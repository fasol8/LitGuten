package com.sol.LitGuten.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sol.LitGuten.model.GutendexResponse;
import com.sol.LitGuten.model.Author;
import com.sol.LitGuten.model.Book;
import com.sol.LitGuten.repository.AuthorRepository;
import com.sol.LitGuten.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final String API_URL = "http://gutendex.com/books/";
    private final RestTemplate restTemplate;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(RestTemplate restTemplate, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.restTemplate = restTemplate;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public String searchAndSaveBooks(String bookTitle) {
        String apiUrl = API_URL + "?search=" + bookTitle.replace(" ", "+");
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GutendexResponse gutendexResponse = objectMapper.readValue(responseBody, GutendexResponse.class);
            for (Book apiBook : gutendexResponse.getResults()) {
                Book book = new Book();
                book.setId(apiBook.getId());
                book.setTitle(apiBook.getTitle());
                List<Author> authors = new ArrayList<>();
                for (Author author : apiBook.getAuthors()) {
                    Author existingAuthor = authorRepository.findByName(author.getName()).orElse(null);
                    if (existingAuthor == null) {
                        authorRepository.save(author);
                        authors.add(author);
                    } else {
                        authors.add(existingAuthor);
                    }
                }
                book.setAuthors(authors);
                book.setSubjects(apiBook.getSubjects());
                book.setLanguages(apiBook.getLanguages());
                bookRepository.save(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
        return bookRepository.toString();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Map<String, Long> countBooksByLanguage() {
        List<Book> allBooks = bookRepository.findAll();

        Map<String, Long> booksByLanguage = allBooks.stream()
                .collect(Collectors.groupingBy(
                        book -> book.getLanguages().stream().findFirst().orElse("Unknown"),
                        Collectors.counting()
                ));
        return booksByLanguage;
    }
}

