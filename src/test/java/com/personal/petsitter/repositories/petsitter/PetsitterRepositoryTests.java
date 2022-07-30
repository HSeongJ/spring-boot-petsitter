package com.personal.petsitter.repositories.petsitter;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class PetsitterRepositoryTests {

    @Autowired
    private PetsitterRepository petsitterRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            PetsitterEntity entity = PetsitterEntity.builder()
                    .name("testName" + i)
                    .family("testFamily" + i)
                    .price(10000 * i)
                    .content("testContent" + i)
                    .career("testCareer" + i)
                    .category(i % 2 == 0 ? "amateur" : "expert")
                    .build();

            petsitterRepository.save(entity);
        });
    }

    @Test
    public void testGetList() {
        PageRequestDTO dto = new PageRequestDTO();
        dto.setPage(1);
        //dto.setCategory("amateur");
         log.info(petsitterRepository.getList(dto));
    }

    @Test
    public void testGetPetsitterDetailInfo() {
        log.info(petsitterRepository.findPetsitterEntityByIdx(1L));
    }
}
