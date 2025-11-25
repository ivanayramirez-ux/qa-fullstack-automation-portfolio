package com.ivana.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TransferFundsPage {

    private final WebDriver driver;

    private final By amountInput       = By.id("amount");
    private final By fromAccountSelect = By.id("fromAccountId");
    private final By toAccountSelect   = By.id("toAccountId");
    private final By transferButton    = By.cssSelector("input[value='Transfer']");
    private final By successMessage    = By.cssSelector("#rightPanel .title");

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    public TransferFundsPage enterAmount(String amount) {
        driver.findElement(amountInput).clear();
        driver.findElement(amountInput).sendKeys(amount);
        return this;
    }

    private Select waitForSelectWithOptions(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(d -> {
            Select select = new Select(d.findElement(locator));
            return (select.getOptions().size() > 0) ? select : null;
        });
    }

    public TransferFundsPage selectFromAccount(String accountId) {
        Select select = waitForSelectWithOptions(fromAccountSelect);
        List<WebElement> options = select.getOptions();

        boolean found = false;

        for (WebElement option : options) {
            String text = option.getText().trim();
            if (text.contains(accountId)) {
                select.selectByVisibleText(text);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new RuntimeException(
                    "FROM account " + accountId + " not found. Options: " +
                    options.stream().map(o -> o.getText().trim()).collect(Collectors.toList())
            );
        }

        return this;
    }

    public TransferFundsPage selectToAccount(String accountId) {
        Select select = waitForSelectWithOptions(toAccountSelect);
        List<WebElement> options = select.getOptions();

        boolean found = false;

        for (WebElement option : options) {
            String text = option.getText().trim();
            if (text.contains(accountId)) {
                select.selectByVisibleText(text);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new RuntimeException(
                    "TO account " + accountId + " not found. Options: " +
                    options.stream().map(o -> o.getText().trim()).collect(Collectors.toList())
            );
        }

        return this;
    }

    public TransferFundsPage clickTransfer() {
        driver.findElement(transferButton).click();
        return this;
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        );
        return title.getText().trim();
    }

    public String getConfirmationMessage() {
        return getSuccessMessage();
    }
}
