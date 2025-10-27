package com.bank.dto;

import java.time.LocalDate;

public class ChequeDTO {
    private Long id;
    private Long accountNo;
    private String chequeNumber;
    private Double amount;
    private LocalDate issueDate;
    private String status;

    // Constructors
    public ChequeDTO() {}

    public ChequeDTO(Long id, Long accountNo, String chequeNumber, Double amount, LocalDate issueDate, String status) {
        this.id = id;
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

