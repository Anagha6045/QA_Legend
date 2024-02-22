package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;


public class QALegend_NotePage 
{
	
	WebDriver driver;
	PageUtility page_Utility = new PageUtility();
	WaitUtility wait_Utility =new WaitUtility();
	
@FindBy(xpath = "//span[text()='Notes']")
WebElement notesButton;
@FindBy(xpath = "//a[@class='btn btn-default']")
WebElement addNotesButton;
@FindBy(xpath = "//input[@id='title']")
WebElement enterTitle;
@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement saveButton;
@FindBy (xpath = "(//a[@title='Note'])[1]")
WebElement actualTitle;




public QALegend_NotePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver, this);
}



public void clickOnNotesButton()
{
	notesButton.click();
}

public void clickOnAddNotesButton() 
{
	addNotesButton.click();
}
public String enterTitleInAddNotesPopUp(String textTitle) throws IOException 
{
	 enterTitle.sendKeys(textTitle);
	 return textTitle;
	
}
public void clickOnSave()
{
	saveButton.click();
}

public String getActualTitle()
{
	page_Utility.refreshPage(driver);
	wait_Utility.waitForAnElementToBeClickable(driver, actualTitle);
	return page_Utility.getTextFromElement(actualTitle);
}

}

