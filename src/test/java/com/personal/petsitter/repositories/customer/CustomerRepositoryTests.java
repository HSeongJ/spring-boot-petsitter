package com.personal.petsitter.repositories.customer;

import com.personal.petsitter.entities.base.CustomerRole;
import com.personal.petsitter.entities.base.Gender;
import com.personal.petsitter.entities.customer.CustomerEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            CustomerEntity entity = CustomerEntity.builder()
                    .id("Testid" + i)
                    .password("TestPassword" + i)
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
    public void testFindCustomerEntitiesByIdx() {
        Optional<CustomerEntity> result =
                customerRepository.findCustomerEntitiesByIdx(1L);

        if(result.isPresent())
            log.info(result.get());
        else
            log.info(Optional.empty());
    }


    @Modifying
    @Test
    public void testModifyCustomerInfo() {
        CustomerEntity entity = CustomerEntity.builder()
                .idx(1L)
                .id("testId")
                .password("testPas")
                .gender(Gender.FEMAIL)
                .name("test1121")
                .nickname("testnickname")
                .email("test@test.com")
                .phonenumber("0102301203")
                .address("testa")
                .picture("testp")
                .state("활성")
                .build();

        log.info(customerRepository.save(entity));
    }
}
