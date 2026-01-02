package com.co.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/** Utility class for assertions. */
public final class AssertUtils {

    private AssertUtils() {}

    /**
     * Asserts that the actual status code is equal to the expected status code.
     *
     * @param actualStatusCode The actual status code.
     * @param expectedStatusCode The expected status code.
     */
    public static void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
        assertThat(actualStatusCode)
                .withFailMessage(
                        "Expected status code %s but got %s", expectedStatusCode, actualStatusCode)
                .isEqualTo(expectedStatusCode);
    }
}
