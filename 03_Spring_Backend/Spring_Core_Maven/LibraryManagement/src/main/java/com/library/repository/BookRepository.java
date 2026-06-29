package com.library.repository;

public class BookRepository {
    public void fetchBooks() {
        System.out.println("[REPOSITORY LAYER] Executing Database Query: SELECT * FROM library_books;");
    }
}