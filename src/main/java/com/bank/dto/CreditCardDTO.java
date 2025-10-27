package com.bank.dto;

import java.time.LocalDate;

public class CreditCardDTO {
    private Long id;
    private String cardNumber;
    private String cardHolderName;
    private LocalDate expiryDate;
    private String cvv; // Changed to String
    private Double creditLimit;
    private Double currentBalance;
    private Double interestRate;
    private Boolean isActive;
    private Long accountId;

    public CreditCardDTO() {}

    public CreditCardDTO(Long id, String cardNumber, String cardHolderName, LocalDate expiryDate,
                         String cvv, Double creditLimit, Double currentBalance,
                         Double interestRate, Boolean isActive, Long accountId) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        this.isActive = isActive;
        this.accountId = accountId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCardHolderName() { return cardHolderName; }
    public void setCardHolderName(String cardHolderName) { this.cardHolderName = cardHolderName; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public Double getCreditLimit() { return creditLimit; }
    public void setCreditLimit(Double creditLimit) { this.creditLimit = creditLimit; }

    public Double getCurrentBalance() { return currentBalance; }
    public void setCurrentBalance(Double currentBalance) { this.currentBalance = currentBalance; }

    public Double getInterestRate() { return interestRate; }
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
}
