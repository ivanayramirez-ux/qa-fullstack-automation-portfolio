package com.ivana.parabank.api;

import io.restassured.path.xml.XmlPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoansApiTests extends BaseApiTest {

    
    @Test(groups = "stable")
    public void parseLoanResponseXml_shouldExposeApprovedFlagAndMessage() {
        String xml =
                "<loanResponse>" +
                        "  <approved>true</approved>" +
                        "  <message>Loan approved for testing</message>" +
                        "</loanResponse>";

        XmlPath xmlPath = new XmlPath(xml);

        Assert.assertTrue(xmlPath.getBoolean("loanResponse.approved"));
        Assert.assertEquals(xmlPath.getString("loanResponse.message"), "Loan approved for testing");
    }

    
    @Test(
            groups = "live",
            enabled = false,
            description = "Hits live ParaBank loan request endpoint. Disabled because the demo server is unstable."
    )
    public void requestLoan_live() {
        given()
                .queryParam("customerId", "12212")
                .queryParam("amount", "1000")
                .queryParam("downPayment", "100")
                .queryParam("fromAccountId", "12345")
                .when()
                .post("/services/bank/requestLoan")
                .then()
                .statusCode(200);
    }
}
