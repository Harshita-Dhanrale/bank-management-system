package com.bank.service;

import com.bank.dto.LoanDTO;
import com.bank.entity.Account;
import com.bank.entity.Loan;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final AccountRepository accountRepository;

    public LoanService(LoanRepository loanRepository, AccountRepository accountRepository) {
        this.loanRepository = loanRepository;
        this.accountRepository = accountRepository;
    }

    public LoanDTO applyForLoan(LoanDTO loanDTO) {
        Account account = accountRepository.findById(loanDTO.getAccountNo())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        Loan loan = new Loan();
        loan.setAccount(account);
        loan.setLoanAmount(loanDTO.getLoanAmount());
        loan.setInterestRate(loanDTO.getInterestRate());
        loan.setLoanType(loanDTO.getLoanType());

        loan.setStatus("Pending"); // ✅ Correct field
        loan.setApprovalDate(LocalDate.now()); // ✅ Set current date as approval
        loan.setTenureInMonths(loanDTO.getDurationYears() * 12); // ✅ Convert years to months

        loan.setStartDate(LocalDate.now());
        loan.setEndDate(LocalDate.now().plusYears(loanDTO.getDurationYears()));

        Loan savedLoan = loanRepository.save(loan);
        return convertToDTO(savedLoan);
    }

    public List<LoanDTO> getLoansByAccount(Long accountNo) {
        List<Loan> loans = loanRepository.findByAccount_AccountNo(accountNo);
        return loans.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void deleteLoan(Long id) {
        loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        loanRepository.deleteById(id);
    }

    private LoanDTO convertToDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setAccountNo(loan.getAccount().getAccountNo());
        dto.setLoanAmount(loan.getLoanAmount());
        dto.setInterestRate(loan.getInterestRate());
        dto.setLoanType(loan.getLoanType());
        dto.setLoanStatus(loan.getStatus()); // ✅ Correct field
        dto.setStartDate(loan.getStartDate());
        dto.setEndDate(loan.getEndDate());
        dto.setDurationYears(loan.getTenureInMonths() / 12); // ✅ Reverse conversion

        return dto;
    }
}
