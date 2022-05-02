package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage extends BaseTest{
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement accountList_Link;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
	WebElement signIn_Button;
	
	
	public HomePage() {
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	public void goToLoginPage() throws InterruptedException {
	       //Mouse over on the account and list element to click on login button
	       Actions action=new Actions(driver);
           action.moveToElement(accountList_Link).perform();
           //Click on login button
           signIn_Button.click();
  		   Thread.sleep(3);
	}

}
