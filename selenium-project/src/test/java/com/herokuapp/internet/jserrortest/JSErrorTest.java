package com.herokuapp.internet.jserrortest;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.JSErrorPage;
import com.herokuapp.internet.pages.WelcomePage;

public class JSErrorTest extends TestUtilities {
	@Test
	public void keyPressesTest() {
		
		log.info("[TESTINGLOG] JS error test started.");
		SoftAssert softAssert = new SoftAssert();
		
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		
		welcomePage.openPage();
		
		/*************************
		 * access to Multiple Windows Page
		 *************************/
		
		JSErrorPage jsErrorPage = welcomePage.clickJSErrorLink();
		
		/*************************
		 * JS Error test start
		 *************************/
			
		List<LogEntry> logs = getBrowserLogs();
		
		for (LogEntry log : logs) {
			if(log.getLevel().toString().equals("SEVERE")) {
				softAssert.fail("SEVERE ERROR: " + log.getMessage());
			}
		}
		
		softAssert.assertAll();
		/*************************
		 * JS Error test end
		 *************************/
		
		log.info("[TESTINGLOG] JS Error test successfully exited.");
	}
}
