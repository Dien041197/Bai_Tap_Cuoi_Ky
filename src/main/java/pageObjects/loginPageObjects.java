package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.LoginPageUIs;

public class loginPageObjects extends BasePage {
	WebDriver driver;
	
	// constructor
	public loginPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String email) {
		sendKeysToElement(driver, LoginPageUIs.EMAIL_TEXTBOX, email);
	}
	public void inputToPasswordTextbox(String password) {
		sendKeysToElement(driver, LoginPageUIs.PASSWORD_TEXTBOX, password);
	}	
	public void clickToLoginButton() {
		clickToElement(driver, LoginPageUIs.LOGIN_BUTTON);
	}
	
	public boolean isEmailErrorMessage(String value) {
		String message = getTextOfElement(driver, LoginPageUIs.EMAIL_ERROR_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isLoginErrorMessage(String value) {
		String message = getTextOfElement(driver, LoginPageUIs.LOGIN_ERROR_MESSAGE);
		return message.contains(value);
	}
	public boolean isLogOutGetText(String value) {
		String message = getTextOfElement(driver, LoginPageUIs.LOGOUT_GO_MENU);
		return message.contains(value);
	}
}
