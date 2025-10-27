package com.bank.repository;

import com.bank.entity.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Long> {
    Optional<DebitCard> findByCardNumber(String cardNumber);
}

