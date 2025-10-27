package com.bank.controller;

import com.bank.dto.LoanDTO;
import com.bank.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin(origins = "http://localhost:4200") // Allow frontend connection
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<LoanDTO> applyForLoan(@RequestBody LoanDTO loanDTO) {
        LoanDTO createdLoan = loanService.applyForLoan(loanDTO);
        return ResponseEntity.ok(createdLoan);
    }

    @GetMapping("/account/{accountNo}")
    public ResponseEntity<List<LoanDTO>> getLoansByAccount(@PathVariable Long accountNo) {
        List<LoanDTO> loans = loanService.getLoansByAccount(accountNo);
        return ResponseEntity.ok(loans);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.ok("Loan deleted successfully");
    }
}

