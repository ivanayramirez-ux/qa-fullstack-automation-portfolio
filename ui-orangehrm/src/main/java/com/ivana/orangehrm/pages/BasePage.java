package com.ivana.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for all OrangeHRM pages. Provides driver and PageFactory
 * initialization.
 */
public class BasePage {

	protected WebDriver driver;
	protected void click(WebElement element) { element.click(); }

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
}
