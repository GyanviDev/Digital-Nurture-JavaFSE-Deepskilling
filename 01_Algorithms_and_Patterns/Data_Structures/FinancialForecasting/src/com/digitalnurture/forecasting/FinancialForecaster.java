package com.digitalnurture.forecasting;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecaster {

    // Cache for Memoization optimization
    private Map<Integer, Double> memoizationCache = new HashMap<>();

    // 1. Standard Recursive Approach
    public double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        // Base Case: If no periods left, return the current value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive Case: Calculate for one period less, then apply growth
        return (1 + growthRate) * calculateFutureValueRecursive(presentValue, growthRate, periods - 1);
    }

    // 2. Optimized Recursive Approach (Memoization)
    public double calculateFutureValueMemoized(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        
        // Check if we have already calculated this specific period
        if (memoizationCache.containsKey(periods)) {
            return memoizationCache.get(periods);
        }

        // If not calculated, perform the recursive calculation
        double result = (1 + growthRate) * calculateFutureValueMemoized(presentValue, growthRate, periods - 1);
        
        // Store the result in the cache before returning
        memoizationCache.put(periods, result);
        return result;
    }
}