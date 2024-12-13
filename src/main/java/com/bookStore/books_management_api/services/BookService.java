package com.bookStore.books_management_api.services;

import com.bookStore.books_management_api.exception.EntityAlreadyExistsException;
import com.bookStore.books_management_api.exception.EntityNotFoundException;
import com.bookStore.books_management_api.model.Book;
import com.bookStore.books_management_api.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        if(bookAlreadyStored(book.getISBN())){
            throw new EntityAlreadyExistsException("Book with ISBN: " + book.getISBN() + " already stored");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, Long id) {
        return bookRepository.findById(id).map(b -> {
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            b.setGenre(book.getGenre());
            b.setPrice(book.getPrice());
            b.setISBN(book.getISBN());
            return bookRepository.save(b);
        }).orElseThrow(() -> new EntityNotFoundException("Book not found to update"));
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        if(!bookRepository.existsById(id)){
            throw new EntityNotFoundException("Book not found to delete");
        }
        bookRepository.deleteById(id);
    }

    private boolean bookAlreadyStored(String isbn) {
        return bookRepository.findByISBN(isbn).isPresent();
    }

}