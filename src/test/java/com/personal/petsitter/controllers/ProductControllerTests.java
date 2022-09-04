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
public class ProductControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetList() throws Exception {
        mockMvc.perform(
                get("/product/list")
                        .param("page", "1")
                        .param("family", "family1")
                        .param("category", "category1")
                        .param("keyword", "e1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetDetail() throws Exception {
        mockMvc.perform(
                get("/product/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testAddCart() throws Exception {
        mockMvc.perform(
                post("/product/addCart")
                        .param("cus_idx", "1")
                        .param("product_idx", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetCartList() throws Exception {
        mockMvc.perform(
                get("/product/cartlist")
                        .param("cus_idx", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
