package com.sol.LitGuten.principal;

import com.sol.LitGuten.model.Author;
import com.sol.LitGuten.model.Book;
import com.sol.LitGuten.service.AuthorService;
import com.sol.LitGuten.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Main {

    private Scanner scanner = new Scanner(System.in);
    private BookService bookService;
    private AuthorService authorService;

    @Autowired
    public void MyService(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public void showMenu() {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                                        
                    1 - Buscar Libro
                    2 - Mostrar Libros
                    3 - Mostrar Autores
                    4 - Autores nacidos en un anio
                    5 - libros por idioma
                                       
                    0 - Salir
                     """;
            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    showBooks();
                    break;
                case 3:
                    showAuthor();
                    break;
                case 4:
                    showAuthorBorn();
                    break;
                case 5:
                    showLanguageBooks();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida");
            }
        }
    }


    private void searchBook() {
        System.out.println("Ingrese el nombre del libro:");
        String bookTitle = scanner.nextLine();

        String jsonResponse = bookService.searchAndSaveBooks(bookTitle);
        System.out.println("Se agrego Exitosamente -> " + jsonResponse);
    }

    private void showBooks() {
        printBooks(bookService.getAllBooks());
    }

    private void showAuthor() {
        printAuthors(authorService.getAllAuthors());
    }

    private void showAuthorBorn() {
        System.out.println("Ingrese el año: ");
        Integer yearAuthor = scanner.nextInt();

        System.out.println("Son " + authorService.countAuthorsBornAfterYear(yearAuthor) + " autores nacidos despues del año " + yearAuthor);
        printAuthors(authorService.getAuthorsBornAfterYear(yearAuthor));
    }

    private void showLanguageBooks() {
        System.out.println("\n" + bookService.countBooksByLanguage());
    }

    public static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println("\nTitulo: " + book.getTitle());
            System.out.print("Autor: ");
            printAuthorsForBook(book.getAuthors());
            System.out.println();
        }
    }

    private static void printAuthorsForBook(List<Author> authors) {
        for (int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            System.out.print(author.getName());
            if (i < authors.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void printAuthors(List<Author> authors) {
        for (Author author : authors) {
            System.out.println("Nombre: " + author.getName());
            System.out.println("Año de nacimiento: " + author.getBirthYear());
            System.out.println("Año de muerte: " + author.getDeathYear());
            System.out.println();
        }
    }
}
