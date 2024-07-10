package com.herokuapp.internet.fileuploadtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.FileUploaderPage;
import com.herokuapp.internet.pages.WelcomePage;

public class FileUploaderTest extends TestUtilities {
	@Test
	public void fileUploaderTest() {
		
		log.info("FileUploader Test started.");
		
		/*************************
		 * access to welcome page
		 *************************/
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		
		welcomePage.openPage();
		
		/*************************
		 * access to File uploader Page
		 *************************/
		
		FileUploaderPage fileUploaderPage = welcomePage.clickFileUploaderLink();
		
		/*************************
		 * File Uploader test start
		 *************************/
		
		String fileName = "Testing.txt";
		
		fileUploaderPage.chooseFile(fileName);
		
		fileUploaderPage.hitUpload();
		
		String actualFileName = fileUploaderPage.getUploadedFileName();
		
		String expectedFileName = "Testing.txt";
		
		Assert.assertEquals(actualFileName, expectedFileName);
		
		/*************************
		 * File Uploader test end
		 *************************/
		
		log.info("File Uploader test successfully exited.");
	}
}
