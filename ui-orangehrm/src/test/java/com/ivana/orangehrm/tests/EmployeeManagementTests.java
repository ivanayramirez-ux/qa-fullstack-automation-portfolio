package com.ivana.orangehrm.tests;

import com.ivana.core.config.ConfigManager;
import com.ivana.orangehrm.pages.DashboardPage;
import com.ivana.orangehrm.pages.LoginPage;
import com.ivana.orangehrm.pages.PIMPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class EmployeeManagementTests extends BaseUITest {

	@Test(groups = { "smoke", "pim" })
	public void addNewEmployeeFromPIM() {

		String username = ConfigManager.get("orangehrm.username");
		String password = ConfigManager.get("orangehrm.password");

		// login
		LoginPage loginPage = new LoginPage(driver);

		DashboardPage dashboard = loginPage.enterUsername(username).enterPassword(password).clickLogin();

		// navigate to PIM and create employee
		PIMPage pimPage = dashboard.goToPIM();

		pimPage.clickAddEmployee().enterFirstName("Ivana").enterLastName("Automation").saveEmployee();
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("pim"),
				"After saving employee we should stay on a PIM page");
	}
}
