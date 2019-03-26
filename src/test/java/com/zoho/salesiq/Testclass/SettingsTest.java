//$Id$
package com.zoho.salesiq.Testclass;

import java.awt.Checkbox;
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


import org.jsoup.Connection.Base;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.zoho.salesiq.pageclass.Emaillogin;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.BurgerMenuNavigations;
import com.zoho.salesiq.pageclass.VisitorOnlinePage;
import com.zoho.salesiq.pageclass.ChatHistoryPage;
import com.zoho.salesiq.pageclass.NewChatNotification;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.BaseSetup;
import com.zoho.salesiq.pageclass.KebabMenuFunctionality;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.SettingsPage;
import com.zoho.salesiq.Testclass.Emaillogintest;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
import com.zoho.salesiq.Testclass.Emaillogintest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import com.zoho.salesiq.Testclass.DeviceTwoTestCase;
import okhttp3.internal.http2.Settings;

public class SettingsTest extends BaseSetup {
	private SettingsPage settings;
	private VisitorOnlinePage visitorOnlinePage;
	private BurgerMenuNavigations burgerMenuNavigations;
	private CommonActionMobile actions;
	private ChatHistoryPage chatHistoryPage;
	private VisitorSiteAccessTest visitorSiteAccessTest;
	private NewChatNotification newChatNotification;
	private Notificatiofucntionality notificatiofucntionality;

	private BaseSetup baseSetup;
	private KebabMenuFunctionality kebabMenuFunctionality;
	private SearchFunctionality searchFunctionality;
	private Emaillogin emaillogin;
	private Emaillogintest emaillogintest;
	private DeviceTwoTestCase devicetwoTestCase;
	
	
	public SettingsTest()
	{
		
		actions = new CommonActionMobile(driver);
		burgerMenuNavigations = new BurgerMenuNavigations(driver);
		visitorOnlinePage = new VisitorOnlinePage(driver);
		settings = new SettingsPage(driver);
		chatHistoryPage = new ChatHistoryPage(driver);
		visitorSiteAccessTest = new VisitorSiteAccessTest();
		newChatNotification = new NewChatNotification(driver);
		notificatiofucntionality = new Notificatiofucntionality(driver);
		baseSetup = new BaseSetup();
		kebabMenuFunctionality = new KebabMenuFunctionality(driver);
		searchFunctionality = new SearchFunctionality(driver);
		emaillogin = new Emaillogin(driver);
		devicetwoTestCase= new DeviceTwoTestCase();
		emaillogintest = new Emaillogintest();
		
		
	}

	public String operatorChatText = "Hi this is Automation testing Operator Message Chat";

	String module = "Settings Page";



	public void settingsPageTest() throws InterruptedException, MalformedURLException, Exception {

		String filepath = filePath();
// 		System.out.println(filepath);

		File file = new File(filepath + "Settings.properties");

		
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
			System.out.println("Automation Case"+property+"="+testcase);
			// String testcase = property;

			System.out.println(testcase);


			switch (testcase) {
				case "Device1 User Login":
// 				System.out.println("Before login");
				emaillogintest.loginUser(testcase);
		
				break;
			case "Device2 User Login":
// 			
				devicetwoTestCase.DeviceTwoLogin(testcase);
			
				break;

			case "Verify if operator clicks on settigs fucntionality, settings page should open":
// 				System.out.println("Settings page open"+testcase);
				settingsPageNavigation(testcase);
				break;
			case "Verify Settings page is open":
				settings.settingsPageOpenCheck(testcase);
				
				break;
			case "Verify visitor Name match with expected user":
				settings.profileNameCheck(testcase,visitorSiteAccessTest.operatorName);
				break;
			case "Verify Operator Status in Settings menu":
				settings.checkStatus(testcase,operatorStatus);
				break;
			case "Verify Profile details page is opening or not":
				settings.openProfileDetails(testcase);
				break;
			case "Check user Assigned Department":
				settings.operatorAssignedDepartmentCheck(testcase,"Marketting");
				settings.operatorAssignedDepartmentCheck(testcase,"Testing Department for salesiq");
				settings.operatorAssignedDepartmentCheck(testcase,"testSalesia");
				break;
			case "Verify Mail id in Settings page":
				settings.checkMaidIdInProfile(testcase,"anbucan@gmail.com");
				actions.navigateToHomePage(testcase);
				break;
			case "Navigate Status Menu":
				settingsPageNavigation(testcase);
				settings.clickStatusMenu(testcase);
				break;
			case "Verify after clicks on Busy":
				settings.clickBusy(testcase);
				actions.backPress(testcase, "navigate to Settings page");
				break;
			case "Verify User status in Settings page after clicks on Busy":
				settings.checkStatus(testcase,dynamicOperatorStatus);
				break;
			case "Verify after clicks on Available Status":
				settings.clickStatusMenu(testcase);
				settings.clickAvailable(testcase);
				break;
			case "Verify User status in Settings page after clicks on Available":
				actions.backPress(testcase, "navigate to Settings page");
				settings.checkStatus(testcase,dynamicOperatorStatus);
				actions.navigateToHomePage(testcase);
				break;
			case "Navigate to ThemeMenu":
				settingsPageNavigation(testcase);
				settings.clickThemesMenu(testcase);
				break;
			case "Verify Theme menu open":
				settings.themesPageOpenCheck(testcase);
				break;
			case "Verify by click on Royal theme":
				settings.selectRoyalTheme(testcase);
				break;
			case "Verify by click on Barbie theme":
				settings.selectBarbieTheme(testcase);
				break;
			case "Verify by click on Teal theme":
				settings.selectTealTheme(testcase);
				break;
			case "Verify by click on Ocean theme":
				settings.selectOceanTheme(testcase);
				break;
			case "Verify by click on Iris theme":
				settings.selectIrisTheme(testcase);
				actions.navigateToHomePage(testcase);
				break;
			case "Navigate to Feedback Menu":
				settingsPageNavigation(testcase);
				settings.clickFeedbackMenu(testcase);
				break;
			case "Verify app Navigate to Feedback Menu":
				settings.feedbackPageOpenCheck(testcase);
				break;
			case "Verify Feedback Menu clickable before enter text":
				settings.checkFeedbackTickClickable(testcase);
				break;
			case "Verify User should be able to enter text in feedback text area":
				settings.enterFeedbackNotes(testcase,"this is for autoamtion testing");
				break;
			case "Verify User should be Send feedback by clicking on tick symbol":
				settings.savefeedbackNotes(testcase);
				break;
			case "Verify application after sending feedback":
				settings.checkAfterFeedbackSave(testcase);
				actions.navigateToHomePage(testcase);
				//actions.getDeviceVersion();
				break;
				
				// these are commented due to notification design changes
				
			case "Navigate to Notfication menu page":
				settingsPageNavigation(testcase);
				settings.clickNotificationMenu(testcase);
				break;
			case "Verify Navigation is open":
				settings.notificationPageOpenCheck(testcase);
				break;
			case "Verify user should be able to off new visitor toggle":
				settings.clickNewVisitorToggle(testcase,"OFF");
				
				break;
			case "Verify user should be able to on new visitor toggle":
				settings.clickNewVisitorToggle(testcase,"ON");
				
				break;
			case "Verify user should be able to OFF returning visitor toggle":
				settings.returningvisitorsToggle(testcase,"OFF");
				
				break;
			case "Verify user should be able to ON returning visitor toggle":
				settings.returningvisitorsToggle(testcase,"ON");
				settings.notificationPageSwipeDown();
				//actions.getDeviceVersion();
				
				break;
			case "Verify user should be able to Off New Message toggle":
				settings.newMessagesToggle(testcase,"OFF");
				
				break;
			case "Verify user should be able to On New Message toggle":
				settings.newMessagesToggle(testcase,"ON");
				
				break;
			case "Verify user should be able to On Operator Message toggle":
				settings.operatorsMessagesToggle(testcase,"ON");
				actions.navigateToHomePage(testcase);
				break;
//			case "Verify New visitor Notification is displayed and user able to click":
//				settings.newvisitorNotificationSettings();
//				break;
//			case "Verify user should be able to select new visitor notification as full screen":
//				settings.newVisitorChatNotiificationSettings("full screen");
//			
//			case "Verify user should be able to Off Operator Message toggle":
//				settings.operatorsMessagesToggle("OFF");
//				break;
			case "Verify Security menu text is as expected":
				settingsPageNavigation(testcase);
				settings.checkSecurityMenuText(testcase,"Security & Privacy");
				settings.clickSecurityMenu(testcase);
				break;
			case "Verify user should be able to navigate to passcode settings page":
				settings.navigatePasscodeSettings(testcase);
				break;
			case "Verify user should be able to enable passcode by clicking in toggle button":
				settings.enableDisablePasscode(testcase);
				
				break;
			case "Verify user should be to selecte passcode type PIN":
				settings.clickPasscodeDropdown(testcase);
				settings.passcodeTypeSelection(testcase,"PIN");
				
				break;
			case "Verify passcode type is same as selected in dropdown":
				settings.selectPasscodeTypeCheck(testcase);
				
				break;
			case "Verify PIN code error message should be same as expected":
				settings.checkErrorMessagePin(testcase,"Must be at least 4 character long");
				
				break;
			case "Verify user should be able to change passcode type as password":
				settings.clickPasscodeDropdown(testcase);
				settings.passcodeTypeSelection(testcase,"PASSWORD");
				break;
			case "Verify user Passcode type is password":
				settings.selectPasscodeTypeCheck(testcase);
				break;
			case "Verify password validation text should be as expected text":
				settings.checkErrorMessagePin(testcase,"Must be at least 4 character long");
				break;
			case "Verify password error message after entering maximum characters":
				settings.enterPasswrod(testcase,"123456789012345678");
				settings.checkErrorMessagePin(testcase,"Must be less than 17 character long");
				break;
			case "Verify clear text option and its text":
				settings.clearText(testcase);
				settings.checkClearTextPassword(testcase);
				settings.enterPasswrod(testcase,"1234");
				settings.clearText(testcase);
				settings.checkClearTextPassword(testcase);
				break;
			case "Verify by enter password and its navigation to re enter password page":
				settings.enterPasswrod(testcase,"1234");
				settings.clickNextPasscode(testcase);
				settings.reEnterPageOpenCheck(testcase);
				break;
			case "verify by entering valid password and navigate to re enter password page":
				settings.enterPasswrod(testcase,"12345");
				settings.clickNextPasscode(testcase);
				settings.reEnterPageOpenCheck(testcase);
				break;
			case "Verify re enter password error validation message":
				settings.PasscodeReneterTextCheck(testcase);
				settings.enterPasswrod(testcase,"123456");
				settings.clickSavePasscode(testcase);
				settings.PasscodeIncorrectReEnterCheck(testcase);
				break;
			case "Verify user should be able to Off Operator Message toggle":
				settings.enterpin(testcase,"1234");
				settings.clearText(testcase);
				settings.checkClearTextPin(testcase);
				
				break;
			case "Verify user should be able to enter pin number":
				settings.enterpin(testcase,"1234");
				
				break;
			case "Verify user should be able to click on next and navigate to re enter pin page":
				settings.clickNextPasscode(testcase);
				
				break;
			case "Verify user should be able to re enter pin":
				settings.enterpin(testcase,"1235");
				
				break;
		
			case "Verify error message should be shown for invalid confirmation pin number":
				settings.clickSavePasscode(testcase);
				settings.PasscodeIncorrectReEnterCheck(testcase);
				
				break;
				
			case "Verify clear text option should be available in Pin page":
				settings.clearText(testcase);
				settings.checkClearTextPin(testcase);
				
				break;
				
			case "verify after enter valid confirmation pin code and save pin, pin code should be enabled":
				settings.enterpin(testcase,"1234");
				settings.clickSavePasscode(testcase);

				break;
				
			case "Navigate to Passcode Lock Page":
				settings.passcodeLockOpenCheck(testcase);
				break;
				
			case "Verify passcode should be be able to change by user":
				settings.openChangePassword(testcase);
				settings.clickPasscodeDropdown(testcase);
				settings.passcodeTypeSelection(testcase,"PIN");
				settings.enterpin(testcase,"1234");
				settings.clickNextPasscode(testcase);
				settings.enterpin(testcase,"1234");
				settings.clickSavePasscode(testcase);
				break;
				
			case "Verify Lock Time menu should be displayed":
				settings.openLockTimeSettings(testcase);
				
				break;
			case "Verify lock time list should be listed as expected":
				settings.checkLockTimeList(testcase);
				
				break;
			case "Verify user should be able to selecte lock time from the list":
				settings.selectLockTime(testcase);
				actions.navigateToHomePage(testcase);
				
				break;
			case "Verify after minimize and maximize application passcode page should be displayed":

				actions.minAndMax(testcase, "Minimize and maximize app");
				
				break;
			case "Verify for more than 3 failed attempts error message should be shown":
				settings.enterpin(testcase,"1");
				actions.pressEnter(testcase);
				settings.enterpin(testcase,"123");
				actions.pressEnter(testcase);
				settings.enterpin(testcase,"12");
				actions.pressEnter(testcase);
				settings.checkInvalidPasswordPopupMessage(testcase,"Maximum invalid attempts reached");
				//settings.checkErrorMessagePin(testcase,"You will be logged out after 3 failed attempts");
				settings.clickInvalidPasswordPopupMessage(testcase);
				
				break;
			case "Login After logout":
				actions.waitTime(3);
				emaillogin.loginButton(testcase);
				actions.waitTime(2);
				emaillogin.enterEmail("anbucan@gmail.com",testcase);
				emaillogin.enterPassword("Automation@123",testcase);
				actions.hideKeyboard(testcase);
				emaillogin.loginUser(testcase);
				actions.waitTime(2);
				break;
			case "Verify analtytics page text should be as expected":
				settings.clickSecurityMenu(testcase);
				settings.checkAnalyticsPageDescText(testcase,
						"Help Zoho SalesIQ improvise your in-app experience by sharing the app's usage statistics with us.");
				
				break;
			case "Verify app should navigate user to analytics page afte clicks on Analytics page":
				settings.analyticsPageNavigation(testcase);
				settings.checkAnalyticsPageOpen(testcase);
				actions.navigateToHomePage(testcase);
				
				
				break;
			case "Navigate to About Us menu":
				settingsPageNavigation(testcase);
				settings.clickAboutUsMenu(testcase);
				
				break;
			case "Verify about us text is same as expected text":
				settings.checkAboutUsMenuText(testcase,
						"Zoho SalesIQ is the best sales conversion platform which helps you to drive more profit to your business and also serve your customers more efficiently. With SalesIQ application, you can track the visitors visiting your website, proactively connect with them and answer their queries through your mobile device from anywhere, and everywhere.");
				actions.backPress(testcase, "back to settings menu");
				actions.navigateToHomePage(testcase);
				
				break;
			case "Get the Current operator status from settings page":
				settingsPageNavigation(testcase);
				settings.getCurrentOperatorStatus(testcase);
				break;
			case "Verify sign out confirmation popup and its text":
				settings.clickSignOut(testcase);
				settings.checkSignOutPopupText(testcase);
				settings.checkSignOutButtonText(testcase);
				
				
				break;
			case "Verify by selecting set busy button and check the operator status in settings page":
				settings.clickSignOutPopupSetBusy(testcase);
				settings.checkStatus(testcase,"Busy");
				break;
			case "Verify by clicking on Sign out in confirmation popup and user should be logout from application":
				settings.clickStatusMenu(testcase);
				settings.clickAvailable(testcase);
				actions.backPress(testcase, "back to settings menu");
				settings.clickSignOut(testcase);
				actions.navigateToHomePage(testcase);
				break;
				
			case "Verify if operator clicks on profile picture profile page should be displayed":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				settings.clickOperatorDP(testcase,module);
				settings.checkProfilePageCheck(testcase, module);
				break;
				
			default:
				break;

			}
		}

	}

	public void settingsPageNavigation(String testcase) {
//		burgerMenuNavigations.burgermenuClick();
		actions.waitTime(2);
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		actions.waitTime(1);
		
		//burgerMenuNavigations.swipeifSettingsNotFound(testcase);

		// burgerMenuNavigations.settingsMenucheck("Settings");
		burgerMenuNavigations.settingsMenuClick(testcase);
		// settings.settingsPageOpenCheck();

	}

// 	public void profileDetailsFlow() throws InterruptedException {
// 		settingsPageNavigation(testcase);
// 		settings.settingsPageOpenCheck();
// 		settings.profileNameCheck(visitorSiteAccessTest.operatorName);
// 		settings.checkStatus(operatorStatus);
// 		settings.openProfileDetails();
// 		settings.operatorAssignedDepartmentCheck("Marketting");
// 		settings.operatorAssignedDepartmentCheck("Testing Department for salesiq");
// 		settings.operatorAssignedDepartmentCheck("privatedepartment");
// 		settings.checkMaidIdInProfile("anbucan@gmail.com");
// //		actions.backPress(module,"navigate to Settings page");
// //		actions.backPress(module,"navigate to Home page");
// 		actions.navigateToHomePage();
// 		Thread.sleep(3000);

// 	}

// 	public void statusMenuFlow() throws InterruptedException {
// 		settingsPageNavigation(testcase);
// 		settings.settingsPageOpenCheck();
// 		settings.clickStatusMenu();
// 		settings.clickBusy();
// 		actions.backPress(module, "navigate to Settings page");
// 		settings.checkStatus(dynamicOperatorStatus);
// 		settings.clickStatusMenu();
// 		settings.clickAvailable();
// //		settings.checkAvailableStatusValue("1");
// 		actions.backPress(module, "navigate to Settings page");
// 		settings.checkStatus(dynamicOperatorStatus);
// 		actions.navigateToHomePage();
// 		Thread.sleep(3000);

// 	}

	// public void themePageExecutionFlow() throws InterruptedException {
	// 	settingsPageNavigation(testcase);
	// 	settings.clickThemesMenu();
	// 	settings.themesPageOpenCheck();
	// 	settings.selectRoyalTheme();
	// 	settings.selectBarbieTheme();
	// 	settings.selectTealTheme();
	// 	settings.selectOceanTheme();
	// 	settings.selectIrisTheme();
	// 	actions.navigateToHomePage();
	// 	Thread.sleep(3000);

	// }

	// public void feedbackExecutionFlow() {
	// 	settingsPageNavigation(testcase);
	// 	settings.clickFeedbackMenu();
	// 	settings.feedbackPageOpenCheck();
	// 	settings.checkFeedbackTickClickable();
	// 	settings.enterFeedbackNotes("this is for autoamtion testing");
	// 	settings.savefeedbackNotes();
	// 	settings.checkAfterFeedbackSave();
	// 	actions.navigateToHomePage();

	// }

// 	public void notificationExecutionFlow() throws InterruptedException {
// 		settingsPageNavigation(testcase);
// 		settings.clickNotificationMenu();
// 		settings.notificationPageOpenCheck();
// 		settings.checkNotificationsPageTitle();
// 		settings.clickNewVisitorToggle("OFF");
// 		settings.clickNewVisitorToggle("ON");
// 		settings.returningvisitorsToggle("OFF");
// 		settings.returningvisitorsToggle("ON");
// 		settings.newMessagesToggle("OFF");
// 		settings.newMessagesToggle("ON");
// 		settings.operatorsMessagesToggle("ON");
// //		burgerMenuNavigations1.swipeBurgerMenu();
// //		burgerMenuNavigations1.operatorMessageMenuClick();
// //		operatorMessage1.selectOperatorIconClick();
// //		operatorMessage1.selectOperatorFromList(visitorSiteAccessTest.operatorName);
// //		operatorMessage1.checkOperatorChatWindowOpen();
// //		operatorMessage1.enterChatToOperator(operatorChatText);
// //		operatorMessage1.sendChatToOperator();
// //		actions.minimizeApplication(module, "Minize application to check Operator message notitification");
// //		actions.waitTime(5);
// //		notificatiofucntionality.openPushNotification();
// //		notificatiofucntionality.checkNotifcationType(visitorSiteAccessTest.operatorName);
// //		notificatiofucntionality.checkNotifcationText(operatorChatText);
// //		actions.backPress(module, "close notification bar");
// //		actions.openApplication(module, "check maximize application ");
// 		settings.operatorsMessagesToggle("OFF");
// 		settings.newvisitorNotificationSettings();
// 		settings.newVisitorChatNotiificationSettings("full screen");
// 		visitorSiteAccessTest.VisitorAccess();
// 		actions.waitTime(10);
// 		newChatNotification.checkFullScreenNewChatOpen();
// 		actions.backPress(module, "Navigate to Notification Settings page");
// 		settings.newvisitorNotificationSettings();
// 		settings.newVisitorChatNotiificationSettings("Push Notification");
// 		visitorSiteAccessTest.checkNewChatInprogress();
// 		actions.waitTime(5);
// 		visitorSiteAccessTest.VisitorAccess();
// 		actions.waitTime(10);
// 		notificatiofucntionality.openPushNotification();
// 		actions.waitTime(3);
// 		notificatiofucntionality.checkNotifcationType("Incoming chat from " + visitorSiteAccessTest.visitorName);
// 		notificatiofucntionality.checkNotifcationText(visitorSiteAccessTest.visitorQuestion);
// 		actions.navigateToHomePage();
// 		Thread.sleep(3000);
// 	}

// 	// this control the passcode test execution flow, since use case is differnt for
// 	// passcode enable and disabled

// 	public void securityExecutionFlow() throws InterruptedException {
// 		settingsPageNavigation(testcase);
// 		settings.checkSecurityMenuText("Security & Privacy");
// 		settings.clickSecurityMenu();
// 		settings.passcodeStatus();
// 		if (settings.passcodestate == false) {
// 			passcodeTestCase();
// 		} else {
// 			disablePascodeTestCase();
// 		}
// 	}

// 	public void passcodeTestCase() throws InterruptedException {

// 		settings.navigatePasscodeSettings();
// 		settings.enableDisablePasscode();
// 		settings.clickPasscodeDropdown();
// 		settings.passcodeTypeSelection("PIN");
// 		settings.selectPasscodeTypeCheck();
// 		settings.checkErrorMessagePin("Must be at least 4 character long");
// 		settings.clickPasscodeDropdown();
// 		settings.passcodeTypeSelection("PASSWORD");
// 		settings.selectPasscodeTypeCheck();
// 		settings.checkErrorMessagePin("Must be at least 4 character long");
// 		settings.enterPasswrod("123456789012345678");
// 		settings.checkErrorMessagePin("Must be less than 17 character long");
// 		settings.clearText();
// 		settings.checkClearTextPassword();

// 		settings.enterPasswrod("1234");

// 		settings.clearText();

// 		settings.checkClearTextPassword();

// 		settings.enterPasswrod("1234");
// 		settings.clickNextPasscode();
// 		settings.reEnterPageOpenCheck();

// 		settings.enterPasswrod("12345");
// 		settings.clickNextPasscode();
// 		settings.reEnterPageOpenCheck();

// 		settings.PasscodeReneterTextCheck();
// 		settings.enterPasswrod("123456");
// 		settings.clickSavePasscode();
// 		settings.PasscodeIncorrectReEnterCheck();

// 		settings.clickPasscodeDropdown();
// 		settings.passcodeTypeSelection("PIN");

// 		settings.enterpin("1234");
// 		settings.clearText();
// 		settings.checkClearTextPin();

// 		settings.enterpin("1234");

// 		settings.clickNextPasscode();
// 		settings.enterpin("1235");
// 		settings.clickSavePasscode();
// 		settings.PasscodeIncorrectReEnterCheck();
// 		settings.clearText();
// 		settings.checkClearTextPin();
// 		settings.enterpin("1234");
// 		settings.clickSavePasscode();

// 		settings.passcodeLockOpenCheck();
// 		settings.openChangePassword();

// 		settings.clickPasscodeDropdown();
// 		settings.passcodeTypeSelection("PIN");
// 		settings.enterpin("1234");
// 		settings.clickNextPasscode();
// 		settings.enterpin("1234");
// 		settings.clickSavePasscode();

// 		settings.openLockTimeSettings();
// 		settings.checkLockTimeList();
// 		settings.selectLockTime();
// 		actions.backPress(module, "navigate security settings page");
// 		actions.backPress(module, "navigate to settings page");
// 		actions.backPress(module, "navigate to Home page");
// 		actions.minAndMax(module, "Minimize and maximize app");
// 		settings.enterpin("1");
// 		actions.pressEnter();
// 		settings.enterpin("123");
// 		actions.pressEnter();
// 		settings.enterpin("12");
// 		actions.pressEnter();
// 		settings.checkInvalidPasswordPopupMessage("Maximum invalid attempts reached");
// 		settings.clickInvalidPasswordPopupMessage();
// 		settings.checkErrorMessagePin("You will be logged out after 3 failed attempts");
// 		emaillogin.loginButton();
// 		actions.waitTime(2);
// 		emaillogin.enterEmail("anbucan@gmail.com");
// 		emaillogin.enterPassword("Automation@123");
// 		emaillogin.loginUser();
// 		actions.waitTime(5);

// //		settings.enterpin("1234");
// //		actions.pressEnter();
// //		Thread.sleep(3000);
// 	}

// 	public void disablePascodeTestCase() throws InterruptedException {
// 		settings.navigatePasscodeSettings();
// 		settings.enterpin("1234");
// 		settings.enableDisablePasscode();
// 		passcodeTestCase();
// 		Thread.sleep(3000);

// 	}

// 	public void analyticsPage() throws InterruptedException {
// 		settingsPageNavigation(testcase);
// 		settings.clickSecurityMenu();
// 		settings.checkAnalyticsPageDescText(
// 				"Help Zoho SalesIQ improvise your in-app experience by sharing the app's usage statistics with us.");
// 		settings.analyticsPageNavigation();
// 		settings.checkAnalyticsPageOpen();
// 		settings.shareUsageToggle("ON");
// 		settings.crashReportToggle("ON");
// 		settings.includeEmailToggle("ON");
// 		settings.includeEmailToggle("OFF");
// 		settings.crashReportToggle("OFF");
// 		actions.navigateToHomePage();
// 		Thread.sleep(3000);
// 	}

// 	public void textCopy() throws InterruptedException {
// 		settingsPageNavigation(testcase);
// 		settings.clickSecurityMenu();
// 		actions.waitTime(3);
// 		settings.textCopyToggle("ON");
// 		actions.navigateToHomePage();
// 		actions.waitTime(2);
// 		burgerMenuNavigations.swipeBurgerMenu(testcase);
// 		burgerMenuNavigations.chatHistoryMenuClick(testcase);
// 		searchFunctionality.clickSearchIcon();
// 		searchFunctionality.enterSearchText("chathst");
// 		chatHistoryPage.chatHistoryPageOpenCheckl();
// 		chatHistoryPage.selectSingleMessage();
// 		chatHistoryPage.checkCopyText();
// 		actions.navigateToHomePage();
// 		Thread.sleep(3000);
// 	}

// 	public void aboutUsExecutionFlow() {
// 		settingsPageNavigation(testcase);
// 		settings.clickAboutUsMenu();
// 		settings.checkAboutUsMenuText(
// 				"Zoho SalesIQ is the best sales conversion platform which helps you to drive more profit to your business and also serve your customers more efficiently. With SalesIQ application, you can track the visitors visiting your website, proactively connect with them and answer their queries through your mobile device from anywhere, and everywhere.");
// 		actions.navigateToHomePage();
// 	}

// 	public void signOutExecutionFlow() {
// 		settingsPageNavigation(testcase);
// 		settings.getCurrentOperatorStatus();
// 		settings.clickSignOut();
// 		settings.checkSignOutPopupText();
// 		settings.checkSignOutButtonText();
// 		settings.clickSignOutPopupSetBusy();
// 		settings.checkStatus("Busy");

// 		settings.clickStatusMenu();
// 		settings.clickAvailable();
// 		actions.backPress(module, "back to settings menu");
// 		settings.clickSignOut();

// 	}

	public static String filePath() {
		URL location = SettingsTest.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		return fileloc;

	}
}
