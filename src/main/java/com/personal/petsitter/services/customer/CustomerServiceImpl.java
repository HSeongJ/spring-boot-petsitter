package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.repositories.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Customer.Info signIn(Customer.SignIn dto) {
        Optional<CustomerEntity> entity = repository.findCustomerEntityByIdAndPassword(dto.getId(), dto.getPassword());

        if(entity.isPresent())
            return entityToSignInDTO(entity.get());
        else
            return null;
    }

    @Override
    public String signUp(Customer.SignUp dto) {
        try {
            repository.save(signUpDTOToEntity(dto));
            return "success";
        } catch (Exception e) {
            return "fail";
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
