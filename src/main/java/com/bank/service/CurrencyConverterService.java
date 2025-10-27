package com.bank.service;

import com.bank.dto.CurrencyConverterDTO;
import com.bank.entity.CurrencyConverter;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.CurrencyConverterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyConverterService {

    private final CurrencyConverterRepository currencyConverterRepository;

    public CurrencyConverterService(CurrencyConverterRepository currencyConverterRepository) {
        this.currencyConverterRepository = currencyConverterRepository;
    }

    // Create Currency Converter Entry
    public CurrencyConverterDTO createCurrencyConverter(CurrencyConverterDTO dto) {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.setFromCurrency(dto.getFromCurrency());
        currencyConverter.setToCurrency(dto.getToCurrency());
        currencyConverter.setExchangeRate(dto.getExchangeRate());

        CurrencyConverter savedCurrencyConverter = currencyConverterRepository.save(currencyConverter);
        return convertToDTO(savedCurrencyConverter);
    }

    // Get All Currency Conversions
    public List<CurrencyConverterDTO> getAllCurrencyConverters() {
        return currencyConverterRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Currency Converter by ID
    public CurrencyConverterDTO getCurrencyConverterById(Long id) {
        CurrencyConverter currencyConverter = currencyConverterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency Converter not found with id: " + id));
        return convertToDTO(currencyConverter);
    }

    // Convert Currency Amount
    public double convertCurrency(Long id, double amount) {
        CurrencyConverter currencyConverter = currencyConverterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency Converter not found with id: " + id));
        return amount * currencyConverter.getExchangeRate();
    }

    // Delete Currency Converter Entry
    public void deleteCurrencyConverter(Long id) {
        CurrencyConverter currencyConverter = currencyConverterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency Converter not found with id: " + id));
        currencyConverterRepository.delete(currencyConverter);
    }

    // Convert Entity to DTO
    private CurrencyConverterDTO convertToDTO(CurrencyConverter currencyConverter) {
        return new CurrencyConverterDTO(
                currencyConverter.getId(),
                currencyConverter.getFromCurrency(),
                currencyConverter.getToCurrency(),
                currencyConverter.getExchangeRate()
        );
    }
}

