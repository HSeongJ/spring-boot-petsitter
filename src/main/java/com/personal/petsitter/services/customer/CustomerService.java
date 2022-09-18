package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.customer.CustomerEntity;

public interface CustomerService {

    Customer.Info getCustomerInfo(Long idx);

    String updatePhonenumber(Long cusIdx, String phonenumber);

    String updateAddress(Long cusIdx, String address);

    default Customer.Info entityToDTO(CustomerEntity entity) {
        Customer.Info dto = Customer.Info.builder()
                .cusIdx(entity.getIdx())
                .id(entity.getId())
                .password(entity.getPassword())
                .name(entity.getName())
                .nickname(entity.getNickname())
                .gender(entity.getGender())
                .email(entity.getEmail())
                .phonenumber(entity.getPhonenumber())
                .address(entity.getAddress())
                .picture(entity.getPicture())
                .roleSet(entity.getRoleSet())
                .state(entity.getState())
                .build();

        return dto;
    }
}
