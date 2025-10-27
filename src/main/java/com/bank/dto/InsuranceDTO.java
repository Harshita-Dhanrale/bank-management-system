package com.bank.dto;

public class InsuranceDTO {
    private Long id;
    private String policyNumber;
    private Long accountId;
    private String policyType;
    private Double premiumAmount;
    private String status;

    // Constructors
    public InsuranceDTO() {}

    public InsuranceDTO(Long id, String policyNumber, Long accountId, String policyType, Double premiumAmount, String status) {
        this.id = id;
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

