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
	PageUtility.clickOnElement(notesButton);
}

public void clickOnAddNotesButton() 
{
	PageUtility.clickOnElement(addNotesButton);
}
public String enterTitleInAddNotesPopUp(String textTitle) throws IOException 
{
	 PageUtility.enterText(enterTitle,textTitle);
	 return textTitle;
	
}
public void clickOnSave()
{
	PageUtility.clickOnElement(saveButton);
}

public String getActualTitle()
{
	PageUtility.refreshPage(driver);
	WaitUtility.waitForAnElementToBeClickable(driver, actualTitle);
	return PageUtility.getTextFromElement(actualTitle);
}

}

