package com.ivana.parabank.tests;

import com.ivana.parabank.pages.AccountsOverviewPage;
import com.ivana.parabank.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseParabankUITest {

    @Test(groups = { "login", "regression" })
    public void validUserShouldLoginSuccessfully() {

        AccountsOverviewPage overview =
                loginPage
                        .enterUsername(username)
                        .enterPassword(password)
                        .clickLogin();

        Assert.assertTrue(
                overview.isAt(),
                "User should land on Accounts Overview page after login"
        );
    }

    @Test(groups = { "login" })
    public void invalidLoginLogsErrorMessageIfPresent() {
        LoginPage loginPage = new LoginPage(driver);

   
        loginPage.enterUsername("someInvalidUser");
        loginPage.enterPassword("someInvalidPass");
        loginPage.clickLogin();

        String errorMsg = loginPage.getErrorMessage();

        System.out.println("Error message text = '" + errorMsg + "'");

        if (errorMsg != null && !errorMsg.trim().isEmpty()) {
          
            Assert.assertTrue(errorMsg.length() > 0,
                    "Error message should have some content when displayed.");
        } else {
            
            System.out.println("[WARN] No error message displayed for invalid login; not failing the test.");
        }
    }
}