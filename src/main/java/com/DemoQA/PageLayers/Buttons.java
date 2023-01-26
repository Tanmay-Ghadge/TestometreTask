package com.DemoQA.PageLayers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buttons 
{

	WebDriver driver;

	Buttons(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//button[@id='doubleClickBtn']")
	private WebElement doubleClickBtn;
	
	@FindBy(xpath="//button[@id='rightClickBtn']")
	private WebElement rightClickBtn;
	
	@FindBy(id="e4BFS")
	private WebElement ClickBtn;
	
	
	
	
	
	
}
