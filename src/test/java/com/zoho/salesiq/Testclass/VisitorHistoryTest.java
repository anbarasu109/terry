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
import com.zoho.salesiq.pageclass.VisitorHistoryPage;
import com.zoho.salesiq.pageclass.CRMIntegreationFunctionality;
import com.zoho.salesiq.pageclass.ZohoDeskFunctionality;
import com.zoho.salesiq.pageclass.MoreInformationFucntionality;
import com.zoho.salesiq.pageclass.BaseSetup;
import com.zoho.salesiq.pageclass.NotesFunctionality;
import com.zoho.salesiq.pageclass.MissedChatPage;
import com.zoho.salesiq.pageclass.NewChatNotification;
import com.zoho.salesiq.pageclass.OngoingChatPage;

import com.zoho.salesiq.pageclass.BurgerMenuNavigations;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
import com.zoho.salesiq.Testclass.SearchFunctionalityTest;
import com.zoho.salesiq.Testclass.DeviceTwoTestCase;
import com.zoho.salesiq.Testclass.ChatHistory;
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
 



public class VisitorHistoryTest extends BaseSetup{

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
	private String categories = "Visitor History";
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
	private String potentialAmount="17890";
	private ZohoDeskFunctionality zohoDeskFunctionality;
	private String zohodeskPriority="High";
	private String zohoDeskClassification="Problem";
	private Emaillogintest emaillogintest;
	private DeviceTwoTestCase devicetwoTestCase;
	private VisitorHistoryPage visitorHistoryPage;
	private ChatHistoryPage chatHistoryPage;
	private NewChatNotification newChatNotification;
	private ViewInformationFunctionality viewInformationFunctionality;
	private MoreInformationFucntionality moreInformationFucntionality;
	private ChatHistory chatHistory;
	public String sendMailContent="this is email content and typed by Automation script";
	
	


	public VisitorHistoryTest()
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
	visitorHistoryPage= new VisitorHistoryPage(driver);
	ongoingChatPage= new OngoingChatPage(driver);
	newChatNotification= new NewChatNotification(driver);
	viewInformationFunctionality = new ViewInformationFunctionality(driver);
	chatHistory = new ChatHistory();
	burgerMenuNavigations.clearAllBurgerMenuPointValue();
	}

	
	public void visitorHistoryTestExecution() throws InterruptedException, MalformedURLException, Exception {
		String filepath = filePath();
// 		System.out.println(filepath);

		File file = new File(filepath + "VisitorHistoryTest.properties");

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
	
		for (String property : sortedSet) {

			String value = prop.getProperty(property);

			String testcase = value;

			System.out.println("Automation Case"+property+"="+testcase);
		
		switch (testcase) {

		case "Verify if operator clicks on History Menu under Visitors, Operator should be navigated to History Page":
		actions.navigateToHomePage(testcase);
		visitorSiteAccessTest.startBrowser(testcase);
		visitorSiteAccessTest.accessSalesiqSite(testcase);
		actions.waitTime(5);
		visitorSiteAccessTest.quitBrowser(testcase);
		actions.waitTime(40);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.visitorHistoryMenuClick(testcase);
		visitorHistoryPage.checkVisitorHistoryListOpenCheck(testcase,categories);
	
		break;

		case "Verify by default Returning user list should be selected in History pageclass":
		visitorHistoryPage.checkVisitorHistoryFilterDefault(testcase,"Returning Visitors");

		break;



		case "Verify if Visitor left from website, that visitor information should be shown in Visitor History page":
		visitorHistoryPage.clickVisitorHistroyFilter(testcase,categories);
		visitorHistoryPage.selectFilterFromList(testcase,categories,"All Visitors");
		visitorHistoryPage.checkVisitorNameInVisitorHistoryList(testcase,"Testing Automation");

		break;

		
		case "Verify in history page there should be two default list should be shown after clicking on dropdown":
		visitorHistoryPage.clickVisitorHistroyFilter(testcase,categories);
		visitorHistoryPage.checkVisitorHistoryFilterName(testcase);
		actions.backPress(testcase,"Close Visitor history filter list");
		//workaround for appium issue https://github.com/appium/appium/issues/7806
		actions.clickBasedonCoordinate(790,144);
		

		break;	

		case "Verify if Operator clicked on search icon, Text box should be shown to enter search text":
		//actions.clickBasedonCoordinate(790,144);
		actions.minimizeApplication(categories, testcase);
		actions.minAndMax(categories, testcase);
		searchFunctionality.clickVisitorHistorySearchIcon(testcase);
		break;
		
		case "Verify if text entered, result should be shown Based on text":
		searchFunctionality.enterSearchText(testcase,"isfsiuygsdudshfsuhf");
		searchFunctionality.checkEmptyList(testcase,"Looks like there aren’t any records that match the search word specified.");
		break;

		case "Verify search result should be shown based on search value":
		searchFunctionality.enterSearchText(testcase,visitorSiteAccessTest.visitorName);
		searchFunctionality.checkVisitorHistorySearchResult(testcase,visitorSiteAccessTest.visitorName);
		break;

		case "Verify by searching any value, in search result select any visitor from the list, and then open list again, after clicking search icon previously entered text should not display":
		visitorHistoryPage.selectSingleVisitorHistory(testcase,categories);
		actions.backPress(testcase, "Navaigate to Visitor history list page");
		//actions.clickBasedonCoordinate(790,144);
		actions.minimizeApplication(categories, testcase);
		actions.minAndMax(categories, testcase);
		searchFunctionality.clickVisitorHistorySearchIcon(testcase);
		searchFunctionality.checkEmptySearchTextField(testcase,categories);
		break;

		case "Verify if operator clicks on cross icon Enter search value should be cleared and visitor List should display":
		searchFunctionality.closeSearchByClickonCrossIconInVisitorHistory(testcase);

		break;

		case "Verify without scrolling down application, search old chat history user, search result should be shown":
		searchFunctionality.enterSearchText(testcase,"werty");
		searchFunctionality.checkVisitorHistorySearchResult(testcase,"werty");
		actions.hideKeyboard(testcase);
		actions.backPress(testcase, "close search results values");
		break;

		case "Verify Predefined list(All Vistors and Returning Visitors) should be sorted by Lead score":


		visitorHistoryPage.clickVisitorHistroyFilter(testcase,categories);
		visitorHistoryPage.selectFilterFromList(testcase,categories,"LeadScoreSort");
		visitorHistoryPage.selectSingleVisitorHistory(testcase,categories);
		visitorHistoryPage.getVisitorOneLeadScore(testcase,categories);
		actions.backPress(testcase, "Navaigate to Visitor history list page");
		visitorHistoryPage.selectSecondVisitorHistory(testcase,categories);
		visitorHistoryPage.checkVisitoryListedBasedOnLeadScore(testcase,categories);
		actions.backPress(testcase, "Navaigate to Visitor history list page");
		break;

		case "Verify visitor history should be listed based on the predefined list condition":
		visitorHistoryPage.checkReturningVisitorName(testcase,categories,"Testing Automation");
		visitorSiteAccessTest.startBrowser(testcase);
		visitorSiteAccessTest.accessSalesiqSite(testcase);
		actions.waitTime(5);
		visitorSiteAccessTest.quitBrowser(testcase);
		actions.waitTime(40);
		visitorHistoryPage.clickVisitorHistroyFilter(testcase,categories);
		visitorHistoryPage.selectFilterFromList(testcase,categories,"All Visitors");
		//workaround for appium issue https://github.com/appium/appium/issues/7806
//		actions.clickBasedonCoordinate(790,144);
		actions.minimizeApplication(categories, testcase);
		actions.minAndMax(categories, testcase);
		visitorHistoryPage.checkAllVisitorName(testcase,categories);
		break;
		case "Verify In Visitor History page, UI Should be same as expected":
		visitorHistoryPage.checkVisitorHistoryUI(testcase,categories);
		break;

		case "Verify in Visitor History list page each visitor referral should be equal to expected referral type":
		visitorHistoryPage.checkVisitorReferal(testcase,categories,"Direct");
		break;

		case "Verify if visitor haven't name, IP Address should be shown if visitor is not initiated chat or not accepted by operator":
		visitorHistoryPage.checkVisitorHistoryIPAddress(testcase,categories);
		break;

		case "Verify if visitor haven't name, Visitor-Random number should be shown if visitor chat is accepted by operator":
		visitorSiteAccessTest.startBrowser(testcase);
		visitorSiteAccessTest.initiateChatWithoutName(testcase);
		actions.waitTime(5);
		visitorSiteAccessTest.quitBrowser(testcase);
		actions.navigateToHomePage(testcase);
		//this time to for user come under visitor history from visitor online
		actions.waitTime(10);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.visitorHistoryMenuClick(testcase);
		visitorHistoryPage.checkVisitorHistoryListOpenCheck(testcase,categories);
		visitorHistoryPage.clickVisitorHistroyFilter(testcase,categories);
		visitorHistoryPage.selectFilterFromList(testcase,categories,"All Visitors");
		//workaround for appium issue https://github.com/appium/appium/issues/7806
		actions.clickBasedonCoordinate(790,144);
		visitorHistoryPage.selectSingleVisitorHistory(testcase,categories);
		visitorHistoryPage.checkVisitorNameInVisitorHistoryDetails(testcase,categories);
		actions.backPress(testcase, "Navaigate to Visitor history list page");
		break;

		case "Verify after clicks on individual chat list from chat history, visitor history details page should be shown":
		visitorHistoryPage.clickVisitorHistroyFilter(testcase,categories);
		visitorHistoryPage.selectFilterFromList(testcase,categories,"All Visitors");
		//actions.clickBasedonCoordinate(790,144);
		actions.minimizeApplication(categories, testcase);
		actions.minAndMax(categories, testcase);
		searchFunctionality.clickVisitorHistorySearchIcon(testcase);
		searchFunctionality.enterSearchText(testcase,"Testing Automation");
		visitorHistoryPage.selectSingleVisitorHistory(testcase,categories);
		visitorHistoryPage.checkVisitorHistoryDetailspageOpen(testcase,categories);
		break;


		case "Verify in Visitor Details page, Phone and Mail icon should be displayed at the top right corner of Visitor History details page":
		visitorHistoryPage.checkMailIconInVisitorHistoryDetailspage(testcase,categories);
		visitorHistoryPage.checkPhoneIconInVisitorHistoryDetailspage(testcase,categories);
		break;

		case "Verify in visitor info tab for new user First Visited date should be today date, for repeated user First Visited date should be Visitor first accessed date of site":
//		visitorHistoryPage.checkVisitorLastContactType(testcase,categories,"Chat");
		break;

		case "Verify if Operators clicks on Mail icon, App should navigate user to Mail compose page":
		visitorHistoryPage.checkSendMailIcon(categories,testcase);		
		visitorHistoryPage.clickMailIconInVisitorHistoryDetailspage(testcase,categories);		
		sendMailFunctionality.checkSendMailPageOpen(testcase);
		break;		

		case "Verify From Address should be same as Configured in portal settings or individual department settings":
		sendMailFunctionality.checkFromEmailID(testcase,"Customer Support<supervisorsalesiq@yandex.com>");
		break;		

		case "Verify To address should be same as Visitor entered mail id in Chat window or Edited mail id":
		sendMailFunctionality.checkToEmailID(testcase,chatHistory.editedEmail);
		break;		

		case "Verify CC mail id should be same as configured in Portal settings or individual Department settings":
		sendMailFunctionality.checkCCEmailID(testcase,"mr.anbarasu10@gmail.com");
		break;		
			
		case "Verify in compose mail page, subject should be same as Visitor entered question in chat window":
		sendMailFunctionality.enterSubjectInMail(testcase,visitorSiteAccessTest.visitorQuestionInSpanish);
		break;

		case "Verify user should be able to enter mail content in Enter description field":
		sendMailFunctionality.enterEmailContent(testcase,sendMailContent);		
		break;

		case "Verify in mail compose page, after entered Email description and click on send mail should send to TO address and success message should be shown as Email has been sent succesfully":
		sendMailFunctionality.sendEmail(testcase);
		actions.waitTime(2);
		sendMailFunctionality.checkSendMail(testcase);
		break;

		case "Verify Last visited date should be same as user visited date or time":
		visitorHistoryPage.selectVisitorInfoTab(testcase,categories);
		visitorHistoryPage.swipeVisitoInfoTab(testcase,categories);
		visitorHistoryPage.getVisitorInfoDetailsList();
		visitorHistoryPage.checkVisitorSiteAccessedTime(testcase,categories);
		break;

		case "Verify in visitor info page, Referred by should be Direct traffic if visitor accessed site by directly entered link in URL bar":
		visitorHistoryPage.checkVisitorReferalType(testcase,categories,"Direct Traffic");
		break;


		case "Verify Lead score should be same as Calculation given in Lead score calculation page in Web portal":
		visitorHistoryPage.checkLeadScoreValue(testcase,categories,"58");
		break;

		case "Verify in visitor info tab for new user First Visited date":
		visitorHistoryPage.checkVisitorfirstAccessTime(testcase,categories);
		break;

		case "Verify in Visitor info tab, if visitor is last contacted by mail, Last contacted by should be mail":
		visitorHistoryPage.checkVisitorLastContactType(testcase,categories,"Mail");
		break;

		case "Verify Last contacted by name should be same as operator who handled via chat or mail":
		visitorHistoryPage.checkVisitorLastContactType(testcase,categories,"operator MPTEST");
		break;

		case "Verify CRM info tab should be displayed only if user data share with CRM from Salesiq":
		visitorHistoryPage.selectCRMInfoTab(testcase,categories);
		break;
		

		case "Verify Activities Info contains following information if visitor accessed site this week":
		visitorHistoryPage.selectActivitiesInfoTab(testcase,categories);
		visitorHistoryPage.checkActivitiesInfoList(testcase,categories);
		break;	

		case "Verify Activities Info contains following information if visitor not accessed site this week,Frequency of Visits and Referral":
		visitorHistoryPage.checkFrequencyOfVisitsInActivitiesInfo(testcase,categories,"Weekly");
		visitorHistoryPage.checknumberOfvisitsInActivitiesInfo(testcase,categories,"1");
		break;

		case "Verify if visitor accessed site atleast weekly once means, frequency of visit should be weekly":
		visitorHistoryPage.checkFrequencyOfVisitsInActivitiesInfo(testcase,categories,"Weekly");
		break;

		case "Verify Referred by, this should be same as way of visitor accessed website":
		visitorHistoryPage.checkReferedByInActivitiesInfo(testcase,categories,"Direct Traffic");
		break;

		case "Verify Top Pages visited, this should be same as visitor accessed all the pages in website current week":
		visitorHistoryPage.checkAccessedSiteInActivitiesInfo(testcase,categories,"https://salesiqt.blogspot.com/2018/08/blog-post.html");
		break;

		case "Verify under CRM info, all fields should be same as Configured in web portal page":
		visitorHistoryPage.selectCRMInfoTab(testcase,categories);
		visitorHistoryPage.checkCRMTypeTabOpen(testcase,categories);
		break;

		case "Verify under CRM info, all fields Visitor name should be same as expected":
		visitorHistoryPage.checkCRMVsitorName(testcase,categories,"Testing");
		break;

		case "Verify under CRM info, Visitor Email id address should be same as expected":
		visitorHistoryPage.checkCRMVsitorEmail(testcase,categories,visitorSiteAccessTest.emailID);
		break;

		case "Verify under CRM info, CRM contact owner should be same as expected":
		visitorHistoryPage.checkCRMVsitorContactOwner(testcase,categories,chatHistory.crmLeadManager);
		break;


		











		default:

		break;

	}
}
}
	public static String filePath() {
		URL location = VisitorHistoryTest.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		return fileloc;

	}

}

