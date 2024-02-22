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
	PageUtility page_Utility = new PageUtility();
	WaitUtility wait_Utility =new WaitUtility();
	
	@FindBy(xpath="//a[@title='Apply leave']")
	WebElement button_ApplyLeave;
	
	@FindBy(xpath="//a[@title='Assign leave']")
	WebElement button_AssignLeave;
	
	@FindBy(xpath="//span[@id='select2-chosen-3']")
	WebElement leave_Field;
	
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
		button_ApplyLeave.click();
	}
	
	public void clickOnDropDown()
	{
		wait_Utility.waitForAnElementToBeClickable(driver, clickDropDown);
		clickDropDown.click();
	}
	public void selectCasualLeave()
	{
		page_Utility.clickByJavaScript(leave_Field, driver);
	    select_CasualLeave.click();
	}
	public void selectLeaveFromDropDown()
	{
		page_Utility.clickByJavaScript(leave_Field, driver);
		wait_Utility.waitFowaitForAnElementToBeVisible(driver, inputField_LeaveTypeDropDown);
		Select select =new Select(inputField_LeaveTypeDropDown);
		select.selectByValue("1");
		page_Utility.clickOnEnterKey(driver, inputField_LeaveTypeDropDown);
		
	}
	public void durationSingleDay()
	{
		select_DurationSingle.click();
	}

	public void clickOnSingleDateField()
	{
		inputDate_OneDayLeave.click();
	}
	public void selectDateOfLeave()
	{
		Leave_dateFrom.click();
	}
	public void input_Reason(String reason)
	{
		page_Utility.enterText(inputField_Reason, reason);
	}
	public void submitApplyLeave()
	{
	    submit_ApplyLeave.click();
	}
	public boolean isAbleToApplyLeave()
	{
		return page_Utility.isElementEnabled(submit_ApplyLeave);
	}
	

}
