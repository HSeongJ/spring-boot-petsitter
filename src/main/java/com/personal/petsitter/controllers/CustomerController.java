package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Customer;
import com.personal.petsitter.dto.Pet;
import com.personal.petsitter.security.CurrentMember;
import com.personal.petsitter.security.CustomerPrincipal;
import com.personal.petsitter.services.customer.CustomerPetService;
import com.personal.petsitter.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PutMapping("/update/phonenumber")
    public String updatePhonenumber(@CurrentMember CustomerPrincipal customer, @RequestBody String phonenumber) {
        System.out.println(phonenumber);
        return customerService.updatePhonenumber(customer.getIdx(), phonenumber);
    }

    @PutMapping("/update/address")
    public String updateAddress(@CurrentMember CustomerPrincipal customer, @RequestBody String address) {
        return customerService.updateAddress(customer.getIdx(), address);
    }

    @GetMapping("/pet/list")
    public List<Pet.ListInfo> getPetList(@CurrentMember CustomerPrincipal customer) {
        return customerPetService.getPetListInfo(customer.getIdx());
    }

    @PostMapping(value = "/pet/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String addPet(@CurrentMember CustomerPrincipal customer, @Valid @RequestBody Pet.PetWrite dto) {
        System.out.println(dto.getName());
        return customerPetService.addPet(customer.getIdx(), dto);
    }

    @PutMapping(value = "/pet/update", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String modifyPetInfo(@CurrentMember CustomerPrincipal customer, @Valid @RequestBody Pet.PetWrite dto) {
        return customerPetService.modifyPetInfo(customer.getIdx(), dto);
    }

    @DeleteMapping("/pet/delete")
    public String deletePet(Long petIdx) {
        return customerPetService.deletePet(petIdx);
    }
}
