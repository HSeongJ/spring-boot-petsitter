package com.personal.petsitter.repositories.customer;

import com.personal.petsitter.entities.base.CustomerRole;
import com.personal.petsitter.entities.base.Gender;
import com.personal.petsitter.entities.customer.CustomerEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            CustomerEntity entity = CustomerEntity.builder()
                    .id("Testid" + i)
                    .password(passwordEncoder.encode("TestPassword" + i))
                    .name("TestName" + i)
                    .nickname("TestNickname" + i)
                    .gender(i % 2 == 0 ? Gender.FEMAIL : Gender.MAIL)
                    .email("TestEmail" + i + "@aaa.com")
                    .phonenumber("010" + String.format("%04d", i) + "1234")
                    .address("TestAddress" + i)
                    .build();

            entity.addCustomerRole(CustomerRole.USER);

            customerRepository.save(entity);
        });
    }

    @Test
    public void testUpdatePhonenumber() {
        customerRepository.updateCustomerPhonenumber(1L, "01012344444");
    }

    @Test
    public void testCheckIdDuplicate() {
        log.info(customerRepository.checkIdDuplicate("Testid2"));
    }
}
