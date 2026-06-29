package com.digitalnurture.testing.mockito;

public class ExchangeRateService {
    
    private final ExternalBankApi bankApi;

    // Constructor Injection (Best practice for Spring)
    public ExchangeRateService(ExternalBankApi bankApi) {
        this.bankApi = bankApi;
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Transfer amount cannot be negative");
        }
        
        // This is the external call we need to mock
        double rate = bankApi.getConversionRate(fromCurrency, toCurrency);
        
        // This is the business logic we are actually testing
        return amount * rate;
    }
}