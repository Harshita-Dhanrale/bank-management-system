package com.bank.service;

import com.bank.dto.CreditCardDTO;
import com.bank.entity.Account;
import com.bank.entity.CreditCard;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final AccountRepository accountRepository;

    public CreditCardService(CreditCardRepository creditCardRepository, AccountRepository accountRepository) {
        this.creditCardRepository = creditCardRepository;
        this.accountRepository = accountRepository;
    }

    public CreditCardDTO createCreditCard(CreditCardDTO creditCardDTO) {
        Account account = accountRepository.findById(creditCardDTO.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(creditCardDTO.getCardNumber());
        creditCard.setCardHolderName(creditCardDTO.getCardHolderName());
        creditCard.setExpiryDate(creditCardDTO.getExpiryDate());
        creditCard.setCreditLimit(creditCardDTO.getCreditLimit());
        creditCard.setCurrentBalance(creditCardDTO.getCurrentBalance());
        creditCard.setInterestRate(creditCardDTO.getInterestRate());
        creditCard.setCvv(creditCardDTO.getCvv()); // ✅ Set cvv
        creditCard.setIsActive(creditCardDTO.getIsActive());
        creditCard.setAccount(account);

        CreditCard savedCard = creditCardRepository.save(creditCard);
        return convertToDTO(savedCard);
    }

    public List<CreditCardDTO> getAllCreditCards() {
        return creditCardRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CreditCardDTO getCreditCardById(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Credit Card not found"));
        return convertToDTO(creditCard);
    }

    public void deleteCreditCard(Long id) {
        creditCardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Credit Card not found"));
        creditCardRepository.deleteById(id);
    }

    private CreditCardDTO convertToDTO(CreditCard creditCard) {
        CreditCardDTO creditCardDTO = new CreditCardDTO();
        creditCardDTO.setId(creditCard.getId());
        creditCardDTO.setCardNumber(creditCard.getCardNumber());
        creditCardDTO.setCardHolderName(creditCard.getCardHolderName());
        creditCardDTO.setExpiryDate(creditCard.getExpiryDate());
        creditCardDTO.setCreditLimit(creditCard.getCreditLimit());
        creditCardDTO.setCurrentBalance(creditCard.getCurrentBalance());
        creditCardDTO.setInterestRate(creditCard.getInterestRate());
        creditCardDTO.setCvv(creditCard.getCvv()); // ✅ Include cvv
        creditCardDTO.setIsActive(creditCard.getIsActive());
        creditCardDTO.setAccountId(creditCard.getAccount().getId());

        return creditCardDTO;
    }
}

