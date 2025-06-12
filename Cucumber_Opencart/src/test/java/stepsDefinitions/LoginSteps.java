package stepsDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import factory.BaseClass;
import hooks.Hooks;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;
import pageObjects.HomePage;

public class LoginSteps 
{
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	Hooks h;
	
	List<HashMap<String, String>> datamap; // Data driven
	
	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() throws IOException
	{
		
		BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
		hp=new HomePage(BaseClass.getDriver());
		System.out.println("Open URL go to Admin Login page...");
		
	}
	
	@When("the user enters valid username as {string} and password as {string}")
	public void the_user_enters_valid_username_and_password(String username, String password)
	{
		lp=new LoginPage(BaseClass.getDriver());
		lp.enterUsername(username);
		lp.enterPassword(password);
		System.out.println("Credentials entered on Admin Login page...");
	}

	@And("the user click on the login button")
	public void the_user_click_on_the_login_button()
	{
		lp.clickLoginBtn();
		BaseClass.getLogger().info("Click on login button...");
		System.out.println("Clicked on Login button...");

	}

	@Then("the user should be redirected to the My Account page")
	public void the_user_should_be_redirected_to_the_My_Account_page()
	{
		macc=new MyAccountPage(BaseClass.getDriver());
		boolean targetpage = macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
		System.out.println("Admin page is opened...");
	}
	
	//*******   Data Driven test **************
    @Then("the user should be redirected to the MyAccount Page by passing username and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_username_and_password_with_excel_data(String rows)
    {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String username= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        lp.enterUsername(username);
		lp.enterPassword(pwd);

        lp.clickLoginBtn();
        macc=new MyAccountPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=macc.isMyAccountPageExists();
            System.out.println("target page: "+ targetpage);
            if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
                    myaccpage.clicklogoutBtn();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("Invalid"))
            {
                if(targetpage==true)
                {
                    macc.clicklogoutBtn();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      }
	
	
	

}
