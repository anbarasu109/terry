//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;

public class KebabMenuFunctionality extends BaseSetup {
private String module = "KebabFunctionality";

private static String kebabMenuClickModule="";
public static String currentKebabMenuModule="";
	
	private boolean kebabMenuOpen;
	CommonActionMobile actions = new CommonActionMobile(driver);
	SearchFunctionality seachFunctionality=new SearchFunctionality(driver);
	Extentreportclass extentreportclass = new Extentreportclass();

	public KebabMenuFunctionality(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "More options")
	@CacheLookup
	MobileElement kebabMenu;
	
	@AndroidFindBy(id = "title")
	List<MobileElement> kebabMenuList;
	
	public void clickKebabMenu(String testcase)
	{
		String testCaseName="";
		
			testCaseName="Verify kebab menu is displaying";
			

		actions.clickAction(kebabMenu,testcase,testCaseName);
		
	}
	
	public void selectMenuFroMKebab(String menuItem,String testcase)
	{
		try
		{
		actions.waitTime(2);
		actions.selectBasedonTextInList(kebabMenuList, menuItem, testcase, "Verify "+menuItem+" and Click on Menu item");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,"Verify "+menuItem+" and Click on Menu item");	

	}
	}
	public void clickEndSession(String testcase)
	{
	selectMenuFroMKebab("End Session in 30 Secs",testcase);
	actions.waitTime(35);
		
	}

	public void  clickEndNow(String testcase)
	{
		selectMenuFroMKebab("End Now",testcase);

	}
	public void  clickTranslateChatHistory(String testcase)
	{
		selectMenuFroMKebab("Translate Spanish",testcase);

	}
	public void  clickViewOriginalTranscript(String testcase)
	{
		selectMenuFroMKebab("View Original Transcript",testcase);

	}
	
	public void checkClickEndSession(String testcase)
	{
		selectMenuFroMKebab("End Session in 30 Secs",testcase);
		}
	public void checkClickEndTimer(String testcase)
	{
		selectMenuFroMKebab("End Timer",testcase);
	}
	public void clickTransferChat(String testcase)
	{
		selectMenuFroMKebab("Transfer this chat",testcase);
		
	}
	public void clickInviteChat(String testcase)
	{
		selectMenuFroMKebab("Invite operator",testcase);
		
	}
	public void clickBlockIP(String testcase)
	{
		selectMenuFroMKebab("Block IP",testcase);
		
	}
	public void openViewNotes(String testcase)
	{
		selectMenuFroMKebab("View Notes",testcase);
		
	}
	public void addNewNotes(String testcase)
	{
		selectMenuFroMKebab("Add a Note",testcase);
		
	}
	public void viewInformation(String testcase)
	{
		selectMenuFroMKebab("View Information",testcase);
		
	}

	public void moreInformation(String testcase)
	{
		selectMenuFroMKebab("More Information",testcase);
		
	}
	public void footPathMenu(String testcase)
	{
		selectMenuFroMKebab("Foot Path",testcase);
	}
	public void previousChat(String testcase)
	{
		selectMenuFroMKebab("Previous Chats",testcase);
		
	}
	public void comnvertAsContact(String testcase)
	{
		selectMenuFroMKebab("Convert as contact",testcase);
		
	}
	public void convertAsPotential(String testcase)
	{
		selectMenuFroMKebab("Create Potential",testcase);
		
	}
	public void recentlyCreatedTicket(String testcase)
	{
		selectMenuFroMKebab("Recent Support Requests",testcase);
		
	}
	public void clickEditInformationPage(String testcase)
	{
		selectMenuFroMKebab("Edit Information",testcase);
		
	}
	public void sendMailInKebab(String testcase)
	{
		selectMenuFroMKebab("Send Email",testcase);
		
	}
	public void crmInformation(String testcase)
	{
		actions.waitTime(2);
		selectMenuFroMKebab("CRM Information",testcase);
		
	}

	public void createPotential(String testcase,String categories)
	{
		actions.waitTime(2);
		selectMenuFroMKebab("Create Potential",testcase);
		
	}

	public void convertAsContact(String testcase,String categories)
	{
		
		selectMenuFroMKebab("Convert as contact",testcase);
		
	}
	public void checkviewInformationKebabMenu(String testcase)
	{
		boolean status=false;
		String caseName="Check view information kebab menu";
		String[] kebaMenuValue= {"Edit Information","Foot Path","More Information"};
		try {
		int i=0;
		for(MobileElement elem: kebabMenuList)
		{
			if(elem.getText().equalsIgnoreCase(kebaMenuValue[i]))
			{
				i++;
				if(i>=3)	
				{
					status=true;
				}
				
			}
		
		}
		if(status)
		{
			extentreportclass.mobilepassTest(testcase, caseName);
		}
		else
		{
			extentreportclass.mobilefailTest(driver,testcase, caseName);
		}
		}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,testcase, caseName);
		
	}
		
	}
	
	
	public void checkKebabMenuCRMandDesk(String module)
	{
		String caseName="Check CRM and Zoho desk tickets in Chat window Kebab menu functionality";
		try
		{
		boolean crmStatus,deskStatus;
		crmStatus=checkMenuInList("CRM Information");
		deskStatus=checkMenuInList("Recent Support Requests");
		if(crmStatus&&deskStatus)
		{
			extentreportclass.mobilepassTest(module, caseName);	
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
	}
	public void checkViewInformationInPreviousChat(String module)
	{
		String caseName="Check Viewinformation menu in Previoius chat Kebab Menu";
		try
		{
		
		boolean viewInformation;
		viewInformation=checkMenuInList("View Information");
		
		if(viewInformation)
		{
			extentreportclass.mobilepassTest(module, caseName);	
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
	}
	public void checkKebabMenuAfterClickOnEndSession(String module)
	{
		String caseName="Check after clicks on End session End Timer menu should be shown in Kebab menu";
		try
		{
			
			boolean endTimer;
			endTimer=checkMenuInList("End Timer");
			
			if(endTimer)
			{
				extentreportclass.mobilepassTest(module, caseName);	
			}
			else
			{
				extentreportclass.mobilefailTest(driver,module, caseName);	
				
			}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
	}
	public void checkKebabMenuAfterClickOnEndTimer(String testcase)
	{
		String caseName="Check after clicks on End Timer, End Session menu should be shown in Kebab menu";
		try
		{
			
			boolean endTimer;
			endTimer=checkMenuInList("End Session in 30 Secs");
			
			if(endTimer)
			{
				extentreportclass.mobilepassTest(module, caseName);	
			}
			else
			{
				extentreportclass.mobilefailTest(driver,module, caseName);	
				
			}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
	}
	public void checkCreatePotentialInContact(String module)
	{
		String caseName="Check Create potential menu in contact Kebab Menu";
		try
		{
		
		boolean createPotential;
		createPotential=checkMenuInList("Create Potential");
		
		if(createPotential)
		{
			extentreportclass.mobilepassTest(module, caseName);	
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
	}
	public void checkRecentRequestTickets(String module)
	{
		String caseName="Check Recent Request tickets displayed in kebab Menu";
		try
		{
		actions.waitTime(2);
		boolean checkRecentTickets;
		checkRecentTickets=checkMenuInList("Recent Support Requests");
		
		if(checkRecentTickets)
		{
			extentreportclass.mobilepassTest(module, caseName);	
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
	}
	
	public void checkConvertContactAndPotentialMenu(String module)
	{
		String caseName="Check Converts as contact and Create pontential menu should be shown";
		try
		{
		boolean convertContact,createPotential;
		convertContact=checkMenuInList("Convert as contact");
		createPotential=checkMenuInList("Convert as Contact & Add Potential");
		
		if(convertContact&&createPotential)
		{
			extentreportclass.mobilepassTest(module, caseName);	
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);	
			
		}
	}
	
	
	public boolean checkMenuInList(String expectedMenu)
	{
		boolean status=false;
		try {
		for(MobileElement elem: kebabMenuList)
		{
			if(elem.getText().equalsIgnoreCase(expectedMenu))
			{
				status =true;
				break;
			}
		}
		}
		catch(Exception e)
		{
			status=false;
		}
		return status;
		
	}

	public void checkKebabMenuFunctionality(String expectedText,String useCase,String caseName) {
		try {
			
			actions.checkTextinList(kebabMenuList, expectedText, useCase, caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,useCase, caseName);	

		}
	}

	public void checkCRMInformationKebabAsLead(String useCase,String categories) {
		String caseName="Verify CRM information kebab menu as Lead";
		try {
			checkKebabMenuFunctionality("Convert as contact",useCase,caseName);
			checkKebabMenuFunctionality("Convert as Contact & Add Potential",useCase,caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,useCase,caseName);	
		}
	}
	
	public void checkCRMkebabMenuAvailable(String useCase)
	{
	String caseName="Verify CRM information menu didsplayed in Kebab Menu";
	try {
		actions.waitTime(2);
		checkKebabMenuFunctionality("CRM Information",useCase,caseName);
	}
	catch(Exception e)
	{
		
	}
	}
	
	

	

	


}
