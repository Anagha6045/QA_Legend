package AutomationCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import PageClasses.QALegend_ClientPage;
import PageClasses.QALegend_EventPage;
import PageClasses.QALegend_HomePage;
import PageClasses.QALegend_LeavePage;
import PageClasses.QALegend_LoginPage;
import PageClasses.QALegend_MessagePage;
import PageClasses.QALegend_NotePage;
import PageClasses.QALegend_ProjectPage;
import PageClasses.QALegend_TicketsPage;
import Utilities.WaitUtility;

public class BaseClass
{
	protected WebDriver driver;
	public String excelFilePath="//src//main//java//TestData//TestData_Excel.xlsx";
	FileInputStream fis;
	public Properties prop;
	public QALegend_LoginPage login_Page; 
	public QALegend_HomePage home_Page;
	public QALegend_EventPage event_Page;
	public QALegend_ClientPage client_Page;
	public QALegend_MessagePage message_page;
	public QALegend_TicketsPage ticket_Page;
	public QALegend_LeavePage leave_Page;
	public QALegend_ProjectPage project_Page;
	public QALegend_NotePage note_Page;
	
	SoftAssert softassertion;
	
	public WebDriver browserIntialization(String browserName) throws Exception
	{
		if (browserName.equalsIgnoreCase("Chrome"))
		{
	     driver = new ChromeDriver();//chrome

		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();//edge
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();//firefox
		}
		else
		{
			throw new Exception("Invalid Name Exception");
		}
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}


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
	    event_Page = new QALegend_EventPage(driver);
	    client_Page= new QALegend_ClientPage(driver);
	    message_page= new QALegend_MessagePage(driver);
	    ticket_Page =new QALegend_TicketsPage(driver);
	    leave_Page= new QALegend_LeavePage(driver);
	    project_Page =new QALegend_ProjectPage(driver);
	    note_Page= new QALegend_NotePage(driver);
	  
	    
	    login_Page.enterUserName(prop.getProperty("username"));
		login_Page.enterPassword(prop.getProperty("password"));
		login_Page.loginButton();
		}
	  
	  
	  public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException 
	  { 
         TakesScreenshot ts= (TakesScreenshot)driver;
         File source=ts.getScreenshotAs(OutputType.FILE);
         String destinattionFile=System.getProperty("user.dir")+"\\+test-output\\"+testCaseName+".png";
         Files.copy(source, new File(destinattionFile));
         return destinattionFile;
		
	  }
		
		  @AfterMethod 
		  public void tearDown()
		  {
			  driver.quit();
		  }
		 
} 
