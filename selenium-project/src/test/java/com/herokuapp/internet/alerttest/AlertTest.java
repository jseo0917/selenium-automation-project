package com.herokuapp.internet.alerttest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.JavaScriptAlertPage;
import com.herokuapp.internet.pages.WelcomePage;


public class AlertTest extends TestUtilities {
	@Test
	public void jsAlertTest() {
		
		log.info("[TESTINGLOG] JS alert test started.");
		
		SoftAssert softAssert = new SoftAssert();
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		
		welcomePage.openPage();
		
		/*************************
		 * access to JS Alert Page
		 *************************/
		
		JavaScriptAlertPage jsAlertPage = welcomePage.clickJSAlertLink();
		
		/*************************
		 * JS Alert test start
		 *************************/
		
		jsAlertPage.clickForJSAlert();
		
		String actualAlertMessage = jsAlertPage.getAlertMessage();
		String expectedAlertMessage = "I am a JS Alert";
		
		softAssert.assertTrue(actualAlertMessage.equals(expectedAlertMessage));
		
		jsAlertPage.acceptAlert();
		
		String actualResultMessage = jsAlertPage.getResultMessage();
		String expectedResultMessage = "You successfully clicked an alert";
		
		softAssert.assertEquals(actualResultMessage, expectedResultMessage);
		
		/*************************
		 * check box test end
		 *************************/
		softAssert.assertAll();
		log.info("[TESTINGLOG] Check Box test successfully exited.");
	}
	
	@Test
	public void jsConfirmTest() {
		
		log.info("[TESTINGLOG] JS confirm test started.");
		SoftAssert softAssert = new SoftAssert();
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		
		welcomePage.openPage();
		
		/*************************
		 * access to JS Alert Page
		 *************************/
		
		JavaScriptAlertPage jsAlertPage = welcomePage.clickJSAlertLink();
		
		/*************************
		 * JS Confirm test start
		 *************************/
		
		// Accept the alert
		jsAlertPage.clickForJSConfirm();
		
		String actualAlertMessage = jsAlertPage.getAlertMessage();
		String expectedAlertMessage = "I am a JS Confirm";
		
		softAssert.assertTrue(actualAlertMessage.equals(expectedAlertMessage));
		
		jsAlertPage.acceptAlert();
		
		String actualResultMessage = jsAlertPage.getResultMessage();
		String expectedResultMessage = "You clicked: Ok";
		
		softAssert.assertEquals(actualResultMessage, expectedResultMessage);
				
		// Dismiss the alert
		jsAlertPage.clickForJSConfirm();
					
		jsAlertPage.cancelAlert();
		
		actualResultMessage = jsAlertPage.getResultMessage();
		expectedResultMessage = "You clicked: Cancel";
		
		softAssert.assertEquals(actualResultMessage, expectedResultMessage);
		/*************************
		 * check box test end
		 *************************/
		softAssert.assertAll();
		log.info("[TESTINGLOG] Check Box test successfully exited.");
	}
	
	@Test
	public void jsPromptTest() {
		
		log.info("[TESTINGLOG] JS Prompt test started.");
		
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		
		welcomePage.openPage();
		
		/*************************
		 * access to JS Alert Page
		 *************************/
		
		JavaScriptAlertPage jsAlertPage = welcomePage.clickJSAlertLink();
		
		/*************************
		 * JS Alert test start
		 *************************/
		
		jsAlertPage.clickForJSPrompt();;
		
		String actualAlertMessage = jsAlertPage.getAlertMessage();
		String expectedAlertMessage = "I am a JS prompt";
		
		Assert.assertTrue(actualAlertMessage.equals(expectedAlertMessage));
				
		String prompt = "TESTING";
		
		jsAlertPage.writeAlertPrompt(prompt);
		
		String actualResultMessage = jsAlertPage.getResultMessage();
		String expectedResultMessage = "You entered: " + prompt;
		
		Assert.assertEquals(actualResultMessage, expectedResultMessage);
		
		/*************************
		 * check box test end
		 *************************/
		
		log.info("[TESTINGLOG] Check Box test successfully exited.");
	}
}
