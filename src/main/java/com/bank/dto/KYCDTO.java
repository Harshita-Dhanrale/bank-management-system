package com.bank.dto;

import java.time.LocalDate;

public class KYCDTO {
    private Long id;
    private String customerId;
    private String fullName;
    private String address;
    private String identificationNumber;
    private String identificationType;
    private LocalDate dateOfBirth;
    private String status;

    public KYCDTO() {
    }

    public KYCDTO(Long id, String customerId, String fullName, String address, String identificationNumber,
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

