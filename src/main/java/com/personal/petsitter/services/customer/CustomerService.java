package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.base.CustomerRole;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.security.CustomerPrincipal;
import org.springframework.http.ResponseEntity;


public interface CustomerService {

    Customer.Info showInfo(CustomerPrincipal customerPrincipal);

    ResponseEntity<String> updatePhonenumber(Long idx, String phonenumber);

    ResponseEntity<String> updateAddress(Long customerIdx, String address);

    Boolean checkExistId(String id);

    Boolean checkExistNickname(String nickname);

    ResponseEntity<String> signUp(Customer.SignUp dto);

    default Customer.Info entityToInfoDTO(CustomerEntity entity) {
        Customer.Info dto = Customer.Info.builder()
                .id(entity.getId())
                .name(entity.getName())
                .nickname(entity.getNickname())
                .gender(entity.getGender())
                .email(entity.getEmail())
                .phonenumber(entity.getPhonenumber())
                .address(entity.getAddress())
                .picture(entity.getPicture())
                .build();

        return dto;
    }

    default CustomerEntity signUpDTOToEntity(Customer.SignUp dto, String password) {
        CustomerEntity entity = CustomerEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .password(password)
                .nickname(dto.getNickname())
                .gender(dto.getGender())
                .email(dto.getEmail())
                .phonenumber(dto.getPhonenumber())
                .address(dto.getAddress())
                .build();

        entity.addCustomerRole(CustomerRole.USER);
        return entity;
    }
}
