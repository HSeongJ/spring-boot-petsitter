package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.entities.customer.PetEntity;

import java.util.List;

public interface CustomerPetService {

    List<Pet.ListInfo> getPetListInfo(Long cusIdx);

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
}
