package com.digitalnurture.singleton;

public class LoggerTest {
    public static void main(String[] args) {
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both variables point to the exact same Logger instance.");
        } else {
            System.out.println("FAILURE: Multiple instances were created.");
        }

        logger1.log("Application started.");
        logger2.log("Database connection established.");
        
        System.out.println("Hashcode of logger1: " + logger1.hashCode());
        System.out.println("Hashcode of logger2: " + logger2.hashCode());
    }
}