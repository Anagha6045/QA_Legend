package PageClasses;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_MessagePage
{
	WebDriver driver;
	PageUtility page_Utility = new PageUtility();
	WaitUtility wait_Utility =new WaitUtility();
	
	@FindBy(xpath = "//a[@title='Send message']")
	WebElement button_Compose;

	@FindBy(xpath = "//a[text()='Inbox']")
	WebElement button_Inbox;
	
	@FindBy(xpath = "//a[text()='Sent items']")
	WebElement button_SentItems;
	
	@FindBy(xpath="//label[@for='to_user_id']//following::b")
	WebElement inputField_ToDropDown;

	
	@FindBy(name = "to_user_id")
	WebElement inputField_To;

	
	 @FindBy(xpath = "//span[@id='select2-chosen-3']") 
	 WebElement field_To;
	 
	@FindBy(xpath = "//select[@name='to_user_id']")
	WebElement inputFieldToAddress;
	
	@FindBy(id="s2id_autogen46_search")
	WebElement inputField_ToSearch;
	
	@FindBy(id="subject")
	WebElement inputField_Subject;
	
	@FindBy(id="message")
	WebElement inputField_Message;
	 
	@FindBy(xpath="//button[text()=' Upload File']")
	WebElement buttonUpload;
	
    @FindBy(xpath = "//button[text()=' Send']")
    WebElement buttonSend;
    
    @FindBy(id="search-messages")
    WebElement searchSentItems;
    
    @FindBy(id="select2-chosen-100")
    WebElement toField;
    
    @FindBy(xpath = "(//table//tbody//tr[@class='odd'])[1]")
    WebElement selectFirstRecipient;
	
	public QALegend_MessagePage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCompose()
	{
		button_Compose.click();
	}
	
	
	public void clickOnInbox()
	{
		button_Inbox.click();
	}
	
	public void input_ToField(String recipient)
	{
		inputField_To.click();
		inputField_ToSearch.sendKeys(recipient);
		page_Utility.clickOnEnterKey(driver, inputField_ToSearch);
	}

	
	public void input_Subject(String subject)
	{
		inputField_Subject.sendKeys(subject);
	}
	
	public void input_Message(String message)
	{
		inputField_Message.sendKeys(message);
	}
	public void attachFile(String attachment) throws AWTException
	{ 
		
		page_Utility.fileUpload(buttonUpload, attachment);
	}
	public void sendMessage()
	{
		buttonSend.click();
	}
	public void input_ToRecipient(String recipient) throws AWTException
	{
		page_Utility.clickByJavaScript(inputField_ToDropDown,driver);
		wait_Utility.waitFowaitForAnElementToBeVisible(driver, inputField_ToDropDown);
		page_Utility.robotToField();

	}
	public void clickOnSentItems()
	{
		page_Utility.clickByJavaScript(button_SentItems,driver);
	}
	
	  public void toField()
	  {
		  page_Utility.hoverOverToElement(driver, toField);
		  page_Utility.clickOnEnterKey(driver, toField);
		  page_Utility.dropDown_SelectByValue(inputFieldToAddress,"33");

	  }

	public boolean isSubjectVisible()
	{
		
		return page_Utility.isElementDisplayed(selectFirstRecipient);
	}
	 
}
