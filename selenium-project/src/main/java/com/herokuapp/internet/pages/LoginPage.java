package com.herokuapp.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePageObject{
	
	private By usernameLocator = By.id("username");
	private By passwordLocator = By.id("password");
	private By logInButtonLocator = By.tagName("button");
	private By errorMessageLocator = By.id("flash");
	
	public LoginPage(WebDriver driver, Logger log) {	
		super(driver, log);	
	}
	
	public SecureAreaPage logIn(String username, String password) {
		log.info("Executing Login with username [" + username + " ]");
		
		type(username, usernameLocator);			
		type(password, passwordLocator);
		
		click(logInButtonLocator);
		
		return new SecureAreaPage(driver, log);
	}
	
	public void logInWithIncorrectInfo(String username, String password) {
		log.info("Executing Login with Incorrect username or password");
		
		type(username, usernameLocator);			
		type(password, passwordLocator);
		
		click(logInButtonLocator);	
	}
	
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, Duration.ofSeconds(5));
	}
	
	public String getErrorMessage() {
		return find(errorMessageLocator).getText();
	}
 
}
