package com.ivana.core.reporting;

import org.testng.ITestResult;
import org.testng.Reporter;

public class ReportManager {

    private ReportManager() {
        // utility class
    }

    public static void log(String message) {
        Reporter.log(message, true);
        System.out.println("[LOG] " + message);
    }

    public static void logTestStart(ITestResult result) {
        String name = result.getMethod().getMethodName();
        log("==== STARTING TEST: " + name + " ====");
    }

    public static void logTestEnd(ITestResult result) {
        String name = result.getMethod().getMethodName();
        if (result.getStatus() == ITestResult.SUCCESS) {
            log("==== PASSED: " + name + " ====");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            log("==== FAILED: " + name + " ====");
        } else {
            log("==== SKIPPED: " + name + " ====");
        }
    }
}
