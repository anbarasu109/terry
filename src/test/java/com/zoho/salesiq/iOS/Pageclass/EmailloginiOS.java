//$Id$
package com.zoho.salesiq.iOS.Pageclass;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import java.util.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class EmailloginiOS {
	
	IOSDriver driver;
	private static Log log = LogFactory.getLog(EmailloginiOS.class);
	
	String module="EmailLoginPage";

	public  EmailloginiOS(IOSDriver driver) {
		
		this.driver=driver;
	

		}
	

	@iOSFindBy(accessibility = "Sign In")
	MobileElement clickSignIN;
	
	

	public void signInClick()
	{
		try
		{
		
			Thread.sleep(10000);
		clickSignIN.click();
		Thread.sleep(20000);
		
		
		Set<String> contextNames = driver.getContextHandles();
		System.out.println("______________________CONTEXT LIST"+contextNames);
	}
	catch(Exception e)
	{
		log.debug("Exception in"+Thread.currentThread().getStackTrace());
	}
	}
	
	


	
}
