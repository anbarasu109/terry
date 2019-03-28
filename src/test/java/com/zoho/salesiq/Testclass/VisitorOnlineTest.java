//$Id$
package com.zoho.salesiq.Testclass;

import java.awt.Checkbox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import org.testng.annotations.Test;
import com.zoho.salesiq.pageclass.BaseSetup;
import com.zoho.salesiq.pageclass.BurgerMenuNavigations;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.SettingsPage;
import com.zoho.salesiq.pageclass.VisitorOnlinePage;
import com.zoho.salesiq.pageclass.NewChatNotification;
import com.zoho.salesiq.pageclass.CRMIntegreationFunctionality;
import com.zoho.salesiq.pageclass.MoreInformationFucntionality;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
import com.zoho.salesiq.Testclass.MissedChatTest;
import com.zoho.salesiq.pageclass.KebabMenuFunctionality;
import io.appium.java_client.android.Activity;

public class VisitorOnlineTest extends BaseSetup {

	private String module = "Visitor Online";
	private VisitorSiteAccessTest visitorsitetest;
	private Notificatiofucntionality notificationfunctionality;
	private SettingsTest settingtest;
	private SettingsPage settingspage;
	private CommonActionMobile actions;
	private BurgerMenuNavigations burgerMenuNavigations;
	private VisitorOnlinePage visitorOnlinePage;
	private Emaillogintest emaillogintest;
	private KebabMenuFunctionality kebabMenuFunctionality;
	private NewChatNotification newchatnotification;
	private CRMIntegreationFunctionality crmIntegreationFunctionality;
	private MissedChatTest missedchattest;
	private MoreInformationFucntionality moreinformationfunctionality;

	public VisitorOnlineTest() {
		actions = new CommonActionMobile(driver);
		burgerMenuNavigations = new BurgerMenuNavigations(driver);
		visitorOnlinePage = new VisitorOnlinePage(driver);
		visitorsitetest = new VisitorSiteAccessTest();
		notificationfunctionality = new Notificatiofucntionality(driver);
		settingspage = new SettingsPage(driver);
		settingtest = new SettingsTest();
		emaillogintest = new Emaillogintest();
		kebabMenuFunctionality = new KebabMenuFunctionality(driver);
		newchatnotification = new NewChatNotification(driver);
		crmIntegreationFunctionality = new CRMIntegreationFunctionality(driver);
		missedchattest = new MissedChatTest();
		moreinformationfunctionality=new MoreInformationFucntionality(driver);

	}

	
	public void visitorOnline() throws InterruptedException,Exception
	{
		
		
		String filepath = filePath();
// 		System.out.println(filepath);

		File file = new File(filepath+"VisitorOnline.properties");
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
		}finally {
		    if (fileInput!=null) {
		    	fileInput.close();
		    }
		}
		

		Set<String> keys = prop.stringPropertyNames();
		TreeSet<String> sortedSet = new TreeSet<String>(keys);
		// Collections.sort(List<keys>);
		for (String property : sortedSet) {

			String value = prop.getProperty(property);
// 			System.out.println(property + "=" + value);

			String testcase = value;
			System.out.println("Automation Case"+property+"="+testcase);
			switch (testcase) {
			case "Login User":
// 				System.out.println("Before login");
				emaillogintest.loginUser(testcase);
// 				System.out.println("after login");
				break;
			case "check Notification of New Visitor":
				actions.navigateToHomePage(testcase);
				visitorOnlinePage.checkVisitorOnlineRing(module, testcase);
				checkNewUserNotification(testcase);
				break;
			case "check New Notification Text":
				notificationfunctionality.openPushNotification(testcase);
				notificationfunctionality.checkNotifcationText(testcase,"Automation has dropped by your website");
				actions.backPress(testcase,"Close Notification bar");

				break;
			case "Cick on View Info User should be navigate to Visitor Online details page":
				notificationfunctionality.clickViewInfo(testcase);
				actions.waitTime(3);
				visitorOnlinePage.checkvisitoDetailsPageOpen(testcase);
				break;
			case "Check Visitor Count in Online Menu":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				visitorOnlinePage.checkOnlineVisitorCountMenu(testcase);
				actions.backPress(testcase,"close menu");
				// browser here to create new visitor again
				break;
			case "Initiate chat in Push Notification":
				actions.minimizeApplication(testcase,"Minimize application to receive new visitor Notification");
				visitorsitetest.accessSalesiqSite(testcase);
				//wait for push notification to arrive
				actions.waitTime(2);
				notificationfunctionality.openPushNotification(testcase);
				notificationfunctionality.clickInitiateChat(testcase);
				visitorOnlinePage.initiateChatPageOpenCheck(testcase);
				break;
			case "check Department list":
				visitorOnlinePage.checkDepartmentNameinDropdown(testcase,"testSalesia");
				visitorOnlinePage.checkDepartmentNameinDropdown(testcase,"Marketting");
				visitorOnlinePage.checkDepartmentNameinDropdown(testcase,"Testing Department for salesiq");
				break;
			case "select department From list":
				visitorOnlinePage.selectDepartmentFromList(testcase,visitorsitetest.departmentName);
				
				break;
			case "check Chat page open after department selection":
				visitorOnlinePage.checkChatPageAfterSelectDepartment(testcase);
				break;
			case "check New User Notification at killed state":
				
				actions.killApplication(testcase);
				visitorsitetest.accessSalesiqSite(testcase);
				//wait for push notification to arrive
				actions.waitTime(2);
				notificationfunctionality.openPushNotification(testcase);
				notificationfunctionality.checkNotifcationText(testcase,"Automation has dropped by your website");
				driver.startActivity(new Activity("com.zoho.salesiq",".MainActivity"));
				break;
			case "Click on Initiate chat at application killed state":
				notificationfunctionality.openPushNotification(testcase);
				notificationfunctionality.clickInitiateChat(testcase);
				visitorOnlinePage.initiateChatPageOpenCheck(testcase);
				
				break;
			case "Click on View info action at application killed state":
				visitorsitetest.accessSalesiqSite(testcase);
				actions.waitTime(2);
				notificationfunctionality.openPushNotification(testcase);
				notificationfunctionality.clickViewInfo(testcase);
				visitorOnlinePage.checkvisitoDetailsPageOpen(testcase);
				// visitorsitetest.quitBrowser();
				actions.navigateToHomePage(testcase);
				
				break;
			case "Check visitor count in Menu after killed and open application":
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				visitorOnlinePage.checkVisitorCountBeforeAccess(testcase);
				actions.killApplication(testcase);
				actions.lauchApplicationAfterKill(testcase);
				actions.waitTime(2);
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				visitorOnlinePage.checkVisitorCountAfterKillandOpen(testcase);
				
				//neeed to include ring view also
				break;
			case "Click on Online menu, navigate to Online apge":
				burgerMenuNavigations.openOnlineMenu(testcase);
				break;
			case "Online Menu should contain two pages":
				visitorOnlinePage.checkVisitorOnlineRing(module, testcase);
				visitorOnlinePage.checkListAndRingIcon(module,testcase);
				break;
			case "Open List page":
				visitorOnlinePage.openOnlineListPage(testcase);
				visitorOnlinePage.checkListPageOpen(testcase);
				break;
			case "Check Visitor Filter in List":
				visitorOnlinePage.checkTimeFilterBasedCondition(testcase);
				
				break;
			case "Verify in Online List page all required information displayed":
				visitorOnlinePage.checkRequiredUIinOnlineList(testcase);
				visitorOnlinePage.checkSiteAccessTypeIcon(module,testcase);
				break;
			case "Verify for new Visitor Random number should be displayed":
				visitorOnlinePage.checkRandomValueForNewVisitor(testcase);
				break;
			case "Open Online visitor Details page":
				visitorOnlinePage.openFirstListinOnline(testcase);
				visitorOnlinePage.checkOperatorInitiateChatIcon(module, testcase);
				break;
			case "Verify for new Visitor, following information will be shown for New User 1) Foot Path 2) More Information":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				visitorOnlinePage.checkTextInKebabMenu(testcase);
				break;
			case "Verify if user clicks on foot path, all actions performed by visitor will be listed there":
				kebabMenuFunctionality.footPathMenu(testcase);
				visitorOnlinePage.checkFootPathPageOpen(testcase);
				visitorOnlinePage.footPathAction(testcase);
				actions.backPress(testcase, "navigate to Online details page");
				
				break;
			case "Verify for new visitor chat should be able to initiate":
				actions.waitTime(5);
				visitorsitetest.visitorAccessWithMail(testcase);
				newchatnotification.pickupChat(testcase);
				actions.navigateToHomePage(testcase);
				burgerMenuNavigations.swipeBurgerMenu(testcase);
				burgerMenuNavigations.openOnlineMenu(testcase);
				visitorOnlinePage.openOnlineListPage(testcase);
				visitorOnlinePage.checkListPageOpen(testcase);
				break;
			case "Verify if user clicks on CRM information, Respective CRM information should be displayed for respective User":
				kebabMenuFunctionality.crmInformation(testcase);
				break;
			case "Verify CRM fields in CRM View information page":
				crmIntegreationFunctionality.checkLeadOwner(testcase,missedchattest.crmLeadManager);
				crmIntegreationFunctionality.checkLeadSource(testcase,"Chat");
				crmIntegreationFunctionality.checkLeadCity(testcase,"Chennai");
				break;
			case "Verify Create Potential Page is shown in Online CRM information page":
				visitorOnlinePage.checkCreatePotentialNotShown(testcase);
				actions.backPress(testcase, "navigate to Online details page");
				
				break;
			case "Verify New visitor More information page":
				kebabMenuFunctionality.clickKebabMenu(testcase);
				kebabMenuFunctionality.moreInformation(testcase);
				moreinformationfunctionality.checkNewVisitorIPAddress(testcase);
				moreinformationfunctionality.checkNewVisitorBrowser(testcase);
				moreinformationfunctionality.checkNewVisitorRegion(testcase);
				actions.backPress(testcase, "navigate to Online details page");
				actions.backPress(testcase, "navigate to list page");
				break;
			case "Verify if Visitor left site, repective user should removed from Visitor List View":
				// visitorsitetest.getBrowsingCookie();
				// visitorsitetest.quitBrowser();
				// actions.waitTime(60);
				// visitorOnlinePage.checkVisitorOnlineAfterLeftSite();
				// actions.navigateToHomePage(testcase);
				break;
			case "Verify visitor in Ring One based on access time":
				
				visitorOnlinePage.checkVisitorRingOneAccess(testcase);
				break;
			case "Verify visitor in Ring two based on access time":
				
				visitorOnlinePage.checkVisitorRingTwoAccess(testcase);
				break;
			case "Verify visitor in Ring Three based on access time":
				
				visitorOnlinePage.checkVisitorRingThreeAccess(testcase);
				break;
			case "Verify visitor in Ring Four based on access time":
				visitorOnlinePage.checkVisitorRingFourAccess(testcase);
				break;
			case "Verify access site by repeated Visitor":
				visitorsitetest.startBrowser(testcase);
				actions.minimizeApplication(testcase, "Minimize application to receive Repeated visitor Notification");
				visitorsitetest.accessdummysiteSite(testcase);
				visitorsitetest.setBrowsingCookie(testcase);
				visitorsitetest.accessSalesiqSite(testcase);
				break;
			default:
				break;

			}
		}



		


		
		
		
		
		
		
		
				
		
		
		
		

		
		
		
		
		
	
	
	}

	public void checkNewUserNotification(String testcase) {
		burgerMenuNavigations.swipeBurgerMenu(testcase);
		actions.getPageSourceCoOrdinateValue("android.widget.RelativeLayout",18,"android.widget.TextView",0);
		visitorOnlinePage.checkVisitorCountBeforeAccess(testcase);
		actions.backPress(testcase, "close menu");
		actions.minimizeApplication(testcase, "Minimize application to receive new visitor Notification");
		visitorsitetest.accessSalesiqSite(testcase);
		actions.waitTime(5);// wait for new visitor push notification
		notificationfunctionality.openPushNotification(testcase);
		actions.waitTime(3);
		notificationfunctionality.checkNotifcationType(testcase,"New visitor online");
		actions.openApplication(testcase,"Open Application");
	}

	public static String filePath() {
		URL location = SettingsTest.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		return fileloc;

	}

}
