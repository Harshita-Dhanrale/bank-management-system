package com.bank.controller;

import com.bank.dto.AccountDTO;
import com.bank.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        logger.info("Creating new account for: {}", accountDTO.getFirstName());
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(accountDTO));
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        logger.info("Fetching all accounts.");
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        logger.info("Fetching account with ID: {}", id);
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // No need for a body response
    public void deleteAccount(@PathVariable Long id) {
        logger.warn("Deleting account with ID: {}", id);
        accountService.deleteAccount(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO) {
        logger.info("Updating account with ID: {}", id);
        return ResponseEntity.ok(accountService.updateAccount(id, accountDTO));
    }
}
