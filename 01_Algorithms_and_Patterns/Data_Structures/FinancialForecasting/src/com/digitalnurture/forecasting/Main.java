package com.digitalnurture.forecasting;

public class Main {
    public static void main(String[] args) {
        FinancialForecaster forecaster = new FinancialForecaster();
        
        double presentValue = 50000.0;
        double growthRate = 0.08; // 8% growth
        int periods = 15;         // 15 years

        System.out.println("--- Digital Nurture Financial Forecaster ---");
        
        // Standard Recursion
        double standardResult = forecaster.calculateFutureValueRecursive(presentValue, growthRate, periods);
        System.out.printf("Future Value (Standard Recursion): $%,.2f\n", standardResult);

        // Optimized Recursion (Memoization)
        double optimizedResult = forecaster.calculateFutureValueMemoized(presentValue, growthRate, periods);
        System.out.printf("Future Value (Memoized Recursion): $%,.2f\n", optimizedResult);
    }
}