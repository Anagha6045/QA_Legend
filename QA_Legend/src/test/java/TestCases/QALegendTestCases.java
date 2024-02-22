package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import AutomationCore.BaseClass;
import PageClasses.QALegend_ClientPage;
import PageClasses.QALegend_EventPage;
import PageClasses.QALegend_HomePage;
import PageClasses.QALegend_LeavePage;
import PageClasses.QALegend_LoginPage;
import PageClasses.QALegend_MessagePage;
import PageClasses.QALegend_NotePage;
import PageClasses.QALegend_ProjectPage;
import PageClasses.QALegend_TicketsPage;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendTestCases extends BaseClass {

	WebDriver driver;
	FileInputStream fis;
	Properties prop;
	QALegend_LoginPage login_Page;
	QALegend_HomePage home_Page;
	QALegend_EventPage event_Page;
	QALegend_ClientPage client_Page;
	QALegend_MessagePage message_page;
	QALegend_TicketsPage ticket_Page;
	QALegend_LeavePage leave_Page;
	QALegend_ProjectPage project_Page;
	QALegend_NotePage note_Page;
	ExcelUtility excel_Utility;
	FakerUtility faker_Utility;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "Browser" })
	public void initialization(String browser) throws Exception {

		driver = browserIntialization(browser);
		fis = new FileInputStream(
				"C:\\Users\\anagh\\git\\QA_Legend\\QA_Legend\\src\\test\\resources\\TestData\\testdata.properties");
		prop = new Properties();
		prop.load(fis);

		driver.get(prop.getProperty("url"));

		login_Page = new QALegend_LoginPage(driver);
		home_Page = new QALegend_HomePage(driver);
		event_Page = new QALegend_EventPage(driver);
		client_Page = new QALegend_ClientPage(driver);
		message_page = new QALegend_MessagePage(driver);
		ticket_Page = new QALegend_TicketsPage(driver);
		leave_Page = new QALegend_LeavePage(driver);
		project_Page = new QALegend_ProjectPage(driver);
		note_Page = new QALegend_NotePage(driver);
		excel_Utility = new ExcelUtility();
		faker_Utility = new FakerUtility();

	}

	@Test( dataProvider = "login_Details" ,groups = { "LoginScenario" })
	public void loginCRMDataProvider(String userName, String passWord) {

		login_Page.enterUserName(userName);
		login_Page.enterPassword(passWord);
		login_Page.loginButton();

		String url = home_Page.getUrl();

		if (url.equalsIgnoreCase(prop.getProperty("url_of_dashboard"))) {
			Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("user_profile_name"));
		} else {
			Assert.assertEquals(login_Page.getLogInPageTitle(), prop.getProperty("login_title"));
		}

	}

	@Test(groups = { "Smoke" })
	public void isEventAdded() throws IOException {
		String event_Title = excel_Utility.getString(1, 0, excelFilePath, "Events")
				+ faker_Utility.randomNumberCreation();

		login_Page.logInToTheApplication(prop.getProperty("username"), prop.getProperty("password"));
		home_Page.clickOnEvents();
		Assert.assertEquals(event_Page.IsAddEventClickable(), true);
		event_Page.clickOnAddEvent();
		Assert.assertEquals(event_Page.addEventTitle(), prop.getProperty("titleEventPopUp"));
		event_Page.inputTitle(event_Title);
		event_Page.inputDescription(excel_Utility.getString(1, 1, excelFilePath, "Events"));
		event_Page.inputStartDate();
		event_Page.selectStartDate();
		event_Page.inputEndDate();
		event_Page.selectEndDate();
		event_Page.inputLocation(excel_Utility.getString(1, 4, excelFilePath, "Events"));
		event_Page.clickOnSave();
		/*
		 * event_Page.clickOnDayButton(); event_Page.clickOnEventGrid();
		 * event_Page.getEventTitle();
		 * 
		 * Assert.assertEquals(event_Page.getEventTitle(), true);
		 */
	}

	@Test(retryAnalyzer = Rerun_FailedTestcases.class)
	public void mandatoryFieldCheckClientCompany() throws IOException, InterruptedException {
		login_Page.logInToTheApplication(prop.getProperty("username"), prop.getProperty("password"));
		home_Page.clickOnClients();
		client_Page.clickOnAddClient();
		client_Page.inputAddress(excel_Utility.getString(1, 1, excelFilePath, "Clients"));
		client_Page.inputCity(excel_Utility.getString(1, 2, excelFilePath, "Clients"));
		client_Page.inputState(excel_Utility.getString(1, 3, excelFilePath, "Clients"));
		client_Page.inputZip(excel_Utility.getNumeric(1, 4, excelFilePath, "Clients"));
		client_Page.inputCountry(excel_Utility.getString(1, 5, excelFilePath, "Clients"));
		client_Page.inputPhone(excel_Utility.getNumeric(1, 6, excelFilePath, "Clients"));
		client_Page.inputWebsite(excel_Utility.getString(1, 7, excelFilePath, "Clients"));
		client_Page.button_Save();
		Assert.assertEquals(client_Page.mandatoryMessage(), prop.getProperty("fieldMandatoryMessage"));

	}

	@Test(groups = { "Smoke" })
	public void downloadClientReport() {
		login_Page.logInToTheApplication(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("user_profile_name"));
		home_Page.clickOnClients();
		client_Page.downloadExcelReport();
		client_Page.printExcelReport();
		Assert.assertEquals(client_Page.noOfColumns(), Integer.valueOf(prop.getProperty("theActualNoOfColumns")));
		client_Page.switchParentTab();

	}

	@Test(groups = { "Smoke" })
	public void sendEmail() throws IOException, AWTException {
		login_Page.logInToTheApplication(prop.getProperty("username"), prop.getProperty("password"));
		String subject = excel_Utility.getString(1, 1, excelFilePath, "Messages")
				+ faker_Utility.randomNumberCreation();
		home_Page.clickOnMessage();
		message_page.clickOnCompose();
		message_page.input_ToRecipient(excel_Utility.getString(1, 0, excelFilePath, "Messages"));
		message_page.input_Subject(subject);
		message_page.input_Message(
				excel_Utility.getString(1, 2, excelFilePath, "Messages") + faker_Utility.randomNumberCreation());
		message_page.attachFile(excel_Utility.getString(1, 3, excelFilePath, "Messages"));
		message_page.sendMessage();
		message_page.clickOnSentItems();
		Assert.assertEquals(message_page.isSubjectVisible(), true);
	}

	@Test(groups = { "Regression" })
	public void verifyNumberOfTickets() {
		login_Page.logInToTheApplication(prop.getProperty("username"), prop.getProperty("password"));
		home_Page.noOfTickets();
		home_Page.clickOnTickets();
		String displayedNoOfTickets = home_Page.noOfTickets();
		ticket_Page.clickOnPrint();
		String NoOfTicketsfFromTickets = ticket_Page.countTheNoOfTickets();
		ticket_Page.switchParentTab();
		Assert.assertEquals(NoOfTicketsfFromTickets, displayedNoOfTickets);

	}

	@Test(groups = { "Smoke" })
	public void isAddedNotesDisplayed() throws IOException {
		login_Page.logInToTheApplication(prop.getProperty("username"), prop.getProperty("password"));
		note_Page.clickOnNotesButton();
		note_Page.clickOnAddNotesButton();
		String expectedNotesTitle = note_Page
				.enterTitleInAddNotesPopUp(excel_Utility.getString(1, 0, excelFilePath, "Notes"));
		note_Page.clickOnSave();
		String actualNotesTitle = note_Page.getActualTitle();

		Assert.assertEquals(actualNotesTitle, expectedNotesTitle);

	}

	@Test(groups = { "Regression" })
	public void userCanApplyForLeave() {
		login_Page.logInToTheApplication(prop.getProperty("username"), prop.getProperty("password"));
		home_Page.clickOnLeave();
		leave_Page.clickOnButtonApplyLeave();
		leave_Page.clickOnDropDown();
		leave_Page.selectCasualLeave();
		leave_Page.durationSingleDay();
		leave_Page.clickOnSingleDateField();
		leave_Page.selectDateOfLeave();
		leave_Page.input_Reason(prop.getProperty("leave_reason") + faker_Utility.randomNumberCreation());

		Assert.assertEquals(leave_Page.isAbleToApplyLeave(), true);
	}

	@Test(groups = { "Smoke" })
	public void isAddedProjectViewable() throws IOException, AWTException, InterruptedException {
		login_Page.logInToTheApplication(prop.getProperty("username"), prop.getProperty("password"));
		home_Page.clickOnProjects();
		home_Page.clickOnAllProjects();
		project_Page.clickOnAddProjectButton();
		String title = excel_Utility.getString(1, 0, excelFilePath, "Projects");
		project_Page.inputTitle(title);
		project_Page.inputDescription(excel_Utility.getString(1, 2, excelFilePath, "Projects"));
		project_Page.input_StartDate();
		project_Page.input_Deadline();
		project_Page.inputPrice(excel_Utility.getNumeric(1, 5, excelFilePath, "Projects"));
		project_Page.saveProject();

		Assert.assertEquals(true, project_Page.addedProjectDisplayed());

	}

	@Test(groups = { "Smoke" })

	public void canUseraddTickets() throws IOException {

		login_Page.logInToTheApplication(prop.getProperty("username"), prop.getProperty("password"));

		home_Page.noOfTickets();
		home_Page.clickOnTickets();

		ticket_Page.input_AddTicket();
		ticket_Page.input_Title(excel_Utility.getString(1, 0, excelFilePath, "Tickets"));
		ticket_Page.inputClient();
		ticket_Page.input_Description(excel_Utility.getString(1, 3, excelFilePath, "Tickets"));
		ticket_Page.clickOnSave();
		ticket_Page.clickOnCancel();
		ticket_Page.clickOnFirstTicket();

		Assert.assertEquals(true, ticket_Page.visibilityActionButton());
		Assert.assertEquals(true, ticket_Page.enabledActionButton());

	}

	@DataProvider(name = "login_Details")
	public Object[][] testData() throws IOException {
		Object[][] login_data = new Object[3][2];

		login_data[0][0] = excel_Utility.getString(1, 0, excelFilePath, "LoginData");
		login_data[0][1] = excel_Utility.getNumeric(1, 1, excelFilePath, "LoginData");
		login_data[1][0] = excel_Utility.getString(2, 0, excelFilePath, "LoginData");
		login_data[1][1] = excel_Utility.getNumeric(2, 1, excelFilePath, "LoginData");
		login_data[2][0] = excel_Utility.getString(3, 0, excelFilePath, "LoginData");
		login_data[2][1] = excel_Utility.getNumeric(3, 1, excelFilePath, "LoginData");

		return login_data;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}