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

public class BaseApi {
    protected static final String AUTH = "Cookie";

    protected RequestSpecification getCommonRequestSpec() {
        return SerenityRest.given()
                .config(
                        config().objectMapperConfig(
                                        new ObjectMapperConfig(ObjectMapperType.JACKSON_2)))
                .contentType(ContentType.JSON)
                .log()
                .all();
    }

    protected RequestSpecification getAuthRequestSpec() {
        return getCommonRequestSpec().header(AUTH, getUserToken());
    }

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

    protected Response postWithOutAuth(String endpoint) {
        return getCommonRequestSpec().when().post(endpoint).then().log().all().extract().response();
    }

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

    protected Response postWithAuth(String endpoint) {
        return getAuthRequestSpec().when().post(endpoint).then().log().all().extract().response();
    }

    protected Response getWithOutAuth(String endpoint) {
        return getCommonRequestSpec().when().get(endpoint).then().log().all().extract().response();
    }

    protected Response getWithAuth(String endpoint) {
        return getAuthRequestSpec().when().get(endpoint).then().log().all().extract().response();
    }

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

    protected Response putWithAuth(String endpoint) {
        return getAuthRequestSpec().when().put(endpoint).then().log().all().extract().response();
    }

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

    protected Response patchWithAuth(String endpoint) {
        return getAuthRequestSpec().when().patch(endpoint).then().log().all().extract().response();
    }

    protected Response deleteWithAuth(String endpoint) {
        return getAuthRequestSpec().when().delete(endpoint).then().log().all().extract().response();
    }

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

    private String getUserToken() {
        return "token=" + Serenity.sessionVariableCalled(USER_TOKEN.getValue());
    }
}
