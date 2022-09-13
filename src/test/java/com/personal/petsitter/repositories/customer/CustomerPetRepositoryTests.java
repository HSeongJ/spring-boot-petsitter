package com.personal.petsitter.repositories.customer;

import com.personal.petsitter.entities.base.Gender;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.customer.PetEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class CustomerPetRepositoryTests {

    @Autowired
    private CustomerPetRepository repository;

    @Test
    public void InsertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            PetEntity entity = PetEntity.builder()
                    .family(i % 2 == 0 ? "Family1" : "Family2")
                    .name("TestName" + i)
                    .gender(i % 3 == 0 ? Gender.FEMAIL : Gender.MAIL)
                    .age(i % 100 + 1)
                    .customer(CustomerEntity.builder().idx(i % 20 + 1L).build())
                    .build();

            repository.save(entity);
        });
    }

    @Test
    public void testUpdate() {
        PetEntity entity = PetEntity.builder()
                .idx(2L)
                .customer(CustomerEntity.builder().idx(3L).build())
                .family("Change")
                .picture("Change")
                .age(33)
                .gender(Gender.MAIL)
                .name("Change")
                .build();

        repository.save(entity);
    }
    @Test
    public void testGetPetList() {
        log.info(repository.findPetEntitiesByCustomer(CustomerEntity.builder().idx(1L).build()));
    }
}
