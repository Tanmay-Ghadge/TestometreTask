package com.DemoQA.PageLayers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements_RadioButtons 
{

	WebDriver localDriver;

	public Elements_RadioButtons(WebDriver rdriver)
	{
		localDriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	@FindBy(id="yesRadio")
	private WebElement yesRadioOption;
	
	@FindBy(id="impressiveRadio")
	private WebElement impressiveRadioOption;
	
	@FindBy(id="noRadio")
	private WebElement noRadioOption;
	
	
	
	
	
}
