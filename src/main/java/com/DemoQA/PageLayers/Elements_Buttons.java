package com.DemoQA.PageLayers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements_Buttons 
{

	WebDriver driver;

	public Elements_Buttons(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//button[@id='doubleClickBtn']")
	private WebElement doubleClickBtn;
	
	@FindBy(xpath="//button[@id='rightClickBtn']")
	private WebElement rightClickBtn;
	
	@FindBy(xpath="//button[text()='Click Me']")
	private WebElement ClickBtn;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/p")
	private List <WebElement > buttonConsoleList;
	
	@FindBy(id="rightClickMessage")
	private WebElement rightClickMessageConsole;
	
	@FindBy(id="doubleClickMessage")
	private WebElement doubleClickMessageConsole;
	
	@FindBy(id="dynamicClickMessage")
	private WebElement dynamicClickMessageConsole;
	
	
	
	public WebElement getRightClickMessageConsole() {
		return rightClickMessageConsole;
	}

	public WebElement getDoubleClickMessageConsole() {
		return doubleClickMessageConsole;
	}

	public WebElement getDynamicClickMessageConsole() {
		return dynamicClickMessageConsole;
	}

	public List<WebElement> getButtonConsoleList() {
		return buttonConsoleList;
	}

	public WebElement getButtonsDropdownOption() {
		return buttonsDropdownOption;
	}

	@FindBy(id="item-4")
	private WebElement buttonsDropdownOption;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDoubleClickBtn() {
		return doubleClickBtn;
	}

	public WebElement getRightClickBtn() {
		return rightClickBtn;
	}

	public WebElement getClickButton() {
		return ClickBtn;
	}

	public WebElement getButtonsRadioDropdownOption() {
		return buttonsDropdownOption;
	}
	
	
	
	
	
}
