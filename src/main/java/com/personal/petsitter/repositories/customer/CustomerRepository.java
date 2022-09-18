package com.personal.petsitter.repositories.customer;

import com.personal.petsitter.entities.customer.CustomerEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<CustomerEntity> findCustomerEntitiesByIdx(Long idx);

    @Modifying
    @Transactional
    @Query("UPDATE CustomerEntity c SET c.phonenumber =:phonenumber WHERE c.idx =:customerIdx")
    Integer updateCustomerPhonenumber(@Param("customerIdx") Long customerIdx,
                                      @Param("phonenumber") String phonenumber);

    @Modifying
    @Transactional
    @Query("UPDATE CustomerEntity c SET c.address =:address WHERE c.idx =:customerIdx")
    Integer updateCustomerAddress(@Param("customerIdx") Long customerIdx,
                                      @Param("address") String address);
}
