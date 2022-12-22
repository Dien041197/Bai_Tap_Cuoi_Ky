package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.ShoppingCartPageUIs;


public class ShoppingCartPageObject extends BasePage{
	WebDriver driver;
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToQTYTextbox(String q) {
		sendKeysToElement(driver, ShoppingCartPageUIs.QTY_INPUT, q);
	}
	public void clickToUpdateCartButton() {
		clickToElement(driver, ShoppingCartPageUIs.UPDATE_SHOPPING_CART_BUTTON);
		
	}
	public boolean isQTYText(String QTY) {
		String message = getTextOfElement(driver, ShoppingCartPageUIs.QTY_INPUT);
		return message.equals(QTY);
	}
	public boolean isVerifyElements(String value) {
		List<WebElement> ln = findElements(driver, ShoppingCartPageUIs.QTY_INPUT);
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
	public void clickToRemoveButton() {
		clickToElement(driver, ShoppingCartPageUIs.REMOVE_BUTTON);
		
	}
	public boolean isNoDataMessage(String value) {
		String message = getTextOfElement(driver, ShoppingCartPageUIs.NO_DATA_MESSAGE);
		return message.equals(value);
	}

}
