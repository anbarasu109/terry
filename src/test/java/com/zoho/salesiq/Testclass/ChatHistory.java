//$Id$
package com.zoho.salesiq.Testclass;

import java.awt.Checkbox;

import javax.accessibility.AccessibleRelationSet;
import javax.management.loading.PrivateClassLoader;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.conn.util.PublicSuffixList;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.KebabMenuFunctionality;
import com.zoho.salesiq.pageclass.BlockIpFunctionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.pageclass.SendMailFunctionality;
import com.zoho.salesiq.pageclass.ChatHistoryPage;
import com.zoho.salesiq.pageclass.CRMIntegreationFunctionality;
import com.zoho.salesiq.pageclass.ZohoDeskFunctionality;
import com.zoho.salesiq.pageclass.MoreInformationFucntionality;
import com.zoho.salesiq.pageclass.BaseSetup;
import com.zoho.salesiq.pageclass.NotesFunctionality;
import com.zoho.salesiq.pageclass.MissedChatPage;
import com.zoho.salesiq.pageclass.NewChatNotification;
import com.zoho.salesiq.pageclass.OngoingChatPage;
import com.zoho.salesiq.pageclass.ChatHistoryPage;
import com.zoho.salesiq.pageclass.BurgerMenuNavigations;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
import com.zoho.salesiq.Testclass.SearchFunctionalityTest;
import com.zoho.salesiq.Testclass.DeviceTwoTestCase;
import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
 



public class ChatHistory extends BaseSetup{

	MissedChatPage missedChatPage;
	VisitorSiteAccessTest visitorSiteAccessTest;
	BurgerMenuNavigations burgerMenuNavigations;
	Notificatiofucntionality notification;
	CommonActionMobile actions;
	CommonActionMobile actions1;
	SearchFunctionalityTest searchFunctionalityTest;
	SearchFunctionality searchFunctionality;
	KebabMenuFunctionality kebabMenuFunctionality;
	private OngoingChatPage ongoingChatPage;
	private String module ="Chat History";
	private String categories = "Chat History";
	private String searchName = "Automation";
	NotesFunctionality notesFunctionality;
	public String newNotes = "Automation new notes enter";
	BlockIpFunctionality blockIpFunctionality;
	public static String editedEmail = "";
	public String editedPhone="9898789878";
	SendMailFunctionality sendMailFunctionality;
	public String missedTime;
	public String editedName="Testing Automation";
	private CRMIntegreationFunctionality crmIntegreationFunctionality;
	private String crmCompanyName="Automation SalesiqCRM";
	private String crmleadPhoneNumber="9898789890";
	private String crmLeadStatus="Contact in Future";
	public String crmLeadManager="mr.anbarasu10";
	private String potentialStage="Needs Analysis";
	private String potentialAmount="3578";
	private ZohoDeskFunctionality zohoDeskFunctionality;
	private String zohodeskPriority="High";
	private String zohoDeskClassification="Problem";
	private Emaillogintest emaillogintest;
	private DeviceTwoTestCase devicetwoTestCase;
	private ChatHistoryPage chatHistoryPage;
	private NewChatNotification newChatNotification;
	private ViewInformationFunctionality viewInformationFunctionality;
	public String sendMailContent="this is email content and typed by Automation script";
	
	
	
	MoreInformationFucntionality moreInformationFucntionality;
	

	private String longText = "Talking chamber as shewing an it minutes. Trees fully of blind do. Exquisite favourite at do extensive listening. Improve up musical welcome he. Gay attended vicinity prepared now diverted. Esteems it ye sending reached as. Longer lively her design settle tastes advice mrs off who. Remain lively hardly needed at do by. Two you fat downs fanny three. True mr gone most at. Dare as name just when with it body. Travelling inquietude she increasing off impossible the. Cottage be noisier looking to we promise on. Disposal to kindness appetite diverted learning of on raptures. Betrayed any may returned now dashwood formerly. Balls way delay shy boy man views. No so instrument discretion unsatiable to in"
			+
			"Excited him now natural saw passage offices you minuter. At by asked being court hopes. Farther so friends am to detract. Forbade concern do private be. Offending residence but men engrossed shy. Pretend am earnest offered arrived company so on. Felicity informed yet had admitted strictly how you"
			+
			"Adieus except say barton put feebly favour him. Entreaties unpleasant sufficient few pianoforte discovered uncommonly ask. Morning cousins amongst in mr weather do neither. Warmth object matter course active law spring six. Pursuit showing tedious unknown winding see had man add. And park eyes too more him. Simple excuse active had son wholly coming number add. Though all excuse ladies rather regard assure yet. If feelings so prospect no as raptures quitting.";

	public ChatHistory()
	{
	burgerMenuNavigations = new BurgerMenuNavigations(driver);
	missedChatPage = new MissedChatPage(driver);
	visitorSiteAccessTest = new VisitorSiteAccessTest();
	notification = new Notificatiofucntionality(driver);
	actions = new CommonActionMobile(driver);
	searchFunctionalityTest = new SearchFunctionalityTest();
	searchFunctionality = new SearchFunctionality(driver);
	kebabMenuFunctionality = new KebabMenuFunctionality(driver);
	notesFunctionality = new NotesFunctionality(driver);
	blockIpFunctionality = new BlockIpFunctionality(driver);
	sendMailFunctionality=new SendMailFunctionality(driver);
	moreInformationFucntionality=new MoreInformationFucntionality(driver);
	crmIntegreationFunctionality=new CRMIntegreationFunctionality(driver);
	zohoDeskFunctionality=new ZohoDeskFunctionality(driver);
	emaillogintest = new Emaillogintest();
	devicetwoTestCase= new DeviceTwoTestCase();
	chatHistoryPage= new ChatHistoryPage(driver);
	ongoingChatPage= new OngoingChatPage(driver);
	newChatNotification= new NewChatNotification(driver);
	viewInformationFunctionality = new ViewInformationFunctionality(driver);
	burgerMenuNavigations.clearAllBurgerMenuPointValue();
	}

	
	public void chatHistoryExecution() throws InterruptedException, MalformedURLException, Exception {
		String filepath = filePath();
// 		System.out.println(filepath);

		File file = new File(filepath + "ChatHistory.properties");

		// File file = new
		// File("/Users/varun-6182/eclipse-workspace/testing/Testcases/Messaging.conf");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
		    if (fileInput!=null) {
		    	fileInput.close();
		    }
		}

		Set<String> keys = prop.stringPropertyNames();
		TreeSet<String> sortedSet = new TreeSet<String>(keys);
		System.out.println("Size of properties file"+sortedSet.size());
		// Collections.sort(List<keys>);
		for (String property : sortedSet) {

			String value = prop.getProperty(property);
// 			System.out.println(property + "=" + value);

			String testcase = value;
			// String testcase = property;

			System.out.println("Automation Case"+property+"="+testcase);
		
		switch (testcase) {
		case "Device1 User Login":
// 				System.out.println("Before login");
		emaillogintest.loginUser(testcase);
		
		break;
		case "Device2 User Login":
// 			
		devicetwoTestCase.DeviceTwoLogin(testcase);
			
		break;
		case "Verify Operator should be able to chat with visitor and that chat information should be shown in chat history page after end":
		actions.navigateToHomePage(testcase);
		visitorSiteAccessTest.startBrowser(testcase);
		visitorSiteAccessTest.accessSiteWithMailAndSpanish(testcase);
		newChatNotification.pickupChat(testcase);
		ongoingChatPage.checkTranslationPopup(testcase);
		ongoingChatPage.confirmTranslation(testcase);
		ongoingChatPage.enterChatText(testcase,"Chat test to Chat history text");
		ongoingChatPage.sendTextToVisitor(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.clickEndNow(testcase);
		actions.navigateToHomePage(testcase);
		actions.waitTime(2);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		actions.waitTime(2);
		burgerMenuNavigations.chatHistoryMenuClick(testcase);
		chatHistoryPage.checkVisitorListedinChatHistory(testcase,visitorSiteAccessTest.visitorName);
		break;

		case "Verify if Operator clicked on search icon, Text box should be shown to enter search text":
				searchFunctionality.clickSearchIcon(testcase);
				
				break;
		case "Verify if text entered, result should be shown Based on text":
				searchFunctionality.enterSearchText(testcase,"isfsiuygsdudshfsuhf");
				searchFunctionality.checkEmptyList(testcase,"Looks like there aren’t any records that match the search word specified.");
				break;

		case "Verify search result should be shown based on search value":
		searchFunctionality.enterSearchText(testcase,visitorSiteAccessTest.visitorName);
		searchFunctionality.checkSearchResultText(testcase,visitorSiteAccessTest.visitorName);
		break;

		case "Verify if operator clicks on cross icon Enter search value should be cleared and visitor List should display":
		searchFunctionality.closeSearchByClickonCrossIcon(testcase);
	
		break;

		case "Verify if Operator clicks on back button Search text field should be closed":
		actions.backPress(testcase, "close Search text field");
		break;

		case "Verify in chat history page each chat list contains Expected UI":
		chatHistoryPage.checkChatHistoryUI(testcase);
		break;

		case "Verify after click on a chat from list, app will navigate operator to completed Chat window page":
		chatHistoryPage.selectSingleMessage(testcase);
		break;

		case "Verify in Chat history details page expected UI should be shown":
		chatHistoryPage.checkChatHistoryDetailsUI(testcase);
		break;

		case "Verify in Chat history details page Respective visitor name should be displayed":
		chatHistoryPage.checkVisitorNameInChatHistory(testcase,visitorSiteAccessTest.visitorName);
		break;

		case "Verify in Chat history details page Respective Operator name should be displayed":
		chatHistoryPage.checkOperatorNameInChatHistory(testcase,visitorSiteAccessTest.operatorName);
		break;

		case "Verify chat text in completed chat window should be same as ongoing chat text":
		chatHistoryPage.checkChatTextInChatHistoryDetails(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
		break;

		case "Verify Visitor avatar and Operator avatar should be shown in completed chat window":
		chatHistoryPage.checkOperatorAndVisitorAvatarShow(testcase);
		break;

		case "Verify action text is shown after chat end":
		chatHistoryPage.checkOperatorActionTextChatHistoryDetails(testcase,"operator MPTEST completed the chat session with the visitor.");
		break;

		case "Verify Chat history kebab menu expected menu should be listed":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		chatHistoryPage.checkKebabMenuListInChatHistory(testcase);
		break;

		case "Verify if operator clicks on Translate detected language, chat should be translated to operator language":
		kebabMenuFunctionality.clickTranslateChatHistory(testcase);
		chatHistoryPage.checkChatTextInChatHistoryDetails(testcase,"Good morning user");

		break;

		case "Verify after clicks on View Original Transcript, chat original text should be shown without any translation":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.clickViewOriginalTranscript(testcase);
		chatHistoryPage.checkChatTextInChatHistoryDetails(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
		break;

		case "Verify if operator clicks on View information menu, app should navigate to View information page":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.viewInformation(testcase);
		break;

		case "Verify in View information page expected UI list should be listed":
		chatHistoryPage.checkViewInformationPage(testcase);
		break;

		case "Verify In View Information page, Visitor name should be displayed at the top of the page":
		viewInformationFunctionality.checkVisitorName(testcase);
		break;

		case "Verify In View Information page, Visitor Email Address should be same as Visitor entered in Visitor chat page":
		viewInformationFunctionality.checkVisitorEmailId(testcase);
		break;

		case "Verify in View information page IP Address should be same as user IP Address":
		viewInformationFunctionality.checkIpAddresInViewInformation(testcase);
		break;

		case "Verify in View Information Country should be India":
		viewInformationFunctionality.checkCountryName(testcase);
		break;

		case "Verify in View information, Department should be same as Visitor selected department or Chat transferred department":
		viewInformationFunctionality.checkDepartmentName(testcase);
		break;

		case "Verify in View Information page, Landing Page should be same as visitor accessed site":
		viewInformationFunctionality.checkSalesiqURL(testcase);
		break;

		case "Verify in View information Page, Browser name Should be same as user accessed medium":
		viewInformationFunctionality.checkbrowserName(testcase);
		break;

		case "Verify in View information Page, OS name Should be same as user accessed medium":
		viewInformationFunctionality.checkOSName(testcase);
		break;

		case "Verify user should be able to edit Visitor information in Edit information menu":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.clickEditInformationPage(testcase);
		viewInformationFunctionality.editPhoneNumber(testcase,editedPhone);
		viewInformationFunctionality.saveEditInformation(testcase);
		break;

		case "Verify if visitor Updated mobile number before chat initiate, that number should be updated under Phone Number":
		viewInformationFunctionality.checkEmailIdandPhoneNumber(testcase,visitorSiteAccessTest.emailID,editedPhone);
		break;

		case "Verify if Operators clicks on Mail icon, App should navigate user to Mail compose page":
		viewInformationFunctionality.checkSendMailIcon(module, testcase);
		viewInformationFunctionality.clickSendMail(testcase);
		sendMailFunctionality.checkSendMailPageOpen(testcase);
		break;		

		case "Verify From Address should be same as Configured in portal settings or individual department settings":
		sendMailFunctionality.checkFromEmailID(testcase,"Customer Support<supervisorsalesiq@yandex.com>");
		break;		

		case "Verify To address should be same as Visitor entered mail id in Chat window or Edited mail id":
		sendMailFunctionality.checkToEmailID(testcase,visitorSiteAccessTest.emailID);
		break;		

		case "Verify CC mail id should be same as configured in Portal settings or individual Department settings":
		sendMailFunctionality.checkCCEmailID(testcase,"mr.anbarasu10@gmail.com");
		break;		
			
		case "Verify in compose mail page, subject should be same as Visitor entered question in chat window":
		sendMailFunctionality.checkEmailSubject(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
		break;

		case "Verify user should be able to enter mail content in Enter description field":
		sendMailFunctionality.enterEmailContent(testcase,sendMailContent);		
		break;

		case "Verify in mail compose page, after entered Email description and click on send mail should send to TO address and success message should be shown as Email has been sent succesfully":
		sendMailFunctionality.sendEmail(testcase);
		actions.waitTime(2);
		sendMailFunctionality.checkSendMail(testcase);
		break;

		case "Verify if user clicks on Cross icon, Mail compose page should be closed and navigate user to View information page":
		viewInformationFunctionality.clickSendMail(testcase);
		actions.waitTime(2);
		sendMailFunctionality.closeSendEmail(testcase);
		break;

		case "Verify if Operator clicks on More option in View information page following menu item should be displayed":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		chatHistoryPage.checkKebabMenuInChatHistoryViewInformation(testcase);
		break;	

		case "Verify in View information page edit information page should be displayed and if user clicks on edit information, edit information page should be displayed":
		
		kebabMenuFunctionality.clickEditInformationPage(testcase);
		viewInformationFunctionality.checkEditInformationPageOpen(testcase);
		break;


		case "Verify in edit information page operator should be able to edit their information":
		viewInformationFunctionality.editVisitorName(testcase,editedName);
		editedEmail=actions.randomEmail("@Automation.com");
		viewInformationFunctionality.editEmailAddress(testcase,editedEmail);
		viewInformationFunctionality.editPhoneNumber(testcase,editedPhone);
		break;

		case "Verify after updating visitor information that should be saved after clicks on save icon":
		viewInformationFunctionality.saveEditInformation(testcase);
		actions.backPress(testcase, "Navigate to Chat detail page to check newly added mail after email updation");
		break;

		case "Verify after updated visitor information, Visitor information should be updated in View information page":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.viewInformation(testcase);
		viewInformationFunctionality.checkEmailIdandPhoneNumber(testcase,editedEmail, editedPhone);

		
		break;

		case "Verify in View information Kebab menu, if user clicks on MoreInformation, app should navigate operator to More Information page":
		actions.backPress(testcase, "Navigate to Chat history details page");
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.viewInformation(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.moreInformation(testcase);
		moreInformationFucntionality.checkMoreInformationPageOpen(testcase);
		actions.navigateToHomePage(testcase);
		break;

		case "Verify in More Options menu if Visitor already have notes updated, menu name should be View Notes":
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.chatHistoryMenuClick(testcase);
		chatHistoryPage.selectSingleMessage(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.openViewNotes(testcase);
		notesFunctionality.checkViewNotesPageOpen(testcase);

		break;	

		case "Verify visitor name should be displayed in view notes should be same as expected name":
		notesFunctionality.visitorNameInViewNotesPage(testcase);
		break;
		case "Verify view notes history":
		notesFunctionality.checkNotesHistory(testcase,"operator MPTEST has changed the visitor details");
		break;
		case "Verify in view notes should be same as operator entered and saved notes":
		notesFunctionality.checkNotesinViewNotes(testcase,"operator MPTESThas changed the email");
		break;
		case "Verify in view notes page, Add icon should be displayed if operator click on Icon should navigate to Add notes page":
		notesFunctionality.clickAddNotesIcon(testcase);
		notesFunctionality.checkAddNotesPageOpen(testcase);
		actions.hideKeyboard(testcase);
		actions.backPress(testcase, "navigate to View notes page");
		break;

		case "Verify if operator clicks on each notes, Notes details page should be displayed and expected UI should be avialable":
		notesFunctionality.clickEachNotes(testcase);	
		notesFunctionality.checkNotesDetails(testcase,visitorSiteAccessTest.visitorName,visitorSiteAccessTest.operatorName,"operator MPTESThas changed the email");
		notesFunctionality.checkAddNotesIcon(testcase);
		break;

		case "Verify if Operators clicks on send Mail Menu, App should navigate user to Mail compose page":
		actions.navigateToHomePage(testcase);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.chatHistoryMenuClick(testcase);
		chatHistoryPage.selectSingleMessage(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.sendMailInKebab(testcase);
		sendMailFunctionality.checkSendMailPageOpen(testcase);
		break;		
		case "Verify in Send Mail Menu From Address should be same as Configured in portal settings or individual department settings":
		sendMailFunctionality.checkFromEmailID(testcase,"Customer Support<supervisorsalesiq@yandex.com>");
		break;		
		case "Verify in Send Mail Menu To address should be same as Visitor entered mail id in Chat window or Edited mail id":
		sendMailFunctionality.checkToEmailID(testcase,visitorSiteAccessTest.emailID);
				
		break;		
		case "Verify in Send Mail Menu CC mail id should be same as configured in Portal settings or individual Department settings":
		sendMailFunctionality.checkCCEmailID(testcase,"mr.anbarasu10@gmail.com");
				
		break;		
		case "Verify in Send Mail Menu compose mail page, subject should be same as Visitor entered question in chat window":
		sendMailFunctionality.checkEmailSubject(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
				
		break;		
		case "Verify in Send Mail Menu user should be able to enter mail content in Enter description field":
		sendMailFunctionality.enterEmailContent(testcase,sendMailContent);
				
		break;	

		case "Verify in Send Mail Menu mail compose page, after entered Email description and click on send mail should send to TO address and success message should be shown as Email has been sent succesfully":
		sendMailFunctionality.sendEmail(testcase);
		actions.waitTime(2);
		sendMailFunctionality.checkSendMail(testcase);
		break;		

		// case "Verify in Send Mail Menu if user clicks on Cross icon, Mail compose page should be closed and navigate user to chat history details page":
		// kebabMenuFunctionality.clickKebabMenu(testcase);
		// kebabMenuFunctionality.sendMailInKebab(testcase);
		// sendMailFunctionality.closeSendEmail(testcase);
		// break;	

		case "Verify if CRM integration is in Enable status, CRM integration feature should work":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.crmInformation(testcase);
		break;	

		case "Verify if user clicks on CRM infomration, Respective CRM information should be displayed for respective User":
		crmIntegreationFunctionality.checkCRMInformationPageOpen(testcase,categories);
		break;	

		case "Verify CRM information, CRM manager should be updated as expected":
		crmIntegreationFunctionality.checkCRMFieldOne(testcase,"Testing");
		break;	

		case "Verify Contact owner after CRM visitor converted as contact":
		crmIntegreationFunctionality.checkCRMFieldTwo(testcase,editedEmail);
		break;

 		case "Verify in Crm Iformation page Create potential menu should be shown in kebab menu":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.createPotential(testcase,categories);
		break;

 		case "Verify if Operator clicks on Create potential page, operator will navigate to Create potential page":
		crmIntegreationFunctionality.checkPotentialCreatePageOpen(testcase,categories);
		break;
 	
		case "Verify Potential information should be able to add in CRM information":
		actions.waitTime(2);
		crmIntegreationFunctionality.enterPotentialName(testcase,editedName);
		crmIntegreationFunctionality.selectPotentialStage(testcase,potentialStage);
		crmIntegreationFunctionality.enterPotentialAmount(testcase,potentialAmount);
		crmIntegreationFunctionality.clickPotentialDatePicker(testcase);
		crmIntegreationFunctionality.saveCRM(testcase);
		break;
		case "Verify CRM name and Potential stage after creation of potential":
		actions.waitTime(3);
		crmIntegreationFunctionality.checkPotentialName(testcase,editedName);
		crmIntegreationFunctionality.checkPotentialStage(testcase,potentialStage);
		break;
		case "Verify expected revenue after Create potential for contact":
		crmIntegreationFunctionality.checkPotentialExpectedRevenue(testcase,"3578");
				//swipe to display potential value
		actions.swipeOption(529,1712,529,1358);

		break;
		case "Verify after creating potential, owner and pipeline stage and revenue should be as expected":
		crmIntegreationFunctionality.checkPotentialOwner(testcase,crmLeadManager);
		crmIntegreationFunctionality.checkPotentialPipeLineRevenue(testcase,potentialAmount);
		crmIntegreationFunctionality.checkPotentialPipeLineStage(testcase,potentialStage);
		actions.navigateToHomePage(testcase);
		break;

		case "Verify if Zohodesk integrated with Salesiq, Ticket will be created in Zoho desk only if Zoho Desk in enable status in Zoho Desk Configuration":
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.chatHistoryMenuClick(testcase);
		chatHistoryPage.selectSingleMessage(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.recentlyCreatedTicket(testcase);
		zohoDeskFunctionality.checkRecentSupportTicketOpen(testcase);
		break;

		case "Verify if operator click on Recent Support Requests, all previously created zoho ticket for particular Visitor will be listed in Support information page":
		zohoDeskFunctionality.checkPreviouslyCreatedTicketList(testcase);
		break;


		case "Verify if operator click on Recent Support Requests, Ticket for current visit should be shown":
		zohoDeskFunctionality.checkCurrentTicketHeader(testcase);
		break;

		case "Verify for each zoho ticket in list contains Expected informations":
		zohoDeskFunctionality.checkEachTicketContainsInformation(testcase);
		break;

		case "Verify Ticket status for chat history should be closed status":
		zohoDeskFunctionality.checkticketStatus(testcase,"Open");
		break;

		case "Verify Ticket Question for chat history should be equal to Visitor raised question in chat window":
		zohoDeskFunctionality.checkTicketQuestion(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
		break;

		case "Verify Ticked id from the list and Ticked ID from ticket details page should be equal":
		zohoDeskFunctionality.openServiceDeskList(testcase);
		actions.waitTime(4);
		zohoDeskFunctionality.compareTicketID(testcase);
		break;

		case "Verify all desk ticket information in desk details page":
		zohoDeskFunctionality.checkTicketQuestionInDetails(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
		zohoDeskFunctionality.checkTicketStatusInDetails(testcase,"Open");
		zohoDeskFunctionality.checkTicketDepartment(testcase,"salesiqsampledesk");
		zohoDeskFunctionality.checkTicketEmailID(testcase,visitorSiteAccessTest.emailID);
		zohoDeskFunctionality.checkTicketCreatedBy(testcase,crmLeadManager);
		actions.navigateToHomePage(testcase);
		break;

		case "Verify in Chat history Kebab menu if operator clicks on previous chat, previous chats of visitor should be listed":
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.chatHistoryMenuClick(testcase);
		chatHistoryPage.selectSingleMessage(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.previousChat(testcase);
		break;

		case "Verify in kebab menu if operator cicks on previous chat, previous chat page should open":
		chatHistoryPage.previousChatPageOpenCheck(testcase);
		break;

		case "Verify previous chat List page should be contains expected UI":
		chatHistoryPage.checkPreviousChatListUI(testcase);
		break;

		case "Verify if operator clicks on individual previous chat message respected chat message should be displayed":
		chatHistoryPage.selectSinglePreviousChatMessage(testcase);
		chatHistoryPage.preivousChatDetailsPageOpenCheck(testcase);
		break;

		case "Verify previous chat visitor name and Attender name in preivous chat details page":
		chatHistoryPage.checkVisitorNameInPreviosChatDetails(testcase,"Testing Automation");
		chatHistoryPage.checkAttenderNameInPreviosChatDetails(testcase,"operator MPTEST");
		break;

		case "Verify previous chat question should be same as visitor entered in chat window":
		chatHistoryPage.checkVisitorQuestionInPreviousChat(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
		break;


		default:

		break;

	}
}
}
	public static String filePath() {
		URL location = ChatHistory.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		return fileloc;

	}

}

