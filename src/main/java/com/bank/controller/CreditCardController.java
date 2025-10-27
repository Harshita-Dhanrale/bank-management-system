package com.bank.controller;

import com.bank.dto.CreditCardDTO;
import com.bank.service.CreditCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-cards")
@CrossOrigin(origins = "http://localhost:4200")
public class CreditCardController {
    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public ResponseEntity<CreditCardDTO> createCreditCard(@RequestBody CreditCardDTO creditCardDTO) {
        CreditCardDTO createdCard = creditCardService.createCreditCard(creditCardDTO);
        return ResponseEntity.ok(createdCard);
    }

    @GetMapping
    public ResponseEntity<List<CreditCardDTO>> getAllCreditCards() {
        return ResponseEntity.ok(creditCardService.getAllCreditCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCardDTO> getCreditCardById(@PathVariable Long id) {
        return ResponseEntity.ok(creditCardService.getCreditCardById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCreditCard(@PathVariable Long id) {
        creditCardService.deleteCreditCard(id);
        return ResponseEntity.ok("Credit Card deleted successfully.");
    }
}

