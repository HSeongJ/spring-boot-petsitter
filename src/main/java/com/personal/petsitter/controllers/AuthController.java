package com.personal.petsitter.controllers;

import com.personal.petsitter.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomerService customerService;

    @GetMapping("/checkId")
    public Boolean checkExistId(String id) {
        return customerService.checkExistId(id);
    }

    @GetMapping("/checkNickname")
    public Boolean checkExistNickname(String nickname) {
        return customerService.checkExistNickname(nickname);
    }
}
