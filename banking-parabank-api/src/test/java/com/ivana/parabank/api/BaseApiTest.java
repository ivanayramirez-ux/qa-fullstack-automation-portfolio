package com.ivana.parabank.api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass
    public void setupApi() {

        
        RestAssured.baseURI = "http://parabank.parasoft.com";
        RestAssured.basePath = "/parabank/services/bank";

        
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
