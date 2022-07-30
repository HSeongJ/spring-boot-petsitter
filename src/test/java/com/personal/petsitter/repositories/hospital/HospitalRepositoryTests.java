package com.personal.petsitter.repositories.hospital;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.entities.hospital.HospitalEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.time.LocalTime;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class HospitalRepositoryTests {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            HospitalEntity entity = HospitalEntity.builder()
                    .name("testName" + i)
                    .content("testContent" + i)
                    .openTime(LocalTime.now())
                    .closeTime(LocalTime.now())
                    .address("testAddress" + i)
                    .phonenumber("testPhonenumber" + i)
                    .build();

            hospitalRepository.save(entity);
        });
    }

    @Test
    public void testGetHospitalEntityList() {
        PageRequestDTO dto = new PageRequestDTO();
        Page<HospitalEntity> results = hospitalRepository
                .getHospitalEntityList(dto.getPageable(Sort.by("idx").descending()));

        results.get().forEach(result -> {
            log.info(result.toString());
        });
    }

    @Test
    public void testGetHospitalInfo() {
        log.info(hospitalRepository.findHospitalEntityByIdx(1L));
    }
}
