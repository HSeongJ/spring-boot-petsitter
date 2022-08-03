package com.personal.petsitter.repositories.petsitter;

import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.petsitter.PetsitterReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetsitterReservationRepository extends JpaRepository<PetsitterReservationEntity, Long> {

    List<PetsitterReservationEntity> findPetsitterReservationEntitiesByCustomer(CustomerEntity customer);
}
