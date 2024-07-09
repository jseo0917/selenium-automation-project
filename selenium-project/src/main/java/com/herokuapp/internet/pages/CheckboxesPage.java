package com.herokuapp.internet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/checkboxes";
	private By checkBox = By.xpath("//input[@type='checkbox']");
	
	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getUrl() {
		return pageUrl;
	}
	
	public void selectAllCheckboxes() {
		
		List<WebElement> checkboxes = findAll(checkBox);
		
		for (WebElement checkbox : checkboxes) {
			if(!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}
	
	public Boolean checkAllCheckboxesSelected() {
		
		List<WebElement> checkboxes = findAll(checkBox);
		
		for (WebElement checkbox : checkboxes) {
			if(!checkbox.isSelected()) {
				return false;
			}
		}
		
		return true;
	}
}
