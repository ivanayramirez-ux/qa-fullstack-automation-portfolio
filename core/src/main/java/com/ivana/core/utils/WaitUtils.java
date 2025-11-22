package com.ivana.core.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class WaitUtils {

    public static void applyTimeouts(WebDriver driver,
                                     int implicitSeconds,
                                     int pageLoadSeconds) {

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(implicitSeconds));

        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(pageLoadSeconds));
    }

	public static void waitForClickable(WebDriver driver, WebElement logoutLink, int i) {
		// TODO Auto-generated method stub
		
	}
}
