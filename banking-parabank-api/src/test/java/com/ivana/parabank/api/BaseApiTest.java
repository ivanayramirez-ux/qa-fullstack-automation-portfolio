package com.ivana.parabank.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public abstract class BaseApiTest {

    protected static final String BASE_URI = "http://parabank.parasoft.com/parabank";

    @BeforeClass(alwaysRun = true)
    public void configureRestAssured() {
        RestAssured.baseURI = BASE_URI;
    }
}
