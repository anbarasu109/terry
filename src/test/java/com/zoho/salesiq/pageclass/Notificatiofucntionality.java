//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;


public class Notificatiofucntionality extends BaseSetup{
	CommonActionMobile actions=new CommonActionMobile(driver);
	private String module="Notification Functionality";
	Extentreportclass extentreportclass=new Extentreportclass();
	
	public Notificatiofucntionality(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Missed Chat']")
//	List<MobileElement> notificationTypeName;
//	
	@AndroidFindBy(id = "//android.widget.TextView[@text='now']")
	List<MobileElement> notificationTime;
	
	
	 	@FindBy(id = "android:id/inbox_text0")
	    private List<MobileElement> checkChatText;
	 	
	 	@FindBy(id = "com.android.systemui:id/notification_panel")
	 	private List<MobileElement> notificationPanel;
	    //settings data
	    @FindBy(id = "com.android.systemui:id/dismiss_text")
	    MobileElement clearAllBtn;
	    //last items
	    @FindBy(id = "com.android.systemui:id/latestItems")
	    private List<MobileElement> lastItemsContainer;
	    //events data
	    @FindBy(id = "android:id/status_bar_latest_event_content")
	    private List<MobileElement> lastItemsContent;
	    
	    @FindBy(id = "android:id/title")
	    private List<MobileElement> itemTitle;
	    String itemTitle_Locator_Text = "android:id/title";
	    @FindBys({
	            @FindBy (id = "android:id/big_text"),
	            @FindBy (id = "android:id/text")
	    })
	    private List<MobileElement> itemText;
	    String itemText_Phone_Locator_Text = "android:id/text";
	    @FindBy(id = "android:id/time")
	    private List<MobileElement> itemTime;
	    
	    @FindBy(id = "android:id/time")
	    private List<MobileElement> notificationAction;
	    
	    
	    @FindBy (id ="android:id/big_text")
	    MobileElement tapNotification;
	    
	    @AndroidFindBy (accessibility = "android:id/action0")
	    List<MobileElement> initiateChat;
	    
	    @AndroidFindBy (accessibility = "android:id/action0")
	    List<MobileElement> viewVisitorInfo;
	    
	   

	public void clickViewInfo(String module)
	{
		try
		{
		if(viewVisitorInfo.get(0).isDisplayed())
		{
		actions.clickAction(viewVisitorInfo.get(0), module, "Click on viewInfo in Notification");
		}
		else
		{
			actions.backPress(module, "View info action not shown so Close notification bar");
		}
	}
	catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
		// TODO: handle exception
// 	System.out.println("Failed to click on Notification");
	
	}finally
	{
		actions.backPress(module, "Close notification bar");
	}
	}
	public void clickInitiateChat(String module)
	{
		try {
		if(initiateChat.get(1).isDisplayed())
		{
		actions.clickAction(initiateChat.get(1), module, "Click on Initiate chat in Notification");
		}
		else
		{
			actions.backPress(module, "Initiate chat menu not shown so Close notification bar");
		}
		}
		catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
// 		System.out.println("Failed to click on Notification");
		
		}finally
		{
			actions.backPress(module, "Close notification bar");
		}
	}
	
	public void checkPushNotification(String module,String notificationType)
	{
		try {
			actions.waitTime(2);
		MobileElement element = itemText.get(0);
		MobileElement element1 = itemTime.get(0);
		String notificationName=actions.getElementText(element);
		String notificationTimeValue=actions.getElementText(element1);
		actions.compareText(notificationTimeValue, "now", module, "Check whether received notification correctly");
		actions.compareText(notificationName,notificationType, module, "Check whether received notification correctly");
		}
		catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
// 		System.out.println("Failed to click on Notification");
		
		
		}finally
		{
			actions.backPress(module, "Close notification bar");
		}
	}
	
	public void openPushNotification(String module)
	{
		actions.openPushNotification();
	}
	 public boolean isNativeNotificationPage() throws Exception {
	        boolean bool;
	        actions.waitTime(1);
	        bool = !notificationPanel.isEmpty();
	        actions.waitTime(1);
	        return bool;
	    }

	    public boolean isClearAllBtnLoaded() {
	        boolean bool;
	        actions.waitTime(3);
	        bool = !((List<MobileElement>) clearAllBtn).isEmpty();
	        actions.waitTime(1);
	        return bool;
	    }

	    public int getLastItemsContentSize() {return lastItemsContent.size();}

	    public String getItemTitle(int num) {return lastItemsContent.get(num).findElement(By.id(itemTitle_Locator_Text)).getText();}

	    public String getItemText(int num) {
// 	        //System.out.println(lastItemsContent.get(num).findElements(MobileBy.className("android.widget.TextView")).size());
	                return lastItemsContent.get(num).findElement(MobileBy.id("android:id/big_text")).getText();
	    
	    }
 		public String getOperatorChatText(int num) {
// 	        //System.out.println(lastItemsContent.get(num).findElements(MobileBy.className("android.widget.TextView")).size());
 			String elem="android:id/inbox_text"+num;
	                return lastItemsContent.get(0).findElement(MobileBy.id(elem)).getText();
	    
	    }

	    public void tapClearAllBtn(String module) {
	    	try{
	    	if(clearAllBtn.isDisplayed())
	    	{
	    	clearAllBtn.click();
	    	}
	    	
	    	}catch(Exception e)
	    	{

	    	}
	    }


	    public void tapLastItemsContent(int num) {
	    	actions.clickAction(lastItemsContainer.get(num),module,"");
	       	    }

	    public void tapOngoingAudioCallNotification(String module) {
	    	actions.clickAction(lastItemsContent.get(0),module,"Click on Ongoing Call notification");
	    
	    }
	    public void checkNotifcationType(String module,String notificationType)
	    {
	    	try
	    	{
	    	String actualText=getItemTitle(0);
	    	actions.compareText(actualText, notificationType, module, "Check notification Title text");
	    	}
	    	catch(IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e){
	    		extentreportclass.mobilefailTest(driver,module, "Notification not received for"+notificationType);
	    		
	    	}
	    	
	    		
	    }


	    public void checkOperatorChatText(String useCase,String categories,String notificationText)
	    {
	    	try
	    	{
	    	String actualText=getOperatorChatText(0);
	    	actions.compareText(actualText, notificationText, useCase, "Verify in notification operator chats Notification should be expected");
	    	}
	    	catch(IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e){
	    		extentreportclass.mobilefailTest(driver,module, "Notification not received for "+notificationText);
	    		
	    	}
	    	
	    }
	    
	    public void checkNotifcationText(String module,String notificationText)
	    {
	    	try
	    	{
	    	String actualText=getItemText(0);
	    	
	    		actions.compareText(actualText, notificationText, module, "Check notification Title text");
	    	}
	    	catch(IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e){
	    		extentreportclass.mobilefailTest(driver,module, "Notification not received"+notificationText);
	    	}
	    	
	    }
	    
	    public void checkNotificationNotShow(String module,String notificationText) {
	    	boolean status;
	    	try {
	    	
	    	if(1==1) {
	    		status=true;
	    	}
	    	}
	catch (IndexOutOfBoundsException e) {
		// TODO: handle exception
		
	}
	    }
	    
	    public void tapPushNotification(String module)
	    {
	    	try
	    	{
	    	lastItemsContent.get(0).findElement(MobileBy.id("android:id/big_text")).click();
	    	}
	    	catch(IndexOutOfBoundsException e){
	    		extentreportclass.mobilefailTest(driver,module, "Notification not received for new visitor");
	    	}
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public void checkAudioCallNotification(String module,String callType)
	    {
	    	
	    	String actualValue="";
	    
		try
		{

			actualValue = actions.getPageSourceValue("android.widget.LinearLayout",7,"android.widget.TextView",1);
			if(!actualValue.isEmpty())
			{
			if(actualValue.equalsIgnoreCase(callType))
			{
				extentreportclass.mobilepassTest(module, "Check notification for Audio call");
			}
			else
			{
				extentreportclass.mobilefailTest(driver,module, "Check notification for Audio call");
			}
			}
			
			
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check notification for Audio call");
		}
	    	
	    }
	    
	    public void checkVisitorSendText(String module,String text)
	    {
	    	String caseName="Check minimized application chat notification";
	    	try
	    	{
	    		actions.textContainsText(checkChatText.get(0),text,module,caseName);
	    	}
	    	catch(Exception e)
	    	{
	    		extentreportclass.mobilefailTest(driver,module, "Check chat notification");
	    		
	    	}
	    	
	    }
	    public void checkSendTextKilledApp(String module,String text)
	    {
	    	String caseName="Check killed application chat notification";
	    	try
	    	{
	    		actions.textContainsText(checkChatText.get(0),text,module,caseName);
	    	}
	    	catch(Exception e)
	    	{
	    		
	    	}
	    }
	    public void clickChatNotification(String module)
	    {
	    	try{
	    	actions.clickAction(checkChatText.get(0), module, "Click on Chat notification send by operator");
	    }
	    catch(Exception e)
	    {
	    	
	    }
	    }
	   
	    
	    
	    
	    
	}
	
	
	
	



