package PageClasses;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;



public class QALegend_LoginPage 
{
WebDriver driver;
PageUtility page_Utility = new PageUtility();
WaitUtility wait_Utility =new WaitUtility();

@FindBy(name = "email")
WebElement userNamefield;
@FindBy(name ="password")
WebElement passWordField;
@FindBy(tagName = "Button")
WebElement signInButton;

@FindBy(xpath = "//span[@id='email-error']")
WebElement emailError;

@FindBy(xpath = "//h2[text()='Sign in']")
WebElement signInTitle;

public QALegend_LoginPage(WebDriver driver)
{
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this); 
}
public void logInToTheApplication(String username, String password) {
	enterUserName(username);
	enterPassword(password);
	loginButton();
}
public String errorMessage()
{
	return emailError.getText();
}



public void enterUserName(String username)
{
	userNamefield.sendKeys(username);
}
public void enterPassword(String password)
{
	passWordField.sendKeys(password);
}
public void loginButton()
{
    signInButton.click();
}

public void loginScenario(String username, String password)
{
	userNamefield.sendKeys(username);
	passWordField.sendKeys(password);
	signInButton.click();

}
public String getLogInPageTitle()
{
	return page_Utility.getTextFromElement(signInTitle);
}
public boolean displaylogInPageTitle()
{
	return page_Utility.isElementDisplayed(signInTitle);
}

}
