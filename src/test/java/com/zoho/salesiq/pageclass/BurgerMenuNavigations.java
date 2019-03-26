//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import org.jfree.util.Log;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.BaseSetup;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import com.zoho.salesiq.pageclass.Extentreportclass;
import org.openqa.selenium.support.FindBys;

public class BurgerMenuNavigations extends BaseSetup {

	private String module = "MenuHandling";

	private static int previousOperatorChatsMenuCount;
	private static int currentOperatorChatsMenuCount;
	private static int previousMessageBoardMenuCount;
	private static int currentMessageBoardMenuCount;
	public Point visitorHistoryPoint;
	public Point chatHistoryPoint;
	public Point settingsPoint;



	private static CommonActionMobile actions = new CommonActionMobile(driver);
	private static Extentreportclass extentreportclass = new Extentreportclass();

	public BurgerMenuNavigations(AndroidDriver driver) {
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "header_parent")
	MobileElement burgeMenuCheck;

	@AndroidFindBy(accessibility = "Zoho SalesIQ")
	MobileElement burger;

	@AndroidFindBy(id = "com.zoho.salesiq:id/header_status_change_track")
	MobileElement statusChange;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	MobileElement settingsMenu;
	
	@AndroidFindBy(id = "header_status")
	MobileElement burgerStatusText;

	@FindBy(xpath = "//android.widget.TextView[@text='Online']")
	MobileElement onlineMenuClick;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Ongoing']")
	MobileElement ongoingMenuClick;

	@FindBy(xpath = "//android.widget.TextView[@text='Missed']")
	MobileElement missedMenuClick;
	
	@FindBy( xpath = "//android.widget.TextView[@text='History']")
	List<MobileElement> visitorAndChatHistory;
	
	@FindBy(id = "selectionview")
	List<MobileElement> onlineMenuID;
	
	@FindBy(id = "selectionview")
	List<MobileElement> ongoingMenuID;

	@FindBy(id = "com.zoho.salesiq:id/item_circle")
	List<MobileElement> eachMenuCount;

	@AndroidFindBy(id = "com.zoho.salesiq:id/item_name")
	List<MobileElement> burgerMenuList;

	public void burgermenuClick(String module) {
		try
		{
			actions.clickAction(burger, module, "");
		}
		catch(Exception e)
		{

		}
	
	}

	public void settingsMenuClick(String module) {
		try{
		swipeifSettingsNotFound(module);
		actions.clickAction(settingsMenu, module, "Settings Menu Click");
		
//		chatHistoryPoint=settingsMenu.getCenter();
//		}
//			actions.waitTime(2);
//			if(actions.checkImagePresent("burgerOngoingIcon"))
//			{
//				extentreportclass.mobilepassTest(module,  "Navigate to Chat History Page");
//			actions.clickBasedOnPoint(chatHistoryPoint);
//			}
//			else
//			{
//				MobileElement element1 = burgerMenuList.get(4);
//				actions.clickAction(element1, module, "Navigate to Chat History Page");
//				
//			}
		
		}
	catch(Exception e)
	{
		burgermenuClick(module);
		actions.clickAction(settingsMenu, module, "Settings Menu Click");
	}
	}
	
	
	public void checkBurgerMenuList(String module,String useCase)
	{
		String testCaseName="Verify Burger Menu list is same as expected";
		try
		{		
		MobileElement burgerMenuList=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("burgerMenuList"));
		if(burgerMenuList.isDisplayed())
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
	
	public void clearAllBurgerMenuPointValue() {
		try
		{
		
		visitorHistoryPoint=null;
		chatHistoryPoint=null;
		}
		catch(Exception e)
		{
			Log.error("error happened while null burger point value"+e.getStackTrace());
		}
		
	}
	

	public int getOperatorChatMenuCount()
	{
		int result;
		try
		{
		String value=eachMenuCount.get(5).findElement(MobileBy.id("com.zoho.salesiq:id/item_no")).getText();
		result = Integer.parseInt(value);
	}
	catch(Exception e)
	{
		result =0;
	}
return result;
	}

	public int getMessageBoardMenuCount()
	{
		int result;
		try
		{
		String value=eachMenuCount.get(6).findElement(MobileBy.id("com.zoho.salesiq:id/item_no")).getText();
		result = Integer.parseInt(value);
	}
	catch(Exception e)
	{
		result =0;
	}
return result;
	}

	public void getPreviousOperatorChatsMenuCount(String useCase,String categories)
	{
		try
		{
		previousOperatorChatsMenuCount=getOperatorChatMenuCount();
		extentreportclass.mobilepassTest(useCase,"Get the operator Chats Menu count before chat operator send text");

		}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,"Get the operator Chats Menu count before chat operator send text");

	}
	}public void getPreviousMessageBoardMenuCount(String useCase,String categories)
	{
		try
		{
		previousMessageBoardMenuCount=getMessageBoardMenuCount();
		extentreportclass.mobilepassTest(useCase,"Get the Message Board Menu count before chat operator send text");
		
		
		

		}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,"Get the Message Board Menu count before chat operator send text");

	}
	}

	public void checkOperatorsChatCountMenu(String useCase,String categories)
	{
		String testCase= "Verify Operator chats menu count should be increased based on chat between operator";
			try
			{		
			MobileElement sendMailIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("operatorChatCountOne"));
			if(sendMailIcon.isDisplayed())
			{
				extentreportclass.mobilepassTest(useCase, testCase);
			}
			else
			{
				extentreportclass.mobilefailTest(driver,useCase, testCase);
			}
}
catch(Exception e)
{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

}
	}
public void checkMessageBoardCountMenu(String useCase,String categories)
	{
		String testCase= "Verify Message Board menu count should be increased based on chat send by operator";
		try
		{		
		MobileElement sendMailIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("messageBoardCountOne"));
		if(sendMailIcon.isDisplayed())
		{
			extentreportclass.mobilepassTest(useCase, testCase);
		}
		else
		{
			extentreportclass.mobilefailTest(driver,useCase, testCase);
		}
}
catch(Exception e)
{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

}
	}





	public void ongoingMenuClick(String module) {
		try{
		//MobileElement element = burgerMenuList.get(2);
		actions.clickAction(ongoingMenuClick, module, "Navigate to Ongoing page");
		}
	catch(Exception e)
	{
burgermenuClick(module);
actions.clickAction(ongoingMenuClick, module, "Ongoing Menu click");
	}
	}
	

	public void settingsMenucheck(String expectedText) {
		try{
		actions.checkText(expectedText, settingsMenu, module, "SettingsText check");
	}
	catch(Exception e)
	{
burgermenuClick(module);
	}
	}

	public void swipeifSettingsNotFound(String module) {
		try
		{
//		if (!actions.iselemetFound(settingsMenu)) {
			actions.swipeOption(422, 1358, 422, 435);
//			extentreportclass.mobilepassTest(module, "Scroll burger menu if settings menu not found");
//		}
	}
	catch(Exception e)
	{
		
	}
	}

	public void swipeBurgerMenu(String module) {
		try{
			actions.waitTime(2);
		actions.swipeOption(10, 1008, 563, 1008);
		extentreportclass.mobilepassTest(module,"Open Burger menu by swipping");

	}
	catch(Exception e)
	{

	}
}
//	public void swipeBurgerMenu1()
//	{
//		actions1.swipeOption1(0, 1008, 563, 1008);	
//	}

	public void chatHistoryMenuClick(String module) {

		try{
			if(chatHistoryPoint==null)
			{
		MobileElement element1 = burgerMenuList.get(4);
		chatHistoryPoint=element1.getCenter();
			}
				actions.waitTime(2);
				if(actions.checkImagePresent("burgerOngoingIcon"))
				{
					extentreportclass.mobilepassTest(module,  "Navigate to Chat History Page");
				actions.clickBasedOnPoint(chatHistoryPoint);
				}
				else
				{
					MobileElement element1 = burgerMenuList.get(4);
					actions.clickAction(element1, module, "Navigate to Chat History Page");
					
				}
	
		}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,  "Navigate to Chat History Page");
	}
}


public void operatorChatsMenuClick(String module) {

		try{
		MobileElement element = burgerMenuList.get(5);
		actions.clickAction(element, module, "Navigate to Operator Chats Page");
		}
	catch(Exception e)
	{
burgermenuClick(module);
	}
}
public void messageBoardMenuClick(String useCase,String categories) {

		try{
		MobileElement element = burgerMenuList.get(6);
		actions.clickAction(element, useCase, "Navigate to Message Board Page");
		}
	catch(Exception e)
	{
burgermenuClick(module);
	}
}

public void visitorHistoryMenuClick(String module) {
	String testCase = "Navigate to Visitor History Page";

		try{
			if(visitorHistoryPoint==null&&actions.checkImagePresent("burgerOngoingIcon"))
			{		
		MobileElement element = burgerMenuList.get(1);
		visitorHistoryPoint=element.getCenter();
			}
				actions.waitTime(2);
				if(actions.checkImagePresent("burgerOngoingIcon"))
				{
				
				actions.clickBasedOnPoint(visitorHistoryPoint);
				extentreportclass.mobilepassTest(module,  testCase);
				}
				else
				{
				MobileElement element1 = burgerMenuList.get(1);
				actions.clickAction(element1, module, testCase);
				}
		}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,testCase);
	}
}

	
	public void openOnlineMenu(String module)
	{
		try{
		actions.clickAction(onlineMenuClick, module, "Navigate to Online Menu");
		}
	catch(Exception e)
	{
burgermenuClick(module);	
actions.clickAction(onlineMenuClick, module, "Navigate to Online Menu");	
	}
	}

	public void missedChatMenuClick(String module) {
		try{
		actions.clickAction(missedMenuClick, module, "Navigate to missed Chat Page");
		}
	catch(Exception e)
	{
burgermenuClick(module);	
actions.clickAction(missedMenuClick, module, "Navigate to missed Chat Page");
	}
	}

	public void operatorMessageMenuClick(String module) {
		try{
		MobileElement element = burgerMenuList.get(5);
		actions.clickAction(element, module, "Navigate to OperatorMessage Page");
		}
	catch(Exception e)
	{

	}
	}

	public int checkOnlineUserCountInMenu()
	{
		int value=0;
	try
	{
		String onlineUserCount = actions.getPageSourceValue("android.widget.RelativeLayout",19,"android.widget.TextView",0);
		if(!onlineUserCount.isEmpty())
		{
		value = Integer.parseInt(onlineUserCount);
		}
		else
		{
			value=0;
		}
		
	}
	catch(Exception e)
	{
		value =0;
	}
	return value;
	
	}
	public int checkOngoignChatCountInMenu()
	{
		int value=0;
		try
		{
			
			String ongoingUserCount = eachMenuCount.get(2).findElement(MobileBy.id("com.zoho.salesiq:id/item_no")).getText();
			
			if(!ongoingUserCount.isEmpty())
			{
			value = Integer.parseInt(ongoingUserCount);
			}
			else
			{
				value=0;
			}
			
			
		}
		catch(Exception e)
		{
			value =0;
		}
		return value;
		
	}
	
	
	public String getCurrentStatusInMenu(String module)
	{
		String status="";
		
		status = actions.getElementText(burgerStatusText);
		
		return status;
	}
	
	public void changeStatusInMenu(String status,String module)
	{
		try{
		String value="";
		value = getCurrentStatusInMenu(module);
		if(status.equalsIgnoreCase(value))
		{
			
		}
		else
		{
			actions.clickAction(statusChange,module,"Change status from" +value+ "to" + status);
		}
		}
	catch(Exception e)
	{

	}
	}

}
