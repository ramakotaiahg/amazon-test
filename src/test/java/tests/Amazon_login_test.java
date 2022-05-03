package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import utilities.Utilities;

public class Amazon_login_test extends BaseTest{
	
	@Test(dataProviderClass=Utilities.class,dataProvider="testdata")
	public void login_test(String username,String password) throws InterruptedException {
        report.log(Status.INFO, "USERNAME:"+username+" PASSWORD:"+password);
		
		home_page.goToLoginPage();
		
		login_page.login(username, password);
		
		
				
	
	}

	
}
