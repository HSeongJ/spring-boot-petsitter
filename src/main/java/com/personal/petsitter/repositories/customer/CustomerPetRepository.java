package com.personal.petsitter.repositories.customer;

import com.personal.petsitter.entities.customer.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPetRepository extends JpaRepository<PetEntity, Long> {


}
