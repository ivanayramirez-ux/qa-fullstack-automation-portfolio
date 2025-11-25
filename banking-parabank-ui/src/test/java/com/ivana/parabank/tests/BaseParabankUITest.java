package com.ivana.parabank.tests;

import com.ivana.core.config.ConfigManager;
import com.ivana.core.drivers.DriverFactory;
import com.ivana.parabank.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseParabankUITest {

    protected WebDriver driver;
    protected String baseUrl;
    protected String username;
    protected String password;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();

        
        baseUrl = ConfigManager.get("parabank.baseUrl");
        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            baseUrl = "https://parabank.parasoft.com/parabank";
        }

        
        username = ConfigManager.get("parabank.username");
        password = ConfigManager.get("parabank.password");

        
        if (username == null || username.trim().isEmpty()) {
            username = "john";
        }
        if (password == null || password.trim().isEmpty()) {
            password = "demo";
        }

        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
