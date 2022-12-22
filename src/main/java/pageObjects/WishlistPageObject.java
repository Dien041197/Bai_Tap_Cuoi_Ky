package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.WishlistPageUIs;

public class WishlistPageObject extends BasePage{
	WebDriver driver;
	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToWishlistButton() {
		clickToElement(driver, WishlistPageUIs.ADD_TO_WISHLIST_BUTTON);
	}
	public void clickToWishlistAddToButton() {
		clickToElement(driver, WishlistPageUIs.WISHLIST_ADD_TO_CART_BUTTON);
	}
	public void clickToWishlistLabel() {
		clickToElement(driver, WishlistPageUIs.WISHLIST_LABEL);
		
	}
	public void clickToCartLabel() {
		clickToElement(driver, WishlistPageUIs.CART_LABEL);
		
	}
	public void clickToWishlistCheckbox() {
		clickToElement(driver, WishlistPageUIs.WISHLIST_CHECKBOX);
		
	}
	public boolean isSearchProductName(String value) {
		String message = getTextOfElement(driver, WishlistPageUIs.PRODUCT_NAME);
		return message.equals(value);
	}
	public boolean isVerifyElements(String value) {
		List<WebElement> ln = findElements(driver, WishlistPageUIs.PRODUCT_NAME);
		boolean verify = true;
		for (WebElement o : ln) {
			if (o.getText().contains(value)) {
				return verify = true;
			} else {
				return verify = false;
			}
		}
		return verify;
	}

}
