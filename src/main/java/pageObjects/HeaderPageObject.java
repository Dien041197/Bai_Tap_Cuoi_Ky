package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HeaderPageUIS;

public class HeaderPageObject extends BasePage {
	WebDriver driver;
	
	public HeaderPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public void clickToWishlistLabel() {
		clickToElement(driver, HeaderPageUIS.WISHLIST_LABEL);
		
	}
	public void clickToLogOutButton () {
		clickToElement(driver, HeaderPageUIS.LOG_OUT_BUTTON);
	}
	
	public void clickToLogInButton() {
		clickToElement(driver, HeaderPageUIS.LOG_IN_BUTTON);
	}
	
	public boolean isMyAccountDisplayed(String value) {
		String message = getTextOfElement(driver, HeaderPageUIS.MY_ACCOUNT_BUTTON);
		return message.equals(value);
	}
	

}
