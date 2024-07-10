package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAlertPage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/javascript_alerts";
	
	private By jsAlertButtonLocator = By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']");
	private By jsConfirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
	private By jsPromptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
	private By resultLocator = By.id("result");
	
	public JavaScriptAlertPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void clickForJSAlert() {
		click(jsAlertButtonLocator);
	}
	
	public void clickForJSConfirm() {
		click(jsConfirmButtonLocator);
	}
	
	public void clickForJSPrompt() {
		click(jsPromptButtonLocator);
	}
	
	public String getAlertMessage() {
		Alert getAlert = switchToAlert();
		return getAlert.getText();
	}
	
	public String getResultMessage() {
		WebElement result = find(resultLocator);
		return result.getText();
	}
	
	public void acceptAlert() {
		Alert getAlert = switchToAlert();
		getAlert.accept();
	}
	
	public void cancelAlert() {
		Alert getAlert = switchToAlert();
		getAlert.dismiss();
	}
	
	public void writeAlertPrompt(String prompt) {
		Alert getAlert = switchToAlert();
		getAlert.sendKeys(prompt);
		getAlert.accept();
	}
}
