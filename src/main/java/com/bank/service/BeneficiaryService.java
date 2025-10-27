package com.bank.service;

import com.bank.dto.BeneficiaryDTO;
import com.bank.entity.Beneficiary;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.BeneficiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiaryService {

    private final BeneficiaryRepository beneficiaryRepository;

    public BeneficiaryService(BeneficiaryRepository beneficiaryRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
    }

    // Create Beneficiary
    public BeneficiaryDTO createBeneficiary(BeneficiaryDTO beneficiaryDTO) {
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setAccountNo(beneficiaryDTO.getAccountNo());
        beneficiary.setBeneficiaryName(beneficiaryDTO.getBeneficiaryName());
        beneficiary.setBeneficiaryAccountNo(beneficiaryDTO.getBeneficiaryAccountNo());
        beneficiary.setBankName(beneficiaryDTO.getBankName());
        beneficiary.setIfscCode(beneficiaryDTO.getIfscCode());

        Beneficiary savedBeneficiary = beneficiaryRepository.save(beneficiary);
        return convertToDTO(savedBeneficiary);
    }

    // Get All Beneficiaries
    public List<BeneficiaryDTO> getAllBeneficiaries() {
        return beneficiaryRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Beneficiary by ID
    public BeneficiaryDTO getBeneficiaryById(Long id) {
        Beneficiary beneficiary = beneficiaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Beneficiary not found with id: " + id));
        return convertToDTO(beneficiary);
    }

    // Delete Beneficiary
    public void deleteBeneficiary(Long id) {
        Beneficiary beneficiary = beneficiaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Beneficiary not found with id: " + id));
        beneficiaryRepository.delete(beneficiary);
    }

    // Convert Entity to DTO
    private BeneficiaryDTO convertToDTO(Beneficiary beneficiary) {
        BeneficiaryDTO dto = new BeneficiaryDTO();
        dto.setId(beneficiary.getId());
        dto.setAccountNo(beneficiary.getAccountNo());
        dto.setBeneficiaryName(beneficiary.getBeneficiaryName());
        dto.setBeneficiaryAccountNo(beneficiary.getBeneficiaryAccountNo());
        dto.setBankName(beneficiary.getBankName());
        dto.setIfscCode(beneficiary.getIfscCode());
        beneficiary.setStatus(beneficiary.getStatus());
        return dto;
    }
}

