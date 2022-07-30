package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class PetsitterServiceTests {

    @Autowired
    private PetsitterService petsitterService;

    @Test
    public void testGetPetsitterList() {
        PageRequestDTO dto = new PageRequestDTO();

        log.info(petsitterService.getPetsitterList(dto));
    }

    @Test
    public void testGetPetsitterInfo() {
        log.info(petsitterService.getPetsitterInfo(1L));
    }
}
