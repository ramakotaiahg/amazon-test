package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Utilities;

public class Amazon_login_test extends BaseTest{
	
	@Test(dataProviderClass=Utilities.class,dataProvider="testdata")
	public void login_test(String username,String password) throws InterruptedException {
		WebElement accountList=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		
		//Mouse over on the account and list element to click on login button
		Actions action=new Actions(driver);
		action.moveToElement(accountList).perform();
		
		//Click on login button
		driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")).click();
		
		Thread.sleep(3);
		
		//Verifying the title
		String expected_title="Amazon Sign In";
		String actual_title=driver.getTitle();
		Assert.assertEquals(expected_title, actual_title);
		
		//enter email or ph number
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(username);
		
		//click on continue button
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		//enter password
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		
		//click on sign in button
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		
		
		
		
				
	
	}

	
}
