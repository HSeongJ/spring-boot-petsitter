package com.personal.petsitter.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @Setter
    @Getter
    @NoArgsConstructor
    public static class InsertInfo {
        @NotBlank(message = "Title can't null")
        @Size(max=500, message = "The maximum length of the title is 500 characters.")
        private String title;
        @Size(max=1000, message = "The maximum length of the content is 1000 characters.")
        private String content;
        private String category;
        private String picture1;
        private String picture2;
        private String picture3;
        private String picture4;
        private String picture5;
    }


    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private PageResultDTO<ListInfo> resultDTO;
    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class InsertResponse {
        private String result;
    }
}
