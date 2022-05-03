package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import utilities.Utilities;

public class BaseTest extends ObjectsRepo {
	
	
	String browser=Utilities.read_propert_value("BROWSER");
	String ApplicationURL=Utilities.read_propert_value("URL");
	
	
	
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
		
		
		//Page Objects Initialization
		home_page=new HomePage();
		login_page=new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
