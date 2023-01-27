package com.DemoQA.PageLayers;

import java.util.List;

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
	
	@FindBy(id="submit")
	private WebElement submit;
	
	@FindBy(css="div.main-header")
	private WebElement mainHeader;
	
	@FindBy(id="item-0")
	private static WebElement textboxDropdownOption;
	
	//console elements
	@FindBy(id="output")
	private static WebElement consoleOutput;
	
	

	@FindBy(xpath="//div[@id='output']/div/p")
	private List<WebElement> elementsOfConsole;
	
	@FindBy(xpath="//p[@id='name']")
	private WebElement consoleOutputName;
	
	@FindBy(xpath="//p[@id='email']")
	private WebElement consoleOutputemail;
	
	@FindBy(xpath="//p[@id='currentAddress']")
	private WebElement consoleOutputCurrentAddress;
	
	@FindBy(xpath="//p[@id='permanentAddress']")
	private WebElement consoleOutputPermanentAddress;
	
	
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

	public static WebElement getTextboxDropdownOption() {
		return textboxDropdownOption;
	}

	public WebElement getConsoleOutputName() {
		return consoleOutputName;
	}

	public WebElement getConsoleOutputemail() {
		return consoleOutputemail;
	}

	public WebElement getConsoleOutputCurrentAddress() {
		return consoleOutputCurrentAddress;
	}

	public WebElement getConsoleOutputPermanentAddress() {
		return consoleOutputPermanentAddress;
	}


	public static void clicktextboxDropdownOption() {
		textboxDropdownOption.click();		
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
