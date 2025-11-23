package com.ivana.core.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

    private RestClient() {
    }

    public static RequestSpecification givenBase(String baseUri) {
        return RestAssured
                .given()
                .baseUri(baseUri)
                .relaxedHTTPSValidation()
                .log().all();
    }

    public static Response get(RequestSpecification request, String path) {
        return request.when().get(path).then().log().all().extract().response();
    }

    public static Response post(RequestSpecification request, String path) {
        return request.when().post(path).then().log().all().extract().response();
    }
}
