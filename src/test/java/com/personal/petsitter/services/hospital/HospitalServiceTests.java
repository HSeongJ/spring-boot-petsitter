package com.personal.petsitter.services.hospital;

import com.personal.petsitter.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class HospitalServiceTests {

    @Autowired
    private HospitalService hospitalService;

    @Test
    public void testGetHospitalList() {
        PageRequestDTO dto = new PageRequestDTO();
        log.info(hospitalService.getHospitalList(dto).getResultDTO());
    }

    @Test
    public void testGetHospitalInfo() {
        log.info(hospitalService.getHospitalInfo(1L));
    }
}
