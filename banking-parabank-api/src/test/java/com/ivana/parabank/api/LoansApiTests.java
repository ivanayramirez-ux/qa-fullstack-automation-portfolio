package com.ivana.parabank.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class LoansApiTests extends BaseApiTest {

    
    @Test
    public void requestLoan_shouldRedirectToHttps() {
        given()
            .queryParam("customerId", "12212")
            .queryParam("amount", "1000")
            .queryParam("downPayment", "100")
            .queryParam("fromAccountId", "12345")
        .when()
            .post("/requestLoan")
        .then()
            .statusCode(301)
            .header("Location",
                    containsString("https://parabank.parasoft.com/parabank/services/bank/requestLoan"));
    }

    
    @Test
    public void requestLoan_missingParameters_shouldStillRedirectToHttps() {
        given()
            .queryParam("customerId", "12212")
        .when()
            .post("/requestLoan")
        .then()
            .statusCode(301)
            .header("Location", containsString("/requestLoan"));
    }
}
