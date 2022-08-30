package com.personal.petsitter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

public class Product {

    @Builder
    @ToString
    @Getter
    @AllArgsConstructor
    public static class ListInfo {
        private Long idx;
        private String family;
        private String title;
        private String content;
        private String picture;
        private Double avg_rated;
    }

    @Builder
    @ToString
    @Getter
    @AllArgsConstructor
    public static class DetailInfo {
        private Long idx;
        private String title;
        private String content;
        private String category;
        private String family;
        private Double avgRated;
        private int price;
        private LocalDateTime regDate;
        private LocalDateTime modDate;
        private List<String> pictures;
    }

    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private PageResultDTO<Product.ListInfo> resultDTO;
    }
}
