package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.customer.CustomerEntity;

public interface CustomerService {

    Customer.Info getCustomerInfo(Long idx);

    String updatePhonenumber(Long customerIdx, String phonenumber);

    String updateAddress(Long customerIdx, String address);

    Boolean checkExistId(String id);

    Boolean checkExistNickname(String nickname);

    default Customer.Info entityToDTO(CustomerEntity entity) {
        Customer.Info dto = Customer.Info.builder()
                .customerIdx(entity.getIdx())
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
