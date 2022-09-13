package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.customer.CustomerEntity;

public interface CustomerService {

    Customer.Info getCustomerInfo(Long idx);

    default Customer.Info entityToDTO(CustomerEntity entity) {
        Customer.Info dto = Customer.Info.builder()
                .cusIdx(entity.getIdx())
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
}
