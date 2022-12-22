package com.nopcommerce.demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class TS_01_Gegister {
	WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    RegisterPageObject registerPage;
    LoginPageObject loginPage;

    @BeforeClass
	public void beforeClass() {
    	String url = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		registerPage= new RegisterPageObject(driver);
    }
    
    @Test
    public void TC_01_RegisterWithEmptyData() {
    	registerPage.refeshCurrentPage(driver);
    	registerPage.clickToRegisterButton();
    	AssertJUnit.assertTrue(registerPage.isFirstNameMessageError("First name is required."));
    	AssertJUnit.assertTrue(registerPage.isLastNameMessageError("Last name is required."));
    	AssertJUnit.assertTrue(registerPage.isEmailMessageError("Email is required."));
    	AssertJUnit.assertTrue(registerPage.isPassWordMessageError("Password is required."));
    	AssertJUnit.assertTrue(registerPage.isConfirmPassWordMessageError("Password is required."));
    	  	
    }
    
    @Test
    public void TC_02_RegisterWithInvalidEmail() {
    	registerPage.refeshCurrentPage(driver);
    	registerPage.inputToEmailTextbox("anhlavodick113");
    	registerPage.clickToRegisterButton();
    	AssertJUnit.assertTrue(registerPage.isEmailMessageError("Wrong email"));
    	  	
    }
    @Test
    public void TC_03_RegisterWithExistEmail() {
    	registerPage.refeshCurrentPage(driver);
    	registerPage.clickToMaleGenderCheckbox();
    	registerPage.inputToFisrtNameTextbox("nguyen");
    	registerPage.inputToLastNameTextbox("dien");
    	registerPage.inputToEmailTextbox("anhlavodick113@gmail.com");
    	registerPage.clickToNewsletterCheckbox();
    	registerPage.inputToPassWordTextbox("anhlavodick113");
    	registerPage.inputToCompirmPassWordTextbox("anhlavodick113");
    	registerPage.clickToRegisterButton();
    	AssertJUnit.assertTrue(registerPage.isEmailValidationSummaryMessageError("The specified email already exists"));
    	
    }
    @Test
    public void TC_04_RegisterWithPasswordSmallThan6() {
    	registerPage.refeshCurrentPage(driver);
    	registerPage.inputToPassWordTextbox("12345");
    	registerPage.clickToRegisterButton();
    	AssertJUnit.assertTrue(registerPage.isPassWordMessageErrorP("Password must meet the following rules"));
    	AssertJUnit.assertTrue(registerPage.isPassWordMessageErrorUl("must have at least 6 characters"));
    	
    }
    @Test
    public void TC_05_RegisterWithPassWordDoesNotMatchWithConfirm() {
    	registerPage.refeshCurrentPage(driver);
    	registerPage.inputToPassWordTextbox("123456");
    	registerPage.inputToCompirmPassWordTextbox("123457");
    	registerPage.clickToRegisterButton();
    	AssertJUnit.assertTrue(registerPage.isConfirmPassWordMessageError("The password and confirmation password do not match."));

    }
    @Test
    public void TC_06_RegisterSuccess() {
    	registerPage.refeshCurrentPage(driver);
    	registerPage.clickToMaleGenderCheckbox();
    	registerPage.inputToFisrtNameTextbox("nguyen");
    	registerPage.inputToLastNameTextbox("dien");
//    	registerPage.inputToDayDatePicker("1");
//    	registerPage.inputToMonthDatePicker("1");
//    	registerPage.inputToYearDatePicker("2000");
    	registerPage.inputToEmailTextbox("anhlavodick113t@gmail.com");
    	registerPage.clickToNewsletterCheckbox();
    	registerPage.inputToPassWordTextbox("anhlavodick113");
    	registerPage.inputToCompirmPassWordTextbox("anhlavodick113");
    	registerPage.clickToRegisterButton();
    	AssertJUnit.assertTrue(registerPage.isConfirmRegisterResultMessage("Your registration completed"));
    	//loginPage.clickLogout();
    	
    	
    }
    
    
    @AfterClass
    public void afterClass() {
    	 driver.quit();
    }
}
