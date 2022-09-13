package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.services.customer.CustomerPetService;
import com.personal.petsitter.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerPetService customerPetService;
    private final CustomerService customerService;

    @GetMapping("/{customerIdx}")
    public Customer.Info getCustomerInfo(@PathVariable("customerIdx")Long idx) {
        return customerService.getCustomerInfo(idx);
    }

    @GetMapping("/pet/list/{customerIdx}")
    public List<Pet.ListInfo> getPetList(@PathVariable("customerIdx")Long idx) {
        return customerPetService.getPetListInfo(idx);
    }

    @PostMapping("/pet/add")
    public String addPet(Pet.PetWrite dto) {
        return customerPetService.addPet(dto);
    }

    @PostMapping("/pet/update")
    public String modifyPetInfo(Pet.PetWrite dto) {
        return customerPetService.modifyPetInfo(dto);
    }
}
