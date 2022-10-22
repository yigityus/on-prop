package com.example.onprop.model;

import lombok.Getter;

public enum CanKlusterType {
    LOCAL("local"), REMOTE("remote");

    @Getter
    private final String code;

    CanKlusterType(String code) {
        this.code = code;
    }
}
