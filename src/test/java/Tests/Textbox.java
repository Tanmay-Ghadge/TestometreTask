package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DemoQA.Base.DriverFactory;
import com.DemoQA.Base.TestBase;
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
			+ "then details are shown at the bottom")
	void fillAllDetails() throws Exception
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clicktextboxDropdownOption();
		ActionDriver.sendkeysCustom(ElementsTextbox.getFullName(),"full name", "Tanmay Shivajirao Ghadge");
		ActionDriver.sendkeysCustom(ElementsTextbox.getEmail(),"email", "Tanmay@gmail.co");
		ActionDriver.sendkeysCustom(ElementsTextbox.getCurrentAdress(),"current address","address 1");
		ActionDriver.sendkeysCustom(ElementsTextbox.getPermanetAdress(),"permanent address","address 2");
		ActionDriver.scrollByDistance(0,400);
		ActionDriver.clickWebeElement(ElementsTextbox.getSubmit());
		Thread.sleep(3000);

		String name=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputName());
		String email=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputemail());
		String currentAdress=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputCurrentAddress());
		String permanentAddress=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputPermanentAddress());
		System.out.println(name);

		if(name.equals("Tanmay Shivajirao Ghadge"))
			softAssert.assertTrue(true);
		else
			softAssert.assertTrue(false);

		if(email.equals("Tanmay@gmail.com"))
			softAssert.assertTrue(true);
		else
			softAssert.assertTrue(false);

		if(currentAdress.equals("address 1") )
			softAssert.assertTrue(true);
		else
			softAssert.assertTrue(false);

		if(permanentAddress.equals("address 2"))
			softAssert.assertTrue(true);
		else
			softAssert.assertTrue(false);

		softAssert.assertAll();
	}

	@Test(description ="validate that current and permanent address can be same")
	void addressValidation() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clicktextboxDropdownOption();
		ActionDriver.sendkeysCustom(ElementsTextbox.getFullName(),"full name", "Tanmay Shivajirao Ghadge");
		ActionDriver.sendkeysCustom(ElementsTextbox.getEmail(),"email", "Tanmay@gmail.co");
		ActionDriver.sendkeysCustom(ElementsTextbox.getCurrentAdress(),"current address","address same");
		ActionDriver.sendkeysCustom(ElementsTextbox.getPermanetAdress(),"permanent address","address same");
		ActionDriver.scrollByDistance(0,400);
		ActionDriver.clickWebeElement(ElementsTextbox.getSubmit());
		Thread.sleep(3000);

		String currentAdress=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputCurrentAddress());
		String permanentAddress=ActionDriver.getTextCustom(ElementsTextbox.getConsoleOutputPermanentAddress());

		if(currentAdress.equals(permanentAddress))
		{
			Assert .assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);	
		}
	}

	//verify when we enter  some texts in the fields    and in the middle we click on other module and come back then should maintain the data

	@Test(description ="TC_FP_008_validate that current and permanent address can be same")
	void TC_FP_008() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clicktextboxDropdownOption();

		ActionDriver.sendkeysCustom(ElementsTextbox.getFullName(),"full name", "Tanmay Shivajirao Ghadge");
		ActionDriver.sendkeysCustom(ElementsTextbox.getEmail(),"email", "Tanmay@gmail.co");
		Thread.sleep(2000);

		ActionDriver.naviagteBack();
		Thread.sleep(2000);

		ActionDriver.naviagteForward();
		Thread.sleep(2000);

		if(ElementsTextbox.getFullName().isDisplayed())
		{
			System.out.println("is value inside that field is present");
		}

	}


	@Test(description = "verify that in email field after character '@' dot(.) Cannot be accepted")
	void TC_FP_011() throws InterruptedException
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

	@Test(description = "verify that in email field after character '@' dot(.) Cannot be accepted")
	void TC_FP_013() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clicktextboxDropdownOption();


		ActionDriver.sendkeysCustom(ElementsTextbox.getEmail(),"email", "@.gmail.co");
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

	


}
