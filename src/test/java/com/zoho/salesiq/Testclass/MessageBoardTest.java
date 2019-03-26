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
import com.zoho.salesiq.pageclass.MessageBoardPage;
import com.zoho.salesiq.pageclass.SettingsPage;
import com.zoho.salesiq.pageclass.Emaillogin;

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
 



public class MessageBoardTest extends BaseSetup{

	MissedChatPage missedChatPage;
	VisitorSiteAccessTest visitorSiteAccessTest;
	BurgerMenuNavigations burgerMenuNavigations;
	Notificatiofucntionality notificatiofucntionality;
	CommonActionMobile actions;
	CommonActionMobile actions1;
	SearchFunctionalityTest searchFunctionalityTest;
	SearchFunctionality searchFunctionality;
	KebabMenuFunctionality kebabMenuFunctionality;
	MessageBoardPage messageBoardPage;
	SettingsPage settingsPage;
	private OngoingChatPage ongoingChatPage;
	private String categories = "Message Board";
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
	private Emaillogin emaillogin;
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
	private String messageBoardText="operator send text in Message board";

	


	public MessageBoardTest()
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
	emaillogin = new Emaillogin(driver);
	devicetwoTestCase= new DeviceTwoTestCase();
	chatHistoryPage= new ChatHistoryPage(driver);
	visitorHistoryPage= new VisitorHistoryPage(driver);
	ongoingChatPage= new OngoingChatPage(driver);
	newChatNotification= new NewChatNotification(driver);
	viewInformationFunctionality = new ViewInformationFunctionality(driver);
	chatHistory = new ChatHistory();
	operatorsChatPage= new OperatorsChatPage(driver);
	messageBoardPage= new MessageBoardPage(driver);
	settingsPage= new SettingsPage(driver);
	}

	
	public void messageBoardTestExecution() throws InterruptedException, MalformedURLException, Exception {
		String filepath = filePath();
// 		System.out.println(filepath);

		File file = new File(filepath + "MessageBoardTest.properties");

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

		case "Verify if Operator clicks on Message board, app should navigate user to Message Board page":
		actions.navigateToHomePage(testcase);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.messageBoardMenuClick(testcase,categories);
		messageBoardPage.checkMessageChatPageOpen(testcase,categories);
		break;

		case "Verify active participant count should be displayed in Message board":
		messageBoardPage.checkActiveOperatorCountInMessageBoard(testcase,categories,"1");
		break;

		case "Verify if any operator sends message in Message boards, all operator should see the entered message":
		devicetwoTestCase.swipeBurger(testcase);
		devicetwoTestCase.messageBoardMenuClick(testcase,categories);
		devicetwoTestCase.enterTextInMessageBoardTwo(testcase,categories,messageBoardText);
		devicetwoTestCase.sendTextInMessageBoardTwo(testcase,categories);
		messageBoardPage.checkMessageBoardText(testcase,categories,messageBoardText);	
		break;
		case "Verify if new message received in Message board, in Message board menu based on chat count, message count should be displayed":
		actions.backPress(testcase, "close Search text field");
		devicetwoTestCase.enterTextInMessageBoardTwo(testcase,categories,messageBoardText);
		devicetwoTestCase.sendTextInMessageBoardTwo(testcase,categories);
		actions.waitTime(2);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		burgerMenuNavigations.checkMessageBoardCountMenu(testcase,categories);
		actions.backPress(testcase, "Close burger menu");

		break;

		case "Verify if new Operator in active state, that operator count should be added in message board without closing and open application":
		devicetwoTestCase.redirectToHomePage(testcase);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		actions.waitTime(2);
		burgerMenuNavigations.settingsMenuClick(testcase);
		settingsPage.clickSignOut(testcase);
		settingsPage.signOutInPopup(testcase);

		//login third user
		actions.waitTime(2);
		emaillogin.loginButton(testcase);
		actions.waitTime(2);
		emaillogin.enterEmail("testingsalesiq@gmail.com",testcase);
		emaillogin.enterPassword("Automation@123",testcase);
		actions.hideKeyboard(testcase);
		emaillogin.loginUser(testcase);
		actions.waitTime(2);
		emaillogin.clickNotInterested(testcase);

		devicetwoTestCase.swipeBurger(testcase);
		devicetwoTestCase.messageBoardMenuClick(testcase,categories);
		devicetwoTestCase.checkActiveOperatorCountIfNewOperatorAdded(testcase,categories,"2");
		devicetwoTestCase.redirectToHomePage(testcase);

		break;

		






















		default:

		break;

	}
}
}
	public static String filePath() {
		URL location = MessageBoardTest.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		return fileloc;

	}

}

