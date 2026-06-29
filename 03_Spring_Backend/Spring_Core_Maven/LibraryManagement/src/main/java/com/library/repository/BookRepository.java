package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void fetchBooks() {
        System.out.println("[REPOSITORY LAYER] Executing Database Query: SELECT * FROM library_books;");
    }
}