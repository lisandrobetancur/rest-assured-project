package com.co.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Enum representing API paths. */
@Getter
@AllArgsConstructor
public enum Path {
    AUTH_PATH("auth"),
    BOOKING_PATH("booking"),
    BOOKING_PATH_ID("/booking/{id}");

    private final String value;
}
