//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import io.appium.java_client.AppiumDriver;

public class ChatHistoryPage extends BaseSetup {
	private boolean chatHistotryPage;
	private String visitorChatQuestion;
	private String singleChat;
	private String module = "Chat History page";
	CommonActionMobile actions = new CommonActionMobile(driver);

	public ChatHistoryPage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	SearchFunctionality seachFunctionality = new SearchFunctionality(driver);
	Extentreportclass extentreportclass = new Extentreportclass();
	private KebabMenuFunctionality kebabMenuFunctionality = new KebabMenuFunctionality(driver);
	private BurgerMenuNavigations burgerMenu = new BurgerMenuNavigations(driver);


	@AndroidFindBy(id = "title")
	List<MobileElement> kebabMenuList;

	@AndroidFindBy(id = "visitorchat_question")
	List<MobileElement> selectSingleChat;
	
	@AndroidFindBy(id = "visitorchat_name")
	List<MobileElement> visitorList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/showmsg")
	List<MobileElement> selectSingleText;

	@AndroidFindBy(id = "msg_name")
	List<MobileElement> visitorName;

	@AndroidFindBy(id = "chatinfomsgview")
	List<MobileElement> chatActionText;


	@AndroidFindBy(id = "previouschat_attender")
	List<MobileElement> prviousChatAttender;

	@AndroidFindBy(id = "previouschat_question")
	List<MobileElement> prviousChatQuestion;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Previous Chats']")
	MobileElement previousChatPage;
	

	@AndroidFindBy(id = "visitorchat_info")
	List<MobileElement> attendedOperatorName;
	
	@AndroidFindBy(id = "primaryItemText")
	List<MobileElement> viewInformationList;

	@AndroidFindBy(className = "android.widget.TextView")
	MobileElement clickCopyButton;

	@AndroidFindBy(className = "android.widget.TextView")
	List<MobileElement> chatDetailsHeaderUI;

	@AndroidFindBy(className = "android.widget.TextView")
	List<MobileElement> previousChatHeaderUI;

	@AndroidFindBy( id = "userpicright")
	List<MobileElement> operatorImage;
	
	@AndroidFindBy( id = "userpicleft")
	List<MobileElement> visitorImage;

	@AndroidFindBy(accessibility = "More options")
	MobileElement kebabMenu;


	
	
	public void checkPreviousChatListUI(String useCase)
	{
String caseName="Check previous chat list UI should be same as expected";
		try
		{
			if(prviousChatAttender.size()>0&&prviousChatQuestion.size()>0)
			{
		extentreportclass.mobilepassTest(useCase, caseName);

			}
			else
			{
		extentreportclass.mobilefailTest(driver,useCase, caseName);
				
			}
		}catch(Exception e)
		{

		}
	}








	public void selectSinglePreviousChatMessage(String useCase) {
		String testCase="Verify if operator clicks on invidual previous chat, respected chat details page should be displayed";
		try {
		MobileElement element = prviousChatAttender.get(0);
		actions.clickAction(element, useCase,testCase);
		}
		catch (Exception e) {
			// TODO: handle exception
		extentreportclass.mobilepassTest(useCase, testCase);

		}
	}

	public void selectSingleMessage(String module) {
		String testCase="Verify if operator clicks on single chat in list Chat history details page should be shown";
		try {
		MobileElement element = selectSingleChat.get(0);
		actions.clickAction(element, module,testCase);
		}
		catch (Exception e) {
			// TODO: handle exception
		extentreportclass.mobilepassTest(module, testCase);

		}
	}

	public String getVisitorQuestionChatList(String module) {
		MobileElement element = selectSingleChat.get(0);
		visitorChatQuestion = actions.getElementText(element);
		return visitorChatQuestion;
	}

	public String getSingleChat(String module) {
		try {
			MobileElement element = selectSingleText.get(0);
			singleChat = actions.getElementText(element);
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		return singleChat;
		
	}

	public void chatHistoryPageOpenCheckl(String module) {
		try{
		MobileElement element = selectSingleChat.get(0);
		chatHistotryPage = actions.isPageOpened(element, module, "Check Chat History Page Open");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,"Check Chat History Page Open");

	}

	}

	public void preivousChatDetailsPageOpenCheck(String useCase) {
		String testCase="check Previous chat details page is opened";
		try{
		
		actions.isPageOpened(kebabMenu, useCase,testCase);
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}

	}

	public void previousChatPageOpenCheck(String useCase) {
		String testCase ="Check Previous chat page open after operator clicks on Previoius chat menu";
		try{
		actions.isPageOpened(previousChatPage, useCase,testCase);
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}

	}


	public void checkChatHistoryUI(String module)
	{
		String testCase="Verify in Chat histoty page all expected UI is displayed";
	try{
	if(selectSingleChat.size()>0 &&  visitorList.size()>0 && attendedOperatorName.size()>0)	
	{
	extentreportclass.mobilepassTest(module,testCase);
	}
	else
	{
		extentreportclass.mobilefailTest(driver,module,testCase);
		
	}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,testCase);
	}
	}

	public void checkChatHistoryDetailsUI(String module)
	{
		String testCase="Verify Chat details page is having all expected UI";
	try
	{
	if(selectSingleText.size()>0 &&  visitorName.size()>0 && chatActionText.size()>0)	
	{
	extentreportclass.mobilepassTest(module,testCase);
	}
	else
	{
		extentreportclass.mobilefailTest(driver,module,testCase);
		
	}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,testCase);
	}
	}

	public void checkVisitorNameInChatHistory(String module,String visitorName)
	{
	String testCase="Verify visitor name should be displayed in Chat history details page";
	try
	{
	actions.checkText(visitorName,chatDetailsHeaderUI.get(0), module,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,module,testCase);
	}
	}

	public void checkVisitorQuestionInPreviousChat(String useCase,String visitorQuestion)
	{
	String testCase="Verifyin previous chat details page visitor question should be same as visitor entered in Chat window";
	try
	{
	actions.checkText(visitorQuestion,selectSingleText.get(0), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

	public void checkVisitorNameInPreviosChatDetails(String useCase,String visitorName)
	{
	String testCase="Verify visitor name in preivous chat Details page";
	try
	{
	actions.checkText(visitorName,previousChatHeaderUI.get(0), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

	public void checkAttenderNameInPreviosChatDetails(String useCase,String attenderName)
	{
	String testCase="Verify Attender name in preivous chat Details page";
	try
	{
	actions.textContainsText(previousChatHeaderUI.get(1),attenderName,useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}


	public void checkOperatorNameInChatHistory(String module,String attendedOperatorName)
	{
	String testCase="Verify Attended Operator name should be displayed in Chat history details page";
	try
	{
	actions.textContainsText(chatDetailsHeaderUI.get(1),attendedOperatorName,module,testCase);
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,testCase);
	}
	}

	public void checkChatTextInChatHistoryDetails(String module,String chatText)
	{
	String testCase="Verify Chat Text should be same as visitor entered in chat Ongoing";
	try
	{
	actions.textContainsText(selectSingleText.get(0),chatText,module,testCase);
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,testCase);
	}
	}

	public void checkOperatorActionTextChatHistoryDetails(String module,String actionText)
	{
	String testCase="Verify operator chat action text should be displayed in Chat history details page";
	try
	{
	actions.checkText(actionText,chatActionText.get(0), module,testCase);
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,testCase);
	}
	}

	public void checkOperatorAndVisitorAvatarShow(String module)
	{
		String testCase="Verify Operator and visitor avatar image shown in chat history details page";
		try
		{
		
		if(visitorImage.size()>0 && operatorImage.size()>0)
		{

	extentreportclass.mobilepassTest(module,testCase);

		}
		else
		{
			extentreportclass.mobilefailTest(driver,module,testCase);


		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,testCase);
}


	}
	public void checkKebabMenuListInChatHistory(String module) {
		try {
			checkKebabMenuFunctionality(module,"Translate Spanish");
			checkKebabMenuFunctionality(module,"View Information");
			checkKebabMenuFunctionality(module,"Add a Note");
			checkKebabMenuFunctionality(module,"Send Email");
			checkKebabMenuFunctionality(module,"CRM Information");
			checkKebabMenuFunctionality(module,"Recent Support Requests");
			checkKebabMenuFunctionality(module,"Previous Chats");
		} catch (Exception e) {

		}
	}
	public void checkKebabMenuFunctionality(String module,String expectedText) {

		String caseName = "Check "+expectedText+" from kebab menu list in Chat History page";
		try
		{
		boolean status = actions.checkTextinListBoolean(kebabMenuList, expectedText, module, caseName);
		if (status) {
			extentreportclass.mobilepassTest(module, caseName);
		} else {
			extentreportclass.mobilefailTest(driver,module, caseName + " not available : " + expectedText);

		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, caseName + " not available : " + expectedText);
		
	}

	}

	public void checkViewInformationPage(String module)
	{
		String testCase="Verify View information page have all expected information";
		try
		{
if(viewInformationList.size()>0)
{
	extentreportclass.mobilepassTest(module,testCase);
}
else
{
	extentreportclass.mobilefailTest(driver,module,testCase);
}
}
catch(Exception e)
{
	extentreportclass.mobilefailTest(driver,module,testCase);

}

	}





	public void checkCopyText(String module) {
		if (chatHistotryPage) {
			try {
			String actualText;
			MobileElement element = selectSingleText.get(0);
			
			//Perform Long Press on Selected Message
			actions.longPress(element);
			//click on Copy button
			clickCopyButton(module);
			
			//Get the text of Single chat
			getSingleChat(module);
			
			//Get the text from Clip Board
			actualText = singleChat;
			
			
			actions.compareText(actualText,singleChat, module, "Testing copy clipbaord text and copied Text");
			}
			catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			}
		}
	}

	public void clickCopyButton(String module) {
		String testCase= "Copy to clip board by click on Copy";
		try{

		actions.clickAction(clickCopyButton,module,testCase);
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,testCase);

	}


	}
	
	public void checkVisitorListedinChatHistory(String module,String visitorName)
	{
		String testCase= "Check closed visitor in missed chat should be listed in chat history";
		try{
		actions.checkTextinList(visitorList, visitorName, module,testCase );
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,testCase);

	}
	}
	

	public void checkKebabMenuInChatHistoryViewInformation(String testcase) {
		try {
			checkKebabMenuFunctionality(testcase,"Edit Information");
			checkKebabMenuFunctionality(testcase,"More Information");
		} catch (Exception e) {

		}
	}

}
