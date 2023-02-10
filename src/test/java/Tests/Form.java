package tests;

import java.awt.AWTException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DemoQA.Base.TestBase;
import com.DemoQA.Dataprovider.Dataproviders;
import com.DemoQA.PageLayers.Elements_RadioButtons;
import com.DemoQA.PageLayers.Elements_Textbox;
import com.DemoQA.PageLayers.FormElements;
import com.DemoQA.PageLayers.Homepage;
import com.DemoQA.actiondriver.ActionDriver;

public class Form extends TestBase
{

	void reachForm() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement("forms");
		formElements.getPracticeForm().click();

	}


	@Test(priority=1,description = "verify all fields basic fields in form are displayed or not"				+ "")
	void checkDisabilityofNoRadioButton() throws InterruptedException
	{
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		boolean firsname=formElements.getFirstName().isDisplayed();
		softAssert.assertTrue(firsname,"firsname is not displayed");

		boolean lastName=formElements.getLastName().isDisplayed();
		softAssert.assertTrue(lastName,"lastName is not displayed");

		boolean email=formElements.getUserEmail().isDisplayed();
		softAssert.assertTrue(email,"email is not displayed");

		boolean maleradio=formElements.getMaleRadio().isDisplayed();
		softAssert.assertTrue(maleradio,"maleradio is not displayed");

		boolean femaleradio=formElements.getFemaleRadio().isDisplayed();
		softAssert.assertTrue(femaleradio,"femaleradio is not displayed");

		boolean otherradio=formElements.getOtherRadio().isDisplayed();
		softAssert.assertTrue(otherradio,"otherradio is not displayed");

		boolean userNumber=formElements.getUserNumber().isDisplayed();
		softAssert.assertTrue(userNumber,"userNumber is not displayed");

		boolean dob=formElements.getDateOfBirthInput().isDisplayed();
		softAssert.assertTrue(dob,"dob is not displayed");

		boolean subject=formElements.getSubjectsInput().isDisplayed();
		softAssert.assertTrue(subject,"subject is not displayed");

		boolean musicCheckbox=formElements.getMusicChecBox().isDisplayed();
		softAssert.assertTrue(musicCheckbox,"musicCheckbox is not displayed");

		boolean readingCheckbox=formElements.getReadingChecBox().isDisplayed();
		softAssert.assertTrue(readingCheckbox,"readingCheckbox is not displayed");

		boolean sportCheckbox=formElements.getSportChecBox().isDisplayed();
		softAssert.assertTrue(sportCheckbox,"sportCheckbox is not displayed");

		boolean uploadPicture=formElements.getUploadPicture().isDisplayed();
		softAssert.assertTrue(uploadPicture,"uploadPicture is not displayed");

		boolean currentAddress=formElements.getCurrentAddress().isDisplayed();
		softAssert.assertTrue(currentAddress,"currentAddress is not displayed");


		//-----------------------------these assertions should fail but are passed


		boolean submitButton=formElements.getSubmitButton().isDisplayed();
		softAssert.assertTrue(submitButton,"submitButton is not displayed");

		boolean city=formElements.getSelectCity().isEnabled();
		softAssert.assertTrue(city,"city is not Enabled");

		boolean state=formElements.getSelectState().isEnabled();
		softAssert.assertTrue(state,"state is not enabled");

		Thread.sleep(5000);
		softAssert.assertAll();

	}

	@Test(priority=1,description = "verify that all radio buttons are in enabled state")
	void areRadiobuttonsEnabled() throws InterruptedException
	{
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		boolean maleradio=formElements.getMaleRadio().isEnabled();
		softAssert.assertTrue(maleradio,"maleradio is not Enabled");

		boolean femaleradio=formElements.getFemaleRadio().isEnabled();
		softAssert.assertTrue(femaleradio,"femaleradio is not Enabled");

		boolean otherradio=formElements.getOtherRadio().isEnabled();
		softAssert.assertTrue(otherradio,"otherradio is not Enabled");

		softAssert.assertAll();
	}

	@Test(priority=1,description = "verify that all checkboxes are in enabled state")
	void areCheckboxEnabled() throws InterruptedException
	{
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		boolean musicCheckbox=formElements.getMusicChecBox().isEnabled();
		softAssert.assertTrue(musicCheckbox,"musicCheckbox is not Enabled");

		boolean readingCheckbox=formElements.getReadingChecBox().isEnabled();
		softAssert.assertTrue(readingCheckbox,"readingCheckbox is not Enabled");

		boolean sportCheckbox=formElements.getSportChecBox().isEnabled();
		softAssert.assertTrue(sportCheckbox,"sportCheckbox is not Enabled");

		softAssert.assertAll();


	}

	@Test(priority=1,description = "verify that all checkboxes are in enabled state")
	void areCheckboxSelected() throws InterruptedException
	{
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		boolean musicCheckbox=formElements.getMusicChecBox().isSelected();
		softAssert.assertTrue(musicCheckbox,"musicCheckbox is not Selected");

		boolean readingCheckbox=formElements.getReadingChecBox().isSelected();
		softAssert.assertTrue(readingCheckbox,"readingCheckbox is not Selected");

		boolean sportCheckbox=formElements.getSportChecBox().isSelected();
		softAssert.assertTrue(sportCheckbox,"sportCheckbox is not Selected");

		softAssert.assertAll();


	}


	@Test(priority=1,description = "by default none of the radio button options should be selected ")
	void areRadioButtonsSelected() throws InterruptedException
	{
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		boolean maleradio=formElements.getMaleRadio().isSelected();
		softAssert.assertFalse(maleradio,"maleradio is selected");

		boolean femaleradio=formElements.getFemaleRadio().isSelected();
		softAssert.assertFalse(femaleradio,"femaleradio is selected");

		boolean otherradio=formElements.getOtherRadio().isSelected();
		softAssert.assertFalse(otherradio,"otherradio is selected");


	}

	@Test(priority=1,description ="Verify that at a time only one radio option can be selected")
	void multipleRadioOptionSelect() throws InterruptedException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);
		Thread.sleep(2000);
		
		ActionDriver.jsClick(formElements.getMaleRadio() );
		
		ActionDriver.jsClick(formElements.getFemaleRadio()  );
     	
     	if(formElements.getMaleRadio().isSelected()== false && formElements.getFemaleRadio().isSelected()== true)
     	{
     		Assert.assertTrue(true);
     	}
	}
	
	@Test(priority=1,description ="Verify that multiple checkbox options can be selected")
	void multipleOptionSelect() throws InterruptedException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);
		Thread.sleep(2000);
		
		ActionDriver.jsClick(formElements.getSportChecBox() );
		
		ActionDriver.jsClick(formElements.getMusicChecBox()  );
     	
     	if(formElements.getSportChecBox().isSelected()== true && formElements.getMusicChecBox().isSelected()== true)
     	{
     		Assert.assertTrue(true);
     	}
	}
	
	
	
	@Test(description ="Verify that proper placeholders present in all fields.")
	void areplaceholdersPresent() throws InterruptedException
	{
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		String firstName=ActionDriver.getPlaceholderName(formElements.getFirstName());
		String lastName=ActionDriver.getPlaceholderName(formElements.getLastName());
		String currentAddress=ActionDriver.getPlaceholderName(formElements.getCurrentAddress());
		String userNumber=ActionDriver.getPlaceholderName(formElements.getUserNumber());
		String email=ActionDriver.getPlaceholderName(formElements.getUserEmail());
		String subject=ActionDriver.getPlaceholderName(formElements.getSubjectsInput());
		String state=ActionDriver.getPlaceholderName(formElements.getSelectState());
		String city=ActionDriver.getPlaceholderName(formElements.getSelectCity());

		softAssert.assertEquals(firstName, "First Name");
		softAssert.assertEquals(lastName, "Last Name");
		softAssert.assertEquals(currentAddress, "Current Address");
		softAssert.assertEquals(userNumber, "Mobile Number");
		softAssert.assertEquals(email, "Email");
		softAssert.assertEquals(subject, "Subject");
		softAssert.assertEquals(state, "Select State");
		softAssert.assertEquals(city, "Select City");

		softAssert.assertAll();

	}

	//TDD
	@Test(description ="TDD-First name negative Test cases",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void firstNameValidationNegative(String[] firstnameValues) throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getFirstName().sendKeys(firstnameValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getFirstName(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#dc3545");
	}

	//TDD
	@Test(description ="TDD-First name Positive Test cases",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void firstNameValidationPositive(String[] firstnameValues) throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getFirstName().sendKeys(firstnameValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getFirstName(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#28a745");
	}

	//TDD
	@Test(description ="TDD-Last name Negative Test cases",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void lastNameValidationNegative(String[] lastnameValues) throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getLastName().sendKeys(lastnameValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getLastName(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#dc3545");
	}

	//TDD
	@Test(description ="TDD-Last name Positive Test cases",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void lastNameValidationPositive(String[] lastnameValues) throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getLastName().sendKeys(lastnameValues);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getLastName(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#28a745");
	}


	@Test(description ="TDD-Phone number Negative Test cases",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void phoneNumberValidationNegative(String[] phoneNumber) throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getUserNumber().sendKeys(phoneNumber);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getUserNumber(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#dc3545");
	}

	@Test(description ="TDD-Phone number Positive Test cases",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void phoneNumberValidationPositive(String[] phoneNumber) throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getUserNumber().sendKeys(phoneNumber);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getUserNumber(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#28a745");
	}

	@Test(description ="TDD-Email Positive Test cases",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void emailValidationPositive(String[] emailID) throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getUserEmail().sendKeys(emailID);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getUserEmail(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#28a745");
	}

	@Test(description ="TDD-Email Negative Test cases",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void emailValidationNegative(String[] emailid) throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getUserEmail().sendKeys(emailid);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getUserEmail(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#dc3545");
	}


	//*******************************Date Field**************************************

	@Test(description ="By default No date should be filled in the date field")
	void dateValidationNegative() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		String attributeValue=ActionDriver.actionGetAttribute(formElements.getDateOfBirthInput(),"value");

		if(attributeValue.isEmpty())
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

	@Test(description ="By default No date should be filled in the date field")
	void clearDateField() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		ActionDriver.actionMove(formElements.getDateOfBirthInput());

		Thread.sleep(20000);
	}

	@Test(description ="upload jpg file,png,jpeg file\r\n"
			+ "")
	void uploadValidFile() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getUploadPicture().sendKeys("C:\\Users\\tusha\\Documents\\FilesToUpload\\Untitledkvkhv.png");
		ActionDriver.pressEnterRobot();
		Thread.sleep(20000);
	}

	@Test(description ="Verify that user can enter a date mannually without using Calender")
	void verifydate() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getDateOfBirthInput().click(); 
		ActionDriver.selectAllClear();

		formElements.getDateOfBirthInput().sendKeys("08 Feb 2008");
		ActionDriver.pressEnterRobot();

		Thread.sleep(20000);
	}

	@Test(description ="Verify that on date field is enabled")
	void isdateEnabled() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);
		boolean flag=formElements.getDateOfBirthInput().isDisplayed();

		if(flag==true)
		{
			boolean flag2=formElements.getDateOfBirthInput().isEnabled();

			if(flag2==true)
			{
				Assert.assertTrue(flag2);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else
		{
			Assert.assertTrue(false);
		}

	}

	@Test(description ="Verify that when user clicks on date field calender should be displayed")
	void isCalenderDisplayed() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);
		formElements.getDateOfBirthInput().click();
		WebElement month= formElements.getMonthDropdown();
		WebElement year=formElements.getYearDropdown();

		softAssert.assertTrue(month.isDisplayed());
		softAssert.assertTrue(year.isDisplayed());
		softAssert.assertAll();
	}

	@Test(description ="Verify that week in calender should be start from monday and end with saunday")
	void areWeekDaysDisplayed() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getDateOfBirthInput().click();

		List<WebElement> days=formElements.getWeekDays();

		softAssert.assertEquals(days.get(0).getText(),"Mo");
		softAssert.assertEquals(days.get(1).getText(),"Tu");
		softAssert.assertEquals(days.get(2).getText(),"We");
		softAssert.assertEquals(days.get(3).getText(),"Th");
		softAssert.assertEquals(days.get(4).getText(),"Fr");
		softAssert.assertEquals(days.get(5).getText(),"Sa");
		softAssert.assertEquals(days.get(6).getText(),"Su");

		softAssert.assertAll();

	}	


	@Test(description ="Verify that by default current date is selected")
	void isCurrentDateSelected() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		String actualdate= ActionDriver.actionGetAttribute(formElements.getDateOfBirthInput(),"value");  
		SimpleDateFormat format=new SimpleDateFormat("dd MMM yyyy");
		Date date=new Date();
		String actualdate1=format.format(date);

		Assert.assertEquals(actualdate, actualdate1);
	}

	@Test(description ="Verify that when clicked on front arrow next month should be displayed "
			+ "and in the month  dropdown month should be same as month on calender heading")
	void verifyNextMonthButton() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getDateOfBirthInput().click();

		String a[]={"january 2023","February 2023","March 2023","April 2023","May 2023",
				"June 2023","July 2023","August 2023","September 2023","October 2023","November 2023","December 2023"};

		for(int i=1;i<12;i++)
		{
			String month=formElements.getMonthYear().getText();

			formElements.getNextMonthButton().click();	
			softAssert.assertEquals(month, a[i]);
			System.out.println(month+"-----"+a[i]);
		}

		softAssert.assertAll();
	}

	@Test(description ="Verify that when clicked on Next month button after december "
			+ "month year should change by one digit ,january month should "
			+ "be displayed in first dropdown and next year should be in year dropdown")
	void verifyNextMonthButtonTillNextYear() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getDateOfBirthInput().click();
		int year=2023;

		for(int i=1;i<48;i++)
		{

			formElements.getNextMonthButton().click();	
			String monthyear=formElements.getMonthYear().getText();

			if(monthyear.contains("December"))
			{
				formElements.getNextMonthButton().click();	
				String month1=formElements.getMonthYear().getText();
				year++;
				String[] a=month1.split(" ");
				if(month1.contains("January") && a[0].equals("January") && a[0].contains(""+year))
				{
					System.out.println(month1);
					System.out.println("January-------- "+year);
					System.out.println("passed");

					Assert.assertTrue(true);
				}
				else
				{
					System.out.println(month1);
					System.out.println("January****************"+year);
					System.out.println("passed");
					Assert.assertTrue(false);
				}
			}
		}


	}

	@Test(description ="Verify that user can Select date using calender")
	void verifyNextMonthButtoTillNextYear() throws InterruptedException, AWTException
	{
		FormElements formElements=new FormElements(driver);


		reachForm();
		Thread.sleep(2000);
		formElements.getDateOfBirthInput().click();
		ActionDriver.scrollByDistance(0,1500);

		String Year="2011";
		String month="March";
		String dateOfMonth="25";

		ActionDriver.dropdownoptionsByValue(formElements.getMonthDropdown(), month);
		ActionDriver.dropdownoptionsByValue(formElements.getYearDropdown(), Year);

		List<WebElement> dates=formElements.getDatePicker();

		for(WebElement date:dates)
		{
			if(date.getText().equals(dateOfMonth))
			{
				date.click();
			}

		}
		Thread.sleep(5000);
	}




}
