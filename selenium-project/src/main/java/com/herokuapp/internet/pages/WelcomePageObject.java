package com.herokuapp.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class WelcomePageObject extends BasePageObject {
		
	private String pageUrl = "http://the-internet.herokuapp.com/";
			
	private By fromAuthenticationLinkLocater = By.linkText("Form Authentication");
	
	public WelcomePageObject(WebDriver driver, Logger log) {		
		super(driver, log);
	}
	
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page successfully opened.");
	}
		
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Auth link on welcome page");
		click(fromAuthenticationLinkLocater);
		return new LoginPage(driver, log);
	}
}
