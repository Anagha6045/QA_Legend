package PageClasses;


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
	
	@FindBy(xpath = "//div[@id='s2id_event_labels']")
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
		PageUtility.clickOnElement(buttonAdd_event);
	}
	public boolean IsAddEventClickable() 
	{
		return PageUtility.isElementEnabled(buttonAdd_event);
		
	}
	public String addEventTitle() 
	{
		return PageUtility.getTextFromElement(addEventPopUpTitle);
		
	}
	public void inputTitle(String title)
	{
		PageUtility.enterText(inputField_Title, title);
	}
	public void inputDescription(String description)
	{
		PageUtility.enterText(inputField_Description, description);
	}
	public void inputEventLabel(String label)
	{
		PageUtility.enterText(inputField_Description,label);
	}
	 public void inputStartDate()
     {
	   PageUtility.clickOnElement(inputField_Start_date);
	 }
	
	 public void selectStartDate()
	 {
		 PageUtility.clickOnElement(startDateCurrent_date);
	 }
	 public void inputEndDate()
     {
	   PageUtility.clickOnElement(inputField_End_date);
	 }
	 public void selectEndDate()
	 {
		 PageUtility.clickOnElement(endDateFirst_Next);
	 }
	 public void inputLocation(String location)
	 {
		
		 PageUtility.enterText(inputFieldLocation, location);
	 }
	 public void inputLabel(String label)
	 {
		 System.out.println(inputField_Label.isEnabled());
		 System.out.println(inputField_Label.isDisplayed());
		 System.out.println(inputField_Label.isEnabled());
		 WaitUtility.waitForAnElementToBeClickable(driver, inputField_Label);
		 PageUtility.clickOnEnterKey(driver, inputField_Label);
		 PageUtility.enterText(inputField_Label, label);
	 }

	 public void inputClientField(String client)
	 {
		 System.out.println(clientFieldDropDown.isEnabled());
		 System.out.println(clientFieldDropDown.isDisplayed());
		 System.out.println(clientFieldDropDown.isEnabled());
		 WaitUtility.waitForAnElementToBeClickable(driver, inputField_Label);
		 PageUtility.clickOnElement(clientFieldDropDown);
		 
		 
		 
	 }
	 public void searchForClient(String client)
	 {
		 System.out.println(clientField_SearchBox.isEnabled());
		 System.out.println(clientField_SearchBox.isDisplayed());
		 System.out.println(clientField_SearchBox.isEnabled());
		 WaitUtility.waitForAnElementToBeClickable(driver, clientField_SearchBox);
		
		 
		 PageUtility.enterText(clientField_SearchBox, client);
		
	 }
	 
	 public void shareWithField()
	 {
		 PageUtility.clickOnElement(shareWithField_Radio);
	 }
	 public void selectThemeColor()
	 {
		 PageUtility.clickOnElement(eventThemeColor);
	 }
	 
	public void clickOnSave()
	{
		PageUtility.submitPage(SaveButton);
	}
	public void scrollThePage()
	{
		
	}
	public void searchForAddedEvent(String title)
	{
		PageUtility.getTextFromElement(clientField_SearchBox);
	}
   
	
	
	
	
	
}
