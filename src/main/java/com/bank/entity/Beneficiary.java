package com.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiaries")
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long accountNo;

    @Column(nullable = false)
    private String beneficiaryName;

    @Column(nullable = false, unique = true)
    private String beneficiaryAccountNo;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String ifscCode;

    @Column(nullable = false)
    private String status; // "Active", "Inactive", "Pending"

    // Constructors
    public Beneficiary() {
    }

    public Beneficiary(Long id, Long accountNo, String beneficiaryName, String beneficiaryAccountNo, String bankName, String ifscCode, String status) {
        this.id = id;
        this.accountNo = accountNo;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryAccountNo = beneficiaryAccountNo;
        this.bankName = bankName;
        this.ifscCode = ifscCode;
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

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryAccountNo() {
        return beneficiaryAccountNo;
    }

    public void setBeneficiaryAccountNo(String beneficiaryAccountNo) {
        this.beneficiaryAccountNo = beneficiaryAccountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

