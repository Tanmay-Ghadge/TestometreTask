package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DemoQA.Base.TestBase;
import com.DemoQA.PageLayers.Elements_Buttons;
import com.DemoQA.PageLayers.Elements_Checkbox;
import com.DemoQA.PageLayers.Elements_Textbox;
import com.DemoQA.PageLayers.FormElements;
import com.DemoQA.PageLayers.Homepage;
import com.DemoQA.actiondriver.ActionDriver;

public class Buttons extends TestBase
{
	

	@Test(description ="Verify that buttons 'Double click' , 'Right click ', 'Click me ' buttons"
			+ " are visible to the user",
			groups = {"smoke"})
	void areClickButtonsPresent() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Buttons button=new Elements_Buttons(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		button.getButtonsRadioDropdownOption().click();

	}


	Homepage homepage=new Homepage(driver); 
	Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
	SoftAssert softAssert=new SoftAssert();
	
	@Test
	void reachForm() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		FormElements formElements=new FormElements(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		//homepage.clickElement();
		//getformDropdown

	}
	
	
}
