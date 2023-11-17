package com.ismail.bookstore.service;

import com.ismail.bookstore.model.Book;
import com.ismail.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(Integer bookId){
        return bookRepository.findById(bookId).orElse(null);

    }
    public boolean isBookExists(Integer bookId) {
        return bookRepository.existsById(bookId);
    }
}
