package com.co.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VarSession {
    USER_TOKEN("token");

    private final String value;
}
