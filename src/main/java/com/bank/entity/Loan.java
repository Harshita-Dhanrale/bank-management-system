package com.bank.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_no", referencedColumnName = "accountNo", nullable = false)
    private Account account;

    @Column(nullable = false)
    private BigDecimal loanAmount;

    @Column(nullable = false)
    private BigDecimal interestRate;

    @Column(nullable = false)
    private int tenureInMonths;

    @Column(nullable = false)
    private String loanType; // e.g., Home Loan, Personal Loan

    @Column(nullable = false)
    private LocalDate approvalDate;

    @Column(nullable = false)
    private String status; // e.g., Approved, Pending, Rejected

    // Constructors
    public Loan() {}

    public Loan(Long id, Account account, BigDecimal loanAmount, BigDecimal interestRate, int tenureInMonths, 
                String loanType, LocalDate approvalDate, String status) {
        this.id = id;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public void setTenureInMonths(long l) {
        this.tenureInMonths = (int) l;
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

	public void setLoanStatus(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setEndDate(LocalDate plusYears) {
		// TODO Auto-generated method stub
		
	}

	public void setStartDate(LocalDate now) {
		// TODO Auto-generated method stub
		
	}

	public Object getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getLoanStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLoanStatus(Object string) {
		// TODO Auto-generated method stub
		
	}
}

