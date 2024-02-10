package PageClasses;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegend_TicketsPage 
{
	WebDriver driver;
	
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
		PageUtility.clickOnElement(addNewTicket);
	}
	
	public void input_Title(String title)
	{
		PageUtility.enterText(input_FieldTitle,title);
	}

	
	public void input_Description(String description)
	{
		PageUtility.enterText(input_Description,description);
	}
	public void clickOnPrint()
	{
		PageUtility.clickOnElement(buttonPrint);
	}
	
	public void inputClient()
	{
		PageUtility.clickOnElement(dropdownIcon);
	}
	public void selectFromDropDown(String company) throws AWTException
	{
		PageUtility.clickByJavaScript(selectDropDown,driver);
		PageUtility.scrollThePage(inputSearch_Client, driver);
		PageUtility.clickByJavaScript(inputSearch_Client,driver);
		PageUtility.robotSearchClient();
	}
	public String countTheNoOfTickets()
	{
		PageUtility.windowHandling(driver);
		//List<Integer> rowSizes = new ArrayList<>();
		List<WebElement> rows = noOfTickets; // Assuming rows are within a <tbody>
		System.out.println(rows.size());// assertion
		
		  return String.valueOf(rows.size()-1);
		
		
	}
	public void switchParentTab()
	{
		PageUtility.switchWindowToParentTab(driver);
	}
	public void clickOnSave()
	{
		PageUtility.clickOnElement(clickOnSave);
	}
    
	public void clickOnCancel()
	{
		PageUtility.clickOnElement(clickOnCancel);
	}
	public void clickOnFirstTicket()
	{
		PageUtility.clickOnElement(hyperlinkTicketTitle);
	}
	public boolean visibilityActionButton()
	{
		return PageUtility.isElementDisplayed(actionButtonOnOpenedTicketPage);
	}
	public boolean enabledActionButton()
	{
		return PageUtility.isElementEnabled(actionButtonOnOpenedTicketPage);
	}
}
