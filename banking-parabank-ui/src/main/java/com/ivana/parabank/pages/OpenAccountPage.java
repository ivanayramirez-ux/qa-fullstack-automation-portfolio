package com.ivana.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class OpenAccountPage {

    private final WebDriver driver;

    private final By accountTypeSelect = By.id("type");
    private final By fromAccountSelect = By.id("fromAccountId");
    private final By openNewAccountBtn = By.cssSelector("input[value='Open New Account']");
    private final By newAccountIdLink  = By.id("newAccountId");

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

   
    public OpenAccountPage selectAccountType(String visibleText) {
        Select select = new Select(driver.findElement(accountTypeSelect));
        select.selectByVisibleText(visibleText);
        return this;
    }

   
    private Select waitForSelectWithOptions(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(d -> {
            Select select = new Select(d.findElement(locator));
            return select.getOptions().isEmpty() ? null : select;
        });
    }

    
    public OpenAccountPage selectFromAccount(String accountId) {

        Select select = waitForSelectWithOptions(fromAccountSelect);
        List<WebElement> options = select.getOptions();

        List<String> texts = options.stream()
                .map(o -> o.getText().trim())
                .collect(Collectors.toList());

        System.out.println("FROM dropdown options on OpenAccount page: " + texts);
        System.out.println("Trying to select accountId: " + accountId);

        for (String text : texts) {
            if (text.contains(accountId)) {
                select.selectByVisibleText(text);
                return this;
            }
        }

        throw new RuntimeException(
                "Account " + accountId + " not found in FROM dropdown. Options were: " + texts
        );
    }

    
    public List<String> getFromAccountOptions() {
        Select select = waitForSelectWithOptions(fromAccountSelect);
        return select.getOptions()
                .stream()
                .map(o -> o.getText().trim())
                .collect(Collectors.toList());
    }

    public OpenAccountPage clickOpenNewAccount() {
        driver.findElement(openNewAccountBtn).click();
        return this;
    }

    public String getNewAccountId() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(
                ExpectedConditions.visibilityOfElementLocated(newAccountIdLink)
        );
        return link.getText().trim();
    }
}
