package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DemoQA.Base.TestBase;
import com.DemoQA.PageLayers.Elements_Checkbox;
import com.DemoQA.PageLayers.Elements_Textbox;
import com.DemoQA.PageLayers.Elements_WebTables;
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

}
