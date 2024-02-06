package PageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegend_TicketsPage 
{
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Print']")
	WebElement buttonPrint;
	
	@FindBy(xpath = "//table")
	WebElement ticketsTable;
	
	@FindBy(xpath = "//tbody//child::tr")
	List<WebElement> noOfTickets;
	
	
	
	
	public QALegend_TicketsPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnPrint()
	{
		PageUtility.clickOnElement(buttonPrint);
	}
	
	public String countTheNoOfTickets()
	{
		PageUtility.windowHandling(driver);
		//List<Integer> rowSizes = new ArrayList<>();
		List<WebElement> rows = noOfTickets; // Assuming rows are within a <tbody>
		System.out.println(rows.size());// assertion
		
		  return String.valueOf(rows.size()-1);
		
		
	}
	public void switchParentTab()
	{
		PageUtility.switchWindowToParentTab(driver);
	}
    
}
