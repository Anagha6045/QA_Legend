package Utilities;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility
{


//browser commands
public  void loadPage(WebDriver driver,String url)
{
 driver.get(url);
}
public String getTitleOfThePage(WebDriver driver)
{
	return driver.getTitle();
}
public String getUrlOfThePage(WebDriver driver)
{
	return driver.getCurrentUrl();
}
public  void closeTheTab(WebDriver driver)
{
	 driver.close();
}
public void closeAllTabs(WebDriver driver)
{
	 driver.quit();
}


//navigation commands
public  void navigateTo(WebDriver driver,String url)
{
	driver.navigate().to(url);
}
public void navigateBack(WebDriver driver)
{
	driver.navigate().back();
}
public void navigateForward(WebDriver driver)
{
	driver.navigate().forward();
}
public void refreshPage(WebDriver driver)
{
	driver.navigate().refresh();
}


//webElement commands
public void ClearTheField(WebElement element)
{
	element.clear();
}

public void clickOnElement(WebElement element)
{
	element.click();
}
public void enterText(WebElement element, String value)
{
	element.sendKeys(value);
}
public void enterNumber(WebElement element, CharSequence[] value)
{
	element.sendKeys(value);
	
}
public boolean isElementDisplayed(WebElement element)
{
	return element.isDisplayed();
}
public boolean isElementEnabled(WebElement element)
{
	return element.isEnabled();
}
public boolean isElementSelected(WebElement element)
{
	return element.isSelected();
}
public void submitPage(WebElement element)
{
 element.submit();
}

public String getTextFromElement(WebElement element)
{
	return element.getText();
}

public String getAttributeValue(WebElement element,String attributeName)
{
	return element.getAttribute(attributeName);
}
public String getTagnameElement(WebElement element)
{
	return element.getTagName();
}

//dropdown
public void selectDropDownByIndex(WebElement element, int indexValue)
{
	Select obj= new Select(element);
	obj.selectByIndex(indexValue);
}
public void selectDropDownByValue(WebElement element, String Value)
{
	Select obj= new Select(element);
	obj. selectByValue(Value);
}
public void selectDropDownByText(WebElement element, String Value)
{
	Select obj= new Select(element);
	obj. selectByVisibleText(Value);
}


//alerts
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert(). dismiss();
}
public String getAlertMessage(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}
public void getAlertMessage(WebDriver driver, String inputMessage)
{
	driver.switchTo().alert().sendKeys(inputMessage);
}


//Frames
public void selectFrameByNumber(WebDriver driver, int frameNumber)
{
	driver.switchTo().frame(frameNumber);
}
public void selectFrameByNameId(WebDriver driver, String frameNameId)
{
	driver.switchTo().frame(frameNameId);
}
public void selectFrameByWebElement(WebDriver driver, WebElement element)
{
	driver.switchTo().frame(element);
}


//Action class

public void ClickOnElement(WebDriver driver,WebElement element)
{
	Actions actions= new Actions(driver);
	actions.click(element).build().perform();
}
public void ClickAndHoldOnElement(WebDriver driver,WebElement element)
{
	Actions actions= new Actions(driver);
	actions.clickAndHold(element).build().perform();
}
public void LeftClick(WebDriver driver)
{
	Actions actions= new Actions(driver);
	actions.click().build().perform();
}
public void OnclickAndHold(WebDriver driver)
{
	Actions actions= new Actions(driver);
	actions.clickAndHold().build().perform();
}

public void doubleClick(WebDriver driver)
{
	Actions actions= new Actions(driver);
	actions.doubleClick().build().perform();
}
public void doubleClickOnElement(WebDriver driver,WebElement element)
{
	Actions actions= new Actions(driver);
	actions.doubleClick(element).build().perform();
}
public void rightClick(WebDriver driver)
{
	Actions actions= new Actions(driver);
	actions.contextClick().build().perform();
}
public void rightClickOnElement(WebDriver driver,WebElement element)
{
	Actions actions= new Actions(driver);
	actions.contextClick(element).build().perform();
}
public void hoverOverToElement(WebDriver driver, WebElement element) 
{
    Actions actions = new Actions(driver);
    actions.moveToElement(element).build().perform();
}
public void dragAndDropElement(WebDriver driver, WebElement fromLocation,WebElement toLocation) 
{
    Actions actions = new Actions(driver);
    actions.dragAndDrop(fromLocation,toLocation).build().perform();
}
public void releaseElement(WebDriver driver,WebElement element)
{
	Actions actions = new Actions(driver);
	actions.release(element);
	
}
public void clickOnEnterKey(WebDriver driver,WebElement element)
{
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.ENTER).build().perform();
}
public void clickOnPageUp(WebDriver driver)
{
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.ARROW_UP).build().perform();
}
public void clickOnPageDown(WebDriver driver)
{
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.ARROW_DOWN).build().perform();
}
public void clickOn(WebDriver driver,String value)
{
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.valueOf(value)).build().perform();
}


public void singleTabHandling(WebDriver driver,WebElement element)
{
	driver.getWindowHandle();
}


// how to handle window
public void multipleTabHandling(WebDriver driver)
{
	Set<String> handles=driver.getWindowHandles();
	Iterator<String>iterate=handles.iterator();
	
while(iterate.hasNext())
{
	iterate.next();
}
	
}
public void switchTab(WebDriver driver, String handle)
{
	driver.switchTo().window(handle);
}
//select
public void dropDown_SelectByValue(WebElement element, String value)
{
	Select select= new Select(element);
	select.selectByValue(value);
}
public void dropDown_SelectByDisplayedOptions(WebElement element, String value)
{
	Select select= new Select(element);
	select.selectByVisibleText(value);
}


// javascript executor
public void scrollThePage(WebElement element,WebDriver driver)
{
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView(true)", element);
}

public void scrollToBottom(WebDriver driver, int percentScroll) 
{    
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1000)","");
}

    public void clickByJavaScript(WebElement element, WebDriver driver) 
{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", element);
}
    public void enterTextByJavaScript(WebDriver driver,WebElement element, String input)
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(input);
    }
    public String capturePropmptAlert(WebDriver driver)
    {
    	System.out.println(driver.switchTo().alert().getText());
    	return driver.switchTo().alert().getText();	
    }
	public void fileUpload(WebElement element, String path) throws AWTException
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
    
	public void windowHandling(WebDriver driver)
	{
		driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		it.next();
		String childtab = it.next();
		driver.switchTo().window(childtab);
	}
    public void switchWindowToParentTab(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }

    public void robotSearchClient() throws AWTException
    {
    	Robot robot= new Robot();
    	robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void robotToField() throws AWTException
    {
    	Robot robot= new Robot();
    	robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
