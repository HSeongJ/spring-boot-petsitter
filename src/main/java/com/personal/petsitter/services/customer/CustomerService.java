package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.base.CustomerRole;
import com.personal.petsitter.entities.base.Gender;
import com.personal.petsitter.entities.customer.CustomerEntity;

public interface CustomerService {

    Customer.Info signIn(Customer.SignIn dto);

    String updatePhonenumber(Long customerIdx, String phonenumber);

    String updateAddress(Long customerIdx, String address);

    Boolean checkExistId(String id);

    Boolean checkExistNickname(String nickname);

    String signUp(Customer.SignUp dto);

    default Customer.Info entityToSignInDTO(CustomerEntity entity) {
        Customer.Info dto = Customer.Info.builder()
                .customerIdx(entity.getIdx())
                .id(entity.getId())
                .name(entity.getName())
                .nickname(entity.getNickname())
                .gender(entity.getGender())
                .email(entity.getEmail())
                .phonenumber(entity.getPhonenumber())
                .address(entity.getAddress())
                .picture(entity.getPicture())
                .roleSet(entity.getRoleSet())
                .build();

        return dto;
    }

    default CustomerEntity signUpDTOToEntity(Customer.SignUp dto) {
        CustomerEntity entity = CustomerEntity.builder()
                .id(dto.getId())
                .password(dto.getPassword())
                .name(dto.getName())
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
