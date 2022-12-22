package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.ShoppingCartPageObject;
import pageObjects.WishlistPageObject;

public class TS_06_ShoppingCart {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	ShoppingCartPageObject ShoppingCartPage;
	WishlistPageObject WishlistPage;
	
	@BeforeClass
	public void beforeClass() {
		String url = "https://demo.nopcommerce.com/apple-macbook-pro-13-inch";
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WishlistPage =new WishlistPageObject(driver);
		ShoppingCartPage =new ShoppingCartPageObject(driver);
	}
	@Test
	public void TC_01_UpdateShoppingCart() {
		WishlistPage.refeshCurrentPage(driver);
		WishlistPage.clickToWishlistButton();
		WishlistPage.clickToWishlistLabel();
		WishlistPage.clickToWishlistCheckbox();
		WishlistPage.clickToWishlistAddToButton();
		WishlistPage.clickToCartLabel();
		ShoppingCartPage.inputToQTYTextbox("5");
		ShoppingCartPage.clickToUpdateCartButton();
		Assert.assertTrue(ShoppingCartPage.isQTYText("5"));
		
	}
	@Test
	public void TC_02_RemoveFromCart() {
		WishlistPage.clickToCartLabel();
		ShoppingCartPage.clickToRemoveButton();
		Assert.assertTrue(ShoppingCartPage.isNoDataMessage("Your Shopping Cart is empty!"));
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
