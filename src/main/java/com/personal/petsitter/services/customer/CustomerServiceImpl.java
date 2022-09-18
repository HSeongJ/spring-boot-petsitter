package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.repositories.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Customer.Info getCustomerInfo(Long idx) {
        Optional<CustomerEntity> result = repository.findCustomerEntitiesByIdx(idx);

        if(result.isPresent()) {
            Customer.Info dto = entityToDTO(result.get());
            return dto;
        } else {
            return null;
        }
    }

    @Modifying
    @Override
    public String modifyCustomerInfo(Customer.Info dto) {
        try {
            CustomerEntity entity = infoDtoToEntity(dto);
            repository.save(entity);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
}
