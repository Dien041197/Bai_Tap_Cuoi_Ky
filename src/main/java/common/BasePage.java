package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

public class BasePage {
	private Select select;
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	/////////////////////////////////
	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	//////////////////////
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput) {
		findElement(driver, locator).clear();
		findElement(driver, locator).sendKeys(valueInput);
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		findElement(driver, locator).click();
	}
	
	public String getTextOfElement(WebDriver driver, String locator) {
		return findElement(driver, locator).getText();
	}
	// xử lý cho dropdown
    public void selectDropdownByText(WebDriver driver, String locator, String textItem) {
        select = new Select(getElement(driver, locator));
        select.selectByVisibleText(textItem);
    }
}
