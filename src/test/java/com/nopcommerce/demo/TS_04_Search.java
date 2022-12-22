package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.FooterObject;
import pageObjects.LoginPageObject;
import pageObjects.SearchPageObject;

public class TS_04_Search {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	SearchPageObject searchPage;
	FooterObject footer;
	LoginPageObject loginPage;

	
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
	public void TC_01_SearchWithEmptyData() {
		searchPage.refeshCurrentPage(driver);	
		searchPage.inputToSearchTextbox("");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isSearchEmptyErrorMessage("Search term minimum length is 3 characters"));
	}
	
	@Test
	public void TC_02_SearchWithWrongData() {
		searchPage.inputToSearchTextbox("Macbook Pro 2040");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isWrongDataErrorMessage("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_03_SearchWithKeywordLenovo() {
		searchPage.inputToSearchTextbox("Lenovo");
		searchPage.clickToSearchButton();
		searchPage.isAddToCartButton("ADD TO CART");
		Assert.assertTrue(searchPage.isVerifyElements("Lenovo"));
		
	}
	
	@Test
	public void TC_04_AdvanceSearchWithParentCategories() {
		searchPage.refeshCurrentPage(driver);
		searchPage.inputToSearchTextbox("Apple Macbook Pro");
		searchPage.clickToAdvanceSearchCheckBox();
		searchPage.selectTextOfDropdown("Computers");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isWrongDataErrorMessage("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_05_AdvanceSearchWithSubCategories() {
//		searchPage.refeshCurrentPage(driver);
//		footer.clickToSearchButton();
		searchPage.inputToSearchTextbox("Apple Macbook Pro");
//		searchPage.clickToAdvanceSearchCheckBox();
		searchPage.selectTextOfDropdown("Computers");
		searchPage.clickToAutomaticallySearchCheckBox();
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isVerifyElements("Apple MacBook Pro"));
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
