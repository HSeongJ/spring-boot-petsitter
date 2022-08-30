package com.personal.petsitter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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

    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private PageResultDTO<Product.ListInfo> resultDTO;
    }
}
