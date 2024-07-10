package com.herokuapp.internet.dropdowntest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.DropdownPage;
import com.herokuapp.internet.pages.WelcomePage;

public class DropdownTest extends TestUtilities {
	
	@Parameters({"selectOption"})
	@Test
	public void dropdownTests(int selectOption) {
		
		log.info("[TESTINGLOG] Drop down test started.");
		
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePageObject = new WelcomePage(driver, log);
		
		welcomePageObject.openPage();
		
		/*************************
		 * access to the drop down page
		 *************************/	
		
		DropdownPage dropdownPage = welcomePageObject.clickDropdownLink();
		
		/*************************
		 * start the drop down test
		 *************************/
		
		dropdownPage.selectOption(selectOption);
		
		Assert.assertEquals("Option " + selectOption, dropdownPage.getSelectedOption());
		
		/*************************
		 * end the drop down test
		 *************************/
		
		log.info("[TESTINGLOG] Drop down test successfully exited.");
	}
}
