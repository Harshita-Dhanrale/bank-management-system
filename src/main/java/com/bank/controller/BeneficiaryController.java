package com.bank.controller;

import com.bank.dto.BeneficiaryDTO;
import com.bank.service.BeneficiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
@CrossOrigin(origins = "http://localhost:4200") // Allow frontend connection
public class BeneficiaryController {

    private final BeneficiaryService beneficiaryService;

    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    // Create Beneficiary
    @PostMapping
    public ResponseEntity<BeneficiaryDTO> createBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO) {
        BeneficiaryDTO createdBeneficiary = beneficiaryService.createBeneficiary(beneficiaryDTO);
        return ResponseEntity.ok(createdBeneficiary);
    }

    // Get All Beneficiaries
    @GetMapping
    public ResponseEntity<List<BeneficiaryDTO>> getAllBeneficiaries() {
        List<BeneficiaryDTO> beneficiaries = beneficiaryService.getAllBeneficiaries();
        return ResponseEntity.ok(beneficiaries);
    }

    // Get Beneficiary by ID
    @GetMapping("/{id}")
    public ResponseEntity<BeneficiaryDTO> getBeneficiaryById(@PathVariable Long id) {
        BeneficiaryDTO beneficiary = beneficiaryService.getBeneficiaryById(id);
        return ResponseEntity.ok(beneficiary);
    }

    // Delete Beneficiary
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBeneficiary(@PathVariable Long id) {
        beneficiaryService.deleteBeneficiary(id);
        return ResponseEntity.ok("Beneficiary deleted successfully");
    }
}
