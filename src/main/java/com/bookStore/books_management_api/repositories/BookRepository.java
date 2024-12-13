package com.bookStore.books_management_api.repositories;

import com.bookStore.books_management_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByISBN(String ISBN);

}
