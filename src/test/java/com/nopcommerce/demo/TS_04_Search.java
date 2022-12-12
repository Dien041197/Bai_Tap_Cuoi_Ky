package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.SearchPageObject;

public class TS_04_Search {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	SearchPageObject searchPage;
	
	@BeforeClass
	public void beforeClass() {
		String url = "https://demo.nopcommerce.com/search";
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		searchPage = new SearchPageObject(driver);
	}
	
	@Test
	public void TC_01() {
		searchPage.refeshCurrentPage(driver);
		searchPage.clickToSearchButton();
		searchPage.isSearchWarning("Search term minimum length is 3 characters");
	
	}
	@Test
	public void TC_02() {
		searchPage.refeshCurrentPage(driver);
		searchPage.inputToSearchTextbox("Macbook Pro 2040");
		searchPage.clickToSearchButton();
		searchPage.isSearchNoResul("No products were found that matched your criteria.");
	
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
