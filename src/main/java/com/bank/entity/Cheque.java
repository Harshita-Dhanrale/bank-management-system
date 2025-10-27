package com.bank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cheques")
public class Cheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long accountNo;

    @Column(nullable = false, unique = true)
    private String chequeNumber;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate issueDate;

    @Column(nullable = false)
    private String status; // Pending, Cleared, Bounced

    // Constructors
    public Cheque() {}

    public Cheque(Long accountNo, String chequeNumber, Double amount, LocalDate issueDate, String status) {
        this.accountNo = accountNo;
        this.chequeNumber = chequeNumber;
        this.amount = amount;
        this.issueDate = issueDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
