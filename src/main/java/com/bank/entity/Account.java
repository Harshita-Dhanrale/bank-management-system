package com.bank.entity;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ensure JPA manages ID
    private Long accountNo; // Unique Account Number

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false, length = 10)
    private String contactNo;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    private Integer creditScore;

    @Column(nullable = false)
    private String documentId;

    @PrePersist
    public void generateAccountNo() {
        if (this.accountNo == null) {
            this.accountNo = ThreadLocalRandom.current().nextLong(1000000000L, 9999999999L); // 10-digit number
        }
        this.creditScore = (this.accountType == AccountType.SAVINGS) ? 700 : 600;
    }

    public enum AccountType {
        SAVINGS, CURRENT, CHECKING
    }

    // Default constructor
    public Account() {
    }

    // Parameterized constructor
    public Account(Long accountNo, AccountType accountType, String firstName, String middleName, String lastName,
                   String contactNo, LocalDate dob, String email, String address, Integer creditScore, String documentId) {
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.creditScore = creditScore;
        this.documentId = documentId;
    }

    // Getters and Setters
    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", accountType=" + accountType +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", creditScore=" + creditScore +
                ", documentId='" + documentId + '\'' +
                '}';
    }

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}


