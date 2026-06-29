package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApp {
    public static void main(String[] args) {
        System.out.println("--- Bootstrapping Spring Application Context ---");
        
        // 1. Load the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 2. Retrieve the fully wired bean from the IoC container
        BookService service = context.getBean("bookService", BookService.class);
        
        // 3. Execute the logic to prove the dependencies were injected correctly
        service.manageBooks();
    }
}