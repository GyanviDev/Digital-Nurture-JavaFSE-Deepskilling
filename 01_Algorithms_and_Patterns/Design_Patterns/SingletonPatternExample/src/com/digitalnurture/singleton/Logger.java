package com.digitalnurture.singleton;

import java.io.Serializable;

public class Logger implements Serializable {

    // volatile keyword guarantees memory visibility across threads
    private static volatile Logger instance;

    // Private constructor prevents instantiation from outside
    private Logger() {
        if (instance != null) {
            throw new IllegalStateException("Instance already exists! Use getInstance() method.");
        }
    }

    // Double-Checked Locking for high-performance thread safety
    public static Logger getInstance() {
        if (instance == null) { 
            synchronized (Logger.class) { 
                if (instance == null) { 
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + System.currentTimeMillis() + ": " + message);
    }
    
    // Defense against Serialization breaking the Singleton
    protected Object readResolve() {
        return getInstance();
    }
}