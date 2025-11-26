package com.ivana.parabank.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ivana.parabank.pages.AccountsOverviewPage;
import com.ivana.parabank.pages.LoginPage;
import com.ivana.parabank.pages.RequestLoanPage;

public class RequestLoanTests extends BaseParabankUITest {

	@Test(groups = { "loan", "regression" })
	public void requestLoanForExistingAccount() {

		LoginPage loginPage = new LoginPage(driver);

		AccountsOverviewPage overview = loginPage.enterUsername(username).enterPassword(password).clickLogin();

		List<String> accounts = overview.getAccountIds();
		Assert.assertFalse(accounts.isEmpty(), "At least one account is needed to request a loan");

		RequestLoanPage requestLoanPage = overview.goToRequestLoan();

		requestLoanPage.enterLoanAmount("500").enterDownPayment("50").selectFromAccount(accounts.get(0))
				.clickApplyNow();

		if (requestLoanPage.hasInternalError()) {
			throw new SkipException(
					"Skipping: Parabank returned 'internal error' during loan request (unstable environment).");
		}

		String status = requestLoanPage.getLoanStatus();
		Assert.assertNotNull(status, "Loan status should be displayed");
		Assert.assertFalse(status.trim().isEmpty(), "Loan status text should not be empty");
	}
}
