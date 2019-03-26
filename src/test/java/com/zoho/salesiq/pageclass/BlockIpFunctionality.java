//$Id$
package com.zoho.salesiq.pageclass;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import io.appium.java_client.AppiumDriver;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class BlockIpFunctionality {
	AndroidDriver driver=null;
	CommonActionMobile actions;
	
	public BlockIpFunctionality(AndroidDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		actions=new CommonActionMobile(driver);
	}

	
	private String module="Block IP Functionality";
	Extentreportclass extentreportclass = new Extentreportclass();
	VisitorSiteAccessTest visitorSiteAccessTest=new VisitorSiteAccessTest();
	
	
	
	@AndroidFindBy(id ="prompt_message")
	MobileElement blockIpPopupMessage;
	
	@AndroidFindBy(id ="cancel_button")
	MobileElement blockIpCancelButton;
	
	@AndroidFindBy(id ="ok_button")
	MobileElement blockIpOkButton;
	
	@AndroidFindBy(id ="dialog_title")
	MobileElement blockIpTitle;
	
	
	public void checkBlockIPTitle(String module)
	{
		try
		{
		actions.checkText("Block IP", blockIpTitle, module, "Check Block Ip Popup Message Title");
	}
	catch(Exception e)
	{

	}
	}
	
	public void checkmaskedBlockIP(String module)
	{
		try {
			
			String popupTextAndIp[]=blockIpPopupMessage.getText().split("IP");
			
			

			if(popupTextAndIp[1].contains("*"))
			{
				extentreportclass.mobilepassTest(module, "Check popup message Block IP is maked");
			}
			else
			{
				extentreportclass.mobilefailTest(driver,module,  "Check popup message Block IP is maked");
			}
		} catch (Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			extentreportclass.mobilefailTest(driver,module,  "Check popup message Block IP is maked");
		}
	}
	
	
	
	
	public void checkPopupMessageContent(String module)
	{
		try {
			String systemPublicIP=actions.getSystemPublicIPAddress();
			if(blockIpPopupMessage.isDisplayed()&&blockIpPopupMessage.getText().contains(systemPublicIP))
			{
				extentreportclass.mobilepassTest(module, "Check popup message contains Block IP");
			}
			else
			{
				extentreportclass.mobilefailTest(driver,module,  "Check popup message contains Block IP");
			}
		} catch (Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			extentreportclass.mobilefailTest(driver,module,  "IP address exception or empty popup Text");
		}
	}
	
	public void clickBlockIpCancel(String module)
	{
		try{
		actions.clickAction(blockIpCancelButton, module, "Cancel Block IP");
	}
		catch(Exception e)
		{
	e.printStackTrace();
	}
	}
	public void clickBlockIpOK(String module)
	{
		try{
		actions.clickAction(blockIpOkButton, module, "OK Block IP");
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	}
	
	
	
	
	
	
	

}
