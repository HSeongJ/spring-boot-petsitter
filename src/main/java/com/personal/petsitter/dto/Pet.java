package com.personal.petsitter.dto;

import com.personal.petsitter.entities.base.Gender;
import lombok.*;

public class Pet {

    @Builder
    @ToString
    @Getter
    public static class ListInfo {
        private Long petIdx;
        private String family;
        private String name;
        private Gender gender;
        private int age;
        private String picture;
    }


    @Getter
    @NoArgsConstructor
    public static class PetWrite {
        private String family;
        private String name;
        private Gender gender;
        private int age;
        private String picture;
    }
}
