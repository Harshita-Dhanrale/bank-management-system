package com.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DepositDTO {
    private Long id;
    private Long accountNo;
    private BigDecimal amount;
    private LocalDateTime depositDate;
    private String depositType;
    private String status;

    // Default Constructor
    public DepositDTO() {}

    // Parameterized Constructor
    public DepositDTO(Long id, Long accountNo, BigDecimal amount, LocalDateTime depositDate, String depositType, String status) {
        this.id = id;
        this.accountNo = accountNo;
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

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
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
        return "DepositDTO{" +
                "id=" + id +
                ", accountNo=" + accountNo +
                ", amount=" + amount +
                ", depositDate=" + depositDate +
                ", depositType='" + depositType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

