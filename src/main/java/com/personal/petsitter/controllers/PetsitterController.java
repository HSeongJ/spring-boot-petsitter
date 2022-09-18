package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.Petsitter;
import com.personal.petsitter.services.petsitter.PetsitterReservationService;
import com.personal.petsitter.services.petsitter.PetsitterReviewService;
import com.personal.petsitter.services.petsitter.PetsitterService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petsitter")
@RequiredArgsConstructor
public class PetsitterController {

    private final PetsitterService petsitterService;

    private final PetsitterReservationService reservationService;

    private final PetsitterReviewService petsitterReviewService;

    @GetMapping("/list")
    public Petsitter.ListResponse getList(PageRequestDTO dto) {
        return petsitterService.getPetsitterList(dto);
    }

    @GetMapping("/info/{petsitterIdx}")
    public Petsitter.DetailInfo getInfo(@PathVariable("petsitterIdx")Long idx) {
        return petsitterService.getPetsitterInfo(idx);
    }

    @PostMapping("/reservation")
    public String petsitterReservation(Petsitter.ReservationRequest reservationInfo) {
        return reservationService.insertReservation(reservationInfo);
    }

    @GetMapping("/reservation/info")
    public List<Petsitter.ReservationResponse> getReservationList(Long customerIdx) {
        return reservationService.getReservation(customerIdx);
    }

    @GetMapping("/review")
    public Comment.PetsitterResponse getPetsitterReview(Long petsitterIdx, int page) {
        return petsitterReviewService.getPetsitterReview(petsitterIdx, page);
    }
}
