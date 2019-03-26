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
import com.zoho.salesiq.pageclass.OperatorsChatPage;

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
 



public class OperatorChats extends BaseSetup{

	MissedChatPage missedChatPage;
	VisitorSiteAccessTest visitorSiteAccessTest;
	BurgerMenuNavigations burgerMenuNavigations;
	Notificatiofucntionality notificatiofucntionality;
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
	private OperatorsChatPage operatorsChatPage;
	private ChatHistory chatHistory;
	public String sendMailContent="this is email content and typed by Automation script";
	private String operatorChatsText="Send Operator chat between Operators in operators Chat";

	


	public OperatorChats()
	{
	burgerMenuNavigations = new BurgerMenuNavigations(driver);
	missedChatPage = new MissedChatPage(driver);
	visitorSiteAccessTest = new VisitorSiteAccessTest();
	notificatiofucntionality = new Notificatiofucntionality(driver);
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
	operatorsChatPage= new OperatorsChatPage(driver);
	}

	
	public void operatorChatsTestExecution() throws InterruptedException, MalformedURLException, Exception {
		String filepath = filePath();
// 		System.out.println(filepath);

		File file = new File(filepath + "OperatorChats.properties");

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

		case "verify after clicks on Operator Chats in Burger Menu, Operator Chats page should be shown":
			actions.navigateToHomePage(testcase);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.operatorChatsMenuClick(testcase);
		operatorsChatPage.checkOepratorChatsPageOpen(testcase,categories);
		break;

		case "Verify in Operator Chats page, Search icon should be available to search Chats":
		operatorsChatPage.checkSearchIconDisplayedInOperatorChats(testcase,categories);
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
		actions.hideKeyboard(testcase);
		operatorsChatPage.checkOperatorListCheckAfterCrossSymbolClick(testcase,categories);
	
		break;

		case "Verify if Operator clicks on back button Search text field should be closed":
		actions.backPress(testcase, "close Search text field");
		break;

		case "Verify individual chat between operator can performed by clicking on chat icon and select the operator who want to chat":
		operatorsChatPage.checkOperatorChatIcon(categories,testcase);
		operatorsChatPage.clickCreateChatIcon(testcase,categories);
		operatorsChatPage.checkAfterCicksOnCreateOperatorChatIcon(testcase,categories);
		break;

		case "Verify after clicks on Create chat icon Operator name should be listed in the oeprator chats page":
		
		operatorsChatPage.checkOperatorCount(testcase,categories,3);
		operatorsChatPage.checkOperatorsInList(testcase,categories,"Admin");
		operatorsChatPage.checkOperatorsInList(testcase,categories,"supervisor");
		operatorsChatPage.checkOperatorsInList(testcase,categories,"supevisortest@yandex.com");
		break;


		case "Verify if operator should be able to selelct operator from the list":

		operatorsChatPage.selectOperatorFromList(testcase,categories,"Admin");
		operatorsChatPage.checkOperatorNameAfterConnect(testcase,categories,"Admin");
		actions.navigateToHomePage(testcase);
		
		break;

		case "Verify if operator1 receive chats from operator2, chat count in Operator Chats menu should increased":

		devicetwoTestCase.redirectToHomePage(testcase);
		devicetwoTestCase.swipeBurger(testcase);
		devicetwoTestCase.operatorChatsMenuDeviceTwo(testcase);
		devicetwoTestCase.selectOperatorFromOperatorChats(testcase,categories,"operator MPTEST");
		devicetwoTestCase.enterTextInOperatorChatsTwo(testcase,categories,operatorChatsText);
		devicetwoTestCase.sendTextInOperatorChatsTwo(testcase,categories);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.checkOperatorsChatCountMenu(testcase,categories);
		break;

		case "Verify if operator1 receive chats from operator2, chat count in Operator Chats list should be based on chat text count":
		burgerMenuNavigations.operatorChatsMenuClick(testcase);
		operatorsChatPage.checkUnreadChatListCount(testcase,categories,"1");
		break;

		case "Verify if Operator1 put application in minimise state, if Operator sent text, that text should be received in push notification":
		actions.minimizeApplication(testcase,"Minimize application");
		devicetwoTestCase.enterTextInOperatorChatsTwo(testcase,categories,operatorChatsText);
		devicetwoTestCase.sendTextInOperatorChatsTwo(testcase,categories);
		notificatiofucntionality.openPushNotification(testcase);
		notificatiofucntionality.checkOperatorChatText(testcase,categories,operatorChatsText);
		actions.backPress(testcase, "close Search text field");
		actions.lauchApplicationAfterKill(testcase);
		break;

		case "Verify if Operator clicks on File share icon, file manager should be open to upload image file from system":


		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.operatorChatsMenuClick(testcase);
		operatorsChatPage.selectOperatorFromOperatorChatsList(testcase,categories,"Admin");
		ongoingChatPage.clickShareImageIcon(testcase);
		ongoingChatPage.openImageFile(testcase);
		ongoingChatPage.clickSendUpdload(testcase);
		devicetwoTestCase.checkImageSharedWithOtherOperator(testcase,categories);
		
		break;

		case "Verify if operator clicks on Donwload icon, Image should be downloaded":
		devicetwoTestCase.checkImageisDownloaded(testcase,categories);
		devicetwoTestCase.redirectToHomePage(testcase);
		break;























		default:

		break;

	}
}
}
	public static String filePath() {
		URL location = OperatorChats.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		return fileloc;

	}

}

