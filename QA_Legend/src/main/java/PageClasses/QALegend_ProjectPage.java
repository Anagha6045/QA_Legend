package PageClasses;

import java.awt.AWTException;

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
	PageUtility page_Utility = new PageUtility();
	WaitUtility wait_Utility =new WaitUtility();

	@FindBy(xpath = "//a[@title='Add project']")
	WebElement addProjectButton;
	
	@FindBy(id="title")
	WebElement input_FieldTitle;
	@FindBy(xpath = "//label[@for='client_id']//following::b")
	WebElement dropdownIcon;
	
	@FindBy(xpath  = "//select[@name='client_id']")
	WebElement selectDropDown;
	
	@FindBy(xpath ="(//a[@class='select2-choice'])[3]")
	WebElement click_ClientField;
	@FindBy(xpath="//ul//li//div[@class='select2-result-label' and text()='APS Test Company ']")
	WebElement inputSearch_Client;
	
	@FindBy(xpath="//div[text()='APS Test Company ']")
	WebElement selectClient;
	
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
	
	@FindBy(id ="//li//input")
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
	
	@FindBy(xpath="//label//input[@placeholder='Search']")
	WebElement searchProject;
	
	@FindBy(xpath = "//tbody//tr//td//a[text()='TestProject9442']")
	WebElement resultSearchProject;
	
	@FindBy(xpath = "(//a[@title='Delete project'])[1]")
	WebElement deleteProject;
	
	@FindBy(id="confirmDeleteButton")
	WebElement deleteButton;
	
	@FindBy(xpath = "//button[text()=' Cancel']")
	WebElement cancelDelete;

	public QALegend_ProjectPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	public void clickOnAddProjectButton()
	{
		addProjectButton.click();
	}
	public void inputTitle(String title)
	{
		input_FieldTitle.sendKeys(title);
	}
	public void inputClient()
	{
		dropdownIcon.click();
	}
	public void selectFromDropDown(String company) throws AWTException
	{
		page_Utility.clickByJavaScript(click_ClientField,driver);
		page_Utility.clickByJavaScript(inputSearch_Client,driver);
		page_Utility.robotSearchClient();
	}
	public void inputDescription(String description)
	{
		input_Description.sendKeys(description) ;
	}
	public void input_StartDate()
	{
		inputField_StartDate.click();
		start_DateFrom.click();
	}
	public void input_Deadline()
	{
		inputField_EndDate.click();
		end_DateTo.click();
	}
	public void inputPrice(String price)
	{
		inputField_Price.sendKeys(price);
	}
	public void inputLabel(String label)
	{
		page_Utility.scrollToBottom(driver, -100);
		page_Utility.clickByJavaScript(inputField_ProjectLabels,driver);
		page_Utility.enterText(inputField_ProjectLabels, label);
	}
	public void saveProject()
	{
		buttonSave.click();
	}
	public void filterByOpenStatus()
	{

		wait_Utility.waitForAnElementToBeClickable(driver, status);
		page_Utility.clickByJavaScript(status,driver);
		page_Utility.clickByJavaScript(statusOpen,driver);
	}
	
	public void filterByCompletedStatus()
	{
		page_Utility.clickByJavaScript(status,driver);
		page_Utility.clickByJavaScript(statusOpen,driver);
		page_Utility.clickByJavaScript(statusCompleted,driver);
	}
	public void filterByHoldStatus()
	{
		page_Utility.clickByJavaScript(status,driver);
		page_Utility.clickByJavaScript(statusCompleted,driver);
		page_Utility.clickByJavaScript(statusHold,driver);
	}
	public void filterByCanceledStatus()
	{
		page_Utility.clickByJavaScript(status,driver);
		page_Utility.clickByJavaScript(statusHold,driver);
		page_Utility.clickByJavaScript(statusCanceled,driver);
	}
	public void searchProject(String projectName)
	{
		wait_Utility.waitFowaitForAnElementToBeVisible(driver, searchProject);
		page_Utility.clickByJavaScript(searchProject,driver);
		page_Utility.enterTextByJavaScript(driver,searchProject, projectName);
		
	}
	public boolean addedProjectDisplayed()
	{
		return resultSearchProject.isDisplayed();
	}
	public void clickOnDeleteProject()
	{
		page_Utility.clickByJavaScript(deleteProject,driver);
	}
	public void clickOnAlertCancel()
	{
		cancelDelete.click();
	}
	public void clickOnAlertDelete()
	{
		deleteButton.click();
	}
	public String getDeleteWarning() throws InterruptedException
	{
		
		return driver.switchTo().alert().getText();
		
	}
	
	//delete functionality
}
