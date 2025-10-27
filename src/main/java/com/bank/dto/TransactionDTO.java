package com.bank.dto;

import java.time.LocalDateTime;

public class TransactionDTO {
    private Long id;
    private String transactionType;
    private Double amount;
    private LocalDateTime transactionDate;
    private Long accountId; // Reference to Account ID
    private String status;

    // ✅ Default Constructor
    public TransactionDTO() {}

    // ✅ Parameterized Constructor
    public TransactionDTO(Long id, String transactionType, Double amount, LocalDateTime transactionDate, Long accountId, String status) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountId = accountId;
        this.status = status;
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

