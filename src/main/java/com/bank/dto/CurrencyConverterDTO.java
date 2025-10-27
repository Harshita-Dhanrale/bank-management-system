package com.bank.dto;

public class CurrencyConverterDTO {
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private double exchangeRate;

    // Constructors
    public CurrencyConverterDTO() {}

    public CurrencyConverterDTO(Long id, String fromCurrency, String toCurrency, double exchangeRate) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.exchangeRate = exchangeRate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
