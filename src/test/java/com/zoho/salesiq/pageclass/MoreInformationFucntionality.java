//$Id$
package com.zoho.salesiq.pageclass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.KebabMenuFunctionality;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class MoreInformationFucntionality extends BaseSetup {
	CommonActionMobile actions = new CommonActionMobile(driver);
	private String module = "More Information Page";
	Extentreportclass extentreportclass = new Extentreportclass();
	VisitorSiteAccessTest visitorSiteAccessTest = new VisitorSiteAccessTest();
	ViewInformationFunctionality viewInformationFunctionality=new ViewInformationFunctionality(driver);
	private KebabMenuFunctionality kebabmenufunctionality = new KebabMenuFunctionality(driver);
	private boolean sendMailPage;
	
	public MoreInformationFucntionality(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id ="primaryItemText")
	List<MobileElement> moreInformationList;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='More Information']")
	MobileElement moreInformationTitle;
	

	
	
	public void checkMoreInformationPageOpen(String module)
	{
	actions.isPageOpened(moreInformationTitle, module, "Check More information page open");
	
	}
	
	public void checkVisitorName(String module,String visitorName)
	{
		try {

			actions.checkText(visitorName, moreInformationList.get(1), module, "Visitor Name check in More Information Page");			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Name check in More Information Page");
		}
	}
	
	public void checkVisitorQuestion(String module,String visitorQuestion)
	{
		try {
			actions.checkText(visitorQuestion, moreInformationList.get(2), module, "Visitor Question check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Question check in More Information Page");
		}
	}
	
	public void checkVisitorDepartment(String module,String visitorDepartment)
	{
		try {
			actions.checkText(visitorDepartment, moreInformationList.get(3), module, "Visitor Department check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Department check in More Information Page");
		}
	}
	
	public void checkVisitorEmbed(String module,String visitorEmbed)
	{
		try {
			actions.checkText(visitorEmbed, moreInformationList.get(4), module, "Visitor Embed check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Embed check in More Information Page");
		}
	}
	
	public void checkVisitorchatMissedReason(String module,String visitorChatMisssedReason)
	{
		try {
			
				
			
			actions.checkText(visitorChatMisssedReason, moreInformationList.get(5), module, "Visitor Chat Missed Reason check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Chat Missed Reason check in More Information Page");
		}
	}
	public void checkVisitorEmailID(String module,String visitorEmailId)
	{
		try {
		
				
			actions.checkText(visitorEmailId, moreInformationList.get(6), module, "Visitor Email id check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Email id check in More Information Page");
		}
	}
	public void checkVisitorPhoneNumber(String module,String visitorPhoneNumber)
	{
		try {
			
				actions.swipeElementLocation(moreInformationList.get(6), moreInformationList.get(5));
			
			actions.checkText(visitorPhoneNumber, moreInformationList.get(6), module, "Visitor Phone Number check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Phone Number check in More Information Page");
		}
	}
	
	public void checkVisitorInTime(String module,String visitorInTime)
	{
		try {
			actions.swipeElementLocation(moreInformationList.get(6), moreInformationList.get(5));
			actions.checkText(visitorInTime, moreInformationList.get(6), module, "Visitor In Time check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor In Time check in More Information Page");
		}
	}
	public void checkVisitorMissedTime(String module,String visitorMissedTime)
	{
		try {
			
			actions.swipeElementLocation(moreInformationList.get(6), moreInformationList.get(5));
			actions.checkText(visitorMissedTime, moreInformationList.get(6), module, "Visitor Missed Time check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Missed Time check in More Information Page");
		}
	}
	public void checkVisitorEndTime(String module,String visitorEndTime)
	{
		try {
			
			actions.swipeElementLocation(moreInformationList.get(6), moreInformationList.get(5));
			
			actions.checkText(visitorEndTime, moreInformationList.get(6), module, "Visitor End Time check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor End Time check in More Information Page");
		}
	}
	public void checkVisitorCountry(String module)
	{
		try {
			
			actions.swipeElementLocation(moreInformationList.get(6), moreInformationList.get(5));
			
			actions.checkText("INDIA", moreInformationList.get(6), module, "Visitor End Time check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor End Time check in More Information Page");
		}
	}
	
	
	
	public void checkVisitorState(String module)
	{
		try {
			
			actions.swipeElementLocation(moreInformationList.get(6), moreInformationList.get(5));
			
			actions.checkText("TAMIL NADU", moreInformationList.get(6), module, "Visitor End Time check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor End Time check in More Information Page");
		}
	}
	
	
	public void checkVisitorCity(String module)
	{
		try {
			
			actions.swipeElementLocation(moreInformationList.get(6), moreInformationList.get(5));
			
			actions.checkText("CHENNAI", moreInformationList.get(6), module, "Visitor End Time check in More Information Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor End Time check in More Information Page");
		}
	}
	
	
	public void checkVisitorIPAddress(String module)
	{
		try {
			
			actions.swipeElementLocation(moreInformationList.get(6), moreInformationList.get(5));
			

			String ipAddress = moreInformationList.get(6).getText();
			String currentIP = actions.getSystemPublicIPAddress();
			if (viewInformationFunctionality.ipMasked) {
				if (ipAddress.equalsIgnoreCase(currentIP)) {
					extentreportclass.mobilefailTest(driver,module, "Check masked IP Address");
				} else {
					extentreportclass.mobilepassTest(module, "Check masked IP Address");
				}
			} else {
				if (ipAddress.equalsIgnoreCase(currentIP)) {
					extentreportclass.mobilepassTest(module, "Check masked IP Address");
				} else {
					extentreportclass.mobilefailTest(driver,module, "Check masked IP Address");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
	
	public void checkNewVisitorIPAddress(String module)
	{
		try {
		String ipAddress = moreInformationList.get(0).getText();
		String currentIP = actions.getSystemPublicIPAddress();
		if (viewInformationFunctionality.ipMasked) {
			if (ipAddress.equalsIgnoreCase(currentIP)) {
				extentreportclass.mobilefailTest(driver,module, "Check New visitor masked IP Address");
			} else {
				extentreportclass.mobilepassTest(module, "Check New visitor masked IP Address");
			}
		} else {
			if (ipAddress.equalsIgnoreCase(currentIP)) {
				extentreportclass.mobilepassTest(module, "Check New visitor masked IP Address");
				
							} else {
								extentreportclass.mobilefailTest(driver,module, "Check New visitor IP Address");
			}
		}
	} catch (Exception e) {
		extentreportclass.mobilefailTest(driver,module, "Check New visitor IP Address");
		// T
	}	
	}
	
	public void checkNewVisitorBrowser(String module)
	{
		String browser="";

		try {
			browser = moreInformationList.get(1).getText();
		}
		catch(Exception e){
			
			if(browser.equalsIgnoreCase("Google Chrome"))
			{
				extentreportclass.mobilepassTest(module, "Check New visitor browser");

			}
			else
			{
				extentreportclass.mobilefailTest(driver,module, "Check New visitor browser");
				
			}
			
		}
		
	}
	public void checkNewVisitorRegion(String module)
	{
		String region="";

		try {
			region = moreInformationList.get(3).getText();
			if(region.equalsIgnoreCase("Asia Pacific"))
			{
				extentreportclass.mobilepassTest(module, "Check new visitor region");

			}
			else
			{
				extentreportclass.mobilefailTest(driver,module, "Check new visitor region");
				
			}
		}
		catch(Exception e){
			
			extentreportclass.mobilefailTest(driver,module, "Check new visitor region");
		
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
