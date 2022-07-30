package com.personal.petsitter.entities.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MAIL("남"),
    FEMAIL("여");

    private final String string;


}
