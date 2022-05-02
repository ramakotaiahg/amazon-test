package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utilities.Utilities;

public class Amazon_login_test extends BaseTest{
	
	@Test(dataProviderClass=Utilities.class,dataProvider="testdata")
	public void login_test(String username,String password) throws InterruptedException {
	
		HomePage home_page=new HomePage();
		LoginPage login_page=new LoginPage();
		
		home_page.goToLoginPage();
		login_page.login(username, password);
		
		
				
	
	}

	
}
