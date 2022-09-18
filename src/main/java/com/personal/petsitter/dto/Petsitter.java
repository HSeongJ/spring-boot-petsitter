package com.personal.petsitter.dto;

import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public class Petsitter {

    @Builder
    @ToString
    @Getter
    public static class ListInfo {
        private Long petsitterIdx;
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
        private Long petsitterIdx;
        private String name;
        private String content;
        private String career;
        private int price;
        private String family;
        private String category;
        private Double avgRated;
        private List<String> pictures;
    }

    @Builder
    @Getter
    public static class ReservationRequest {
        private Long petsitterIdx;
        private Long customerIdx;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime startTime;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime endTime;

        private Integer price;
    }

    @Builder
    @ToString
    @Getter
    public static class ReservationResponse {
        private Long petresIdx;
        private Long customerIdx;
        private String petsitterName;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private Integer price;
        private String payState;
    }

    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private PageResultEntityToDTO<PetsitterEntity, ListInfo> resultDTO;
    }
}
