package com.ivana.orangehrm.tests;

import com.ivana.core.config.ConfigManager;
import com.ivana.orangehrm.pages.DashboardPage;
import com.ivana.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMLoginTest extends BaseUITest {

	@Test(groups = { "smoke" })
	public void loginWithValidCredentials() {

		String username = ConfigManager.get("orangehrm.username");
		String password = ConfigManager.get("orangehrm.password");

		// driver comes from BaseUITest
		LoginPage loginPage = new LoginPage(driver);

		DashboardPage dashboard = loginPage.enterUsername(username).enterPassword(password).clickLogin();

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "User should be on Dashboard after login");

		dashboard.logout();
	}
}
