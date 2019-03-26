//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import javax.management.loading.PrivateClassLoader;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.ActionOptions;

import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import io.appium.java_client.AppiumDriver;

public class MissedChatPage extends BaseSetup {

	private String module = "Missed Chat";
	
	private boolean missedDetailsPage;
	CommonActionMobile actions = new CommonActionMobile(driver);
	private boolean missedChatPage;
	SearchFunctionality seachFunctionality=new SearchFunctionality(driver);
	String assigneeName="";
	Extentreportclass extentreportclass=new Extentreportclass();
	public MissedChatPage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "user_name")
	@CacheLookup
	MobileElement profileName;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Missed Chats']")
	@CacheLookup
	MobileElement missedChatPageTitle;

	@AndroidFindBy(id = "visitorchat_name")
	List<MobileElement> visitorChatList;

	@AndroidFindBy(id = "emptylist_title")
	MobileElement missedChatEmptyList;
	
	@AndroidFindBy(id = "visitorchat_name")
	List<MobileElement> visitorNameInMissedChatList;
	
	@AndroidFindBy(id = "visitorchat_question")
	List<MobileElement> visitorQuestionInMissedChatList;
	
	@AndroidFindBy(id = "visitorchat_info")
	List<MobileElement> visitorAssigneeInMissedChatList;
	
	@AndroidFindBy(id = "visitorchat_time")
	List<MobileElement> visitorTimeInMissedChatList;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	List<MobileElement> visitorNameInMissedChatDetails;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
	MobileElement visitorAssignNameInMissedChatDetails;
	
	@AndroidFindBy(id = "question")
	@CacheLookup
	MobileElement visitorQuestionInMissedChatDetails;
	
	@AndroidFindBy(id = "missedtime")
	@CacheLookup
	MobileElement visitorMissedTimeinMissedDetails;
	
	@AndroidFindBy(id = "title")
	List<MobileElement> kebabMenuList;
	
	@AndroidFindBy(id = "username")
	List<MobileElement> assignOperatorList;
	
	@AndroidFindBy(id = "invitebutton")
	@CacheLookup
	MobileElement assignOperator;
	
	@AndroidFindBy(id = "prompt_message")
	@CacheLookup
	MobileElement missedChatClosePopupMessage;
	
	@AndroidFindBy(id = "cancel_button")
	@CacheLookup
	MobileElement missedChatClosePopupCancel;
	
	@AndroidFindBy(id = "ok_button")
	@CacheLookup
	MobileElement missedChatClosePopupOk;
	
	@AndroidFindBy(id = "dialog_title")
	@CacheLookup
	MobileElement missedChatClosePopupTitle;
	
	
	
	
	
	
	
	
	
	
	
	

	/// need to include Missed chat menu count

	public void checkMissedChatPageOpen(String module) {
		missedChatPage = actions.isPageOpened(missedChatPageTitle, module, "Check Missed Chat page open");
	}

	public void checkEmptyPageText(String module,String textValue) {
		if (missedChatPage) {
			if (actions.getListCount(visitorChatList) == 0) {
				actions.checkText(textValue, missedChatEmptyList, module, "Check empty text in missed chat");
			}
		}
	}
	public void searchFunctionFlow(String module)
	{
		boolean status;
		if (missedChatPage)
		{
			status = true;
		}
		
		
	}
	
	//SIQ_MISCHAT_014
		public void checkMissedChatListUI(String module)
		{
		try
		{
		actions.checkElementfoundCase(visitorNameInMissedChatList.get(0), module, "Check Visitor Name located in missed chat list");
		actions.checkElementfoundCase(visitorQuestionInMissedChatList.get(0), module, "Check Visitor question located in missed chat list");
		actions.checkElementfoundCase(visitorAssigneeInMissedChatList.get(0), module, "Check Visitor Assignee located in missed chat list");
		actions.checkElementfoundCase(visitorTimeInMissedChatList.get(0), module, "Check Visitor Time located in missed chat list");
	}
	catch(Exception e )
	{

	}
		}
		
		
		//SIQ_MISCHAT_015
		public void visitorNameCheckinMissedChatList(String module,String visitorName)
		{
			try
		{
			actions.checkText(visitorName, visitorNameInMissedChatList.get(0), module, "Check Visitor name in the missed chat list");
		}
		catch(Exception e )
	{

	}
}
		
		//SIQ_MISCHAT_016
		public void visitorQuestionCheckinMissedChatList(String module,String visitorQuestion)
		{
			try
		{
			actions.checkText(visitorQuestion, visitorQuestionInMissedChatList.get(0), module, "Check Visitor Question in missed Chat List");
			}
		catch(Exception e )
	{

	}
		}

		
		//SIQ_MISCHAT_017
		public void visitorAssigneeCheckinMissedChatList(String module,String operatorName)
		{
			try
		{
		actions.checkText(operatorName, visitorAssigneeInMissedChatList.get(0), module, "Check Visitor Assignee in missed caht list");
		assigneeName=actions.getElementText(visitorAssigneeInMissedChatList.get(0));
		}
		catch(Exception e )
	{

	}
			
		}
		
		//SIQ_MISCHAT_019
		public void visitorTimeCheckInMissedChatList(String module,String visitorTime)
		{
			try
		{
			actions.checkText(visitorTime, visitorTimeInMissedChatList.get(0), module, "Check Visitor Time in missed Chat List");
		}
		catch(Exception e )
	{

	}
		}
		
		
		//SIQ_MISCHAT_022
		public void missedChatDetailsPageOpen(String module)
		{
			try
		{
			actions.clickAction(visitorAssigneeInMissedChatList.get(0), module, "Open missed chat details page");
		}
		catch(Exception e )
	{

	}
		}
		
		
		//SIQ_MISCHAT_023
		public void missedChatDetailsUiCheck(String module)
		{
			try
		{
			actions.checkElementfoundCase(visitorNameInMissedChatDetails.get(0), module, "Check Visitor Name in Missed Details page");
			actions.checkElementfoundCase(visitorQuestionInMissedChatDetails, module, "Check Visitor Question in missed Details page");
			actions.checkElementfoundCase(visitorMissedTimeinMissedDetails, module, "Check Visitor Missed Time in missed details page");
		}
		catch(Exception e )
	{

	}
		}
		
		public void checkVisitornNameinMissedDetailsPage(String module,String visitorName)
		{
			try
		{
			actions.checkText(visitorName, visitorNameInMissedChatDetails.get(0), module, "Check VisitorName in missed Chat details page");
		}
		catch(Exception e )
	{

	}
		}
		
		public void checkVisitorQuestioninMissedDetails(String module,String visitorQuestion)
		{
			actions.checkText(visitorQuestion, visitorQuestionInMissedChatDetails, module, "Check visitor Question in Missed Details page");
		}
		public void checkMissedTimeinMissedDetails(String module,String missedTime)
		{
			actions.checkText(missedTime, visitorMissedTimeinMissedDetails, module, "Check Visitor missed Time in missed Details page");
		}
		
		//SIQ_MISCHAT_030
		public void checkKebabMenuwithoutMailid(String module)
		{
			if(missedDetailsPage)
			{
			actions.checkTextinList(kebabMenuList, "Assign Operator",module,"Check Kebab Menu Items Without Email Id");
			actions.checkTextinList(kebabMenuList, "Close", module,"Check Kebab Menu Items Without Email Id");
			actions.checkTextinList(kebabMenuList, "Add a Note", module,"Check Kebab Menu Items Without Email Id");
			actions.checkTextinList(kebabMenuList, "Block IP", module,"Check Kebab Menu Items Without Email Id");
			actions.checkTextinList(kebabMenuList, "View Information", module,"Check Kebab Menu Items Without Email Id");
			}
		}
		
		
		public void missedDetailsPageOpencheck(String module)
		{
			try
		{
			missedDetailsPage=actions.isPageOpened(visitorNameInMissedChatDetails.get(0), module, "Check Missed Details page open");
		}
		catch(Exception e )
	{

	}
		}
		
		public void checkAssignOperatorList(String module)
		{
			if(assigneeName.equals("Yet to assign"))
			{
				actions.checkTextinList(assignOperatorList, "You", module, "Check the operator in list of Assign Operator");
			}
		}
		public void checkAssignOperatorListForAssignedChat(String module)
		{
			if(!assigneeName.equals("Yet to assign"))
			{
				String operatorList[]=actions.getListofValue(assignOperatorList);
				for(String operator:operatorList)
				{
					if(operator.equalsIgnoreCase("You"))
					{
						extentreportclass.mobilefailTest(driver,module, "Check operator list for assigned operator");
						
					}
					else
					{
						extentreportclass.mobilepassTest(module, "Check Operator list for assigned Operator");
					}
				}
			}
		}
		
		public void assigNewOperator(String module,String operatorName)
		{
		actions.selectBasedonTextInList(assignOperatorList, operatorName, module, "Select Current Operator");
		actions.clickAction(assignOperator, module, "click on Assign operator");
		}
		
		public void checkAssignedOperatorName(String module,String operatorName)
		{
			actions.checkText(operatorName, visitorAssignNameInMissedChatDetails, module, "After assign operator check name in missed chat details page");
		}
		
		public void checkPopupTitle(String module,String popupTitle)
		{
			actions.checkText(popupTitle, missedChatClosePopupTitle, module, "Check Missed Chat Close Popup Title");
		}

		
		public void checkPopupMessage(String module,String popupMessage)
		{
			actions.checkText(popupMessage, missedChatClosePopupMessage, module, "Check Missed Chat Close Popup Message");
		}
		
		public void clickPopupMessageCancel(String module)
		{
			actions.clickAction(missedChatClosePopupCancel, module, "Cancel Popup Message");
		}
		
		public void clickPopupMessageOk(String module)
		{
			actions.clickAction(missedChatClosePopupOk, module, "Click Ok in Popup Message");
		}
		
		public void clickClosedVisitor(String module,String visitorName)
		{
			actions.checkTextShouldNotListed(visitorChatList, visitorName, module, "Check after close chat visitorName should not listed in missed chat list");
		}
		
	
		
		
		
		
	
		
		
	
		
		

	
	
	

}
