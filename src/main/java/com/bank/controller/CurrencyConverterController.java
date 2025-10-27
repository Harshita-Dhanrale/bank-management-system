package com.bank.controller;

import com.bank.dto.CurrencyConverterDTO;
import com.bank.service.CurrencyConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currency-converter")
@CrossOrigin(origins = "http://localhost:4200") // Allow frontend connection
public class CurrencyConverterController {

    private final CurrencyConverterService currencyConverterService;

    public CurrencyConverterController(CurrencyConverterService currencyConverterService) {
        this.currencyConverterService = currencyConverterService;
    }

    // Create Currency Converter Entry
    @PostMapping
    public ResponseEntity<CurrencyConverterDTO> createCurrencyConverter(@RequestBody CurrencyConverterDTO dto) {
        CurrencyConverterDTO createdConverter = currencyConverterService.createCurrencyConverter(dto);
        return ResponseEntity.ok(createdConverter);
    }

    // Get All Currency Conversions
    @GetMapping
    public ResponseEntity<List<CurrencyConverterDTO>> getAllCurrencyConverters() {
        List<CurrencyConverterDTO> converters = currencyConverterService.getAllCurrencyConverters();
        return ResponseEntity.ok(converters);
    }

    // Get Currency Converter by ID
    @GetMapping("/{id}")
    public ResponseEntity<CurrencyConverterDTO> getCurrencyConverterById(@PathVariable Long id) {
        CurrencyConverterDTO converter = currencyConverterService.getCurrencyConverterById(id);
        return ResponseEntity.ok(converter);
    }

    // Convert Currency Amount
    @GetMapping("/{id}/convert")
    public ResponseEntity<Double> convertCurrency(@PathVariable Long id, @RequestParam double amount) {
        double convertedAmount = currencyConverterService.convertCurrency(id, amount);
        return ResponseEntity.ok(convertedAmount);
    }

    // Delete Currency Converter Entry
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCurrencyConverter(@PathVariable Long id) {
        currencyConverterService.deleteCurrencyConverter(id);
        return ResponseEntity.ok("Currency Converter entry deleted successfully");
    }
}

