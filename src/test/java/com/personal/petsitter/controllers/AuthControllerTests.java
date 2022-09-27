package com.personal.petsitter.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Log4j2
@AutoConfigureMockMvc
public class AuthControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSignUp() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();

        map.put("id", "test4");
        map.put("password", "test4");
        map.put("name", "testName");
        map.put("nickname", "testNickname");
        map.put("gender", "MAIL");
        map.put("email", "test@gmail.com");
        map.put("phonenumber", "010-1234-1223");
        map.put("address", "fdasfdasfas");

        String requestBody = mapper.writeValueAsString(map);

        mockMvc.perform(post("/auth/signUp").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void testSignIn() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();

        map.put("id", "test4");
        map.put("password", "test4");

        String requestBody = mapper.writeValueAsString(map);

        mockMvc.perform(post("/auth/signIn").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
