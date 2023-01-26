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

	static WebDriver testDriver=DriverFactory.getInstance().getDriver();
	
	Homepage homepage=new Homepage(testDriver); 
	Elements_Textbox ElementsTextbox=new Elements_Textbox(testDriver);
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
	
	@Test(priority=1)
	 void fillAllDetails() throws InterruptedException
	{
		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
//	ActionDriver.clickWebeElement(ElementsTextbox.getCurrentAdress());
		
		
	}
	
	
	
	
}
