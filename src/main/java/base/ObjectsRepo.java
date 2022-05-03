package base;

import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HomePage;
import pages.LoginPage;

public class ObjectsRepo {
	
	public static String executionDate;
	public static String executionDateTime;
	public static WebDriver driver;
    public static ExtentTest report;
    public static ExtentReports extent;	
	public static HomePage home_page;
	public static LoginPage login_page;
}
