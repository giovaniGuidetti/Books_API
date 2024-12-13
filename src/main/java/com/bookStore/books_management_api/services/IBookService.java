package com.bookStore.books_management_api.services;


import com.bookStore.books_management_api.model.Book;

import java.util.List;

public interface IBookService {

    public Book addBook(Book book);

    public Book updateBook(Book book, Long id);

    public Book getBookById(Long id);

    public List<Book> getAllBooks();

    public void deleteBook(Long id);

}
