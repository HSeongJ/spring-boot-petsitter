package com.personal.petsitter.controllers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Log4j2
@AutoConfigureMockMvc
public class BoardControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetList() throws Exception {
        mockMvc.perform(
                get("/board/list"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetDetailInfo() throws Exception {
        mockMvc.perform(
                get("/board/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
