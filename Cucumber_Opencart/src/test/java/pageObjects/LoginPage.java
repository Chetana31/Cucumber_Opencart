package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement loginPage;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement clickUsername;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement clickPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginBtn;
	
	
	// Actions method
	
	
	public void enterUsername(String uname) 
	{
		clickUsername.sendKeys(uname);
	}

	public void enterPassword(String pwd) 
	{
		clickPassword.sendKeys(pwd);
	}
	
	public void clickLoginBtn() 
	{
		loginBtn.click();
	}
	
}
