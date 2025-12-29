package com.co.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Path {
    AUTH_PATH("auth"),
    BOOKING_PATH("booking");

    private final String value;
}
