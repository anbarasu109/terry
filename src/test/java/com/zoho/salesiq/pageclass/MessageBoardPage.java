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

public class MessageBoardPage extends BaseSetup {
	private boolean chatHistotryPage;
	private String visitorChatQuestion;
	private String singleChat;
	private String categories ="Visitor History Page";

	private static int LeadScoreVisitorOne;
	private static int LeadScoreVisitorTwo;
	private static String[] operatorList;
	CommonActionMobile actions = new CommonActionMobile(driver);

	public MessageBoardPage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	SearchFunctionality seachFunctionality = new SearchFunctionality(driver);
	Extentreportclass extentreportclass = new Extentreportclass();
	private KebabMenuFunctionality kebabMenuFunctionality = new KebabMenuFunctionality(driver);
	private BurgerMenuNavigations burgerMenu = new BurgerMenuNavigations(driver);

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Message Board']")
	MobileElement checkMessageBoardOpenCheck;	

	

	@AndroidFindBy(className = "android.widget.TextView")
	List<MobileElement> headerText;


	@AndroidFindBy(id = "com.zoho.salesiq:id/showmsg")
	List<MobileElement> messageBoardText;



public void checkMessageChatPageOpen(String useCase,String categories)
	{
		String testCase="verify if operator clicks on Message board, Message board page should be displayed";
		try{

		actions.isPageOpened(checkMessageBoardOpenCheck,useCase,testCase);
	
		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}



	public void checkActiveOperatorCountInMessageBoard(String useCase,String categories,String expectedCount)
	{
		String testCase="Verify expected Active Operator count " +expectedCount+ " in the message Board";

		try{


		actions.textContainsText(headerText.get(1),expectedCount,useCase,testCase);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}
	}

	public void checkMessageBoardText(String useCase,String categories,String expectedValue)
	{
		String testCase="Verify chat send by operator two should be received by operator one in message board";

		try{

		int total= messageBoardText.size();
		actions.checkText(expectedValue,messageBoardText.get(total-1),useCase,testCase);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}
	}


	
























}
