package com.bank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "debit_cards")
public class DebitCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;  // Primary Key

    @Column(unique = true, nullable = false, length = 16)
    private String cardNumber; // 16-digit debit card number

    @Column(nullable = false)
    private String cardHolderName;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    private Double dailyWithdrawalLimit;

    @Column(nullable = false)
    private Boolean isActive;

    // Many-to-One relation with Account
    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false) // ✅ Matches DB
    private Account account;


    // Default Constructor
    public DebitCard() {}

    // Parameterized Constructor
    public DebitCard(Long cardId, String cardNumber, String cardHolderName, LocalDate expiryDate,
                     Double dailyWithdrawalLimit, Boolean isActive, Account account) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
        this.isActive = isActive;
        this.account = account;
    }

    // Getters
    public Long getCardId() {
        return cardId;
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

    public Account getAccount() {
        return account;
    }

    // Setters
    public void setCardId(Long cardId) {
        this.cardId = cardId;
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

    public void setAccount(Account account) {
        this.account = account;
    }

    // toString Method (Optional for debugging)
    @Override
    public String toString() {
        return "DebitCard{" +
                "cardId=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", dailyWithdrawalLimit=" + dailyWithdrawalLimit +
                ", isActive=" + isActive +
                ", account=" + account +
                '}';
    }
}

