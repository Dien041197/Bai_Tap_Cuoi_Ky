package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUIs;

public class RegisterPageObject extends BasePage{
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	//click
	public void clickToRegisterButton() {
		clickToElement(driver, RegisterPageUIs.REGISTER_BUTTON);
	}
	public void clickToMaleGenderCheckbox() {
		clickToElement(driver, RegisterPageUIs.GENDER_MALE_CHECKBOX);
	}
	public void clickToFemaleGenderCheckbox() {
		clickToElement(driver, RegisterPageUIs.GENDER_FEMALE_CHECKBOX);
	}
	public void clickToNewsletterCheckbox() {
		clickToElement(driver, RegisterPageUIs.NEWSLETTER_CHECKBOX);
	}
		
	//message
	public boolean isFirstNameMessageError(String value) {
		String massage =getTextOfElement(driver, RegisterPageUIs.FIRST_NAME_ERROR_MESSAGE);
		return massage.contains(value);
		
	}
	public boolean isLastNameMessageError(String value) {
		String massage =getTextOfElement(driver, RegisterPageUIs.LAST_NAME_ERROR_MESSAGE);
		return massage.contains(value);
		
	}
	public boolean isEmailMessageError(String value) {
		String massage =getTextOfElement(driver, RegisterPageUIs.EMAIL_ERROR_MESSAGE);
		return massage.contains(value);
		
	}
	public boolean isPassWordMessageError(String value) {
		String massage =getTextOfElement(driver, RegisterPageUIs.PASS_WORD_ERROR_MESSAGE);
		return massage.contains(value);
		
	}
	public boolean isPassWordMessageErrorP(String value) {
		String massage =getTextOfElement(driver, RegisterPageUIs.PASS_WORD_ERROR_MESSAGE_P);
		return massage.contains(value);
		
	}
	public boolean isPassWordMessageErrorUl(String value) {
		String massage =getTextOfElement(driver, RegisterPageUIs.PASS_WORD_ERROR_MESSAGE_UL);
		return massage.contains(value);
		
	}
	public boolean isConfirmPassWordMessageError(String value) {
		String massage =getTextOfElement(driver, RegisterPageUIs.COMFIRM_PASS_WORD_ERROR_MESSAGE);
		return massage.contains(value);
		
	}
	public boolean isConfirmRegisterResultMessage(String value) {
		String massage =getTextOfElement(driver, RegisterPageUIs.REGISTER_RESULT_MESSAGE);
		return massage.contains(value);
		
	}
	public boolean isEmailValidationSummaryMessageError(String value) {
		String massage =getTextOfElement(driver, RegisterPageUIs.EMAIL_ERROR_VALIDATION_SUMMARY_MESSAGE);
		return massage.contains(value);
		
	}
	
	
	//input
	public void inputToFisrtNameTextbox(String fisrtname) {
		sendKeysToElement(driver, RegisterPageUIs.FIRST_NAME_TEXTBOX, fisrtname);
	}
	public void inputToLastNameTextbox(String lastname) {
		sendKeysToElement(driver, RegisterPageUIs.LAST_NAME_TEXTBOX, lastname);
	}
	public void inputToEmailTextbox(String email) {
		sendKeysToElement(driver, RegisterPageUIs.EMAL_TEXTBOX, email);
	}
	public void inputToCompanyNameTextbox(String companyname) {
		sendKeysToElement(driver, RegisterPageUIs.COMPANY_NAME_TEXTBOX, companyname);
	}
	public void inputToPassWordTextbox(String password) {
		sendKeysToElement(driver, RegisterPageUIs.PASS_WORD_TEXTBOX, password);
	}
	public void inputToCompirmPassWordTextbox(String password) {
		sendKeysToElement(driver, RegisterPageUIs.COMPIRM_PASS_WORD_TEXTBOX, password);
	}
	public void inputToDayDatePicker(String day) {
		sendKeysToElement(driver, RegisterPageUIs.DAY_DATE_PICKER, day);
	}
	public void inputToMonthDatePicker(String month) {
		sendKeysToElement(driver, RegisterPageUIs.MONTH_DATE_PICKER, month);
	}
	public void inputToYearDatePicker(String year) {
		sendKeysToElement(driver, RegisterPageUIs.YEAR_DATE_PICKER, year);
	}

}
