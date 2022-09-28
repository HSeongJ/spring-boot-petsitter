package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.customer.PetEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerPetService {

    List<Pet.ListInfo> getPetListInfo(Long cusIdx);

    ResponseEntity<String> addPet(Long idx, Pet.PetWrite dto);

    ResponseEntity<String> modifyPetInfo(Long idx, Pet.PetWrite dto);

    ResponseEntity<String> deletePet(Long petIdx);

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

    default PetEntity WriteDtoToEntity(Long idx, Pet.PetWrite dto) {
        PetEntity entity = PetEntity.builder()
                .family(dto.getFamily())
                .name(dto.getName())
                .gender(dto.getGender())
                .age(dto.getAge())
                .picture(dto.getPicture())
                .customer(CustomerEntity.builder().idx(idx).build())
                .build();

        return entity;
    }
}
