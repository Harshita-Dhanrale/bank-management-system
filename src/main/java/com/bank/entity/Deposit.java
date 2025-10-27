package com.bank.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false)
    private Account account;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime depositDate;

    @Column(nullable = false)
    private String depositType;  // e.g., "CASH", "CHECK", "ONLINE"

    @Column(nullable = false)
    private String status; // "PENDING", "SUCCESS", "FAILED"

    // Constructors
    public Deposit() {}

    public Deposit(Long id, Account account, BigDecimal amount, LocalDateTime depositDate, String depositType, String status) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.depositDate = depositDate;
        this.depositType = depositType;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(LocalDateTime depositDate) {
        this.depositDate = depositDate;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString Method
    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", account=" + account +
                ", amount=" + amount +
                ", depositDate=" + depositDate +
                ", depositType='" + depositType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

