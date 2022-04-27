package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	String browser="chrome";
	String ApplicationURL="https://www.amazon.in/";
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		if(browser.contentEquals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(browser.contentEquals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browser.contentEquals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.get(ApplicationURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}