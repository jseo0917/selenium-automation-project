package com.herokuapp.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;

public class SecureAreaPage extends BasePageObject{

	private String pageUrl = "https://the-internet.herokuapp.com/secure";
	
	public SecureAreaPage(WebDriver driver, Logger log) {		
		super(driver, log);
	}
	
	public String getUrl() {
		return pageUrl;
	}
	
	public String getFlashMessage(By id) {
		return find(id).getText();
	}
	
	public Boolean isLogOutButtonVisible(By id) {
		return find(id).isDisplayed();
	}
}
