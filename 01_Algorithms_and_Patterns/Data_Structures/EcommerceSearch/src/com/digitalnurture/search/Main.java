package com.digitalnurture.search;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Unsorted array for Linear Search
        Product[] unsortedCatalog = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(109, "Gaming Monitor", "Displays"),
            new Product(103, "USB-C Cable", "Accessories")
        };

        // Sorted array for Binary Search
        Product[] sortedCatalog = {
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(103, "USB-C Cable", "Accessories"),
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(109, "Gaming Monitor", "Displays")
        };

        System.out.println("--- Linear Search Execution ---");
        Product foundLinear = SearchAlgorithms.linearSearch(unsortedCatalog, 109);
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        System.out.println("\n--- Binary Search Execution ---");
        Product foundBinary = SearchAlgorithms.binarySearch(sortedCatalog, 105);
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}