package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TS_01_Gegister {
	WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
	public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window();        
    }
    @AfterClass
    public void afterClass() {
    	 driver.quit();
    }
    @Test
    public void TC_01() {
    	
    }
}
