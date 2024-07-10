package com.herokuapp.internet.WYSIWYGeditortest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.WYSIWYGEditorPage;
import com.herokuapp.internet.pages.WelcomePage;

public class WYSIWYGEditorTest extends TestUtilities{
	@Test
	public void editorTest() {
		
		log.info("[TESTINGLOG] WYSIWYG Editor test started.");
		
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePageObject = new WelcomePage(driver, log);
		
		welcomePageObject.openPage();
		
		/*************************
		 * access to the WYSIWYG Editor page
		 *************************/	
		
		WYSIWYGEditorPage editorPage = welcomePageObject.clickWYSIWYGEditorLink();
		
		/*************************
		 * start the drop down test
		 *************************/
		
		String actualMessage = editorPage.getEditorText();
		
		String expectedMesasge = "Your content goes here.";
		
		Assert.assertTrue(actualMessage.contains(expectedMesasge));
		
		/*************************
		 * end the WYSIWG Editor test
		 *************************/
		
		log.info("[TESTINGLOG] WYSIWG Editor test successfully exited.");
	}
}
