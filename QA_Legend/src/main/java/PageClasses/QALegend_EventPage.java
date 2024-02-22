package PageClasses;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.DateUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_EventPage
{

	WebDriver driver;
	PageUtility page_Utility = new PageUtility();
	WaitUtility wait_Utility =new WaitUtility();
	
	@FindBy(xpath = "//a[text()=' Add event']")
	WebElement buttonAdd_event;
	
	@FindBy(id="title")
	WebElement inputField_Title;
	
	@FindBy(id="description")
	WebElement inputField_Description;
	
	@FindBy(id="start_date")
	WebElement inputField_Start_date;
	
	@FindBy(id="end_date")
	WebElement inputField_End_date;
	
	@FindBy(xpath = "//td[@class='today day']")
	WebElement startDateCurrent_date;
	
	@FindBy(xpath = "//td[@class='new day' and text()='1']")
	WebElement endDateFirst_Next;
	
	@FindBy(id = "location")
	WebElement inputFieldLocation;
	
	@FindBy(xpath = "//button[text()='day']")
	WebElement dayButton;
	
	@FindBy(xpath = "//div[@class='fc-event-container']//a[last()]")
	WebElement startDateGridline;
	
	@FindBy(xpath = "//h4[text()='Demo CRM']")
	WebElement eventTitlefromPage;
	
	@FindBy(id = "//input[starts-with(@id,'s2id')][1]")
	WebElement inputField_Label;
	@FindBy(xpath = "//b[@role='presentation'][1]")
	WebElement clientFieldDropDown;
	
	@FindBy(xpath = "//span[@id='select2-chosen-1']")
	WebElement clientField_SearchBox;
	
	@FindBy(id = "only_me")
	WebElement shareWithField_Radio;
	
	@FindBy(xpath = "//*[@id=\"event-form\"]/div[1]/div[11]/div/div/span[12]")
	WebElement eventThemeColor;
	
	@FindBy(xpath ="//button[text()=' Save']")
	WebElement SaveButton;
	
	@FindBy(id="ajaxModalTitle")
	WebElement addEventPopUpTitle;
	
	public QALegend_EventPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnAddEvent() 
	{
		page_Utility.clickByJavaScript(buttonAdd_event, driver);
	
	}
	public boolean IsAddEventClickable() 
	{
		return page_Utility.isElementEnabled(buttonAdd_event);
		
	}
	public String addEventTitle() 
	{
		return page_Utility.getTextFromElement(addEventPopUpTitle);
		
	}
	public void inputTitle(String title)
	{
		page_Utility.enterText(inputField_Title, title);
	}
	public void inputDescription(String description)
	{
		page_Utility.enterText(inputField_Description, description);
	}
	public void inputEventLabel(String label)
	{
		page_Utility.enterText(inputField_Description,label);
	}
	 public void inputStartDate()
     {
	   inputField_Start_date.click();
	 }
	
	 public void selectStartDate()
	 {
		startDateCurrent_date.click();
	 }
	 public void inputEndDate()
     {
	  inputField_End_date.click();
	 }
	 public void selectEndDate()
	 {
		 endDateFirst_Next.click();
	 }
	 public void inputLocation(String location)
	 {
		
		 page_Utility.enterText(inputFieldLocation, location);
	 }
	 public void inputLabel(String label)
	 {
		 wait_Utility.waitForAnElementToBeClickable(driver, inputField_Label);
		 page_Utility.clickOnEnterKey(driver, inputField_Label);
		 page_Utility.enterText(inputField_Label, label);
	 }

	 public void inputClientField(String client)
	 {
		 wait_Utility.waitForAnElementToBeClickable(driver, inputField_Label);
		 page_Utility.clickOnElement(clientFieldDropDown);
		 
		 
		 
	 }
	 public void searchForClient(String client)
	 {

		 wait_Utility.waitForAnElementToBeClickable(driver, clientField_SearchBox);
		 page_Utility.enterText(clientField_SearchBox, client);
		
	 }
	 
	 public void shareWithField()
	 {
		 shareWithField_Radio.click();
	 }
	 public void selectThemeColor()
	 {
		 eventThemeColor.click();
	 }
	 
	public void clickOnSave()
	{
		page_Utility.submitPage(SaveButton);
	}
	public void scrollThePage()
	{
		
	}
	public void clickOnDayButton()
	{
		wait_Utility.waitForAnElementToBeClickable(driver, dayButton);
		page_Utility.clickByJavaScript(dayButton,driver);
	}
   
	public void clickOnEventGrid()
	{
		page_Utility.clickByJavaScript(startDateGridline, driver);
	}
	public boolean getEventTitle()
	{
		return page_Utility.isElementDisplayed(eventTitlefromPage);
	}
	
	
	
}
