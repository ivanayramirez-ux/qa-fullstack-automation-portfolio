package com.ivana.orangehrm.tests;

import com.ivana.core.config.ConfigManager;
import com.ivana.orangehrm.pages.DashboardPage;
import com.ivana.orangehrm.pages.LeavePage;
import com.ivana.orangehrm.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LeaveRequestTests extends BaseUITest {

	@Test(groups = {"leave", "regression"})
    public void submitLeaveRequest() {

        String username = ConfigManager.get("orangehrm.username");
        String password = ConfigManager.get("orangehrm.password");

        // login
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboard = loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();

        // navigate to Leave
        LeavePage leavePage = dashboard.goToLeave();

        // actions on Leave page
        leavePage
                .openApplyLeave()
                .selectLeaveType("CAN - Personal")
                .selectFromDate("2024-12-10")
                .selectToDate("2024-12-12")
                .enterComment("Automation leave request")
                .submitLeave();
        
        Assert.assertTrue(
                driver.getCurrentUrl().toLowerCase().contains("leave"),
                "After submitting leave we should remain in the Leave module"
        );
    }
}