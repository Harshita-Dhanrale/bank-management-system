package com.bank.dto;

import com.bank.entity.Account.AccountType;
import java.time.LocalDate;

public class AccountDTO {
    private Long accountNo;
    private AccountType accountType;
    private String firstName;
    private String middleName;
    private String lastName;
    private String contactNo;
    private LocalDate dob;
    private String email;
    private String address;
    private Integer creditScore;
    private String documentId;

    // Default Constructor
    public AccountDTO() {
    }

    // Parameterized Constructor
    public AccountDTO(Long accountNo, AccountType accountType, String firstName, String middleName, String lastName,
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

    // Builder Pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long accountNo;
        private AccountType accountType;
        private String firstName;
        private String middleName;
        private String lastName;
        private String contactNo;
        private LocalDate dob;
        private String email;
        private String address;
        private Integer creditScore;
        private String documentId;

        public Builder accountNo(Long accountNo) {
            this.accountNo = accountNo;
            return this;
        }

        public Builder accountType(AccountType accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder contactNo(String contactNo) {
            this.contactNo = contactNo;
            return this;
        }

        public Builder dob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder creditScore(Integer creditScore) {
            this.creditScore = creditScore;
            return this;
        }

        public Builder documentId(String documentId) {
            this.documentId = documentId;
            return this;
        }

        public AccountDTO build() {
            return new AccountDTO(accountNo, accountType, firstName, middleName, lastName, contactNo, dob, email, address, creditScore, documentId);
        }
    }
}

