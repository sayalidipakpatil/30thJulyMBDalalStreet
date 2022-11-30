package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class LoginPage extends TestBase {
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	//----------obj repo--------------------
	@FindBy(xpath="//input[@name='email']")
	private WebElement email_txt;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passw_txt;
	
	@FindBy(xpath="//button[text()='Log In']")
	private WebElement login_btn;
	
	//--------action methods----------------
	public void enterEmailId(String email)
	{
		email_txt.sendKeys(email);
	}
	
	public void enterPassword(String password) 
	{
		passw_txt.sendKeys(password);
	}
	public void clickOnLoginButton()
	{
		login_btn.click();
	}
	public String getCURL()
	{
		String url=driver.getCurrentUrl();
		return url;
	}
}
