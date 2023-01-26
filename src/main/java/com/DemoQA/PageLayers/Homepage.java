package com.DemoQA.PageLayers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.Base.DriverFactory;
import com.DemoQA.actiondriver.ActionDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage 
{

	static WebDriver localDriver;;


	public Homepage(WebDriver rdriver)
	{
		localDriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	@FindBy(css="div.body-height:nth-child(2) div.home-content div.home-body div.category-cards div.card.mt-4.top-card:nth-child(1) div:nth-child(1) div.avatar.mx-auto.white > svg:nth-child(1)")
	private WebElement elements;

	@FindBy(linkText="Forms")
	private WebElement forms;

	@FindBy(linkText="Alerts, Frame & Windows")
	private WebElement alertsFrameWindows;

	@FindBy(linkText="Widgets")
	private WebElement widgets;

	@FindBy(linkText="Interactions")
	private WebElement interactions;

	@FindBy(linkText="Book Store Application")
	private WebElement bookStore;







	/*----------------------------page methods------------------------------*/

	public boolean pageValidation(WebDriver driver)
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="ToolsQA";


		if(actualTitle.equals(expectedTitle))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public void clickElement()
	{
		elements.click();
	}

	public void clickForms()
	{
		forms.click();
	}

	public void clickAlertsFrameWindows()
	{
		alertsFrameWindows.click();
	}

	public void clickWidgets()
	{
		widgets.click();
	}

	public void clickInteractions()
	{
		interactions.click();
	}

	public void clickBookStore()
	{
		bookStore.click();
	}

	public boolean iselementVisible(String elementVisibleName)
	{
		switch (elementVisibleName.toLowerCase()) 
		{
		case "elements":
		boolean	flag=ActionDriver.checkElementVisibility(elements);
			return flag;

		case "forms":
			boolean	flag2=ActionDriver.checkElementVisibility(forms);
			return flag2;
			
		case "alertsFrameWindows":
			boolean	flag3=ActionDriver.checkElementVisibility(alertsFrameWindows);
			return flag3;
			
		case "widgets":
			boolean	flag4=ActionDriver.checkElementVisibility(widgets);
			return flag4;
			
		case "interactions":
			boolean	flag5=ActionDriver.checkElementVisibility(interactions);
			return flag5;
			
		case "bookStore":
			boolean	flag6=ActionDriver.checkElementVisibility(bookStore);
			return flag6;
			

		default:
			System.err.println("please enter valid element name ");
			return false;
		}
	}

	public void clickElement(String elementToClick)
	{
		switch (elementToClick.toLowerCase()) 
		{
		case "elements":
			elements.click();
			break;

		case "forms":
			forms.click();
			break;
			
		case "alertsFrameWindows":
			alertsFrameWindows.click();
			break;
			
		case "widgets":
			widgets.click();
			break;
			
		case "interactions":
			interactions.click();
			break;
			
		case "bookStore":
			bookStore.click();
			break;

		default:
			System.err.println("please enter valid element name to click ");
		}
		
		
		
	}




}
