package com.digitalnurture.search;

public class SearchAlgorithms {

    // Linear Search: O(n) Time Complexity
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product; // Best case: O(1) if found on first try
            }
        }
        return null; // Worst case: O(n) if not found or at the very end
    }

    // Binary Search: O(log n) Time Complexity (Requires sorted array)
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return products[mid]; // Best case: O(1) if found exactly at the middle
            }
            if (midId < targetId) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return null; // Worst case: O(log n)
    }
}