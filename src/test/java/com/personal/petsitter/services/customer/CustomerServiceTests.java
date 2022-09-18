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
    public void testUpdateCustomerPhonenumber() {
        log.info(service.updatePhonenumber(1L, "01011223344"));
    }

    @Test
    public void testCheckExistId() {
        log.info(service.checkExistId("Testid2"));
    }
}
