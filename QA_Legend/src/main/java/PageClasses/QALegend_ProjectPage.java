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

	@FindBy(xpath = "//a[@title='Add project']")
	WebElement addProjectButton;
	
	@FindBy(id="title")
	WebElement input_FieldTitle;
	@FindBy(xpath = "//label[@for='client_id']//following::b")
	WebElement dropdownIcon;
	
	@FindBy(xpath  = "//select[@name='client_id']")
	WebElement selectDropDown;
	
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
	
	@FindBy(xpath = "//tbody//tr//td//a[text()='TestProject9843']")
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
	public void selectFromDropDown(String company) throws AWTException
	{
		PageUtility.clickByJavaScript(selectDropDown,driver);
		PageUtility.scrollThePage(inputSearch_Client, driver);
		PageUtility.clickByJavaScript(inputSearch_Client,driver);
		PageUtility.robotSearchClient();
	}
	public void inputDescription(String description)
	{
		PageUtility.enterText(input_Description, description);
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
		PageUtility.scrollToBottom(driver, -100);
		PageUtility.clickByJavaScript(inputField_ProjectLabels,driver);
		PageUtility.enterText(inputField_ProjectLabels, label);
	}
	public void saveProject()
	{
		PageUtility.clickOnElement(buttonSave);
	}
	public void filterByOpenStatus()
	{

		WaitUtility.waitForAnElementToBeClickable(driver, status);
		PageUtility.clickByJavaScript(status,driver);
		PageUtility.clickByJavaScript(statusOpen,driver);
	}
	
	public void filterByCompletedStatus()
	{
		PageUtility.clickByJavaScript(status,driver);
		PageUtility.clickByJavaScript(statusOpen,driver);
		//WaitUtility.waitForAnElementToBeClickable(driver, statusCompleted);
		
		PageUtility.clickByJavaScript(statusCompleted,driver);
	}
	public void filterByHoldStatus()
	{
		PageUtility.clickByJavaScript(status,driver);
		PageUtility.clickByJavaScript(statusCompleted,driver);
		PageUtility.clickByJavaScript(statusHold,driver);
	}
	public void filterByCanceledStatus()
	{
		PageUtility.clickByJavaScript(status,driver);
		PageUtility.clickByJavaScript(statusHold,driver);
		PageUtility.clickByJavaScript(statusCanceled,driver);
	}
	public void searchProject(String projectName)
	{
		WaitUtility.waitFowaitForAnElementToBeVisible(driver, searchProject);
		PageUtility.clickByJavaScript(searchProject,driver);
		PageUtility.enterTextByJavaScript(driver,searchProject, projectName);
		
	}
	public boolean addedProjectDisplayed()
	{
		return resultSearchProject.isDisplayed();
	}
	public void clickOnDeleteProject()
	{
		PageUtility.clickByJavaScript(deleteProject,driver);
	}
	public void clickOnAlertCancel()
	{
		PageUtility.clickOnElement(cancelDelete);
	}
	public void clickOnAlertDelete()
	{
		PageUtility.clickOnElement(deleteButton);
	}
	public String getDeleteWarning() throws InterruptedException
	{
		Thread.sleep(3000);
		return driver.switchTo().alert().getText();
		
	}
	
	//delete functionality
}
