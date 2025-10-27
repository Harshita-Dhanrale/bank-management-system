package com.bank.controller;

import com.bank.dto.DepositDTO;
import com.bank.service.DepositService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/deposits")
public class DepositController {

    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    // ✅ Create Deposit
    @PostMapping
    public ResponseEntity<DepositDTO> createDeposit(@Valid @RequestBody DepositDTO depositDTO) {
        return ResponseEntity.ok(depositService.createDeposit(depositDTO));
    }

    // ✅ Get Deposits by Account
    @GetMapping("/account/{accountNo}")
    public ResponseEntity<List<DepositDTO>> getDepositsByAccount(@PathVariable Long accountNo) {
        List<DepositDTO> deposits = depositService.getDepositsByAccount(accountNo);
        return deposits.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(deposits);
    }

    // ✅ Delete Deposit
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeposit(@PathVariable Long id) {
        depositService.deleteDeposit(id);
        return ResponseEntity.noContent().build(); // More standard for deletions
    }
}

