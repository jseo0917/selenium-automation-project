package com.herokuapp.internet.logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.pages.SecureAreaPage;
import com.herokuapp.internet.pages.WelcomePageObject;

public class NegativeLoginTests extends TestUtilities {
	
	
	@Parameters({"username","password", "expectedMessage"})
	@Test(priority =1)
	public void negativeTests(@Optional("username") String username, String password, String expectedErrorMessage) {		
		
		log.info("Negative test started.");
		log.info("LOGIN PAGE STARTED.");
		
		/*************************
		 * ACCESS TO WELCOME PAGE
		 *************************/
		
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		
		welcomePageObject.openPage();
		
		/*************************
		 * ACCESS TO LOGIN PAGE
		 *************************/
		
		LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();
		
		/*************************
		 * ACCESS TO SECURE PAGE
		 *************************/
		
		// Will attemp to put with incorrect user name or password
		loginPage.logInWithIncorrectInfo(username, password);
		
		loginPage.waitForErrorMessage();
		
		String actualMessage = loginPage.getErrorMessage();
		
		Assert.assertTrue(actualMessage.contains(expectedErrorMessage));

		
	}	
}
