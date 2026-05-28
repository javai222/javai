package com.tismo.app.service;

import com.tismo.app.entity.Book;
import com.tismo.app.exception.BookNotFoundException;
import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void deleteBook(Long id);
}



