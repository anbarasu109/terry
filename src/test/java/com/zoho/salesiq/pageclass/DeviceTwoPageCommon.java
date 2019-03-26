//$Id$
package com.zoho.salesiq.pageclass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.BaseSetupDevice2;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;

public class DeviceTwoPageCommon extends BaseSetupDevice2 {
	private String module = "Devicetwo page Common";
	private static boolean viewInformation, moreInformation;

	private boolean kebabMenuOpen;
	CommonActionMobileDeviceTwo actions = new CommonActionMobileDeviceTwo(driver1);
	Extentreportclass extentreportclass = new Extentreportclass();
	AppiumFieldDecorator appiumFieldDecoratorDeviceTwo;

	public DeviceTwoPageCommon(AndroidDriver driver1) {

		this.driver1 = driver1;
		appiumFieldDecoratorDeviceTwo = new AppiumFieldDecorator(driver1);
		PageFactory.initElements(appiumFieldDecoratorDeviceTwo, this);

	}

	@AndroidFindBy(id = "loginButton")
	// @iOSFindBy(id = "recoverPassword")
	MobileElement loginButton;

	@AndroidFindBy(id = "lid")
	MobileElement emailEnter;

	@AndroidFindBy(id = "pwd")
	MobileElement passwordEnter;

	@AndroidFindBy(id = "title")
	MobileElement checkTransferPopupTitle;

	@AndroidFindBy(id = "negativetext")
	MobileElement clickRejectInTransferPopup;

	@AndroidFindBy(id = "positivetext")
	MobileElement clickAcceptInTransferPopup;

	@AndroidFindBy(className = "android.widget.Button")
	MobileElement loginUser;

	@AndroidFindBy(id = "com.zoho.salesiq:id/dialog_notification_skip")
	MobileElement notificationDialogSkip;

	@AndroidFindBy(id = "button1")
	MobileElement notIntersted;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Online']")
	MobileElement onlineMenu;

	@AndroidFindBy(id = "setpinedit")
	MobileElement passCode;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='History']")
	@CacheLookup
	MobileElement someElements;

	@AndroidFindBy(id = "com.zoho.salesiq:id/chatinfomsgview")
	List<MobileElement> chatActionText;

	@AndroidFindBy(id = "com.zoho.salesiq:id/showmsg")
	List<MobileElement> chatText;

	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemHeadingText")
	List<MobileElement> cannedMessageList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> viewInformationList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/internal_name")
	List<MobileElement> selectOperatorInOperatorChats;

	@AndroidFindBy(id = "com.zoho.salesiq:id/chatactionimage")
	MobileElement cannedMessageIcon;

	@AndroidFindBy(id = "com.zoho.salesiq:id/msgEditText")
	MobileElement sendTextInput;

	@AndroidFindBy(id = "com.zoho.salesiq:id/sendimage")
	MobileElement sendChatText;

	@AndroidFindBy(accessibility = "More options")
	MobileElement kebabMenu;

	@AndroidFindBy(id = "RecyclerView")
	MobileElement checkIndividualChatWindowOpen;

	@AndroidFindBy(id = "title")
	List<MobileElement> kebabMenuList;

	@FindBy(xpath = "//android.widget.TextView[@text='Ongoing']")
	MobileElement ongoingMenuClick;

	@AndroidFindBy(id = "com.zoho.salesiq:id/visitorchat_name")
	List<MobileElement> visitorChatList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/ok_button")
	MobileElement confirmTranslation;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/botjoinlayout")
	MobileElement joinWithOperator;

	@AndroidFindBy(id = "com.zoho.salesiq:id/image_download_button")
	MobileElement imageSharingDownloadIcon;

	@AndroidFindBy(id = "com.zoho.salesiq:id/item_name")
	List<MobileElement> burgerMenuList;

	@AndroidFindBy(className = "android.widget.TextView")
	List<MobileElement> headerText;


	public void loginButton(String testcase) {
		actions.clickAction(loginButton, testcase, "Navigate to Loging page");

	}

	public void operatorChatsMenuClickDeviceTwo(String module) {

		try{
		MobileElement element = burgerMenuList.get(5);
		actions.clickAction(element, module, "Navigate to Operator Chats Page");
		}
	catch(Exception e)
	{
	}
}
	public void joinWithOperatorForChat(String module,String useCase) {
		
		try{
			
			actions.clickAction(joinWithOperator, useCase, "Join With Operator for chat");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver1,module, "Join With Operator for chat");
		}
	}
public void messageBoardMenuClickDeviceTwo(String module,String categories) {

		try{
		MobileElement element = burgerMenuList.get(6);
		actions.clickAction(element, module, "Navigate to Message Board Page");
		}
	catch(Exception e)
	{
	}
}

public void checkActiveOperatorCountInMessageBoard(String useCase,String categories,String expectedCount)
	{
		String testCase="Verify expected Active Operator count " +expectedCount+ " in the message Board if new active operator added";

		try{


		actions.textContainsText(headerText.get(1),expectedCount,useCase,testCase);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver1,useCase,testCase);

	}
	}






	public void openOngoingMenu(String module) {
		actions.clickAction(ongoingMenuClick, module, "Navigate to Online Menu");
	}

	public void enterEmail(String email,String testcase) {
		try {
			actions.actionEnter(emailEnter, email, testcase, "Enter Email address for login");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}

	public void enterPassword(String password,String testcase) {
		try {
			actions.actionEnter(passwordEnter, password, testcase, "Enter Password for login");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}

	public void loginUser(String testcase) {
		actions.clickAction(loginUser, testcase, "Click on Login Button for login");
	}

	public void clickNotInterested(String testcase) {
		if (actions.iselemetFound(notIntersted)) {
			actions.clickAction(notIntersted, testcase, "Click on Not Interested");
		}

	}

	public void acceptCrashReport(String module) {
		try {
			actions.clickAction(notIntersted, "Login", "Click on Not interested in crash reporting");
			driver1.getPerformanceData("com.zoho.salesiq", "cpuinfo", 5000);
		} catch (Exception e) {
		}

	}

	public void selectVisitorFromList(String module) {
		try {
			actions.clickAction(visitorChatList.get(0), module, "Selelct One user from Ongoing List");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver1,module, "Selelct One user from Ongoing List");
		}
	}

	public void skipNotificationDialog(String module) {
		try {
			if (notificationDialogSkip.isDisplayed()) {
				actions.clickAction(notificationDialogSkip, "Login", "Click on Skip in Notification dialog");
			}
		} catch (Exception e) {
		}
	}

	public void clickRejectTransferChat(String module) {
		String caseName = "Click on Reject transfer chat in Popup";
		try {
			if (clickRejectInTransferPopup.isDisplayed()) {

				actions.clickAction(clickRejectInTransferPopup, module,
						"Click on reject in Chat transfer Popup");
				extentreportclass.mobilepassTest(module, caseName);
			} else {
				extentreportclass.mobilefailTest(driver1,module, caseName);
			}

		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver1,module,caseName);
		}

	}
	public void confirmTranslation(String module) {
			try {
				actions.clickAction(confirmTranslation, module, "Confirm Translation");
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver1,module, "Confirm Translation");
			}
	}

	public void clickAcceptTransferChat(String module) {
		String caseName = "click on Accept transfer chat in Popup";
		try {
			
				actions.clickAction(clickAcceptInTransferPopup, module,
						"Click on reject in Chat transfer Popup");
				extentreportclass.mobilepassTest(module, caseName);

		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver1,module, caseName);
		}

	}

	public void enterPasscode(String module,String code) {
		passCode.sendKeys(code);
	}

	public void clickOngoing() throws InterruptedException, IOException {

//		driver.openNotifications();

//		MobileElement textOngoing = (MobileElement)driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Ongoing\")");
//		textOngoing.click();
//		
//		
//		
//		driver.pushFile("/path/to/device/foo.bar", new File("/Users/johndoe/files/foo.bar"));
		WebDriverWait wait = new WebDriverWait(driver1, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/header_status_change_track")));
//		statusChange.click();
//		
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='History']")));
		someElements.click();
//
//	
//
		WebDriverWait wait2 = new WebDriverWait(driver1, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("visitname")));

		List<MobileElement> elements = driver1.findElementsById("visitname");

		elements.get(0).click();

//
//		WebDriverWait wait3 = new WebDriverWait(driver, 20);
//		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/showmsg")));
//
////		AndroidElement element1= (AndroidElement)driver.findElement(By.id("com.zoho.salesiq:id/showmsg"));
////		TouchAction action = new TouchAction(driver);
////		action.longPress(element1).waitAction(100).release().perform();
//
////		burger.click();
////		WebDriverWait wait1 = new WebDriverWait(driver,20);
////		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Online']")));
////		onlineMenu.click();
//		WebDriverWait wait1 = new WebDriverWait(driver, 20);
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/item_name")));
//		List<WebElement> elementName = driver.findElementsById("com.zoho.salesiq:id/item_name");
//		System.out.println(elementName.size());

	}

	public void dpClick() {
//		WebDriverWait wait2 = new WebDriverWait(driver, 20);
//		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/header_dp")));
//		MobileElement eleme = driver.findElement(By.id("com.zoho.salesiq:id/header_dp"));
//		eleme.click();

	}

	public void getListProfile(String module) {
		WebDriverWait wait2 = new WebDriverWait(driver1, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/textview")));
		List<MobileElement> eleme = driver1.findElements(By.id("com.zoho.salesiq:id/textview"));
		String val = eleme.get(2).getText();

	}

	public void checkTransferChatText(String module) {
		boolean status;
		String caseName = "Check Transfer Chat popup text";

		try {
			status = actions.checkText("operator MPTEST has transferred a support to you", checkTransferPopupTitle,
					module, caseName);
			if (status = true) {
				extentreportclass.mobilepassTest(module, caseName);
			} else {
				extentreportclass.mobilefailTest(driver1,module, caseName);
			}

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver1,module, caseName);
		}
	}

	public void checkInviteChatText(String module) {
		boolean status;
		String caseName = "Verify chat transfer text after chat transfer has been done";

		try {
			status = actions.checkText("operator MPTEST has transferred a support to you", checkTransferPopupTitle,
					module, caseName);
			if (status = true) {
				extentreportclass.mobilepassTest(module, caseName);
			} else {
				extentreportclass.mobilefailTest(driver1,module, caseName);
			}

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver1,module, caseName);
		}
	}

	public void checkChatTransferNotification(String module) {

		String actualValue = "";
		String expectedValue = "operator MPTEST has transfered chat to you";
		String caseName = "Check Transfer Chat notitification text";

		try {

			actualValue = actions.getPageSourceValue("android.view.ViewGroup", 6, "android.widget.TextView", 2);
			if (!actualValue.isEmpty()) {
				if (actualValue.equalsIgnoreCase(expectedValue)) {
					extentreportclass.mobilepassTest(module, caseName);
				} else {
					extentreportclass.mobilefailTest(driver1,module, caseName);
				}
			}

			
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver1,module, caseName);
		}

	}

	public void checkChatInviteNotification(String module) {

		String actualValue = "";
		String expectedValue = "operator MPTEST has added you to the chat conversation";
		String caseName = "Check Invite Chat notitification text";

		try {

			actualValue = actions.getPageSourceValue("android.view.ViewGroup", 6, "android.widget.TextView", 2);
			if (!actualValue.isEmpty()) {
				if (actualValue.equalsIgnoreCase(expectedValue)) {
					extentreportclass.mobilepassTest(module, caseName);
				} else {
					extentreportclass.mobilefailTest(driver1,"Ongoing Chat", caseName);
				}
			}

			
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver1,module, caseName);
		}

	}

	public void checkImageSharedWithOperatorTwo(String useCase,String categories)
	{
		String caseName="Check Shared Image transfered to Operator two";
		try
		{

		if(imageSharingDownloadIcon.isDisplayed())
		{
			extentreportclass.mobilepassTest(useCase, caseName);
			
		}
		else
		{
			extentreportclass.mobilefailTest(driver1,useCase, caseName);


		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver1,useCase, caseName);

	}
	}


	public void clickDownloadIcon(String useCase,String categories) {
		String caseName="Verify operator should be able to click on download icon";
		try
		{

		actions.clickAction(imageSharingDownloadIcon,useCase,caseName);
		}
		catch(Exception e )
		{
			extentreportclass.mobilefailTest(driver1,useCase,caseName);

		}

	}

	public void checkImageDownloaded(String useCase,String categories)
	{
		String caseName="Check After click on download imae, image should be downloaded";
		try
		{

		if(!imageSharingDownloadIcon.isDisplayed())
		{
			extentreportclass.mobilepassTest(useCase, caseName);
			
		}
		else
		{
			extentreportclass.mobilefailTest(driver1,useCase, caseName);


		}
	}
	catch(Exception e)
	{
			extentreportclass.mobilepassTest(useCase, caseName);
		
	}

	}







	public void checkActionText( String module,String expectedText,String testcase) {
		
		String caseName = testcase;
			try {
				int value = chatActionText.size();
				if (value > 0) {
					actions.checkText(expectedText, chatActionText.get(value - 1), "Ongoing Chat", caseName);
				} else {
					extentreportclass.mobilefailTest(driver1,module, caseName);
				}
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver1,module, caseName);
			}
		} 
	

	public void checkChatTextOfInvitedOperator(String module,String expectedText) {
		String caseName = "Check whether invited operator receive Chat text";

		int value = chatText.size();
		try {

		if (value > 0) {
			

				actions.checkText(expectedText, chatText.get(value - 1),module, caseName);

			} 
			else {
				extentreportclass.mobilefailTest(driver1,module, caseName);
		}
		}
			catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver1,module, caseName);
			}
	}

	public void enterChatText(String module,String sendText) {
		try
		{
		
		actions.actionEnter(sendTextInput, sendText,module, "Verify Operator2 able to enter text after chat invite");
		}
		catch(Exception e)
		{
			
		}
	}


public void enterTextInChatInputField(String module,String categories,String caseName,String sendText) {
	try{

		actions.actionEnter(sendTextInput,sendText,module,caseName);
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver1,module,caseName);
	}
	}

	public boolean checkEnterTextField(String module) {
		boolean result=false;
		String caseName = "Check chat input field is displayed after successfull transfer and accept";
		try
		{
		
		if (sendTextInput.isDisplayed()) {
			extentreportclass.mobilepassTest(module, caseName);
			result=true;
		} else {
			extentreportclass.mobilefailTest(driver1,module, caseName);
			result=false;
		}
	}
	catch(Exception e )
	{
		extentreportclass.mobilefailTest(driver1,module, caseName);
	result=false;
	}
	return result;
	}

	public void sendTextToVisitor(String module) {
		try
		{

		actions.clickAction(sendChatText, module, "Verify Operator2 able to Send text after chat invite");
		}
		catch(Exception e )
		{

		}

	}

	public void sendTextFromChatWindow(String module,String categories,String testcase) {
		try
		{

		actions.clickAction(sendChatText, module, testcase);
		}
		catch(Exception e )
		{
			extentreportclass.mobilefailTest(driver1,module, testcase);

		}

	}

	public void clickKebabMenu(String module) {
try
{
		actions.clickAction(kebabMenu, module, "Send chat text");
	}
	catch(Exception e)
	{

	}

	}

	public void checkKebabMenuFunctionality(String module,String expectedText,String testCase) {

		boolean status = actions.checkTextinList(kebabMenuList, expectedText,module, testCase+" "+expectedText);
		if (status) {
			extentreportclass.mobilepassTest(module, testCase+" "+expectedText);
		} else {
			extentreportclass.mobilefailTest(driver1,module, testCase + " not available : " + expectedText);

		}

	}

	public void checkDepartmentNameInCanned(String module,String expectedText) {
		try {
			if (cannedMessageList.size() > 0) {
				actions.textContainsText(cannedMessageList.get(2), expectedText, module,
						"Check Department Name in Canned Message list Department Name :" +expectedText);
				extentreportclass.mobilepassTest(module, "Check Department Name in Canned Message list");
			} else {
				extentreportclass.mobilefailTest(driver1,module, "Check Department Name in Canned Message list");

			}
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver1,module, "Check Department Name in Canned Message list");
		}
	}

	public void openCannedMessage(String module) {
		String caseName = "Open canned message list";
		try {
			if (cannedMessageIcon.isDisplayed()) {
				actions.clickAction(cannedMessageIcon,module, caseName);
				extentreportclass.mobilepassTest(module, caseName);

			} else {
				extentreportclass.mobilefailTest(driver1,module, caseName);
			}
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver1,module, caseName);
		}
	}

	public void selectMenuFroMKebab(String module,String menuItem) {
		try{
		actions.selectBasedonTextInList(kebabMenuList, menuItem, module, "Click on Kebab Menu Item");
	}
	catch(Exception e)
	{

	}
	}

	public void selectOperatorFromList(String useCase,String categories,String operatorName) {
		String caseName = "Select Operator from Operator chats List";
		try{
		actions.selectBasedonTextInList(selectOperatorInOperatorChats,operatorName,useCase,caseName);
		}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver1,useCase,caseName);
	}
	}


	public void checkViewInformationDepartment(String module,String text) {
		try {
			viewInformation = actions.checkText(text, viewInformationList.get(3), module, "");

		} catch (Exception e) {

		}
	}

	public void checkmoreInformationDepartment(String module,String text) {
		String caseName = "Check Moreinformation and viewInformation department name after department based chat Transfer";

		try {
			moreInformation = actions.checkText(text, viewInformationList.get(4), module, caseName);

			if (moreInformation = true && viewInformation == true) {
				extentreportclass.mobilepassTest(module, caseName);
			} else {
				extentreportclass.mobilefailTest(driver1,module, caseName);
			}

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver1,module, caseName);
		}
	}

	public void checkOperatorChatPageOpen(String module) {
		String caseName = "Check Operator chat should be shown after click on chat with operator menu";
		try {
			if (checkIndividualChatWindowOpen.isDisplayed()) {
				extentreportclass.mobilepassTest(module, caseName);

			} else {
				extentreportclass.mobilefailTest(driver1,module, caseName);
			}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver1,module, caseName);

		}

	}
}

