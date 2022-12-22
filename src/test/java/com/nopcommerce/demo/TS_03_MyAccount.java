package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HeaderPageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObjects;


public class TS_03_MyAccount {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	MyAccountPageObjects myAccountPage;
	LoginPageObject loginPage;
	HeaderPageObject header;
	
	@BeforeClass
	public void beforeClass() {
		String url = "https://demo.nopcommerce.com/customer/info";
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		myAccountPage = new MyAccountPageObjects(driver);
		loginPage = new LoginPageObject(driver);
		header = new HeaderPageObject (driver);
	}
	
	@Test
	public void TC_01_updateCustomerInfor() {
		myAccountPage.refeshCurrentPage(driver);
		myAccountPage.inputTogoEmailTextbox("anhlavodick113t@gmail.com");
		myAccountPage.inputToPasswordTextbox("anhlavodick113");
		myAccountPage.clickToLoginButton();
		myAccountPage.clickToMaleGenderCheckbox();
		myAccountPage.inputToFisrtNameTextbox("nguyen1");
		myAccountPage.inputToLastNameTextbox("dien1");
		myAccountPage.inputToEmailTextbox("anhlavodick113t@gmail.com");
		myAccountPage.inputToCompanyNameTextbox("dien1");
		myAccountPage.clickToSaveInfoButton();
	
	}
	
	@Test
	public void TC_02_addAddressInfo() {
		myAccountPage.refeshCurrentPage(driver);
		driver.get("https://demo.nopcommerce.com/customer/addresses");
//		myAccountPage.refeshCurrentPage(driver);
//		myAccountPage.inputTogoEmailTextbox("anhlavodick113t@gmail.com");
//		myAccountPage.inputToPasswordTextbox("anhlavodick113");
//		myAccountPage.clickToLoginButton();
		myAccountPage.clickToAddAddressesMenu();
		myAccountPage.clickToAddAddressesButton();
		myAccountPage.inputToAddressesFirstnameTextbox("Nguyen");
		myAccountPage.inputToAddressesLastnameTextbox("Dien");
		myAccountPage.inputToAddressesEmailTextbox("anhlavodick113t@gmail.com");
		myAccountPage.inputToAddressesCompanyTextbox("dien");
		myAccountPage.selectTextOfCountryid("United States");
		myAccountPage.inputToAddressesCityTextbox("Binh Duong");
		myAccountPage.inputToAddressesAddress1Textbox("so 9");
		myAccountPage.inputToAddressesAddress2Textbox("so 10");
		myAccountPage.inputToAddressesZippostalcodeTextbox("HCM, 11223");
		myAccountPage.inputToAddressesPhonenumberTextbox("098761004");
		myAccountPage.inputToAddressesFaxnumberTextbox("0987610042");
		myAccountPage.clickToSaveAddAddressesButton();
		Assert.assertTrue(myAccountPage.isNameDisplayed("Nguyen Dien"));
		Assert.assertTrue(myAccountPage.isEmailDisplayed("Email: anhlavodick113t@gmail.com"));
		Assert.assertTrue(myAccountPage.isPhoneNumberDisplayed("Phone number: 098761004"));
		Assert.assertTrue(myAccountPage.isAddress1Displayed("so 9"));
		Assert.assertTrue(myAccountPage.isCityZipCodeDisplayed("Binh Duong, HCM, 11223"));
		Assert.assertTrue(myAccountPage.isCountryDisplayed("United States"));
	}
	@Test
	public void TC_03_ChangePasswordAndLoginAgain() {
		myAccountPage.clickToChangePasswordTab();
		myAccountPage.inputOldPasswordTextbox("anhlavodick113");
		myAccountPage.inputToNewPasswordTextbox("anhlavodick113t");
		myAccountPage.inputToConfirmPasswordTextbox("anhlavodick113t");
		myAccountPage.clickToChangePasswordButton();
		myAccountPage.openUrl(driver, "https://demo.nopcommerce.com");
		header.clickToLogOutButton();
		header.clickToLogInButton();
		//login fail
		loginAccount("anhlavodick113t@gmail.com","anhlavodick113");
		Assert.assertTrue(loginPage.isLoginWithRegisteredEmailAndBlankPasswordErrorMessage("The credentials provided are incorrect"));
		//login success with new password
		loginAccount("anhlavodick113t@gmail.com","anhlavodick113t");
		header.isMyAccountDisplayed("My account");
		
	}
	public void loginAccount(String email, String password) {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
