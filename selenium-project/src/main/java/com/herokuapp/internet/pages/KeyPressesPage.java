package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/key_presses?";
	private By bodyLocator = By.xpath("//body");
	private By resultLocator = By.id("result");
	
	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void pressKey(Keys key) {
		log.info("You pressed Key: " + key.name());
		pressKey(bodyLocator, key);
	}

	public String getResult () {
		return find(resultLocator).getText();
	}
}
