package com.herokuapp.internet.checkboxtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.CheckboxesPage;
import com.herokuapp.internet.pages.WelcomePageObject;

public class CheckBoxTest extends TestUtilities {

	@Test
	public void selectingTwoCheckBoxTest() {
		
		log.info("[TESTINGLOG] Check Box test started.");
		
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		
		welcomePage.openPage();
		
		/*************************
		 * access to check box page
		 *************************/
		
		CheckboxesPage checkboxesPages = welcomePage.clickCheckboxesLink();
		
		/*************************
		 * check box test start
		 *************************/
		
		checkboxesPages.selectAllCheckboxes();
		
		Assert.assertTrue(checkboxesPages.checkAllCheckboxesSelected());
		
		/*************************
		 * check box test end
		 *************************/
		
		log.info("[TESTINGLOG] Check Box test successfully exited.");
	}
}
