package TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QALegend_HomePage;
import PageClasses.QALegend_LoginPage;
import dev.failsafe.internal.util.Assert;

public class QALegendTestCases extends BaseClass 
{
	public WebDriver driver;
	FileInputStream fis;
	Properties prop;
	QALegend_LoginPage login_Page; 
	QALegend_HomePage home_Page;
	
	
	@BeforeMethod
	@Parameters({"Browser"})
	public void initialization(String browser) throws Exception
	{
    driver = browserIntialization(browser);
    
    fis = new  FileInputStream("C:\\Users\\anagh\\git\\QA_Legend\\QA_Legend\\src\\main\\java\\TestData\\testdata.properties");
    prop = new Properties();
    prop.load(fis);
    driver.get(prop.getProperty("url"));
    
    login_Page= new QALegend_LoginPage(driver);
    home_Page = new QALegend_HomePage(driver);
    
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
	

}
