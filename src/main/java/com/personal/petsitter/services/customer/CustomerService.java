package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.customer.CustomerEntity;

public interface CustomerService {

    Customer.Info getCustomerInfo(Long idx);

    String modifyCustomerInfo(Customer.Info dto);
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

    default CustomerEntity infoDtoToEntity(Customer.Info dto) {
        CustomerEntity entity = CustomerEntity.builder()
                .idx(dto.getCusIdx())
                .id(dto.getId())
                .password(dto.getPassword())
                .name(dto.getName())
                .nickname(dto.getNickname())
                .email(dto.getEmail())
                .gender(dto.getGender())
                .phonenumber(dto.getPhonenumber())
                .address(dto.getAddress())
                .picture(dto.getPicture())
                .roleSet(dto.getRoleSet())
                .state(dto.getState())
                .build();

        return entity;
    }
}
