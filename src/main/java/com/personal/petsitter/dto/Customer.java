package com.personal.petsitter.dto;

import com.personal.petsitter.entities.base.CustomerRole;
import com.personal.petsitter.entities.base.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

public class Customer {

    @Builder
    @ToString
    @Getter
    public static class Info {
        private Long customerIdx;
        private String id;
        private String password;
        private String name;
        private String nickname;
        private Gender gender;
        private String email;
        private String phonenumber;
        private String address;
        private String picture;
        private Set<CustomerRole> roleSet;
        private String state;
    }

}
