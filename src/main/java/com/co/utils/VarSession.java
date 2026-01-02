package com.co.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Enum representing Serenity session variables. */
@Getter
@AllArgsConstructor
public enum VarSession {
    USER_TOKEN("token");

    private final String value;
}
