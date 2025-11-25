package com.ivana.parabank.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AccountsOverviewPage {

    private WebDriver driver;
    private By accountsTableRows = By.cssSelector("#accountTable tbody tr");
    private final By pageHeading = By.cssSelector("h1.title");

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isAt() {
        String headingText = driver.findElement(pageHeading).getText();
        return headingText != null && headingText.contains("Accounts Overview");
        
    }
    public List<String> getAccountIds() {
        List<WebElement> rows = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountsTableRows));

        return rows.stream()
                .map(row -> {
                    try {
                        
                        WebElement cell = row.findElement(By.cssSelector("td:first-child a, td:first-child"));
                        return cell.getText().trim();
                    } catch (NoSuchElementException e) {
                        return "";
                    }
                })
                .filter(id -> !id.isEmpty())
                .collect(Collectors.toList());
    }

    public TransferFundsPage goToTransferFunds() {
        driver.findElement(By.linkText("Transfer Funds")).click();
        return new TransferFundsPage(driver);
    }

    public OpenAccountPage goToOpenAccount() {
        driver.findElement(By.linkText("Open New Account")).click();
        return new OpenAccountPage(driver);
    }

    public RequestLoanPage goToRequestLoan() {
        driver.findElement(By.linkText("Request Loan")).click();
        return new RequestLoanPage(driver);
    }

	public String getHeaderTitle() {
		return null;
	}
}
