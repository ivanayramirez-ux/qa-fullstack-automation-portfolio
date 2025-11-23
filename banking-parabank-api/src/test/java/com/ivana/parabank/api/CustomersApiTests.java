package com.ivana.parabank.api;

import io.restassured.path.xml.XmlPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CustomersApiTests extends BaseApiTest {

    
    @Test(groups = "stable")
    public void parseCustomerXml_shouldExposeBasicFields() {
        String xml =
                "<customer>" +
                        "  <id>12212</id>" +
                        "  <firstName>John</firstName>" +
                        "  <lastName>Smith</lastName>" +
                        "</customer>";

        XmlPath xmlPath = new XmlPath(xml);

        Assert.assertEquals(xmlPath.getInt("customer.id"), 12212);
        Assert.assertEquals(xmlPath.getString("customer.firstName"), "John");
        Assert.assertEquals(xmlPath.getString("customer.lastName"), "Smith");
    }

    
    @Test(
            groups = "live",
            enabled = false,
            description = "Hits live ParaBank customer accounts endpoint. Disabled because the demo server is unstable."
    )
    public void getCustomerAccounts_live() {
        given()
                .when()
                .get("/services/bank/customers/12212/accounts")
                .then()
                .statusCode(200);
    }
}
