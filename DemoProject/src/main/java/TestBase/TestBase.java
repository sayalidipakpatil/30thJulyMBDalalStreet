package TestBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import PageLayer.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Logger logger;
	public LoginPage login;

	
	@BeforeClass
	public void start()
	{
	    logger=Logger.getLogger("Dalalstreet Auto framework");
	    PropertyConfigurator.configure("log4j.properties");
		
		logger.info("framework execution started");
	}
	
	@AfterClass
	public void end()
	{
		logger.info("framework execution completed");
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) throws InterruptedException    //string br="chrome"
	{
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
		    driver=new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		}
		else
		{
			System.out.println("please provide correct browser");
		}	
		driver.get("https://apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		logger.info("url launches,maximize,and provided waits");
		
		//=========obj creation========================
		
		login=new LoginPage();
		
		logger.info("object creations");
		
		//============login page=================
		login.enterEmailId("amarwaghmare573@gmail.com");
		login.enterPassword("Test@1234");
		login.clickOnLoginButton();
		Thread.sleep(3000);
		
		logger.info("login successful");
	}
	
	@AfterMethod
	public void teardown() 
	{
		//driver.quit();
	}


}
