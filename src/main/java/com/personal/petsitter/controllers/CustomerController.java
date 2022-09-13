package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.services.customer.CustomerPetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerPetService customerPetService;

    @GetMapping("/pet/list/{customerIdx}")
    public List<Pet.ListInfo> getPetList(@PathVariable("customerIdx")Long idx) {
        return customerPetService.getPetListInfo(idx);
    }
}
