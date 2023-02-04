package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DemoQA.Base.TestBase;
import com.DemoQA.PageLayers.Elements_Checkbox;
import com.DemoQA.PageLayers.Elements_Textbox;
import com.DemoQA.PageLayers.Homepage;
import com.DemoQA.actiondriver.ActionDriver;
public class CheckBoxTests extends TestBase
{

	void reachCheckBox() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver); 
		Elements_Textbox ElementsTextbox=new Elements_Textbox(driver);
		Elements_Checkbox checkbox=new Elements_Checkbox(driver);
		
		SoftAssert softAssert=new SoftAssert();

		ActionDriver.scrollByDistance(0,400);
		Thread.sleep(3000);
	//	ActionDriver.jsClick(homepage.getelements());
	//	ActionDriver.actionClick(homepage.getelements());
     	homepage.clickElement2();
		Thread.sleep(2000);
		checkbox.getcheckboxDropdownOption().click();
	}
	
	@Test
	void test() throws InterruptedException
	{
		reachCheckBox();
	}
}
