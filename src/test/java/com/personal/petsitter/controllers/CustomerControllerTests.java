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
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCustomerInfo() throws Exception {
        mockMvc.perform(
                        get("/customer/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void testUpdateCustomerPhonenumber() throws Exception {
        mockMvc.perform(
                post("/customer/update/phonenumber")
                        .param("customerIdx", "1")
                        .param("phonenumber", "01012341234"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetPetList() throws Exception {
        mockMvc.perform(
                get("/customer/pet/list/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testAddPetInfo() throws Exception {
        mockMvc.perform(
                        post("/customer/pet/add")
                                .param("customerIdx", "2")
                                .param("family", "mockAdd")
                                .param("name", "mockAdd")
                                .param("gender", "MAIL")
                                .param("age", "92")
                                .param("picture", "mockAdd"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testModifyPetInfo() throws Exception {
        mockMvc.perform(
                post("/customer/pet/update")
                        .param("petIdx", "1")
                        .param("customerIdx", "2")
                        .param("family", "mockChange")
                        .param("name", "mockChange")
                        .param("gender", "MAIL")
                        .param("age", "92")
                        .param("picture", "mockChange"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeletePet() throws Exception {
        mockMvc.perform(
                post("/customer/pet/delete")
                        .param("petIdx", "302"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
