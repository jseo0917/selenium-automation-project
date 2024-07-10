package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

	private By boxALocator = By.id("column-a");
	private By boxBLocator = By.id("column-b");
	
	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void dragAndDrop() {
		performDragAndDrop(boxALocator, boxBLocator);
	}
	
	public String getText(By locator) {
		return find(locator).getText();
	}
}
