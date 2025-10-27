package com.bank.service;

import com.bank.dto.ServiceRequestDTO;
import com.bank.entity.Account;
import com.bank.entity.ServiceRequest;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.ServiceRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;
    private final AccountRepository accountRepository;

    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository, AccountRepository accountRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.accountRepository = accountRepository;
    }

    public ServiceRequestDTO createRequest(ServiceRequestDTO dto) {
        Account account = accountRepository.findById(dto.getAccountNo())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        ServiceRequest request = new ServiceRequest();
        request.setAccount(account);
        request.setRequestType(dto.getRequestType());
        request.setDescription(dto.getDescription());

        // ✅ Use status from frontend
        request.setStatus(dto.getStatus());

        // ✅ Use requestDate from frontend
        request.setRequestDate(dto.getRequestDate());

        ServiceRequest saved = serviceRequestRepository.save(request);
        return convertToDTO(saved);
    }


    public List<ServiceRequestDTO> getRequestsByAccount(Long accountNo) {
        List<ServiceRequest> requests = serviceRequestRepository.findByAccount_AccountNo(accountNo);
        return requests.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void deleteRequest(Long id) {
        serviceRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        serviceRequestRepository.deleteById(id);
    }

    private ServiceRequestDTO convertToDTO(ServiceRequest request) {
        ServiceRequestDTO dto = new ServiceRequestDTO();
        dto.setId(request.getId());
        dto.setAccountNo(request.getAccount().getAccountNo());
        dto.setRequestType(request.getRequestType());
        dto.setDescription(request.getDescription());
        dto.setStatus(request.getStatus());
        dto.setRequestDate(request.getRequestDate());
        return dto;
    }
}

