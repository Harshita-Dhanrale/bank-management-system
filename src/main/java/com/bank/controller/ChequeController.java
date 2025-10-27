package com.bank.controller;

import com.bank.dto.ChequeDTO;
import com.bank.service.ChequeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cheques")
@CrossOrigin(origins = "http://localhost:4200") // Allow frontend connection
public class ChequeController {

    private final ChequeService chequeService;

    public ChequeController(ChequeService chequeService) {
        this.chequeService = chequeService;
    }

    // Create Cheque
    @PostMapping
    public ResponseEntity<ChequeDTO> createCheque(@RequestBody ChequeDTO chequeDTO) {
        ChequeDTO createdCheque = chequeService.createCheque(chequeDTO);
        return ResponseEntity.ok(createdCheque);
    }

    // Get All Cheques
    @GetMapping
    public ResponseEntity<List<ChequeDTO>> getAllCheques() {
        List<ChequeDTO> cheques = chequeService.getAllCheques();
        return ResponseEntity.ok(cheques);
    }

    // Get Cheque by ID
    @GetMapping("/{id}")
    public ResponseEntity<ChequeDTO> getChequeById(@PathVariable Long id) {
        ChequeDTO cheque = chequeService.getChequeById(id);
        return ResponseEntity.ok(cheque);
    }

    // Delete Cheque
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCheque(@PathVariable Long id) {
        chequeService.deleteCheque(id);
        return ResponseEntity.ok("Cheque deleted successfully");
    }
}

