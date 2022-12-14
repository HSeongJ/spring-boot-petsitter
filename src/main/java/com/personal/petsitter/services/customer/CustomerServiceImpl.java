package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.repositories.customer.CustomerRepository;
import com.personal.petsitter.security.CustomerPrincipal;
import com.personal.petsitter.util.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public Customer.Info showInfo(CustomerPrincipal customerPrincipal) {
        Optional<CustomerEntity> entity = repository.findByIdx(customerPrincipal.getIdx());

        Customer.Info dto = entityToInfoDTO(entity.get());

        return dto;
    }

    @Override
    public ResponseEntity<String> signUp(Customer.SignUp dto) {
        try {
            repository.save(signUpDTOToEntity(dto, passwordEncoder.encode(dto.getPassword())));
        } catch (Exception e) {
            return new ResponseEntity<>(AppConstants.RESPONSE_FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(AppConstants.RESPONSE_SUCCESS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updatePhonenumber(Long idx, String phonenumber) {
        try {
            repository.updateCustomerPhonenumber(idx, phonenumber);
        } catch (Exception e) {
            return new ResponseEntity<>(AppConstants.RESPONSE_FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(AppConstants.RESPONSE_SUCCESS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateAddress(Long customerIdx, String address) {
        try {
            repository.updateCustomerAddress(customerIdx, address);
        } catch (Exception e) {
            return new ResponseEntity<>(AppConstants.RESPONSE_FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(AppConstants.RESPONSE_SUCCESS, HttpStatus.OK);
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
