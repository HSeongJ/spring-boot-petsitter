package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.customer.PetEntity;
import com.personal.petsitter.repositories.customer.CustomerPetRepository;
import com.personal.petsitter.util.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerPetServiceImpl implements CustomerPetService {

    private final CustomerPetRepository repository;

    @Override
    public List<Pet.ListInfo> getPetListInfo(Long customerIdx) {
        CustomerEntity customer = CustomerEntity.builder().idx(customerIdx).build();

        List<PetEntity> results = repository.findPetEntitiesByCustomer(customer);

        List<Pet.ListInfo> dto = results.stream().map(i -> entityToDTO(i)).collect(Collectors.toList());

        return dto;
    }

    @Override
    public ResponseEntity<String> addPet(Long idx, Pet.PetWrite dto) {
        try {
            PetEntity entity = WriteDtoToEntity(idx, dto);
            repository.save(entity);
        } catch (Exception e) {
            return new ResponseEntity<>(AppConstants.RESPONSE_FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(AppConstants.RESPONSE_SUCCESS, HttpStatus.OK);
    }

    @Modifying
    @Override
    public ResponseEntity<String> modifyPetInfo(Long idx, Pet.PetWrite dto) {
        try {
            PetEntity entity = WriteDtoToEntity(idx, dto);
            repository.save(entity);
        } catch (Exception e) {
            return new ResponseEntity<>(AppConstants.RESPONSE_FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(AppConstants.RESPONSE_SUCCESS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deletePet(Long petIdx) {
        try {
            repository.deleteById(petIdx);
        } catch (Exception e) {
            return new ResponseEntity<>(AppConstants.RESPONSE_FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(AppConstants.RESPONSE_SUCCESS, HttpStatus.OK);
    }
}
