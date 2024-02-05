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

@FindBy(xpath = "//span[text()='Events']")
WebElement EventsButton;

@FindBy(xpath = "//span[text()='Notes']")
WebElement NotesButton;

@FindBy(xpath = "//span[text()='Messages']")
WebElement MessagesButton;

@FindBy(xpath = "//span[text()='Clients']")
WebElement ClientsButton;

@FindBy(xpath = "//span[text()='Projects']")
WebElement ProjectsButton;

@FindBy(xpath = "//span[text()='Estimates']")
WebElement EstimatesButton;

@FindBy(xpath = "//span[text()='Invoices']")
WebElement InvoicesButton;

@FindBy(xpath = "//span[text()='Tickets']")
WebElement TicketsButton;

@FindBy(xpath = "//span[text()='Team members']")
WebElement TeamMemberButton;

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
public void clickOnEvents() 
{
	PageUtility.clickOnElement(EventsButton);
}

public void clickOnClients() 
{
	PageUtility.clickOnElement(ClientsButton);
}
public void clickOnTeamMembers() 
{
	PageUtility.clickOnElement(TeamMemberButton);
}
}
