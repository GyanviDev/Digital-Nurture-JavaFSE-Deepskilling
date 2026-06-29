package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private final BookRepository bookRepository;

    // The Spring IoC container will automatically inject the repository here
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("[SERVICE LAYER] BookService business logic initiated.");
        // Delegating data access to the injected repository
        bookRepository.fetchBooks(); 
    }
}