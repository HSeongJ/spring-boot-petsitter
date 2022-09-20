package com.personal.petsitter.dto;

import com.personal.petsitter.entities.base.CustomerRole;
import com.personal.petsitter.entities.base.Gender;
import lombok.*;

import java.util.Set;

public class Customer {

    @Builder
    @ToString
    @Getter
    public static class Info {
        private Long customerIdx;
        private String id;
        private String name;
        private String nickname;
        private Gender gender;
        private String email;
        private String phonenumber;
        private String address;
        private String picture;
        private Set<CustomerRole> roleSet;
    }

    @Getter
    @Setter
    public static class SignIn {
        private String id;
        private String password;
    }

    @Getter
    @Setter
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
