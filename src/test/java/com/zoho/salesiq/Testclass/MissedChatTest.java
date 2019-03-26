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
 



public class MissedChatTest extends BaseSetup{

	MissedChatPage missedChatPage;
	VisitorSiteAccessTest visitorSiteAccessTest;
	BurgerMenuNavigations burgerMenuNavigations;
	Notificatiofucntionality notification;
	CommonActionMobile actions;
	CommonActionMobile actions1;
	SearchFunctionalityTest searchFunctionalityTest;
	SearchFunctionality searchFunctionality;
	KebabMenuFunctionality kebabMenuFunctionality;
	private String module = "Missed Chat page";
	private String searchName = "Automation";
	NotesFunctionality notesFunctionality;
	public String newNotes = "Automation new notes enter";
	BlockIpFunctionality blockIpFunctionality;
	ViewInformationFunctionality viewInformationFunctionality;
	public static String editedEmail = "";
	public String editedPhone="9898789878";
	SendMailFunctionality sendMailFunctionality;
	public String missedTime;
	public String editedName="Testing Automation";
	private ChatHistoryPage chatHistoryPage;
	private CRMIntegreationFunctionality crmIntegreationFunctionality;
	private String crmCompanyName="Automation SalesiqCRM";
	private String crmleadPhoneNumber="9898789890";
	private String crmLeadStatus="Contact in Future";
	public String crmLeadManager="mr.anbarasu10";
	private String potentialStage="Needs Analysis";
	private String potentialAmount="17890";
	private ZohoDeskFunctionality zohoDeskFunctionality;
	private String zohodeskPriority="High";
	private String zohoDeskClassification="Problem";
	private Emaillogintest emaillogintest;
	private  DeviceTwoTestCase devicetwoTestCase;
	
	
	MoreInformationFucntionality moreInformationFucntionality;
	

	private String longText = "Talking chamber as shewing an it minutes. Trees fully of blind do. Exquisite favourite at do extensive listening. Improve up musical welcome he. Gay attended vicinity prepared now diverted. Esteems it ye sending reached as. Longer lively her design settle tastes advice mrs off who. Remain lively hardly needed at do by. Two you fat downs fanny three. True mr gone most at. Dare as name just when with it body. Travelling inquietude she increasing off impossible the. Cottage be noisier looking to we promise on. Disposal to kindness appetite diverted learning of on raptures. Betrayed any may returned now dashwood formerly. Balls way delay shy boy man views. No so instrument discretion unsatiable to in"
			+
			"Excited him now natural saw passage offices you minuter. At by asked being court hopes. Farther so friends am to detract. Forbade concern do private be. Offending residence but men engrossed shy. Pretend am earnest offered arrived company so on. Felicity informed yet had admitted strictly how you"
			+
			"Adieus except say barton put feebly favour him. Entreaties unpleasant sufficient few pianoforte discovered uncommonly ask. Morning cousins amongst in mr weather do neither. Warmth object matter course active law spring six. Pursuit showing tedious unknown winding see had man add. And park eyes too more him. Simple excuse active had son wholly coming number add. Though all excuse ladies rather regard assure yet. If feelings so prospect no as raptures quitting.";

	public MissedChatTest()
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
	viewInformationFunctionality=new ViewInformationFunctionality(driver);
	sendMailFunctionality=new SendMailFunctionality(driver);
	moreInformationFucntionality=new MoreInformationFucntionality(driver);
	chatHistoryPage=new ChatHistoryPage(driver);
	crmIntegreationFunctionality=new CRMIntegreationFunctionality(driver);
	zohoDeskFunctionality=new ZohoDeskFunctionality(driver);
	emaillogintest = new Emaillogintest();
	devicetwoTestCase= new DeviceTwoTestCase();
	}

	
	public void missedChatExecution() throws InterruptedException, MalformedURLException, Exception {
		String filepath = filePath();
// 		System.out.println(filepath);

		File file = new File(filepath + "MissedChat.properties");

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
		case "Login User":
				//LOGGER.info("Loging user1");
				
				
				emaillogintest.loginUser(testcase);
				
				//LOGGER.info("Loging user2");
				devicetwoTestCase.DeviceTwoLogin(testcase);
				
				
		break;

		case "Verify if new chat is missed by operator, operator should be notified by notification":
			actions.navigateToHomePage(testcase);

		visitorSiteAccessTest.VisitorAccess(testcase);
		//this method should call with param to maintain wait until chat missed
		visitorSiteAccessTest.checkNewChatInprogress(testcase);
		missedTime=actions.getCurrentTime();
		actions.waitTime(2);
		notification.openPushNotification(testcase);
		actions.waitTime(1);
		notification.checkNotifcationType(testcase,"Missed Chat");
		break;

		case "verify visitor name should be displayed in notification":
		notification.checkNotifcationText(testcase,visitorSiteAccessTest.visitorQuestion);
		actions.backPress(testcase, "close notification Bar");
		break;

		case "Verify Empty missed chat list is empty based on serach value":
		actions.waitTime(2);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.checkEmptyPageText(testcase,"No missed visitors found for you!");
		break;

		case "Verify each missed chat list should be equal to expected result":
		missedChatPage.checkMissedChatListUI(testcase);
		break;

		case "Verify Search icon displayed in Missed chat list page":
		searchFunctionality.clickSearchIcon(testcase);
		break;
		case "Verify if search result not found, empty message should be shown in missed chat list page":
		searchFunctionality.enterSearchText(testcase,"isfsiuygsdudshfsuhf");
		searchFunctionality.checkEmptyList(testcase,"Looks like there aren't any records that match the search word specified.");
		break;

		case "Verify search icon should be closed after clicks on cross symbol":
		searchFunctionality.closeSearchByClickonCrossIcon(testcase);
		break;

		case "Verify search result should be shown based on search value":
		searchFunctionality.enterSearchText(testcase,"Automation");
		searchFunctionality.checkSearchResultText(testcase,"Automation");
		break;

		case "Verify visitor name in search result should be as expected result":
		searchFunctionality.clickSearchIcon(testcase);
		searchFunctionality.enterSearchText(testcase,"Automation");
		missedChatPage.visitorNameCheckinMissedChatList(testcase,"Testing Automation");
		break;
		case "Verify vsitor question should be same as visitor entered while create chat":
		missedChatPage.visitorQuestionCheckinMissedChatList(testcase,visitorSiteAccessTest.visitorQuestion);
		break;

		case "Verify in missed chat list page if chat is not assigned to any operator particular chat status should be yet to assigned":
		missedChatPage.visitorAssigneeCheckinMissedChatList(testcase,"Yet to assign");
		actions.navigateToHomePage(testcase);
		break;
		case "Verify if operator clicks on any missed chat from list, it should navigate operator to missed chat details page":
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		missedChatPage.missedDetailsPageOpencheck(testcase);
		break;

		case "Verify missed chat details UI should be as expected":
		missedChatPage.missedChatDetailsUiCheck(testcase);
		break;

		case "Verify in Missed chat details page, visitor Name is same as entered in chat window":
		missedChatPage.checkVisitornNameinMissedDetailsPage(testcase,visitorSiteAccessTest.visitorName);
		break;
		case "Verify in Missed chat details page, visitor question is same as entered in chat window":
		missedChatPage.checkVisitorQuestioninMissedDetails(testcase,visitorSiteAccessTest.visitorQuestion);
		break;
		case "Verify kebab menu without visitor enter mail id":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		missedChatPage.checkKebabMenuwithoutMailid(testcase);
		break;

		case "Check Assign Operator name list for missed chat":
		kebabMenuFunctionality.selectMenuFroMKebab("Assign Operator",testcase);
		missedChatPage.checkAssignOperatorList(testcase);
		actions.navigateToHomePage(testcase);
		break;

		case "Verify Add a note is displayed in kebab menu":
		actions.waitTime(1);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("Add a Note",testcase);
		
		break;

		case "Verify after clicks Add a note from kebeb menu, add a note page should be displayed":
		notesFunctionality.checkAddNotesPageOpen(testcase);
		break;

		case "Verify Visitor name is displayed in Add a note should be same as visitor entered in chat window":
		notesFunctionality.visitorNameInAddNotesPage(testcase);
		break;

		case "Verify operator should be able to enter and add notes":
		notesFunctionality.enterNotes(testcase,newNotes);
		notesFunctionality.saveNotes(testcase);
		actions.waitTime(3);
		break;

		case "Verify after adde new notes, In kebab menu add notes should be changed as View notes":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("View Notes",testcase);
		break;

		case "Verify after clicks on View notes, view notes page should be opened":
		notesFunctionality.checkViewNotesPageOpen(testcase);
		break;

		case "Verify visitor name should be displayed in view notes should be same as expected name":
		notesFunctionality.visitorNameInViewNotesPage(testcase);
		break;
		case "Verify view notes history":
		notesFunctionality.checkNotesHistory(testcase,"Note added by "+visitorSiteAccessTest.operatorName);
		break;
		case "Verify in view notes should be same as operator entered and saved notes":
		notesFunctionality.checkNotesinViewNotes(testcase,newNotes);
		break;
		case "Verify in view notes page, Add icon should be displayed if operator click on Icon should navigate to Add notes page":
		notesFunctionality.clickAddNotesIcon(testcase);
		notesFunctionality.checkAddNotesPageOpen(testcase);
		actions.hideKeyboard(testcase);
		actions.backPress(testcase, "navigate to View notes page");
		break;

		case "Verify if operator clicks on each notes, Notes details page should be displayed and expected UI should be avialable":
		notesFunctionality.clickEachNotes(testcase);	
		notesFunctionality.checkNotesDetails(testcase,visitorSiteAccessTest.visitorName,visitorSiteAccessTest.operatorName,newNotes);
		notesFunctionality.checkAddNotesIcon(testcase);
		actions.navigateToHomePage(testcase);
		break;

		case "Verify in missed chat Assign operator page expected operator should be listed":
		actions.waitTime(1);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("Assign Operator",testcase);
		missedChatPage.checkAssignOperatorList(testcase);
		break;

		case "Verify if oeprator assigned missed chat to himself by clicking on You, that missed chat should be assigned to same operator":
		missedChatPage.assigNewOperator(testcase,"You");
		missedChatPage.checkAssignedOperatorName(testcase,"Assigned to operator MPTEST");
		actions.backPress(testcase, "navigate to missed chat list page");
		break;

		case "Verify after operator assigned, assinged oeprator name should be displayed in missed chat list":
		missedChatPage.visitorAssigneeCheckinMissedChatList(testcase,"You");
		actions.navigateToHomePage(testcase);
		break;

		case "Verify in Kebab menu Block IP menu item should be displayed":
		actions.waitTime(2);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("Block IP",testcase);
		break;
		case "Verify if oeprator clicks on block ip, expected text should be displayed in Popup":
		blockIpFunctionality.checkBlockIPTitle(testcase);
		blockIpFunctionality.checkPopupMessageContent(testcase);
		break;

		case "Verify if IP is masked in salesiq Admin portal, visitor IP address shouldnot be displayed in Block IP Popup":
		blockIpFunctionality.checkmaskedBlockIP(testcase);
		break;

		case "Verify in Block Ip popup, if operator clicks on cancel popup should be closed":
		blockIpFunctionality.clickBlockIpCancel(testcase);
		actions.navigateToHomePage(testcase);
		break;

		case "verify in missed chat Kebab menu, View information page should be displayed":
		actions.waitTime(2);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("View Information",testcase);
		break;

		case "verify If operator clicks on View information menu, view information page should be displayed":
		viewInformationFunctionality.checkViewInformationPageOpen(testcase);
		break;

		case "Verify in View information page, All Information should be as expected":
		viewInformationFunctionality.checkVisitorName(testcase);
		viewInformationFunctionality.checkIpAddresInViewInformation(testcase);
		viewInformationFunctionality.checkCountryName(testcase);
		viewInformationFunctionality.checkDepartmentName(testcase);
		viewInformationFunctionality.checkSalesiqURL(testcase);
		viewInformationFunctionality.checkbrowserName(testcase);
		viewInformationFunctionality.checkOSName(testcase);
		actions.navigateToHomePage(testcase);
		break;

		case "Verify in view information kebab menu expected menu items should be displayed":
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("View Information",testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		viewInformationFunctionality.checkViewInformationKebabMenu(testcase);
		break;

		case "Verify in View information page edit information page should be displayed and if user clicks on edit information, edit information page should be displayed":
		kebabMenuFunctionality.selectMenuFroMKebab("Edit Information",testcase);
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

		case "Verify after updated visitor information, keabab menu should be updated":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		viewInformationFunctionality.checkNewMenuAddedafterupdateMail(testcase);
		break;

		case "Verify after updated visitor information, Visitor information should be updated in View information page":
			
		kebabMenuFunctionality.selectMenuFroMKebab("View Information",testcase);
		viewInformationFunctionality.checkEmailIdandPhoneNumber(testcase,editedEmail, editedPhone);
		actions.navigateToHomePage(testcase);
		break;


		case "Verify if user clicks on Mail icon in View information page it should navigate user to Send mail page":
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("View Information",testcase);
		viewInformationFunctionality.clickSendMail(testcase);
		sendMailFunctionality.checkSendMailPageOpen(testcase);
		break;

		case "Verify From mail id should be same as configured in admin portal":
		sendMailFunctionality.checkFromEmailID(testcase,"Customer Support <supervisorsalesiq@yandex.com>");
		break;

		case "Verify To mail id should be same as Visitor email id":
		sendMailFunctionality.checkToEmailID(testcase,editedEmail);
		break;

		case "Verify IN send mail page, CC mail id should be same as configured in Admin portal":
		sendMailFunctionality.checkCCEmailID(testcase,"mr.anbarasu10@gmail.com");
		break;
 
		case "Verify operator should be able enter email content in content Text field":
		sendMailFunctionality.enterEmailContent(testcase,"hi please send this email, this is for automation testing");
		sendMailFunctionality.sendEmail(testcase);
		actions.waitTime(3);
		break;
  
		case "Verify operator should be able to close send mail page by clickin on cross aymbol":
		viewInformationFunctionality.clickSendMail(testcase);
		sendMailFunctionality.checkSendMailPageOpen(testcase);
		sendMailFunctionality.closeSendEmail(testcase);
		actions.navigateToHomePage(testcase);
		break;
  
		case "Verify More information should be displayed in view information kebaba menu":
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("View Information",testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("More Information",testcase);
		break;
 
 
		case "Verify in more informaiton page all informmation should be same as visitor informaton":
		moreInformationFucntionality.checkVisitorName(testcase,visitorSiteAccessTest.visitorName);
		moreInformationFucntionality.checkVisitorQuestion(testcase,visitorSiteAccessTest.visitorQuestion);
		moreInformationFucntionality.checkVisitorDepartment(testcase,visitorSiteAccessTest.departmentName);
		moreInformationFucntionality.checkVisitorEmbed(testcase,"salesiqt");
		// moreInformationFucntionality.checkVisitorchatMissedReason("All the operators are busy.");
		// moreInformationFucntionality.checkVisitorEmailID(editedEmail);
		// moreInformationFucntionality.checkVisitorPhoneNumber(editedPhone);
		// moreInformationFucntionality.checkVisitorInTime("Today at "+visitorSiteAccessTest.visitorAccessTime);
		// moreInformationFucntionality.checkVisitorMissedTime(missedTime);
		// moreInformationFucntionality.checkVisitorEndTime("Today at "+visitorSiteAccessTest.visitorAccessTime);
		// moreInformationFucntionality.checkVisitorCountry();
		// moreInformationFucntionality.checkVisitorState();
		// moreInformationFucntionality.checkVisitorCity();
		// moreInformationFucntionality.checkVisitorIPAddress();
		actions.navigateToHomePage(testcase);
		break;

		case "Verify in Missed chat kebab menu CRM information menu should be displayed":
		actions.waitTime(2);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		missedChatPage.missedDetailsPageOpencheck(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		
		break;

		case "Verify in Missed chat page Push to CRM menu should be displayed":
		kebabMenuFunctionality.selectMenuFroMKebab("Push to CRM",testcase);
		crmIntegreationFunctionality.selectLeadCRM(testcase);
		crmIntegreationFunctionality.enterLeadCompanyName(testcase,crmCompanyName);
		crmIntegreationFunctionality.enterLeadPhoneNumber(testcase,crmleadPhoneNumber);
		crmIntegreationFunctionality.checkLeadStatusDropDownList(testcase);
		crmIntegreationFunctionality.selectLeadStatus(testcase,crmLeadStatus);
		crmIntegreationFunctionality.checkCRMMangerDropDownList(testcase);
		crmIntegreationFunctionality.selectLeadMangerForCRM(testcase,crmLeadManager);
		actions.hideKeyboard(testcase);
		crmIntegreationFunctionality.leadAddTask(testcase);
		crmIntegreationFunctionality.saveCRM(testcase);
		break;

		case "Verify CRM information, CRM manager should be updated as expected":
		actions.navigateToHomePage(testcase);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		missedChatPage.missedDetailsPageOpencheck(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("CRM Information",testcase);
		crmIntegreationFunctionality.checkCRMFieldOne(testcase,crmLeadManager);
		break;
 
		case "Verify CRM resource and Location should be updated as expected":
		crmIntegreationFunctionality.checkCRMFieldTwo(testcase,"Chat");
		crmIntegreationFunctionality.checkCRMFieldThree(testcase,"Chennai");
		break;
 

		case "Verify In Crm kebab menu Convert as contact & Add potential menu should be displayed":
		kebabMenuFunctionality.clickKebabMenu(testcase);
		kebabMenuFunctionality.selectMenuFroMKebab("Convert as Contact & Add Potential",testcase);
		break;
 
		case "Verify Potential information should be able to add in CRM information":
		crmIntegreationFunctionality.enterPotentialName(testcase,editedName);
		crmIntegreationFunctionality.selectPotentialStage(testcase,potentialStage);
		crmIntegreationFunctionality.enterPotentialAmount(testcase,potentialAmount);
		crmIntegreationFunctionality.clickPotentialDatePicker(testcase);
		crmIntegreationFunctionality.saveCRM(testcase);
		actions.navigateToHomePage(testcase);
		break;
 
		case "Verify Conver chat as ticket menu should be shown in Kebab menu functionality":
		actions.waitTime(2);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.missedChatMenuClick(testcase);
		missedChatPage.missedChatDetailsPageOpen(testcase);
		kebabMenuFunctionality.clickKebabMenu(testcase);
		actions.waitTime(3);
		kebabMenuFunctionality.selectMenuFroMKebab("Convert Chat as Ticket",testcase);
		break;
 
		case "Verify Zoho Desk Prioriy contains expected list":
		zohoDeskFunctionality.checkDeskPriority(testcase);
		break;
 
		case "Verify operator should be able to selelct prioriy from list":
		zohoDeskFunctionality.selectDeskPriority(testcase,zohodeskPriority);
		break;
 
		case "Verify Clasification should contains expected list":
		zohoDeskFunctionality.checkDeskClasification(testcase);
		break;
 

		case "Verify user should be able to selelct and updated clasification and save zoho desk":
		
		zohoDeskFunctionality.selectDeskClasification(testcase,zohoDeskClassification);
		zohoDeskFunctionality.clickSaveZohoDesk(testcase);
		//wait for ticket to save
		actions.waitTime(3);
		
		break;
 
		case "Verify in missed chat kebab menu Recent Support request menu should be updated":
		
		kebabMenuFunctionality.clickKebabMenu(testcase);
		//wait for menu reload
		actions.waitTime(3);
		kebabMenuFunctionality.selectMenuFroMKebab("Recent Support Requests",testcase);
		
		break;
 

		case "Verify in Recent support request updated zoho desk information should be shown":
		
		actions.waitTime(3);
		zohoDeskFunctionality.checkticketStatus(testcase,"Open");
		zohoDeskFunctionality.checkTicketQuestion(testcase,visitorSiteAccessTest.visitorQuestion);
		
		break;
 
		case "Verify if operator clicks on any list from zoho desk, zoho desk details should be shown":
		zohoDeskFunctionality.openServiceDeskList(testcase);
		actions.waitTime(3);
		zohoDeskFunctionality.checkTicketQuestionInDetails(testcase,visitorSiteAccessTest.visitorQuestion);
		zohoDeskFunctionality.checkTicketStatusInDetails(testcase,"Open");
		zohoDeskFunctionality.checkTicketDepartment(testcase,"salesiqsampledesk");
		zohoDeskFunctionality.checkTicketEmailID(testcase,editedEmail);
		zohoDeskFunctionality.checkTicketCreatedBy(testcase,crmLeadManager);
		zohoDeskFunctionality.checkTicketPriority(testcase,zohodeskPriority);
		actions.navigateToHomePage(testcase);
		
		break;

 		case "verify Close menu should be shown in Missed chat details kebab menu":
		
//		actions.waitTime(2);
//		burgerMenuNavigations.swipeBurgerMenu(testcase);
//		burgerMenuNavigations.missedChatMenuClick(testcase);
//		missedChatPage.missedChatDetailsPageOpen(testcase);
//		kebabMenuFunctionality.clickKebabMenu(testcase);
//		kebabMenuFunctionality.selectMenuFroMKebab("Close",testcase);

		break;
 

 		case "verify if we clicks on Close menu expected text should be displayed":
		
//		missedChatPage.checkPopupTitle(testcase,"Close Chat");
//		missedChatPage.checkPopupMessage(testcase,"Are you sure that you want to close this chat?");
//		missedChatPage.clickPopupMessageCancel(testcase);

		break;
 
 		case "Verify if operator clicks on close menu that missed chat should be closed":
		
//		kebabMenuFunctionality.clickKebabMenu(testcase);
//		kebabMenuFunctionality.selectMenuFroMKebab("Close",testcase);
//		missedChatPage.clickPopupMessageOk(testcase);

		break;
 
		case "Verify after missed chat is closed, particular visitor chat should not be listed in missed chat list":
		
//		actions.waitTime(2);
//		missedChatPage.clickClosedVisitor(testcase,editedName);
//		actions.navigateToHomePage(testcase);

		break;
 
		case "Verify if missed chat is closed that missed chat should be updated in Chat history":
		actions.waitTime(2);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.chatHistoryMenuClick(testcase);
		chatHistoryPage.checkVisitorListedinChatHistory(testcase,editedName);
		actions.navigateToHomePage(testcase);
		break;

		default:
		break;

			}
		}

		
	}

	
		

		
		
//		notification.openPushNotification();
//		notification.tapClearAllBtn();
		
		
		
		
		
		
		
	
	
// 	public void checkCRMFunctionalFlow()
// 	{
// 		actions.waitTime(2);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		missedChatPage.missedDetailsPageOpencheck();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		crmIntegreationFunctionality.checkCRMinformationMenuinKebabMenu();
// 		if(crmIntegreationFunctionality.crmMenuShow)
// 		{
// 			crmInformationmenu();
// 		}
// 		else 
// 		{
// 			pushToCRMMenu();
// 		}
// 	}
	
// 	public void crmInformationmenu()
// 	{
// 		actions.waitTime(2);
// 		kebabMenuFunctionality.selectMenuFroMKebab("CRM Information");
// 		crmIntegreationFunctionality.checkCRMFieldOne(crmLeadManager);
// 		crmIntegreationFunctionality.checkCRMFieldTwo("Chat");
// 		crmIntegreationFunctionality.checkCRMFieldThree("Chennai");
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Convert as Contact & Add Potential");
// 		crmIntegreationFunctionality.enterPotentialName(editedName);
// 		crmIntegreationFunctionality.selectPotentialStage(potentialStage);
// 		crmIntegreationFunctionality.enterPotentialAmount(potentialAmount);
// 		crmIntegreationFunctionality.clickPotentialDatePicker();
// 		actions.selectPotentialEndDate(module,"Select Current date in Picker");
// 		crmIntegreationFunctionality.saveCRM();
// 		actions.navigateToHomePage(testcase);
// 	}
	
	
	
// 	public void missedChatVisitorAccess()
// 	{
		
// 		visitorSiteAccessTest.VisitorAccess();
		
// 		//this method should call with param to maintain wait until chat missed
// 		actions.waitTime(visitorSiteAccessTest.visitorWaitingTime);
// 		missedTime=actions.getCurrentTime();
// 		actions.waitTime(10);
// 		notification.openPushNotification();
// 		actions.waitTime(2);
// 		notification.checkNotifcationType("Missed Chat");
// 		notification.checkNotifcationText(visitorSiteAccessTest.visitorQuestion);
// 		actions.backPress(module, "close notification Bar");
// 		actions.waitTime(2);
		
// 	}
// 	public void searchFunctionality()
// 	{
// 		actions.waitTime(2);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		//Missed Chat List 
// 		missedChatPage.checkEmptyPageText("No missed visitors found for you!");
// 		missedChatPage.checkMissedChatListUI();
// 		actions.waitTime(3);
// 		searchFunctionalityTest.searchFunctionalFlow();
// 		searchFunctionality.clickSearchIcon();
// 		searchFunctionality.enterSearchText(searchName);
// 		missedChatPage.visitorNameCheckinMissedChatList(searchName);
// 		missedChatPage.visitorQuestionCheckinMissedChatList(visitorSiteAccessTest.visitorQuestion);
// 		//this is madatory to check operator list in Assign Operator Menu
// 		missedChatPage.visitorAssigneeCheckinMissedChatList("Yet to assign");
// 		actions.navigateToHomePage(testcase);
// 	}
	
// 	public void missedChatDetailspage()
// 	{
// 		actions.waitTime(2);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		missedChatPage.missedDetailsPageOpencheck();
// 		missedChatPage.missedChatDetailsUiCheck();
// 		missedChatPage.checkVisitornNameinMissedDetailsPage(searchName);
// 		missedChatPage.checkVisitorQuestioninMissedDetails(visitorSiteAccessTest.visitorQuestion);
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		missedChatPage.checkKebabMenuwithoutMailid();
// 		kebabMenuFunctionality.selectMenuFroMKebab("Assign Operator");
// 		missedChatPage.checkAssignOperatorList();
// 		actions.navigateToHomePage(testcase);
		
// 	}
	
	
// 	public void notesFunctionalities()
// 	{
// 		actions.waitTime(3);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Add a Note");
// 		notesFunctionality.checkAddNotesPageOpen();
// 		notesFunctionality.visitorNameInAddNotesPage();
// 		notesFunctionality.enterNotes(newNotes);
// 		notesFunctionality.saveNotes();
// 		actions.waitTime(3);
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("View Notes");
// 		notesFunctionality.checkViewNotesPageOpen();
// 		notesFunctionality.visitorNameInViewNotesPage();
// 		notesFunctionality.checkNotesHistory("Note added by "+visitorSiteAccessTest.operatorName);
// 		notesFunctionality.checkNotesinViewNotes(newNotes);
// 		notesFunctionality.clickAddNotesIcon();
// 		notesFunctionality.checkAddNotesPageOpen();	
// 		notesFunctionality.doubleClickSaveNotes();
// //		 Long Text enter the edit notes
// //		notesFunctionality.longtextSaveCheck(longText);		
// 		notesFunctionality.clickEachNotes();	
// 		notesFunctionality.checkNotesDetails(visitorSiteAccessTest.visitorName, visitorSiteAccessTest.operatorName, longText);
// 		notesFunctionality.checkAddNotesIcon();
// 		actions.navigateToHomePage(testcase);
// 	}
	
// 	public void assignoperatorFunctionality()
// 	{
// 		actions.waitTime(2);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Assign Operator");
// 		missedChatPage.checkAssignOperatorList();
// 		missedChatPage.assigNewOperator("You");
// 		missedChatPage.checkAssignedOperatorName("Assigned to operator MPTEST");
// 		actions.backPress(module, "navigate to missed chat list page");
// 		missedChatPage.visitorAssigneeCheckinMissedChatList("You");
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Assign Operator");
// 		//missedChatPage.checkAssignOperatorListForAssignedChat();
// 		actions.navigateToHomePage(testcase);
		

// 	}
	
// 	public void blockIPFucntionality()
// 	{
// 		actions.waitTime(2);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Block IP");
// 		blockIpFunctionality.checkBlockIPTitle();
// 		blockIpFunctionality.checkmaskedBlockIP();
// 		blockIpFunctionality.checkPopupMessageContent();
// 		blockIpFunctionality.clickBlockIpCancel();
// 		actions.navigateToHomePage(testcase);
// 	}
// 	public void viewInformationFucntionality()
// 	{
// 		actions.waitTime(2);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("View Information");
// 		viewInformationFunctionality.checkViewInformationPageOpen();
// 		viewInformationFunctionality.checkVisitorName();
// 		viewInformationFunctionality.checkIpAddresInViewInformation();
// 		viewInformationFunctionality.checkCountryName();
// 		viewInformationFunctionality.checkDepartmentName();
// 		viewInformationFunctionality.checkSalesiqURL();
// 		viewInformationFunctionality.checkbrowserName();
// 		viewInformationFunctionality.checkOSName();
// 		actions.navigateToHomePage(testcase);

// 	}
	
// 	public void editInformationFunctionality()
// 	{
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("View Information");
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		viewInformationFunctionality.checkViewInformationKebabMenu();
// 		kebabMenuFunctionality.selectMenuFroMKebab("Edit Information");
// 		viewInformationFunctionality.checkEditInformationPageOpen();
// 		viewInformationFunctionality.editVisitorName(editedName);
		
// 		String temp=actions.randomEmail("@Automation.com");
// 		editedEmail=temp;
// 		viewInformationFunctionality.editEmailAddress(editedEmail);
// 		viewInformationFunctionality.editPhoneNumber(editedPhone);
// 		viewInformationFunctionality.saveEditInformation();
// 		actions.backPress(module, "Navigate to Chat detail page to check newly added mail after email updation");
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		viewInformationFunctionality.checkNewMenuAddedafterupdateMail();
// 		kebabMenuFunctionality.selectMenuFroMKebab("View Information");
// 		viewInformationFunctionality.checkEmailIdandPhoneNumber(editedEmail, editedPhone);
// 		actions.navigateToHomePage(testcase);
		
		
// 	}
	
// 	public void sendMailfunctionalityinViewInformation()
// 	{
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("View Information");
// 		viewInformationFunctionality.clickSendMail();
// 		sendMailFunctionality.checkSendMailPageOpen();
// 		sendMailFunctionality.checkFromEmailID("operator MPTEST<anbucan@gmail.com>");
// 		sendMailFunctionality.checkToEmailID(editedEmail);
// 		sendMailFunctionality.checkCCEmailID("mr.anbarasu10@gmail.com");
// 		sendMailFunctionality.checkEmailSubject(visitorSiteAccessTest.visitorQuestion);
// 		sendMailFunctionality.enterEmailContent("hi please send this email, this is for automation testing");
// 		sendMailFunctionality.sendEmail();
// 		actions.waitTime(3);
// 		viewInformationFunctionality.clickSendMail();
// 		sendMailFunctionality.checkSendMailPageOpen();
// 		sendMailFunctionality.closeSendEmail();
// 		actions.navigateToHomePage(testcase);
// 	}
// 	public void moreInformationPageFunctionality()
// 	{
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("View Information");
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("More Information");
// 		moreInformationFucntionality.checkVisitorName(visitorSiteAccessTest.visitorName);
// 		moreInformationFucntionality.checkVisitorQuestion(visitorSiteAccessTest.visitorQuestion);
// 		moreInformationFucntionality.checkVisitorDepartment(visitorSiteAccessTest.departmentName);
// 		moreInformationFucntionality.checkVisitorEmbed("salesiqt");
// 		moreInformationFucntionality.checkVisitorchatMissedReason("All the operators are busy.");
// 		moreInformationFucntionality.checkVisitorEmailID(editedEmail);
// 		moreInformationFucntionality.checkVisitorPhoneNumber(editedPhone);
// 		moreInformationFucntionality.checkVisitorInTime("Today at "+visitorSiteAccessTest.visitorAccessTime);
// 		moreInformationFucntionality.checkVisitorMissedTime(missedTime);
// 		moreInformationFucntionality.checkVisitorEndTime("Today at "+visitorSiteAccessTest.visitorAccessTime);
// 		moreInformationFucntionality.checkVisitorCountry();
// 		moreInformationFucntionality.checkVisitorState();
// 		moreInformationFucntionality.checkVisitorCity();
// 		moreInformationFucntionality.checkVisitorIPAddress();
// 		actions.navigateToHomePage(testcase);
// 	}
// 	public void phoneCallFeatureinViewInformation()
// 	{
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("View Information");
// 		//phone call check negative scenario
// 		viewInformationFunctionality.clickCallIcon();
// 		sendMailFunctionality.clickPermissionDeny();
// 		sendMailFunctionality.clickDontAskPermission();
// 		sendMailFunctionality.clickPermissionDeny();
// 		sendMailFunctionality.checkPermissionPopupShown();
// 		actions.navigateToHomePage(testcase);
// 	}
	
// 	public void closeMissedChatFeaure()
// 	{
// 		//Missed Chat Close
// 		actions.waitTime(2);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Close");
// 		missedChatPage.checkPopupTitle("Close Chat");
// 		missedChatPage.checkPopupMessage("Are you sure that you want to close this chat?");
// 		missedChatPage.clickPopupMessageCancel();
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Close");
// 		missedChatPage.clickPopupMessageOk();
		
// 		//Time for removing missedchat from list
// 		actions.waitTime(2);
// 		actions.backPress(module, "navigate to missed chat list");
// 		missedChatPage.clickClosedVisitor(editedName);
// 		actions.burgerSwipe();
// 		//Time for adding missedchat in list
// 		actions.waitTime(2);
// 		burgerMenuNavigations.chatHistoryMenuClick(testcase);
// 		chatHistoryPage.checkVisitorListedinChatHistory(editedName);
// 		actions.navigateToHomePage(testcase);
// 	}
	
// 	public void pushToCRMMenu()
// 	{
// 		kebabMenuFunctionality.selectMenuFroMKebab("Push to CRM");
// 		crmIntegreationFunctionality.selectLeadCRM();
// 		crmIntegreationFunctionality.enterLeadCompanyName(crmCompanyName);
// 		crmIntegreationFunctionality.enterLeadPhoneNumber(crmleadPhoneNumber);
// 		crmIntegreationFunctionality.checkLeadStatusDropDownList();
// 		crmIntegreationFunctionality.selectLeadStatus(crmLeadStatus);
// 		crmIntegreationFunctionality.checkCRMMangerDropDownList();
// 		crmIntegreationFunctionality.selectLeadMangerForCRM(crmLeadManager);
// 		crmIntegreationFunctionality.leadAddTask();
// 		crmIntegreationFunctionality.saveCRM();
// 		//wait for CRM information save
// 		actions.waitTime(3);
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		//wait for menu load
// 		actions.waitTime(3);
// 		crmIntegreationFunctionality.checkCRMinformationMenuinKebabMenu();
// 		crmIntegreationFunctionality.openCRMViewInformation();
		
// 		//wait for CRM Page to Load
// 		actions.waitTime(3);
		
// 		crmIntegreationFunctionality.checkLeadOwner(crmLeadManager);
// 		crmIntegreationFunctionality.checkLeadSource("Chat");
// 		crmIntegreationFunctionality.checkLeadCity("Chennai");
// //		crmIntegreationFunctionality.checkPopupShouldNotOpen();
// //		crmIntegreationFunctionality.clickCRMICon();
// //		crmIntegreationFunctionality.checkCRMAppLinkPopup("To view the Visitor Information from your Zoho CRM account, you should have the Zoho CRM app installed in your device.");
// //		crmIntegreationFunctionality.clickCancelCRMPopup();
// //		crmIntegreationFunctionality.downloadCRMApplication();
// //		actions.backPress(module, "back to CRM page from download page");
		
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Convert as contact");
		
// 		//wait for convert lead to contact
// 		actions.waitTime(3);
// 		crmIntegreationFunctionality.checkCRMFieldOne("edited");
// 		crmIntegreationFunctionality.checkCRMFieldThree(crmLeadManager);
// 		crmIntegreationFunctionality.checkCRMFieldTwo(editedEmail);
		
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		//wait for menu load
// 		actions.waitTime(3);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Create Potential");
		
// 		//Loading Time
// 		actions.waitTime(2);
		
		
// 		crmIntegreationFunctionality.enterPotentialName(editedName);
// 		crmIntegreationFunctionality.selectPotentialStage(potentialStage);
// 		crmIntegreationFunctionality.enterPotentialAmount(potentialAmount);
// 		crmIntegreationFunctionality.clickPotentialDatePicker();
		
// 		crmIntegreationFunctionality.saveCRM();
		
// 		//Time for save potential information
// 		actions.waitTime(3);
		
// 		crmIntegreationFunctionality.checkPotentialName(editedName);
// 		crmIntegreationFunctionality.checkPotentialStage(potentialStage);
// 		crmIntegreationFunctionality.checkPotentialExpectedRevenue(potentialAmount);
// 		//crmIntegreationFunctionality.checkPotentialClosingDate();
// 		crmIntegreationFunctionality.checkPotentialOwner(crmLeadManager);
// 		crmIntegreationFunctionality.checkPotentialPipeLineRevenue(potentialAmount);
// 		crmIntegreationFunctionality.checkPotentialPipeLineStage(potentialStage);
// 		//crmIntegreationFunctionality.checkPotentialPipeLineEndDate();
// 		actions.navigateToHomePage(testcase);
		
// 	}
	
	
// 	public void zohoServiceDesk()
// 	{
	
// 		actions.waitTime(2);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.missedChatMenuClick(testcase);
// 		missedChatPage.missedChatDetailsPageOpen();
// //		kebabMenuFunctionality.clickKebabMenu(module);
// 		//wait for menu load
		
// 		kebabMenuFunctionality.clickKebabMenu(module);
// 		actions.waitTime(3);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Convert Chat as Ticket");
// 		zohoDeskFunctionality.checkDeskPriority();
// 		//actions.backPress(module, testCaseName);
// 		zohoDeskFunctionality.selectDeskPriority(zohodeskPriority);
// 		zohoDeskFunctionality.checkDeskClasification();
// 		zohoDeskFunctionality.selectDeskClasification(zohoDeskClassification);
// 		zohoDeskFunctionality.clickSaveZohoDesk();
		
// 		//wait for ticket to save
// 		actions.waitTime(3);
		
// 		kebabMenuFunctionality.clickKebabMenu(module);
		
// 		//wait for menu reload
// 		actions.waitTime(3);
// 		kebabMenuFunctionality.selectMenuFroMKebab("Recent Support Requests");
		
// 		//wait for ticket list open
// 		actions.waitTime(3);
// 		zohoDeskFunctionality.checkticketStatus("Open");
// 		zohoDeskFunctionality.checkTicketQuestion(visitorSiteAccessTest.visitorQuestion);
// 		zohoDeskFunctionality.openServiceDeskList();
		
// 		//wait for ticket details to open
// 		actions.waitTime(3);
// 		zohoDeskFunctionality.checkTicketQuestionInDetails(visitorSiteAccessTest.visitorQuestion);
// 		zohoDeskFunctionality.checkTicketStatusInDetails("Open");
// 		zohoDeskFunctionality.checkTicketDepartment("salesiqsampledesk");
// 		zohoDeskFunctionality.checkTicketEmailID(editedEmail);
// 		zohoDeskFunctionality.checkTicketCreatedBy(crmLeadManager);
// 		zohoDeskFunctionality.checkTicketPriority(zohodeskPriority);
// 		actions.navigateToHomePage(testcase);
			
// 	}
	public static String filePath() {
		URL location = MissedChatTest.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		return fileloc;

	}

}

