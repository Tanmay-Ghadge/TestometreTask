package Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DemoQA.Base.TestBase;
import com.DemoQA.PageLayers.Elements_Checkbox;
import com.DemoQA.PageLayers.Elements_Textbox;
import com.DemoQA.PageLayers.Homepage;
import com.DemoQA.actiondriver.ActionDriver;

public class Checkbox extends TestBase
{
	
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
		
		//did not put any assertions
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
		
		softAssert.assertEquals(home, false);
		softAssert.assertEquals(desktop, false);
		softAssert.assertEquals(document, false);
		softAssert.assertEquals(download, false);
		
		softAssert.assertAll();
	}

	@Test(description = "verify by default any chekbox options should not be in expanded condition",groups = {"smoke"})
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
		Thread.sleep(10000);
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
							if(documentOptionName.contains("React"))
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
		//No assertions
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
	
	
}
