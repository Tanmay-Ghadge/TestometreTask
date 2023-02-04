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
	
	//Home
	@FindBy(xpath="//span[text()='Home']")
	private WebElement homeAllOptions;
	
	@FindBy(xpath="//div[@id='tree-node']/ol/li/ol/li")
	private List <WebElement> homeOptionsList;
	

	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/span[1]/button[1]")
	private WebElement homedownArrow;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]")
	private WebElement homeExpandedCollapse;
	
	
	//-----------------------------
	
	//Desktop
	@FindBy(xpath="//span[text()='Desktop']")
	private WebElement desktopAllOptions;
	
	@FindBy(xpath="//div[@id='tree-node']/ol/li/ol/li[1]/ol/li/span/label/span[3]")
	private List <WebElement> desktopAllOptionslist;
	//div[@id='tree-node']/ol/li/ol/li[1]/ol/li/span/label/span[2]
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[1]")
	private WebElement desktopExpandedCollapse;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[1]/span[1]/button[1]")
	private WebElement desktopArrow;	
	
	//-----------------------------
	
	//Document 
	@FindBy(xpath="//span[text()='Documents']")
	private WebElement DocumentsAllOptions;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol/li/span/label/span[3]")
	private List <WebElement> DocumentsAllOptionsList;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol[1]/li[1]/ol/li/span/label/span[3]")
	private  List <WebElement> DocumentsfirstAllOptionsList;
	
	
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol[1]/li[2]/ol/li/span/label/span[3]")
	private List <WebElement>  DocumentsOfficeAllOptionsList;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]")
	private WebElement documentExpandedCollapse;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol[1]/li[1]")
	private WebElement documentWorkspaceExpandedCollapse;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol[1]/li[2]")
	private WebElement documentOfficeExpandedCollapse;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/span[1]/button[1]")
	private WebElement documentArrow;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol[1]/li[1]/span[1]/button[1]")
	private WebElement documentWorkspaceArrow;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol[1]/li[2]/span[1]/button[1]")
	private WebElement documentOfficeArrow;
	
//---------------------------------------------------
	// Downloads
	
	@FindBy(xpath="//span[text()='Downloads']")
	private WebElement DownloadsAllOptions;
	
	@FindBy(xpath="//div[@id='tree-node']/ol/li/ol/li[3]/ol/li/span/label/span[3]")
	private  List <WebElement> DownloadsAllOptionsList;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[3]/span[1]/button[1]")
	private WebElement downloadArrow;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[3]")
	private WebElement downloadExpandedCollapse;
	
//-----------------------------------------------------------
	//expand and collapse all
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/button[1]")
	private WebElement expandALL;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/button[2]")
	private WebElement collapseALL;
	
//-------------------test method----------------------	
	
	public WebDriver getLocalDriver() {
		return localDriver;
	}

	public WebElement getExpandALLButton() {
		return expandALL;
	}

	public WebElement getCollapseALL() {
		return collapseALL;
	}

	public WebElement getcheckboxDropdownOption() {
		return checkboxDropdownOption;
	}
	
	public WebElement getHomedownArrow() {
		return homedownArrow;
	}
	
	public WebElement getHomeAllOptions() {
		return homeAllOptions;
	}


	public List<WebElement> getHomeOptionsList() {
		return homeOptionsList;
	}


	public WebElement getDesktopAllOptions() {
		return desktopAllOptions;
	}


	public List<WebElement> getDesktopAllOptionslist() {
		return desktopAllOptionslist;
	}


	public WebElement getDocumentsAllOptions() {
		return DocumentsAllOptions;
	}


	public List<WebElement> getDocumentsWorkspaceAllOptionsList() {
		return DocumentsfirstAllOptionsList;
	}


	public List<WebElement> getDocumentsOfficeAllOptionsList() {
		return DocumentsOfficeAllOptionsList;
	}


	public WebElement getDownloadsAllOptions() {
		return DownloadsAllOptions;
	}


	public List<WebElement> getDownloadsAllOptionsList() {
		return DownloadsAllOptionsList;
	}


	public WebElement getDesktopArrow() {
		return desktopArrow;
	}


	public WebElement getDocumentArrow() {
		return documentArrow;
	}


	public WebElement getDownloadArrow() {
		return downloadArrow;
	}
	
	public WebElement getCheckboxDropdownOption() {
		return checkboxDropdownOption;
	}

	public WebElement getHomeExpandedCollapse() {
		return homeExpandedCollapse;
	}

	public WebElement getDesktopExpandedCollapse() {
		return desktopExpandedCollapse;
	}

	public WebElement getDocumentExpandedCollapse() {
		return documentExpandedCollapse;
	}

	public WebElement getDocumentWorkspaceExpandedCollapse() {
		return documentWorkspaceExpandedCollapse;
	}
	
	public List<WebElement> getDocumentsAllOptionsList() {
		return DocumentsAllOptionsList;
	}
	
	public WebElement getDocumentOfficeExpandedCollapse() {
		return documentOfficeExpandedCollapse;
	}

	public WebElement getDownloadExpandedCollapse() {
		return downloadExpandedCollapse;
	}


	public List<WebElement> getDocumentsfirstAllOptionsList() {
		return DocumentsfirstAllOptionsList;
	}

	public WebElement getDocumentWorkspaceArrow() {
		return documentWorkspaceArrow;
	}

	public WebElement getDocumentOfficeArrow() {
		return documentOfficeArrow;
	}
}
