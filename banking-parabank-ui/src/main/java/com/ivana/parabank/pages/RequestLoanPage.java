package com.ivana.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestLoanPage {

	private final WebDriver driver;

	private final By loanAmountInput = By.id("amount");
	private final By downPaymentInput = By.id("downPayment");
	private final By fromAccountSelect = By.id("fromAccountId");
	private final By applyNowButton = By.cssSelector("input[value='Apply Now']");
	private final By statusText = By.id("loanStatus");
	private final By loanProviderText = By.id("loanProviderName");

	private final By internalErrorMsg = By.xpath("//*[contains(text(),'An internal error has occurred')]");

	public RequestLoanPage(WebDriver driver) {
		this.driver = driver;
	}

	public RequestLoanPage enterLoanAmount(String amount) {
		driver.findElement(loanAmountInput).clear();
		driver.findElement(loanAmountInput).sendKeys(amount);
		return this;
	}

	public RequestLoanPage enterDownPayment(String amount) {
		driver.findElement(downPaymentInput).clear();
		driver.findElement(downPaymentInput).sendKeys(amount);
		return this;
	}

	public RequestLoanPage selectFromAccount(String accountId) {
		new Select(driver.findElement(fromAccountSelect)).selectByVisibleText(accountId);
		return this;
	}

	public RequestLoanPage clickApplyNow() {
		driver.findElement(applyNowButton).click();
		return this;
	}

	public String getLoanStatus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(statusText));

		return status.getText().trim();
	}

	public String getLoanProviderName() {
		return driver.findElement(loanProviderText).getText();
	}

	public boolean hasInternalError() {
		return !driver.findElements(internalErrorMsg).isEmpty();
	}
}
