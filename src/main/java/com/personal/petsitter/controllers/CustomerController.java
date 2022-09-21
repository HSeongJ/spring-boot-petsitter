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

    @PostMapping("/signin")
    public Customer.Info signIn(Customer.SignIn dto) {
        return customerService.signIn(dto);
    }

    @PostMapping("/signup")
    public String signUp(Customer.SignUp dto) {
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

    @PostMapping("/update/phonenumber")
    public String updatePhonenumber(Long cusIdx, String phonenumber) {
        return customerService.updatePhonenumber(cusIdx, phonenumber);
    }

    @PostMapping("/update/address")
    public String updateAddress(Long cusIdx, String address) {
        return customerService.updateAddress(cusIdx, address);
    }

    @GetMapping("/pet/list")
    public List<Pet.ListInfo> getPetList(Long idx) {
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

    @PostMapping("/pet/delete")
    public String deletePet(Long petIdx) {
        return customerPetService.deletePet(petIdx);
    }
}
