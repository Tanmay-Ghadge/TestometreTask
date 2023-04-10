package Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
	

	@Test(description ="Verify that whether user can perform needed operations on "
	+ "buttons 'Double click' , 'Right click ', 'Click me ' buttons simultaneously",
	groups = {"smoke"})
	void clickbuttons() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Buttons button=new Elements_Buttons(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		ActionDriver.scrollByDistance(0,400);
		button.getButtonsRadioDropdownOption().click();
		Thread.sleep(2000);
		ActionDriver.doubleClick(button.getDoubleClickBtn());
		ActionDriver.rightClick(button.getRightClickBtn());
		button.getClickButton().click();
		Thread.sleep(12000);

		int count=0;
		String output1 = null;
		String output2= null;
		String output3= null;
		List<WebElement> consoleOutputList=button.getButtonConsoleList();
		for(WebElement consoleOutputElement:consoleOutputList)	
		{
			if(count==0)
			{
				output1=consoleOutputElement.getText();
				count++;
			}
			else if(count==1)
			{
				output2=consoleOutputElement.getText();
				count++;
			}
			else if(count==2)
			{
				output3=consoleOutputElement.getText();
			}
		}

		if(output1.equals("You have done a double click") && output2.equals("You have done a right click") && output3.equals("You have done a dynamic click"))
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);

	}

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
		ActionDriver.scrollByDistance(0,400);
		button.getButtonsRadioDropdownOption().click();
		Thread.sleep(2000);
		ActionDriver.doubleClick(button.getDoubleClickBtn());
		ActionDriver.rightClick(button.getRightClickBtn());
		button.getClickButton().click();
		Thread.sleep(12000);


		int count=0;
		boolean output1 = false ;
		boolean output2= false;
		boolean output3= false;
		List<WebElement> consoleOutputList=button.getButtonConsoleList();
		for(WebElement consoleOutputElement:consoleOutputList)	
		{
			if(count==0)
			{
				output1=consoleOutputElement.isDisplayed();
				count++;
			}
			else if(count==1)
			{
				output2=consoleOutputElement.isDisplayed();
				count++;
			}
			else if(count==1)
			{
				output3=consoleOutputElement.isDisplayed();
			}
		}

		if(output1==true && output1==true && output1==true)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

	@Test(description ="//Verify that background colour of all the present buttons is #007bff",
			groups = {"smoke"})
	void verifyButtonBackgroundColour() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Buttons button=new Elements_Buttons(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		ActionDriver.scrollByDistance(0,400);

		button.getButtonsRadioDropdownOption().click();
		Thread.sleep(2000);

		String doubleClickButtonBackgroundColour=ActionDriver.getHexValue(button.getDoubleClickBtn(),"background-color");
		String rightClickButtonBackgroundColour=ActionDriver.getHexValue(button.getRightClickBtn(),"background-color");
		String ClickButtonBackgroundColour=ActionDriver.getHexValue(button.getClickButton(),"background-color");
		
		System.out.println(doubleClickButtonBackgroundColour);

		
		Assert.assertEquals(doubleClickButtonBackgroundColour,"#007bff");
		Assert.assertEquals(rightClickButtonBackgroundColour, "#007bff");
		Assert.assertEquals(ClickButtonBackgroundColour, "#007bff");
	}

	@Test(description ="Verify that text colour of all the present buttons is #fff",
			groups = {"smoke"})
	void verifyButtonTextColour() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Buttons button=new Elements_Buttons(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		ActionDriver.scrollByDistance(0,400);

		button.getButtonsRadioDropdownOption().click();
		Thread.sleep(2000);

		String doubleClickButtonBackgroundColour=ActionDriver.getHexValue(button.getDoubleClickBtn(),"color");
		String rightClickButtonBackgroundColour=ActionDriver.getHexValue(button.getRightClickBtn(),"color");
		String ClickButtonBackgroundColour=ActionDriver.getHexValue(button.getClickButton(),"color");

		System.out.println(doubleClickButtonBackgroundColour);
		
		Assert.assertEquals(doubleClickButtonBackgroundColour,"#fff");
		Assert.assertEquals(rightClickButtonBackgroundColour, "#fff");
		Assert.assertEquals(ClickButtonBackgroundColour, "#fff");
	}
	
	@Test(description ="Verify that when double clicked on 'Double Click Me' button respective message should be shown in console",
			groups = {"smoke"})
	void verifyDoubleClickFunctionality() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Buttons button=new Elements_Buttons(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		ActionDriver.scrollByDistance(0,400);

		button.getButtonsRadioDropdownOption().click();
		Thread.sleep(2000);
		
		ActionDriver.doubleClick(button.getDoubleClickBtn());
		String outputMessage=button.getDoubleClickMessageConsole().getText();
		
		Assert.assertEquals(outputMessage,"You have done a double click");
	}

	@Test(description ="Verify that when right clicked on Right Click Me button respective message should be shown in console",
			groups = {"smoke"})
	void verifyRightClickFunctionality() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Buttons button=new Elements_Buttons(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		ActionDriver.scrollByDistance(0,400);

		//code is right but not working
		button.getButtonsRadioDropdownOption().click();
		Thread.sleep(2000);
		
		ActionDriver.rightClick(button.getRightClickBtn());
		String outputMessage=button.getRightClickBtn().getText();
		
		Assert.assertEquals(outputMessage,"You have done a right click");
	}
	
	@Test(description ="Verify that when clicked on Click Me button respective message should be shown in console ",
			groups = {"smoke"})
	void verifyClickFunctionality() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Buttons button=new Elements_Buttons(driver);

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		ActionDriver.scrollByDistance(0,400);

		button.getButtonsRadioDropdownOption().click();
		Thread.sleep(2000);
		
		button.getClickButton().click();
		String outputMessage=button.getDynamicClickMessageConsole().getText();
		Assert.assertEquals(outputMessage,"You have done a dynamic click");
	}

	
	
	
	
	
	
	
}
