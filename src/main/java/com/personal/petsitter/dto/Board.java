package com.personal.petsitter.dto;

import com.querydsl.core.Tuple;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    @ToString
    @Getter
    @AllArgsConstructor
    public static class DetailInfo {
        private Long idx;
        private String title;
        private String writer;
        private String content;
        private LocalDateTime regDate;
        private LocalDateTime modDate;
        private String category;
        private List<String> pictures;
    }

    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private PageResultDTO<ListInfo> resultDTO;
    }

}
