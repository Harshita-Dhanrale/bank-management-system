package com.bank.repository;

import com.bank.entity.CurrencyConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConverterRepository extends JpaRepository<CurrencyConverter, Long> {
}

