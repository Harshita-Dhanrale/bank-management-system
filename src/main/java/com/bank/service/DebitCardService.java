package com.bank.service;

import com.bank.dto.DebitCardDTO;
import com.bank.entity.Account;
import com.bank.entity.DebitCard;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.DebitCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DebitCardService {

    private final DebitCardRepository debitCardRepository;
    private final AccountRepository accountRepository;

    public DebitCardService(DebitCardRepository debitCardRepository, AccountRepository accountRepository) {
        this.debitCardRepository = debitCardRepository;
        this.accountRepository = accountRepository;
    }

    // ✅ Create Debit Card
    public DebitCardDTO createDebitCard(DebitCardDTO debitCardDTO) {
        Account account = accountRepository.findById(debitCardDTO.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        DebitCard debitCard = new DebitCard();
        debitCard.setCardNumber(debitCardDTO.getCardNumber());
        debitCard.setCardHolderName(debitCardDTO.getCardHolderName());
        debitCard.setExpiryDate(debitCardDTO.getExpiryDate());
        debitCard.setDailyWithdrawalLimit(debitCardDTO.getDailyWithdrawalLimit());
        debitCard.setIsActive(debitCardDTO.getIsActive());
        debitCard.setAccount(account);

        DebitCard savedCard = debitCardRepository.save(debitCard);
        return convertToDTO(savedCard);
    }

    // ✅ Get All Debit Cards
    public List<DebitCardDTO> getAllDebitCards() {
        return debitCardRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Get Debit Card by ID
    public DebitCardDTO getDebitCardById(Long id) {
        DebitCard debitCard = debitCardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Debit Card not found"));
        return convertToDTO(debitCard);
    }

    // ✅ Delete Debit Card
    public void deleteDebitCard(Long id) {
        DebitCard debitCard = debitCardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Debit Card not found"));
        debitCardRepository.deleteById(id);
    }

    // Helper method to convert entity to DTO
    private DebitCardDTO convertToDTO(DebitCard debitCard) {
        DebitCardDTO dto = new DebitCardDTO();
        dto.setId(debitCard.getCardId());
        dto.setCardNumber(debitCard.getCardNumber());
        dto.setCardHolderName(debitCard.getCardHolderName());
        dto.setExpiryDate(debitCard.getExpiryDate());
        dto.setDailyWithdrawalLimit(debitCard.getDailyWithdrawalLimit());
        dto.setIsActive(debitCard.getIsActive());
        dto.setAccountId(debitCard.getAccount().getAccountNo()); // Link with Account
        return dto;
    }
}

