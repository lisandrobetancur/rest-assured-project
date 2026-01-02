package com.co.api;

import static com.co.utils.VarSession.USER_TOKEN;
import static io.restassured.RestAssured.config;

import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

/** Base class for API interactions, providing common methods for making HTTP requests. */
public class BaseApi {
    protected static final String AUTH = "Cookie";

    /**
     * Returns a common {@link RequestSpecification} with default configurations.
     *
     * @return A {@link RequestSpecification} instance.
     */
    protected RequestSpecification getCommonRequestSpec() {
        return SerenityRest.given()
                .config(
                        config().objectMapperConfig(
                                        new ObjectMapperConfig(ObjectMapperType.JACKSON_2)))
                .contentType(ContentType.JSON)
                .log()
                .all();
    }

    /**
     * Returns a {@link RequestSpecification} with authentication headers.
     *
     * @return A {@link RequestSpecification} instance with authentication.
     */
    protected RequestSpecification getAuthRequestSpec() {
        return getCommonRequestSpec().header(AUTH, getUserToken());
    }

    /**
     * Sends a POST request without authentication.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param payload The request payload.
     * @return The {@link Response} from the API.
     */
    protected Response postWithOutAuth(String endpoint, Object payload) {
        return getCommonRequestSpec()
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Sends a POST request without authentication and without a payload.
     *
     * @param endpoint The API endpoint to send the request to.
     * @return The {@link Response} from the API.
     */
    protected Response postWithOutAuth(String endpoint) {
        return getCommonRequestSpec().when().post(endpoint).then().log().all().extract().response();
    }

    /**
     * Sends a POST request with authentication.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param payload The request payload.
     * @return The {@link Response} from the API.
     */
    protected Response postWithAuth(String endpoint, Object payload) {
        return getAuthRequestSpec()
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Sends a POST request with authentication and without a payload.
     *
     * @param endpoint The API endpoint to send the request to.
     * @return The {@link Response} from the API.
     */
    protected Response postWithAuth(String endpoint) {
        return getAuthRequestSpec().when().post(endpoint).then().log().all().extract().response();
    }

    /**
     * Sends a GET request without authentication.
     *
     * @param endpoint The API endpoint to send the request to.
     * @return The {@link Response} from the API.
     */
    protected Response getWithOutAuth(String endpoint) {
        return getCommonRequestSpec().when().get(endpoint).then().log().all().extract().response();
    }

    /**
     * Sends a GET request with authentication.
     *
     * @param endpoint The API endpoint to send the request to.
     * @return The {@link Response} from the API.
     */
    protected Response getWithAuth(String endpoint) {
        return getAuthRequestSpec().when().get(endpoint).then().log().all().extract().response();
    }

    /**
     * Sends a GET request with authentication and query parameters.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param queryParams A map of query parameters.
     * @return The {@link Response} from the API.
     */
    protected Response getWithAuthAndQueryParams(String endpoint, Map<String, Object> queryParams) {
        return getAuthRequestSpec()
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Sends a GET request without authentication and with query parameters.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param queryParams A map of query parameters.
     * @return The {@link Response} from the API.
     */
    protected Response getWithOutAuthAndQueryParams(
            String endpoint, Map<String, Object> queryParams) {
        return getCommonRequestSpec()
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Sends a GET request with authentication and a path parameter.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param value The path parameter value.
     * @return The {@link Response} from the API.
     */
    protected Response getWithAuthAndPathParam(String endpoint, Object value) {
        return getAuthRequestSpec()
                .queryParam("id", value)
                .when()
                .get(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Sends a GET request without authentication and with a path parameter.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param value The path parameter value.
     * @return The {@link Response} from the API.
     */
    protected Response getWithOutAuthAndPathParam(String endpoint, Object value) {
        return getCommonRequestSpec()
                .pathParam("id", value)
                .when()
                .get(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Sends a PUT request with authentication.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param payload The request payload.
     * @return The {@link Response} from the API.
     */
    protected Response putWithAuth(String endpoint, Object payload) {
        return getAuthRequestSpec()
                .body(payload)
                .when()
                .put(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Sends a PUT request with authentication and without a payload.
     *
     * @param endpoint The API endpoint to send the request to.
     * @return The {@link Response} from the API.
     */
    protected Response putWithAuth(String endpoint) {
        return getAuthRequestSpec().when().put(endpoint).then().log().all().extract().response();
    }

    /**
     * Sends a PUT request with authentication and a path parameter.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param payload The request payload.
     * @param value The path parameter value.
     * @return The {@link Response} from the API.
     */
    protected Response putWithAuthAndPathParam(String endpoint, Object payload, Object value) {
        return getAuthRequestSpec()
                .pathParam("id", value)
                .body(payload)
                .when()
                .put(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Sends a PATCH request with authentication.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param payload The request payload.
     * @return The {@link Response} from the API.
     */
    protected Response patchWithAuth(String endpoint, Object payload) {
        return getAuthRequestSpec()
                .body(payload)
                .when()
                .patch(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Sends a PATCH request with authentication and without a payload.
     *
     * @param endpoint The API endpoint to send the request to.
     * @return The {@link Response} from the API.
     */
    protected Response patchWithAuth(String endpoint) {
        return getAuthRequestSpec().when().patch(endpoint).then().log().all().extract().response();
    }

    /**
     * Sends a DELETE request with authentication.
     *
     * @param endpoint The API endpoint to send the request to.
     * @return The {@link Response} from the API.
     */
    protected Response deleteWithAuth(String endpoint) {
        return getAuthRequestSpec().when().delete(endpoint).then().log().all().extract().response();
    }

    /**
     * Sends a DELETE request with authentication and a path parameter.
     *
     * @param endpoint The API endpoint to send the request to.
     * @param value The path parameter value.
     * @return The {@link Response} from the API.
     */
    protected Response deleteWithAuthAndPathParam(String endpoint, Object value) {
        return getAuthRequestSpec()
                .pathParam("id", value)
                .when()
                .delete(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Returns the user token from the Serenity session.
     *
     * @return The user token.
     */
    private String getUserToken() {
        return "token=" + Serenity.sessionVariableCalled(USER_TOKEN.getValue());
    }
}
