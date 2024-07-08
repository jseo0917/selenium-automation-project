package com.herokuapp.internet.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;

public class NegativeLoginTests extends TestUtilities {
	
	
	@Parameters({"username","password", "expectedMessage"})
	@Test(priority =1)
	public void negativeTests(@Optional("username") String username, String password, String expectedErrorMessage) {		
		String url = "https://the-internet.herokuapp.com/login";		
		driver.get(url);
		
		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.sendKeys(username);
		
		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.sendKeys(password);
		
		WebElement loginBtn = driver.findElement(By.xpath("//form[@id='login']/button[@class='radius']"));
		
		loginBtn.click();
		
		WebElement flash = driver.findElement(By.id("flash"));
                
		String actualText = flash.getText();
						
		Assert.assertTrue(actualText.contains(expectedErrorMessage));
		
	}	
}
