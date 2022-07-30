package com.personal.petsitter.dto;

import com.personal.petsitter.entities.hospital.HospitalEntity;
import lombok.*;

import java.util.List;

public class Hospital {

    @Builder
    @ToString
    @Getter
    public static class Info {
        private Long hospital_idx;
        private String name;
        private String content;
        private String openTime;
        private String closeTime;
        private String address;
        private String phonenumber;
        private List<String> pictures;
    }

    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private PageResultEntityToDTO<HospitalEntity, Info> resultDTO;
    }
}
