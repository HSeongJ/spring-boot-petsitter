package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.Petsitter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class PetsitterReservationServiceTests {

    @Autowired
    private PetsitterReservationServiceImpl service;

    @Test
    public void testInsertReservation () {
        Petsitter.ReservationRequest dto = Petsitter.ReservationRequest.builder()
                .petsitterIdx(1L)
                .cusIdx(1L)
                .startTime(LocalDateTime.parse("2022-09-14T16:00:00"))
                .endTime(LocalDateTime.parse("2022-09-14T20:00:00"))
                .price(100000)
                .build();

        service.insertReservation(dto);
    }

    @Test
    public void testGetReservation () {
        log.info(service.getReservation(1L));
    }
}
