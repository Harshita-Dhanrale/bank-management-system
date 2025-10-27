package com.bank.repository;

import com.bank.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByAccount_AccountNo(Long accountNo);
}
