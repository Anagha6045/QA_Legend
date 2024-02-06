package PageClasses;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;

public class QALegend_MessagePage
{
	WebDriver driver;
	
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

	@FindBy(xpath = "//*[@id=\"select2-result-label-18\"]/text()")
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
    
    @FindBy(xpath = "//*[@id=\"s2id_autogen24_search\"]")
    WebElement selectFirstRecipient;
	
	public QALegend_MessagePage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCompose()
	{
		PageUtility.clickOnElement(button_Compose);
	}
	
	
	public void clickOnInbox()
	{
		PageUtility.clickOnElement(button_Inbox);
	}
	
	public void input_ToField(String recipient)
	{
		PageUtility.clickOnElement(inputField_To);
		PageUtility.enterText( inputField_ToSearch, recipient);
	    PageUtility.clickOnEnterKey(driver, inputField_ToSearch);
	}

	
	public void input_Subject(String subject)
	{
		PageUtility.enterText(inputField_Subject, subject);
	}
	
	public void input_Message(String message)
	{
		PageUtility.enterText(inputField_Message, message);
	}
	public void attachFile(String attachment) throws AWTException
	{ 
		
		PageUtility.fileUpload(buttonUpload, attachment);
	}
	public void sendMessage()
	{
		PageUtility.clickOnElement(buttonSend);
		System.out.println(selectFirstRecipient.getText());
	}
	public void input_ToRecipient(String recipient)
	{
		PageUtility.clickOnElement(inputField_ToDropDown);
		PageUtility.enterText(inputFieldToAddress,recipient);
		//Select select =new Select(inputField_To);
		//select.selectByVisibleText(recipient);
		//select.selectByValue("15");
		
		
		
		
	}
	public void clickOnSentItems()
	{
		PageUtility.clickOnElement(button_SentItems);
	}
	public void searchForRecipient( )
	{
		PageUtility.enterText(searchSentItems);
	}
}
