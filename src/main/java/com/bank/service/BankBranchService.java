package com.bank.service;

import com.bank.dto.BankBranchDTO;
import com.bank.entity.BankBranch;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.BankBranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankBranchService {

    private final BankBranchRepository bankBranchRepository;

    public BankBranchService(BankBranchRepository bankBranchRepository) {
        this.bankBranchRepository = bankBranchRepository;
    }

    // Create Bank Branch
    public BankBranchDTO createBankBranch(BankBranchDTO bankBranchDTO) {
        BankBranch bankBranch = new BankBranch();
        bankBranch.setBranchCode(bankBranchDTO.getBranchCode());
        bankBranch.setBranchName(bankBranchDTO.getBranchName());
        bankBranch.setAddress(bankBranchDTO.getAddress());
        bankBranch.setCity(bankBranchDTO.getCity());
        bankBranch.setState(bankBranchDTO.getState());
        bankBranch.setContactNumber(bankBranchDTO.getContactNumber());

        BankBranch savedBankBranch = bankBranchRepository.save(bankBranch);
        return convertToDTO(savedBankBranch);
    }

    // Get All Bank Branches
    public List<BankBranchDTO> getAllBankBranches() {
        return bankBranchRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Bank Branch by ID
    public BankBranchDTO getBankBranchById(Long id) {
        BankBranch bankBranch = bankBranchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank Branch not found with id: " + id));
        return convertToDTO(bankBranch);
    }

    // Delete Bank Branch
    public void deleteBankBranch(Long id) {
        BankBranch bankBranch = bankBranchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank Branch not found with id: " + id));
        bankBranchRepository.delete(bankBranch);
    }

    // Convert Entity to DTO
    private BankBranchDTO convertToDTO(BankBranch bankBranch) {
        return new BankBranchDTO(
                bankBranch.getId(),
                bankBranch.getBranchCode(),
                bankBranch.getBranchName(),
                bankBranch.getAddress(),
                bankBranch.getCity(),
                bankBranch.getState(),
                bankBranch.getContactNumber()
        );
    }
}

