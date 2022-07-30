package com.personal.petsitter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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

    public static class BoardWrite {
        private Long board_idx;
        private Long cus_idx;
        private String content;
    }

    @AllArgsConstructor
    @Getter
    public static class BoardResponse {
        private List<Board> resultDTO;
    }
}
