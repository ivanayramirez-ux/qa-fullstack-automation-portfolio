package com.ivana.core.api;

import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    private ApiUtils() {
    }

    public static RequestSpecification withXmlAccept(RequestSpecification req) {
        return req.header("Accept", "application/xml");
    }

    public static RequestSpecification withJsonAccept(RequestSpecification req) {
        return req.header("Accept", "application/json");
    }
}
