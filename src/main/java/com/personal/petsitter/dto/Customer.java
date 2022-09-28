package com.personal.petsitter.dto;

import com.personal.petsitter.entities.base.Gender;
import lombok.*;

public class Customer {
    @Builder
    @ToString
    @Getter
    public static class Info {
        private String id;
        private String name;
        private String nickname;
        private Gender gender;
        private String email;
        private String phonenumber;
        private String address;
        private String picture;
    }

    @Getter
    @Setter
    public static class SignIn {
        private String id;
        private String password;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SignUp {
        private String id;
        private String password;
        private String name;
        private String nickname;
        private Gender gender;
        private String email;
        private String phonenumber;
        private String address;
    }
}
