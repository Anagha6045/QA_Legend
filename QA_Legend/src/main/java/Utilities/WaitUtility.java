package Utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	
	public static void waitForAnElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitFowaitForAnElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
  public static void waitForAFrame(WebDriver driver,WebElement element)
  { 
	  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	  
  }
  public static void waitTillAlertDisplays(WebDriver driver, Duration timeinseconds)
  {
  	WebDriverWait wait= new WebDriverWait(driver, timeinseconds);
  	wait.until(ExpectedConditions.alertIsPresent());
  }
 
  public static void waitTillElementSelected(WebDriver driver,WebElement element, Duration timeinseconds)
  {
  	WebDriverWait wait= new WebDriverWait(driver, timeinseconds);
  	wait.until(ExpectedConditions.elementToBeSelected(element));
  }
  public static void waitTillvisibilityOfElementLocated(WebDriver driver,By Byelement, Duration timeinseconds)
  {
  	WebDriverWait wait= new WebDriverWait(driver, timeinseconds);
  wait.until(ExpectedConditions.visibilityOfElementLocated(Byelement));
  }
}
