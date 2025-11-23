package com.ivana.parabank.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AccountsApiTests extends BaseApiTest {

    @Test
    public void healthCheck_accountsEndpoint_shouldReturnStatusCode() {
        given()
            .when()
            .get("/accounts/12345")
            .then()
            .statusCode(200);
    }
}
