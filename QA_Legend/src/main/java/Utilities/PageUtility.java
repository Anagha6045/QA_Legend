package Utilities;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility
{


//browser commands
public static void loadPage(WebDriver driver,String url)
{
 driver.get(url);
}
public static String getTitleOfThePage(WebDriver driver)
{
	return driver.getTitle();
}
public static String getUrlOfThePage(WebDriver driver)
{
	return driver.getCurrentUrl();
}
public static void closeTheTab(WebDriver driver)
{
	 driver.close();
}
public static void closeAllTabs(WebDriver driver)
{
	 driver.quit();
}


//navigation commands
public static void navigateTo(WebDriver driver,String url)
{
	driver.navigate().to(url);
}
public static void navigateBack(WebDriver driver)
{
	driver.navigate().back();
}
public static void navigateForward(WebDriver driver)
{
	driver.navigate().forward();
}
public static void refreshPage(WebDriver driver)
{
	driver.navigate().refresh();
}


//webElement commands
public static void ClearTheField(WebElement element)
{
	element.clear();
}

public static void clickOnElement(WebElement element)
{
	element.click();
}
public static void enterText(WebElement element, String value)
{
	element.sendKeys(value);
}
public static void enterNumber(WebElement element, CharSequence[] value)
{
	element.sendKeys(value);
	
}
public static boolean isElementDisplayed(WebElement element)
{
	return element.isDisplayed();
}
public static boolean isElementEnabled(WebElement element)
{
	return element.isEnabled();
}
public static boolean isElementSelected(WebElement element)
{
	return element.isSelected();
}
public static void submitPage(WebElement element)
{
 element.submit();
}

public static String getTextFromElement(WebElement element)
{
	return element.getText();
}

public static String getAttributeValue(WebElement element,String attributeName)
{
	return element.getAttribute(attributeName);
}
public static String getTagnameElement(WebElement element)
{
	return element.getTagName();
}

//dropdown
public static void selectDropDownByIndex(WebElement element, int indexValue)
{
	Select obj= new Select(element);
	obj.selectByIndex(indexValue);
}
public static void selectDropDownByValue(WebElement element, String Value)
{
	Select obj= new Select(element);
	obj. selectByValue(Value);
}
public static void selectDropDownByText(WebElement element, String Value)
{
	Select obj= new Select(element);
	obj. selectByVisibleText(Value);
}


//alerts
public static void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public static void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert(). dismiss();
}
public static String getAlertMessage(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}
public static void getAlertMessage(WebDriver driver, String inputMessage)
{
	driver.switchTo().alert().sendKeys(inputMessage);
}


//Frames
public static void selectFrameByNumber(WebDriver driver, int frameNumber)
{
	driver.switchTo().frame(frameNumber);
}
public static void selectFrameByNameId(WebDriver driver, String frameNameId)
{
	driver.switchTo().frame(frameNameId);
}
public static void selectFrameByWebElement(WebDriver driver, WebElement element)
{
	driver.switchTo().frame(element);
}


//Action class

public static void ClickOnElement(WebDriver driver,WebElement element)
{
	Actions actions= new Actions(driver);
	actions.click(element).build().perform();
}
public static void ClickAndHoldOnElement(WebDriver driver,WebElement element)
{
	Actions actions= new Actions(driver);
	actions.clickAndHold(element).build().perform();
}
public static void LeftClick(WebDriver driver)
{
	Actions actions= new Actions(driver);
	actions.click().build().perform();
}
public static void OnclickAndHold(WebDriver driver)
{
	Actions actions= new Actions(driver);
	actions.clickAndHold().build().perform();
}

public static void doubleClick(WebDriver driver)
{
	Actions actions= new Actions(driver);
	actions.doubleClick().build().perform();
}
public static void doubleClickOnElement(WebDriver driver,WebElement element)
{
	Actions actions= new Actions(driver);
	actions.doubleClick(element).build().perform();
}
public static void rightClick(WebDriver driver)
{
	Actions actions= new Actions(driver);
	actions.contextClick().build().perform();
}
public static void rightClickOnElement(WebDriver driver,WebElement element)
{
	Actions actions= new Actions(driver);
	actions.contextClick(element).build().perform();
}
public static void moveToElement(WebDriver driver, WebElement element) 
{
    Actions actions = new Actions(driver);
    actions.moveToElement(element).build().perform();
}
public static void dragAndDropElement(WebDriver driver, WebElement fromLocation,WebElement toLocation) 
{
    Actions actions = new Actions(driver);
    actions.dragAndDrop(fromLocation,toLocation).build().perform();
}
public static void releaseElement(WebDriver driver,WebElement element)
{
	Actions actions = new Actions(driver);
	actions.release(element);
	
}
public static void clickOnEnterKey(WebDriver driver,WebElement element)
{
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.ENTER).build().perform();
}
public static void clickOnPageUp(WebDriver driver)
{
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.ARROW_UP).build().perform();
}
public static void clickOnPageDown(WebDriver driver)
{
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.ARROW_DOWN).build().perform();
}
public static void clickOn(WebDriver driver,String value)
{
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.valueOf(value)).build().perform();
}

public static void singleTabHandling(WebDriver driver,WebElement element)
{
	driver.getWindowHandle();
}


// how to handle window
public static void multipleTabHandling(WebDriver driver,WebElement element)
{
	Set<String> handles=driver.getWindowHandles();
	Iterator<String>iterate=handles.iterator();
	
while(iterate.hasNext())
{
	iterate.next();
}
	
}
public static void switchTab(WebDriver driver, String handle)
{
	driver.switchTo().window(handle);
}


// javascript executor
public static void scrollThePage(WebElement element,WebDriver driver)
{
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView(true)", element);
}

public static void scrollToBottom(WebDriver driver, int percentScroll) 
{    
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1000)","");
}

    public static void clickByJavaScript(WebElement element, WebDriver driver) 
{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", element);
}
    public static void enterTextByJavaScript(WebDriver driver,WebElement element, String input)
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(input);
    }
    public static String capturePropmptAlert(WebDriver driver)
    {
    	System.out.println(driver.switchTo().alert().getText());
    	return driver.switchTo().alert().getText();	
    }
	public static void fileUpload(WebElement element, String path) throws AWTException
	{
		StringSelection s=new StringSelection(path);
		 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		element.click();
		 
		Robot robot= new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
    
	public static void windowHandling(WebDriver driver)
	{
		driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		it.next();
		String childtab = it.next();
		driver.switchTo().window(childtab);
	}
    public static void switchWindowToParentTab(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }

}
