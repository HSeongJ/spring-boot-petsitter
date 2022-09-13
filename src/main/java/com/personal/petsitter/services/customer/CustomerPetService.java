package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.customer.PetEntity;

import java.util.List;

public interface CustomerPetService {

    List<Pet.ListInfo> getPetListInfo(Long cusIdx);

    String addPet(Pet.PetWrite dto);
    String modifyPetInfo(Pet.PetWrite dto);
    default Pet.ListInfo entityToDTO(PetEntity entity) {

        Pet.ListInfo dto = Pet.ListInfo.builder()
                .petIdx(entity.getIdx())
                .family(entity.getFamily())
                .name(entity.getName())
                .gender(entity.getGender())
                .age(entity.getAge())
                .picture(entity.getPicture())
                .build();

        return dto;
    }

    default PetEntity WriteDtoToEntity(Pet.PetWrite dto) {
        PetEntity entity = PetEntity.builder()
                .idx(dto.getPetIdx())
                .family(dto.getFamily())
                .name(dto.getName())
                .gender(dto.getGender())
                .age(dto.getAge())
                .picture(dto.getPicture())
                .customer(CustomerEntity.builder().idx(dto.getCustomerIdx()).build())
                .build();
        
        return entity;
    }
}
