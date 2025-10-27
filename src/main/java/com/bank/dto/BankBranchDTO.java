package com.bank.dto;

public class BankBranchDTO {
    private Long id;
    private String branchCode;
    private String branchName;
    private String address;
    private String city;
    private String state;
    private String contactNumber;

    // Constructors
    public BankBranchDTO() {}

    public BankBranchDTO(Long id, String branchCode, String branchName, String address, String city, String state, String contactNumber) {
        this.id = id;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}

