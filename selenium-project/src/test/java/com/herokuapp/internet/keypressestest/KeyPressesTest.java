package com.herokuapp.internet.keypressestest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.KeyPressesPage;
import com.herokuapp.internet.pages.WelcomePage;

public class KeyPressesTest extends TestUtilities {
	@Test
	public void keyPressesTest() {
		
		log.info("[TESTINGLOG] Key Presses test started.");
		
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		
		welcomePage.openPage();
		
		/*************************
		 * access to Multiple Windows Page
		 *************************/
		
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();
		
		/*************************
		 * Key Presses test start
		 *************************/
			
		keyPressesPage.pressKey(Keys.ENTER);

		String actualMessage = keyPressesPage.getResult();
		
		String expectedMessage = "You entered: ENTER";
		
		Assert.assertEquals(actualMessage, expectedMessage);
		
		/*************************
		 * Key Presses test end
		 *************************/
		
		log.info("[TESTINGLOG] Key Presses test successfully exited.");
	}
}
