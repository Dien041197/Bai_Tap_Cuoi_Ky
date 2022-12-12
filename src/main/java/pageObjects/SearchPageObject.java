package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUIs;
import pageUIs.SearchPageUIs;

public class SearchPageObject extends BasePage {
	WebDriver driver;
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToSearchButton() {
		clickToElement(driver, SearchPageUIs.SEACH_BUTTON);
	}
	public boolean isSearchWarning(String value) {
		String massage =getTextOfElement(driver, SearchPageUIs.SEACH_WARNING);
		return massage.contains(value);
		
	}
	public boolean isSearchNoResul(String value) {
		String massage =getTextOfElement(driver, SearchPageUIs.SEACH_NO_RESUL);
		return massage.contains(value);
		
	}
	public void inputToSearchTextbox(String key) {
		sendKeysToElement(driver,SearchPageUIs.SEARCH_TEXTBOX, key);
	}
	
	

}
