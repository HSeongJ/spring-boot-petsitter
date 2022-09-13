package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.customer.PetEntity;
import com.personal.petsitter.repositories.customer.CustomerPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
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

    @Override
    public String addPet(Pet.PetWrite dto) {
        try {
            PetEntity entity = WriteDtoToEntity(dto);
            repository.save(entity);

            return "추가성공";
        } catch (Exception e) {
            return "추가실패";
        }
    }

    @Modifying
    @Override
    public String modifyPetInfo(Pet.PetWrite dto) {
        try {
            PetEntity entity = WriteDtoToEntity(dto);
            repository.save(entity);

            return "변경성공";
        } catch (Exception e) {
            return "변경실패";
        }
    }
}