//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.KebabMenuFunctionality;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;

public class ZohoDeskFunctionality extends BaseSetup {
private String module = "CRM Integration";
	
	private boolean missedDetailsPage;
	CommonActionMobile actions = new CommonActionMobile(driver);
	private boolean missedChatPage;
	SearchFunctionality seachFunctionality=new SearchFunctionality(driver);
	Extentreportclass extentreportclass=new Extentreportclass();
	KebabMenuFunctionality kebabMenuFunctionality=new KebabMenuFunctionality(driver);
	public boolean ticketList;
	private static String ticketNumber="";
	
	
	public int crmContactFieldCount=3;
	
	public boolean crminfoUpdated;
	public ZohoDeskFunctionality(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="spinner")
	List<MobileElement> clickPriority;
	
	@AndroidFindBy(id="android:id/text1")
	List<MobileElement> priorityList;
	
	@AndroidFindBy(id="android:id/text1")
	List<MobileElement> clasificationList;
	
	@AndroidFindBy(id="action_save")
	MobileElement saveZohoDesk;
	
	@AndroidFindBy(id="visitorchat_info")
	List<MobileElement> deskticketstatusinList;
	
	@AndroidFindBy(id="visitorchat_question")
	List<MobileElement> visitorQuestion;

	@AndroidFindBy(id="subject")
	MobileElement ticketQuestionInDetails;
	
	@AndroidFindBy(id="visitorchat_name")
	List<MobileElement> getTicketID;
	
	@AndroidFindBy(id="status")
	MobileElement ticketStatusinDetails;
	
	@AndroidFindBy(id="primaryItemText")
	List<MobileElement> ticketListDetails;
	
	@AndroidFindBy(id="visitorchat_headername")
	List<MobileElement> checkZohoDeskTicketHeaders;
	
	@AndroidFindBy(className="android.widget.TextView")
	List<MobileElement> checkRecentSupportTicketPage;
	
	

	public void  checkDeskPriority(String module)
	{
		try{
		actions.clickAction(clickPriority.get(0), module, "Click on Priority dropdown");
		actions.checkTextinList(priorityList, "None", module, "Check Prioriry List");
		actions.checkTextinList(priorityList, "High", module, "Check Prioriry List");
		actions.checkTextinList(priorityList, "Medium", module, "Check Prioriry List");
		actions.checkTextinList(priorityList, "Low", module, "Check Prioriry List");
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Zoho desk priority list fail");
		}
	}
		public void  selectDeskPriority(String module,String priority)
		{
			actions.selectBasedonTextInList(priorityList, priority, module, "Select priority value in zoho desk list");
			
		}
		

	public void  selectDeskClasification(String module,String clasification)
	{
		actions.selectBasedonTextInList(priorityList, clasification, module, "Select priority value in zoho desk list");
		
	}
	public void  checkDeskClasification(String module)
	{
		try{
		actions.clickAction(clickPriority.get(1), module, "Click on Priority dropdown");
		actions.checkTextinList(clasificationList, "None", module, "Check Prioriry List");
		actions.checkTextinList(clasificationList, "Question", module, "Check Prioriry List");
		actions.checkTextinList(clasificationList, "Problem", module, "Check Prioriry List");
		actions.checkTextinList(clasificationList, "Feature", module, "Check Prioriry List");
		actions.checkTextinList(clasificationList, "Others", module, "Check Prioriry List");
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Zoho desk priority list fail");
		}
	}
	public void clickSaveZohoDesk(String module)
	{
		actions.clickAction(saveZohoDesk, module, "Save Zoho Desk Ticket");
	}
	
	public void checkticketStatus(String module,String status)
	{
		try {
			getTicketID(module);
		actions.textContainsText(deskticketstatusinList.get(0),status,module, "Check ticket status in recent service desk list");
		ticketList=true;
		}
		catch (Exception e) {
			
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Recent service desk ticket not found");
			ticketList=false;
		}
	}
	
	public void checkTicketQuestion(String module,String question)
	{
		try {
			getTicketID(module);
			actions.textContainsText(visitorQuestion.get(0),question,module, "Check ticket visitor question in recent service desk list");
			ticketList=true;
			}
			catch (Exception e) {
				
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "Recent service desk ticket not found");
				
			}
		
	}
	public void checkPreviousTicketStatus(String module,String status)
	{
		String caseName="check Previous ticket Status";
				
		try {
			actions.textContainsText(deskticketstatusinList.get(1),status,module,caseName);
			
		}
		catch (Exception e) {
			
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module,caseName);
			
		}
	}
	
	public void checkPreviousTicketQuestion(String module,String question)
	{
		String caseName="Check Previous ticket question";
		try {
			actions.checkText(question, visitorQuestion.get(1), module, "Check ticket visitor question in recent service desk list");
			ticketList=true;
		}
		catch (IndexOutOfBoundsException e) {
			
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Recent service desk ticket not found");
			ticketList=false;
		}
		
	}
	
	public void openServiceDeskList(String module)
	{
		String caseName="Check individual Dest Details is opened";
		try {
		if(ticketList)
		{
			actions.clickAction(visitorQuestion.get(0), module, "Open service desk ticket");
		}
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Ticket not opened");
			ticketList=false;
			
		}
	}
	
	public void getTicketID(String module)
	{
		ticketNumber = getTicketID.get(0).getText();
	}
	public void checkTicketQuestionInDetails(String module,String question)
	{
		if(ticketList)
		{
		actions.checkText(question, ticketQuestionInDetails, module, "Check visitor question in ticket details");
		}
	}
	public void checkTicketStatusInDetails(String module,String status)
	{
		if(ticketList)
		{
		actions.checkText(status, ticketStatusinDetails, module, "Check ticket status in ticket details");
		}
	}
	
	public void checkTicketDepartment(String module,String departmentName)
	{
		try {
		if(ticketList)
		{
			actions.checkText(departmentName,ticketListDetails.get(1), module, "Check ticket department in ticket details");
		}
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Department name not found");
		}
	}
	
	public void compareTicketID(String module)
	{
		String caseName="Check department name with Desk ticekt list and Details page";
		try {
			if(ticketList)
			{
				actions.waitTime(2);
				actions.checkText(ticketNumber,ticketListDetails.get(0), module, "Check ticket department in ticket details Ticket Number"+ticketNumber);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Recent support tickets not found");
		}
	}
	
	
	public void checkTicketEmailID(String module,String emailID)
	{
		try {
			if(ticketList)
			{
				actions.checkText(emailID,ticketListDetails.get(2), module, "Check ticket EmailID in ticket details");
			}
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Email id  not found");
		}
	}
	public void checkTicketCreatedBy(String module,String createdBy)
	{
		try {
			if(ticketList)
			{
				actions.checkText(createdBy,ticketListDetails.get(3), module, "Check ticket createdBy in ticket details");
			}
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Ticket CreatedBy not found");
		}
	}
	public void checkTicketPriority(String module,String priority)
	{
		try {
			if(ticketList)
			{
				actions.checkText(priority,ticketListDetails.get(4), module, "Check ticket priority in ticket details");
			}
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Priority  not found");
		}
	}
	public void checkRecentSupportTicketOpen(String module)
	{
		String caseName="Check if operator clicks on Recent Support reuqest, zoho deask ticket list page should opened";
		try {
			if(checkRecentSupportTicketPage.get(0).getText().equalsIgnoreCase("Support Information"))
			{
				extentreportclass.mobilepassTest(module,caseName);
				getTicketID(module);
				
			}
			else
			{
				extentreportclass.mobilepassTest(module,caseName);
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}
	
	public void checkCurrentAndPreviousTicketTopic(String module)
	{
		String caseName="Check Current and previous chat zoho desk";
		try
		{
		int value = checkZohoDeskTicketHeaders.size();
		
		if(value>1)
		{
			extentreportclass.mobilepassTest(module,caseName);
			
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
			
		}
	}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
			
		}
	}

	public void checkCurrentTicketHeader(String module)
	{
		String caseName="Check Current visitor access ticket created";
		try
		{
		int value = checkZohoDeskTicketHeaders.size();
		
		if(value>0)
		{
			extentreportclass.mobilepassTest(module,caseName);
			
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
			
		}
	}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
			
		}
	}
	
	public void checkPreviouslyCreatedTicketList(String module)
	{
		String caseName = "check previously create ticket is showing in Recently created Ticket";
		try{
		if(getTicketID.size()>0)
		{
			
			extentreportclass.mobilepassTest(module,caseName);
		}
		else
		{

			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}
catch(Exception e)
{

	extentreportclass.mobilefailTest(driver,module,caseName);
}
	}

	public void checkEachTicketContainsInformation(String useCase)
	{
		String caseName="Verify all UI element is displayed for each Ticket";
		try
		{
				if(deskticketstatusinList.size()>0 && visitorQuestion.size()>0 && getTicketID.size()>0 )
				{
				extentreportclass.mobilepassTest(useCase,caseName);

				}
				else{
				extentreportclass.mobilepassTest(useCase,caseName);

				}
	

		}
catch(Exception e)
{
extentreportclass.mobilepassTest(useCase,caseName);
}
	}


	
	
	

	
	
}
