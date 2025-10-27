package com.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_branch")
public class BankBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "branch_code", nullable = false, unique = true)  // Change here
    private String branchCode;

    @Column(name = "branch_name", nullable = false)
    private String branchName;


    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(name = "contactNumber", nullable = false)
    private String contactNumber;


    // Constructors
    public BankBranch() {}

    public BankBranch(String branchCode, String branchName, String address, String city, String state, String contactNumber) {
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
