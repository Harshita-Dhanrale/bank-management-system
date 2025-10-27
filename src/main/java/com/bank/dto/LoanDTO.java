package com.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDTO {

    private Long id;
    private Long accountNo;
    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private int tenureInMonths;
    private String loanType;
    private LocalDate approvalDate;
    private String status;

    // Constructors
    public LoanDTO() {}

    public LoanDTO(Long id, Long accountNo, BigDecimal loanAmount, BigDecimal interestRate, int tenureInMonths, String loanType, LocalDate approvalDate, String status) {
        this.id = id;
        this.accountNo = accountNo;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.tenureInMonths = tenureInMonths;
        this.loanType = loanType;
        this.approvalDate = approvalDate;
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

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public int getTenureInMonths() {
        return tenureInMonths;
    }

    public void setTenureInMonths(int tenureInMonths) {
        this.tenureInMonths = tenureInMonths;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public long getDurationYears() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLoanStatus(Object loanStatus) {
		// TODO Auto-generated method stub
		
	}

	public void setStartDate(Object startDate) {
		// TODO Auto-generated method stub
		
	}

	public void setEndDate(Object endDate) {
		// TODO Auto-generated method stub
		
	}

	public void setDurationYears(int i) {
		// TODO Auto-generated method stub
		
	}


		
	}


