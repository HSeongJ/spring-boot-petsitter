package com.personal.petsitter.repositories.customer;

import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.customer.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerPetRepository extends JpaRepository<PetEntity, Long> {

    List<PetEntity> findPetEntitiesByCustomer(CustomerEntity customer);
}
