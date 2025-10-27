package com.bank.dto;

import java.time.LocalDate;

public class DebitCardDTO {
    private Long id;
    private String cardNumber;
    private String cardHolderName;
    private LocalDate expiryDate;
    private Double dailyWithdrawalLimit;
    private Boolean isActive;
    private Long accountId; // Foreign Key reference

    // Default Constructor
    public DebitCardDTO() {}

    // Parameterized Constructor
    public DebitCardDTO(Long id, String cardNumber, String cardHolderName, LocalDate expiryDate,
                        Double dailyWithdrawalLimit, Boolean isActive, Long accountId) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
        this.isActive = isActive;
        this.accountId = accountId;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public Double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Long getAccountId() {
        return accountId;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setDailyWithdrawalLimit(Double dailyWithdrawalLimit) {
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    // toString Method (Optional for debugging)
    @Override
    public String toString() {
        return "DebitCardDTO{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", dailyWithdrawalLimit=" + dailyWithdrawalLimit +
                ", isActive=" + isActive +
                ", accountId=" + accountId +
                '}';
    }
}


