// BaseClass mainly responsible for initializing the driver
package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass 
{
	static WebDriver driver;
	static Properties p;
	static Logger logger; // log4j
	
	@SuppressWarnings("deprecation")
	public static WebDriver initilizeBrowser() throws IOException // this method will decide OS and browser and it is call in Hooks.java
	{
		p=getProperties(); // this method will load the properties file that is config.properties
		String executionEnv = p.getProperty("execution_env");
		String browser = p.getProperty("browser").toLowerCase();
		String os = p.getProperty("os").toLowerCase();
		
		// for remotely execution
		if(executionEnv.equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			// OS - 
			switch (os) 
			{
				case "windows": 
					capabilities.setPlatform(Platform.WINDOWS);			
					break;
					
				case "mac": 
					capabilities.setPlatform(Platform.MAC);		
					break;
					
				case "linux": 
					capabilities.setPlatform(Platform.LINUX);		
					break;
	
				default:
					System.out.println("No matching os...");
					return null;
			}
			
			switch (browser) 
			{
				case "chrome": 
					capabilities.setBrowserName("chrome");
					break;
				
				case "edge": 
					capabilities.setBrowserName("MicrosoftEdge");
					break;
					
				default:
					System.out.println("No matching browser...");
					return null;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/ui/#/sessions"),capabilities);
		}
		
		// for local environment execution
		else if (executionEnv.equalsIgnoreCase("local")) 
		{
			switch (browser.toLowerCase()) 
			{
				case "chrome": 
					driver=new ChromeDriver();				
					break;
					
				case "edge": 
					driver=new EdgeDriver();				
					break;
	
				default:
					System.out.println("No matching browser...");
					driver=null;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		return driver;
	}
	
	public static WebDriver getDriver() // this method will return the driver and it initialize in WebDriver initilizeBrowser() method
	{
		return driver;
	}

	public static Properties getProperties() throws IOException // this method will load the properties file that is config.properties
	{
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{
		logger=LogManager.getLogger(); // log4j
		return logger;
	}
	
	public static String randomeString() 
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
		
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}
	

}