package com.bank.controller;

import com.bank.dto.BankBranchDTO;
import com.bank.service.BankBranchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-branches")
@CrossOrigin(origins = "http://localhost:4200") // Allow frontend connection
public class BankBranchController {

    private final BankBranchService bankBranchService;

    public BankBranchController(BankBranchService bankBranchService) {
        this.bankBranchService = bankBranchService;
    }

    // Create Bank Branch
    @PostMapping
    public ResponseEntity<BankBranchDTO> createBankBranch(@RequestBody BankBranchDTO bankBranchDTO) {
        BankBranchDTO createdBankBranch = bankBranchService.createBankBranch(bankBranchDTO);
        return ResponseEntity.ok(createdBankBranch);
    }

    // Get All Bank Branches
    @GetMapping
    public ResponseEntity<List<BankBranchDTO>> getAllBankBranches() {
        List<BankBranchDTO> bankBranches = bankBranchService.getAllBankBranches();
        return ResponseEntity.ok(bankBranches);
    }

    // Get Bank Branch by ID
    @GetMapping("/{id}")
    public ResponseEntity<BankBranchDTO> getBankBranchById(@PathVariable Long id) {
        BankBranchDTO bankBranch = bankBranchService.getBankBranchById(id);
        return ResponseEntity.ok(bankBranch);
    }

    // Delete Bank Branch
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBankBranch(@PathVariable Long id) {
        bankBranchService.deleteBankBranch(id);
        return ResponseEntity.ok("Bank Branch deleted successfully");
    }
}

