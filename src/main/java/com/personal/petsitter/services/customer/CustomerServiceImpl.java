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

    @Override
    public String updatePhonenumber(Long customerIdx, String phonenumber) {
        try {
            repository.updateCustomerPhonenumber(customerIdx, phonenumber);

            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public String updateAddress(Long customerIdx, String address) {
        try {
            repository.updateCustomerAddress(customerIdx, address);

            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public Boolean checkExistId(String id) {
        return repository.checkIdDuplicate(id) > 0 ? false : true;
    }

    @Override
    public Boolean checkExistNickname(String nickname) {
        return repository.checkNicknameDuplicate(nickname) > 0 ? false : true;
    }
}
