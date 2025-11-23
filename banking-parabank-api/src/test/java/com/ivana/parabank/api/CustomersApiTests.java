package com.ivana.parabank.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CustomersApiTests extends BaseApiTest {

    
    @Test
    public void getCustomerById_shouldReturnCustomerDetails() {
        given()
            .when()
            .get("/customers/12212")
            .then()
            .statusCode(200)
            .and()
            .body("customer.id", equalTo("12212"))
            .body("customer.firstName", notNullValue())
            .body("customer.lastName", notNullValue());
    }

   
    @Test
    public void getCustomerAccounts_shouldReturnListOfAccounts() {
        given()
            .when()
            .get("/customers/12212/accounts")
            .then()
            .statusCode(200)
            .and()
            .body("accounts.account.size()", notNullValue());
    }
}
