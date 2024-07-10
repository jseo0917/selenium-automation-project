package com.herokuapp.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com/";

	private By fromAuthenticationLinkLocater = By.linkText("Form Authentication");
	private By checkboxesLinkLocator = By.linkText("Checkboxes");
	private By dropDownLinkLocator = By.linkText("Dropdown");
	private By alertLinkLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowsLocator = By.linkText("Multiple Windows");
	private By editorLocator = By.linkText("WYSIWYG Editor");
	private By keyPressesLocator = By.linkText("Key Presses");
	private By fileUploaderLocator = By.linkText("File Upload");
	private By dragAndDropLocator = By.linkText("Drag and Drop");
	private By javaScriptErrorLocator = By.linkText("JavaScript onload event error");
	
	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page successfully opened.");
	}

	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Auth link on welcome page");
		click(fromAuthenticationLinkLocater);
		return new LoginPage(driver, log);
	}

	public CheckboxesPage clickCheckboxesLink() {
		log.info("Clicking Checkboxes link on welcome page");
		click(checkboxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}

	public DropdownPage clickDropdownLink() {
		log.info("Clicking Dropdown link on welcome page");
		click(dropDownLinkLocator);
		return new DropdownPage(driver, log);
	}
	
	public JavaScriptAlertPage clickJSAlertLink() {
		log.info("Clicking JS Alert link on welcome page");
		click(alertLinkLocator);
		return new JavaScriptAlertPage(driver, log);
	}
	
	public MultipleWindowsPage clickMultipleWindowsLink() {
		log.info("Clicking Multiple Windows link on welcome page");
		click(multipleWindowsLocator);
		return new MultipleWindowsPage(driver, log);
	}
	
	public WYSIWYGEditorPage clickWYSIWYGEditorLink() {
		log.info("Clicking WYSIWYG Editor link on welcome page");
		click(editorLocator);
		return new WYSIWYGEditorPage(driver, log);
	}
	
	public  KeyPressesPage clickKeyPressesLink() {
		log.info("Clicking Key Presses link on welcome page");
		click(keyPressesLocator);
		return new KeyPressesPage(driver, log);
	}
	
	public FileUploaderPage clickFileUploaderLink() {
		log.info("Clicking File Uploader link on welcome page");
		click(fileUploaderLocator);
		return new FileUploaderPage(driver, log);
	}
	
	public DragAndDropPage clickDragAndDropLink() {
		log.info("Clicking Drag and Drop link on welcome page");
		click(dragAndDropLocator);
		return new DragAndDropPage(driver, log);
	}
	
	public JSErrorPage clickJSErrorLink() {
		log.info("Clicking JS Error link on welcome page");
		click(javaScriptErrorLocator);
		return new JSErrorPage(driver, log);
	}
}
