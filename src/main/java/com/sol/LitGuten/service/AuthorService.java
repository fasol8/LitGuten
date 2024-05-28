package com.sol.LitGuten.service;

import com.sol.LitGuten.model.Author;
import com.sol.LitGuten.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public long countAuthorsBornAfterYear(int year) {
        List<Author> allAuthors = authorRepository.findAll();

        long count = allAuthors.stream()
                .filter(author -> author.getBirthYear() >= year)
                .count();
        return count;
    }

    public List<Author> getAuthorsBornAfterYear(int year) {
        List<Author> allAuthors = authorRepository.findAll();

        List<Author> filteredAuthors = allAuthors.stream()
                .filter(author -> author.getBirthYear() >= year)
                .collect(Collectors.toList());
        return filteredAuthors;
    }
}
