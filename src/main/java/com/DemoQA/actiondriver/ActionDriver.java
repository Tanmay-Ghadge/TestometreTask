package com.DemoQA.actiondriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import com.DemoQA.Base.DriverFactory;
import com.DemoQA.Base.ExtentReportThreadSafe;
import com.DemoQA.Base.TestBase;
import com.aventstack.extentreports.Status;

public class ActionDriver extends TestBase
{
	static WebDriver driver=DriverFactory.getInstance().getDriver();
	public static Object checkElementVisibility;

	public static void  sendkeysCustom(WebElement element,String fieldName,String valueToEnter)
	{
		try
		{
			element.sendKeys(valueToEnter);
			//	ExtentReportThreadSafe.getInstance().getExtent().log(Status.PASS,"successfully entered value--valueToEnter in field "+fieldName);
		}
		catch(Exception e)
		{
			//	ExtentReportThreadSafe.getInstance().getExtent().log(Status.FAIL,"failed to enter value in field "+fieldName+" due to exception-->"+e);

		}
	}

	public static void  naviagteBack()
	{
		driver.navigate().back();
	}

	public static String  getHexValue(WebElement element,String cssValueName)
	{
		String rgbValue=element.getCssValue(cssValueName);

		String hexValue=Color.fromString(rgbValue).asHex();
		return hexValue;
	}

	public static void  naviagteForward()
	{
		driver.navigate().forward();
	}

	public static String  getPlaceholderName(WebElement element)
	{
		String placeholder=element.getAttribute("placeholder");
		return placeholder;
	}

	public void clickCustom(WebElement element,String fieldName,String valueToEnter)
	{
		try
		{
			element.click();
			ExtentReportThreadSafe.getInstance().getExtent().log(Status.PASS,"successfully clicked on field -"+fieldName);
		}
		catch(Exception e)
		{
			ExtentReportThreadSafe.getInstance().getExtent().log(Status.FAIL,"failed to click on field "+fieldName+" due to exception-->"+e);

		}
	}

	public static boolean getpageTitle(String expectedTitle)
	{
		String actualPageTitle=driver.getTitle();
		if(actualPageTitle.equals(expectedTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static String getpageTitle()
	{
		String actualPageTitle=driver.getTitle();
		return actualPageTitle;
	}

	public static void jsClick(WebElement element)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();",element);
	}


	public static boolean dropdownSelectByValue(WebElement locationOfDropdown,String value)
	{
		boolean flag = false;
		try 
		{
			Select dropdown=new Select(locationOfDropdown);
			dropdown.selectByValue(value);
			flag = true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
			{
				System.out.println("dropdown Option-"+value+" was chosen by value");
			}
			else
			{
				System.out.println("dropdown Option-"+value+" was NOT chosen by value");
			}
		}

	}

	public static boolean dropdownSelectByIndex(WebElement locationOfDropdown,int index)
	{
		boolean flag = false;
		try 
		{
			Select dropdown=new Select(locationOfDropdown);
			dropdown.selectByIndex(index);
			flag = true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
			{
				System.out.println("dropdown index-"+index+" was chosen by index");
			}
			else
			{
				System.out.println("dropdown index-"+index+" was NOT chosen by value");
			}
		}

	}

	public static boolean dropdownSelectByvisibleText(WebElement locationOfDropdown,String visibleText)
	{
		boolean flag = false;
		try 
		{
			Select dropdown=new Select(locationOfDropdown);
			dropdown.selectByVisibleText(visibleText);
			flag = true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
			{
				System.out.println("dropdown Option-"+visibleText+" was chosen by visibleText");
			}
			else
			{
				System.out.println("dropdown Option-"+visibleText+" was NOT chosen by visibleText");
			}
		}

	}

	public static boolean dropdownUL(List<WebElement> listOfOptions,String optionToChoose)
	{
		boolean flag=false;
		try
		{
			for (WebElement eachoption : listOfOptions) 
			{
				String option=eachoption.getText();
				if(option.equals(optionToChoose))
				{
					eachoption.click();
					flag=true;
					return flag;
				}
			}
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
				System.out.println("dropdown Option-"+optionToChoose+" was  chosen by li option");
			else
				System.out.println("dropdown Option-"+optionToChoose+" was NOT chosen by li option");
		}
		return flag;
	}

	public static boolean dropdownOptionispresent(List<WebElement> listOfOptions,String optionToChoose)
	{
		boolean flag=false;
		try
		{
			for (WebElement eachoption : listOfOptions) 
			{
				String option=eachoption.getText();
				if(option.equals(optionToChoose))
				{
					flag=true;
					return flag;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return flag;
	}


	public static void navigateback(WebDriver cdriver)
	{
		cdriver.navigate().back();
	}

	public static void browserforwardBTN() throws AWTException
	{
		Robot robot=new Robot();
		robot.mouseMove(50,50);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public static void browserBackwardBTN() throws AWTException
	{
		Robot robot=new Robot();
		robot.mouseMove(23,50);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public static boolean dropdownoptions(WebElement location,String optionToChoose)
	{
		boolean flag=false;
		try
		{
			Select dropdown=new Select(location);
			List <WebElement> allOptions=dropdown.getOptions();

			for( WebElement  options:allOptions)
			{			
				if(options.getText().equals(optionToChoose))
				{
					options.click();
					flag=true;
				}			
				break;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
			{
				System.out.println("dropdown Option-"+optionToChoose+" was chosen by li option");
			}
			else
			{
				System.out.println("dropdown Option-"+optionToChoose+" was NOT chosen by li option");
			}

		}
		return flag;


	}

	  public static boolean actionClick(WebElement elementToClick)
	{
		boolean flag=false;
		try 
		{
			Actions act = new Actions(driver);
			act.moveToElement(elementToClick).click().build().perform();
			flag=true;
		}
		catch(Exception e)
		{
			return false;
		}
		return flag;

	}

	  public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public static void scrollByDistance(int horizontalDistance,int verticalDistance)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("window.scrollBy("+horizontalDistance+","+verticalDistance+")"+","+"\"\"");

	}

	public boolean type(WebElement element, String text)
	{
		boolean flag = false;
		try 
		{
			flag = element.isDisplayed();
			element.clear();
			element.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) 
		{
			System.out.println("Location Not found");
			return false;
		} finally
		{
			if (flag==true) 
			{
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}

	public static void clickWebeElement(WebElement element)
	{
		element.click();
	}

	public static boolean checkElementVisibility(WebElement element) 
	{
		element.isDisplayed();
		return true;		
	}

	public static String getTextCustom(WebElement element) 
	{
		String text=element.getText();
		return text;
	}

	public static void pressEnterRobot() throws AWTException 
	{
		Robot robot=new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void robotBackspace() throws AWTException 
	{
		Robot robot=new Robot();

		robot.keyPress(KeyEvent.VK_BACK_SPACE);
	}


	public static void actionEnter() throws AWTException 
	{
		Actions act = new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

	}



	public static String actionGetAttribute(WebElement element, String attributeName)
	{
		return element.getAttribute(attributeName);
	}

	public static void actionMove(WebElement element) 
	{
		Actions act = new Actions(driver);

		act.moveToElement(element)
		.keyDown(Keys.BACK_SPACE).perform();		
	}




}
