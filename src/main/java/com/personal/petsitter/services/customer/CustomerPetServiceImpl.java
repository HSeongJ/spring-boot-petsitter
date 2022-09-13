package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.customer.PetEntity;
import com.personal.petsitter.repositories.customer.CustomerPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerPetServiceImpl implements CustomerPetService{

    private final CustomerPetRepository repository;

    @Override
    public List<Pet.ListInfo> getPetListInfo(Long cusIdx) {
        CustomerEntity customer = CustomerEntity.builder().idx(cusIdx).build();

        List<PetEntity> results = repository.findPetEntitiesByCustomer(customer);

        List<Pet.ListInfo> dto = results.stream().map(i -> entityToDTO(i)).collect(Collectors.toList());

        return dto;
    }
}
