package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.entities.base.Gender;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class CustomerPetServiceTests {

    @Autowired
    private CustomerPetService service;

    @Test
    public void testGetPetList() {
        log.info(service.getPetListInfo(1L));
    }

    @Test
    public void testAddPetInfo() {
        Pet.PetWrite dto = Pet.PetWrite.builder()
                .age(32)
                .name("AddName")
                .family("AddFamily1")
                .gender(Gender.MAIL)
                .picture("Add")
                .build();

        log.info(service.addPet(3L, dto));
    }
    @Test
    public void testModifyPetInfo() {
        Pet.PetWrite dto = Pet.PetWrite.builder()
                .petIdx(2L)
                .age(32)
                .name("ChangeName")
                .family("ChangeFamily1")
                .gender(Gender.MAIL)
                .picture("Change")
                .build();

        log.info(service.modifyPetInfo(3L, dto));
    }

    @Test
    public void testDeletePet() {
        log.info(service.deletePet(301L));
    }
}
