package tests;

import java.awt.AWTException;

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

		//getformDropdown

	}


	@Test(priority=1,description = "verify all fields basic fields in form are displayed or not"				+ "")
	void checkDisabilityofNoRadioButton() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
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
		Homepage homepage=new Homepage(driver); 
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

	@Test(priority=1,description = "verify that all radio buttons are in enabled state")
	void areCheckboxEnabled() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
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


	@Test(priority=1,description = "by default none of the radio button options should be selected ")
	void areRadiobuttonselected() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
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

	@Test(description ="Verify that proper placeholders present in all fields.")
	void areplaceholdersPresent() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
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

	@Test(description ="Verify that proper placeholders present in all fields.",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void firstNameValidationNegative(String[] firstnameValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

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
	
	@Test(description ="Verify that proper placeholders present in all fields.",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void firstNameValidationPositive(String[] firstnameValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

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

	@Test(description ="Verify that proper placeholders present in all fields.",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void lastNameValidationNegative(String[] lastnameValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

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

	@Test(description ="Verify that proper placeholders present in all fields.",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void lastNameValidationPositive(String[] lastnameValues) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

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

	
	@Test(description ="Verify that proper placeholders present in all fields.",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void phoneNumberValidationNegative(String[] phoneNumber) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

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

	@Test(description ="Verify that proper placeholders present in all fields.",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void phoneNumberValidationPositive(String[] phoneNumber) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

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

	@Test(description ="Verify that proper placeholders present in all fields.",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void emailValidationPositive(String[] phoneNumber) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getUserEmail().sendKeys(phoneNumber);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getUserEmail(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#28a745");
	}
	
	@Test(description ="Verify that proper placeholders present in all fields.",
			dataProvider = "dataforFirstName", dataProviderClass = Dataproviders.class)
	void emailValidationNegative(String[] phoneNumber) throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		formElements.getUserEmail().sendKeys(phoneNumber);
		ActionDriver.pressEnterRobot();
		Thread.sleep(2000);
		String hex=ActionDriver.getHexValue(formElements.getUserEmail(),"border-color");

		//#7ebcfa=blue 
		//#28a745=green 
		//#dc3545=red
		Assert.assertEquals(hex, "#dc3545");
	}
	
	@Test(description ="By default No date should be filled in the date field")
	void dateValidationNegative() throws InterruptedException, AWTException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

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
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);
		SoftAssert softAssert=new SoftAssert();

		reachForm();
		ActionDriver.scrollByDistance(0,1500);

		ActionDriver.actionMove(formElements.getDateOfBirthInput());
		
	
		Thread.sleep(20000);
	}

	
	
}
