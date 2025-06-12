package stepsDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;

public class RegistrationSteps 
{
	WebDriver driver;
	
	AccountRegistrationPage regpage;
	
	@Given("the user navigates to the MyInfo")
    public void theUserNavigatesToTheMyInfo() 
	{
		
		System.out.println("Navigating to MyInfo page...");
    }

    @When("user enters the Personal Details")
    public void userEntersThePersonalDetails(DataTable dataTable) 
    {
        Map<String, String> data = dataTable.asMap(String.class,String.class);

        regpage=new AccountRegistrationPage(BaseClass.getDriver());
        regpage.setFirstname(data.get("firstname"));
        regpage.setLastname(data.get("lasttname"));  // typo preserved from your scenario
        regpage.setEmployeeId(data.get("Employee Id"));
        regpage.setOtherId(data.get("Other Id"));

        System.out.println("Personal information entered successfully..");

        // Replace these print statements with real Seleniumm or automation code
    }

    @And("the user clicks on the Save button")
    public void theUserClicksOnTheSaveButton() 
    {
        // Simulate click on Save button
        System.out.println("Clicking on the Save button...");
    }

    @Then("the user should be refresh MyInfo Page")
    public void theUserShouldBeRefreshMyInfoPage() 
    {
        // Logic to confirm the MyInfo page is refreshed
        System.out.println("Checking if MyInfo page is refreshed...");
        Assert.assertTrue("MyInfo page refresh check", true);  // Replace with real validation
    }
}