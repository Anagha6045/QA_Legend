package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegend_HomePage 
{
WebDriver driver;

@FindBy (xpath = "//span[@class='topbar-user-name']")
WebElement userProfileName;

@FindBy(xpath = "//a[text()=' Sign Out']")
WebElement signOutUser;





public QALegend_HomePage(WebDriver driver) 
{
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}





public void logOut()
{
  PageUtility.clickOnElement(userProfileName);
  PageUtility.clickOnElement(signOutUser);
}
public String getUserProfileName()
{
String userName= PageUtility.getTextFromElement(userProfileName);
return userName;
}



}
