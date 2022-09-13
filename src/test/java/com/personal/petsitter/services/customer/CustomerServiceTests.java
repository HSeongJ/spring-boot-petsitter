package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.entities.base.CustomerRole;
import com.personal.petsitter.entities.base.Gender;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Collections;

@SpringBootTest
@Log4j2
public class CustomerServiceTests {

    @Autowired
    private CustomerService service;

    @Test
    public void testGetCustomerInfo() {
        log.info(service.getCustomerInfo(1L));
    }

    @Test
    public void testModifyCustomerInfo() {
        Customer.Info dto = Customer.Info.builder()
                .cusIdx(1L)
                .id("ChangeId")
                .password("ChangePassword")
                .name("ChangeName")
                .nickname("ChangeNickname")
                .gender(Gender.FEMAIL)
                .email("Change@test.com")
                .phonenumber("010231023010")
                .picture("ChangePicture")
                .address("ChangeAddress")
                .roleSet(Collections.singleton(CustomerRole.USER))
                .state("활성")
                .build();

        log.info(service.modifyCustomerInfo(dto));
    }
}
