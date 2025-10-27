package com.bank.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String transactionType; // e.g., "Deposit", "Withdrawal", "Transfer"

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account; // Assuming Account entity exists

    @Column(nullable = false)
    private String status; // e.g., "Completed", "Pending", "Failed"

    // ✅ Default Constructor
    public Transaction() {}

    // ✅ Parameterized Constructor
    public Transaction(String transactionType, Double amount, LocalDateTime transactionDate, Account account, String status) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
