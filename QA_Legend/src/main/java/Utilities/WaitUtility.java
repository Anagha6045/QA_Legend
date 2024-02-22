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
	
	public void waitForAnElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitFowaitForAnElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
  public void waitForAFrame(WebDriver driver,WebElement element)
  { 
	  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	  
  }
  public void waitTillAlertDisplays(WebDriver driver, Duration timeinseconds)
  {
  	WebDriverWait wait= new WebDriverWait(driver, timeinseconds);
  	wait.until(ExpectedConditions.alertIsPresent());
  }
 
  public void waitTillElementSelected(WebDriver driver,WebElement element, Duration timeinseconds)
  {
  	WebDriverWait wait= new WebDriverWait(driver, timeinseconds);
  	wait.until(ExpectedConditions.elementToBeSelected(element));
  }
  public void waitTillvisibilityOfElementLocated(WebDriver driver,By Byelement, Duration timeinseconds)
  {
  	WebDriverWait wait= new WebDriverWait(driver, timeinseconds);
  wait.until(ExpectedConditions.visibilityOfElementLocated(Byelement));
  }
}
