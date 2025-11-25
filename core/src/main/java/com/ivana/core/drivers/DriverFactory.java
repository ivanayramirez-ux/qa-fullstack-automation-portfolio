package com.ivana.core.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver createDriver() {
		WebDriver current = driver.get();

		if (current == null || isSessionClosed(current)) {
			WebDriverManager.chromedriver().setup();
			current = new ChromeDriver();
			driver.set(current);
		}

		return current;
	}

	public static WebDriver getDriver() {
		WebDriver current = driver.get();
		if (current == null || isSessionClosed(current)) {
			current = createDriver();
		}
		return current;
	}

	public static void quitDriver() {
		WebDriver current = driver.get();
		if (current != null) {
			try {
				current.quit();
			} finally {
				driver.remove();
			}
		}
	}

	private static boolean isSessionClosed(WebDriver webDriver) {
		try {
			if (webDriver instanceof RemoteWebDriver) {
				return ((RemoteWebDriver) webDriver).getSessionId() == null;
			}
		} catch (Exception e) {

			return true;
		}
		return false;
	}
}
