package com.DemoQA.PageLayers;

import java.util.List;

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
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	private WebElement monthDropdown;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	private WebElement yearDropdown;
	
	@FindBy(xpath="//div[@class='react-datepicker__month']/div/div")
	private List <WebElement> datePicker;
	
	@FindBy(xpath="//div[@class='react-datepicker__day-names']/div")
	private List <WebElement> dayNames;
	
	@FindBy(xpath="//button[text()='Next Month']")
	private WebElement nextMonthButton;
	
	@FindBy(xpath="//button[text()='Previous Month']")
	private WebElement previousMonthButton;
	
	@FindBy(xpath="//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']")
	private WebElement monthYear;
	
	
	

	public List<WebElement> getDayNames() {
		return dayNames;
	}

	public WebElement getNextMonthButton() {
		return nextMonthButton;
	}

	public WebElement getPreviousMonthButton() {
		return previousMonthButton;
	}

	public WebElement getMonthYear() {
		return monthYear;
	}

	public WebElement getMonthDropdown() {
		return monthDropdown;
	}

	public WebElement getYearDropdown() {
		return yearDropdown;
	}

	public List<WebElement> getWeekDays() {
		return dayNames;
	}

	public List<WebElement> getDatePicker() {
		return datePicker;
	}

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
