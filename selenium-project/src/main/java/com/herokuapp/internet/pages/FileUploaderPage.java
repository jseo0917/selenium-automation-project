package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject{

	private By chooseFileLocator = By.id("file-upload");
	private By uploadLocator = By.id("file-submit");
	private By uploadedFilesLocator = By.id("uploaded-files");
	
	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void chooseFile(String fileName) {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
		upload(filePath, chooseFileLocator);
	}
	
	public void hitUpload() {
		log.info("File Successfully uploaded.");
		find(uploadLocator).click();
	}
	
	public String getUploadedFileName() {
		return find(uploadedFilesLocator).getText();
	}
}
