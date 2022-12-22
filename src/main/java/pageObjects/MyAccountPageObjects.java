package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import common.BasePage;
import pageUIs.LoginPageUIs;
import pageUIs.MyAccountPageUIs;

public class MyAccountPageObjects extends BasePage {
	WebDriver driver;
	public MyAccountPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	//click
	public void clickToSaveInfoButton() {
		clickToElement(driver, MyAccountPageUIs.SAVE_INFO_BUTTON);
	}
	public void clickToMaleGenderCheckbox() {
		clickToElement(driver, MyAccountPageUIs.GENDER_MALE_CHECKBOX);
	}
	public void clickToFemaleGenderCheckbox() {
		clickToElement(driver, MyAccountPageUIs.GENDER_FEMALE_CHECKBOX);
	}
	public void clickToNewsletterCheckbox() {
		clickToElement(driver, MyAccountPageUIs.NEWSLETTER_CHECKBOX);
	}
	//input
	public void inputToFisrtNameTextbox(String fisrtname) {
		sendKeysToElement(driver, MyAccountPageUIs.FIRST_NAME_TEXTBOX, fisrtname);
	}
	public void inputToLastNameTextbox(String lastname) {
		sendKeysToElement(driver,  MyAccountPageUIs.LAST_NAME_TEXTBOX, lastname);
	}
	public void inputToEmailTextbox(String email) {
		sendKeysToElement(driver,  MyAccountPageUIs.EMAL_TEXTBOX, email);
	}
	public void inputToCompanyNameTextbox(String companyname) {
		sendKeysToElement(driver,  MyAccountPageUIs.COMPANY_NAME_TEXTBOX, companyname);
	}
	public void inputToDayDatePicker(String day) {
		sendKeysToElement(driver,  MyAccountPageUIs.DAY_DATE_PICKER, day);
	}
	public void inputToMonthDatePicker(String month) {
		sendKeysToElement(driver,  MyAccountPageUIs.MONTH_DATE_PICKER, month);
	}
	public void inputToYearDatePicker(String year) {
		sendKeysToElement(driver,  MyAccountPageUIs.YEAR_DATE_PICKER, year);
	}
	public void inputTogoEmailTextbox(String email) {
		sendKeysToElement(driver, MyAccountPageUIs.EMAIL_TEXTBOX, email);
	}
	public void inputToPasswordTextbox(String password) {
		sendKeysToElement(driver, MyAccountPageUIs.PASSWORD_TEXTBOX, password);
	}	
	public void clickToLoginButton() {
		clickToElement(driver, MyAccountPageUIs.LOGIN_BUTTON);
	}
	public void clickToAddAddressesMenu() {
		clickToElement(driver, MyAccountPageUIs.ADDRESSES_NAVIGATION_MENU);
	}
	public void clickToAddAddressesButton() {
		clickToElement(driver, MyAccountPageUIs.ADD_ADDRESSES_BUTTON);
	}
	public void inputToAddressesFirstnameTextbox(String Firstname) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_FIRST_NAME_TEXTBOX, Firstname);
	}	
	public void inputToAddressesLastnameTextbox(String Lastname) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_LAST_NAME_TEXTBOX, Lastname);
	}	
	public void inputToAddressesEmailTextbox(String Email) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_EMAL_TEXTBOX, Email);
	}	
	public void inputToAddressesCompanyTextbox(String Company) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_COMPANY_NAME_TEXTBOX, Company);
	}	
	public void inputToAddressesCityTextbox(String City) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_CITY_TEXTBOX, City);
	}	
	public void inputToAddressesAddress1Textbox(String Address1) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_ADDRESSES1_TEXTBOX, Address1);
	}	
	public void inputToAddressesAddress2Textbox(String Address2) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_ADDRESSES2_TEXTBOX, Address2);
	}	
	public void inputToAddressesZippostalcodeTextbox(String Zippostalcode) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_ZIPPOSTALCODE_TEXTBOX, Zippostalcode);
	}	
	public void inputToAddressesPhonenumberTextbox(String Phonenumber) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_PHONENUMBER_TEXTBOX, Phonenumber);
	}
	public void inputToAddressesFaxnumberTextbox(String Faxnumber) {
		sendKeysToElement(driver, MyAccountPageUIs.ADDRESSES_FAXNUMBER_TEXTBOX, Faxnumber);
	}
//	public void enterToDayDropdown(String value) {
//		selectDropdownByText(driver, MyAccountPageUIs.ADDRESSES_COUNTRYID_SELECT, value);
//	}
	public void selectTextOfCountryid(String value) {
		Select select = new Select(findElement(driver, MyAccountPageUIs.ADDRESSES_COUNTRYID_SELECT));
		select.selectByVisibleText(value);
	}
	public void selectTextOfStateProvince(String value) {
		Select select = new Select(findElement(driver, MyAccountPageUIs.ADDRESSES_STATEPROVINCEID_SELECT));
		select.selectByVisibleText(value);
	}
	public void clickToSaveAddAddressesButton() {
		clickToElement(driver, MyAccountPageUIs.SAVE_ADDRESS_BUTTON);
	}
	public boolean isInfo(String value) {
		String message = getTextOfElement(driver, MyAccountPageUIs.INFO);
		return message.contains(value);
	}
	public boolean isNameDisplayed (String value) {
		String message = getTextOfElement(driver, MyAccountPageUIs.NAME_TEXT);
		return message.equals(value);
	}
	
	public boolean isEmailDisplayed (String value) {
		String message = getTextOfElement(driver, MyAccountPageUIs.EMAIL_TEXT);
		return message.equals(value);
	}
	
	public boolean isPhoneNumberDisplayed(String value) {
		String message = getTextOfElement(driver, MyAccountPageUIs.PHONE_NUMBER_TEXT);
		return message.equals(value);
	}
	
	public boolean isAddress1Displayed(String value) {
		String message = getTextOfElement(driver, MyAccountPageUIs.ADDRESS_1_TEXT);
		return message.equals(value);
	}
	
	public boolean isCityZipCodeDisplayed(String value) {
		String message = getTextOfElement(driver,MyAccountPageUIs.CITY_ZIP_CODE_TEXT);
		return message.equals(value);
	}
	
	public boolean isCountryDisplayed(String value) {
		String message = getTextOfElement(driver, MyAccountPageUIs.COUNTRY_TEXT);
		return message.equals(value);
	}
	public void clickToChangePasswordTab() {
		clickToElement(driver, MyAccountPageUIs.CHANGE_PASSWORD_TAB);
	}
	
	public void inputOldPasswordTextbox(String oldPassword) {
		sendKeysToElement(driver, MyAccountPageUIs.OLD_PASSWORD_TEXTBOX, oldPassword);
	}
	
	public void inputToNewPasswordTextbox(String newPassword) {
		sendKeysToElement(driver, MyAccountPageUIs.NEW_PASSWORD_TEXTBOX, newPassword);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		sendKeysToElement(driver, MyAccountPageUIs.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	
	public void clickToChangePasswordButton() {
		clickToElement(driver, MyAccountPageUIs.CHANGE_PASSWORD_BUTTON);
	}

}
