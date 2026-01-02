package com.co.stepdefinitions.hooks;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import java.util.concurrent.atomic.AtomicReference;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Global setup for the test suite. */
public class GlobalSetup {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalSetup.class);
    private static final String BASE_URL_PROPERTY = "baseurl";

    /** Sets up the test suite before any tests are run. */
    @BeforeAll
    public static void setup() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

        AtomicReference<String> baseUrl =
                new AtomicReference<>(
                        EnvironmentSpecificConfiguration.from(variables)
                                .getOptionalProperty(BASE_URL_PROPERTY)
                                .orElseThrow(
                                        () ->
                                                new IllegalStateException(
                                                        String.format(
                                                                "Failed to initialize test suite: Property '%s' is not defined in serenity.conf for the current environment.",
                                                                BASE_URL_PROPERTY))));

        RestAssured.baseURI = baseUrl.get();

        LOGGER.info("-------------------------------------------------------");
        LOGGER.info("Configuration Initialized");
        LOGGER.info("Target Base URI: {}", RestAssured.baseURI);
        LOGGER.info("-------------------------------------------------------");
    }
}
