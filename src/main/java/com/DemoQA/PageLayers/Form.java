package com.DemoQA.PageLayers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Form 
{
	WebDriver driver;

	Form(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="userEmail")
	private WebElement userEmail;
	
	@FindBy(xpath="//input[@value='Male']")
	private WebElement maleRadio;
	
	@FindBy(xpath="//input[@value='Female']")
	private WebElement femaleRadio;
	
	@FindBy(xpath="//input[@value='Other']")
	private WebElement otherRadio;
	
	@FindBy(id="userNumber")
	private WebElement userNumber;
	
	@FindBy(id="dateOfBirthInput")
	private WebElement dateOfBirthInput;
	
	@FindBy(id="subjectsInput")
	private WebElement subjectsInput;
	
	@FindBy(id="hobbies-checkbox-1")
	private WebElement sportChecBox;
	
	@FindBy(id="hobbies-checkbox-2")
	private WebElement readingChecBox;
	
	@FindBy(id="hobbies-checkbox-3")
	private WebElement musicChecBox;
	
	@FindBy(css="input.uploadPicture")
	private WebElement uploadPicture;
	
	@FindBy(xpath="//textarea[@placeholder='Current Address']")
	private WebElement currentAddress;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
