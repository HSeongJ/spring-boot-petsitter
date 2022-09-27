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
    public List<Pet.ListInfo> getPetListInfo(Long customerIdx) {
        CustomerEntity customer = CustomerEntity.builder().idx(customerIdx).build();

        List<PetEntity> results = repository.findPetEntitiesByCustomer(customer);

        List<Pet.ListInfo> dto = results.stream().map(i -> entityToDTO(i)).collect(Collectors.toList());

        return dto;
    }

    @Override
    public String addPet(Long idx, Pet.PetWrite dto) {
        try {
            PetEntity entity = WriteDtoToEntity(idx, dto);
            repository.save(entity);

            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Modifying
    @Override
    public String modifyPetInfo(Long idx, Pet.PetWrite dto) {
        try {
            PetEntity entity = WriteDtoToEntity(idx, dto);
            repository.save(entity);

            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public String deletePet(Long petIdx) {
        try {
            repository.deleteById(petIdx);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
}
