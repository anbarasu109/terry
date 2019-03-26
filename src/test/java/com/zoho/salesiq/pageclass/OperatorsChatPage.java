//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import io.appium.java_client.AppiumDriver;

public class OperatorsChatPage extends BaseSetup {
	private boolean chatHistotryPage;
	private String visitorChatQuestion;
	private String singleChat;
	private String categories ="Visitor History Page";

	private static int LeadScoreVisitorOne;
	private static int LeadScoreVisitorTwo;
	private static String[] operatorList;
	CommonActionMobile actions = new CommonActionMobile(driver);

	public OperatorsChatPage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	SearchFunctionality seachFunctionality = new SearchFunctionality(driver);
	Extentreportclass extentreportclass = new Extentreportclass();
	private KebabMenuFunctionality kebabMenuFunctionality = new KebabMenuFunctionality(driver);
	private BurgerMenuNavigations burgerMenu = new BurgerMenuNavigations(driver);


	@AndroidFindBy(id = "com.zoho.salesiq:id/internal_name")
	List<MobileElement> operatorChatList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/fab")
	MobileElement createOperatorChatIcon;

	@AndroidFindBy(id = "com.zoho.salesiq:id/username")
	List<MobileElement> operatorNameList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/intime")
	List<MobileElement> accessedTime;

	@AndroidFindBy(id = "com.zoho.salesiq:id/search")
	MobileElement searchIcon;	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Operator Chats']")
	MobileElement checkOperatorChatPageOpen;	


	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Start a Chat']")
	MobileElement operatorChatListPage;


	@AndroidFindBy(id ="com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> visitorInfoTabList;

	@AndroidFindBy(id ="com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> activitiesInfoTabList;

	@AndroidFindBy(id ="com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> crmInfoPageList;


	@AndroidFindBy(id ="com.zoho.salesiq:id/toolbar_spinner")
	MobileElement visitorHistoryDropDown;


	@AndroidFindBy(id = "com.zoho.salesiq:id/internal_name")
	List<MobileElement> selectOperatorInOperatorChats;

	@AndroidFindBy(id = "com.zoho.salesiq:id/text1")
	MobileElement defaultFilterName;

	@AndroidFindBy(id = "com.zoho.salesiq:id/oppotunity_percentage")
	MobileElement leadScorePercentage;

	@AndroidFindBy(id = "com.zoho.salesiq:id/mail")
	MobileElement mailIcon;

	@AndroidFindBy(id = "com.zoho.salesiq:id/phone")
	MobileElement mobileCallIcon;
	
	@AndroidFindBy(id = "android:id/text1")
	List<MobileElement> visitorHistoryFilterList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/unreadcount")
	List<MobileElement> unreadCountInChatList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemHeadingText")
	List<MobileElement> activitiesInfoHeadText;

	@AndroidFindBy(className = "android.widget.TextView")
	List<MobileElement> headerText;



public void checkOepratorChatsPageOpen(String useCase,String categories)
	{
		String testCase="Verify if operator clicks on Operator chats menu, Operator chats page should be open";
		try{

		actions.isPageOpened(checkOperatorChatPageOpen,useCase,testCase);
		getOperatorListInOperatorChat();
		

		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}

public void checkSearchIconDisplayedInOperatorChats(String useCase,String categories)
	{
		String testCase="Verify Search Icon is displayed in operator chats page";
		try{

		actions.isPageOpened(searchIcon,useCase,testCase);
		

		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}

	public void checkIndividualChatInOperatorChats(String useCase,String categories,String expectedValue)
	{
		String testCase="Verify " +expectedValue+ " chat type in Operators Chat";

		try{


		actions.checkTextinList(operatorChatList,expectedValue, useCase,testCase);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}
	}

	public void checkGroupChatInOperatorChats(String useCase,String categories,String expectedValue)
	{
		String testCase="Verify " +expectedValue+ " chat type in Operators Chat";

		try{


		actions.checkTextinList(operatorChatList,expectedValue, useCase,testCase);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}
	}


public void checkOperatorsInList(String useCase,String categories,String expectedValue)
	{
		String testCase="Verify "+expectedValue+" operator in the list";

		try{


		actions.checkTextinList(operatorNameList,expectedValue,useCase,testCase);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}
	}

	public void checkOperatorCount(String useCase,String categories,int count)
	{
		String testCase="check operator count "+count+" in the operator chat list";
		try{

			if(operatorNameList.size()==count)
			{
			extentreportclass.mobilepassTest(useCase,testCase);
			}
			else
			{
				extentreportclass.mobilefailTest(driver,useCase,testCase);
			}
		}catch(Exception e){

			extentreportclass.mobilefailTest(driver,useCase,testCase);
		}
	}

	public void checkOperatorChatIcon(String module,String UseCase)
	{
		String testCaseName="Verify Operator chat icon is displayed in Operator chat Page";
		try
		{
			
			MobileElement chatInitiateIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("OperatorChatinitiateIcon"));
			if(chatInitiateIcon.isDisplayed())
			{
				extentreportclass.mobilepassTest(UseCase,testCaseName);
			}
			else
			{
				extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
			}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
		}
		
	}

	public void clickCreateChatIcon(String useCase,String categories)
	{
		String testCase="Verify if operator clicks on create chat icon in Operator chat operator list should be shown";
		try{

		actions.clickAction(createOperatorChatIcon,useCase,testCase);
		

		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}

	public void checkAfterCicksOnCreateOperatorChatIcon(String useCase,String categories)
	{
		String testCase="Verify if operator clicks on operator chat icon Operator Chat list should be listed";
		try{

		actions.isPageOpened(operatorChatListPage,useCase,testCase);
		

		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}

	public void selectOperatorFromList(String useCase,String categories,String operatorName)
	{
	String testCase="Select "+operatorName+" From visitor Operator chat list";
	try
	{

	actions.selectBasedonTextInList(operatorNameList,operatorName,useCase,testCase);
	
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}


	public void getOperatorListInOperatorChat()
	{
		try
		{
		int i=0;
	for(MobileElement elem : operatorChatList)
	{
		operatorList[i]=elem.getText();
		i++;
	}
}
catch(Exception e)
{

}
	
	}

	public void checkOperatorListCheckAfterCrossSymbolClick(String useCase,String categories)
	{
		String testCase="Verify after clicks on cross symbol search result should be cleared";
	boolean status = false;
	int i=0;

try{
	
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.invisibilityOf(operatorChatList.get(0)));
	
for(MobileElement elem : operatorChatList)
	{
		if(operatorList[i].equalsIgnoreCase(elem.getText()))
		{
		status=true;
		
		}
		else
		{
		status=false;
		}
		i++;
	
	}
	if(status)
	{
	extentreportclass.mobilepassTest(useCase,testCase);

	}
	else
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}
	

}catch(Exception e){

	extentreportclass.mobilefailTest(driver,useCase,testCase);

}


	}

	public void checkOperatorNameAfterConnect(String useCase,String categories,String expectedValue)
	{
		String testCase="Verify " +expectedValue+ " operator connected with current operator in Operator chat";

		try{


		actions.checkText(expectedValue,headerText.get(0),useCase,testCase);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}
	}

	public void checkUnreadChatListCount(String useCase,String categories,String expectedValue)
	{
		String testCase="Verify unread Text count in Operators chat list";

		try{
		actions.checkText(expectedValue,unreadCountInChatList.get(0),useCase,testCase);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}
	}

	public void selectOperatorFromOperatorChatsList(String useCase,String categories,String operatorName) {
		String caseName = "Select Operator from Operator chats List";
		try{
		actions.selectBasedonTextInList(selectOperatorInOperatorChats,operatorName,useCase,caseName);
		}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,caseName);
	}
	}

	














	
























}
