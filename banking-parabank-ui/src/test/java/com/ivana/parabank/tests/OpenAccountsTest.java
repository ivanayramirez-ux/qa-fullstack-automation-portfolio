package com.ivana.parabank.tests;

import com.ivana.parabank.pages.AccountsOverviewPage;
import com.ivana.parabank.pages.LoginPage;
import com.ivana.parabank.pages.OpenAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OpenAccountsTest extends BaseParabankUITest {

	@Test(groups = { "open-account", "regression" })
	public void openNewSavingsAccount() {
		LoginPage loginPage = new LoginPage(driver);

		AccountsOverviewPage overview = loginPage.enterUsername(username).enterPassword(password).clickLogin();

		List<String> existingAccounts = overview.getAccountIds();
		Assert.assertFalse(existingAccounts.isEmpty(), "User should have at least one existing account");

		OpenAccountPage openAccountPage = overview.goToOpenAccount();

		List<String> dropdownAccounts = openAccountPage.getFromAccountOptions();
		Assert.assertFalse(dropdownAccounts.isEmpty(), "Dropdown should have at least one account option");

		String accountToUse = dropdownAccounts.get(0);

		openAccountPage.selectAccountType("SAVINGS").selectFromAccount(accountToUse).clickOpenNewAccount();

		String newAccountId = openAccountPage.getNewAccountId();
		Assert.assertNotNull(newAccountId, "New account ID should be displayed");
		Assert.assertFalse(newAccountId.isEmpty(), "New account ID should not be empty");

		driver.navigate().to(baseUrl + "/overview.htm");
		AccountsOverviewPage refreshed = new AccountsOverviewPage(driver);
		List<String> updatedAccounts = refreshed.getAccountIds();

		Assert.assertTrue(updatedAccounts.contains(newAccountId),
				"Newly created account should appear in Accounts Overview");
	}
}
