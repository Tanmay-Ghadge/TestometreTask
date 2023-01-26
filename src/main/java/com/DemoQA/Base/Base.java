package com.DemoQA.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Base {
	public static WebDriver driver;
	Properties propertiesfile;
	
	
	public void loadConfiguration() throws IOException {
		propertiesfile = new Properties();
		FileInputStream fis = new FileInputStream("./Configuration//Config.properties");

		propertiesfile.load(fis);

		String browserName = propertiesfile.getProperty("browser");
		String url = propertiesfile.getProperty("url");
	
		
	}

	public WebDriver selectBrowser(String browserName) throws IOException 
	{

		switch (browserName.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;



		default:
			System.err.println("please enter valid browser name ");
		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	public void openURL(String url)
	{
		driver.get(url);

	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}
	

}
