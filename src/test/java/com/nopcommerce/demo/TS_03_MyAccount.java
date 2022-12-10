package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.MyAccountPageObjects;

public class TS_03_MyAccount {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	MyAccountPageObjects myAccountPage;
	
	@BeforeClass
	public void beforeClass() {
		String url = "https://demo.nopcommerce.com/customer/info";
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		myAccountPage = new MyAccountPageObjects(driver);
	}
	
	@Test
	public void TC_01() {
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
	public void TC_02() {
		myAccountPage.refeshCurrentPage(driver);
		driver.get("https://demo.nopcommerce.com/customer/addresses");
//		myAccountPage.refeshCurrentPage(driver);
//		myAccountPage.inputTogoEmailTextbox("anhlavodick113t@gmail.com");
//		myAccountPage.inputToPasswordTextbox("anhlavodick113");
//		myAccountPage.clickToLoginButton();
		myAccountPage.clickToAddAddressesMenu();
		myAccountPage.clickToAddAddressesButton();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
