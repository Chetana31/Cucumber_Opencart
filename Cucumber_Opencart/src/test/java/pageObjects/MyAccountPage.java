package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	WebElement header;
	
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement myProfile;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutBtn;
	
	// Actions
	public boolean isMyAccountPageExists() 
	{
		try 
		{
			return(header.isDisplayed());
		} 
		catch (Exception e) 
		{
			return (false);
		}
	}
	
	public void clickMyProfileBtn() 
	{
		myProfile.click();
	}
	
	public void clicklogoutBtn() 
	{
		logoutBtn.click();
	}

}
