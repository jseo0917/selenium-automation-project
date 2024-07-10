package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePageObject {

	private String pageURL = "https://the-internet.herokuapp.com/windows";
	private By clickHereLocator = By.xpath("//a[text()='Click Here']");
	private By newWindowLocator = By.xpath("//h3[text()='New Window']");
	public MultipleWindowsPage(WebDriver driver, Logger log) {		
		super(driver, log);
	}
	
	public void clickClickHereLink() {
		log.info("Clicking Click Here link in multiple windows page.");
		click(clickHereLocator);
	}
	
	public void switchToNewWindow(String expectedMessage) {
		log.info("Switch to New window.");
		switchToWindow(expectedMessage);					
	}
	
	public String getWindowMessage() {
		return find(newWindowLocator).getText();
	}
}
