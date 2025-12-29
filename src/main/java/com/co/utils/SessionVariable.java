package com.co.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SessionVariable {
    USER_TOKEN("token");

    private final String value;
}
