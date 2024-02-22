package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_HomePage 
{
WebDriver driver;
PageUtility page_Utility = new PageUtility();
WaitUtility wait_Utility =new WaitUtility();

@FindBy (xpath = "//span[@class='topbar-user-name']")
WebElement userProfileName;

@FindBy(xpath = "//a[text()=' Sign Out']")
WebElement signOutUser;

@FindBy(xpath = "//span[text()='Events']")
WebElement eventsButton;

@FindBy(xpath = "//span[text()='Notes']")
WebElement notesButton;

@FindBy(xpath = "//span[text()='Messages']")
WebElement messagesButton;

@FindBy(xpath = "//span[text()='Clients']")
WebElement ClientsButton;

@FindBy(xpath = "//span[text()='Projects']")
WebElement projectsButton;

@FindBy(xpath="//span[text()='All Projects']")
WebElement allProjectsButton;

@FindBy(xpath = "//span[text()='Estimates']")
WebElement estimatesButton;

@FindBy(xpath = "//span[text()='Invoices']")
WebElement invoicesButton;

@FindBy(xpath = "//span[text()='Tickets']")
WebElement ticketsButton;

@FindBy(xpath = "//span[text()='Team members']")
WebElement teamMemberButton;

@FindBy (xpath = "//span[text()='Tickets']//following-sibling::span")
WebElement noOfTicketsDisplayed;

@FindBy(xpath = "//div[@id='ticket-status-flotchart']")
WebElement locateTicketsPieChart;

@FindBy(xpath ="//span[text()='Leave']")
WebElement leaveButton;


public QALegend_HomePage(WebDriver driver) 
{
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}





public void logOut()
{
  userProfileName.click();
  signOutUser.click();
}
public String signInUrl()
{
	return page_Utility.getUrlOfThePage(driver);
}
public String getUserProfileName()
{
String userName= page_Utility.getTextFromElement(userProfileName);
return userName;
}
public void clickOnEvents() 
{
 eventsButton.click();
}

public void clickOnClients() 
{
 ClientsButton.click();
}
public void clickOnMessage()
{
	messagesButton.click();
}
public void clickOnProjects()
{
 projectsButton.click();
}
public void clickOnAllProjects()
{
	allProjectsButton.click();
}
public void clickOnTeamMembers() 
{
	teamMemberButton.click();
}

public String noOfTickets()
{
	return noOfTicketsDisplayed.getText();
}
public void clickOnTickets()
{
	ticketsButton.click();
}
public void plotTicketsPieChart()
{
	page_Utility.scrollThePage(locateTicketsPieChart, driver);
}
public void clickOnLeave()
{
	leaveButton.click();
}
public String getUrl()
{
	return page_Utility.getUrlOfThePage(driver);
}
}
