package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/dropdown";
	private By dropdownLocator = By.id("dropdown");

	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public String getUrl() {
		return pageUrl;
	}

	public void selectOption(int value) {
		WebElement dropdownElement = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue("" + value);
	}

	public String getSelectedOption() {
		WebElement dropdownElement = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is chosen in dropdown option.");
		return selectedOption;

	}

}
