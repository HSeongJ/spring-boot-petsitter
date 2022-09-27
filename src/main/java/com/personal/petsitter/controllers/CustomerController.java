package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.security.CurrentMember;
import com.personal.petsitter.security.CustomerPrincipal;
import com.personal.petsitter.services.customer.CustomerPetService;
import com.personal.petsitter.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerPetService customerPetService;
    private final CustomerService customerService;

    @GetMapping("/info")
    public ResponseEntity<Customer.Info> getCustomerInfo(@CurrentMember CustomerPrincipal customer) {
        return new ResponseEntity<>(customerService.showInfo(customer), HttpStatus.OK);
    }

    @PostMapping("/update/phonenumber")
    public String updatePhonenumber(@CurrentMember CustomerPrincipal customer, String phonenumber) {
        return customerService.updatePhonenumber(customer.getIdx(), phonenumber);
    }

    @PostMapping("/update/address")
    public String updateAddress(@CurrentMember CustomerPrincipal customer, String address) {
        return customerService.updateAddress(customer.getIdx(), address);
    }

    @GetMapping("/pet/list")
    public List<Pet.ListInfo> getPetList(@CurrentMember CustomerPrincipal customer) {
        return customerPetService.getPetListInfo(customer.getIdx());
    }

    @PostMapping("/pet/add")
    public String addPet(@CurrentMember CustomerPrincipal customer, Pet.PetWrite dto) {
        return customerPetService.addPet(customer.getIdx(), dto);
    }

    @PostMapping("/pet/update")
    public String modifyPetInfo(@CurrentMember CustomerPrincipal customer, Pet.PetWrite dto) {
        return customerPetService.modifyPetInfo(customer.getIdx(), dto);
    }

    @PostMapping("/pet/delete")
    public String deletePet(Long petIdx) {
        return customerPetService.deletePet(petIdx);
    }
}
