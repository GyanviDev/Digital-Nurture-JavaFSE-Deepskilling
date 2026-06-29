package com.library.service;

import com.library.repository.BookRepository;
import com.library.config.LibraryConfig;

public class BookService {
    
    private final BookRepository bookRepository; // Mandatory
    private LibraryConfig libraryConfig;         // Optional

    // Constructor Injection (For Mandatory dependency)
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter Injection (For Optional dependency)
    public void setLibraryConfig(LibraryConfig libraryConfig) {
        this.libraryConfig = libraryConfig;
    }

    public void manageBooks() {
        System.out.println("[SERVICE LAYER] BookService initiated.");
        bookRepository.fetchBooks();
        if (libraryConfig != null) {
            libraryConfig.getConfiguration();
        }
    }
}