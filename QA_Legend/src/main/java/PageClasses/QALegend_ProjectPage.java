package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_ProjectPage
{
	WebDriver driver;

	@FindBy(xpath = "//a[@title='Add project']")
	WebElement addProjectButton;
	
	@FindBy(id="title")
	WebElement input_FieldTitle;
	@FindBy(xpath = "//label[@for='client_id']//following::b")
	WebElement dropdownIcon;
	
	@FindBy(name = "client_id")
	WebElement selectDropDown;
	
	@FindBy(id="description")
	WebElement input_Description;
	
	@FindBy(id="start_date")
	WebElement inputField_StartDate;
	
	@FindBy(id="deadline")
	WebElement inputField_EndDate;
	
	@FindBy(xpath = "//td[@class='today day']")
	WebElement start_DateFrom;
	
	@FindBy(xpath = "//td[@class='new day' and text()='2']")
	WebElement end_DateTo;
	
	@FindBy(id="price")
	WebElement inputField_Price;
	
	@FindBy(id="project_labels")
	WebElement inputField_ProjectLabels;
	
	@FindBy(xpath="//button[text()=' Save']")
	WebElement buttonSave;
	
	@FindBy(xpath="//button[text()=' Close']")
	WebElement buttonClose;
	
	@FindBy(xpath="//button[text()='Status ']")
	WebElement status;
	
	@FindBy(xpath="//li[text()='Open']")
	WebElement statusOpen;
	@FindBy(xpath="//li[text()='Completed']")
	WebElement statusCompleted;
	@FindBy(xpath="//li[text()='Hold']")
	WebElement statusHold;
	@FindBy(xpath="//li[text()='Canceled']")
	WebElement statusCanceled;

	public QALegend_ProjectPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	public void clickOnAddProjectButton()
	{
		PageUtility.clickOnElement(addProjectButton);
	}
	public void inputTitle(String title)
	{
		PageUtility.enterText(input_FieldTitle,title);
	}
	public void inputClient()
	{
		PageUtility.clickOnElement(dropdownIcon);
	}
	public void selectFromDropDown()
	{
		Select select=new Select(selectDropDown);
		select.selectByVisibleText("APS Test Company ");
	}
	public void inputDescription(String description)
	{
		PageUtility.enterText(addProjectButton, description);
	}
	public void input_StartDate()
	{
		PageUtility.clickOnElement(inputField_StartDate);
		PageUtility.clickOnElement(start_DateFrom);
	}
	public void input_Deadline()
	{
		PageUtility.clickOnElement(inputField_EndDate);
		PageUtility.clickOnElement(end_DateTo);
	}
	public void inputPrice(String price)
	{
		PageUtility.enterText(inputField_Price, price);
	}
	public void inputLabel(String label)
	{
		PageUtility.enterText(inputField_ProjectLabels, label);
	}
	public void saveProject()
	{
		PageUtility.clickOnElement(buttonSave);
	}
	public void filterByOpenStatus()
	{
		System.out.println(status.isEnabled());
		System.out.println(status.isDisplayed());
		System.out.println(status.isSelected());
		WaitUtility.waitForAnElementToBeClickable(driver, status);
		//PageUtility.clickOnElement(status);
		PageUtility.clickOnElement(statusOpen);
	}
	public void filterByCompletedStatus()
	{
		PageUtility.clickOnElement(status);
		PageUtility.clickOnElement(statusOpen);
		WaitUtility.waitForAnElementToBeClickable(driver, statusCompleted);
		PageUtility.clickOnElement(statusCompleted);
	}
	public void filterByHoldStatus()
	{
		PageUtility.clickOnElement(status);
		PageUtility.clickOnElement(statusCompleted);
		PageUtility.clickOnElement(statusHold);
	}
	public void filterByCanceledStatus()
	{
		PageUtility.clickOnElement(status);
		PageUtility.clickOnElement(statusHold);
		PageUtility.clickOnElement(statusCanceled);
	}
}
