package PageClasses;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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

public String errorMessage()
{
	return emailError.getText();
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

public void loginScenario(String username, String password)
{
	PageUtility.enterText(userNamefield, username);
	PageUtility.enterText(passWordField, password);
	PageUtility.clickOnElement(signInButton);

}
public String getLogInPageTitle()
{
	return PageUtility.getTextFromElement(signInTitle);
}
public boolean displaylogInPageTitle()
{
	return PageUtility.isElementDisplayed(signInTitle);
}

}
