package com.bank.controller;

import com.bank.dto.LockerDTO;
import com.bank.service.LockerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lockers")
@CrossOrigin(origins = "http://localhost:4200") // Allow frontend connection
public class LockerController {

    private final LockerService lockerService;

    public LockerController(LockerService lockerService) {
        this.lockerService = lockerService;
    }

    // Create Locker
    @PostMapping
    public ResponseEntity<LockerDTO> createLocker(@RequestBody LockerDTO lockerDTO) {
        LockerDTO createdLocker = lockerService.createLocker(lockerDTO);
        return ResponseEntity.ok(createdLocker);
    }

    // Get All Lockers
    @GetMapping
    public ResponseEntity<List<LockerDTO>> getAllLockers() {
        List<LockerDTO> lockers = lockerService.getAllLockers();
        return ResponseEntity.ok(lockers);
    }

    // Get Locker by ID
    @GetMapping("/{id}")
    public ResponseEntity<LockerDTO> getLockerById(@PathVariable Long id) {
        LockerDTO locker = lockerService.getLockerById(id);
        return ResponseEntity.ok(locker);
    }

    // Delete Locker
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocker(@PathVariable Long id) {
        lockerService.deleteLocker(id);
        return ResponseEntity.ok("Locker deleted successfully");
    }
}

