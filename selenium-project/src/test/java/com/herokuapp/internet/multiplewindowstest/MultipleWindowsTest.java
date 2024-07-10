package com.herokuapp.internet.multiplewindowstest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.JavaScriptAlertPage;
import com.herokuapp.internet.pages.MultipleWindowsPage;
import com.herokuapp.internet.pages.WelcomePage;

public class MultipleWindowsTest extends TestUtilities {
	@Test
	public void MultipleWindowTest() {
		
		log.info("[TESTINGLOG] Multiple Windows test started.");
		
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		
		welcomePage.openPage();
		
		/*************************
		 * access to Multiple Windows Page
		 *************************/
		
		MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();
		
		/*************************
		 * Multiple Windows test start
		 *************************/
		
		multipleWindowsPage.clickClickHereLink();
		
		multipleWindowsPage.switchToNewWindow("New Window");

		String actualWindowMessage = multipleWindowsPage.getWindowMessage();
		
		String expectedWindowMessage = "New Window";
		
		Assert.assertTrue(actualWindowMessage.equals(expectedWindowMessage));
				
		/*************************
		 * Multiple Windows test end
		 *************************/
		
		log.info("[TESTINGLOG] Multiple Windows test successfully exited.");
	}
}
