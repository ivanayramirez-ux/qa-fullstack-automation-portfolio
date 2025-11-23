package com.ivana.parabank.api;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class AccountsApiTests extends BaseApiTest {

 
    @Test(groups = "stable")
    public void parseAccountPayloads_shouldBeParseableJson() throws Exception {
        // src/main/resources/test-data/accountPayloads.json
        try (InputStream is = getClass().getClassLoader()
                .getResourceAsStream("test-data/accountPayloads.json")) {

            Assert.assertNotNull(is, "Fixture test-data/accountPayloads.json must exist on the classpath");

            String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            Assert.assertFalse(json.isEmpty(), "Fixture JSON should not be empty");

            JsonPath jsonPath = new JsonPath(json);
            Object root = jsonPath.get("$");
            Assert.assertNotNull(root, "Fixture JSON should be valid and parseable");
        }
    }

   
    @Test(
            groups = "live",
            enabled = false,
            description = "Hits live ParaBank accounts endpoint. Disabled because the demo server is unstable."
    )
    public void healthCheck_accountsEndpoint_live() {
        given()
                .when()
                .get("/services/bank/accounts/12345")
                .then()
                .statusCode(200);
    }
}
