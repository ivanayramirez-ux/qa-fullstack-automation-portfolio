package com.ivana.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPage extends BasePage {

	public PIMPage(WebDriver driver) {
		super(driver);
	}

	// ---------- LOCATORS ----------

	// "Add" button on PIM page
	@FindBy(xpath = "//button[contains(@class,'oxd-button') and .=' Add ']")
	private WebElement addEmployeeButton;

	// Fields on Add Employee form
	@FindBy(name = "firstName")
	private WebElement firstNameInput;

	@FindBy(name = "lastName")
	private WebElement lastNameInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	// Optional search box & search button if you want to verify employee
	@FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input")
	private WebElement employeeNameSearchInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;

	// ---------- ACTIONS ----------

	public PIMPage clickAddEmployee() {
		click(addEmployeeButton);
		return this;
	}

	protected void click(WebElement addEmployeeButton2) {

	}

	public PIMPage enterFirstName(String firstName) {
		type(firstNameInput, firstName);
		return this;
	}

	private void type(WebElement firstNameInput2, String firstName) {

	}

	public PIMPage enterLastName(String lastName) {
		type(lastNameInput, lastName);
		return this;
	}

	public PIMPage saveEmployee() {
		click(saveButton);
		return this;
	}

	public PIMPage searchEmployeeByName(String fullName) {
		type(employeeNameSearchInput, fullName);
		click(searchButton);
		return this;
	}
}
