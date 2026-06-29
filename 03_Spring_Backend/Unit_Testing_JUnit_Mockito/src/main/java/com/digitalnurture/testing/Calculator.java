package com.digitalnurture.testing;

public class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public boolean isPositive(int number) {
        return number > 0;
    }
    
    public String getVersion() {
        return "v1.0.0-Enterprise";
    }
    
    public Object getNullConfiguration() {
        return null; // Simulating a missing configuration object
    }
}