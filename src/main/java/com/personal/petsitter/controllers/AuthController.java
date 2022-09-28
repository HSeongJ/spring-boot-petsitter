package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.dto.JwtAuthenticationResponseDTO;
import com.personal.petsitter.security.JwtTokenProvider;
import com.personal.petsitter.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomerService customerService;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponseDTO> authenticateCustomer(
            @Valid @RequestBody Customer.SignIn dto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getId(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        return new ResponseEntity<>(new JwtAuthenticationResponseDTO(jwt), HttpStatus.OK);
    }

    @PostMapping(value = "/signUp", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> signUp(@Valid @RequestBody Customer.SignUp dto) {
        return customerService.signUp(dto);
    }

    @PostMapping("/checkId")
    public Boolean checkExistId(String id) {
        return customerService.checkExistId(id);
    }

    @PostMapping("/checkNickname")
    public Boolean checkExistNickname(String nickname) {
        return customerService.checkExistNickname(nickname);
    }
}
