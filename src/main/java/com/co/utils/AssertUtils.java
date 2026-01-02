package com.co.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class AssertUtils {

    private AssertUtils() {}

    public static void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
        assertThat(actualStatusCode)
                .withFailMessage(
                        "Expected status code %s but got %s", expectedStatusCode, actualStatusCode)
                .isEqualTo(expectedStatusCode);
    }
}
