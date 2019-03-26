//$Id$
package com.zoho.salesiq.pageclass;

import java.io.IOException;
import java.util.List;

import org.apache.http.util.VersionInfo;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.support.PageFactory;

import com.zoho.salesiq.pageclass.*;
import com.zoho.salesiq.Testclass.*;

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
public class ViewInformationFunctionality extends BaseSetup {
	CommonActionMobile actions = new CommonActionMobile(driver);
	private String module = "View InformationPage";
	Extentreportclass extentreportclass = new Extentreportclass();
	VisitorSiteAccessTest visitorSiteAccessTest = new VisitorSiteAccessTest();
	private boolean viewInformationPage;
	public boolean ipMasked = true;
	public boolean emailAdded;
	SendMailFunctionality sendmail=new SendMailFunctionality(driver);
	
	//this variable to handle list location change after email and phone number update
	private static int listUpdation = 0;
	

	public ViewInformationFunctionality(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "contentview")
	List<MobileElement> viewInformationList;
	
	
	@AndroidFindBy(id = "primaryItemText")
	List<MobileElement> indvidualInformation;
	
	@AndroidFindBy(id = "path_action_time")
	List<MobileElement> footPathActionTime;
	
	@AndroidFindBy(id = "path_action_text")
	List<MobileElement> footPathActionText;
	
	@AndroidFindBy(id = "footer_time")
	List<MobileElement> footPathFooterTime;
	
	
	@AndroidFindBy(id = "editText1")
	MobileElement nameEdit;
	
	
	@AndroidFindBy(id = "editText2")
	MobileElement emailEdit;
	
	
	@AndroidFindBy(id = "editText3")
	MobileElement phoneNumberEdit;
	
	@AndroidFindBy(id = "action_save")
	MobileElement saveEditInformation;
	
	

	@AndroidFindBy(className = "android.widget.TextView")
	List<MobileElement> visitorName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Foot Path']")
	MobileElement footPathPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Information']")
	MobileElement editInformationPage;
	
	@AndroidFindBy(id = "title")
	List<MobileElement> kebabMenuList;
	
	@AndroidFindBy(id = "actionicon")
	List<MobileElement> actionIcon;

	public void checkViewInformationPageOpen(String module) {
		if (viewInformationPage = viewInformationList.isEmpty()) {
			extentreportclass.mobilefailTest(driver,module, "check view information page open");
		} else {
			
			listUpdation=actions.getListCount(actionIcon);
			extentreportclass.mobilepassTest(module, "check View information page open");
		}
	}

	public void checkIpAddresInViewInformation(String module) {
		
		try {
			listUpdation=actions.getListCount(actionIcon);
			String ipAddress = indvidualInformation.get(0+listUpdation).getText();
			String currentIP = actions.getSystemPublicIPAddress();
			if (ipMasked && !indvidualInformation.isEmpty()) {
				if (ipAddress.equalsIgnoreCase(currentIP)) {
					extentreportclass.mobilefailTest(driver,module, "Check masked IP Address in View information page");
				} else {
					extentreportclass.mobilepassTest(module, "Check masked IP Address in View information page");
				}
			} else {
				if (ipAddress.equalsIgnoreCase(currentIP)) {
					extentreportclass.mobilepassTest(module, "Check ip address in View information page");
				} else {
					extentreportclass.mobilefailTest(driver,module, "Check ip address in View information page");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			extentreportclass.mobilefailTest(driver,module, "Check ip address in View information page");
		
		}

	}
	
	
	public void checkCountryName(String module)
	{
		
		try {
			listUpdation=actions.getListCount(actionIcon);
			actions.checkText("India", indvidualInformation.get(1+listUpdation), module, "Check Country name in View Information");
			
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Country name in View Information Page");
		}

	}
	public void checkDepartmentName(String module)
	{
		try {
			listUpdation=actions.getListCount(actionIcon);
			actions.checkText(visitorSiteAccessTest.departmentName, indvidualInformation.get(2+listUpdation), module, "Check Department name in ViewInformation");
			
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Department name in View Information Page");
		}
		
	}

	public void checkVisitorName(String module) {
		try
		{
		actions.checkText(visitorSiteAccessTest.visitorName, visitorName.get(0), module,
				"Check Visitor Name: "+visitorSiteAccessTest.visitorName+" in ViewInformation");
		}
		catch(Exception e)
		{
			
		}
	}
	public void checkVisitorEmailId(String module) {
		String caseName="Check Visitor Email ID: "+visitorSiteAccessTest.emailID+" in ViewInformation Page";
		try
		{
			actions.checkText(visitorSiteAccessTest.emailID,indvidualInformation.get(0), module,caseName);
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}
	
	public void checkSalesiqURL(String module)
	{

		try {
			listUpdation=actions.getListCount(actionIcon);
			actions.checkText(visitorSiteAccessTest.salesiqURL, indvidualInformation.get(3+listUpdation), module, "check salesiqURL in ViewInformation");
			
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check salesiqURL in View Information Page");
		}
	}
	public void checkbrowserName(String module)
	{
		
		try {
			listUpdation=actions.getListCount(actionIcon);
			actions.checkText("Google Chrome", indvidualInformation.get(4+listUpdation), module, "check browserName in ViewInformation");
			
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check browserName in View Information Page");
		}
	}
	public void checkOSName(String module)
	{
		String osValue="";
		
		try {

			
			osValue = System.getProperty("os.name").toLowerCase();
			if(osValue.indexOf("mac") >= 0)
			{
				listUpdation=actions.getListCount(actionIcon);
				actions.checkText("Apple Macintosh",indvidualInformation.get(5+listUpdation), module, "check OS Name in ViewInformation");
			}
			else if(osValue.indexOf("nix") >= 0 || osValue.indexOf("nux") >= 0 || osValue.indexOf("aix") > 0 )
			{
				listUpdation=actions.getListCount(actionIcon);
				actions.checkText("Linux",indvidualInformation.get(5+listUpdation), module, "check OS Name in ViewInformation");
			}
			else
			{
				listUpdation=actions.getListCount(actionIcon);
				actions.checkText("Apple Macintosh",indvidualInformation.get(5+listUpdation), module, "check OS Name in ViewInformation");
			}
			
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check OS Name in View Information Page");
		}
	}
	
	public void checkViewInformationKebabMenu(String module)
	{
		actions.checkTextinList(kebabMenuList, "Edit Information", module, "Check Edit information in view information Kebaba Menu");
		actions.checkTextinList(kebabMenuList, "More Information", module, "Check More Information in view information Kebaba Menu");
	}
	public void checkEditInformationPageOpen(String module)
	{
		String caseName ="Check Edit information page is open";
		try
		{
		actions.isPageOpened(editInformationPage, module, caseName);
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
			
		}
	}
	
	public void editVisitorName(String module,String visitorName)
	{
		nameEdit.clear();
		actions.actionEnter(nameEdit, visitorName, module, "Enter VisitorName in Edit Information page");
	}
	
	public void editEmailAddress(String module,String emailAddress)
	{
		// actions.checkText("", emailEdit, module,"Check empty field if mail id not entered" );
		//checkEmptyText(emailEdit,module,"Check empty field if mail id not entered");
		emailEdit.clear();
		actions.actionEnter(emailEdit, emailAddress, module, "Enter Email in Edit Information page");
	}
	
	public void editPhoneNumber(String module,String phoneNumber)
	{
		phoneNumberEdit.clear();
		actions.actionEnter(phoneNumberEdit, phoneNumber, module, "Enter phone Number in Edit Information page");
	}

	public void checkEmptyText(MobileElement elem,String module,String testCase)
	{
		if(elem.getText().isEmpty())
		{

			extentreportclass.mobilepassTest(module, testCase);
		}
		else
		{

			extentreportclass.mobilefailTest(driver,module, testCase);
		}
	}
	
	public void saveEditInformation(String module)
	{
		try
		{
		actions.clickAction(saveEditInformation, module, "Save edited information");
		
		//wait for information to update
		actions.waitTime(3);
		
		if(actions.getListCount(actionIcon)>0)
		{
			extentreportclass.mobilepassTest(module, "After save edit information details updated in view information page");
			emailAdded=true;
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, "After save edit information details updated in view information page");
			emailAdded=false;
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "After save edit information details updated in view information page");
	}
	}
	
	public void checkNewMenuAddedafterupdateMail(String module)
	{
		if(emailAdded)
		{
			actions.checkTextinList(kebabMenuList, "Send Email", module, "Check Send mail menu added afrer Email update");
			actions.checkTextinList(kebabMenuList, "Push to CRM", module, "Check Push to CRM menu added afrer Email update");
			actions.checkTextinList(kebabMenuList, "Convert Chat as Ticket", module, "Check Convert Chat as Ticket menu added afrer Email update");
			
		}
	}
	public void checkEmailIdandPhoneNumber(String module,String emailid,String phoneNumber)
	{try {
		if(actions.getListCount(actionIcon)==1)
		{
			actions.checkText(emailid, indvidualInformation.get(0), module, "Check email id in view information page after update");
		}
		else if(actions.getListCount(actionIcon)==2)
		{
			actions.checkText(emailid, indvidualInformation.get(0), module, "Check phone number in view information page after update");
			actions.checkText(phoneNumber, indvidualInformation.get(1), module, "Check Phone number in view information page after update");
		}
		
	}catch (ArrayIndexOutOfBoundsException e) {
		// TODO: handle exception
	}
	
	}
	public void checkSendMailIcon(String module,String useCase)
	{
		String testCaseName="Verify Mail Icon is displayed in View information page";
		try
		{		
		MobileElement sendMailIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("mailIcon"));
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
	
	public void clickSendMail(String module)
	{
		String caseName="Navigate to compose mail page by clicking on mail icon";
		try {
		actions.clickAction(actionIcon.get(0), module,caseName);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}
	public void clickCallIcon(String module)
	{
		try {
			actions.clickAction(actionIcon.get(1), module, "Click on Call icon in view information page");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Click on Call icon in view information page");
			
		}
	}
	
	public void checkVisitorNameInEditPage(String module,String visitorName)
	{
		String caseName="Check visitor name in edit information page";
		try {
			actions.checkText(visitorName,nameEdit,module,caseName);
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
			
		}
		
	}
	public void checkEmailIdInEditPage(String module,String visitorEmail)
	{
		String caseName="Check visitor name in edit information page";
				try {
					actions.checkText(visitorEmail,emailEdit,module,caseName);
				}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
			
		}
		
	}
	public void checkMobileNumberInEditPage(String module,String mobileNumber)
	{
		String caseName="Check mobile number in edit information page";
				try {
					
					if(actions.checkIntegerValue(phoneNumberEdit.getText()))
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
	public void checkFootPathOpenCheck(String module)
	{
		String caseName="Check foot path page is opened after open Foot Path";
		try {
			if(footPathPage.isDisplayed())
			{
				extentreportclass.mobilepassTest(module, caseName);
			
			}else
			{
				extentreportclass.mobilefailTest(driver,module, caseName);
				
			}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
			
		}
	}
	public void checkUIInFootPathPage(String module)
	{
		String caseName="Check UI of Foot path Details page";
		try {
		boolean actionTime,actionText,footerTime;
		actionTime=actions.isPageOpen(footPathActionTime.get(0));
		actionText=actions.isPageOpen(footPathActionText.get(0));
		int value = footPathActionText.size()/3;
		actions.swipeElementLocation(footPathActionText.get(footPathActionText.size()), footPathActionText.get(value));
		footerTime=actions.isPageOpen(footPathFooterTime.get(0));
		if(actionTime&&actionText&&footerTime)
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
	
	
	
	
	
	
	
	
	
	

}
