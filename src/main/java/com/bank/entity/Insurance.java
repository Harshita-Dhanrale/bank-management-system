package com.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private String policyType; // Health, Life, Vehicle, etc.

    @Column(nullable = false)
    private Double premiumAmount;

    @Column(nullable = false)
    private String status; // Active, Expired

    // Constructors
    public Insurance() {}

    public Insurance(String policyNumber, Long accountId, String policyType, Double premiumAmount, String status) {
        this.policyNumber = policyNumber;
        this.accountId = accountId;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public Double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

