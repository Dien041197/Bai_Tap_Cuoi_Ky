package com.nopcommerce.demo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.loginPageObjects;

public class TS_02_login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	loginPageObjects loginPage;
	
	@BeforeClass
	public void beforeClass() {
		String url = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		loginPage = new loginPageObjects(driver);
	}
	
	@Test
	public void TC_01_LoginWithEmptyData() {
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailErrorMessage("Please enter your email"));
	}
	
	@Test
	public void TC_02_LoginWithInvalidData() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextbox("abcd");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailErrorMessage("Wrong email"));
	}
	
	@Test
	public void TC_03_LoginWithUnregisteredEmail() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextbox("abcd@gmail.com");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("No customer account found"));
	}
	@Test
	public void TC_04_LoginWithregisteredEmail() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextbox("anhlavodick113t@gmail.com");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("The credentials provided are incorrect"));
	}
	@Test
	public void TC_05_LoginWithTheWrongPassword() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextbox("anhlavodick113t@gmail.com");
		loginPage.inputToPasswordTextbox("anhlavodick113t");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("The credentials provided are incorrect"));
	}
	@Test
	public void TC_06_LoginSuccessful() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextbox("anhlavodick113t@gmail.com");
		loginPage.inputToPasswordTextbox("anhlavodick113");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLogOutGetText("Log out"));
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	//aaa
	
    
}
