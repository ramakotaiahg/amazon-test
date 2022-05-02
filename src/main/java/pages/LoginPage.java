package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;

public class LoginPage extends BaseTest{
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement email_TextBox;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continue_Button;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password_TextBox;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signIn_Button;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void login(String username,String password) {
	       //Verifying the title
			String expected_title="Amazon Sign In";
			String actual_title=driver.getTitle();
			Assert.assertEquals(expected_title, actual_title);
			
			//enter email or ph number
			email_TextBox.sendKeys(username);
			//click on continue button
			continue_Button.click();
			//enter password
			password_TextBox.sendKeys(password);
			//click on sign in button
			signIn_Button.click();
	}

}
