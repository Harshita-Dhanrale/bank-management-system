package com.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lockers")
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String lockerNumber;

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private String size; // Small, Medium, Large

    @Column(nullable = false)
    private Double rentAmount;

    @Column(nullable = false)
    private String status; // Available, Occupied

    // Constructors
    public Locker() {}

    public Locker(String lockerNumber, Long accountId, String size, Double rentAmount, String status) {
        this.lockerNumber = lockerNumber;
        this.accountId = accountId;
        this.size = size;
        this.rentAmount = rentAmount;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    public void setLockerNumber(String lockerNumber) {
        this.lockerNumber = lockerNumber;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

