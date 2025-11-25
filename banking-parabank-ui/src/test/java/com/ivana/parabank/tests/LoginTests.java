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
    public void invalidUserShouldSeeErrorMessage() {

        loginPage
                .enterUsername("wrongUser")
                .enterPassword("wrongPass")
                .clickLogin();

        String errorText = loginPage.getErrorMessage();
        Assert.assertNotNull(errorText, "Error message should be displayed");
        Assert.assertFalse(errorText.trim().isEmpty(), "Error message should not be empty");
    }
}
