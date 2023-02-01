package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DemoQA.Base.TestBase;
import com.DemoQA.PageLayers.Elements_RadioButtons;
import com.DemoQA.PageLayers.Elements_Textbox;
import com.DemoQA.PageLayers.Homepage;
import com.DemoQA.actiondriver.ActionDriver;

public class RadioButton extends TestBase
{
	Homepage homepage=new Homepage(driver); 
	Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
	SoftAssert softAssert=new SoftAssert();
	Elements_RadioButtons radioButton=new Elements_RadioButtons(driver);
	

	@Test(priority=1,description = "Verify that option 'no' is disabled by default")
	void checkDisabilityofNoRadioButton() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_RadioButtons radioButton=new Elements_RadioButtons(driver);
		
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clickradiobuttonDropdownOption();
		
		Assert.assertFalse(radioButton.getNoRadioOption().isEnabled());
	}
	
	
	@Test(priority=1,description = "Verify that options 'Yes' and 'No\" should be enabled")
	void checkEnabilityofRadioButtons() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_RadioButtons radioButton=new Elements_RadioButtons(driver);
		
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clickradiobuttonDropdownOption();
		
		softAssert.assertTrue(radioButton.getYesRadioOption().isEnabled());
		softAssert.assertTrue(radioButton.getImpressiveRadioOption().isEnabled());
		softAssert.assertAll();
	
	}
	
	@Test(priority=1,description = "Verify that selected option is displayed on the console.")
	void checkConsoleoutput() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_RadioButtons radioButton=new Elements_RadioButtons(driver);
		
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clickradiobuttonDropdownOption();
		
		Thread.sleep(2000);
		ActionDriver.jsClick(radioButton.getYesRadioOption() );
     	String console=	ActionDriver.getTextCustom(radioButton.getRadioBoxConsole());
     	softAssert.assertEquals(console,"You have selected Yes");
     	
     	ActionDriver.jsClick(radioButton.getImpressiveRadioOption() );     	
     	String console2=ActionDriver.getTextCustom(radioButton.getRadioBoxConsole());
     	softAssert.assertEquals(console2,"You have selected Impressive");
     	
     	Thread.sleep(2000);
     	softAssert.assertAll();
	}
	
	@Test(priority=1,description = "Verify that by default none of the available option should be selected.")
	void areRadioButtonsSelected() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_RadioButtons radioButton=new Elements_RadioButtons(driver);
		
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clickradiobuttonDropdownOption();
		
		softAssert.assertFalse(radioButton.getYesRadioOption().isSelected());
		softAssert.assertFalse(radioButton.getImpressiveRadioOption().isSelected());
		softAssert.assertFalse(radioButton.getNoRadioOption().isSelected());
		
		softAssert.assertAll();
	
	}
	
	@Test(priority=1,description ="Verify that user can select option yes.")
	void selectYesOption() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_RadioButtons radioButton=new Elements_RadioButtons(driver);
		
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clickradiobuttonDropdownOption();
		
		ActionDriver.jsClick(radioButton.getYesRadioOption() );
		String console=	ActionDriver.getTextCustom(radioButton.getRadioBoxConsole());
     	Assert.assertEquals(console,"You have selected yes");
		
		Thread.sleep(3000);
	}
	
	@Test(priority=1,description ="Verify that user can select option no.")
	void selectNoOption() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_RadioButtons radioButton=new Elements_RadioButtons(driver);
		
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		Elements_Textbox.clickradiobuttonDropdownOption();
		
		ActionDriver.jsClick(radioButton.getImpressiveRadioOption() );
		String console=	ActionDriver.getTextCustom(radioButton.getRadioBoxConsole());
     	Assert.assertEquals(console,"You have selected Impressive");
		
		Thread.sleep(3000);
	}
	
	

	

	
	

	
}
