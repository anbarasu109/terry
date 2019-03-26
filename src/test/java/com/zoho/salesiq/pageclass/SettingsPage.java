//$Id$
package com.zoho.salesiq.pageclass;
import static java.time.Duration.ofSeconds;

import java.util.List;
import java.util.concurrent.locks.Lock;

import javax.imageio.spi.IIORegistry;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.google.common.util.concurrent.Service.State;
import com.mongodb.MongoBulkWriteException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import okhttp3.internal.http2.Settings;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;

public class SettingsPage extends BaseSetup {
	public boolean profilepage;
	public boolean notificationPage;
	public boolean themesPage;
	public boolean feedbackPage;
	public boolean securityPrivacyPage;
	private boolean analyticsPage;
	public boolean aboutusPage;
	public Boolean passcodestate;
	public String passcodeTypeValue="";
	public static String currentOperatorStatus="";
	public static int newVisitorElement;
	public static int returningVisitorElement;
	public static int newChatRequestElement;
	public static int newMessageFromVisitorElement;
	public static int operatorMessageElement;
	

	private String module = "SettingsPage";
	CommonActionMobile actions = new CommonActionMobile(driver);
	Extentreportclass extentreportclass = new Extentreportclass();

	public SettingsPage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver,ofSeconds(5)), this);
	}

	@AndroidFindBy(id = "user_name")
	@CacheLookup
	MobileElement profileName;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/header_dp")
	@CacheLookup
	MobileElement operatorDP;
	
	@AndroidFindBy(id = "status")
	@CacheLookup
	MobileElement status;
	@AndroidFindBy(id = "textview")
	@CacheLookup
	List<MobileElement> profiledetailsValue;
	
	@AndroidFindBy(id = "textview1")
	@CacheLookup
	List<MobileElement> profileDetailsList;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/textview1")
	List<MobileElement> settingsMenuList;
	
	@AndroidFindBy(id = "selectiontickimage")
	@CacheLookup
	MobileElement statusMenuImage;
	
	@AndroidFindBy(id = "selectionview")
	@CacheLookup
	List<MobileElement> statusSelection;
	
	@AndroidFindBy(id = "title_view")
	List<MobileElement> notificationTitle;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/action_switch")
	@CacheLookup
	List<MobileElement> notificationPageToggle;
	
	@AndroidFindBy(className = "android.widget.TextView")
	@CacheLookup
	List<MobileElement> themecolours;
	@AndroidFindBy(id = "theme1")
	@CacheLookup
	MobileElement royalTheme;
	@AndroidFindBy(id = "theme2")
	@CacheLookup
	MobileElement irisTheme;
	@AndroidFindBy(id = "theme3")
	@CacheLookup
	MobileElement barbieTheme;
	@AndroidFindBy(id = "theme4")
	@CacheLookup
	MobileElement tealTheme;
	@AndroidFindBy(id = "theme5")
	@CacheLookup
	MobileElement oceanTheme;
	@AndroidFindBy(id = "editnotes")
	@CacheLookup
	MobileElement feedbackEditNotes;
	@AndroidFindBy(id = "action_save_note")
	@CacheLookup
	MobileElement saveFeedBackNotes;
	@AndroidFindBy(id = "action_nav")
	@CacheLookup
	List<MobileElement> insidesecurityPageNavigation;
	@AndroidFindBy(id = "desc_view")
	@CacheLookup
	List<MobileElement> securityStatus;
	
	@AndroidFindBy(id = "setpinedit")
	@CacheLookup
	MobileElement pincodeEnterPage;
	
	@AndroidFindBy(id = "action_switch")
	MobileElement enableDisablePasscode;
	
	@AndroidFindBy(id = "text1")
	@CacheLookup
	MobileElement passcodeTypeClick;
	
	@AndroidFindBy(className = "android.widget.CheckedTextView")
	List<MobileElement> passcodeTypeSelection;
	
	@AndroidFindBy(id = "setpinedit")
	MobileElement enterPin;
	
	@AndroidFindBy(id = "setpassedit")
	@CacheLookup
	MobileElement enterPassword;
	
	@AndroidFindBy(id = "incorrectpin")
	MobileElement errorMessagePin;
	
	@AndroidFindBy(id = "clearText")
	@CacheLookup
	MobileElement clearTextPin;
	
	@AndroidFindBy(id = "choosepin")
	MobileElement selectPasswordType;
	
	@AndroidFindBy(id = "next")
	@CacheLookup
	MobileElement clickNext;
	
	@AndroidFindBy(id = "action_nav")
	@CacheLookup
	MobileElement changePassword;
	
	@AndroidFindBy(id = "action_text")
	@CacheLookup
	MobileElement locKTime;
	
	@AndroidFindBy(className = "android.widget.CheckedTextView")
	List<MobileElement> lockTimeList;
	
	@AndroidFindBy(className = "android.widget.CheckedTextView")
	List<MobileElement> newVsitorchatNotification;
	
	@AndroidFindBy(className = "android.widget.TextView")
	@CacheLookup
	MobileElement invalidPasscodeMaxReach;
	
	@AndroidFindBy(className = "android.widget.Button")
	@CacheLookup
	MobileElement invalidPasscodeMaxReachButton;
	
	@AndroidFindBy(id = "action_switch_usage")
	MobileElement analyticsActiveUserToggle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Departments']")
	MobileElement profileNavigation;
	
	@AndroidFindBy(id = "action_switch_crash")
	@CacheLookup
	MobileElement analyticsActiveCrashToggle;
	
	@AndroidFindBy(id = "action_switch_email")
	@CacheLookup
	MobileElement analyticsActiveEmailToggle;
	
	
	@AndroidFindBy(className = "android.widget.Switch")
	@CacheLookup
	MobileElement textCopyToggle;
	
	@AndroidFindBy(id = "aboutus_content")
	@CacheLookup
	MobileElement aboutUsContent;
	
	@AndroidFindBy(className = "android.widget.TextView")
	@CacheLookup
	MobileElement signOutPopupText;
	
	@AndroidFindBy(className = "android.widget.Button")
	List<MobileElement> signOutPopupButton;
	

	public void settingsPageOpenCheck(String module) {
		try
		{
		profilepage=actions.isPageOpened(profileName, module,"Verify Settings page is opened");
	}
	catch(Exception e)
	{

	}

	}
	
	public void checkSettingMenuList(String module,String useCase)
	{
		String testCaseName="Verify Settings menu is displayed as expected in settings page";
		try
		{		
		MobileElement settingMenuList=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("SettingMenuList"));
		if(settingMenuList.isDisplayed())
		{
			extentreportclass.mobilepassTest(useCase, testCaseName);
		}
		else
		{
			extentreportclass.mobilefailTest(driver,useCase, testCaseName);
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,useCase, testCaseName);
		}
	}
	
	
	
	
	
	public void notificationPageOpenCheck(String module)
	{
		try{
		notificationPage=actions.isPageOpened(notificationTitle.get(0), module, "Notification Page open check");
		}
	catch(Exception e)
	{
		
	}
	}

	public void profileNameCheck(String module,String profileNameText) {
		try{
		if(profilepage)
		{
		actions.checkText(profileNameText, profileName, module, "check the profile name in Settings page");
		}
		}
	catch(Exception e)
	{
	
	}
	}
	
	
	public void clickOperatorDP(String useCase,String module)
	{
		String testCaseName="Verify operator should be able to click on profile picture";
		try
		{
		actions.clickAction(operatorDP, useCase, testCaseName);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void checkProfilePageCheck(String useCase,String module)
	{
		Boolean pageOpened;
		String testCaseName="Verify if operator clicks on profile DP operator should navigate to profile page";
		try
		{
			pageOpened=actions.isPageOpen(profileNavigation);
			if(pageOpened)
			{
				extentreportclass.mobilepassTest(useCase, testCaseName);
			}
			else
			{
				actions.backPress(useCase, testCaseName);
				extentreportclass.mobilefailTest(driver,useCase, testCaseName);
			}
		}
		catch(Exception e)
		{
			actions.backPress(useCase, testCaseName);
			extentreportclass.mobilefailTest(driver,useCase, testCaseName);
		}
	}

	public void checkStatus(String module,String operatorStatus) {
		try{
		actions.checkText(operatorStatus,status, module, "check status of Operator");
		}
	catch(Exception e)
	{
		
	}
	}

	public void openProfileDetails(String module) {
		try{
		actions.clickAction(profileName, module, "Verify if user clicks on user name Profile Details page should open");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void operatorRoleCheck(String module,String expectedValue)
	{
		try{
		if(profilepage) 
		{
		MobileElement elm = profiledetailsValue.get(0);
		actions.checkText(expectedValue, elm,module, "Operator Role Testing");
		}
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void operatorAssignedDepartmentCheck(String module,String expectedvalue)
	{
		try
		{
		if(profilepage)
	{
		actions.departmentCheckinProfile(profiledetailsValue, expectedvalue, module, "Operator assigned department list expected department  : "+expectedvalue);
	}
}
	catch(Exception e)
	{
		
	}
	}
	public void clickStatusMenu(String module)
	{
		try{
		MobileElement element=settingsMenuList.get(0);
		actions.clickAction(element, module, "Click on status in from menu list");
		}
	catch(Exception e)
	{
		
	}
	}
	public void clickNotificationMenu(String module)
	{
		try{
		MobileElement element=settingsMenuList.get(1);
		actions.clickAction(element,module,"Open notification Menu");
		}
	catch(Exception e)
	{
		
	}
	}
	public void clickThemesMenu(String module)
	{
		try{
		MobileElement element=settingsMenuList.get(2);
		actions.clickAction(element,module,"Verify if operator clicks on Themes menu should Open");
		}
	catch(Exception e)
	{
		
	}
	}
	public void clickFeedbackMenu(String module)
	{
		try{
		MobileElement element=settingsMenuList.get(4);
		actions.clickAction(element, module,"Open notification Menu");
		}
	catch(Exception e)
	{
		
	}
	}
	public void clickSecurityMenu(String module)
	{
		try{
		MobileElement element=settingsMenuList.get(3);
		actions.clickAction(element, module,"Open notification Menu");
		}
	catch(Exception e)
	{
		
	}
	}
	public void clickAboutUsMenu(String module)
	{
		try{
		MobileElement element=settingsMenuList.get(5);
		actions.clickAction(element,module,"Open notification Menu");
		}
	catch(Exception e)
	{
		
	}
	}
	public void clickSignOut(String module)
	{
		try{
		MobileElement element= settingsMenuList.get(6);
		actions.clickAction(element, module, "Click on Sign Out");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void checkAvailableStatusValue(String module,String operatorStatus)
	{
		try{
		actions.checkAttributeValue(statusMenuImage,"instance",operatorStatus, module,"check tick mark located in Available");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void checkMaidIdInProfile(String module,String mail) {
		try{
		if(profilepage) {
		MobileElement element = profiledetailsValue.get(2);
		actions.checkText(mail,element, module, "mail id check in profile details page");
		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void clickBusy(String module)
	{
		try{
			if(profilepage) {
		actions.clickAction(statusSelection.get(1), module, "Click on Busy from list");
		BaseSetup.dynamicOperatorStatus="Busy";
	}
	}
	catch(Exception e)
	{
		
	}
		
	}
	
	public void clickAvailable(String module)
	{
		try{
		if(profilepage) {
		actions.clickAction(statusSelection.get(0), module, "Click on Available from list");
		BaseSetup.dynamicOperatorStatus="Available";
		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void checkbusyStatusValue(String module,String operatorStatus)
	{
try{
		if(profilepage) {
		actions.checkAttributeValue(statusMenuImage,"instance",operatorStatus, module,"check tick mark moved to busy");
	}
	}
	catch(Exception e)
	{
		
	}
	}

	public void checkNotificationsPageTitle(String module)
	{
		try{
		actions.checkTextinList(notificationTitle,"New visitors", module, "check New Visitor Title");
		actions.checkTextinList(notificationTitle,"Returning visitors", module, "check Returning visitors Title");
		actions.checkTextinList(notificationTitle,"New chat request from visitors", module, "check New chat request from visitors Title");
		actions.checkTextinList(notificationTitle,"New message from visitors", module, "check New message from visitors Title");
		actions.checkTextinList(notificationTitle,"Operator messages", module, "check Operator messages Title");
		}
	catch(Exception e)
	{
		
	}
	}

	public void clickNewVisitorToggle(String module,String state)
	{
		String caseName="New Visitor toggle click action = "+state;
		String actualState;
		try{
		boolean status;
		
		
			MobileElement element=notificationPageToggle.get(0);
			actualState=element.getText();
// 			System.out.println("check Visitor"+actualState);
			if(actualState.equalsIgnoreCase("ON"))
			{
				newVisitorElement=2;
			}
			else
			{
				newVisitorElement=1;
			}
			if(actualState.equalsIgnoreCase(state)){
				status =false;
			}
			else {
				actions.clickAction(element, module,caseName);
			}
			actualState=element.getText();
// 			System.out.println("check Visitor"+actualState);
			if(actualState.equalsIgnoreCase("ON"))
			{
				newVisitorElement=2;
			}
			else
			{
				newVisitorElement=1;
			}
			
		}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,caseName);	
	}
		
	}
	
	
	
	public void returningvisitorsToggle(String module,String state)
	{
		String actualState;
		String caseName="Returning Visitor toggle click action = "+state;
		try{
		boolean status;
		
		MobileElement element=notificationPageToggle.get(1+newVisitorElement);
		actualState=actions.getElementText(element);
// 		System.out.println("check Visitor"+actualState);
		if(actualState.equalsIgnoreCase("ON"))
			{
				returningVisitorElement=2+newVisitorElement;
			}
			else
			{
				returningVisitorElement=1+newVisitorElement;
			}
		
		if(actualState.equalsIgnoreCase(state))
{
			status=false;
	}
else {
	actions.clickAction(element,module,caseName);
}
if(actualState.equalsIgnoreCase("ON"))
			{
				returningVisitorElement=2+newVisitorElement;
			}
			else
			{
				returningVisitorElement=1+newVisitorElement;
			}
	}
	
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,caseName);	
	}
	}
	public void newMessagesToggle(String module,String state)
	{
		String actualState;
		try{
		boolean status;
		MobileElement element=notificationPageToggle.get(1+newChatRequestElement);
	 	actualState=actions.getElementText(element);
// 		System.out.println("check Visitor"+actualState);


		if(actualState.equalsIgnoreCase("ON"))
			{
				newMessageFromVisitorElement=2+newChatRequestElement;
			}
			else
			{
				newMessageFromVisitorElement=1+newChatRequestElement;
			}
		
		if(actualState.equalsIgnoreCase(state))
		{
			status = false;
		}
		else {
			actions.clickAction(element, module, "New message toggle click action="+state);
		
		}
		actualState=actions.getElementText(element);
// 		System.out.println("check Visitor"+actualState);


		if(actualState.equalsIgnoreCase("ON"))
			{
				newMessageFromVisitorElement=2+newChatRequestElement;
			}
			else
			{
				newMessageFromVisitorElement=1+newChatRequestElement;
			}
		}
		
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,"New message toggle click action="+state);	
	}
	}
	public void operatorsMessagesToggle(String module,String state)
	{
		String actualState;
		try{
		boolean status;

		MobileElement element=notificationPageToggle.get(1+newMessageFromVisitorElement);
		 actualState=actions.getElementText(element);
// 		System.out.println("check Visitor"+actualState);

		if(actualState.equalsIgnoreCase("ON"))
			{
				operatorMessageElement=2+newMessageFromVisitorElement;
			}
			else
			{
				operatorMessageElement=1+newMessageFromVisitorElement;
			}
		
		if(actualState.equalsIgnoreCase(state))
		{
			status = false;
		}
		else {
			actions.clickAction(element, module, "Operator message toggle click action="+state);
		}
		
		 actualState=actions.getElementText(element);
// 		System.out.println("check Visitor"+actualState);

		if(actualState.equalsIgnoreCase("ON"))
			{
				operatorMessageElement=2+newMessageFromVisitorElement;
			}
			else
			{
				operatorMessageElement=1+newMessageFromVisitorElement;
			}
		}
		
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,"Operator message toggle click action="+state);	
		
	}
	}
	
	public void newvisitorNotificationSettings(String module,String state)
	{
		String actualState;
		boolean status;
		try{
		
		MobileElement element=notificationPageToggle.get(1+returningVisitorElement);
		actualState=actions.getElementText(element);

		if(actualState.equalsIgnoreCase("ON"))
			{
				newChatRequestElement=2+returningVisitorElement;
			}
			else
			{
				newChatRequestElement=1+returningVisitorElement;
			}

		if(actualState.equalsIgnoreCase(state))
		{
			status = false;
		}
		else {
			actions.clickAction(element, module, "Open New Visitor notification settings");
		}
		 actualState=actions.getElementText(element);
// 		System.out.println("check Visitor"+actualState);

		if(actualState.equalsIgnoreCase("ON"))
			{
				newChatRequestElement=2+returningVisitorElement;
			}
			else
			{
				newChatRequestElement=1+returningVisitorElement;
			}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,"Open New Visitor notification settings");	
		
	}
	}


	public void notificationPageSwipeDown()
	{
	int x=BaseSetup.deviceWidthOne;
	int y=BaseSetup.deviceHeightOne;

	actions.swipeOption(x/2,y-10,x/2,10);

	}
	
	public void newVisitorChatNotiificationSettings(String module,String type)
	{
		try{
		if(type.equalsIgnoreCase("Full screen"))
		{
			MobileElement element=newVsitorchatNotification.get(0);
			actions.clickAction(element,module, "Select new visitor notification as full screen");
		}
		else {
		MobileElement element=newVsitorchatNotification.get(1);
				actions.clickAction(element,module, "Select new visitor notification as full screen");
		}
		}
	catch(Exception e)
	{
		
	}
	}
	
	
	
	
	public void themesPageOpenCheck(String module)
	{
		try{
	themesPage=actions.isPageOpened(royalTheme, module, "Theme page Open check");
	}
	catch(Exception e)
	{
		
	}
	}
	public void themecolourCheck(String module)
	{
		try{
		if (themesPage) {
			actions.checkTextinList(themecolours, "Royal", module, "Royal Colour Check");
			actions.checkTextinList(themecolours, "Iris", module, "Iris Colour check");
			actions.checkTextinList(themecolours, "Barbie", module, "Barbie Colour check");
			actions.checkTextinList(themecolours, "Teal", module, "Teal Colour check");
			actions.checkTextinList(themecolours, "Ocean", module, "Ocean Colour check");
		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void selectRoyalTheme(String module)
	{
		try{
		if(themesPage)
		{

		actions.checkElementColor(royalTheme,module, "Select Royal Color displyed",65,142,232);
		actions.clickAction(royalTheme, module, "Select Royal Theme");
		
	}
	}
	catch(Exception e)
	{
		
	}
	}
	public void selectIrisTheme(String module)
	{
		try{
		if(themesPage)
		{
			actions.checkElementColor(irisTheme,module, "Select Iris theme Color displyed",129,104,200);
			actions.clickAction(irisTheme, module, "Select Iris Theme");
		

		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void selectBarbieTheme(String module)
	{
		try{
		if(themesPage)
		{
			actions.checkElementColor(barbieTheme, module, "Select Barbie theme Color displayed",218,70,129);
			actions.clickAction(barbieTheme, module, "Select Barbie theme");
		

		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void selectTealTheme(String module)
	{
		try{
		if(themesPage)
		{
		actions.checkElementColor(tealTheme, module, "Select Teal Theme Color displayed",63,173,155);
		actions.clickAction(tealTheme, module, "Select Teal Theme");

		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void selectOceanTheme(String module)
	{try{

		if(themesPage)
		{
			actions.checkElementColor(oceanTheme, module, "Select Ocean Theme Color displayed",48,172,211);
			actions.clickAction(oceanTheme, module, "Select Ocean Theme");
		}
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void feedbackPageOpenCheck(String module)
	{try{

		feedbackPage=actions.isPageOpened(feedbackEditNotes, module, "Check feedback Page Open");
		}
	catch(Exception e)
	{
		
	}
	}
	public void checkFeedbackTickClickable(String module)
	{
		try{
		if(feedbackPage)
		{
			actions.clickAction(saveFeedBackNotes, module, "Click without enterring any value in feedback page");
			feedbackPage=actions.isPageOpened(feedbackEditNotes, module, "Check without entering feedback value, feedback should not saved");
				
		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void enterFeedbackNotes(String module,String feedback)
	{
		try{
		if(feedbackPage)
		{
	 actions.actionEnter(feedbackEditNotes, feedback,module, "Enter feedback");
		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void savefeedbackNotes(String module)
	{
		try{
		if(feedbackPage)
		{
		actions.clickAction(saveFeedBackNotes, module, "Save Feedback");
		
		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void checkAfterFeedbackSave(String module)
	{
		try{
		MobileElement element = settingsMenuList.get(4);
		actions.isPageOpened(element, module, "After Feedback Save, Settings page should be shown");
		}
	catch(Exception e)
	{
		
	}
	}
	public void checkSecurityMenuText(String module,String expectedText)
	{
		try{
		MobileElement element=settingsMenuList.get(3);
		actions.checkText(expectedText, element, module, "Check security menu text");
		}
	catch(Exception e)
	{
		
	}
	}
	public boolean passcodeStatus(String module)
	{
		try{
		
	MobileElement element=securityStatus.get(0) ;
	String passcodeStatus = actions.getElementText(element);
	if(passcodeStatus.equalsIgnoreCase("ON"))
	{
	passcodestate=true;	
	}
	else {
		passcodestate=false;
	}
	}
	catch(Exception e)
	{
		
	}
return passcodestate;
	}
	
	public void navigatePasscodeSettings(String module)
	{
		try{
			MobileElement element=insidesecurityPageNavigation.get(0);
			actions.clickAction(element, module, "Navigate to Passcode Setting page ");
			}
	catch(Exception e)
	{
		
	}
	}
	
	public void enterPinCode(String module,String passcode)
	{
		try{
		actions.actionEnter(pincodeEnterPage, passcode,module,"Enter passcode if passcode already enabled");	
		}
	catch(Exception e)
	{
		
	}
	}
	public void enableDisablePasscode(String module)
	{
		try{
		actions.clickAction(enableDisablePasscode, module, "Enable or Disable password");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void clickPasscodeDropdown(String module)
	{
		try{
		actions.clickAction(passcodeTypeClick, module, "Click on Passcode dropdown");
		}
	catch(Exception e)
	{
		
	}
	}
	public void passcodeTypeSelection(String module,String passcodeType)
	{
		try{
		if(passcodeType.equalsIgnoreCase("PIN"))
		{
			MobileElement element=passcodeTypeSelection.get(0);
			actions.clickAction(element,module, "Select PIN Type");
			passcodeTypeValue=passcodeType;
		}
		else
		{
			MobileElement element=passcodeTypeSelection.get(1);
			actions.clickAction(element,module, "Select Password Type");	
			passcodeTypeValue=passcodeType;
		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void selectPasscodeTypeCheck(String module)
	{
		try{
		if(passcodeTypeValue.equalsIgnoreCase("PIN"))
		{
			actions.checkText("Select PIN",selectPasswordType, module, "Check select PIN text changing based on passcode type");
		}
		else
		{
			actions.checkText("Select password",selectPasswordType, module, "Check select Password text changing based on passcode type");
			
		}
		}
	catch(Exception e)
	{
		
	}
	}
	
	
	public void checkErrorMessagePin(String module,String errorMesssage)
	{
		try{
		actions.checkText(errorMesssage, errorMessagePin, module, "Check valid error message in PIN");
		}
	catch(Exception e)
	{
		
	}
	}
	
	
	public void enterpin(String module,String pin)	
	{
		try{
	actions.actionEnter(enterPin, pin,module,"Enter Pin Value");
	}
	catch(Exception e)
	{
		
	}
	}
	
	public void enterPasswrod(String module,String password)	
	{
		try{
		actions.actionEnter(enterPassword,password,module,"Enter Pin Value");
		}
	catch(Exception e)
	{
		
	}
	}
	
	
	public void clearText(String module)	
	{
		try{
		actions.clickAction(clearTextPin, module, "Clear Text");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void checkClearTextPin(String module)
	{
		try{
		actions.checkText("", enterPin, module, "Check empty field of pin field after click on clear Text");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void checkClearTextPassword(String module)
	{
		try{
		actions.checkText("", enterPassword, module, "Check empty field of pin field after click on clear Text");
		}
	catch(Exception e)
	{
		
	}
	}

	public void clickNextPasscode(String module)
	{
		try{
		actions.checkText("NEXT",clickNext, module, "Check Next Button text");
		actions.clickAction(clickNext, module, "Click on nex after entering passcode");
		}
	catch(Exception e)
	{
		
	}
	}
	
	
	public void PasscodeReneterTextCheck(String module)
	{
		try{
		if(passcodeTypeValue.equalsIgnoreCase("PIN"))
		{
			actions.checkText("Re-enter PIN",selectPasswordType, module, "Check select PIN text changing based on passcode type");
		}
		else
		{
			actions.checkText("Re-enter password",selectPasswordType, module, "Check select Password text changing based on passcode type");
			
		}
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void PasscodeIncorrectReEnterCheck(String module)
	{
		try{
		if(passcodeTypeValue.equalsIgnoreCase("PIN"))
		{
			actions.checkText("PINs did'nt match! Try again.",selectPasswordType, module, "Check select PIN text changing based on passcode type");
		}
		else
		{
			actions.checkText("Passwords did'nt match! Try again.",selectPasswordType, module, "Check select Password text changing based on passcode type");
			
		}
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void clickSavePasscode(String module)
	{
		try{
		actions.checkText("SAVE",clickNext, module, "Check Save Button text");
		actions.clickAction(clickNext, module, "Click on nex after entering passcode");
		}
	catch(Exception e)
	{
		
	}
	}
	public void reEnterPageOpenCheck(String module)
	{
		try{
		actions.checkText("SAVE",clickNext, module, "Check whether re Enter Page is opened or not");
		}
	catch(Exception e)
	{
		
	}
	}
	public void passcodeLockOpenCheck(String module)
	{
		try{
		actions.isPageOpened(enableDisablePasscode, module, "Passcode Lock Page open Check");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void openChangePassword(String module)
	{
		try{
		actions.clickAction(changePassword, module, "Open Change password");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void openLockTimeSettings(String module)
	{
		try{
		actions.clickAction(locKTime, module, "Open Lock Time List Page");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void checkLockTimeList(String module)
	{
		try{
		actions.checkTextinList(lockTimeList, "Immediately", module, "Lock Time Checking Immediate");
		actions.checkTextinList(lockTimeList, "30 seconds", module, "Lock Time Checking 30 Seconds");
		actions.checkTextinList(lockTimeList, "1 minute", module, "Lock Time Checking 1 Minute");
		actions.checkTextinList(lockTimeList, "5 minutes", module, "Lock Time Checking 5 Minutes");
		actions.checkTextinList(lockTimeList, "30 minutes", module, "Lock Time Checking 30 Minutes");
		actions.checkTextinList(lockTimeList, "1 hour", module, "Lock Time Checking 1 Hour");
		}
	catch(Exception e)
	{
		
	}
		
	}
	
	
	
	public void selectLockTime(String module)
	{
		try{
		MobileElement element=lockTimeList.get(0);
		actions.clickAction(element, module, "Selelct immediatley lock time");
		}
	catch(Exception e)
	{
		
	}
	}
	public void checkInvalidPasswordPopupMessage(String module,String textValue) {
		try{
		actions.checkText(textValue, invalidPasscodeMaxReach, textValue, "Check Invalid passcode maximum reach");
		}
	catch(Exception e)
	{
		
	}
		
	}
	public void clickInvalidPasswordPopupMessage(String module) {
		try{
		
		actions.clickAction(invalidPasscodeMaxReachButton, module,"Click Invalid passcode maximum reach");
		}
	catch(Exception e)
	{
		
	}
		
	}
	
	public void analyticsPageNavigation(String module)
	{
		try{
		MobileElement element=insidesecurityPageNavigation.get(1);
		actions.clickAction(element, module, "Navigate to Analytics page ");
		}
	catch(Exception e)
	{
		
	}	
	}
	
	public void checkAnalyticsPageDescText(String module,String textValue)
	{
		try{
		MobileElement element=securityStatus.get(1) ;
		String passcodeStatus = actions.getElementText(element);
		actions.checkText(textValue, element, module, "Check Analytics Description Text");
		}
	catch(Exception e)
	{
		
	}
	
	}
	
	public void checkAnalyticsPageOpen(String module)
	{
		try{
		
		analyticsPage=actions.isPageOpened(analyticsActiveUserToggle, module, "Check analytics Page Open");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void shareUsageToggle(String module,String state)
	{
		try{
		boolean status;
		if(analyticsPage)
		{
		
		String actualState=actions.getElementText(analyticsActiveUserToggle);
// 		System.out.println("share analytics"+actualState);
		
		if(!actualState.isEmpty()&&actualState.equalsIgnoreCase(state))
		{
			status=false;
		}
		else {
			actions.clickAction(analyticsActiveUserToggle, module, "Share usage click action="+state);
		
		}
		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void crashReportToggle(String module,String state)
	{
		try{
		boolean status;
		if(analyticsPage)
		{
		
		String actualState=actions.getElementText(analyticsActiveCrashToggle);
// 		System.out.println("crash report"+actualState);
		
		if(!actualState.isEmpty()&&actualState.equalsIgnoreCase(state))
		{
			status= false;
		}
		else {
			actions.clickAction(analyticsActiveCrashToggle, module, "Crash Report click action="+state);
		
		}
		}
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void includeEmailToggle(String module,String state)
	{
		try{
		boolean status;
		if(analyticsPage)
		{
		String actualState=actions.getElementText(analyticsActiveEmailToggle);
// 		System.out.println("Include Email"+actualState);
		
		if(!actualState.isEmpty()&&actualState.equalsIgnoreCase(state))
		{
			status =false;
		}
		else {
			actions.clickAction(analyticsActiveEmailToggle, module, "Include Email click action="+state);
		
		}
		}
		}
	catch(Exception e)
	{
		
	}
	}
	public void textCopyToggle(String module,String state)
	{
		try{
		boolean status;
		if(analyticsPage)
		{
		actions.waitTime(2);
			String actualState=actions.getElementText(textCopyToggle);
	// 			System.out.println("Include Email"+actualState);
			
			if(actualState!=null&&actualState.equalsIgnoreCase(state))
			{
				status=false;
			}
			else {
				actions.clickAction(textCopyToggle, module, "Include Email click action="+state);
				
			}
		}
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void getCurrentOperatorStatus(String module)
	{
		try{
		currentOperatorStatus = actions.getElementText(status);
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void checkAboutUsMenuText(String module,String expectedText)
	{
		try{
		actions.checkText(expectedText, aboutUsContent, module, "Check About Us Content");
		}
	catch(Exception e)
	{
		
	}
	}
	
	public void checkSignOutPopupText(String module) {
		try{
		
	//get the Operator Current Status
	
		
	if((currentOperatorStatus!=null)&&currentOperatorStatus.equalsIgnoreCase("Available"))
	{
		actions.checkText("Setting the status as “busy” will also work the same way as “sign out”. Would you prefer to set the status as busy?", signOutPopupText, module, "sign out popup with avaialable status");
		
	}
	else
	{
		actions.checkText("Your status is already set as busy, which will work the same way as “sign out”. Would you still prefer to sign out?", signOutPopupText, module, "sign out popup with Busy status");
		
	}
	}
	catch(Exception e)
	{
		
	}
		
	}
	
	public void checkSignOutButtonText(String module)
	{
		try{
		
		//get the Operator Current Status
		MobileElement element = signOutPopupButton.get(0);
		MobileElement element1 = signOutPopupButton.get(1);
		
	if((currentOperatorStatus!=null)&&currentOperatorStatus.equalsIgnoreCase("Available"))
	{
		actions.checkText("SET BUSY", element, module, "Check sign out popup button text with Avaialable status");
		actions.checkText("CONTINUE SIGN OUT", element1, module, "Check sign out popup button text with Avaialable status");
	}
	else
	{
		actions.checkText("CANCEL", element, module, "Sign out popup button text with Busy status");
		actions.checkText("SIGN OUT", element1, module, "Sign out popup button text with Busy status");
		
	}
	}
	catch(Exception e)
	{
		
	}	
	}
	public void signOutInPopup(String module)
	{
		try{
	
		actions.clickAction(signOutPopupButton.get(1), module, "Click on Sign Out in Sign out popup");
		}
	catch(Exception e)
	{
		
	}	
	}





	
	public void clickSignOutPopupSetBusy(String module)
	{
		try{
		MobileElement element=signOutPopupButton.get(0);
		if(currentOperatorStatus.equalsIgnoreCase("Available"))
		{
		
		actions.clickAction(element, module, "Click on SetBusy in Sign Out Popup");
		currentOperatorStatus="Busy";
		}
		else {
			actions.clickAction(element, module, "Click on cancel in Sign Out Popup");
			clickStatusMenu(module);
			clickAvailable(module);
			actions.backPress(module, "Navigate to Settings Page");
			clickSignOut(module);
			actions.clickAction(element, module, "Click on SetBusy in Sign Out Popup");

}
}
	catch(Exception e)
	{
		
	}
		}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
