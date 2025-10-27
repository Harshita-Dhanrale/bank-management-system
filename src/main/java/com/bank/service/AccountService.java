package com.bank.service;

import com.bank.dto.AccountDTO;
import com.bank.entity.Account;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAccountType(accountDTO.getAccountType());
        account.setFirstName(accountDTO.getFirstName());
        account.setMiddleName(accountDTO.getMiddleName());
        account.setLastName(accountDTO.getLastName());
        account.setContactNo(accountDTO.getContactNo());
        account.setDob(accountDTO.getDob());
        account.setEmail(accountDTO.getEmail());
        account.setAddress(accountDTO.getAddress());
        account.setDocumentId(accountDTO.getDocumentId());

        Account savedAccount = accountRepository.save(account);
        return convertToDTO(savedAccount);
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
        return convertToDTO(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
        accountRepository.deleteById(id);
    }

    private AccountDTO convertToDTO(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setAccountNo(account.getAccountNo());
        dto.setAccountType(account.getAccountType());
        dto.setFirstName(account.getFirstName());
        dto.setMiddleName(account.getMiddleName());
        dto.setLastName(account.getLastName());
        dto.setContactNo(account.getContactNo());
        dto.setDob(account.getDob());
        dto.setEmail(account.getEmail());
        dto.setAddress(account.getAddress());
        dto.setCreditScore(account.getCreditScore());
        dto.setDocumentId(account.getDocumentId());
        return dto;
    }
    
    public AccountDTO updateAccount(Long id, AccountDTO accountDTO) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));

        // Updating account details
        account.setAccountType(accountDTO.getAccountType());
        account.setFirstName(accountDTO.getFirstName());
        account.setMiddleName(accountDTO.getMiddleName());
        account.setLastName(accountDTO.getLastName());
        account.setContactNo(accountDTO.getContactNo());
        account.setDob(accountDTO.getDob());
        account.setEmail(accountDTO.getEmail());
        account.setAddress(accountDTO.getAddress());
        account.setDocumentId(accountDTO.getDocumentId());

        // Save updated account
        Account updatedAccount = accountRepository.save(account);
        return convertToDTO(updatedAccount);
    }
}
