package com.bank.controller;

import com.bank.dto.DebitCardDTO;
import com.bank.service.DebitCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/debit-cards")
@CrossOrigin(origins = "http://localhost:4200") // Enable CORS for Angular frontend
public class DebitCardController {

    private final DebitCardService debitCardService;

    public DebitCardController(DebitCardService debitCardService) {
        this.debitCardService = debitCardService;
    }

    // ✅ Create a new Debit Card
    @PostMapping
    public ResponseEntity<DebitCardDTO> createDebitCard(@RequestBody DebitCardDTO debitCardDTO) {
        DebitCardDTO createdCard = debitCardService.createDebitCard(debitCardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCard);
    }

    // ✅ Get all Debit Cards
    @GetMapping
    public ResponseEntity<List<DebitCardDTO>> getAllDebitCards() {
        List<DebitCardDTO> debitCards = debitCardService.getAllDebitCards();
        return ResponseEntity.ok(debitCards);
    }

    // ✅ Get Debit Card by ID
    @GetMapping("/{id}")
    public ResponseEntity<DebitCardDTO> getDebitCardById(@PathVariable Long id) {
        DebitCardDTO debitCard = debitCardService.getDebitCardById(id);
        return ResponseEntity.ok(debitCard);
    }

    // ✅ Delete Debit Card
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDebitCard(@PathVariable Long id) {
        debitCardService.deleteDebitCard(id);
        return ResponseEntity.ok("Debit Card deleted successfully");
    }
}

