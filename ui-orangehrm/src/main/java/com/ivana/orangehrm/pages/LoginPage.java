package com.ivana.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ivana.orangehrm.pages.DashboardPage;

public class LoginPage {
	
	

    private WebDriver driver;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton   = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public DashboardPage clickLogin() {
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }
}
