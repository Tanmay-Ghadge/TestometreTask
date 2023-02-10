package com.DemoQA.Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.DemoQA.ReusableComponents.PropertiesOperations;

public class TestBase 
{
	public static WebDriver driver;
	
	BrowserFactory browserFactoryObject=new BrowserFactory();

	@BeforeMethod
	public void launchApplication() throws Exception
	{
		PropertiesOperations properties=new PropertiesOperations();
		String browser=properties.getPropertiesValue("browser");
		String url=properties.getPropertiesValue("url");
		
		DriverFactory.getInstance().setDriver(browserFactoryObject.selectBrowser(browser));
		
		driver=DriverFactory.getInstance().getDriver();
		System.out.println("driver="+driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		System.out.println("url opened="+url);
	}
	
	@AfterMethod
	public void teardown()
	{
		//driver.quit();
		DriverFactory.getInstance().getDriver().quit();
	}
	
	
	
}
