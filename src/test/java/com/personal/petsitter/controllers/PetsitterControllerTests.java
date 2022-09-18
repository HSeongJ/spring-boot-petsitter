package com.personal.petsitter.controllers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Log4j2
@AutoConfigureMockMvc
public class PetsitterControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetList() throws Exception {
        mockMvc.perform(
                        get("/petsitter/list")
                                .param("page", "1")
                                .param("category", "expert")
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetInfo() throws Exception {
        mockMvc.perform(
                        get("/petsitter/info/1")
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testReservationPetsitter() throws Exception {
        mockMvc.perform(
                post("/petsitter/reservation")
                        .param("petsitterIdx", "1")
                        .param("cusIdx", "1")
                        .param("price", "10000")
                        .param("startTime", "2022-09-14T16:00:00")
                        .param("endTime", "2022-09-14T20:00:00")
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetReservationList() throws Exception {
        mockMvc.perform(
                get("/petsitter/reservation/info")
                        .param("cusIdx", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetPetsitterReview() throws Exception {
        mockMvc.perform(
                get("/petsitter/review")
                        .param("petsitter_idx", "1")
                        .param("page", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
