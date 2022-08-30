package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ProductServiceTests {

    @Autowired
    private ProductService service;

    @Test
    public void testGetList() {
        PageRequestDTO dto = new PageRequestDTO();

        dto.setPage(1);
        dto.setFamily("Family1");
        dto.setCategory("Category1");
        dto.setKeyword("e1");

        log.info(service.getList(dto).getResultDTO());
    }
}
