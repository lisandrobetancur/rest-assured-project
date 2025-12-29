package com.co.steps;

import static com.co.utils.Path.AUTH_PATH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.co.model.request.AuthRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class BookingStep {

    @Step("Login with username {0} and password {1}")
    public void login(String username, String password) {
        AuthRequest payload = AuthRequest.builder().username(username).password(password).build();

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(payload)
                .post(AUTH_PATH.getValue())
                .then()
                .log()
                .all()
                .extract()
                .response();

        int statusCode = SerenityRest.lastResponse().getStatusCode();

        assertThat(statusCode)
                .withFailMessage("Expected status code 200 but got %s", statusCode)
                .isEqualTo(200);
    }
}
