//$Id$
package com.zoho.salesiq.Testclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.zoho.salesiq.pageclass.CommonActionWeb;
import com.zoho.salesiq.pageclass.SearchFunctionality;

import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;

import com.zoho.salesiq.pageclass.BaseSetupWeb;
import com.zoho.salesiq.pageclass.VisitorSiteAccessPage;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
public class VisitorSiteAccessTest extends BaseSetupWeb {

	public String visitorQuestion = "Hi user this is for testing";
	public String visitorQuestionInSpanish = "buenos dias usuario";
	public String visitorName = "Testing Automation";
	public String operatorName="operator MPTEST";
	public String departmentName="Marketting";
	public String emailID="anbarasu.v@zohocorp.com";
	public String mobileNumber="9976058073";
	String module="VisitorSiteAccess";
	public String crmCompanyName="Automation SalesiqCRM";
	public String crmleadPhoneNumber="9898789890";
	public String crmLeadStatus="Contact in Future";
	public String crmLeadManager="mr.anbarasu10";
	public String potentialStage="Needs Analysis";
	public String potentialAmount="17890";
	public String zohodeskPriority="High";
	public String zohoDeskClassification="Problem";
	public String zohoDeskTicketStatus="Open";
	public String crmType="chat";
	public String salesiqURL="https://salesiqt.blogspot.com/2019/03/var-zohozoho-zoho.html";
	VisitorSiteAccessPage visitorsite;
	CommonActionWeb actions;
	BaseSetupWeb basesetup;
	public int visitorWaitingTime;
	public String visitorAccessTime;

	//public static WebDriver webDriver;
	public VisitorSiteAccessTest()
	{	
		basesetup=new BaseSetupWeb();
		if(webDriver==null)
		{
			System.out.println("Visitor Test constructor driver object null");
		}
		visitorsite = new VisitorSiteAccessPage(webDriver);
		actions=new CommonActionWeb(webDriver);	
	}

	
	public void VisitorAccess(String module)
	{
		
// 		System.out.println("Site accessed");
		basesetup.webPageAccess(module,salesiqURL);
		visitorAccessTime=actions.getCurrentTime();
		visitorsite.checkWidgetChatWindow(module);
		visitorsite.clearVisitorNameField(module);
		visitorsite.enterVisitorName(module,visitorName);
		visitorsite.selectDepartmentName(module,departmentName);
		visitorsite.enterChatText(module,visitorQuestion);
		visitorsite.sendchatRequestVisitor(module);
		visitorWaitingTime=visitorsite.getcurrentWaitingTime(module);

	}
	public void initiateChatWithoutName(String module)
	{
		
// 		System.out.println("Site accessed");
		basesetup.webPageAccess(module,salesiqURL);
		visitorAccessTime=actions.getCurrentTime();
		visitorsite.checkWidgetChatWindow(module);
		visitorsite.clearVisitorNameField(module);
		visitorsite.selectDepartmentName(module,departmentName);
		visitorsite.enterChatText(module,visitorQuestion);
		visitorsite.sendchatRequestVisitor(module);
		visitorWaitingTime=visitorsite.getcurrentWaitingTime(module);

	}
	public void visitorAccessWithMail(String module)
	{
		
// 		System.out.println("Site accessed");
		basesetup.webPageAccess(module,salesiqURL);
		visitorAccessTime=actions.getCurrentTime();
		visitorsite.checkWidgetChatWindow(module);
		visitorsite.clearVisitorNameField(module);
		visitorsite.enterVisitorName(module,visitorName);
		visitorsite.selectDepartmentName(module,departmentName);
		visitorsite.entervisitorMailid(module,emailID);
		visitorsite.enterChatText(module,visitorQuestion);
		visitorsite.sendchatRequestVisitor(module);
		visitorWaitingTime=visitorsite.getcurrentWaitingTime(module);
	}
	
	public void enterEmail(String module)
	{
		visitorsite.entervisitorMailid(module,emailID);
	}
	
	public void accessSiteWithMailAndSpanish(String module)
	{
// 		System.out.println("Site accessed");
		basesetup.webPageAccess(module,salesiqURL);
		visitorAccessTime=actions.getCurrentTime();
		visitorsite.checkWidgetChatWindow(module);
		visitorsite.clearVisitorNameField(module);
		visitorsite.enterVisitorName(module,visitorName);
		visitorsite.selectDepartmentName(module,departmentName);
		visitorsite.entervisitorMailid(module,emailID);
		visitorsite.enterChatText(module,visitorQuestionInSpanish);
		visitorsite.sendchatRequestVisitor(module);
		visitorWaitingTime=visitorsite.getcurrentWaitingTime(module);
	}
	
	
	
	public void checkNewChatInprogress(String module)
	{
		visitorsite.checkNewChatProgress(module);
	}
	public void clearChatTextVisitor(String module)
	{
		visitorsite.clearChatText(module);
	}
	public void accessSalesiqSite(String module)
	{
		basesetup.webPageAccess(module,salesiqURL);
		
	}
	public void accessdummysiteSite(String module)
	{
		basesetup.webPageAccess(module,"http://salesiqt.blogspot.com/");
		
	}
	public void quitBrowser(String module)
	{
		basesetup.closeBrowser(module);
		
	}
	public void startBrowser(String module)
	{
		basesetup.visitorAccessWeb(module);
		
	}
	
	public void startNewBrowser(String module)
	{
		webDriver=basesetup.visitorAccessWeb(module);
	}
	public void chatEnterInSpanish(String module) {
		visitorsite.enterChatText(module,visitorQuestionInSpanish);	
	}
	public void chatWithOperator(String module,String text) {
		visitorsite.enterChatText(module,text);	
	}
	
	public void getBrowsingCookie(String module) {
		basesetup.getBrowserCookie(module);
	}
	public void sendChatToOperator(String module) {
		visitorsite.sendchatRequestVisitor(module);
	}
	public void setBrowsingCookie(String module) {
		basesetup.setBrowserCookie(module);
	}
	public void initiateCall(String module)
	{
		visitorsite.initiateCallFromVisitor(module);
	}
	public void rejectCall(String module)
	{
		visitorsite.rejectCallFromVisitor(module);
	}
	public void acceptCall(String module)
	{
		visitorsite.acceptCallFromVisitor(module);
	}
	
	public void sendChatTextToOperator(String module)
	{
		visitorsite.sendTextToOperator(module);
	}
	public void endChatByVisitorClick(String module)
	{
		visitorsite.endChatByVisitor(module);
	}
	public void skipRatingByVisitor(String module)
	{
		visitorsite.closeRating(module);
	}
	public void createChatClickHere(String module)
	{
		visitorsite.createChatClickHere(module);
	}
	public int getCurrentWaitingTime(String module)
	{
	int value=visitorsite.getcurrentWaitingTime(module);
	return value;
	}
	
	
	
	
	
	

}
