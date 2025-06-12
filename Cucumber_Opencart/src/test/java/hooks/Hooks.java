// Hooks.java - contains commons steps or methods from stepDefinition file like @annotation from TestNG
// before executing login and registration steps we execute some common stuff like launching browser, URL, Close browser
// we cannot extends any stepDefinition class in other classes
package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import factory.BaseClass;

public class Hooks
{
	WebDriver driver;
	Properties p;
	
	@Before  // execute before every stepDefinition file like LoginStep.java
	public void setup() throws IOException
	{
		driver = BaseClass.initilizeBrowser(); // decides browser and os from BaseClass.java
		p = BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@After  // execute after every stepDefinition file like LoginStep.java
	public void tearDown(Scenario scenario) // Scenario is predefined method and here we use object
	{
		driver.quit();
	}
	
	@AfterStep // execute after every scenario and capture the screen shorts of failed steps in cucumber Junit report
	public void addScreenshot(Scenario scenario)
	{
		// this is for cucumber Junit report
		if(scenario.isFailed())
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
}
