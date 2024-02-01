package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegend_LoginPage 
{
WebDriver driver;
@FindBy(name = "email")
WebElement userNamefield;
@FindBy(name ="password")
WebElement passWordField;
@FindBy(tagName = "Button")
WebElement signInButton;



public QALegend_LoginPage(WebDriver driver)
{
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this); 
}





public void enterUserName(String username)
{
	PageUtility.enterText(userNamefield, username);
}
public void enterPassword(String password)
{
	PageUtility.enterText(passWordField, password);
}
public void loginButton()
{
	PageUtility.clickOnElement(signInButton);
}



}
