package tests;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DemoQA.Base.TestBase;
import com.DemoQA.Dataprovider.Dataproviders;
import com.DemoQA.PageLayers.Elements_Checkbox;
import com.DemoQA.PageLayers.Elements_Textbox;
import com.DemoQA.PageLayers.Elements_WebTables;
import com.DemoQA.PageLayers.FormElements;
import com.DemoQA.PageLayers.Homepage;
import com.DemoQA.actiondriver.ActionDriver;
public class Webtable extends TestBase
{
	void reachWebtable() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(3000);

		homepage.clickElement2();
		Thread.sleep(2000);
		webtable.getWebTableDropdownOption().click();
		Thread.sleep(2000);
	}

	@Test(description ="Verify that buttons basic Webelements are visible to user suh as Add,Searcbox,search button,previous,"
			+ "next button,row dropdown ,fields in Add ,edit and delete button in each row" )
	void checkVisbilityOfElements() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softassert=new SoftAssert();

		reachWebtable();

		boolean add=webtable.getAddButton().isDisplayed();
		softassert.assertTrue(add,"add button <--header is not displayed");	

		boolean searchbox=webtable.getSearchbox().isDisplayed();
		softassert.assertTrue(searchbox,"searchbox <--header is not displayed");	

		boolean searchButton=webtable.getSearchButton().isDisplayed();
		softassert.assertTrue(searchButton,"searchButton <--header is not displayed");	

		boolean previousButton=webtable.getPreviousButton().isDisplayed();
		softassert.assertTrue(previousButton,"previousButton <--header is not displayed");	

		boolean nextButton=webtable.getNextButton().isDisplayed();
		softassert.assertTrue(nextButton," nextButton<--header is not displayed");	

		boolean rowDropdown=webtable.getRowDropdown().isDisplayed();
		softassert.assertTrue(rowDropdown," rowDropdown<--header is not displayed");	

		List <WebElement> headerElements=webtable.getTableHeaderList();

		boolean flag=false;

		for(WebElement headerElement:headerElements)
		{
			flag=headerElement.isDisplayed();
			if(flag==false)
			{
				String headerName=headerElement.getText();
				System.out.println(headerName);
				softassert.assertTrue(flag,headerName+" <--header is not displayed");	
			}

		}


		softassert.assertAll();

	}

	@Test(description ="verify that by default total number of columns present are 7")
	void test() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softassert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		List<WebElement> headerList= webtable.getTableHeaderList();
		Thread.sleep(1000);

		int headerElementCount=headerList.size();

		Assert.assertEquals(headerElementCount, 7);
	}

	@Test(description ="Verify the Sequence in which coulumns are visible to user")
	void verifyColumnSequence() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softassert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		List<WebElement> headerList= webtable.getTableHeaderList();

		List HeaderNames=new ArrayList<String>();

		for(WebElement headerElement:headerList)
		{
			String headername=headerElement.getText();
			HeaderNames.add(headername);
		}

		softassert.assertEquals(HeaderNames.get(0), "First Name");
		softassert.assertEquals(HeaderNames.get(1), "Last Name");
		softassert.assertEquals(HeaderNames.get(2), "Age");
		softassert.assertEquals(HeaderNames.get(3), "Email");
		softassert.assertEquals(HeaderNames.get(4), "Salary");
		softassert.assertEquals(HeaderNames.get(5), "Department");
		softassert.assertEquals(HeaderNames.get(6), "Action");
		softassert.assertAll();

	}

	@Test(description ="verify that by default 5 rows are selected in dropdown and 5 rows displayed to the user")
	void vverifyNumberOfRowsVisible() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softassert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);

		String value=ActionDriver.actionGetAttribute(webtable.getJumpToPageORcurrentpage(),"value");

		String a=webtable.getRowDropdown().getText();


		//right locator but list is returning as empty
		List<WebElement> rows=webtable.getNumberOfRowsPresent();
		System.out.println(rows.size());

		Assert.assertEquals(rows.size(), 5);

	}

	@Test(description ="Verify that placeholders in searchbox and in add field elements")
	void checkPlaceholders() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softassert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);

		String searchBox=ActionDriver.actionGetAttribute(webtable.getSearchbox(),"placeholder");
		webtable.getAddButton().click();
		String firstName=ActionDriver.actionGetAttribute(webtable.getFirstName(),"placeholder");
		String lastname=ActionDriver.actionGetAttribute(webtable.getLastName(),"placeholder");
		String email=ActionDriver.actionGetAttribute(webtable.getUserEmail(),"placeholder");
		String salary=ActionDriver.actionGetAttribute(webtable.getSalary(),"placeholder");
		String age=ActionDriver.actionGetAttribute(webtable.getAge(),"placeholder");
		String department=ActionDriver.actionGetAttribute(webtable.getDepartment(),"placeholder");

		softassert.assertEquals(searchBox, "Type to search");
		softassert.assertEquals(firstName, "First Name");
		softassert.assertEquals(lastname, "Last Name");
		softassert.assertEquals(email, "email@Gmail.com");
		softassert.assertEquals(salary, "Salary");
		softassert.assertEquals(age, "Age");
		softassert.assertEquals(department, "Department");

		softassert.assertAll();
	}

	@Test(description ="Verify that when clicked on add button registration form should appear on the screen")
	void checkAddPaged() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softassert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		boolean firstnName=webtable.getFirstName().isDisplayed();
		softassert.assertTrue(firstnName,"firstnName <--header is not displayed");

		boolean rowDropdown1=webtable.getRowDropdown().isDisplayed();
		softassert.assertTrue(rowDropdown1,"rowDropdown <--header is not displayed");	

		boolean lastName=webtable.getLastName().isDisplayed();
		softassert.assertTrue(lastName,"lastName <--header is not displayed");	

		boolean salary=webtable.getSalary().isDisplayed();
		softassert.assertTrue(salary,"salary <--header is not displayed");	

		boolean age=webtable.getAge().isDisplayed();
		softassert.assertTrue(age,"age <--header is not displayed");	

		boolean department=webtable.getDepartment().isDisplayed();
		softassert.assertTrue(department,"department <--header is not displayed");	

		boolean email=webtable.getUserEmail().isDisplayed();
		softassert.assertTrue(email,"email <--header is not displayed");	

		boolean submit=webtable.getSubmit().isDisplayed();
		softassert.assertTrue(submit,"submit <--header is not displayed");	

		boolean closeRegistration=webtable.getCloseRegistrationForm().isDisplayed();
		softassert.assertTrue(closeRegistration,"closeRegistration <--header is not displayed");	

		softassert.assertAll();
	}

	@Test(description ="first name negative tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void firstNameValidationNegative(String[] firstnameValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	


		webtable.getFirstName().sendKeys(firstnameValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getFirstName(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#dc3545");
	}

	@Test(description ="first name positive tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void firstNameValidationPositive(String[] firstnameValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getFirstName().sendKeys(firstnameValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getFirstName(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#28a745");
	}

	@Test(description ="Last name negative tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void lastNameValidationNegative(String[] lastNameValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getLastName().sendKeys(lastNameValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getLastName(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#dc3545");
	}

	@Test(description ="last name positive tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void lastNameValidationPositive(String[] firstnameValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getLastName().sendKeys(firstnameValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getLastName(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#28a745");
	}

	@Test(description ="Email negative tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void emailNameValidationNegative(String[] emailValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getUserEmail().sendKeys(emailValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getUserEmail(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#dc3545");
	}

	@Test(description ="Email positive tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void emailNameValidationPositive(String[] emailValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getUserEmail().sendKeys(emailValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getUserEmail(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#28a745");
	}

	@Test(description ="Age negative tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void ageValidationNegative(String[] ageValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getAge().sendKeys(ageValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getAge(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#dc3545");
	}

	@Test(description ="Age positive tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void ageValidationPositive(String[] ageValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getAge().sendKeys(ageValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getAge(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#28a745");
	}

	@Test(description ="Salary negative tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void salaryNameValidationNegative(String[] salaryValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getSalary().sendKeys(salaryValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getSalary(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#dc3545");
	}

	@Test(description ="Salary positive tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void salaryValidationPositive(String[] salaryValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getSalary().sendKeys(salaryValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getSalary(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#28a745");
	}

	@Test(description ="Salary negative tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void departmentNameValidationNegative(String[] departmentValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getDepartment().sendKeys(departmentValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getDepartment(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#dc3545");
	}

	@Test(description ="Salary positive tc",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void departmentValidationPositive(String[] departmentValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getDepartment().sendKeys(departmentValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(webtable.getDepartment(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex,"#28a745");
	}

	@Test(description ="Verify that when correct information filled in all the field and pressed enter record should be created",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void fillCorrectDetails(String[] departmentValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		webtable.getAddButton().click();	

		webtable.getFirstName().sendKeys(departmentValues);
		webtable.getLastName().sendKeys(departmentValues);
		webtable.getUserEmail().sendKeys(departmentValues);
		webtable.getAge().sendKeys(departmentValues);
		webtable.getSalary().sendKeys(departmentValues);
		webtable.getDepartment().sendKeys(departmentValues);
		webtable.getSubmit().click();

		List<WebElement> rowVAlues=webtable.getRowList(2);

		List<String> rowStringValues=new ArrayList<String>();

		for(WebElement rowVAlue:rowVAlues)
		{
			String rowValue=	rowVAlue.getText();
			rowStringValues.add(rowValue);
		}

		softAssert.assertEquals(rowStringValues.get(0), "first name");
		softAssert.assertEquals(rowStringValues.get(1), "last name");
		softAssert.assertEquals(rowStringValues.get(2), "email");
		softAssert.assertEquals(rowStringValues.get(3), "salary");
		softAssert.assertEquals(rowStringValues.get(4), "age");
		softAssert.assertEquals(rowStringValues.get(5), "department");


	}

	@Test(description ="Verify that when correct information filled in all the field and pressed enter record should be created")
	void getLatestRecord() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);


		List<WebElement> rowVAlues=webtable.getRowList(3);

		List<String> rowStringValues=new ArrayList<String>();

		for(WebElement rowVAlue:rowVAlues)
		{
			String rowValue=	rowVAlue.getText();
			System.out.println(rowValue);
			rowStringValues.add(rowValue);
		}
	}

	@Test(description ="Verify that When user search with First name relevant results should be displayed")
	void checkSearchByfirstName() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		//search by first name
		webtable.getSearchbox().sendKeys("Alden");
		webtable.getSearchbox().click();

		List<WebElement> rowVAlues=webtable.getRowList(1);

		List<String> rowStringValues=new ArrayList<String>();

		for(WebElement rowVAlue:rowVAlues)
		{
			String rowValue=	rowVAlue.getText();
			System.out.println(rowValue);
			rowStringValues.add(rowValue);
		}

		Assert.assertEquals(rowStringValues.get(0),"Alden");

	}

	@Test(description ="Verify that When user search with Last name relevant results should be displayed")
	void checkSearchByLastName() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		//search by first name
		webtable.getSearchbox().sendKeys("Vega");
		webtable.getSearchbox().click();

		List<WebElement> rowVAlues=webtable.getRowList(1);

		List<String> rowStringValues=new ArrayList<String>();

		for(WebElement rowVAlue:rowVAlues)
		{
			String rowValue=	rowVAlue.getText();
			System.out.println(rowValue);
			rowStringValues.add(rowValue);
		}

		Assert.assertEquals(rowStringValues.get(1),"Vega");

	}

	@Test(description ="Verify that When user search with age relevant results should be displayed")
	void checkSearchByAge() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		//search by first name
		webtable.getSearchbox().sendKeys("29");
		webtable.getSearchbox().click();

		List<WebElement> rowVAlues=webtable.getRowList(1);

		List<String> rowStringValues=new ArrayList<String>();

		for(WebElement rowVAlue:rowVAlues)
		{
			String rowValue=	rowVAlue.getText();
			System.out.println(rowValue);
			rowStringValues.add(rowValue);
		}

		Assert.assertEquals(rowStringValues.get(2),"29");

	}

	@Test(description ="Verify that When user search with email relevant results should be displayed")
	void checkSearchByEmail() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		//search by first name
		webtable.getSearchbox().sendKeys("kierra@example.com");
		webtable.getSearchbox().click();

		List<WebElement> rowVAlues=webtable.getRowList(1);

		List<String> rowStringValues=new ArrayList<String>();

		for(WebElement rowVAlue:rowVAlues)
		{
			String rowValue=	rowVAlue.getText();
			System.out.println(rowValue);
			rowStringValues.add(rowValue);
		}

		Assert.assertEquals(rowStringValues.get(3),"kierra@example.com");

	}

	@Test(description ="Verify that When user search with email relevant results should be displayed")
	void checkSearchBySalary() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		//search by salary
		webtable.getSearchbox().sendKeys("12000");
		webtable.getSearchbox().click();

		// first result that comes must have salary=12000
		List<WebElement> rowVAlues=webtable.getRowList(1);

		List<String> rowStringValues=new ArrayList<String>();

		for(WebElement rowVAlue:rowVAlues)
		{
			String rowValue=	rowVAlue.getText();
			System.out.println(rowValue);
			rowStringValues.add(rowValue);
		}

		Assert.assertEquals(rowStringValues.get(4),"12000");

	} 	

	@Test(description ="Verify that When user search with email relevant results should be displayed")
	void checkSearchByDepartment() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		//search by salary
		webtable.getSearchbox().sendKeys("Compliance");
		webtable.getSearchbox().click();

		// first result that comes must have salary=12000
		List<WebElement> rowVAlues=webtable.getRowList(1);

		List<String> rowStringValues=new ArrayList<String>();

		for(WebElement rowVAlue:rowVAlues)
		{
			String rowValue=	rowVAlue.getText();
			System.out.println(rowValue);
			rowStringValues.add(rowValue);
		}

		Assert.assertEquals(rowStringValues.get(5),"Compliance");

	} 	

	@Test(description ="Verify that when searched  by value which more than one record contains then results"
			+ " should be shown in alphabetical order")
	void searchEmployeeWithCommonData() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);

		//Add a new Employee
		webtable.getAddButton().click();
		webtable.getFirstName().sendKeys("anmay");
		webtable.getLastName().sendKeys("b");
		webtable.getUserEmail().sendKeys("cssdv@gmail.com");
		webtable.getAge().sendKeys("39");
		webtable.getSalary().sendKeys("1258444");
		webtable.getDepartment().sendKeys("it");
		//submit click didn't create record
		ActionDriver.pressEnterRobot();

		//search by age
		webtable.getSearchbox().sendKeys("39");
		webtable.getSearchbox().click();

		// first result that comes must have salary=12000
		List<WebElement> rowVAlues=webtable.getRowList(1);

		List<String> rowStringValues=new ArrayList<String>();

		for(WebElement rowVAlue:rowVAlues)
		{
			String rowValue=	rowVAlue.getText();
			System.out.println(rowValue);
			rowStringValues.add(rowValue);
		}

		Assert.assertEquals(rowStringValues.get(0),"tanmay");

	} 	

	@Test(description ="Verify that user should be able to able to edit searched records")
	void editSearchedRecords() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);

		//search by age
		webtable.getSearchbox().sendKeys("39");
		webtable.getSearchbox().click();

		// edit first row 
		webtable.getRowEditButton(1).click();

		//while editing existing records values should be already present in the fields
		//clear salary and department
		//change salary from 10000 to 100000
		//change department from Insurance to Finance
		// validate edited changes made are available in the table
		if(	webtable.getFirstName().isDisplayed()==true)
		{
			String firstName=ActionDriver.actionGetAttribute(webtable.getFirstName(), "value");
			if(firstName.isEmpty())
			{
				softAssert.assertTrue(false);
			}
		}

		if(	webtable.getLastName().isDisplayed()==true)
		{
			String lastName=ActionDriver.actionGetAttribute(webtable.getLastName(), "value");
			if(lastName.isEmpty())
			{
				softAssert.assertTrue(false);
			}
		}

		if(	webtable.getUserEmail().isDisplayed()==true)
		{
			String email=ActionDriver.actionGetAttribute(webtable.getUserEmail(), "value");
			if(email.isEmpty())
			{
				softAssert.assertTrue(false);
			}
		}

		if(	webtable.getSalary().isDisplayed()==true)
		{
			String salary=ActionDriver.actionGetAttribute(webtable.getSalary(), "value");
			if(salary.isEmpty())
			{
				softAssert.assertTrue(false);
			}
			else if(salary.equals("10000"))
			{
				webtable.getSalary().clear();
				webtable.getSalary().sendKeys("100000");
			}
		}

		if(	webtable.getDepartment().isDisplayed()==true)
		{
			String department=ActionDriver.actionGetAttribute(webtable.getDepartment(), "value");
			if(department.isEmpty())
			{
				softAssert.assertTrue(false);
			}
			else if(department.equals("Insurance"))
			{
				webtable.getDepartment().clear();
				webtable.getDepartment().sendKeys("Finance");
			}
		}
		//submit button didn't work
		ActionDriver.pressEnterRobot();


		List<WebElement> updatedRow=   webtable.getRowList(1);


		softAssert.assertEquals(updatedRow.get(4).getText(),"100000");//updated salary
		softAssert.assertEquals(updatedRow.get(5).getText(), "Finance");//updated Department

		softAssert.assertAll();
		Thread.sleep(5000);
	} 	


	@Test(description ="Verify that user should be able to able to Delete searched records")
	void deleteSearchedRecords() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);

		//search by age
		webtable.getSearchbox().sendKeys("Cantrell");
		webtable.getSearchbox().click();

		//verify correct results has been displayed
		List<WebElement> rowElements=webtable.getRowList(1);
		String lastName=rowElements.get(1).getText();

		Assert.assertEquals(lastName,"Cantrell");

		// delete first row 
		webtable.getRowDeleteButton(1).click();

		//verify row has been deleted
		List<WebElement> rowElements2=webtable.getRowList(1);

		String firstName=rowElements2.get(0).getText();
		String lastName2=rowElements2.get(1).getText();
		String ageName=rowElements2.get(2).getText();
		String email=rowElements2.get(3).getText();
		String salary=rowElements2.get(4).getText();
		String department=rowElements2.get(5).getText();

		softAssert.assertTrue(firstName.isBlank());
		softAssert.assertTrue(lastName2.isBlank());
		softAssert.assertTrue(ageName.isBlank());
		softAssert.assertTrue(email.isBlank());
		softAssert.assertTrue(salary.isBlank());
		softAssert.assertTrue(department.isBlank());

		softAssert.assertAll();

	}

	@Test(description ="Verify that Duplicate records should not be created")
	void duplicateRecord() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);

		//add a new record which has exact same details as the existing record
		webtable.getAddButton().click();
		webtable.getFirstName().sendKeys("Kierra");
		webtable.getLastName().sendKeys("Gentry");
		webtable.getUserEmail().sendKeys("kierra@example.com");
		webtable.getSalary().sendKeys("2000");
		webtable.getAge().sendKeys("29");
		webtable.getDepartment().sendKeys("Legal");
		webtable.getSubmit().click();

		//verify new record has been created 
		List<WebElement> rowElements2=webtable.getRowList(3);

		String firstName=rowElements2.get(0).getText();
		String lastName2=rowElements2.get(1).getText();
		String age=rowElements2.get(2).getText();
		String email=rowElements2.get(3).getText();
		String salary=rowElements2.get(4).getText();
		String department=rowElements2.get(5).getText();

		softAssert.assertNotEquals(firstName,"Kierra");
		softAssert.assertNotEquals(lastName2,"Gentry");
		softAssert.assertNotEquals(email,"kierra@example.com");
		softAssert.assertNotEquals(age,"29");
		softAssert.assertNotEquals(salary,"2000");
		softAssert.assertNotEquals(department,"Legal");

		softAssert.assertAll();

	}

	@Test(description ="Verify that two emplyees cannot have same Email id")
	void duplicateEmail() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);

		//Add new employee with existing email but other details should be different
		webtable.getAddButton().click();
		webtable.getFirstName().sendKeys("john");
		webtable.getLastName().sendKeys("Dane");
		webtable.getUserEmail().sendKeys("cierra@example.com");
		webtable.getSalary().sendKeys("45684");
		webtable.getAge().sendKeys("21");
		webtable.getDepartment().sendKeys("Finance");
		webtable.getSubmit().click();

		//search by email
		webtable.getSearchbox().sendKeys("cierra@example.com");
		List <WebElement> row1=webtable.getRowList(1);
		List <WebElement> row2=webtable.getRowList(2);

		String result1EmailID=row1.get(3).getText();
		String result2EmailID=row2.get(3).getText();

		Assert.assertNotEquals(result1EmailID,result2EmailID,"user is able to add new employee with existing email");
	}

	@Test(description ="Verify that when user is present on the first page then previous buttons should be disabled.")
	void isPreviousButtonDisabled() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);

		//verify that user is on the first page
		String pagenumber=ActionDriver.actionGetAttribute(webtable.getJumpToPageORcurrentpage(),"value");
		System.out.println(pagenumber);

		if(pagenumber.equals("1"))
		{
			boolean previousButton=webtable.getPreviousButton().isEnabled();
			Assert.assertFalse(previousButton);
		}
		else
		{
			webtable.getJumpToPageORcurrentpage().sendKeys("1");
			ActionDriver.pressEnterRobot();
			boolean previousButton2=webtable.getPreviousButton().isEnabled();
			Assert.assertFalse(previousButton2);
		}
	}

	@Test(description ="Verify that Next button is disabled when no other pages are not  available")
	void isNextButtonDisabled() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);

		//verify that user is on the first page
		String totalPagenumber=webtable.getTotalNumberOfPages().getText();
		System.out.println(totalPagenumber);

		if(totalPagenumber.equals("1"))
		{
			boolean nextButton=webtable.getNextButton().isEnabled();
			Assert.assertFalse(nextButton);
		}
	}
	
	@Test(description ="Verify the colours of fields -'Add' ,'Submit','SearchButton'")
	void verifyColours() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_WebTables webtable=new Elements_WebTables(driver);
		SoftAssert softAssert=new SoftAssert();

		reachWebtable();
		Thread.sleep(1000);
		
		String addButtonColour=ActionDriver.getHexValue(webtable.getAddButton(),"background-color");
		webtable.getAddButton().click();
		String submitColour=ActionDriver.getHexValue(webtable.getSubmit(),"background-color");
		webtable.getCloseRegistrationForm().click();
		String searchButtonColour=ActionDriver.getHexValue(webtable.getSearchButton(),"background-color");

		softAssert.assertEquals(addButtonColour,"#007bff");
		softAssert.assertEquals(submitColour,"#007bff");
		softAssert.assertEquals(searchButtonColour,"#e9ecef");
		softAssert.assertAll();
	}

	

	






}
