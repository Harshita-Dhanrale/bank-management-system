package com.bank.service;

import com.bank.dto.ChequeDTO;
import com.bank.entity.Cheque;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.ChequeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChequeService {

    private final ChequeRepository chequeRepository;

    public ChequeService(ChequeRepository chequeRepository) {
        this.chequeRepository = chequeRepository;
    }

    // Create Cheque
    public ChequeDTO createCheque(ChequeDTO chequeDTO) {
        Cheque cheque = new Cheque();
        cheque.setAccountNo(chequeDTO.getAccountNo());
        cheque.setChequeNumber(chequeDTO.getChequeNumber());
        cheque.setAmount(chequeDTO.getAmount());
        cheque.setIssueDate(chequeDTO.getIssueDate());
        cheque.setStatus("Pending");

        Cheque savedCheque = chequeRepository.save(cheque);
        return convertToDTO(savedCheque);
    }

    // Get All Cheques
    public List<ChequeDTO> getAllCheques() {
        return chequeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Cheque by ID
    public ChequeDTO getChequeById(Long id) {
        Cheque cheque = chequeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cheque not found with id: " + id));
        return convertToDTO(cheque);
    }

    // Delete Cheque
    public void deleteCheque(Long id) {
        Cheque cheque = chequeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cheque not found with id: " + id));
        chequeRepository.delete(cheque);
    }

    // Convert Entity to DTO
    private ChequeDTO convertToDTO(Cheque cheque) {
        ChequeDTO dto = new ChequeDTO();
        dto.setId(cheque.getId());
        dto.setAccountNo(cheque.getAccountNo());
        dto.setChequeNumber(cheque.getChequeNumber());
        dto.setAmount(cheque.getAmount());
        dto.setIssueDate(cheque.getIssueDate());
        dto.setStatus(cheque.getStatus());
        return dto;
    }
}

