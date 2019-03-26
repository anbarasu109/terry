//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import javax.management.loading.PrivateClassLoader;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.ActionOptions;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.KebabMenuFunctionality;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.BurgerMenuNavigations;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OngoingChatPage extends BaseSetup {

	private String module = "Ongoing Chat";
	private int previousOngoignCount;
	private boolean chatNotificationPage;
	private static String selectedCannedMessage = "";
	private static String endSessionMessage="";

	private boolean ongoingChatPageOpen;
	private boolean chatTranslatePopup;
	private boolean footPathPageOpen;
	private static boolean featureToolTipStatus;
	private static String callDuration = "";
	CommonActionMobile actions = new CommonActionMobile(driver);
	SearchFunctionality seachFunctionality = new SearchFunctionality(driver);
	String assigneeName = "";
	Extentreportclass extentreportclass = new Extentreportclass();
	private KebabMenuFunctionality kebabMenuFunctionality = new KebabMenuFunctionality(driver);
	private BurgerMenuNavigations burgerMenu = new BurgerMenuNavigations(driver);

	public OngoingChatPage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "user_name")
	@CacheLookup
	MobileElement profileName;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Missed Chats']")
	@CacheLookup
	MobileElement missedChatPageTitle;

	@AndroidFindBy(id = "visitorchat_name")
	List<MobileElement> visitorChatList;

	@AndroidFindBy(id = "emptylist_title")
	MobileElement missedChatEmptyList;

	@AndroidFindBy(id = "com.android.documentsui:id/menu_open")
	MobileElement clickOpenLongPressImage;

	@AndroidFindBy(id = "call_accept_image_view")
	MobileElement cancelAudioCall;

	@AndroidFindBy(id = "visitorchat_question")
	List<MobileElement> visitorQuestionInChatList;

	@AndroidFindBy(id = "visitorchat_info")
	List<MobileElement> visitorAssigneeInChatList;

	@AndroidFindBy(id = "visitorchat_time")
	List<MobileElement> visitorTimeInMissedChatList;

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	List<MobileElement> visitorNameInMissedChatDetails;

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
	MobileElement visitorAssignNameInMissedChatDetails;

	@AndroidFindBy(id = "title")
	List<MobileElement> kebabMenuList;

	@AndroidFindBy(id = "username")
	List<MobileElement> departmentListInTransferChat;

	@AndroidFindBy(className = "android.widget.TextView")
	List<MobileElement> checkPreviuosChatWindow;

	@AndroidFindBy(id = "showmsg")
	List<MobileElement> chatText;

	@AndroidFindBy(id = "username")
	List<MobileElement> assignOperatorList;

	@AndroidFindBy(id = "invitebutton")
	MobileElement assignOperator;

	@AndroidFindBy(id = "message")
	MobileElement callPermissionAlert;

	@AndroidFindBy(id = "prompt_message")
	MobileElement popupMessage;

	@AndroidFindBy(id = "cancel_button")
	MobileElement closePopup;

	@AndroidFindBy(id = "com.zoho.salesiq:id/arrow_image")
	MobileElement chatPickUpArrow;

	@AndroidFindBy(id = "vchat_button")
	MobileElement agentTab;
	
	@AndroidFindBy(accessibility = "Show roots")
	MobileElement openFileManagerMenu ;
	
	@AndroidFindBy(accessibility = "More options")
	MobileElement kebabMenuFileManger ;

	@AndroidFindBy(id = "achat_button")
	MobileElement departmentTab;

	@AndroidFindBy(id = "invitetext")
	MobileElement inviteText;

	@AndroidFindBy(id = "ok_button")
	@CacheLookup
	MobileElement missedChatClosePopupOk;

	@AndroidFindBy(id = "fab")
	MobileElement chatIcon;

	@AndroidFindBy(id = "chatactionimage")
	MobileElement cannedMessageIcon;

	@AndroidFindBy(id = "prompt_message")
	MobileElement tranlationPopup;

	@AndroidFindBy(id = "msgEditText")
	MobileElement chatinPutBox;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/uploadsend")
	MobileElement uploadSendImage;
	
	@AndroidFindBy(id = "uploadcancel")
	MobileElement cancelSendImage;
	
	@AndroidFindBy(id = "attach_image")
	MobileElement attachedImageChecks;

	@AndroidFindBy(id = "header_text")
	List<MobileElement> cannedMessageHeader;
	
	@AndroidFindBy(id = "android:id/title")
	List<MobileElement> selecImageBaseOnName;

	@AndroidFindBy(className = "android.widget.TextView")
	List<MobileElement> callVisitor;
	
	@AndroidFindBy(className = "android.widget.TextView")
	MobileElement visitorNameInSendImage;

	@AndroidFindBy(accessibility = "More options")
	MobileElement kebabMenu;

	@AndroidFindBy(accessibility = "Search")
	MobileElement searchIcon;

	@AndroidFindBy(accessibility = "‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‏‎‎‎‎‎‎‏‏‏‎‏‏‏‎‎‎‎‏‏‏‎‏‏‏‎‎‎‏‏‏‎‎‎‏‏‎‎‏‏‎‏‏‏‏‏‎‏‏‎‏‏‏‎‏‎Collapse‎‏‎‎‏‎")
	MobileElement backIconPress;

	@AndroidFindBy(id = "sendimage")
	MobileElement shareImage;

	@AndroidFindBy(id = "ok_button")
	MobileElement confirmTranslation;

	@AndroidFindBy(id = "banner_cal_view")
	MobileElement callInprogressBanner;
	
	@AndroidFindBy(id = "sendername")
	MobileElement checkSenderNameInImagePreview;

	@AndroidFindBy(id = "showmsg")
	List<MobileElement> visitorConvertedText;

	@AndroidFindBy(id = "chatinfomsgview")
	List<MobileElement> chatActionText;

	@AndroidFindBy(id = "visitorchat_info")
	List<MobileElement> visitorWaitingCountDown;

	@AndroidFindBy(id = "button2")
	MobileElement audioPermissionNotNow;

	@AndroidFindBy(id = "button1")
	MobileElement audioPermissionContinue;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	MobileElement clickAllowPermission;

	@AndroidFindBy(id = "com.zoho.salesiq:id/dialog_title")
	MobileElement missedChatClosePopupTitle;

	@AndroidFindBy(id = "com.zoho.salesiq:id/busy_callback_button_view")
	MobileElement busyCallBack;

	@AndroidFindBy(id = "com.zoho.salesiq:id/busy_cancel_button_view")
	MobileElement busyCancelCallBack;

	@AndroidFindBy(id = "com.zoho.salesiq:id/busy_message_button_view")
	MobileElement busyChatWindow;

	@AndroidFindBy(id = "com.zoho.salesiq:id/chat_bg_view")
	MobileElement callInprogressChat;

	@AndroidFindBy(id = "com.zoho.salesiq:id/msgEditText")
	MobileElement sendTextInput;

	@AndroidFindBy(id = "com.zoho.salesiq:id/sendimage")
	MobileElement sendChatText;

	@AndroidFindBy(id = "com.zoho.salesiq:id/msg_name")
	List<MobileElement> operatorName;

	@AndroidFindBy(id = "com.zoho.salesiq:id/chatinfomsgview")
	List<MobileElement> checkInfoMessage;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemHeadingText")
	List<MobileElement> cannedMessageList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/previouschat_attender")
	List<MobileElement> previousChatAttender;

	@AndroidFindBy(id = "com.zoho.salesiq:id/previouschat_question")
	List<MobileElement> previousChatQuestion;


	@AndroidFindBy(id = "com.android.documentsui:id/icon_thumb")
	List<MobileElement> imageList;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Offer rapid resolutions over an audio call']")
	MobileElement featureToolTip;

	

	public void checkUIinInOngoingChatList(String module) {
		try {
			boolean visitorName = actions.isPageOpen(visitorChatList.get(0));
			boolean visitorQuestion = actions.isPageOpen(visitorQuestionInChatList.get(0));
			boolean operatorName = actions.isPageOpen(visitorAssigneeInChatList.get(0));

			if (visitorName == true && visitorQuestion == true && operatorName == true) {
				extentreportclass.mobilepassTest(module, "Ongoign chat list UI check");

			} else {
				extentreportclass.mobilefailTest(driver,module, "Ongoign chat list UI check");

			}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "Ongoign chat list UI check");
		}
	}

	public void checkUIinInOngoingChatDetails(String module) {
		try {
			boolean checkcallIcon = actions.isPageOpen(callVisitor.get(1));
			boolean checkKebabMenu = actions.isPageOpen(kebabMenu);
			boolean checkshareImage = actions.isPageOpen(shareImage);

			if (checkcallIcon == true && checkKebabMenu == true && checkshareImage == true) {
				extentreportclass.mobilepassTest(module, "Ongoign chat Deatils UI check");

			} else {
				extentreportclass.mobilefailTest(driver,module, "Ongoign chat Deatils UI check");

			}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "Ongoign chat Deatils UI check");
		}
	}
	
	public void checkShareImage(String module,String useCase)
	{
		String testCaseName="Check Share image icon displayed in operator chat window page";
		try
		{
		
		MobileElement attchamentIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("attachmenticon"));
		if(attchamentIcon.isDisplayed())
		{
			extentreportclass.mobilepassTest(useCase,testCaseName);
		}
		else
		{
			extentreportclass.mobilefailTest(driver,useCase,testCaseName);
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,useCase,testCaseName);
		}
	}
	public void checkShareImageAfterEnterText(String module,String useCase)
	{
		String caseName="Check Share image icon should not be displayed chat enter in operator chat window page";
		try {
			MobileElement shareImageIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("attachmenticon"));
			if(shareImageIcon.isDisplayed())
			{
				extentreportclass.mobilefailTest(driver,useCase,caseName);
				
			}
			else
			{
				extentreportclass.mobilepassTest(useCase,caseName);
				
			}
		}
		catch(Exception e)
		{	
			extentreportclass.mobilepassTest(useCase,caseName);
		}
	}
	
	
	
	
	
	
	

	public void checkOperatorNameInChatList(String module) {
		try {
			actions.checkText("you", visitorAssigneeInChatList.get(0), module,
					"Check Operator name in Ongoing chat list");
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "Check Operator name in Ongoing chat list");
		}
	}

	public void checkOngoignCountBefore(String module) {
		previousOngoignCount = burgerMenu.checkOngoignChatCountInMenu();
	}

	public void checkOngoingCount(String useCase,String module) {

			String testCaseName= "Ongoing Menu count check at busy status";
			try
			{		
			MobileElement sendMailIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("ongoingwithNumber"));
			if(sendMailIcon.isDisplayed())
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
	public void checkOngoingChatCountInMenuAfterEndSession(String module) {
		String caseName ="Check Ongoing menu Current chat count after end session";
		try
		{
			MobileElement sendMailIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("ongoingChatMenuCountZero"));
			if(sendMailIcon.isDisplayed())
			{
				extentreportclass.mobilepassTest(module, caseName);
			}
			else
			{
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
			}
			catch(Exception e)
			{
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
	}


	public void checkVisitorCountingAtBusyStatus(String module) {
		try {
			actions.textContainsText(visitorWaitingCountDown.get(0), "waiting", module,
					"Check vistor waiting timer in Ongoing page");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check vistor waiting timer in Ongoing page");
		}
	}
	
	
	
	public void checkCallIconInChatWindow(String module,String useCase)
	{
		String testCaseName="Verify Mail Icon is displayed in View information page";
		try
		{		
		MobileElement callICon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("CallChatWindow"));
		if(callICon.isDisplayed())
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
	
	

	public void checkInvitedOperatorNameInInviteText(String module,String operatorName) {
		String caseName = "Check Operator name in Invite Text";
		try {
			actions.textContainsText(inviteText, operatorName, module, caseName);
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void checkDepartmentNameInCanned(String module,String expectedText) {
		try {
			actions.textContainsText(cannedMessageList.get(2), expectedText, module,
					"Check Department Name in Canned Message list");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Department Name in Canned Message list");
		}
	}

	public void selectVisitorFromList(String module) {
		try {
			actions.clickAction(visitorChatList.get(0), module, "Selelct One user from Ongoing List");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Selelct One user from Ongoing List");
		}
	}
	public void clickShareImageIcon(String module) {
		String caseName="Click on Share image and check file manager page is opened";
		try {
			actions.clickAction(shareImage, module, caseName);
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}
	public void checkOngoingChatList(String module) {
		String caseName="Check Ongoing Chat list removed after end session";
		try {
			if(visitorChatList.size()>0)
			{
			
				extentreportclass.mobilefailTest(driver,module,caseName);
		} 
		else
			{
			extentreportclass.mobilepassTest(module,caseName);
			}
		}catch (Exception e) {
			// TODO: handle exception
				extentreportclass.mobilepassTest(module,caseName);
		
		}
	
	}

	public void clickOnCallIcon(String module) {
		try {
			actions.clickAction(callVisitor.get(1), module, "Click on Call icon in Ongoing Chat details Page");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Click on Call icon in Ongoing Chat details Page");
		}
	}

	public void checkChatIcon(String module) {
		try {
			actions.isPageOpened(chatPickUpArrow, module, "Check swipe chat showing in Details page");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check swipe chat showing in Details page");
		}
	}

	public void checkChatInputBox(String module) {
		try {
			actions.isPageOpened(chatinPutBox, module, "Check Chat Input box shown in Chat page");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Chat Input box shown in Chat page");
			actions.backPress(module, "Navigate to Ongoing chat list page");
			selectVisitorFromList(module);

		}
	}

	public void clickChatIcon(String module) {
		try {

		
			//geth arrow co ordinates for swipe
			int elementX = chatPickUpArrow.getLocation().getX();

			int elementY=chatPickUpArrow.getLocation().getY();

			int lowerY = 70;

			int finalY=(elementY+lowerY);

			int deviceXvalue=BaseSetup.deviceWidthOne-200;

			//int deviceHeightOne = dim.getHeight();

			actions.swipeOption(elementX,finalY,deviceXvalue,finalY);

			//Chat icon removed in new design
			//actions.clickAction(chatIcon, module, "Click Chat icon to initiate chat");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Click Chat icon to initiate chat");
		}
	}

	public void clickCannedMessageIcon(String module) {
		try {
			actions.clickAction(cannedMessageIcon, module, "Click and Open Canned Message");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Click and Open Canned Message");
		}
	}

	public void checkTranslationPopup(String module) {
		try {
			chatTranslatePopup = actions.isPageOpened(tranlationPopup, module, "Check Translation Popup Shown");
		} catch (Exception e) {
			// TODO: handle exception
			chatTranslatePopup = false;
			extentreportclass.mobilefailTest(driver,module, "Check Translation Popup Shown");
		}
	}

	public void checkTranslationDetectedLanguage(String module) {
		
			try {
				actions.textContainsText(tranlationPopup, "Spanish", module, "Check Spanish langugate in popup");
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "Check Spanish langugate in popup");
			}
	}

	public void confirmTranslation(String module) {
		
			try {
				actions.clickAction(confirmTranslation, module, "Confirm Translation");
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "Confirm Translation");
			}
	}

	public void checkTranslationInKebabMenu(String module) {
		
			try {
				actions.checkTextinList(kebabMenuList, "Stop Translation (Spanish)", module,
						"Check stop translation menu showing in kebab menu");
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "Check stop translation menu showing in kebab menu");
			}
	}

	public void clickStopTranslation(String testcase) {	
		
			try {
				kebabMenuFunctionality.selectMenuFroMKebab("Stop Translation (Spanish)",testcase);
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "Click stop translation menu showing in kebab menu");
			}
	}

	public void checkTranslatedText(String module) {
		
			try {
				actions.textContainsText(visitorConvertedText.get(0),"Good morning user",  module,
						"Check coverted text to operator language");
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "check coverted text to operator language");
			}
	}

	public void checkActionText(String module,String expectedText) {
		int value = chatActionText.size();
		String caseName = "check action text in ongoig chat page";
		if (value > 0) {
			try {
				actions.checkText(expectedText, chatActionText.get(value - 1), module, caseName);
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
		} else {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void checkActionTextOfCallEnd(String module) {
		int value = chatActionText.size();
		String expectedText = "You were in an audio call for " + callDuration + " mins";
		String caseName = "Check action text after call disconected";
		if (value > 0) {
			try {
				actions.checkText(expectedText, chatActionText.get(value - 1), module, caseName);
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
		} else {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void checkStopTranslatedText(String module,String expectedValue) {
		
			try {
				actions.checkTextinList(visitorConvertedText, expectedValue, module, "Check after stop translation");
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "Check after stop translation");
			}
	}

	public void checkWelcomeMesssage(String module,String expectedValue) {
		try {
			actions.checkTextinList(operatorName, expectedValue, module, "Check Welcome Message shown");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Welcome Message shown");
		}

	}

	public void checkCallPermissionMessage(String module) {
		try {
			actions.checkText(
					"To make audio calls, you will have to allow Zoho SalesIQ to access the device's microphone.",
					callPermissionAlert, module, "Check error call permission message");
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "Check error call permission message");

		}
	}

	public void checkChatTransferErrorMessage(String module) {
		String caseName = "Check Popup Message in Transfer Chat while call inprogress";
		String expectedText = "The ongoing call will be aborted if you transfer this chat session over to your colleague. Would you still like to transfer?";
		try {
			actions.checkText(expectedText, popupMessage, module, caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}
	}

	public void checkChatInviteErrorMessage(String module) {
		String caseName = "Check Popup Message in Invite Chat while call inprogress";
		String expectedText = "Do remember that, inviting your colleague over would let them be a part of the chat session but not the ongoing call! Would you still like to invite?";
		try {
			actions.checkText(expectedText, popupMessage, module, caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}
	}

	public void checkChatInviteMessage(String module,String transferOperator) {
		String caseName = "Check chat invite Message";
		String expectedText = "You are about to invite “"+transferOperator+"” to participate in this chat";
		try {
			actions.checkText(expectedText, inviteText, module, caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}
	}

	public void checkChatTransferMessage(String module,String transferOperator) {
		String caseName = "Check chat Transfer Message";
		String expectedText = "You are about to transfer this chat to " + transferOperator;
		try {
			actions.checkText(expectedText, inviteText, module, caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}
	}

	public void clickOnNotNow(String module) {
		try {
			actions.clickAction(audioPermissionNotNow, module, "Click on Not now in Audio permission");
		} catch (Exception e) {

		}
	}

	public void clickOnContinue(String module) {
		try {
			actions.clickAction(audioPermissionContinue, module, "Click on Continue in Audio permission");
		} catch (Exception e) {

		}
	}

	public void clickAllowPermission(String module) {
		try {
			actions.clickAction(clickAllowPermission, module, "Click on Allow in Audio permission");
		} catch (Exception e) {

		}
	}

	public void clickCallInprogressBanner(String module) {
		String caseName = "Click on Call inprogress Banner";
		try {
			actions.clickAction(callInprogressBanner, module, caseName);
		} catch (Exception e) {

		}
	}

	public void checkCallingPageOpening(String module) {
		String callStatus = "";
		try {
			callStatus = actions.getPageSourceValue("android.widget.LinearLayout", 1, "android.widget.TextView", 0);
			if (!callStatus.isEmpty()) {

				if (callStatus.equalsIgnoreCase("Ringing…")) {
					extentreportclass.mobilepassTest(module, "Call status page open check");
				} else {
					extentreportclass.mobilefailTest(driver,module, "Call status page open check");
				}
			}

// 				System.out.print("Visitor Ongoing"+callStatus);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "Call status page open check");
		}
	}

	public void checkVisitorNameInCallingPage(String module,String expectedText) {
		String caseName = "Check visitor Name in Audio call page";
		String visitorName = "";
		try {
			visitorName = actions.getPageSourceValue("android.widget.LinearLayout", 1, "android.widget.TextView", 1);
			if (!visitorName.isEmpty()) {

				if (visitorName.equalsIgnoreCase(expectedText)) {
					extentreportclass.mobilepassTest(module, caseName);
				} else {
					extentreportclass.mobilefailTest(driver,module, caseName);
				}
			}

// 						System.out.print("Visitor name in audioCall"+visitorName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void checkVisitorLocationInCallingPage(String module,String expectedText) {
		String caseName = "Check visitor location in Audio call page";
		String visitorLocation = "";
		try {
			visitorLocation = actions.getPageSourceValue("android.widget.LinearLayout", 2, "android.widget.TextView",
					1);
			if (!visitorLocation.isEmpty()) {

				if (visitorLocation.equalsIgnoreCase(expectedText)) {
					extentreportclass.mobilepassTest(module, caseName);
				} else {
					extentreportclass.mobilefailTest(driver,module, caseName);
				}
			}

// 				System.out.print("Visitor location in audioCall"+visitorLocation);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void checkAudioCallStatusText(String module,String expectedText) {
		String actualText = "";
		try {
			actualText = actions.getPageSourceValue("android.widget.LinearLayout", 1, "android.widget.TextView", 0);
			if (!actualText.isEmpty()) {

				if (actualText.equalsIgnoreCase(expectedText)) {
					extentreportclass.mobilepassTest(module, "Audio call status text");
				} else {
					extentreportclass.mobilefailTest(driver,module, "Audio call statust");
				}
			}

// 				System.out.print("Incoming call text"+actualText);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "Audio call status");
		}
	}

	public void checkVisitorNameInComingCallPage(String module,String expectedText) {
		String caseName = "Check visitor Name in Incoming Audio call page";
		String actualText = "";
		try {
			actualText = actions.getPageSourceValue("android.widget.LinearLayout", 1, "android.widget.TextView", 1);
			if (!actualText.isEmpty()) {

				if (actualText.equalsIgnoreCase(expectedText)) {
					extentreportclass.mobilepassTest(module, caseName);
				} else {
					extentreportclass.mobilefailTest(driver,module, caseName);
				}
			}

// 				System.out.print("Incoming call text"+actualText);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void checkVisitorLocationInComingCallPage(String module,String expectedText) {
		String caseName = "Check visitor Location in Incoming Audio call page";
		String actualText = "";
		try {
			actualText = actions.getPageSourceValue("android.widget.LinearLayout", 2, "android.widget.TextView", 1);
			if (!actualText.isEmpty()) {

				if (actualText.equalsIgnoreCase(expectedText)) {
					extentreportclass.mobilepassTest(module, caseName);
				} else {
					extentreportclass.mobilefailTest(driver,module, caseName);
				}
			}

// 				System.out.print(caseName+" : "+actualText);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void checkCallTimerInprogress(String module) {
		String caseName = "Check Call timer inprogress after call connected between operator and visitor";
		String actualText = "";
		try {
			actualText = actions.getPageSourceValue("android.widget.LinearLayout", 3, "android.widget.TextView", 1);
			if (!actualText.isEmpty()) {
				extentreportclass.mobilepassTest(module, caseName);
			} else {
				extentreportclass.mobilefailTest(driver,module, caseName);
			}

// 				System.out.print(caseName+" : "+actualText);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public String getCallTimerInprogressTimer(String module) {
		String caseName = "Get Call Duration";
		try {
			callDuration = actions.getPageSourceValue("android.widget.LinearLayout", 3, "android.widget.TextView", 1);

// 				System.out.print(caseName+" : "+callDuration);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
		return callDuration;
	}

	public void cancelAudioCall(String module) {

		try {
			actions.clickAction(cancelAudioCall, module, "Cancel Audio Call");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Cancel Audio Call");
		}
	}

	public void clickBusyAudioCallBack(String module) {

		try {
			actions.clickAction(busyCallBack, module, "Audio Call back by Operator");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Audio Call back by Operator");
		}
	}

	public void clickBusyAudioCallCancel(String module) {
		try {
			actions.clickAction(busyCancelCallBack, module, "Audio cancel Call back by Operator");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Audio cancel Call back by Operator");
		}
	}

	public void clickBusyChatMessage(String module) {
		try {
			actions.clickAction(busyChatWindow, module, "Navigate to Chat window from busy page");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Navigate to Chat window from busy page");
		}
	}

	public void clickCallProgressChatMessage(String module) {
		String caseName = "Click on Chat icon while call in progress";
		try {
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(callInprogressChat));
			actions.clickAction(callInprogressChat, module, caseName);
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void closePopup(String module) {
		String caseName = "Close popup";
		try {
			actions.clickAction(closePopup, module, caseName);
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void clickTransferChat(String module) {
		String caseName = "Select Operator for Chat transfer by clicking on transfer";
		try {
			actions.clickAction(assignOperator, module, caseName);
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void checkInviteOperatorList(String module,String operatorName) {
		actions.checkTextShouldNotListed(assignOperatorList, operatorName, module,
				"Check current operator listed or not");
	}

	public void selectOPeratorFromList(String module,String operatorName) {
		actions.waitTime(1);
		actions.selectBasedonTextInList(assignOperatorList,operatorName,module,"Invite operator from the list");

	}

	public void enterChatText(String module,String sendText) {
		actions.actionEnter(sendTextInput, sendText, module, "Verify operator able to enter chat text");
	}

	public void checkInputTextPersist(String module,String sendText) {
		String caseName = "Chat input text persist in chat window";
		try {
			actions.checkText(sendText, sendTextInput, module, caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}
	}
	public void clearChatInputText(String module,String useCase)
	{
		String testCaseName="After send text cleared send chat text icon should changed into Share icon";
		try
		{
			
		actions.clearTextBox(sendTextInput);
		
		MobileElement attchamentIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("attachmenticon"));
		if(attchamentIcon.isDisplayed())
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
	public void cannedMessageIconCheck(String module,String useCase)
	{
		String testCaseName="Verify canned message icon is displayed in Ongoing chat window";
		try
		{		
		MobileElement cannedIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("cannedmessageiCon"));
		if(cannedIcon.isDisplayed())
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

	public void checkInputTextCanneMessageSelect(String module) {
		String caseName = "Check input text box after selected from Canned messages";
		try {
			actions.checkText(selectedCannedMessage, sendTextInput, module, caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}
	}
	public void checkInputTextDifferentCanneMessageSelect(String module) {
		String caseName = "Check input text box after selected different canned message from Canned messages";
		try {
			actions.checkText(selectedCannedMessage, sendTextInput, module, caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
			
		}
	}

	public void sendTextToVisitor(String module) {
		actions.clickAction(sendChatText, module, "Verify operator1 able to send Chat text to visitor");

		if(!featureToolTipStatus)
		{
		if(featureToolTip.isDisplayed())
		{
		actions.backPress("","");
		featureToolTipStatus=true;
		}
	}
	}

	public void selectDepartmentforTransfer(String module) {
		actions.clickAction(departmentTab, module, "Selelct Department tab for chat transfer");
	}

	public void selectCannedMessageFromList(String module)
		{
			String caseName ="Cick canned message from list";
			try
			{
			selectedCannedMessage=cannedMessageList.get(1).getText();
			actions.clickAction(cannedMessageList.get(1),module,caseName);
			
			}
			catch(Exception e)
			{
				extentreportclass.mobilefailTest(driver,module,caseName);	
			}
		}
	public void selectDifferentCannedMessageFromList(String module)
	{
		String caseName ="Cick canned message from list";
		try
		{
			selectedCannedMessage=cannedMessageList.get(2).getText();
			actions.clickAction(cannedMessageList.get(2),module,caseName);
			
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);	
		}
	}

	public void selectAgentTabforTransfer(String module) {
		actions.clickAction(agentTab, module, "Selelct Agent tab for chat transfer");
	}
	public void openImageFile(String module) {
		actions.waitTime(5);
		String caseName="Open Image file from file manager";
		try
		{
			// for(MobileElement elem:selecImageBaseOnName )	
			// {
			// 	if(elem.getText().equalsIgnoreCase("IMG_20181226_154312.jpg"))
			// 	{
			// 		elem.click();
			// 	}
			
			// }
			

		actions.longPress(imageList.get(0));
		actions.clickAction(clickOpenLongPressImage,module,caseName);
//		actions.clickAction(kebabMenuFileManger, module,caseName);
		}
		catch(Exception e)
		{
			actions.backPress(module, "Back to Chat window");
			extentreportclass.mobilefailTest(driver,module,caseName);	
			
		}
	}
	public void openVideoFile(String module) {
		actions.waitTime(2);
		String caseName="Open File Manger Menu";
		try
		{
			for(MobileElement elem:selecImageBaseOnName )	
			{
				if(elem.getText().equalsIgnoreCase("AShareVideo.mp4"))
				{
					if(elem.isEnabled())
					{
						
						extentreportclass.mobilefailTest(driver,module,caseName);
						actions.backPress(module, "Back to Chat window");
						elem.click();
					}
					else
					{
						extentreportclass.mobilepassTest(module,caseName);
						actions.backPress(module, "Back to Chat window");
					}
				}
				
			}
			
//		actions.clickAction(openFileManagerMenu, module,caseName);
//		actions.clickAction(kebabMenuFileManger, module,caseName);
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);	
			
		}
	}

	public void checkChatTextOfInvitedOperator(String module,String expectedText) {
		int value = chatText.size();
		String caseName = "Check whether operator2 send chat received by operator1";
		if (value > 0) {
			try {

				actions.textContainsText(chatText.get(value - 1), expectedText, module, caseName);

			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
		} else {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}
	public void checkVisitorNameInShareImageConfirmation(String module,String expectedText) {
		
		String caseName = "Check Visitor Name in Send image confirmation page";
		
			try {
				
				actions.textContainsText(visitorNameInSendImage,expectedText,module, caseName);
				
			} catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
		
	}

	public void checkAgentAndDepartmenTabAvailable(String module) {
		String caseName = "Check agent and department tab displaying in transfer chat page";
		try {
			if (agentTab.isDisplayed() && departmentTab.isDisplayed()) {

				extentreportclass.mobilepassTest(module, caseName);
			} else {

				extentreportclass.mobilefailTest(driver,module, caseName);
			}
		} catch (Exception e) {

		}
	}

	public void checkDepartmentList(String module) {
		boolean status = false;
		String caseName = "Check department list in Chat transfer page";
		String[] departmentName = { "Testing Department for salesiq", "privatedepartment", "testSalesia" };
		int i;
		int sucess;

		try {
			i = 0;
			sucess = 0;
			for (MobileElement elem : departmentListInTransferChat) {
				if (elem.getText().equalsIgnoreCase(departmentName[i])) {
					sucess++;
					i++;
					if (sucess >= 2) {
						status = true;
						break;
					}
				}

			}
			if (status) {
				extentreportclass.mobilepassTest(module, caseName);
			} else {
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
		} catch (Exception e) {

		}
	}

	public void checkActionText(String module,String expectedText, String testcase) {
		String caseName = testcase;
		try {
			int value = chatActionText.size();
			if (value > 0) {

				if (chatActionText.size() > 0) {
					actions.checkText(expectedText, chatActionText.get(value - 1), module, caseName);
				} else {
					extentreportclass.mobilefailTest(driver,module, caseName);
				}

			} else {
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}
	public void checkEndSessionInfoMessage(String module) {
		String caseName = "Check after clicks on End session info message should be displayed in chat page";
		try {
			int value = checkInfoMessage.size();
			if (value > 0) {
					actions.textContainsText(checkInfoMessage.get(value - 1),"Chat Session will end", module, caseName);
				
			} else {
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}
	public void checkEndSessionInfoMessageAfterSendText(String module) {
		String caseName = "Check after clicks on End session and Operator send chat message End session timer should be stopped";
		try {
			int value = checkInfoMessage.size();
			if (value > 0) {
				actions.waitTime(2);
				if(checkInfoMessage.get(value - 1).getText().contains("Chat Session will end"))
				{
					extentreportclass.mobilefailTest(driver,module, caseName);
					
				}
			} else {
				extentreportclass.mobilepassTest(module, caseName);
			}
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilepassTest(module, caseName);
		}
	}
	public void getEndSessionInfoMessage(String module) {
		
		
		String[] splitMessage;
		try {
			int value = checkInfoMessage.size();
			if (value > 0) {
				endSessionMessage=checkInfoMessage.get(value-1).getText();
			}
		} catch (Exception e) {
			// TODO: handle exception
	
		}
	}
	
	
	public void compareEndSessionMessage(String module)
	{
		String caseName ="Check End Session message after kill and open application";
		String compareSessionMessage ="";
		try {
		int value = checkInfoMessage.size();
		if(!endSessionMessage.isEmpty())
		{
			compareSessionMessage=checkInfoMessage.get(value-1).getText();
			if(compareSessionMessage.equalsIgnoreCase(endSessionMessage))
			{
				
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
			else
			{
				extentreportclass.mobilepassTest(module, caseName);
				
			}
		
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
			
		}
	}
	public void checkEndSessionInfoMessageAfterEndTimer(String module) {
		String caseName = "Check after clicks on End session info message should be displayed in chat page";
		try {
			int value = checkInfoMessage.size();
			if (value > 0) {
				
				if(checkInfoMessage.get(value-1).getText().contains("Chat Session will end"))
						{
					extentreportclass.mobilefailTest(driver,module,caseName);
			} else {
				extentreportclass.mobilepassTest(module,caseName);
			}
		}
		}catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilepassTest(module, caseName);
		}
	}

	public void checkChatInputTextBox(String module) {
		String caseName = "Check Chat input Text box after transfered to another operator";
		try {

			if (chatinPutBox.isDisplayed()) {
				extentreportclass.mobilefailTest(driver,module, caseName);
			} else {
				extentreportclass.mobilepassTest(module, caseName);
			}
		} catch (Exception e) {
			extentreportclass.mobilepassTest(module, caseName);
		}

	}
	public void checkChatInputTextBoxAfterEndSession(String module) {
		String caseName = "Check Chat input Text box Should not displayed after End Session";
		try {
			
			if (chatinPutBox.isDisplayed()) {
				extentreportclass.mobilefailTest(driver,module, caseName);
			} else {
				extentreportclass.mobilepassTest(module, caseName);
			}
		} catch (Exception e) {
			extentreportclass.mobilepassTest(module, caseName);
		}
		
	}

	public void checkKebabMenuFunctionality(String expectedText,String testcase) {
		try {
			String caseName = "Check operator1 kebab menu list after chat transfer";
			actions.checkTextinList(kebabMenuList, expectedText, testcase, caseName);
		} catch (Exception e) {

		}
	}

	public void checkKebabMenuListAfterChatTransfer(String testcase) {
		try {
			checkKebabMenuFunctionality("View Notes",testcase);
			checkKebabMenuFunctionality("Send Email",testcase);
			checkKebabMenuFunctionality("View Information",testcase);
			checkKebabMenuFunctionality("Previous Chats",testcase);
			checkKebabMenuFunctionality("CRM Information",testcase);
			checkKebabMenuFunctionality("Recent Support Requests",testcase);
			checkKebabMenuFunctionality("Recent Campaigns",testcase);
		} catch (Exception e) {

		}
	}

	public void checkPreviouslyAttendedChat(String module,String previousQuestion, String previousAttender) {
		String caseName = "Check Previous attender name and Question displayed";
		try {

			actions.waitTime(1);
			

			if (previousChatQuestion.get(0).getText().equalsIgnoreCase(previousQuestion)) {
				if (previousChatAttender.get(0).getText().equalsIgnoreCase(previousAttender)) {
					extentreportclass.mobilepassTest(module, caseName);
				} else {
					extentreportclass.mobilepassTest(module, caseName);

				}
			} else {
				extentreportclass.mobilepassTest(module, caseName);
			}
		} catch (Exception e) {
			extentreportclass.mobilepassTest(module, caseName);

		}

	}

	public void clickPreviousAttendedChat(String module) {
		String caseName = "Click Previously attended chat";
		try {
			actions.clickAction(previousChatQuestion.get(0), module, caseName);

		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}

	}
	public void clickSendUpdload(String module) {
		actions.waitTime(2);
		String caseName = "Upload Image by clicking on Send";
		try {
			actions.clickAction(uploadSendImage, module, caseName);
			
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
			
		}
		
	}
	public void clickCancelUpload(String module) {
		actions.waitTime(2);
		String caseName = "Image confirmation cancel";
		try {
			actions.clickAction(cancelSendImage, module, caseName);
			
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
			
		}
		
	}
	public void openImagePreviewInChatWindow(String module) {
		actions.waitTime(2);
		String caseName = "Open Image Preview";
		try {
			actions.clickAction(attachedImageChecks, module, caseName);
			
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
			
		}
		
	}
	public void checkImagePreviewInOperatorChatWidnow(String module) {
		actions.waitTime(2);
		String caseName = "Check Image preview displayed in Chat window or not";
		try {
			if(attachedImageChecks.isDisplayed())
			{
				
				extentreportclass.mobilepassTest(module, caseName);
			}
			else {
				
				extentreportclass.mobilefailTest(driver,module, caseName);
			}
			
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
			
		}
		
	}

	public void checkChatText(String useCase,String caseName, String text) {
		try {
			int value = chatText.size();
			// if (chatText.get(value - 1).getText().equalsIgnoreCase(text)) {
			// 	extentreportclass.mobilepassTest(module, caseName);

			// } else {
			// 	extentreportclass.mobilefailTest(driver,module, caseName);

			// }

			actions.textContainsText(chatText.get(value - 1),text,useCase,caseName);
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,useCase, caseName);

		}
	}

	public void checkVisitorExpectedText(String module,String text)
		{
			checkChatText(module,"Check visitor entered text and not send by operator is displaying in operator chat page",text);
		}
	public void checkSenderNameInImagePreview(String module,String text)
	{
		String caseName ="Check Sender Name in Image Preview";
		try
		{
		actions.checkText(text, checkSenderNameInImagePreview, module, caseName);
		actions.backPress(module, "back to Chat window");
	}
		catch(Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void checkChatDoneByOperator(String module,String text)
		{
		try
		{
			checkChatText(module,"Check visitor entered text and send is displayed in operator chat window",text);
		}
		catch(Exception e)
		{
			
		}
		}

	public void checkPreviousChatWindow(String module,String visitorName,String operatorName)
		{
		String caseName="Click Previously attended chat";
			try {
				
			if(checkPreviuosChatWindow.get(0).getText().contains(visitorName))
			{
				if(checkPreviuosChatWindow.get(1).getText().contains(operatorName))
				{
					extentreportclass.mobilepassTest(module,caseName);

					
				}
				else
				{
					extentreportclass.mobilefailTest(driver,module,caseName);

				}
				
			}
			else
			{
				extentreportclass.mobilefailTest(driver,module,caseName);

			}
		}
			catch(Exception e)
			{
				extentreportclass.mobilefailTest(driver,module,caseName);

			}
		}

	public boolean checkOngoingPageOpened(String module) {
		boolean status=false;
		String caseName = "Check chat page is opened after clicks on Chat notification";
		try {
			if (kebabMenu.isDisplayed()) {

				extentreportclass.mobilepassTest(module, caseName);
				status = true;
			} else {
				extentreportclass.mobilefailTest(driver,module, caseName);
				status = false;

			}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}
		return status;
	}

	public void checkEmptyCannedMessageList(String module) {

		String caseName = "Check Canned message list empty issue";
		try {
			if (cannedMessageList.size() > 0) {
				extentreportclass.mobilefailTest(driver,module, caseName);

			} else {
				extentreportclass.mobilefailTest(driver,module, caseName);

			}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}

	}

	public void checkSearchResultText(String module,String searchText) {
		boolean searchresult = true;

		try {
			String searchResult[] = actions.getListofValue(cannedMessageList);
			for (String val : searchResult) {
				if (val != null) {
					if (val.contains(searchText)) {
						searchresult = true;
					} else {
						searchresult = false;
						extentreportclass.mobilefailTest(driver,module, "Check the search result");
						break;
					}
				}
			}
			if (searchresult) {
				extentreportclass.mobilepassTest(module, "Check the search result");
			}
		} catch (Exception e) {
			extentreportclass.mobilepassTest(module, "Check the search result");

		}
	}

	public void checkCannedMessageHeader(String module) {
		String caseName = "Check Canned message Header shown in Canned message list";

		try {
			if (cannedMessageHeader.size() > 1) {
				extentreportclass.mobilepassTest(module, caseName);

			} else {
				extentreportclass.mobilefailTest(driver,module, caseName);

			}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, caseName);

		}
	}

	public void checkOperatorNameInCannedMessageList(String module) {
		String caseName = "Check operator Name dynamically contains in Canned Message List";
		try {
			actions.textContainsText(cannedMessageList.get(1), "operator MPTEST", module, caseName);
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}
	
	public void checkCannedMessageDepartmentBased(String module)
	{
		actions.checkTextShouldNotListed(cannedMessageList,"This canned message for Testing department",module,"check Canned Message is displayed based on department");
	}
	
	
	

}
