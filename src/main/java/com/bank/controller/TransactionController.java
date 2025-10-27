package com.bank.controller;

import com.bank.dto.TransactionDTO;
import com.bank.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:4200") // Allow frontend connection
public class TransactionController {

    private final TransactionService transactionService;

    // ✅ Constructor Injection (Best Practice)
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // ✅ Fetch all transactions
    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    // ✅ Get transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    // ✅ Create a new transaction
    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.ok(transactionService.createTransaction(transactionDTO));
    }

    // ✅ Delete transaction by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Transaction deleted successfully.");
    }
}
