package TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import AutomationCore.BaseClass;

public class QALegendTestCases extends BaseClass 
{
	public WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	
	@BeforeMethod
	@Parameters({"Browser"})
	public void initialization(String browser) throws Exception
	{
    driver = browserIntialization(browser);
    
    fis = new  FileInputStream("C:\\Users\\anagh\\QA_Legend\\src\\main\\java\\TestData\\testdata.properties");
    prop = new Properties();
    prop.load(fis);
    driver.get(prop.getProperty("url"));
    
	}

	public void loginCRM()
	{
		
	}
	

}
