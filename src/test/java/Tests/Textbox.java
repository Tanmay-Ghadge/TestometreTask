package tests;

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

	//****************************************************************************************************

	@Test(description = "verify that user is able to reach checkbox section",groups = {"smoke"})
	void checkboxOpened() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		checkbox.getcheckboxDropdownOption().click();
		//checkbox.getHomeSVG().click();
		checkbox.getHomedownArrow().click();
		Thread.sleep(5000);
	}

	@Test(description = "verify that by default no option should be selected",groups = {"smoke"})
	void isAnyCheckboxOptionSelected() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);
		homepage.clickElement();
		checkbox.getcheckboxDropdownOption().click();;

		checkbox.getHomedownArrow().click();

		boolean home=checkbox.getHomeAllOptions().isSelected();
		boolean desktop=checkbox.getDesktopAllOptions().isSelected();
		boolean document=checkbox.getDocumentsAllOptions().isSelected();
		boolean download=checkbox.getDownloadsAllOptions().isSelected();

		if(home==false && desktop==false && document==false && download==false)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
	}

	@Test(description = "verify that by default no option should be selected",groups = {"smoke"})
	void isAnyCheckboxOptionSeected() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		checkbox.getcheckboxDropdownOption().click();;

		String homeValue=ActionDriver.actionGetAttribute(checkbox.getHomeExpandedCollapse(),"class");

		checkbox.getHomedownArrow().click();
		String desktop=ActionDriver.actionGetAttribute(checkbox.getDesktopExpandedCollapse(),"class");
		String document=ActionDriver.actionGetAttribute(checkbox.getDocumentExpandedCollapse(),"class");
		String download=ActionDriver.actionGetAttribute(checkbox.getDownloadExpandedCollapse(),"class");


		if(homeValue.contains("expanded") && desktop.contains("expanded")
				&& document.contains("expanded") && download.contains("expanded")		)
			Assert.assertTrue(false);
		else
			Assert.assertTrue(true);
	}

	@Test(description = "Verify that when clicked on home expand arrow only folders should be displayed "
			+ "and not the sub-folders or files should be displayed verify that by default no option should be selected",groups = {"smoke"})
	void isAnyCheckboxOdptionSeected() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		checkbox.getcheckboxDropdownOption().click();

		checkbox.getHomedownArrow().click();
		boolean desktop=checkbox.getDesktopAllOptions().isDisplayed();
		boolean document=checkbox.getDocumentsAllOptions().isDisplayed();
		boolean ddownload=checkbox.getDownloadsAllOptions().isDisplayed();

		System.out.println(desktop);
		System.out.println(document);
		System.out.println(ddownload);

		//	checkbox.getDesktopArrow().click();
		List<WebElement> desktoOptions=checkbox.getDesktopAllOptionslist();

		for(WebElement desktoOption : desktoOptions)
		{
			boolean flag=desktoOption.isEnabled();
			System.out.println(flag);
			Assert.assertTrue(flag);
			System.out.println("----------");
		}

	}

	@Test(description = "select Home > Documents> Office >private",groups = {"smoke"})
	void isAnyChecdkboxOdptionSeected() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		checkbox.getcheckboxDropdownOption().click();

		checkbox.getHomedownArrow().click();
		List<WebElement> homeOptions=checkbox.getHomeOptionsList();

		for(WebElement homeOption : homeOptions)
		{
			String text=homeOption.getText();

			if(text.contains("Desktop"))
			{
				checkbox.getDesktopArrow().click();
				List<WebElement> desktopOptions=checkbox.getDesktopAllOptionslist();

				for(WebElement desktopOption : desktopOptions)
				{
					String desktopText=desktopOption.getText();

					if(desktopText.equals("Nots"))
					{
						desktopOption.click();
						break;
					}
					else
					{
						System.out.println("No option from Desktop was seleced");
					}
				}
			}

			else if(text.contains("Documents"))
			{
				checkbox.getDocumentArrow().click();
				List<WebElement> documentAllOptions=checkbox.getDocumentsAllOptionsList();

				for(WebElement documentAllOption : documentAllOptions)
				{
					String documentText=documentAllOption.getText();
					if(documentText.contains("WorkSpace"))
					{
						checkbox.getDocumentWorkspaceArrow().click();					
						List<WebElement> workspaceAllOptions=checkbox.getDocumentsWorkspaceAllOptionsList();
						ActionDriver.scrollByDistance(0,400);
						for(WebElement workspaceAllOption : workspaceAllOptions)
						{
							String documentOptionName=workspaceAllOption.getText();
							if(documentOptionName.contains("Reat"))
							{
								workspaceAllOption.click();
								break;
							}
							else
							{
								System.out.println("No option from Document-Workspace was seleced");
							}
						}
					}
					else if(documentText.contains("Office"))
					{
						checkbox.getDocumentOfficeArrow().click();
						List<WebElement> officeAllOptions=checkbox.getDocumentsOfficeAllOptionsList();

						for(WebElement officeOption : officeAllOptions)
						{
							String officeOptionName=officeOption.getText();
							if(officeOptionName.contains("Classified"))
							{
								officeOption.click();
								break;
							}
							else
							{
								System.out.println("No option from Document-Office was seleced");
							}
						}
					}
				}
			}

			else if(text.contains("Downloads"))
			{
				checkbox.getDownloadArrow().click();
				List<WebElement> downloadOptions=checkbox.getDownloadsAllOptionsList();

				for(WebElement downloadOption : downloadOptions)
				{
					String downloadText=downloadOption.getText();

					if(downloadText.contains("oguacjb"))
					{
						downloadOption.click();
						break;
					}
					else
					{
						System.out.println("No option from Download was seleced");
					}
				}
			}

		}
		Thread.sleep(10000);
	}

	@Test(description ="verify that by default no option should be selected",
			groups = {"smoke"})
	void isAnyOptionSelected() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		checkbox.getcheckboxDropdownOption().click();

		checkbox.getExpandALLButton().click();
		ActionDriver.scrollByDistance(0,300);

		boolean home=checkbox.getHomeAllOptions().isSelected();
		softAssert.assertFalse(home);
		boolean desktop=checkbox.getDesktopAllOptions().isSelected();
		softAssert.assertFalse(desktop);
		boolean document=checkbox.getDocumentsAllOptions().isSelected();
		softAssert.assertFalse(document);
		boolean download=checkbox.getDownloadsAllOptions().isSelected();
		softAssert.assertFalse(download);


		List <WebElement> desktopElements= checkbox.getDesktopAllOptionslist();
		for(WebElement desktopElement:desktopElements)
		{

			boolean desktopElement1=desktopElement.isSelected();

			String desktopElementName=desktopElement.getText();
			if(desktopElement1==true)
			{
				softAssert.assertFalse(desktopElement1);
				System.out.println(desktopElementName+" =from desktop element is Selected to user");
			}
			else
				softAssert.assertFalse(desktopElement1);
			System.out.println(desktopElementName+" =from desktop is NOT Selected");
		}

		List <WebElement> documentElements= checkbox.getDocumentsAllOptionsList();
		for(WebElement documentElement:documentElements)
		{
			boolean documentElement1=documentElement.isSelected();

			if(documentElement1!=true)
			{
				String documentOption=documentElement.getText();
				if(documentOption.equals("WorkSpace"))
				{
					List <WebElement> workspaceElements=checkbox.getDocumentsfirstAllOptionsList();

					for(WebElement workspaceElement:workspaceElements)
					{
						boolean workspaceElement1=workspaceElement.isSelected();
						String workspaceElement2=workspaceElement.getText();
						if(workspaceElement1==true)
						{
							softAssert.assertFalse(workspaceElement1);
							System.out.println(workspaceElement2+" =from Document-Workspace element is Selected");
						}

						else
							softAssert.assertFalse(workspaceElement1);
						System.out.println(workspaceElement2+" =from Document-Workspace is NOT Selected");
					}
				}
				if(documentOption.equals("Office"))
				{
					List <WebElement> officeElements=checkbox.getDocumentsOfficeAllOptionsList();
					for(WebElement officeElement:officeElements)
					{
						boolean officeElement1=officeElement.isSelected();

						String officeElement2=officeElement.getText();
						if(officeElement1==true)
						{
							softAssert.assertFalse(officeElement1);
							System.out.println(officeElement2+" =from Document-Office element is Selected");
						}

						else
						{
							softAssert.assertFalse(officeElement1);
							System.out.println(officeElement2+" =from Document-Office is NOT Selected");
						}

					}	
				}
			}
		}

		List <WebElement> downloadElements=checkbox.getDownloadsAllOptionsList();
		for(WebElement downloadElement:downloadElements)
		{
			boolean downloadeElement1=downloadElement.isSelected();
			String downloadElement2=downloadElement.getText();
			if(downloadeElement1==true)
			{
				softAssert.assertFalse(downloadeElement1);
				System.out.println(downloadElement2+" =from Download is Selected");
			}

			else
			{
				softAssert.assertFalse(downloadeElement1);
				System.out.println(downloadElement2+" =from Download is NOT Selected");	
			}


		}	
		softAssert.assertAll();
	}

	@Test(description ="'Verfy that  when we click button '-' all the checkbox tree gets collapsed",
			groups = {"smoke"})
	void validatecollapseAllButton() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		checkbox.getcheckboxDropdownOption().click();

		checkbox.getExpandALLButton().click();
		ActionDriver.scrollByDistance(0,300);

		boolean home=checkbox.getHomeAllOptions().isDisplayed();
		boolean desktop=checkbox.getDesktopAllOptions().isDisplayed();
		boolean document=checkbox.getDocumentsAllOptions().isDisplayed();
		boolean download=checkbox.getDownloadsAllOptions().isDisplayed();

		System.out.println("home="+home);
		System.out.println("desktop="+desktop);
		System.out.println("document="+document);
		System.out.println("download="+download);

		checkbox.getCollapseALL().click();

		List <WebElement> desktopElements= checkbox.getDesktopAllOptionslist();
		for(WebElement desktopElement:desktopElements)
		{
			boolean desktopElement1=desktopElement.isDisplayed();

			String desktopElementName=desktopElement.getText();
			if(desktopElement1==true)
				System.out.println(desktopElementName+" =from desktop element is visble to user");
			else
				System.out.println(desktopElementName+" =from desktop is NOT visble to user");
		}

		List <WebElement> documentElements= checkbox.getDocumentsAllOptionsList();
		for(WebElement documentElement:documentElements)
		{
			boolean documentElement1=documentElement.isDisplayed();

			if(documentElement1==true)
			{
				String documentOption=documentElement.getText();
				if(documentOption.equals("WorkSpace"))
				{
					List <WebElement> workspaceElements=checkbox.getDocumentsfirstAllOptionsList();

					for(WebElement workspaceElement:workspaceElements)
					{
						boolean workspaceElement1=workspaceElement.isDisplayed();

						String workspaceElement2=workspaceElement.getText();
						if(workspaceElement1==true)
							System.out.println(workspaceElement2+" =from Document-Workspace element is visble to user");
						else
							System.out.println(workspaceElement2+" =from Document-Workspace is NOT visble to user");
					}
				}
				if(documentOption.equals("Office"))
				{
					List <WebElement> officeElements=checkbox.getDocumentsOfficeAllOptionsList();
					for(WebElement officeElement:officeElements)
					{
						boolean officeElement1=officeElement.isDisplayed();

						String officeElement2=officeElement.getText();
						if(officeElement1==true)
							System.out.println(officeElement2+" =from Document-Office element is visble to user");
						else
							System.out.println(officeElement2+" =from Document-Office is NOT visble to user");
					}	
				}
			}
		}

		List <WebElement> downloadElements=checkbox.getDownloadsAllOptionsList();
		for(WebElement downloadElement:downloadElements)
		{
			boolean downloadeElement1=downloadElement.isDisplayed();
			String downloadElement2=downloadElement.getText();
			if(downloadeElement1==true)
				System.out.println(downloadElement2+" =from Download is visble to user");
			else
				System.out.println(downloadElement2+" =from Download is NOT visble to user");
		}	





	}


	@Test(description ="'Verfy that  when we click button '+' all the checkbox tree gets expanded",
			groups = {"smoke"})
	void validateExpandAllButton() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		checkbox.getcheckboxDropdownOption().click();

		checkbox.getExpandALLButton().click();
		ActionDriver.scrollByDistance(0,300);

		boolean home=checkbox.getHomeAllOptions().isDisplayed();
		boolean desktop=checkbox.getDesktopAllOptions().isDisplayed();
		boolean document=checkbox.getDocumentsAllOptions().isDisplayed();
		boolean download=checkbox.getDownloadsAllOptions().isDisplayed();

		System.out.println("home="+home);
		System.out.println("desktop="+desktop);
		System.out.println("document="+document);
		System.out.println("download="+download);

		List <WebElement> desktopElements= checkbox.getDesktopAllOptionslist();
		for(WebElement desktopElement:desktopElements)
		{
			boolean desktopElement1=desktopElement.isDisplayed();

			String desktopElementName=desktopElement.getText();
			if(desktopElement1==true)
				System.out.println(desktopElementName+" =from desktop element is visble to user");
			else
				System.out.println(desktopElementName+" =from desktop is NOT visble to user");
		}

		List <WebElement> documentElements= checkbox.getDocumentsAllOptionsList();
		for(WebElement documentElement:documentElements)
		{
			boolean documentElement1=documentElement.isDisplayed();

			if(documentElement1==true)
			{
				String documentOption=documentElement.getText();
				if(documentOption.equals("WorkSpace"))
				{
					List <WebElement> workspaceElements=checkbox.getDocumentsfirstAllOptionsList();

					for(WebElement workspaceElement:workspaceElements)
					{
						boolean workspaceElement1=workspaceElement.isDisplayed();

						String workspaceElement2=workspaceElement.getText();
						if(workspaceElement1==true)
							System.out.println(workspaceElement2+" =from Document-Workspace element is visble to user");
						else
							System.out.println(workspaceElement2+" =from Document-Workspace is NOT visble to user");
					}
				}
				if(documentOption.equals("Office"))
				{
					List <WebElement> officeElements=checkbox.getDocumentsOfficeAllOptionsList();
					for(WebElement officeElement:officeElements)
					{
						boolean officeElement1=officeElement.isDisplayed();

						String officeElement2=officeElement.getText();
						if(officeElement1==true)
							System.out.println(officeElement2+" =from Document-Office element is visble to user");
						else
							System.out.println(officeElement2+" =from Document-Office is NOT visble to user");
					}	
				}
			}
		}

		List <WebElement> downloadElements=checkbox.getDownloadsAllOptionsList();
		for(WebElement downloadElement:downloadElements)
		{
			boolean downloadeElement1=downloadElement.isDisplayed();
			String downloadElement2=downloadElement.getText();
			if(downloadeElement1==true)
				System.out.println(downloadElement2+" =from Download is visble to user");
			else
				System.out.println(downloadElement2+" =from Download is NOT visble to user");
		}	
	}



	@Test(description ="verify that even if we dont expanding folders files "
			+ "and select only parent folders then their respective child options also should get selected",
			groups = {"smoke"})
	void selectParentCheckbox() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		checkbox.getcheckboxDropdownOption().click();

		//opened all checkboxes
		checkbox.getExpandALLButton().click();
		ActionDriver.scrollByDistance(0,300);

		//1-select desktop all options
		checkbox.getDesktopAllOptions().click();
		Thread.sleep(5000);

		List <WebElement> desktopOptions=checkbox.getDesktopAllOptionslist();
		//checking elements of Desktop one by one
		for(WebElement desktopOption:desktopOptions)
		{
			boolean flag=desktopOption.isSelected();
			System.out.println(flag);
		}

		//2-select Document all options
		checkbox.getDocumentsAllOptions().click();

		List <WebElement> workplaceElements=checkbox.getDocumentsfirstAllOptionsList();
		List <WebElement> officeElements=checkbox.getDocumentsOfficeAllOptionsList();

		//checking whether workspace options are selected
		for(WebElement workplaceElement:workplaceElements)
		{
			boolean flag2=	workplaceElement.isSelected();
			System.out.println(flag2);
		}

		//checking whether office options are selected
		for(WebElement officeElement:officeElements)
		{
			boolean flag3=officeElement.isSelected();
			System.out.println(flag3);
		}

		//2-select Document all options
		checkbox.getDownloadsAllOptions().click();

		List <WebElement> downloadElements=checkbox.getDownloadsAllOptionsList();
		for(WebElement downloadElement:downloadElements)
		{
			boolean flag4=downloadElement.isSelected();
			System.out.println(flag4);
		}
	}

	@Test(description ="Verify that even if a single option is selected "
			+ "its parent folder and home checkbox should get selected",
			groups = {"smoke"})
	void selecParentCheckbox() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(2000);

		homepage.clickElement();
		Thread.sleep(2000);
		checkbox.getcheckboxDropdownOption().click();

		//opened all checkboxes
		checkbox.getExpandALLButton().click();
		ActionDriver.scrollByDistance(0,300);

		List <WebElement> desktopOptions=checkbox.getDesktopAllOptionslist();
		//selecting one option from desktop
		for(WebElement desktopOption:desktopOptions)
		{
			desktopOption.click();;
			break;
		}

		boolean flag=	checkbox.getDesktopAllOptions().isSelected();
		boolean flag1=checkbox.getHomeAllOptions().isSelected();

		System.out.println(flag);
		System.out.println(flag1);

		Thread.sleep(3000);

		//2-select few Document folder options

		List <WebElement> workplaceElements=checkbox.getDocumentsfirstAllOptionsList();
		List <WebElement> officeElements=checkbox.getDocumentsOfficeAllOptionsList();

		//checking whether workspace options are selected
		for(WebElement workplaceElement:workplaceElements)
		{
			workplaceElement.click();
		}

		//checking whether office options are selected
		for(WebElement officeElement:officeElements)
		{
			boolean flag3=officeElement.isSelected();
			System.out.println(flag3);
		}

		boolean flag2=	checkbox.getDocumentsAllOptions().isSelected();
		boolean flag3=checkbox.getHomeAllOptions().isSelected();


		System.out.println(flag);
		System.out.println(flag1);


		/*	
		//2-select few Document all options

		List <WebElement> downloadElements=checkbox.getDownloadsAllOptionsList();
		for(WebElement downloadElement:downloadElements)
		{
			boolean flag4=downloadElement.isSelected();
			System.out.println(flag4);
		}
		 */
	}

	//----------------------------------------buttons-----------------------------------------------------------------------

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
			else if(count==1)
			{
				output3=consoleOutputElement.getText();
			}
		}

		if(output1.equals("You have done a double click") && output1.equals("You have done a right click") && output1.equals("You have done a dynamic click"))
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
	
	@Test(description ="Verify that when right clicked on Right Click Me button respective message should be shown in console",
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
