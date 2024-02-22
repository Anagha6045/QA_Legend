package PageClasses;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_TicketsPage 
{
	WebDriver driver;
	PageUtility page_Utility = new PageUtility();
	WaitUtility wait_Utility =new WaitUtility();
	
	@FindBy(xpath = "//span[text()='Print']")
	WebElement buttonPrint;
	
	@FindBy(xpath = "//table")
	WebElement ticketsTable;
	
	@FindBy(xpath = "//tbody//child::tr")
	List<WebElement> noOfTickets;
	
	@FindBy(xpath = "//a[@title='Add ticket' and text()=' Add ticket']")
	WebElement addNewTicket;
	
	@FindBy(id="title")
	WebElement inputField_Title;
	
	@FindBy(id="title")
	WebElement input_FieldTitle;
	@FindBy(xpath = "//div[@class='form-group']//label[@for='client_id']")
	WebElement dropdownIcon;
	
	@FindBy(xpath  = "//select[@name='client_id']")
	WebElement selectDropDown;
	
	@FindBy(xpath="//ul//li//div[@class='select2-result-label' and text()='APS Test Company ']]")
	WebElement inputSearch_Client;
	
	@FindBy(id="description")
	WebElement input_Description;
	
	@FindBy(xpath="//button[text()=' Save']")
	WebElement clickOnSave;
	@FindBy(xpath = "//button[text()=' Close']")
	WebElement clickOnCancel;
	
	@FindBy(xpath = "(//table//tbody//tr//td//a)[1]")
	WebElement hyperlinkTicketTitle;
	
	@FindBy(xpath = "//button[text()=' Actions                        ']")
	WebElement actionButtonOnOpenedTicketPage;
	
	public QALegend_TicketsPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void input_AddTicket()
	{
		addNewTicket.click();
	}
	
	public void input_Title(String title)
	{
	    input_FieldTitle.sendKeys(title);
	}

	
	public void input_Description(String description)
	{
		input_Description.sendKeys(description);
	}
	public void clickOnPrint()
	{
	    buttonPrint.click();
	}
	
	public void inputClient()
	{
		dropdownIcon.click();
	}
	public void selectFromDropDown(String company) throws AWTException
	{
		page_Utility.clickByJavaScript(selectDropDown,driver);
		page_Utility.scrollThePage(inputSearch_Client, driver);
		page_Utility.clickByJavaScript(inputSearch_Client,driver);
		page_Utility.robotSearchClient();
	}
	public String countTheNoOfTickets()
	{
		page_Utility.windowHandling(driver);
		List<WebElement> rows = noOfTickets; // Assuming rows are within a <tbody>
		System.out.println(rows.size());// assertion
	    return String.valueOf(rows.size()-1);
		
		
	}
	public void switchParentTab()
	{
		page_Utility.switchWindowToParentTab(driver);
	}
	public void clickOnSave()
	{
		clickOnSave.click();
	}
    
	public void clickOnCancel()
	{
		clickOnCancel.click();
	}
	public void clickOnFirstTicket()
	{
		hyperlinkTicketTitle.click();
	}
	public boolean visibilityActionButton()
	{
		return page_Utility.isElementDisplayed(actionButtonOnOpenedTicketPage);
	}
	public boolean enabledActionButton()
	{
		return page_Utility.isElementEnabled(actionButtonOnOpenedTicketPage);
	}
}
