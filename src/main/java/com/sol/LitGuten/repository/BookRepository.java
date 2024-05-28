package com.sol.LitGuten.repository;

import com.sol.LitGuten.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
//    Optional<Book> findByName(String name);
}
