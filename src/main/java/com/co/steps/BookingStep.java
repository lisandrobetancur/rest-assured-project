package com.co.steps;

import static com.co.utils.Path.AUTH_PATH;
import static com.co.utils.Path.BOOKING_PATH_ID;
import static com.co.utils.SessionVariable.USER_TOKEN;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.co.model.request.AuthRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
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

        String token = SerenityRest.lastResponse().jsonPath().getString("token");

        Serenity.setSessionVariable(USER_TOKEN.getValue()).to(token);
    }

    @Step("Search for booking with ID {0}")
    public void searchBooking(int bookingId) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("id", bookingId)
                .log()
                .all()
                .when()
                .get(BOOKING_PATH_ID.getValue())
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
