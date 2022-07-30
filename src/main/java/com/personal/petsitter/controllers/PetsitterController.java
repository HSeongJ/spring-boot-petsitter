package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.Petsitter;
import com.personal.petsitter.services.petsitter.PetsitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/petsitter")
@RequiredArgsConstructor
public class PetsitterController {

    private final PetsitterService petsitterService;

    @GetMapping("/list")
    public Petsitter.ListResponse getList(PageRequestDTO dto) {
        return petsitterService.getPetsitterList(dto);
    }

    @GetMapping("/info/{petsitter_idx}")
    public Petsitter.DetailInfo getInfo(@PathVariable("petsitter_idx")Long idx) {
        return petsitterService.getPetsitterInfo(idx);
    }
}
