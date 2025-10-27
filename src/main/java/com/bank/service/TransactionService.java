package com.bank.service;

import com.bank.dto.TransactionDTO;
import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService { 

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    // Constructor-based Dependency Injection (Preferred)
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    // ✅ Fetch all transactions
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Get transaction by ID
    public TransactionDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));
        return convertToDTO(transaction);
    }

    // ✅ Create a new transaction
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Account account = accountRepository.findById(transactionDTO.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + transactionDTO.getAccountId()));

        Transaction transaction = new Transaction();
        transaction.setTransactionType(transactionDTO.getTransactionType());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAccount(account);
        transaction.setStatus("Completed"); // Default status

        Transaction savedTransaction = transactionRepository.save(transaction);
        return convertToDTO(savedTransaction);
    }

    // ✅ Delete transaction by ID
    public void deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));
        transactionRepository.delete(transaction);
    }

    // ✅ Convert Entity to DTO
    private TransactionDTO convertToDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getTransactionDate(),
                transaction.getAccount().getId(),
                transaction.getStatus()
        );
    }
}

