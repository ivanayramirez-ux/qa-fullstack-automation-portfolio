package com.ivana.orangehrm.tests;

import com.ivana.core.config.ConfigManager;
import com.ivana.core.drivers.DriverFactory;
import com.ivana.core.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;


@Listeners({AllureTestNg.class})
public class BaseUITest {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {

		ConfigManager.load();

		// start browser
		driver = DriverFactory.getDriver();

		// go to base URL
		String baseUrl = ConfigManager.get("base.url");
		if (baseUrl != null && !baseUrl.isEmpty()) {
			driver.get(baseUrl);
		}

		// timeouts
		int implicit = ConfigManager.getInt("implicit.wait", 10);
		int pageLoad = ConfigManager.getInt("page.load.timeout", 20);
		WaitUtils.applyTimeouts(driver, implicit, pageLoad);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
