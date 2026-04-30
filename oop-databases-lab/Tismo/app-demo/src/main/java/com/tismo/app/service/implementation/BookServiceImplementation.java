package com.tismo.app.service.implementation;

import com.tismo.app.entity.Book;
import com.tismo.app.exception.BookNotFoundException;
import com.tismo.app.repository.BookRepository;
import com.tismo.app.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}