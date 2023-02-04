package com.DemoQA.PageLayers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements_WebTables 
{
	WebDriver localDriver;

	public Elements_WebTables(WebDriver rdriver)
	{
		localDriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	
	@FindBy(id="item-3")
	private WebElement webTableDropdownOption;
	
	@FindBy(xpath="//button[@id='addNewRecordButton' and text()='Add']")
	private WebElement addButton;
	
	//registration/add/edit details
	
	
	@FindBy(id="registration-form-modal")
	private WebElement registration;
	
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;

	@FindBy(id="userEmail")
	private WebElement userEmail;
	
	@FindBy(id="age")
	private WebElement age;
	
	@FindBy(id="salary")
	private WebElement salary;
	
	@FindBy(id="department")
	private WebElement department;
	
	@FindBy(xpath="//button[@class='close']")
	private WebElement submit;
	
	@FindBy(id="submit")
	private WebElement closeRegistrationForm;
	
	@FindBy(xpath="//button[text()='Previous']")
	private WebElement previousButton;
	
	@FindBy(xpath="//button[text()='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath="//input[@aria-label='jump to page']")
	private WebElement jumpToPageORcurrentpage;
	
	@FindBy(xpath="//span[@class='-totalPages']")
	private WebElement totalNumberOfPages;
	
	@FindBy(xpath="//select[@aria-label='rows per page']")
	private WebElement rowDropdown;
	
//*****************************************************************************
	
	@FindBy(xpath="//input[@placeholder='Type to search'  or id='searchBox']")
	private WebElement searchbox;
	
	@FindBy(id="basic-addon2")
	private WebElement searchButton;
//-------------------------------------------------------------------------------------	
	@FindBy(id="//div[@class='rt-tr']/div/div[1]")
	private List <WebElement> tableHeaderList;
	
	@FindBy(id="//div[@class='rt-tr-group']")
	private List <WebElement> numberOfRowsPresent;
//---------------------------------------------------------------------------------------------
	
	//row1
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[1]/div/div")
	private List <WebElement> row1List;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[1]/div/div[7]/div/span[1]")
	private WebElement row1Edit;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[1]/div/div[7]/div/span[2]")
	private WebElement row1Delete;

//-----------------------------------------------------------------------
	//row 2

	@FindBy(xpath="//div[@class='rt-tbody']/div[2]/div/div")
	private List <WebElement> row2List;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[2]/div/div[7]/div/span[1]")
	private WebElement row2Edit;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[2]/div/div[7]/div/span[2]")
	private WebElement row2Delete;
	
//--------------------------------------------------------------------------------
	//row 3
	@FindBy(xpath="//div[@class='rt-tbody']/div[3]/div/div")
	private List <WebElement> row3List;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[3]/div/div[7]/div/span[1]")
	private WebElement row3Edit;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[3]/div/div[7]/div/span[2]")
	private WebElement row3Delete;
	
//--------------------------------------------------------------------------------
   //row 4	
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[4]/div/div")
	private List <WebElement> row4List;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[4]/div/div[7]/div/span[1]")
	private WebElement row4Edit;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[4]/div/div[7]/div/span[2]")
	private WebElement row4Delete;

//--------------------------------------------------------------------------------
   //row 5	
	@FindBy(xpath="//div[@class='rt-tbody']/div[5]/div/div")
	private List <WebElement> row5List;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[5]/div/div[7]/div/span[1]")
	private WebElement row5Edit;
	
	@FindBy(xpath="//div[@class='rt-tbody']/div[5]/div/div[7]/div/span[2]")
	private WebElement row5Delete;
	
	
	
//***********************************************************************************************************	
	
	//getters
	
	public WebDriver getLocalDriver() {
		return localDriver;
	}

	public WebElement getAddButton() {
		return addButton;
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

	public WebElement getAge() {
		return age;
	}

	public WebElement getSalary() {
		return salary;
	}

	public WebElement getDepartment() {
		return department;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getCloseRegistrationForm() {
		return closeRegistrationForm;
	}

	public WebElement getPreviousButton() {
		return previousButton;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getJumpToPageORcurrentpage() {
		return jumpToPageORcurrentpage;
	}

	public WebElement getTotalNumberOfPages() {
		return totalNumberOfPages;
	}

	public WebElement getRowDropdown() {
		return rowDropdown;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public List<WebElement> getTableHeaderList() {
		return tableHeaderList;
	}

	public List<WebElement> getNumberOfRowsPresent() {
		return numberOfRowsPresent;
	}

	public List<WebElement> getRow1List() {
		return row1List;
	}

	public WebElement getRow1Edit() {
		return row1Edit;
	}

	public WebElement getRow1Delete() {
		return row1Delete;
	}

	public List<WebElement> getRow2List() {
		return row2List;
	}

	public WebElement getRow2Edit() {
		return row2Edit;
	}

	public WebElement getRow2Delete() {
		return row2Delete;
	}

	public List<WebElement> getRow3List() {
		return row3List;
	}

	public WebElement getRow3Edit() {
		return row3Edit;
	}

	public WebElement getRow3Delete() {
		return row3Delete;
	}

	public List<WebElement> getRow4List() {
		return row4List;
	}

	public WebElement getRow4Edit() {
		return row4Edit;
	}

	public WebElement getRow4Delete() {
		return row4Delete;
	}

	public List<WebElement> getRow5List() {
		return row5List;
	}

	public WebElement getRow5Edit() {
		return row5Edit;
	}

	public WebElement getRow5Delete() {
		return row5Delete;
	}

	public WebElement getWebTableDropdownOption() {
		return webTableDropdownOption;
	}
	
	
	public WebElement getRegistration() {
		return registration;
	}

	
	
}
