package com.DemoQA.PageLayers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormElements 
{
	WebDriver driver;

	public FormElements(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//span[text()='Forms']")
	private WebElement formDropdown;
	
	@FindBy(xpath="//span[text()='Practice Form']")
	private WebElement practiceForm;
	
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
	
	@FindBy(id="uploadPicture")
	private WebElement uploadPicture;
	
	@FindBy(xpath="//textarea[@placeholder='Current Address']")
	private WebElement currentAddress;
	
	@FindBy(xpath="//div[text()='Select State']")
	private WebElement selectState;
	
	@FindBy(xpath="//div[text()='Select City']")
	private WebElement selectCity;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement submitButton;
	
	
	
	
	

	public WebElement getFormDropdown() {
		return formDropdown;
	}

	public WebElement getSelectState() {
		return selectState;
	}

	public WebElement getSelectCity() {
		return selectCity;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	//--------------------------------------------
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getMaleRadio() {
		return maleRadio;
	}

	public WebElement getFemaleRadio() {
		return femaleRadio;
	}

	public WebElement getOtherRadio() {
		return otherRadio;
	}

	public WebElement getUserNumber() {
		return userNumber;
	}

	public WebElement getDateOfBirthInput() {
		return dateOfBirthInput;
	}

	public WebElement getSubjectsInput() {
		return subjectsInput;
	}

	public WebElement getSportChecBox() {
		return sportChecBox;
	}

	public WebElement getReadingChecBox() {
		return readingChecBox;
	}

	public WebElement getMusicChecBox() {
		return musicChecBox;
	}

	public WebElement getUploadPicture() {
		return uploadPicture;
	}

	public WebElement getCurrentAddress() {
		return currentAddress;
	}
	
	public WebElement getformDropdown() {
		return formDropdown;
	}
	
	public WebElement getPracticeForm() {
		return practiceForm;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
