package com.ivana.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ivana.orangehrm.pages.PIMPage;

import dev.failsafe.internal.util.Assert;

import com.ivana.core.utils.WaitUtils;
import com.ivana.orangehrm.pages.LeavePage;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pimMenu;

	@FindBy(xpath = "//span[text()='Leave']")
	private WebElement leaveMenu;

	public PIMPage goToPIM() {
		pimMenu.click();
		return new PIMPage(driver);
	}

	public LeavePage goToLeave() {
		leaveMenu.click();
		return new LeavePage(driver);
	}

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement userDropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutLink;

	public LoginPage logout() {
		click(userDropdown);
		WaitUtils.waitForClickable(driver, logoutLink, 5);
		click(logoutLink);
		return new LoginPage(driver);

	}

}
