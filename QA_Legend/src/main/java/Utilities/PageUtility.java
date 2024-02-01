package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility
{

public static void clickOnElement(WebElement element)
{
	element.click();
}
public static void enterText(WebElement element, String value)
{
	element.sendKeys(value);
}
public static String getTextFromElement(WebElement element)
{
	return element.getText();
}
public static void clearText(WebElement element)
{
	element.clear();
}
public static void navigateBack(WebDriver driver)
{
	driver.navigate().back();
}
public static String getAttributeValue(WebElement element,String attributeName)
{
	return element.getAttribute(attributeName);
}
public static void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

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
public static void c(WebDriver driver)
{
	Actions actions = new Actions(driver);
	actions.
	
}
public static void scrollThePage(WebElement element,WebDriver driver)
{
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView(true)", element);
}

public static void scrollToBottom(WebDriver driver, int percentScroll) 
{    
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,percentScroll)");
}

    public static void clickByJavaScript(WebElement element, WebDriver driver) 
{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", element);
}

public static void selectDropdown(WebElement element, String visibleText) {
	
	Select staticDropdown = new Select(element);
	staticDropdown.selectByVisibleText(visibleText);
	
}

 

}
