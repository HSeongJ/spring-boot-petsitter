package com.personal.petsitter.services.customer;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.security.CustomerPrincipal;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class CustomerServiceTests {

    @Autowired
    private CustomerService service;

    @Test
    public void testUpdateCustomerPhonenumber() {

        log.info(service.updatePhonenumber(1L, "01011223344"));
    }

    @Test
    public void testCheckExistId() {
        log.info(service.checkExistId("Testid2"));
    }

}
