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

import com.google.common.io.Files;


public class BaseClass
{
   public WebDriver driver;
	public String excelFilePath="//src//main//java//TestData//TestData_Excel.xlsx";
	
	
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


	  
	  
	  
	  public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException 
	  { 
         TakesScreenshot ts= (TakesScreenshot)driver;
         File source=ts.getScreenshotAs(OutputType.FILE);
         String destinattionFile=System.getProperty("user.dir")+"\\test-output\\"+testCaseName+".png";
         Files.copy(source, new File(destinattionFile));
         return destinattionFile;
		
	  }
		
		 
} 
