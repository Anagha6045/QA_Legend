package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.PageUtility;

public class QALegend_LoginPage 
{
WebDriver driver;
@FindBy(name = "email")
WebElement userNamefield;




public void enterUserName(String username)
{
	PageUtility.enterText(userNamefield, username);
}

//password 
//login
//constructor
//java


}
