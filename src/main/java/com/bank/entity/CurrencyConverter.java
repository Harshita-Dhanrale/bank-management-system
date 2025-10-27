package com.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency_converter")
public class CurrencyConverter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromCurrency;

    @Column(nullable = false)
    private String toCurrency;

    @Column(nullable = false)
    private double exchangeRate;

    // Constructors
    public CurrencyConverter() {}

    public CurrencyConverter(String fromCurrency, String toCurrency, double exchangeRate) {
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

