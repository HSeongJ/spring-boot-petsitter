package com.personal.petsitter.dto;

import lombok.*;

public class Board {

    @Builder
    @ToString
    @Getter
    @AllArgsConstructor
    public static class ListInfo {
        private Long idx;
        private String title;
        private String writer;
        private String picture;
        private Long commentCount;
    }

    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private PageResultDTO<ListInfo> resultDTO;
    }
}
