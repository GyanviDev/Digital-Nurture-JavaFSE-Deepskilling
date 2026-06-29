package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        System.out.println("[SPRING IoC] Autowiring BookRepository via Constructor Injection.");
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("[SERVICE LAYER] BookService business logic initiated.");
        bookRepository.fetchBooks(); 
    }
}