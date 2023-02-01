package com.DemoQA.PageLayers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements_Checkbox 
{
	WebDriver localDriver;

	public Elements_Checkbox(WebDriver rdriver)
	{
		localDriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	@FindBy(id="item-1")
	private WebElement checkboxDropdownOption;
	
	@FindBy(xpath="//span[text()='Home']")
	private WebElement homeAllOptions;
	
	@FindBy(xpath="//div[@id='tree-node']/ol/li/ol/li")
	private List <WebElement> homeOptionsList;
	
	//-----------------------------
	
	@FindBy(xpath="//span[text()='Desktop']")
	private WebElement desktopAllOptions;
	
	@FindBy(xpath="//div[@id='tree-node']/ol/li/ol/li[1]/ol/li/span/label/span[2]")
	private List <WebElement> desktopAllOptionslist;

	//-----------------------------
	
	@FindBy(xpath="//span[text()='Documents']")
	private WebElement DocumentsAllOptions;
	
	@FindBy(xpath="//div[@id='tree-node']/ol/li/ol/li[2]/ol/li/ol/li/span/label/span[2]")
	private  List <WebElement> DocumentsfirstAllOptionsList;
	
	@FindBy(xpath="//div[@id='tree-node']/ol/li/ol/li[2]/ol/li/ol/li/span/label/span[2]")
	private List <WebElement>  DocumentssecondAllOptionsList;
	
	
	//---------------------------------------------------
	@FindBy(xpath="//span[text()='Downloads']")
	private WebElement DownloadsAllOptions;
	
	@FindBy(xpath="//div[@id='tree-node']/ol/li/ol/li[3]/ol/li/span/label/span[2]")
	private  List <WebElement> DownloadsAllOptionsList;
	
	
	
//------------------------	
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/span[1]/button[1]")
	private WebElement homedownArrow;

	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[1]/span[1]/button[1]")
	private WebElement desktopArrow;	
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/span[1]/button[1]")
	private WebElement documentArrow;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[3]/span[1]/button[1]")
	private WebElement downloadArrow;
	
	//--------------
	
	
	
	
	
	//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/span[1]/button[1]
	
	public WebElement getcheckboxDropdownOption() {
		return checkboxDropdownOption;
	}
	
	
	public WebElement getHomedownArrow() {
		return homedownArrow;
	}
	
	
	
	
	
}
