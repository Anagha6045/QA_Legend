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
	PageUtility.clickOnElement(eventsButton);
}

public void clickOnClients() 
{
	PageUtility.clickOnElement(ClientsButton);
}
public void clickOnMessage()
{
	PageUtility.clickOnElement(messagesButton);
}
public void clickOnProjects()
{
	PageUtility.clickOnElement(projectsButton);
}
public void clickOnAllProjects()
{
	PageUtility.clickOnElement(allProjectsButton);
}
public void clickOnTeamMembers() 
{
	PageUtility.clickOnElement(teamMemberButton);
}

public String noOfTickets()
{
	return noOfTicketsDisplayed.getText();
}
public void clickOnTickets()
{
	PageUtility.clickOnElement(ticketsButton);
}
public void plotTicketsPieChart()
{
	PageUtility.scrollThePage(locateTicketsPieChart, driver);
}
public void clickOnLeave()
{
	PageUtility.clickOnElement(leaveButton);
}
}
