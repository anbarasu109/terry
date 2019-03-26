//$Id$
package com.zoho.salesiq.pageclass;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;

import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class NewChatNotification extends BaseSetup {
	CommonActionMobile actions = new CommonActionMobile(driver);
	private String module = "New Chat Notification";
	Extentreportclass extentreportclass = new Extentreportclass();
	VisitorSiteAccessTest visitorSiteAccessTest = new VisitorSiteAccessTest();
	ViewInformationFunctionality viewInformationFunctionality=new ViewInformationFunctionality(driver);
	private boolean sendMailPage;
	private boolean chatNotificationPage;
	
	
	public NewChatNotification(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@WithTimeout(time=5, chronoUnit = ChronoUnit.SECONDS)
	@AndroidFindBy(id ="com.zoho.salesiq:id/pickuptext")
	MobileElement newChatPickup;
	
	@AndroidFindBy(id ="com.zoho.salesiq:id/ignorechat")
	MobileElement newChatIgnore;
	
	@AndroidFindBy(id = "title")
	MobileElement chatNotificationType;
	

	@AndroidFindBy(id = "com.zoho.salesiq:id/timetextview")
	MobileElement  chatTimer;

	
	@AndroidFindBy(id = "com.zoho.salesiq:id/visitname")
	MobileElement visitorName;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/location")
	MobileElement locationVisitor;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/cpage")
	MobileElement salesiqPage;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/question")
	MobileElement visitorQuestion;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/vtype")
	MobileElement visitorType;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/email")
	MobileElement visitorEmailID;
	
	
	public void checkFullScreenNewChatOpen(String module)
	{
		try{
		actions.isPageOpened(newChatPickup, module, "Check New chat notification page opened with full screen");
	}
	catch(Exception e)
	{
			extentreportclass.mobilepassTest(module, "Check New chat notification page opened with full screen");

	}
}
	public void checkChatNotification(String module)
	{
		try
		{
		actions.isPageOpened(newChatPickup, module, "Check New chat notification page opened with full screen");
		}
		catch(Exception e)
		{
			extentreportclass.mobilepassTest(module, "Chat initiate notification not shown");
		}
	}
	
	public void ignoreChat(String module)
	{
		try
		{
		if(actions.isPageOpen(chatTimer))
		{
//		actions.swipeElementLocation(newChatIgnore,newChatPickup);
		actions.swipeOption(800,1660,150,1660);
		extentreportclass.mobilepassTest(module, "Ignore chat from new chat notiffication");
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, "Ignore chat from new chat notiffication");
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Ignore chat from new chat notiffication");
		}
	}
	public void pickupChat(String module)
	{
//		actions.swipeElementLocation(newChatPickup,newChatIgnore);
		try
		{
			if(actions.isPageOpen(chatTimer))
			{
		actions.swipeOption(150,1660,800,1660);
		extentreportclass.mobilepassTest(module, "Pickup chat from new chat notiffication");
	
			}
	}

		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "pickup chat from new chat notiffication");
		}
	
	}
	
	public void checkChatInitiateNotShown(String module)
	{
		try
		{
		if(newChatPickup.isDisplayed())
		{
			
			extentreportclass.mobilefailTest(driver,module, "Chat initiate notification at busy state");
			ignoreChat(module);
			
		}
		else
		{
			extentreportclass.mobilepassTest(module, "Chat initiate notification at busy state");
			
			
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilepassTest(module, "Chat initiate notification at busy state");
		}
	}
	
	public void checkChatNotificationOpen(String module)
	{
		try
		{
		chatNotificationPage=actions.isPageOpened(chatTimer,module,"Check chat Notification page is opened");
				}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check chat Notification page is opened");
		}
	}
	
	public void checkNameInChatNotificationPage(String module,String visitorNameValue)
	{
		try
		{
		String actualVisitorName = actions.getPageSourceValue("android.widget.LinearLayout",4,"android.widget.TextView",0);
		actions.compareText(actualVisitorName,visitorNameValue,module,"Check Visitor Name in Chat notification");
				}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check Visitor Name in Chat notification");
		}
	}
	
	public void checkNotificationType(String module,String notificationType)
	{
		try
		{
		String actualNotificationType = actions.getPageSourceValue("android.widget.RelativeLayout",0,"android.widget.TextView",1);
		actions.compareText(actualNotificationType,notificationType,module,"Check Notification type in Chat notification");
		
//		actions.checkText(notificationType,chatNotificationType,module,"check Notification type in Chat notification");
			}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check Notification type in Chat notification");
		}
		
	}
	public void checkSiteAccessPage(String module,String sitePage)
	{
		try
		{
		String actualSitePage = actions.getPageSourceValue("android.widget.LinearLayout",8,"android.widget.TextView",1);
		
		actions.compareText(actualSitePage,sitePage,module,"Check Site access page in Chat notification");
		
//		actions.checkText(sitePage,salesiqPage,module,"check Site access page in Chat notification");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check Site access page in Chat notification");
		}
		
	}
	public void checkLocationName(String module,String locationName)
	{
		try
		{
		String actualLocationName = actions.getPageSourceValue("android.widget.LinearLayout",7,"android.widget.TextView",1);
		
		actions.compareText(actualLocationName,locationName,module,"Check Location Name in Chat notification");
//		actions.checkText(locationName,locationVisitor,module,"check Location Name in Chat notification");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check Location Name in Chat notification");
		}
		
	}
	public void checkVisitorQuestion(String module,String visitorQuestionValue)
	{
		try
		{
		String actualVisitorQuestionValue = actions.getPageSourceValue("android.widget.LinearLayout",10,"android.widget.TextView",1);
		
		actions.compareText(actualVisitorQuestionValue,visitorQuestionValue,module,"Check visitor question in Chat notification");
//		actions.checkText(actualVisitorQuestionValue,visitorQuestion,module,"check visitor question in Chat notification");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check visitor question in Chat notification");
		}
		
	}
	public void checkVisitorType(String module,String visitorTypeValue)
	{
		try
		{
		String actualvisitorTypeValue = actions.getPageSourceValue("android.widget.LinearLayout",12,"android.widget.TextView",1);
		
		actions.compareText(actualvisitorTypeValue,visitorTypeValue,module,"Check visitor Type in Chat notification");
//		actions.checkText(visitorTypeValue,visitorType,module,"check visitor Type in Chat notification");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check visitor Type in Chat notification");
		}
		
	}
	public void checkVisitorEmail(String module,String visitorEmailValue)
	{
		try
		{
		String actualvisitorEmailValue = actions.getPageSourceValue("android.widget.LinearLayout",6,"android.widget.TextView",1);
		
		actions.compareText(actualvisitorEmailValue,visitorEmailValue,module,"Check visitor Email in Chat notification");
//		actions.checkText(visitorEmailValue,visitorEmailID,module,"check visitor Email in Chat notification");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check visitor Email in Chat notification");
		}
		
	}

	

}
