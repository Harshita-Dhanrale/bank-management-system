package com.bank.service;

import com.bank.dto.DepositDTO;
import com.bank.entity.Account;
import com.bank.entity.Deposit;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepositService {

    private final DepositRepository depositRepository;
    private final AccountRepository accountRepository;

    public DepositService(DepositRepository depositRepository, AccountRepository accountRepository) {
        this.depositRepository = depositRepository;
        this.accountRepository = accountRepository;
    }

    public DepositDTO createDeposit(DepositDTO depositDTO) {
        Account account = accountRepository.findById(depositDTO.getAccountNo())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        Deposit deposit = new Deposit();
        deposit.setAccount(account);
        deposit.setAmount(depositDTO.getAmount());
        deposit.setDepositDate(LocalDateTime.now());
        deposit.setDepositType(depositDTO.getDepositType());
        deposit.setStatus("PENDING"); // Default status

        Deposit savedDeposit = depositRepository.save(deposit);
        return convertToDTO(savedDeposit);
    }

    public List<DepositDTO> getDepositsByAccount(Long accountNo) {
        List<Deposit> deposits = depositRepository.findByAccount_AccountNo(accountNo);
        return deposits.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void deleteDeposit(Long id) {
        depositRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Deposit not found"));
        depositRepository.deleteById(id);
    }

    private DepositDTO convertToDTO(Deposit deposit) {
        return new DepositDTO(
                deposit.getId(),
                deposit.getAccount().getAccountNo(),
                deposit.getAmount(),
                deposit.getDepositDate(),
                deposit.getDepositType(),
                deposit.getStatus()
        );
    }
}
