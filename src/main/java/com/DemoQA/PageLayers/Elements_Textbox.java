package com.DemoQA.PageLayers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.Base.DriverFactory;

public class Elements_Textbox 
{

	static WebDriver localDriver=DriverFactory.getInstance().getDriver();

	public Elements_Textbox(WebDriver rdriver)
	{
		localDriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	@FindBy(id="userName")
	private WebElement fullName;
	
	@FindBy(id="userEmail")
	private WebElement email;
	
	@FindBy(xpath="//textarea[@placeholder='Current Address']")
	private WebElement currentAdress;
	
	@FindBy(css="textarea#permanentAddress")
	private WebElement permanetAdress;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement submit;
	
	@FindBy(css="div.main-header")
	private WebElement mainHeader;
		
	public WebDriver getLocalDriver() {
		return localDriver;
	}

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getCurrentAdress() {
		return currentAdress;
	}

	public WebElement getPermanetAdress() {
		return permanetAdress;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getMainHeader() {
		return mainHeader;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	

}
