package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Hospital;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.services.hospital.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping("/list")
    public Hospital.ListResponse getList(PageRequestDTO dto) {
        return hospitalService.getHospitalList(dto);
    }

    @GetMapping("/info/{hospital_idx}")
    public Hospital.Info getInfo(@PathVariable("hospital_idx")Long idx) {
        return hospitalService.getHospitalInfo(idx);
    }
}
