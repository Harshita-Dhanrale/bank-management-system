package com.bank.service;

import com.bank.dto.KYCDTO;
import com.bank.entity.KYC;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.KYCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KYCService {

    private final KYCRepository kycRepository;

    @Autowired
    public KYCService(KYCRepository kycRepository) {
        this.kycRepository = kycRepository;
    }

    /**
     * Retrieves all KYC records.
     *
     * @return a list of KYCDTOs
     */
    public List<KYCDTO> getAllKYCRecords() {
        List<KYC> kycRecords = kycRepository.findAll();
        return kycRecords.stream()
                         .map(this::convertToDTO)
                         .collect(Collectors.toList());
    }

    /**
     * Retrieves a KYC record by its ID.
     *
     * @param id the ID of the KYC record
     * @return the corresponding KYCDTO
     * @throws ResourceNotFoundException if the KYC record is not found
     */
    public KYCDTO getKYCById(Long id) {
        KYC kyc = kycRepository.findById(id)
                               .orElseThrow(() -> new ResourceNotFoundException("KYC record not found with id: " + id));
        return convertToDTO(kyc);
    }

    /**
     * Creates a new KYC record.
     *
     * @param kycDTO the data transfer object containing KYC information
     * @return the created KYCDTO
     */
    public KYCDTO createKYC(KYCDTO kycDTO) {
        KYC kyc = convertToEntity(kycDTO);
        KYC savedKYC = kycRepository.save(kyc);
        return convertToDTO(savedKYC);
    }

    /**
     * Updates an existing KYC record.
     *
     * @param id     the ID of the KYC record to update
     * @param kycDTO the data transfer object containing updated KYC information
     * @return the updated KYCDTO
     * @throws ResourceNotFoundException if the KYC record is not found
     */
    public KYCDTO updateKYC(Long id, KYCDTO kycDTO) {
        KYC existingKYC = kycRepository.findById(id)
                                       .orElseThrow(() -> new ResourceNotFoundException("KYC record not found with id: " + id));

        existingKYC.setFullName(kycDTO.getFullName());
        existingKYC.setAddress(kycDTO.getAddress());
        existingKYC.setIdentificationNumber(kycDTO.getIdentificationNumber());
        existingKYC.setIdentificationType(kycDTO.getIdentificationType());
        existingKYC.setDateOfBirth(kycDTO.getDateOfBirth());
        existingKYC.setStatus(kycDTO.getStatus());

        KYC updatedKYC = kycRepository.save(existingKYC);
        return convertToDTO(updatedKYC);
    }

    /**
     * Deletes a KYC record by its ID.
     *
     * @param id the ID of the KYC record to delete
     * @throws ResourceNotFoundException if the KYC record is not found
     */
    public void deleteKYC(Long id) {
        KYC existingKYC = kycRepository.findById(id)
                                       .orElseThrow(() -> new ResourceNotFoundException("KYC record not found with id: " + id));
        kycRepository.delete(existingKYC);
    }

    /**
     * Converts a KYC entity to a KYCDTO.
     *
     * @param kyc the KYC entity
     * @return the corresponding KYCDTO
     */
    private KYCDTO convertToDTO(KYC kyc) {
        return new KYCDTO(
                kyc.getId(),
                kyc.getCustomerId(),
                kyc.getFullName(),
                kyc.getAddress(),
                kyc.getIdentificationNumber(),
                kyc.getIdentificationType(),
                kyc.getDateOfBirth(),
                kyc.getStatus()
        );
    }

    /**
     * Converts a KYCDTO to a KYC entity.
     *
     * @param kycDTO the KYCDTO
     * @return the corresponding KYC entity
     */
    private KYC convertToEntity(KYCDTO kycDTO) {
        KYC kyc = new KYC();
        kyc.setCustomerId(kycDTO.getCustomerId());
        kyc.setFullName(kycDTO.getFullName());
        kyc.setAddress(kycDTO.getAddress());
        kyc.setIdentificationNumber(kycDTO.getIdentificationNumber());
        kyc.setIdentificationType(kycDTO.getIdentificationType());
        kyc.setDateOfBirth(kycDTO.getDateOfBirth());
        kyc.setStatus(kycDTO.getStatus());
        return kyc;
    }
}

