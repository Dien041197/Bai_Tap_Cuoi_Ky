package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HeaderPageObject;
import pageObjects.WishlistPageObject;

public class TS_05_WishList {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WishlistPageObject WishlistPage;
	HeaderPageObject HeaderPage;
	
	
	@BeforeClass
	public void beforeClass() {
		String url = "https://demo.nopcommerce.com/apple-macbook-pro-13-inch";
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WishlistPage =new WishlistPageObject(driver);
	}
	@Test
	public void TC_01_AddToWishList() {
		WishlistPage.refeshCurrentPage(driver);
		WishlistPage.clickToWishlistButton();
		WishlistPage.clickToWishlistLabel();
		Assert.assertTrue(WishlistPage.isVerifyElements("Apple MacBook Pro"));
	}
	@Test
	public void TC_02_AddProductFromWishList() {
		WishlistPage.clickToWishlistCheckbox();
		WishlistPage.clickToWishlistAddToButton();
		WishlistPage.clickToCartLabel();
		Assert.assertTrue(WishlistPage.isVerifyElements("Apple MacBook Pro"));
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
