package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_LeavePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//a[@title='Apply leave']")
	WebElement button_ApplyLeave;
	
	@FindBy(xpath="//a[@title='Assign leave']")
	WebElement button_AssignLeave;
	
	@FindBy(id="leave_type_id")
	WebElement inputField_LeaveTypeDropDown;
	
	@FindBy(xpath = "//div[text()='Casual Leave ']")
	WebElement select_CasualLeave;
	
	@FindBy(xpath = "//label[text()='Leave type']//following::b[1]")
	WebElement clickDropDown;
	@FindBy(xpath="//input[@value='single_day']")
	WebElement select_DurationSingle;
	
	@FindBy(xpath="//input[@value='multiple_days']")
	WebElement select_DurationMultiple;
	

	@FindBy(id="start_date")
	WebElement inputDate_FromDate;
	
	@FindBy(id="end_date")
	WebElement inputDate_ToDate;
	
	@FindBy(id="single_date")
	WebElement inputDate_OneDayLeave;
	
	
	@FindBy(xpath = "//td[@class='today day']")
	WebElement Leave_dateFrom;
	
	@FindBy(xpath = "//td[@class='new day' and text()='1']")
	WebElement Leave_dateTo;

	@FindBy(xpath = "//textarea[@name='reason']")
	WebElement inputField_Reason;
	
	@FindBy(xpath = "//button[text()=' Apply leave']")
	WebElement submit_ApplyLeave;
	
	@FindBy(xpath = "//button[text()=' Close']")
	WebElement buttonClose;
	
	public QALegend_LeavePage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnButtonApplyLeave()
	{
		PageUtility.clickOnElement(button_ApplyLeave);
	}
	
	public void clickOnDropDown()
	{
		PageUtility.clickOnElement(clickDropDown);
	}
	public void selectCasualLeave()
	{
		PageUtility.clickOnElement(select_CasualLeave);
	}
	public void selectLeaveFromDropDown()
	{
		WaitUtility.waitFowaitForAnElementToBeVisible(driver, inputField_LeaveTypeDropDown);
		Select select =new Select(inputField_LeaveTypeDropDown);
		select.selectByValue("1");
		PageUtility.clickOnEnterKey(driver, inputField_LeaveTypeDropDown);
		
	}
	public void durationSingleDay()
	{
		PageUtility.clickOnElement(select_DurationSingle);
	}

	public void clickOnSingleDateField()
	{
		PageUtility.clickOnElement(inputDate_OneDayLeave);
	}
	public void selectDateOfLeave()
	{
		PageUtility.clickOnElement(Leave_dateFrom);
	}
	public void input_Reason(String reason)
	{
		PageUtility.enterText(inputField_Reason, reason);
	}
	public void submitApplyLeave()
	{
		PageUtility.clickOnElement(submit_ApplyLeave);
	}
	
	

}
