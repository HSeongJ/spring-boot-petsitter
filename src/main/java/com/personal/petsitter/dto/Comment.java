package com.personal.petsitter.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class Comment {

    @Builder
    @ToString
    @Getter
    public static class Board {
        private Long idx;
        private String nickname;
        private String content;
        private LocalDateTime regDate;
        private LocalDateTime modDate;
    }


    @Getter
    @NoArgsConstructor
    public static class BoardWrite {
        private Long boardIdx;
        private String content;
    }

    @Builder
    @ToString
    @Getter
    @AllArgsConstructor
    public static class Petsitter {
        private Long idx;
        private String nickname;
        private String title;
        private String content;
        private Double rated;
        private LocalDateTime regDate;
        private LocalDateTime modDate;
    }

    @Builder
    @Getter
    public static class PetsitterWrite {
        private String petsitterName;
        private String cusNickname;
        private String title;
        private String content;
        private Double rated;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Product {
        private Long idx;
        private String nickname;
        private String title;
        private String content;
        private Double rated;
        private LocalDateTime regDate;
        private LocalDateTime modDate;
        private String picture;
    }

    @AllArgsConstructor
    @Getter
    public static class BoardResponse {
        private List<Board> resultDTO;
    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class PetsitterResponse {
        private PageResultDTO<Petsitter> resultDTO;
    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class ProductResponse {
        private PageResultDTO<Product> resultDTO;
    }
}
