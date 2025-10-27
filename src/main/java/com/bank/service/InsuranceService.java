package com.bank.service;

import com.bank.dto.InsuranceDTO;
import com.bank.entity.Insurance;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    // Create Insurance
    public InsuranceDTO createInsurance(InsuranceDTO insuranceDTO) {
        Insurance insurance = new Insurance();
        insurance.setPolicyNumber(insuranceDTO.getPolicyNumber());
        insurance.setAccountId(insuranceDTO.getAccountId());
        insurance.setPolicyType(insuranceDTO.getPolicyType());
        insurance.setPremiumAmount(insuranceDTO.getPremiumAmount());
        insurance.setStatus("Active");

        Insurance savedInsurance = insuranceRepository.save(insurance);
        return convertToDTO(savedInsurance);
    }

    // Get All Insurances
    public List<InsuranceDTO> getAllInsurances() {
        return insuranceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Insurance by ID
    public InsuranceDTO getInsuranceById(Long id) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insurance not found with id: " + id));
        return convertToDTO(insurance);
    }

    // Delete Insurance
    public void deleteInsurance(Long id) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insurance not found with id: " + id));
        insuranceRepository.delete(insurance);
    }

    // Convert Entity to DTO
    private InsuranceDTO convertToDTO(Insurance insurance) {
        return new InsuranceDTO(
                insurance.getId(),
                insurance.getPolicyNumber(),
                insurance.getAccountId(),
                insurance.getPolicyType(),
                insurance.getPremiumAmount(),
                insurance.getStatus()
        );
    }
}

