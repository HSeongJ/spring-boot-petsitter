package com.personal.petsitter.repositories.customer;

import com.personal.petsitter.entities.customer.CustomerEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<CustomerEntity> findCustomerEntitiesByIdx(Long idx);
}
