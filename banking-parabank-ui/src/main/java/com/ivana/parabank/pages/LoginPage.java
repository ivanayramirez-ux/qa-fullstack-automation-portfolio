package com.ivana.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("input[type='submit']");
    private final By errorMessage  = By.cssSelector(".error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public AccountsOverviewPage clickLogin() {
        driver.findElement(loginButton).click();
        return new AccountsOverviewPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}