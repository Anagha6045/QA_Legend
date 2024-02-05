package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.*;

import com.aventstack.extentreports.model.Log;

import AutomationCore.BaseClass;
import PageClasses.QALegend_ClientPage;
import PageClasses.QALegend_EventPage;
import PageClasses.QALegend_HomePage;
import PageClasses.QALegend_LoginPage;
import Utilities.DateUtility;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegendTestCases extends BaseClass 
{
	public WebDriver driver;
	FileInputStream fis;
	Properties prop;
	QALegend_LoginPage login_Page; 
	QALegend_HomePage home_Page;
	QALegend_EventPage event_Page;
	QALegend_ClientPage client_Page;
	
	SoftAssert softassertion;
	
	
	@BeforeMethod
	@Parameters({"Browser"})
	public void initialization(String browser) throws Exception
	{
    driver = browserIntialization(browser);
    driver.manage().window().maximize();
    fis = new  FileInputStream("C:\\Users\\anagh\\git\\QA_Legend\\QA_Legend\\src\\main\\java\\TestData\\testdata.properties");
    prop = new Properties();
    prop.load(fis);
    softassertion =new SoftAssert();
    
    driver.get(prop.getProperty("url"));
    
    
    login_Page= new QALegend_LoginPage(driver);
    home_Page = new QALegend_HomePage(driver);
    event_Page = new QALegend_EventPage(driver);
    client_Page= new QALegend_ClientPage(driver);
  
    
    login_Page.enterUserName(prop.getProperty("username"));
	login_Page.enterPassword(prop.getProperty("password"));
	login_Page.loginButton();
	}

	@Test
	public void loginCRM()
	{
		home_Page.logOut();
		login_Page.enterUserName(prop.getProperty("username"));
		login_Page.enterPassword(prop.getProperty("password"));
		login_Page.loginButton();
		org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("user_profile_name"));
	}
	@Test
	public void addEvent() throws IOException 
	{
		home_Page.logOut();
		login_Page.enterUserName(prop.getProperty("username"));
		login_Page.enterPassword(prop.getProperty("password"));
		login_Page.loginButton();
		Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("user_profile_name"));
		
		home_Page.clickOnEvents();
		Assert.assertEquals(event_Page.IsAddEventClickable(), true);
		
		event_Page.clickOnAddEvent();
		Assert.assertEquals(event_Page.addEventTitle(), prop.getProperty("titleEventPopUp"));
		
		String event_Title=ExcelUtility.getString(1, 0, excelFilePath, "Events")+FakerUtility.randomNumberCreation();
		event_Page.inputTitle(event_Title);
		event_Page.inputDescription(ExcelUtility.getString(1, 1, excelFilePath, "Events"));
		event_Page.inputStartDate();
		event_Page.selectStartDate();
		
		event_Page.inputEndDate();
		event_Page.selectEndDate();
		
		event_Page.inputLocation(ExcelUtility.getString(1, 4, excelFilePath, "Events"));
		//event_Page.inputLabel(ExcelUtility.getString(1, 5, excelFilePath, "Events"));
		//event_Page.inputClientField(ExcelUtility.getString(1, 6, excelFilePath, "Events"));
	    //event_Page.searchForClient(ExcelUtility.getString(1, 6, excelFilePath, "Events"));
		//event_Page.selectThemeColor();
		event_Page.clickOnSave();
		//assertion
		
	}
	@Test
	public void addClient() throws IOException, InterruptedException
	{
		home_Page.logOut();
		login_Page.enterUserName(prop.getProperty("username"));
		login_Page.enterPassword(prop.getProperty("password"));
		login_Page.loginButton();
		Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("user_profile_name"));
		home_Page.clickOnClients();
		
		client_Page.clickOnAddClient();
		client_Page.inputAddress(ExcelUtility.getString(1, 1, excelFilePath, "Clients"));
		client_Page.inputCity(ExcelUtility.getString(1, 2, excelFilePath, "Clients"));
		client_Page.inputState(ExcelUtility.getString(1, 3, excelFilePath, "Clients"));
        client_Page.inputZip(ExcelUtility.getNumeric(1, 4, excelFilePath, "Clients"));
	    client_Page.inputCountry(ExcelUtility.getString(1, 5, excelFilePath, "Clients"));
	    client_Page.inputPhone(ExcelUtility.getNumeric(1, 6, excelFilePath, "Clients"));
	    client_Page.inputWebsite(ExcelUtility.getString(1, 7, excelFilePath, "Clients"));
	    client_Page.inputVAT(ExcelUtility.getNumeric(1, 8, excelFilePath, "Clients"));
	    //client_Page.inputClientGroups(ExcelUtility.getString(1, 9, excelFilePath, "Clients"));
	    client_Page.button_Save();
	    Assert.assertEquals(client_Page.mandatoryMessage(), prop.getProperty("fieldMandatoryMessage"));
	    System.out.println(client_Page.mandatoryMessage());
	    client_Page.inputCompanyName(ExcelUtility.getString(1, 0, excelFilePath, "Clients"));
	    Thread.sleep(5000);
	    client_Page.button_Save();
	}
	@Test
	public void downloadClientReport()
	{
		home_Page.logOut();
		login_Page.enterUserName(prop.getProperty("username"));
		login_Page.enterPassword(prop.getProperty("password"));
		login_Page.loginButton();
		Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("user_profile_name"));
		home_Page.clickOnClients();
		
		client_Page.downloadExcelReport();
		client_Page.printExcelReport();
	}
}


