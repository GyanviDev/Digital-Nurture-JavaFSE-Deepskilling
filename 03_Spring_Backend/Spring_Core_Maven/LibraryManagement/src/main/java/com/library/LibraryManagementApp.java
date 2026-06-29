package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApp {
    public static void main(String[] args) {
        System.out.println("--- Bootstrapping Modern Spring Annotation Context ---");
        
        // 1. Load the Java-based configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // 2. Retrieve the dynamically wired bean
        BookService service = context.getBean(BookService.class);
        
        // 3. Execute the logic
        service.manageBooks();
    }
}