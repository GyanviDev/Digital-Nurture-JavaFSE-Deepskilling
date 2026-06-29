package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;

    // Default no-args constructor is required for Setter Injection
    public BookService() {
    }

    // The Spring IoC container will use this SETTER to inject the dependency
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("[SPRING IoC] Injecting BookRepository via Setter Method.");
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("[SERVICE LAYER] BookService business logic initiated.");
        
        // Safety check to prove the setter actually fired
        if (bookRepository == null) {
            throw new IllegalStateException("Dependency not injected! BookRepository is null.");
        }
        
        bookRepository.fetchBooks(); 
    }
}