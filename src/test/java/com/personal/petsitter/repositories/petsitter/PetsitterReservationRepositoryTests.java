package com.personal.petsitter.repositories.petsitter;

import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import com.personal.petsitter.entities.petsitter.PetsitterReservationEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class PetsitterReservationRepositoryTests {

    @Autowired
    private PetsitterReservationRepository repository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            CustomerEntity customer = CustomerEntity.builder().idx(i % 10 + 1L).build();
            PetsitterEntity petsitter = PetsitterEntity.builder().idx(i % 10 + 1L).build();

            PetsitterReservationEntity entity = PetsitterReservationEntity.builder()
                    .customer(customer)
                    .petsitter(petsitter)
                    .startTime(LocalDateTime.now())
                    .endTime(LocalDateTime.now())
                    .price(10000)
                    .build();

            repository.save(entity);
        });
    }

    @Test
    public void testSave() {
        CustomerEntity customer = CustomerEntity.builder().idx(1L).build();
        PetsitterEntity petsitter = PetsitterEntity.builder().idx(1L).build();

        PetsitterReservationEntity entity = PetsitterReservationEntity.builder()
                .customer(customer)
                .petsitter(petsitter)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .price(10000)
                .build();

        repository.save(entity);
    }

    @Test
    public void testGetReservation() {
        CustomerEntity entity = CustomerEntity.builder().idx(1L).build();

        log.info(repository.findPetsitterReservationEntitiesByCustomer(entity));
    }
}
