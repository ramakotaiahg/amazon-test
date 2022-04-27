package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class Amazon_test_1 extends BaseTest{
	
	
	@Test
	public void amazon_HamePage_Title_Verification() {
		System.out.println("Validating the amazon home page title");
		String expected_title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual_title=driver.getTitle();
		Assert.assertEquals(expected_title, actual_title);
	}
	
	
	
}
