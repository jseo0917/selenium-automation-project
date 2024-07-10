package com.herokuapp.internet.logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.pages.SecureAreaPage;
import com.herokuapp.internet.pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void loginTest(){

		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		
		log.info("LOGIN PAGE STARTED.");
		
		/*************************
		 * ACCESS TO WELCOME PAGE
		 *************************/
		
		WelcomePage welcomePageObject = new WelcomePage(driver, log);
		
		welcomePageObject.openPage();
		
		/*************************
		 * ACCESS TO LOGIN PAGE
		 *************************/
		
		LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();
		
		/*************************
		 * ACCESS TO SECURE PAGE
		 *************************/
		
		SecureAreaPage secureAreaPage = loginPage.logIn(username, password);
		
		String currentURL = secureAreaPage.getCurrentPageSource();
		// Check if the current URL matches with the secure page URL.
		Assert.assertEquals(currentURL, secureAreaPage.getUrl());
		
		// Check if logout button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(By.xpath("//div[@id='content']//a[@href='/logout']")));
		
		// Text Check
		String actualText = secureAreaPage.getFlashMessage(By.id("flash"));
		
		String expectedText = "You logged into a secure area!";
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		WebElement logOutBtn = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']"));
		
		Assert.assertTrue(logOutBtn.isDisplayed());
		
		/**************************
		 * END POSITIVE TESTS
		 **************************/
	}
}
