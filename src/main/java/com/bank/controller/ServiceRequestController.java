package com.bank.controller;

import com.bank.dto.ServiceRequestDTO;
import com.bank.service.ServiceRequestService;

import jakarta.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/service-requests")
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;

    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }
    @PostConstruct
    public void init() {
        System.out.println("✅ ServiceRequestController loaded!");
    }

    @PostMapping
    public ResponseEntity<ServiceRequestDTO> createRequest(@RequestBody ServiceRequestDTO dto) {
        return ResponseEntity.ok(serviceRequestService.createRequest(dto));
    }

    @GetMapping("/account/{accountNo}")
    public ResponseEntity<List<ServiceRequestDTO>> getRequestsByAccount(@PathVariable Long accountNo) {
        return ResponseEntity.ok(serviceRequestService.getRequestsByAccount(accountNo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        serviceRequestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}

