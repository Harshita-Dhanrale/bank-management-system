package com.bank.service;

import com.bank.dto.LockerDTO;
import com.bank.entity.Locker;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.LockerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LockerService {

    private final LockerRepository lockerRepository;

    public LockerService(LockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
    }

    // Create Locker
    public LockerDTO createLocker(LockerDTO lockerDTO) {
        Locker locker = new Locker();
        locker.setLockerNumber(lockerDTO.getLockerNumber());
        locker.setAccountId(lockerDTO.getAccountId());
        locker.setSize(lockerDTO.getSize());
        locker.setRentAmount(lockerDTO.getRentAmount());
        locker.setStatus("Available");

        Locker savedLocker = lockerRepository.save(locker);
        return convertToDTO(savedLocker);
    }

    // Get All Lockers
    public List<LockerDTO> getAllLockers() {
        return lockerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Locker by ID
    public LockerDTO getLockerById(Long id) {
        Locker locker = lockerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Locker not found with id: " + id));
        return convertToDTO(locker);
    }

    // Delete Locker
    public void deleteLocker(Long id) {
        Locker locker = lockerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Locker not found with id: " + id));
        lockerRepository.delete(locker);
    }

    // Convert Entity to DTO
    private LockerDTO convertToDTO(Locker locker) {
        return new LockerDTO(
                locker.getId(),
                locker.getLockerNumber(),
                locker.getAccountId(),
                locker.getSize(),
                locker.getRentAmount(),
                locker.getStatus()
        );
    }
}
