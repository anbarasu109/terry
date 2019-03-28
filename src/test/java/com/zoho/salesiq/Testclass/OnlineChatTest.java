//$Id$
package com.zoho.salesiq.Testclass;

import java.awt.Checkbox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;


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
import com.zoho.salesiq.pageclass.NewChatNotification;
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
import com.zoho.salesiq.pageclass.BurgerMenuNavigations;
import com.zoho.salesiq.pageclass.SettingsPage;
import com.zoho.salesiq.pageclass.Emaillogin;
import com.zoho.salesiq.pageclass.VisitorOnlinePage;
import com.zoho.salesiq.pageclass.OngoingChatPage;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
import com.zoho.salesiq.Testclass.SearchFunctionalityTest;
import com.zoho.salesiq.Testclass.DeviceTwoTestCase;
import io.appium.java_client.AppiumDriver;


public class OnlineChatTest extends BaseSetup{
	
	//final static Logger LOGGER = LoggerFactory.getLogger(OnlineChatTest.class);
	private String newNotes="This is automation new notes";
	private SettingsPage settings;
	private VisitorOnlinePage visitorOnlinePage;
	private BurgerMenuNavigations burgerMenuNavigations;
	private CommonActionMobile actions;
	private ChatHistoryPage chatHistoryPage;
	private VisitorSiteAccessTest visitorSiteAccessTest;
	private NewChatNotification newChatNotification;
	private Notificatiofucntionality notificatiofucntionality;
	private BlockIpFunctionality blockIPFunctionality;
	private NotesFunctionality notesFunctionality;
	private ViewInformationFunctionality viewInformationFunctionality;
	private SendMailFunctionality sendMailFunctionality;
	private CRMIntegreationFunctionality crmFunctionality;
	private ZohoDeskFunctionality zohoDeskFunctionality;
	private static boolean chatTransferResult;

	private BaseSetup baseSetup;
	private KebabMenuFunctionality kebabMenuFunctionality;
	private SearchFunctionality searchFunctionality;
	private Emaillogin emaillogin;
	private Emaillogintest emaillogintest;
	private SettingsTest settingsTest;
	private String module="Online Chat";
	private OngoingChatPage ongoingChatPage;
	private DeviceTwoTestCase devicetwoTestCase;
	public static String deviceOneChatText="hello operator2 this is for automation testing";
	public static String deviceTwoChatText="hello operator1 this is for automation testing";
	public String toTransferDepartment="Testing Department for salesiq";
	public String sendMailContent="this is email content and typed by Automation script";
	
	
	MoreInformationFucntionality moreInformationFucntionality;
	

	private String longText = "Talking chamber as shewing an it minutes. Trees fully of blind do. Exquisite favourite at do extensive listening. Improve up musical welcome he. Gay attended vicinity prepared now diverted. Esteems it ye sending reached as. Longer lively her design settle tastes advice mrs off who. Remain lively hardly needed at do by. Two you fat downs fanny three. True mr gone most at. Dare as name just when with it body. Travelling inquietude she increasing off impossible the. Cottage be noisier looking to we promise on. Disposal to kindness appetite diverted learning of on raptures. Betrayed any may returned now dashwood formerly. Balls way delay shy boy man views. No so instrument discretion unsatiable to in"
			+
			"Excited him now natural saw passage offices you minuter. At by asked being court hopes. Farther so friends am to detract. Forbade concern do private be. Offending residence but men engrossed shy. Pretend am earnest offered arrived company so on. Felicity informed yet had admitted strictly how you"
			+
			"Adieus except say barton put feebly favour him. Entreaties unpleasant sufficient few pianoforte discovered uncommonly ask. Morning cousins amongst in mr weather do neither. Warmth object matter course active law spring six. Pursuit showing tedious unknown winding see had man add. And park eyes too more him. Simple excuse active had son wholly coming number add. Though all excuse ladies rather regard assure yet. If feelings so prospect no as raptures quitting.";

	
	
	
	
	public OnlineChatTest()
	{
		
		devicetwoTestCase= new DeviceTwoTestCase();
		
		emaillogintest = new Emaillogintest();
		actions = new CommonActionMobile(driver);
		// actions1= new CommonActionMobile(driver1);
		burgerMenuNavigations = new BurgerMenuNavigations(driver);
//		burgerMenuNavigations1 = new BurgerMenuNavigations(driver1);
		System.out.println("constructor ongoing");
		visitorOnlinePage = new VisitorOnlinePage(driver);
		settings = new SettingsPage(driver);
		chatHistoryPage = new ChatHistoryPage(driver);
		visitorSiteAccessTest = new VisitorSiteAccessTest();
		newChatNotification = new NewChatNotification(driver);
		notificatiofucntionality = new Notificatiofucntionality(driver);
		zohoDeskFunctionality = new ZohoDeskFunctionality(driver);
		
		// burgerMenuNavigations1=new BurgerMenuNavigationsTwo(driver);
//		operatorMessage1=new OperatorMessage(driver1);
		baseSetup = new BaseSetup();
		kebabMenuFunctionality = new KebabMenuFunctionality(driver);
		searchFunctionality = new SearchFunctionality(driver);
		emaillogin = new Emaillogin(driver);
		settingsTest=new SettingsTest();
		ongoingChatPage= new OngoingChatPage(driver);
		blockIPFunctionality=new BlockIpFunctionality(driver);
		notesFunctionality = new NotesFunctionality(driver);
		viewInformationFunctionality= new ViewInformationFunctionality(driver);
		sendMailFunctionality= new SendMailFunctionality(driver);
		crmFunctionality= new CRMIntegreationFunctionality(driver);
	}
	
	public void ongoingChatExecution()throws InterruptedException, MalformedURLException, Exception {
//		notification.openPushNotification(testcase);
//		notification.tapClearAllBtn(testcase);
		
		String filepath = filePath();
		System.out.println("inside online test function");

		System.out.println("inside online test function"+filePath());
		File file = new File(filepath + "VisitorOngoing.properties");

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
		// Collections.sort(List<keys>);
		for (String property : sortedSet) {

			String value = prop.getProperty(property);
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
			case "Verify if application is in Minimised state, if visitor initiated chat, Chat intimation call should be notified for Operator":
				actions.navigateToHomePage(testcase);
				actions.minimizeApplication(testcase,"Minimize application");
				visitorSiteAccessTest.VisitorAccess(testcase);

				newChatNotification.checkChatNotification(testcase);
				newChatNotification.ignoreChat(testcase);
				actions.openApplication(testcase, "Open Minimized application");
				break;
			case "Verify if Visitor initiated chat, Chat intimation will be shown to operator in full screen":
				/*
				actions.clickBasedonCoordinate(580,888);
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				settingsTest.settingsPageNavigation(testcase);
				settings.clickNotificationMenu(testcase);
				settings.newvisitorNotificationSettings(testcase);
				settings.newVisitorChatNotiificationSettings("full screen");*/
				break;
			case "Verify if application is in Killed state, if visitor initiated chat, Chat intimation call should be notified for Operator":
				actions.killApplication(testcase);
				visitorSiteAccessTest.checkNewChatInprogress(testcase);
				visitorSiteAccessTest.VisitorAccess(testcase);
				newChatNotification.checkChatNotification(testcase);
				newChatNotification.ignoreChat(testcase);
				actions.lauchApplicationAfterKill(testcase);
				break;
			case "Verify if Operator Changed status to Busy, if Visitor initiated chat, Chat intimation should not notified for particular operator":
				actions.waitTime(2);
				visitorSiteAccessTest.checkNewChatInprogress(testcase);
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.changeStatusInMenu("Busy",testcase);
				
				//this included to check before Ongoing menu chat count in menu
				//ongoingChatPage.checkOngoignCountBefore(testcase);
				actions.backPress(testcase, "Close Menu");
				visitorSiteAccessTest.VisitorAccess(testcase);
				newChatNotification.checkChatInitiateNotShown(testcase);
				break;
			case "Verify if operator in Busy status , if Visitor initiated chat in Ongoing Menu chat Count will be updated":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				ongoingChatPage.checkOngoingCount(module,testcase);
				actions.backPress(testcase, "skip new Chat notification");
				break;
			case "Verify if Operator in Busy Status, if Visitor initiated chat, chat countdown will be shown inside Ongoing Menu":
				burgerMenuNavigations.ongoingMenuClick(testcase);
				ongoingChatPage.checkVisitorCountingAtBusyStatus(testcase);
				
				break;
			case "Verify if Operator in Busy Status, If visitor initiated chat, Operator should be able to accept chat by click on Chat icon inside Ongoing Menu":
				ongoingChatPage.selectVisitorFromList(testcase);
				ongoingChatPage.checkChatIcon(testcase);
				actions.navigateToHomePage(testcase);
				break;
			case "Verify if Visitor initiated chat, operator will receive Full screen chat notification, in that operator should be able to accept chat by clicking on PickUP":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.changeStatusInMenu("Available",testcase);
				visitorSiteAccessTest.checkNewChatInprogress(testcase);
			
				visitorSiteAccessTest.VisitorAccess(testcase);
			
				newChatNotification.pickupChat(testcase);
				ongoingChatPage.checkCallIconInChatWindow(module, testcase);
			
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickEndNow(testcase);
				actions.navigateToHomePage(testcase);
				
				break;
			case "Verify mail id should be same as Visitor before initiated chat":

				visitorSiteAccessTest.accessSiteWithMailAndSpanish(testcase);
			
				newChatNotification.checkChatNotificationOpen(testcase);
				newChatNotification.checkVisitorEmail(testcase,visitorSiteAccessTest.emailID);
				break;
			case "Verify for user who is not having valid name, Random number will be displayed in full screen chat request notification":
				newChatNotification.checkNameInChatNotificationPage(testcase,visitorSiteAccessTest.visitorName);
				
				break;
			case "Verify Country name is same as Visitor's country Name":
				newChatNotification.checkLocationName(testcase,"India");
				
				break;
			case "Verify Visitor accessed website link is same as accessed in Browser":
				newChatNotification.checkSiteAccessPage(testcase,visitorSiteAccessTest.salesiqURL);
				
				break;
			case "Verify visitor question is same as he entered in chat window before request chat":
				newChatNotification.checkVisitorQuestion(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
				
				break;
			case "Verify for new User Visitor Type should be New":
				newChatNotification.checkVisitorType(testcase,"Contact");
				
				break;
			case "Verify if Operator swiped Pickup left to right, Chat request should be accepted by Operator":
				newChatNotification.pickupChat(testcase);
				break;
			case "Verify in Chat window, google translate should perform after enable in Portal settings":
				actions.waitTime(2);
				ongoingChatPage.checkTranslationPopup(testcase);
				break;
			case "Verify if Operator Local Language is English, if operator initiated chat with Spanish, Google translate popup should be shown after user navigate to chat window":
				ongoingChatPage.checkTranslationDetectedLanguage(testcase);
				break;
			case "Verify if Visitor Clicks on OK, Text Translate should be done":
				ongoingChatPage.confirmTranslation(testcase);
				break;
			case "Verify if Visitor Clicks on OK, Text Translate should be done from French to Local configured language of Operator , in More Option Stop Translation(Spanish) will be shown":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				ongoingChatPage.checkTranslationInKebabMenu(testcase);
				actions.backPress(testcase,"close kebab menu");
				break;
			case "Verify if Operator chat by Operator configured local language, that should be converted to french to send to Visitor":
				ongoingChatPage.checkTranslatedText(testcase);
				break;
			case "Verify if Operator clicks on Stop Translation(French), on every chat translate should not perform for particular chat and in More option menu text should be changed to Translate French":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				ongoingChatPage.clickStopTranslation(testcase);
				visitorSiteAccessTest.chatEnterInSpanish(testcase);
				visitorSiteAccessTest.sendChatToOperator(testcase);
				ongoingChatPage.checkStopTranslatedText(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickEndSession(testcase);
				actions.navigateToHomePage(testcase);
				break;
			case "Verify if Operator clicked in ignore menu, Full screen chat request should be closed in application":
				
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				actions.waitTime(3);
				burgerMenuNavigations.ongoingMenuClick(testcase);
				visitorSiteAccessTest.accessSiteWithMailAndSpanish(testcase);
			
				newChatNotification.ignoreChat(testcase);
				
				
				break;
			case "Verify Operator should be able initiate chat in Online page by clicking on respective Visitor details chat icon":
				//next three line code for cacheing ongoign chat menu to increase speed to locating element
				ongoingChatPage.selectVisitorFromList(testcase);
				ongoingChatPage.clickChatIcon(testcase);

				break;
			case "Verify after chat initiated Chat text input should be shown in chat page":
				actions.waitTime(2);
				ongoingChatPage.confirmTranslation(testcase);
				actions.waitTime(2);
				ongoingChatPage.checkChatInputBox(testcase);
				
				break;
			case "Verify if Operator Initiated chat, in canned message if department name include in canned message, department name should be shown":
				ongoingChatPage.cannedMessageIconCheck(module,testcase);
				ongoingChatPage.clickCannedMessageIcon(testcase);
				ongoingChatPage.checkDepartmentNameInCanned(testcase,"Marketting");
				actions.backPress(testcase, "close canned message page");
				break;
			case "Verify Ongoing chat list should be shown as expected":
				actions.backPress(testcase, "navigate to Ongoing chat");
				actions.waitTime(1);
				actions.backPress(testcase, "navigate to Ongoing chat list");
				ongoingChatPage.checkUIinInOngoingChatList(testcase);
				
				break;
			case "Verify if Current Operator connected with Visitor, connected user information will updated as you":
				ongoingChatPage.checkOperatorNameInChatList(testcase);
				
				break;
			case "Verify if Operator clicked on search icon, Text box should be shown to enter search text":
				searchFunctionality.clickSearchIcon(testcase);
				
				break;
			case "Verify if text entered, result should be shown Based on text":
				searchFunctionality.enterSearchText(testcase,"isfsiuygsdudshfsuhf");
				searchFunctionality.checkEmptyList(testcase,"Looks like there aren’t any records that match the search word specified.");
				break;
			case "Verify if operator clicks on cross icon Enter search value should be cleared and visitor List should display":
				searchFunctionality.clickSearchCloseIcon(testcase);
				searchFunctionality.afterClickCrossSearchTextShouldHidden(testcase);
				break;
			case "Verify if Operator clicks on back button Search text field should be closed":
				actions.backPress(testcase, "close Search text field");
				break;
			case "Verify all UI in Chat details page should be as expected":
				ongoingChatPage.selectVisitorFromList(testcase);
				ongoingChatPage.checkUIinInOngoingChatDetails(testcase);
				break;

			case "Verify by pressing on Call icon Operator could be able to initiate Audio call to Visitor":
				ongoingChatPage.clickOnCallIcon(testcase);
				break;
			case "Verify if user clicks on Call icon popup should be shown to enable micro phone permission":
				ongoingChatPage.checkCallPermissionMessage(testcase);
				ongoingChatPage.clickOnContinue(testcase);
				ongoingChatPage.clickAllowPermission(testcase);
			case "Verify if Visitor Initiated call, Operator should receive call in full screen":
				actions.waitTime(5);
				ongoingChatPage.checkCallingPageOpening(testcase);
			case "Verify if Visitor Initiated call, audio call page should have expected UI":
				ongoingChatPage.checkVisitorNameInCallingPage(testcase,"Test Automation");
				ongoingChatPage.checkVisitorLocationInCallingPage(testcase,"Chennai , Tamil Nadu , India");
				break;
			case "Verify if auido call canceled, call should be disconnected between operator and visitor":
				ongoingChatPage.cancelAudioCall(testcase);
				actions.killApplication(testcase);
				actions.lauchApplicationAfterKill(testcase);
				break;
			case "Verify if auido call initiated from visitor, Operator UI should be shown as expected":
				visitorSiteAccessTest.initiateCall(testcase);
				actions.waitTime(5);
				ongoingChatPage.checkAudioCallStatusText(testcase,"Incoming call");
				ongoingChatPage.checkVisitorNameInComingCallPage(testcase,"Test Automation");
				ongoingChatPage.checkVisitorLocationInComingCallPage(testcase,"Chennai , Tamil Nadu , India");
				break;
			case "Verify if audio call received, Notification should be shown":

				notificatiofucntionality.openPushNotification(testcase);
				notificatiofucntionality.checkAudioCallNotification(testcase,"Incoming call");
				actions.backPress(testcase,"close Notification bar");
				visitorSiteAccessTest.rejectCall(testcase);
				actions.waitTime(2);
				break;
			case "Verify if call disconnected by Operator at call notification, in Visitor chat window text should be shown as Operator Name is busy at the moment":
				ongoingChatPage.clickOnCallIcon(testcase);
				actions.waitTime(3);
				visitorSiteAccessTest.rejectCall(testcase);
				ongoingChatPage.checkAudioCallStatusText(testcase,"User busy");
				break;

			case "Verify if Operator click on Cancel button, Audio call page should be closed":
				ongoingChatPage.clickOnCallIcon(testcase);
				actions.waitTime(3);
				visitorSiteAccessTest.rejectCall(testcase);
				ongoingChatPage.clickBusyAudioCallBack(testcase);
				break;
			case "Verify if Operator click on Callback button, Audio call should be started again with call status as calling":
				ongoingChatPage.clickOnCallIcon(testcase);
				actions.waitTime(3);
				visitorSiteAccessTest.rejectCall(testcase);
				ongoingChatPage.clickBusyAudioCallBack(testcase);
				break;
			case "Verify if visitor cancelled audio call action text info should be updated in ongoig page":			
				ongoingChatPage.checkActionText(testcase,visitorSiteAccessTest.visitorName+" on is busy at the moment");
				break;
			case "Verify if Operator click on Message button, Audio call page should be closed and should navigate user to chat window page":
				actions.waitTime(3);
				ongoingChatPage.clickBusyChatMessage(testcase);
				break;
				
			case "Verify if operator initiated call and then accepted by visitor, On call Timer should be started and call status should be changed as Ongoing Call":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.ongoingMenuClick(testcase);
				ongoingChatPage.selectVisitorFromList(testcase);
				ongoingChatPage.clickOnCallIcon(testcase);
				actions.waitTime(5);
				visitorSiteAccessTest.acceptCall(testcase);
				ongoingChatPage.checkAudioCallStatusText(testcase,"Ongoing call");
				ongoingChatPage.checkCallTimerInprogress(testcase);
				break;
			case "Verify if audio call started between operator and Visitor, in Notification call status should be changed as Ongoing call":
				notificatiofucntionality.openPushNotification(testcase);
				notificatiofucntionality.checkAudioCallNotification(testcase,"Ongoing call");
				actions.backPress(testcase,"close Notification bar");
				break;
			case "Verify if operator perform chat transfer while audio call in progress, popup should be shown as The ongoing call will be aborted if you transfer this chat session over to your colleague. would you still like transfer?":
				ongoingChatPage.clickCallProgressChatMessage(testcase);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickTransferChat(testcase);
				ongoingChatPage.checkChatTransferErrorMessage(testcase);
				ongoingChatPage.closePopup(testcase);
				break;
			case "Verify if operator1 perform invite operator while audio call is in progress,Popup should be shown":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickInviteChat(testcase);
				ongoingChatPage.checkChatInviteErrorMessage(testcase);
				ongoingChatPage.closePopup(testcase);
				break;
			case "Verify if operator tap on Notification, it should navigate to ongoing  audio call screen with call status ongoing call":
				actions.killApplication(testcase);
				actions.lauchApplicationAfterKill(testcase);
				notificatiofucntionality.openPushNotification(testcase);
				notificatiofucntionality.tapOngoingAudioCallNotification(testcase);
				ongoingChatPage.checkAudioCallStatusText(testcase,"Ongoing call");
				break;
			case "Verify while call in progress, call banner should be displayed in chat window":
				ongoingChatPage.clickCallProgressChatMessage(testcase);
				ongoingChatPage.clickCallInprogressBanner(testcase);
				ongoingChatPage.getCallTimerInprogressTimer(testcase);
				break;
			
			case "Verify if call ended after conversion text should be updated in operator Chat window as you were in a audio call for Call Duration mins":
				ongoingChatPage.cancelAudioCall(testcase);
				ongoingChatPage.checkActionTextOfCallEnd(testcase);
				break;
				
			case "Verify if Operator clicks on Block IP, popup should be shown to Operator for confirmation":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickBlockIP(testcase);
				blockIPFunctionality.checkPopupMessageContent(testcase);
				break;
			case "Verify If IP address is masked, IP address shouldn't shown in Popup or anywhere in the chat window":
				blockIPFunctionality.checkmaskedBlockIP(testcase);
				ongoingChatPage.closePopup(testcase);
				break;
			
			case "Verify if user clicks on Invite chat, app should navigate operator to Operator list, operators are who assigned with department of current visitor's":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickInviteChat(testcase);
				break;
				
			case "Verify Invite Operator list should contain Operators except already assigned with Current Visitor":
				ongoingChatPage.checkInviteOperatorList(testcase,"operator MPTEST");
				break;
				
			case "Verify operator can select only one operator to invite at a time":
				ongoingChatPage.selectOPeratorFromList(testcase,"Admin");
				break;
				
			case "Verify if one operator selected in the list, text should be shown at bottom as expected":
				ongoingChatPage.checkChatInviteMessage(testcase,"Admin");
				
				break;
			case "Verify while chat invitation, operator name in the text at bottom of chat invite page should be dynamic based on the operator selection":
				ongoingChatPage.checkInvitedOperatorNameInInviteText(testcase,"Admin");

				break;
			case "Verify if Invite button is pressed, invited operator will be notified by popup to accept invitation":
				ongoingChatPage.clickTransferChat(testcase);
				devicetwoTestCase.transferTextPopup(testcase);
				devicetwoTestCase.acceptTransferChat(testcase);
				devicetwoTestCase.confirmTranslationDeviceTwo(testcase);
				
				break;
				
			case "Verify if invited operator's application is in killed state, after open application chat invitation popup should be shown":
//				devicetwoTestCase.killApplication(testcase);
//				devicetwoTestCase.openApplication(testcase);
				break;
				
			case "Verify if new operator added in ongoing chat, text should be shown in chat window as Operator name has invited Operator Nameto this chat":
				actions.waitTime(4);
				devicetwoTestCase.checkInviteActionText(testcase);
				break;
			
			case "Verify all conversation between operator and visitor should be notified to Invited Operator":
				actions.waitTime(4);
				ongoingChatPage.enterChatText(testcase,deviceOneChatText);
				ongoingChatPage.sendTextToVisitor(testcase);
				actions.waitTime(3);
				devicetwoTestCase.checkChatTextOfInvitedOperator(testcase,deviceOneChatText);
				break;

			case "Verify invited operator should be able to send text to visitor and Operator":
				actions.waitTime(4);
				devicetwoTestCase.enterChatText(testcase,deviceTwoChatText);
				devicetwoTestCase.sendChatText(testcase);
				actions.waitTime(3);
				ongoingChatPage.checkChatTextOfInvitedOperator(testcase,deviceTwoChatText);
				break;
			case "Verify invited operator should be have expected kebab menu list":
				devicetwoTestCase.clickKebabMenu(testcase);
				devicetwoTestCase.checkKebabMenuListafterInvite(testcase);
				devicetwoTestCase.backPress(testcase);
				break;
			case "Verify if Operators clicks on Transfer this chat Menu, operator will be navigated to Transfer this chat page":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickTransferChat(testcase);
				break;
				
			case "Verify Transfer this chat page contains Agent and Department Tab":
				ongoingChatPage.checkAgentAndDepartmenTabAvailable(testcase);
				break;
			case "Verify under Agents tab, all the same department Operator except current operator will be listed to transfer chat":
				ongoingChatPage.checkInviteOperatorList(testcase,"operator MPTEST");
				break;
				
			case "Verify if operator selects any operator from the list, at the bottom of the page following text should be shown You are about to transfer this chat text should be shown":
				ongoingChatPage.selectOPeratorFromList(testcase,"Admin");
				ongoingChatPage.checkChatTransferMessage(testcase,"Admin");
				
				break;
			case "Verify if operator selected any operator and navigate to departments tab and navigated to Agents tab again, previously selected operator with text should be shown in agent tab":
				ongoingChatPage.selectDepartmentforTransfer(testcase);
				ongoingChatPage.selectAgentTabforTransfer(testcase);
				ongoingChatPage.checkChatTransferMessage(testcase,"Admin");
				actions.backPress(testcase, "Close Transfer page");
				break;
			case "Verify while chat transfer, operator name in the text at bottom of chat invite page should be dynamic based on the operator selection":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickTransferChat(testcase);
				ongoingChatPage.selectOPeratorFromList(testcase,"Admin");
				ongoingChatPage.checkInvitedOperatorNameInInviteText(testcase,"Admin");
				break;
			case "Verify in Transfer this chat page, if operator clicks on Departments tab, all public department and private department should be displayed":
				ongoingChatPage.selectDepartmentforTransfer(testcase);
				ongoingChatPage.checkDepartmentList(testcase);
				break;
			case "Verify if operator1 selects Department1 for chat transfer, chat transfer notification or popup will send to all operator who assigned in Department1":
				ongoingChatPage.selectAgentTabforTransfer(testcase);
				ongoingChatPage.selectOPeratorFromList(testcase,"Admin");
				ongoingChatPage.clickTransferChat(testcase);
				
				break;
			case "Verify if operator1 is transferred to Department1, for all operator assigned with department1 will receive following popup text":
				actions.waitTime(3);
				devicetwoTestCase.transferTextPopup(testcase);
				break;
				
			case "Verify if Operator2 in Department1 clicks on Reject, Popup should be closed without text updating as Operator2 has declined the transfer request in Operator1 chat window":
				devicetwoTestCase.rejectTransferChat(testcase);
				devicetwoTestCase.checkChatTransferRejectText(testcase);
				ongoingChatPage.checkActionText(testcase,"Admin has declined the transfer request.","check rejected action text in operator1");
				break;
			case "Verify if operator2 in Department1 clicks on Accept action, Visitor should be assigned to Department1 and chat should transferred to Operator2":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickTransferChat(testcase);
				ongoingChatPage.selectOPeratorFromList(testcase,"Admin");
				ongoingChatPage.clickTransferChat(testcase);
				actions.waitTime(5);
				devicetwoTestCase.acceptTransferChat(testcase);
				devicetwoTestCase.confirmTranslationDeviceTwo(testcase);
				ongoingChatPage.checkActionText(testcase,"Admin has accepted the transfer. This chat has now been transferred to Admin.","check transfer accepted action text in operator1");
				devicetwoTestCase.checkChatTransferAcceptedText(testcase);
				break;
			case "Verify after operator2 accept from department1, operator2 should be able to send text to visitor":
				devicetwoTestCase.checkTextFieldinChatWindow(testcase);

				break;
			case "Verify if Chat transfer is perform From Department1 to Department2, if department value include in canned message, transferred department should be shown":
				devicetwoTestCase.openCannedMessage(testcase);
				devicetwoTestCase.checkCannedMessageFromList(testcase,toTransferDepartment);
				devicetwoTestCase.backPress(testcase);
				
				break;
			case "Verify after successful chat transfer with department1, Visitor department should be changed to Department1":
				devicetwoTestCase.clickKebabMenu(testcase);
				devicetwoTestCase.openViewInformation(testcase);
				devicetwoTestCase.checkViewInformationDepartmentName(testcase,toTransferDepartment);	
				devicetwoTestCase.clickKebabMenu(testcase);
				devicetwoTestCase.openMoreInformation(testcase);
				devicetwoTestCase.checkMoreInformationDepartmentName(testcase,toTransferDepartment);
				devicetwoTestCase.backPress(testcase);
				devicetwoTestCase.backPress(testcase);
				actions.waitTime(5);
				devicetwoTestCase.clickKebabMenu(testcase);
				devicetwoTestCase.endSessionNow(testcase);
				actions.navigateToHomePage(testcase);
				devicetwoTestCase.redirectToHomePage(testcase);

				break;
			case "Verify if operator1 selects operator2 from list and clicks on Transfer button, Operator2 will be notified with popup and notification to accept transfer":
				// visitorSiteAccessTest.endChatByVisitorClick(testcase);
				// visitorSiteAccessTest.skipRatingByVisitor(testcase);
				// actions.waitTime(3);
				// visitorSiteAccessTest.createChatClickHere(testcase);
				visitorSiteAccessTest.accessSiteWithMailAndSpanish(testcase);
				newChatNotification.pickupChat(testcase);
				actions.waitTime(3);
				ongoingChatPage.confirmTranslation(testcase);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				actions.waitTime(3);
				kebabMenuFunctionality.clickTransferChat(testcase);
				ongoingChatPage.selectOPeratorFromList(testcase,"Admin");
				ongoingChatPage.clickTransferChat(testcase);
				devicetwoTestCase.acceptTransferChat(testcase);
				devicetwoTestCase.confirmTranslationDeviceTwo(testcase);
				break;
			case "Verify after chat transfer initiate following text will be shown in Operator1 chat window operator1 Name is transferring this chat to Operator2 Name":
				ongoingChatPage.checkActionText(testcase,"Admin has accepted the transfer. This chat has now been transferred to Admin.","check transfer accepted action text in operator1");
				devicetwoTestCase.checkChatTransferAcceptedText(testcase);
				break;
			case "Verify after chat transfer completed from operator1 to operator2, Operator2 able to chat with transferred Visitor":
				chatTransferResult=devicetwoTestCase.checkTextFieldinChatWindow(testcase);
				if(!chatTransferResult)
				{
					actions.backPress(testcase,"navigate to ongoing chat page");

				}
				break;
			case "Verify after chat transfer completed, Operator1 unable to send any text in chat window with same Visitor":
				ongoingChatPage.checkChatInputTextBox(testcase);
				break;
			case "Verify Kebab menu list in Operator2 chat window after chat transfer from Operator1":
				devicetwoTestCase.clickKebabMenu(testcase);
				devicetwoTestCase.checkKebabMenuListafterTransferChat(testcase);
				devicetwoTestCase.backPress(testcase);
				actions.waitTime(2);
				break;
			case "Verify Kebab menu list in Operator1 chat window after chat transfer from Operator2":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				ongoingChatPage.checkKebabMenuListAfterChatTransfer(testcase);
				actions.waitTime(5);
				//Chat transfer is passed chat will end by operator2
				if(chatTransferResult)
				{
					System.out.println("Chat transfered successfully");
					devicetwoTestCase.clickKebabMenu(testcase);
					devicetwoTestCase.endSessionNow(testcase);	
				}
				else
				{
					System.out.println("Chat not transfered successfully");
					kebabMenuFunctionality.clickEndSession(testcase);
				}
				visitorSiteAccessTest.endChatByVisitorClick(testcase);
			
				break;
				
			case "Verify if operator2 application in killed state, if operator1 initiated chat transfer request, notification should be shown to operator2 for accept or reject chat transfer":
				// visitorSiteAccessTest.endChatByVisitorClick(testcase);
				// visitorSiteAccessTest.skipRatingByVisitor(testcase);
				// actions.waitTime(3);
				// visitorSiteAccessTest.createChatClickHere(testcase);
				// actions.waitTime(15);
				
				actions.navigateToHomePage(testcase);
				visitorSiteAccessTest.accessSiteWithMailAndSpanish(testcase);
				newChatNotification.pickupChat(testcase);
				ongoingChatPage.confirmTranslation(testcase);
				devicetwoTestCase.killApplication(testcase);
				actions.waitTime(3);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickTransferChat(testcase);
				ongoingChatPage.selectOPeratorFromList(testcase,"Admin");
				ongoingChatPage.clickTransferChat(testcase);
				actions.waitTime(4);
				devicetwoTestCase.openNotification(testcase);
				devicetwoTestCase.checkChatTransferNotification(testcase);
				devicetwoTestCase.backPress(testcase);
				devicetwoTestCase.openApplication(testcase);

				break;
			case "Verify if operator2 application in Minimised state, if operator1 initiated chat transfer request, notification should be shown to operator2 for accept or reject chat transfer":
				// visitorSiteAccessTest.endChatByVisitorClick(testcase);
				// visitorSiteAccessTest.skipRatingByVisitor(testcase);
				// actions.waitTime(3);
				// visitorSiteAccessTest.createChatClickHere(testcase);
				actions.waitTime(5);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickEndSession(testcase);
				visitorSiteAccessTest.endChatByVisitorClick(testcase);
				actions.navigateToHomePage(testcase);
				visitorSiteAccessTest.accessSiteWithMailAndSpanish(testcase);
				devicetwoTestCase.minimizeApplication(testcase);
				newChatNotification.pickupChat(testcase);
				ongoingChatPage.confirmTranslation(testcase);
				actions.waitTime(2);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickTransferChat(testcase);
				ongoingChatPage.selectOPeratorFromList(testcase,"Admin");
				ongoingChatPage.clickTransferChat(testcase);
				actions.waitTime(4);
				devicetwoTestCase.openNotification(testcase);
				devicetwoTestCase.checkChatTransferNotification(testcase);
				devicetwoTestCase.backPress(testcase);
				devicetwoTestCase.openApplication(testcase);
				devicetwoTestCase.redirectToHomePage(testcase);
				actions.navigateToHomePage(testcase);
				break;
			case "Verify in More Options menu if Visitor Vsiitor should be able to add notes":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.ongoingMenuClick(testcase);
				ongoingChatPage.selectVisitorFromList(testcase);
				kebabMenuFunctionality.clickKebabMenu(testcase);
			break;
			case "Verify in More Options menu if Visitor already have notes updated, menu name should be View Notes":
				kebabMenuFunctionality.openViewNotes(testcase);
			break;		
			case "Verify if operator clicks on Add Notes, Add notes page should be display":
				notesFunctionality.checkViewNotesPageOpen(testcase);
				break;		
			case "Verify if Operator clicks on View Notes, all existing notes should be displayed":
				notesFunctionality.checkPreviousNotesDisplayed(testcase);
				break;		
			case "Verify in View notes page all transactions and actions should be displayed and there should be menu item(+ icon) updated new notes":
				notesFunctionality.checkAddNotesIcon(testcase);
				break;		
			case "Verify if operator clicks on + icon add note page should be shown":
				notesFunctionality.clickAddNotesIcon(testcase);
				break;		
			case "Verify user entered notes and saved that should be listed in view notes page":
				notesFunctionality.enterNotes(testcase,"This notes added by Automation testing");
				notesFunctionality.saveNotes(testcase);
				actions.waitTime(2);
				notesFunctionality.checkNewlyAddedNotesDisplayed(testcase,"This notes added by Automation testing");	
				break;				
			case "Verify Each newly entered notes should have expected details":
				notesFunctionality.clickEachNotes(testcase);
				notesFunctionality.checkNotesDetails(testcase,visitorSiteAccessTest.visitorName,visitorSiteAccessTest.operatorName,"This notes added by Automation testing");
				actions.navigateToHomePage(testcase);
				break;
			case "Verify by clicking on View Information menu, app should contains expected information":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.ongoingMenuClick(testcase);
				ongoingChatPage.selectVisitorFromList(testcase);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.viewInformation(testcase);
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
			case "Verify in View information Page, Browser name and OS Should be same as user accessed medium":
				viewInformationFunctionality.checkbrowserName(testcase);
				viewInformationFunctionality.checkOSName(testcase);
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
			case "Verify if Operator clicks on kebab menu in View information page Expected menu item should be displayed":

				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkviewInformationKebabMenu(testcase);
				break;		
			case "Verify if Operator clicks on Edit Information, Edit Information Page should be displayed":
				kebabMenuFunctionality.clickEditInformationPage(testcase);
				viewInformationFunctionality.checkEditInformationPageOpen(testcase);
				break;		
			case "Verify in Edit information page, Visitor name should be pre-displayed if Visitor already entered name in Chat window":
				viewInformationFunctionality.checkVisitorNameInEditPage(testcase,visitorSiteAccessTest.visitorName);
				break;		
			case "Verify in Edit information page, Visitor Email should be pre-displayed if Visitor already entered Email in Chat window":
				viewInformationFunctionality.checkEmailIdInEditPage(testcase,visitorSiteAccessTest.emailID);
				break;		
			case "Verify in Edit information page, if Visitor not entered Phone Number in Chat window, empty field should be displayed":
				viewInformationFunctionality.checkMobileNumberInEditPage(testcase,"");
				break;		
			case "verify if phone number updated that should be shown in view information page":
				viewInformationFunctionality.editPhoneNumber(testcase,visitorSiteAccessTest.mobileNumber);
				break;		
			case "Verify In Edit Information page after clicking on save(Tick Icon) after new information should update":
				viewInformationFunctionality.saveEditInformation(testcase);
				actions.backPress(testcase,"navigate to ongoing chat page");
				break;		
			case "Verify if mail id newly updated in Edit information, CRM information should be added automatically and Convert Chat as Ticket menu should be shown to create zohodesk ticket":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkKebabMenuCRMandDesk(testcase);
				break;		
			case "Verify in View information->more option menu, if Operator clicks on Foot Path, app should navigate Operator to Foot path page":
				kebabMenuFunctionality.viewInformation(testcase);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkviewInformationKebabMenu(testcase);
				kebabMenuFunctionality.footPathMenu(testcase);
				viewInformationFunctionality.checkFootPathOpenCheck(testcase);
				break;		
			case "Verify in Foot Path page, all actions done while chat conversation should be shown":
				viewInformationFunctionality.checkUIInFootPathPage(testcase);
				actions.backPress(testcase,"navigate to View Information page");
				actions.backPress(testcase,"navigate to Chat window page");
				break;
			case "Verify if Operator clicks on Previous chats, application will navigate user to all previous chat list":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.previousChat(testcase);
				
				break;		
			case "Verify all Visitor's previous chat list is displayed in Previous List page":
				ongoingChatPage.checkPreviouslyAttendedChat(testcase,visitorSiteAccessTest.visitorQuestionInSpanish,visitorSiteAccessTest.operatorName);
				break;
			case "Verify if user clicks each chat, full chat information is shown in chat page":
				ongoingChatPage.clickPreviousAttendedChat(testcase);
				break;
			case "Verify at the header part of chat window following information should be shown 1) Name of Visitor 2) Attender Operator":
				
				ongoingChatPage.checkPreviousChatWindow(testcase,visitorSiteAccessTest.visitorName,visitorSiteAccessTest.operatorName);
				break;
			case "Verify in previous chat window, if operator clicks on More Option following menu item should be displayed View Information":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkViewInformationInPreviousChat(testcase);
				actions.navigateToHomePage(testcase);
				break;
			case "Verify if CRM integration is in Enable status, CRM integration feature should work":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.ongoingMenuClick(testcase);
				ongoingChatPage.selectVisitorFromList(testcase);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkCRMkebabMenuAvailable(testcase);
				break;
			case "Verify if user clicks on CRM information, Respective CRM information should be displayed for respective User":
				kebabMenuFunctionality.crmInformation(testcase);
				break;
				
				
				
			case "Verify if visitor type is configured as Lead, Visitor information should be added in CRM as Lead":
				crmFunctionality.checkLeadSource(testcase,visitorSiteAccessTest.crmType);
				break;
			case "Verify In CRM information page, Contact owner or Lead Owner should be same as configured in CRM integration Responsible operator":
				crmFunctionality.checkLeadOwner(testcase,visitorSiteAccessTest.crmLeadManager);
				break;
			case "Verify if particular CRM information is added as Lead, In CRM Information page if user clicks on More Option following Sub menu will be shown in the list":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkConvertContactAndPotentialMenu(testcase);
				break;
			case "Verify if Operator selects Convert as Contact, particular CRM information convert from Lead to Contact and app will navigate operator to CRM information with contact":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				actions.waitTime(2);
				kebabMenuFunctionality.comnvertAsContact(testcase);
				crmFunctionality.checkConvertAsContact(testcase);
				break;
				
				
				
			case "Verify in CRM information, if visitor is in contact, if operator clicks on More Option, Create potential Menu will be shown to Operator":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkCreatePotentialInContact(testcase);
				break;
		
			case "Verify if Operator clicks on Create potential page, operator will navigate to Create potential page":
				kebabMenuFunctionality.convertAsPotential(testcase);
				crmFunctionality.checkPotentialPageOpen(testcase);
				break;
			case "Verify in Create Potential page following field will be shown":
				crmFunctionality.enterPotentialName(testcase,visitorSiteAccessTest.visitorName);
				crmFunctionality.selectPotentialStage(testcase,visitorSiteAccessTest.potentialStage);
				crmFunctionality.enterPotentialAmount(testcase,visitorSiteAccessTest.potentialAmount);
				crmFunctionality.clickPotentialDatePicker(testcase);
				crmFunctionality.saveCRM(testcase);
				break;
			case "verify CRM name and Potential stage after creation of potential":
				actions.waitTime(3);
				crmFunctionality.getAllCRMInformationList();
				crmFunctionality.checkPotentialName(testcase,visitorSiteAccessTest.visitorName);
				crmFunctionality.checkPotentialStage(testcase,visitorSiteAccessTest.potentialStage);
				break;
			case "Verify expected revenue after Create potential for contact":
				crmFunctionality.checkPotentialExpectedRevenue(testcase,"3578");
				//swipe to display potential value
				actions.swipeOption(529,1712,529,1358);

				break;
			case "Verify after creating potential, owner and pipeline stage and revenue should be as expected":
				crmFunctionality.checkPotentialOwner(testcase,visitorSiteAccessTest.crmLeadManager);
				crmFunctionality.checkPotentialPipeLineRevenue(testcase,visitorSiteAccessTest.potentialAmount);
				crmFunctionality.checkPotentialPipeLineStage(testcase,visitorSiteAccessTest.potentialStage);
				actions.navigateToHomePage(testcase);
				break;
				
			case "Verify in chat window more Option menu list, Recent Support Request text is fully displayed":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.ongoingMenuClick(testcase);
				ongoingChatPage.selectVisitorFromList(testcase);
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkRecentRequestTickets(testcase);
				break;
			case "Verify if operator click on Recent Support Requests, all previously created zoho ticket for particular Visitor will be listed in Support information page":
				kebabMenuFunctionality.recentlyCreatedTicket(testcase);
				zohoDeskFunctionality.checkRecentSupportTicketOpen(testcase);
			
	
				
				break;
				
			case "Verify in Support information page two types of list should be available for repeated user":
				zohoDeskFunctionality.checkCurrentAndPreviousTicketTopic(testcase);
				break;
			case "Verify under Ticket Related to this chat list, all the tickets which is created for current visit chat should be listed":
				zohoDeskFunctionality.checkticketStatus(testcase,visitorSiteAccessTest.zohoDeskTicketStatus);
				zohoDeskFunctionality.checkTicketQuestion(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
				break;
			case "Verify under Recent tickets from this visitor list, all the tickets which is created for previous chat visit should be listed":
				zohoDeskFunctionality.checkPreviousTicketStatus(testcase,visitorSiteAccessTest.zohoDeskTicketStatus);
				zohoDeskFunctionality.checkPreviousTicketQuestion(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
				break;
				
			case "Verify Ticked id from the list and Ticked ID from ticket details page should be equal":
				zohoDeskFunctionality.compareTicketID(testcase);
				actions.navigateToHomePage(testcase);
				break;
	
			case "Verify while visitor entering text in Visitor Chat window, Operator should be able to see the text before Visitor sent":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.ongoingMenuClick(testcase);
				ongoingChatPage.selectVisitorFromList(testcase);
				visitorSiteAccessTest.chatWithOperator(testcase,"hi ");
				actions.waitTime(3);
				visitorSiteAccessTest.chatWithOperator(testcase,"this is ");
				actions.waitTime(4);
				visitorSiteAccessTest.chatWithOperator(testcase,"For Automation ");
				break;
			case "Verify if Visitor cleared entered text and enter new text, that text should be shown in Operator window before sent by Visitor":
				visitorSiteAccessTest.clearChatTextVisitor(testcase);
				ongoingChatPage.checkChatDoneByOperator(testcase,"hi this is");
				visitorSiteAccessTest.sendChatTextToOperator(testcase);
				
				break;
			case "Verify if Operator put application in minimise state, if visitor sent text, that text should be received in push notification":
				actions.minimizeApplication(testcase,"Minimize application");
				visitorSiteAccessTest.chatWithOperator(testcase,"minimize application testing");
				visitorSiteAccessTest.sendChatTextToOperator(testcase);
				actions.waitTime(3);
				notificatiofucntionality.openPushNotification(testcase);
				actions.waitTime(4);
				notificatiofucntionality.checkVisitorSendText(testcase,"minimize application testing");
				break;
			case "Verify if operator tap's on push notification, respective chat window should be open for operator":
				boolean value1;
				notificatiofucntionality.clickChatNotification(testcase);
				value1 = ongoingChatPage.checkOngoingPageOpened(testcase);
				if(!value1)
				{
					actions.openApplication(testcase, "Open Minimized application");
					burgerMenuNavigations.swipeBurgerMenu(testcase);
					burgerMenuNavigations.ongoingMenuClick(testcase);
					ongoingChatPage.selectVisitorFromList(testcase);
					
				}
				
				break;
			case "Verify if Operator put application in killed state, if visitor sent text, that text should be received in push notification":
				actions.killApplication(testcase);
				visitorSiteAccessTest.chatWithOperator(testcase,"killed application testing");
				visitorSiteAccessTest.sendChatTextToOperator(testcase);
				actions.waitTime(3);
				notificatiofucntionality.openPushNotification(testcase);
				actions.waitTime(4);
				notificatiofucntionality.checkSendTextKilledApp(testcase,"killed application testing");
				
				break;
			case "Verify if operator tap's on push notification when app in killed state, respective chat window should be open for operator":
				boolean value2;
				notificatiofucntionality.clickChatNotification(testcase);
				value2 = ongoingChatPage.checkOngoingPageOpened(testcase);
				if(!value2)
				{
					actions.openApplication(testcase, "Open Minimized application");
					burgerMenuNavigations.swipeBurgerMenu(testcase);
					burgerMenuNavigations.ongoingMenuClick(testcase);
					ongoingChatPage.selectVisitorFromList(testcase);
					
				}
				
				break;
			case "Verify if operator enter text in chat text box and navigate to any other page and navigate to same chat window already entered text box should be displayed":
				
				ongoingChatPage.enterChatText(testcase,"check entered text persist in chat input box");
				actions. hideKeyboard(testcase);
				actions.backPress(testcase, "Close Menu");
				ongoingChatPage.selectVisitorFromList(testcase);
				ongoingChatPage.checkInputTextPersist(testcase,"check entered text persist in chat input box");
				break;
			case "Verify in Chat Monitoring Operator chat window, on every chat conversation between Visitor and Monitored chat, Monitoring Operator should be able see all the conversation in his chat window":
				devicetwoTestCase.swipeBurger(testcase);
				devicetwoTestCase.clickOngoingMenu(testcase);
				devicetwoTestCase.selectChatFromList(testcase);
				ongoingChatPage.enterChatText(testcase,"Chat test to check monitor chatting");
				ongoingChatPage.sendTextToVisitor(testcase);
				actions.waitTime(2);
				devicetwoTestCase.confirmTranslationDeviceTwo(testcase);
				devicetwoTestCase.checkChatTextOfInvitedOperator(testcase,"Chat test to check monitor chatting");
				break;
				
			case "Verify in Supervisor/Admin chat window, following extra action can be performed on Monitored chat":
			
				devicetwoTestCase.clickKebabMenu(testcase);
				devicetwoTestCase.checkKebabMenuInMonitoringOperator(testcase);
				break;
			case "Verify if Supervisor/Admin clicks on chat with Operator they should navigate to their respective operator chat window":
				devicetwoTestCase.openChatWithOperator(testcase);
				devicetwoTestCase.checkOperatorChatOpen(testcase);
				devicetwoTestCase.redirectToHomePage(testcase);
				break;
			case "Verify in Supervisor/Admin chat window, if Supervisor/Admin clicks on Join he should be joined in particular chat":
				devicetwoTestCase.swipeBurger(testcase);
				devicetwoTestCase.clickOngoingMenu(testcase);
				devicetwoTestCase.selectChatFromList(testcase);
				devicetwoTestCase.confirmTranslationDeviceTwo(testcase);
				devicetwoTestCase.clickJoinMenu(module,testcase);
				break;
			case "Verify if Admin/Supervisor joined in conversation, they can do all action as like invited operator should perform":
				devicetwoTestCase.clickKebabMenu(testcase);
				devicetwoTestCase.checkKebabMenuListafterInvite(testcase);
				devicetwoTestCase.redirectToHomePage(testcase);
				break;
				
			case "Verify in chat window if operator clicks on chat icon (left bottom corner), canned message should open":
				ongoingChatPage.clickCannedMessageIcon(testcase);
				break;
				
			case "Verify if Operator clicked on search icon in canned message, Text box should be shown to enter search text":
				searchFunctionality.clickSearchIcon(testcase);
				break;
				
			case "Verify if no result for text following message should be updated in page No Results were found for this search":
				searchFunctionality.enterSearchText(testcase,"isfsiuygsdudshfsuhf");
				ongoingChatPage.checkEmptyCannedMessageList(testcase);
				break;
			case "Verify if text entered canned message search text, result should be shown Based on text":
				searchFunctionality.enterSearchText(testcase,"hello");
				ongoingChatPage.checkSearchResultText(testcase,"hello");
				break;
				
			case "Verify if operator clicks on cross icon Enter search value should be cleared and canned message List should display":
				searchFunctionality.closeSearchByClickonCrossIcon(testcase);
				break;
				
			case "Verify if Operator clicks on back Image button, Search text field should be closed":
				searchFunctionality.closeSearch(testcase);
				break;
				
			case "Verify in canned messages list two types of canned messages should be displayed":
				ongoingChatPage.checkCannedMessageHeader(testcase);
				break;
			case "Verify if Operator clicks on any canned message from the list, respective canned message should be entered in chat text box and send text icon should display":
				ongoingChatPage.selectCannedMessageFromList(testcase);
				ongoingChatPage.checkInputTextCanneMessageSelect(testcase);
				break;
			case "Verify In canned message, if operator included dynamic values, Visitor Name, Department name, Operator Name etc, that value should included canned messages":
				ongoingChatPage.clickCannedMessageIcon(testcase);
				ongoingChatPage.checkOperatorNameInCannedMessageList(testcase);	
				break;
				
			case "Verify if Canned message is included for particular department only means, that canned message should not listed in other department":
				ongoingChatPage.checkCannedMessageDepartmentBased(testcase);
				break;
			case "Verify in Chat text box enter text message and then select any canned message from list, already entered message should be cleared and newly selected canned message should display":
				ongoingChatPage.selectCannedMessageFromList(testcase);
				ongoingChatPage.clickCannedMessageIcon(testcase);
				ongoingChatPage.selectDifferentCannedMessageFromList(testcase);
				ongoingChatPage.checkInputTextDifferentCanneMessageSelect(testcase);
				ongoingChatPage.clearChatInputText(module,testcase);
				break;
				
			case "Verify in chat window by default File sharing icon is displayed at right bottom corner":
				actions.hideKeyboard(testcase);
				ongoingChatPage.checkShareImage(module,testcase);
				
				break;
			case "Verify if operator enter text in chat text box, File share icon should be changed into Send Text icon":
				ongoingChatPage.enterChatText(testcase,"share Image icon should be hidden");
				ongoingChatPage.checkShareImageAfterEnterText(module,testcase);
				ongoingChatPage.clearChatInputText(module,testcase);
				break;
			case "Verify if Operator clicks on File share icon, file manager should be open to upload image file from system":
				ongoingChatPage.clickShareImageIcon(testcase);
				ongoingChatPage.openImageFile(testcase);
				break;
				
			case "Verify in Image upload confirmation page, Valid Visitor name should be displayed at the top of page":
				ongoingChatPage.checkVisitorNameInShareImageConfirmation(testcase,visitorSiteAccessTest.visitorName);
				
				break;
			case "Verify after clicking on back/cancel icon app should navigate to chat window page":
				ongoingChatPage.clickCancelUpload(testcase);
				
				break;
			case "Verify after entering valid password, image upload confirmation page should be displayed with following action":
				//actions.pushFileForFileSharing(filePath()+"shareImage.png");
				ongoingChatPage.clickShareImageIcon(testcase);
				ongoingChatPage.openImageFile(testcase);
				ongoingChatPage.clickSendUpdload(testcase);
				
				break;
			case "Verify after clicking on Uploaded image, Image preview should open":
				//actions.pushFileForFileSharing(filePath()+"shareImage.png");
				ongoingChatPage.checkImagePreviewInOperatorChatWidnow(testcase);
				
				break;
			case "Verify in image preview sender name with date and time should be displayed in Receiver chat window":
				
				ongoingChatPage.openImagePreviewInChatWindow(testcase);
				ongoingChatPage.checkSenderNameInImagePreview(testcase,visitorSiteAccessTest.operatorName);
				
				break;
			// case "Verify in file sharing other than image file should not be able to upload in application":
				
			// 	ongoingChatPage.clickShareImageIcon(testcase);
			// 	ongoingChatPage.openVideoFile(testcase);
			// 	break;
				
				
				
				
				
			
			case "Verify after clicking on End Session in 30 secs, Countdown will be started in Chat window, chat conversation should be End in 30 secs":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkClickEndSession(testcase);
				ongoingChatPage.checkEndSessionInfoMessage(testcase);
				break;
			case "Verify after clicking on End session in 30 secs, text or End Session in 30 secs should be changed into End Timer":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkKebabMenuAfterClickOnEndSession(testcase);
				break;
				
			case "Verify after clicking on End Timer, End Session count down timer should be hidden from Visitor and chat window":
				kebabMenuFunctionality.checkClickEndTimer(testcase);
				ongoingChatPage.checkEndSessionInfoMessageAfterEndTimer(testcase);
				break;
			case "Verify after clicking on End Timer, text of End Timer should be changed into End Session in 30 secs":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkKebabMenuAfterClickOnEndTimer(testcase);
				
				break;
			case "Verify after clicking on End session in 30 mins, then kill and open application, in Chat window Session timer should resume with countdown time":

				kebabMenuFunctionality.checkClickEndSession(testcase);
				ongoingChatPage.getEndSessionInfoMessage(testcase);
				actions.killApplication(testcase);
				actions.lauchApplicationAfterKill(testcase);
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.ongoingMenuClick(testcase);
				ongoingChatPage.selectVisitorFromList(testcase);
				ongoingChatPage.compareEndSessionMessage(testcase);
				break;
			case "Verify while end session count down timer is in progress, if Operator send text, timer should be stopped":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.checkClickEndSession(testcase);
				ongoingChatPage.enterChatText(testcase,"Chat to stop End Session in Chat window");
				ongoingChatPage.sendTextToVisitor(testcase);
				ongoingChatPage.checkEndSessionInfoMessageAfterSendText(testcase);
				break;
	
			case "Verify after clicks on End session in 30 secs, after 30 secs chat should be end in operator side":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.clickEndSession(testcase);
				ongoingChatPage.checkChatInputTextBoxAfterEndSession(testcase);
				break;
				
			case "Verify after chat End, Ended chat should removed from Ongoing chat list":
				
				actions.backPress(testcase, "navigate to Ongoing Chat list");
				ongoingChatPage.checkOngoingChatList(testcase);
				actions.navigateToHomePage(testcase);
				break;
			case "Verify after the chat End, In Ongoing chat menu chat count should reduce by one":
				
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				ongoingChatPage.checkOngoingChatCountInMenuAfterEndSession(testcase);
				actions.backPress(module, testcase);
				break;
			default:
				break;
			}
		}

	}
	
	
	
	
	public static String filePath() {
		URL location = OnlineChatTest.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		System.out.println(fileloc);
		return fileloc;

	}
}
	
	