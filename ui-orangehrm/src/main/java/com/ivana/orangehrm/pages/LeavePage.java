package com.ivana.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePage extends BasePage {

    public LeavePage(WebDriver driver) {
        super(driver);
    }

    // ---------- LOCATORS ----------

    // left menu item: Leave → Apply
    @FindBy(xpath = "//a[normalize-space()='Apply']")
    private WebElement applyLeaveMenu;

    @FindBy(xpath = "//label[text()='Leave Type']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement leaveTypeDropdown;

    @FindBy(xpath = "//label[text()='From Date']/following::input[1]")
    private WebElement fromDateInput;

    @FindBy(xpath = "//label[text()='To Date']/following::input[1]")
    private WebElement toDateInput;

    @FindBy(xpath = "//label[text()='Comment']/following::textarea[1]")
    private WebElement commentBox;

    @FindBy(xpath = "//button[normalize-space()='Apply']")
    private WebElement applyButton;

    // ---------- ACTIONS ----------

    public LeavePage openApplyLeave() {
        click(applyLeaveMenu);
        return this;
    }

    protected void click(WebElement applyLeaveMenu2) {
		// TODO Auto-generated method stub
		
	}

	public LeavePage selectLeaveType(String leaveType) {
        click(leaveTypeDropdown);
        // uses BasePage.clickByText to choose the option
        clickByText(leaveType);
        return this;
    }

    private void clickByText(String leaveType) {
		// TODO Auto-generated method stub
		
	}

	public LeavePage selectFromDate(String date) {
        type(fromDateInput, date);
        return this;
    }

    private void type(WebElement fromDateInput2, String date) {
		// TODO Auto-generated method stub
		
	}

	public LeavePage selectToDate(String date) {
        type(toDateInput, date);
        return this;
    }

    public LeavePage enterComment(String comment) {
        type(commentBox, comment);
        return this;
    }

    public void submitLeave() {
        click(applyButton);
    }
}
