package com.bank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kyc")
public class KYC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String customerId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String identificationNumber; // e.g., Aadhar, Passport, PAN

    @Column(nullable = false)
    private String identificationType; // e.g., "Aadhar", "PAN", "Passport"

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String status; // e.g., "Pending", "Verified", "Rejected"

    public KYC() {
    }

    public KYC(Long id, String customerId, String fullName, String address, String identificationNumber, 
               String identificationType, LocalDate dateOfBirth, String status) {
        this.id = id;
        this.customerId = customerId;
        this.fullName = fullName;
        this.address = address;
        this.identificationNumber = identificationNumber;
        this.identificationType = identificationType;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getIdentificationNumber() { return identificationNumber; }
    public void setIdentificationNumber(String identificationNumber) { this.identificationNumber = identificationNumber; }

    public String getIdentificationType() { return identificationType; }
    public void setIdentificationType(String identificationType) { this.identificationType = identificationType; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

