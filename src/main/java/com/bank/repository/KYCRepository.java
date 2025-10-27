package com.bank.repository;

import com.bank.entity.KYC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KYCRepository extends JpaRepository<KYC, Long> {
    Optional<KYC> findByCustomerId(String customerId);
}

