package com.herokuapp.internet.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void loginTest() {
		String url = "https://the-internet.herokuapp.com/login";
		
		driver.get(url);
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		
		WebElement loginBtn = driver.findElement(By.xpath("//form[@id='login']/button[@class='radius']"));
		loginBtn.click();
		
		WebElement flash = driver.findElement(By.id("flash"));
		
		String actualText = flash.getText();
		
		String expectedText = "You logged into a secure area!";
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		WebElement logOutBtn = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']"));
		
		Assert.assertTrue(logOutBtn.isDisplayed());
		
	}
}
