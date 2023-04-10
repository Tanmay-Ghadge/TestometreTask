package Tests;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DemoQA.Base.DriverFactory;
import com.DemoQA.Base.TestBase;
import com.DemoQA.PageLayers.Elements_Buttons;
import com.DemoQA.PageLayers.Elements_Checkbox;
import com.DemoQA.PageLayers.Elements_Textbox;
import com.DemoQA.PageLayers.Homepage;
import com.DemoQA.PageLayers.Elements_Textbox;
import com.DemoQA.actiondriver.ActionDriver;

public class Textbox extends TestBase
{

	//static WebDriver testDriver=DriverFactory.getInstance().getDriver();

	Homepage homepage=new Homepage(driver); 
	Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
	SoftAssert softAssert=new SoftAssert();

	@Test(priority=1)
	void launchApplicationURL()
	{
		System.out.println("test1");
		boolean flag =ActionDriver.getpageTitle("ToolsQA");
		Assert.assertTrue(flag);
	}

	@Test
	void checkBasicElementsVisbibily() throws InterruptedException
	{

		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		boolean element=homepage.iselementVisible("element");
		softAssert.assertTrue(element, "element is not visible");

		boolean form=homepage.iselementVisible("form");
		softAssert.assertTrue(form, "form is not visible");

		boolean alertsFrameWindows=homepage.iselementVisible("alertsFrameWindows");
		softAssert.assertTrue(alertsFrameWindows, "alertsFrameWindows is not visible");

		boolean widgets=homepage.iselementVisible("widgets");
		softAssert.assertTrue(widgets, "widgets is not visible");

		boolean interactions=homepage.iselementVisible("interactions");
		softAssert.assertTrue(interactions, "element is not visible");

		softAssert.assertAll();

	}

	@Test(priority=1,description = "verify when entered data in all available fields "
			+ "then details are shown at the console",
			dataProvider ="" )
	void fillAllDetails(String[] value) throws Exception
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clicktextboxDropdownOption();
		ActionDriver.sendkeysCustom(ElementsTextbox.getFullName(),"Full Name",value[0]);
		ActionDriver.sendkeysCustom(ElementsTextbox.getEmail(),"email", value[1]);
		ActionDriver.sendkeysCustom(ElementsTextbox.getCurrentAdress(),"current address",value[2]);
		ActionDriver.sendkeysCustom(ElementsTextbox.getPermanetAdress(),"permanent address",value[3]);
		ActionDriver.scrollByDistance(0,400);
		ActionDriver.clickWebeElement(ElementsTextbox.getSubmit());
		Thread.sleep(3000);

		String name=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputName());
		String email=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputemail());
		String currentAdress=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputCurrentAddress());
		String permanentAddress=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputPermanentAddress());
		System.out.println(name);

		softAssert.assertEquals(name, value[0]);
		softAssert.assertEquals(email, value[1]);
		softAssert.assertEquals(currentAdress, value[2]);
		softAssert.assertEquals(permanentAddress, value[3]);

		softAssert.assertAll();
	}

	@Test(description ="validate that user can enter same current and permanent address")
	void addressValidation(String[] value) throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clicktextboxDropdownOption();
		ActionDriver.sendkeysCustom(ElementsTextbox.getFullName(),"Full Name",value[0]);
		ActionDriver.sendkeysCustom(ElementsTextbox.getEmail(),"email", value[1]);
		ActionDriver.sendkeysCustom(ElementsTextbox.getCurrentAdress(),"current address",value[2]);
		ActionDriver.sendkeysCustom(ElementsTextbox.getPermanetAdress(),"permanent address",value[3]);
		ActionDriver.scrollByDistance(0,400);
		ActionDriver.clickWebeElement(ElementsTextbox.getSubmit());
		Thread.sleep(3000);

		String currentAdress=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputCurrentAddress());
		String permanentAddress=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputPermanentAddress());

		softAssert.assertEquals(currentAdress, value[2]);
		softAssert.assertEquals(permanentAddress, value[3]);
		
		softAssert.assertAll();
	}


	@Test(description ="verify when we enter  some texts in the fields "
			+ "and in the middle we click on other module and come back then should maintain the data")
	void TC_FP_008(String[] value)  throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clicktextboxDropdownOption();

		ActionDriver.sendkeysCustom(ElementsTextbox.getFullName(),"full name", value[0]);
		ActionDriver.sendkeysCustom(ElementsTextbox.getEmail(),"email", value[0]);
		Thread.sleep(2000);

		ActionDriver.naviagteBack();
		Thread.sleep(2000);

		ActionDriver.naviagteForward();
		Thread.sleep(2000);

		//not able to get value of a from the textbox because value attribute is not there
		if(ElementsTextbox.getFullName().isDisplayed())
		{
			System.out.println("is value inside that field is present");
		}

	}


	@Test(description = "verify that in email field after character '@' dot(.) Cannot be accepted")
	void emailNegative() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clicktextboxDropdownOption();


		ActionDriver.sendkeysCustom(ElementsTextbox.getEmail(),"email", "Tanmay@.gmail.co");
		ActionDriver.scrollByDistance(0,400);
		ActionDriver.clickWebeElement(ElementsTextbox.getSubmit());

		System.out.println(ActionDriver.getHexValue(ElementsTextbox.getEmail(), "border"));

		//java.lang.IllegalArgumentException: No enum constant org.openqa.selenium.support.Colors.0.8PX SOLID RGB(176, 198, 227)

	}

	@Test(description = "verify that proper placeholders are present for each field")
	void TC_FP_014() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clicktextboxDropdownOption();

		String fullName=ActionDriver.getPlaceholderName(ElementsTextbox.getFullName());
		String email=ActionDriver.getPlaceholderName(ElementsTextbox.getEmail());
		String currentAddress=ActionDriver.getPlaceholderName(ElementsTextbox.getCurrentAdress());
		String permanentAddress=ActionDriver.getPlaceholderName(ElementsTextbox.getPermanetAdress());

		softAssert.assertEquals(fullName, "Full Name");
		softAssert.assertEquals(email, "Email");
		softAssert.assertEquals(currentAddress, "Current Address");
		softAssert.assertEquals(permanentAddress, "Permanent Address");

		softAssert.assertAll();
	}

	@Test(description = "Verify when clicked on logo user should land on Homepage",groups = {"smoke"})
	void TC_FP_017() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();

		ElementsTextbox.clickLogo();
		String actualTitle=ActionDriver.getpageTitle();

		Assert.assertEquals(actualTitle, "DEMOQA");

	}

	//****************************************************************************************************


	
	

	

	//----------------------------------------buttons-----------------------------------------------------------------------

	














}
