package com.personal.petsitter.dto;

import com.personal.petsitter.entities.base.Gender;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
        @NotBlank(message = "ID can't null")
        private String id;
        @NotBlank(message = "Password can't null")
        @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$")
        private String password;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SignUp {
        @NotBlank(message = "ID can't null")
        @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$")
        private String id;
        @NotBlank(message = "Password can't null")
        @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$")
        private String password;
        @NotBlank(message = "Name can't null")
        @Pattern(regexp = "^[a-zA-Z가-힣]{2,15}$")
        private String name;
        @NotBlank(message = "Nickname can't null")
        @Pattern(regexp = "^[a-z0-9_-]{3,15}$")
        private String nickname;
        private Gender gender;
        @Email
        private String email;
        @NotBlank(message = "Phonenumber can't null")
        private String phonenumber;
        @NotBlank(message = "Address can't null")
        private String address;
    }
}
