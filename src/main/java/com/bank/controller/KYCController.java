package com.bank.controller;

import com.bank.dto.KYCDTO;
import com.bank.service.KYCService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kyc")
@CrossOrigin(origins = "http://localhost:4200") // Allow frontend access
public class KYCController {

    private final KYCService kycService;

    public KYCController(KYCService kycService) {
        this.kycService = kycService;
    }

    /**
     * Retrieves all KYC records.
     *
     * @return a list of KYCDTOs
     */
    @GetMapping
    public ResponseEntity<List<KYCDTO>> getAllKYCRecords() {
        List<KYCDTO> kycRecords = kycService.getAllKYCRecords();
        return ResponseEntity.ok(kycRecords);
    }

    /**
     * Retrieves a KYC record by ID.
     *
     * @param id the KYC record ID
     * @return the corresponding KYCDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<KYCDTO> getKYCById(@PathVariable Long id) {
        KYCDTO kycDTO = kycService.getKYCById(id);
        return ResponseEntity.ok(kycDTO);
    }

    /**
     * Creates a new KYC record.
     *
     * @param kycDTO the KYC data
     * @return the created KYCDTO
     */
    @PostMapping
    public ResponseEntity<KYCDTO> createKYC(@RequestBody KYCDTO kycDTO) {
        KYCDTO createdKYC = kycService.createKYC(kycDTO);
        return ResponseEntity.ok(createdKYC);
    }

    /**
     * Updates an existing KYC record.
     *
     * @param id     the ID of the KYC record
     * @param kycDTO the updated KYC data
     * @return the updated KYCDTO
     */
    @PutMapping("/{id}")
    public ResponseEntity<KYCDTO> updateKYC(@PathVariable Long id, @RequestBody KYCDTO kycDTO) {
        KYCDTO updatedKYC = kycService.updateKYC(id, kycDTO);
        return ResponseEntity.ok(updatedKYC);
    }

    /**
     * Deletes a KYC record by ID.
     *
     * @param id the KYC record ID
     * @return a success message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKYC(@PathVariable Long id) {
        kycService.deleteKYC(id);
        return ResponseEntity.ok("KYC record deleted successfully.");
    }
}

