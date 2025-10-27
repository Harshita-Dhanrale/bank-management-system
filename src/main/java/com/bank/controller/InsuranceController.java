package com.bank.controller;

import com.bank.dto.InsuranceDTO;
import com.bank.service.InsuranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurances")
@CrossOrigin(origins = "http://localhost:4200") // Allow frontend connection
public class InsuranceController {

    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    // Create Insurance
    @PostMapping
    public ResponseEntity<InsuranceDTO> createInsurance(@RequestBody InsuranceDTO insuranceDTO) {
        InsuranceDTO createdInsurance = insuranceService.createInsurance(insuranceDTO);
        return ResponseEntity.ok(createdInsurance);
    }

    // Get All Insurances
    @GetMapping
    public ResponseEntity<List<InsuranceDTO>> getAllInsurances() {
        List<InsuranceDTO> insurances = insuranceService.getAllInsurances();
        return ResponseEntity.ok(insurances);
    }

    // Get Insurance by ID
    @GetMapping("/{id}")
    public ResponseEntity<InsuranceDTO> getInsuranceById(@PathVariable Long id) {
        InsuranceDTO insurance = insuranceService.getInsuranceById(id);
        return ResponseEntity.ok(insurance);
    }

    // Delete Insurance
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteInsurance(id);
        return ResponseEntity.ok("Insurance deleted successfully");
    }
}
