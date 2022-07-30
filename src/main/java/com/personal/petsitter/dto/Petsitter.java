package com.personal.petsitter.dto;

import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class Petsitter {

    @Builder
    @ToString
    @Getter
    public static class ListInfo {
        private Long petsitter_idx;
        private String name;
        private String content;
        private String career;
        private int price;
        private String category;
        private Double avgRated;
        private List<String> pictures;
    }

    @Builder
    @ToString
    @Getter
    public static class DetailInfo {
        private Long petsitter_idx;
        private String name;
        private String content;
        private String career;
        private int price;
        private String family;
        private String category;
        private Double avgRated;
        private List<String> pictures;
    }

    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private PageResultEntityToDTO<PetsitterEntity, ListInfo> resultDTO;
    }
}
