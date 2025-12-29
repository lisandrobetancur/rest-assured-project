package com.co.stepdefinitions;

import io.restassured.RestAssured;
import java.util.concurrent.atomic.AtomicReference;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.jupiter.api.BeforeAll;

public class Hook {

    private static EnvironmentVariables environmentVariables;

    @BeforeAll
    static void setupConfig() {

        AtomicReference<String> path =
                new AtomicReference<>(
                        environmentVariables
                                .optionalProperty("restassured.base.uri")
                                .orElseThrow(
                                        () ->
                                                new RuntimeException(
                                                        "URI not found in serenity.conf")));

        RestAssured.baseURI = path.get();
        System.out.println("DEBUG: Testing on -> " + RestAssured.baseURI);
    }
}
