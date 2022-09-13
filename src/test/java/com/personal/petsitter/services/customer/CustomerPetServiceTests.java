package com.personal.petsitter.services.customer;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class CustomerPetServiceTests {

    @Autowired
    private CustomerPetService service;

    @Test
    public void testGetPetList() {
        log.info(service.getPetListInfo(1L));
    }
}
