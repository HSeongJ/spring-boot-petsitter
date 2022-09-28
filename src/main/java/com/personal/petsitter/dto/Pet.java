package com.personal.petsitter.dto;

import com.personal.petsitter.entities.base.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
