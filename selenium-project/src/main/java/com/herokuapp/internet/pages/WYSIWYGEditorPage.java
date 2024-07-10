package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage extends BasePageObject{

	private String pageURL = "https://the-internet.herokuapp.com/tinymce";
	private By editorTextLocator = By.id("tinymce");
	private By frameLocator = By.id("mce_0_ifr");
	public WYSIWYGEditorPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getEditorText() {		
		log.info("Switch to Iframe and get the text.");
		switchToFrame(frameLocator);
		return find(editorTextLocator).getText();
	}
}
