package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_ClientPage
{
	WebDriver driver;

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

	public QALegend_ClientPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddClient() 
	{
		PageUtility.clickOnElement(buttonAdd_client);
	}
	public boolean IsAddEventClickable() 
	{
		return PageUtility.isElementEnabled(buttonAdd_client);
		
	}
	public String addEventTitle() 
	{
		return PageUtility.getTextFromElement(addClientPopUpTitle);
		
	}
	public void inputCompanyName(String companyName)
	{
		PageUtility.scrollThePage(inputField_CompanyName, driver);
		PageUtility.enterText(inputField_CompanyName, companyName);
	}
	
	public void inputAddress(String address)
	{
		PageUtility.enterText(inputField_Address, address);
	}
	
	public void inputCity(String label)
	{
		PageUtility.enterText(inputField_City,label);
	}

	 public void inputState(String state)
	 {
		
		 PageUtility.enterText(inputField_State, state);
	 }
	 public void inputZip(String string)
	 {
		
		 PageUtility.enterText(inputField_Zip, string);
	 }
	 public void inputCountry(String country)
	 {
		
		 PageUtility.enterText(inputField_Country, country);
	 }
	 
	public void inputPhone(String phone)
	 {
			
			 PageUtility.enterText(inputField_Phone, phone);
     }
	public void inputWebsite(String website)
	 {
			
			 PageUtility.enterText(inputField_Website, website);
    }
	public void inputVAT(String vatNumber)
	 {
			
			 PageUtility.enterText(inputField_VAT, vatNumber);
			 PageUtility.scrollThePage(inputField_VAT, driver);
   }
	public void inputClientGroups(String client)
	 {
            PageUtility.scrollThePage(inputField_ClientGroups, driver);
			 PageUtility.enterText(inputField_ClientGroups,client);
    }
	public void button_Save()
	 {
			
			 PageUtility.clickOnElement(button_Save);
     }
	public String addClientTitle() 
	{
		return PageUtility.getTextFromElement(addClientPopUpTitle);
		
	}
   public String mandatoryMessage()
   {
	return fieldMandatoryMessage.getText();
   }
	
	public void downloadExcelReport()
	{
	PageUtility.clickOnElement(excelDownload);
	}
	public void printExcelReport()
	{
		PageUtility.clickOnElement(printClientReport);
	}
	
	
	
	
	
	
}