package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegend_ClientPage
{
	WebDriver driver;
	PageUtility page_Utility = new PageUtility();

	@FindBy(xpath = "//a[text()=' Add client']")
	WebElement buttonAdd_client;
	
	@FindBy(id = "company_name")
	WebElement inputField_CompanyName;

	@FindBy(xpath = "//textarea[@name='address']")
	WebElement inputField_Address;
	
	@FindBy(id = "city")
	WebElement inputField_City;
	
	@FindBy(id = "state")
	WebElement inputField_State;
	
	@FindBy(id = "zip")
	WebElement inputField_Zip;
	
	@FindBy(id = "country")
	WebElement inputField_Country;
		
	@FindBy(id = "phone")
	WebElement inputField_Phone;		
			
	@FindBy(id = "website")
	WebElement inputField_Website;
	
	@FindBy(id = "vat_number")
	WebElement inputField_VAT;
			
	@FindBy(name = "group_ids")	
	WebElement inputField_ClientGroups;
	
	@FindBy(xpath = "//span[@id='company_name-error']")
	WebElement fieldMandatoryMessage;
	
	@FindBy(xpath = "//button[@type='submit']")	
	WebElement button_Save;
	
	@FindBy(id="ajaxModalTitle")
	WebElement addClientPopUpTitle;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchForClient;
	
	@FindBy(xpath="//span[text()='Excel']")
	 WebElement excelDownload;

	@FindBy(xpath="//span[text()='Print']")
	 WebElement printClientReport;

	@FindBy(xpath="//input[@type='search' and @placeholder='Search']")
	WebElement searchForSavedClients;
	
	@FindBy(xpath = "//h1[text()='Demo CRM']")
	WebElement titleOfThePage;
	
	@FindBy(xpath = "//table//thead//tr//th")
	List<WebElement> countofColumnHeadings;
	
	public QALegend_ClientPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddClient() 
	{
		page_Utility.clickOnElement(buttonAdd_client);
	}
	public boolean IsAddEventClickable() 
	{
		return page_Utility.isElementEnabled(buttonAdd_client);
		
	}
	public String addEventTitle() 
	{
		return page_Utility.getTextFromElement(addClientPopUpTitle);
		
	}
	public void inputCompanyName(String companyName)
	{
		page_Utility.scrollThePage(inputField_CompanyName, driver);
		page_Utility.enterText(inputField_CompanyName, companyName);
	}
	
	public void inputAddress(String address)
	{
		page_Utility.enterText(inputField_Address, address);
	}
	
	public void inputCity(String label)
	{
		page_Utility.enterText(inputField_City,label);
	}

	 public void inputState(String state)
	 {
		
		 page_Utility.enterText(inputField_State, state);
	 }
	 public void inputZip(String string)
	 {
		
		 page_Utility.enterText(inputField_Zip, string);
	 }
	 public void inputCountry(String country)
	 {
		
		 page_Utility.enterText(inputField_Country, country);
	 }
	 
	public void inputPhone(String phone)
	 {
			
		page_Utility.enterText(inputField_Phone, phone);
     }
	public void inputWebsite(String website)
	 {
			
		page_Utility.enterText(inputField_Website, website);
    }
	public void inputVAT(String vatNumber)
	 {
			
		page_Utility.enterText(inputField_VAT, vatNumber);
		page_Utility.scrollThePage(inputField_VAT, driver);
   }
	public void inputClientGroups(String client)
	 {
		page_Utility.scrollThePage(inputField_ClientGroups, driver);
		page_Utility.enterText(inputField_ClientGroups,client);
    }
	public void button_Save()
	 {
			 button_Save.click();
     }
	public String addClientTitle() 
	{
		return page_Utility.getTextFromElement(addClientPopUpTitle);
		
	}
   public String mandatoryMessage()
   {
	return fieldMandatoryMessage.getText();
   }
	public void searchForClient(String client)
	{
		page_Utility.clickOnElement(searchForSavedClients);
		page_Utility.enterText(searchForSavedClients,client);
		page_Utility.clickOnEnterKey(driver,searchForSavedClients);
	}
	public void downloadExcelReport()
	{
		excelDownload.click();
	}
	public void printExcelReport()
	{
		printClientReport.click();
	}
	
	
	public void windowHandle()
	{
		page_Utility.windowHandling(driver);
	}
	public void switchToDefault()
	{
		page_Utility.switchTab(driver, null);
	}
	public int noOfColumns()
	{
		page_Utility.windowHandling(driver);
		List<WebElement> rows = countofColumnHeadings;
		System.out.println(rows.size());// assertion
		
		  return rows.size();
		
	}
	public void switchParentTab()
	{
		page_Utility.switchWindowToParentTab(driver);
	}
}