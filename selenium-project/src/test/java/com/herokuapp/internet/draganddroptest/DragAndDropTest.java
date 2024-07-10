package com.herokuapp.internet.draganddroptest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.DragAndDropPage;
import com.herokuapp.internet.pages.WelcomePage;

public class DragAndDropTest extends TestUtilities {

	@Test
	public void selectingTwoCheckBoxTest() {
		
		log.info("[TESTINGLOG] Drag and drop test started.");
		
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		
		welcomePage.openPage();
		
		/*************************
		 * access to drag and drop page
		 *************************/
		
		DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropLink();
		
		/*************************
		 * Drag And Drop test start
		 *************************/
		
		dragAndDropPage.dragAndDrop();
		
		String box_B = dragAndDropPage.getText(By.id("column-a"));
		
		String box_A = dragAndDropPage.getText(By.id("column-b"));
		
		Assert.assertEquals(box_B, "B");
		
		Assert.assertEquals(box_A, "A");
		
		/*************************
		 * Drag And Drop test end
		 *************************/
		
		log.info("[TESTINGLOG] Drag And Drop test successfully exited.");
	}
}
