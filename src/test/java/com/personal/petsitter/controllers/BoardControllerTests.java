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

    @Test
    public void testInsertBoard() throws Exception {
        mockMvc.perform(
                post("/board/insert")
                        .param("idx", "3")
                        .param("title", "mockTest")
                        .param("content", "mockTest")
                        .param("category", "mockTest")
                        .param("picture1", "mockTest1")
                        .param("picture2", "mockTest2")
                        .param("picture3", "mockTest3"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetCommentList() throws Exception {
        mockMvc.perform(
                get("/board/comment/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testInsertComment() throws Exception {
        mockMvc.perform(
                post("/board/comment/insert")
                        .param("boardIdx", "1")
                        .param("cusIdx", "1")
                        .param("content", "mockTest"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
