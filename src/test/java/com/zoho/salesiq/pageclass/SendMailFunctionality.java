//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SendMailFunctionality extends BaseSetup {
	CommonActionMobile actions = new CommonActionMobile(driver);
	private String module = "Send Mail Page";
	Extentreportclass extentreportclass = new Extentreportclass();
	VisitorSiteAccessTest visitorSiteAccessTest = new VisitorSiteAccessTest();
	private static boolean sendMailPage;
	
	public SendMailFunctionality(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.zoho.salesiq:id/action_send_mail")
	MobileElement sendMailIcon;
	
	
	@AndroidFindBy(id="com.zoho.salesiq:id/emailfromtextview")
	@CacheLookup
	MobileElement emailFrom;
	
	@AndroidFindBy(id="com.zoho.salesiq:id/email_totext")
	@CacheLookup
	MobileElement emailTo;
	
	@AndroidFindBy(id="com.zoho.salesiq:id/email_cctext")
	@CacheLookup
	MobileElement emailCC;
	
	@AndroidFindBy(id="com.zoho.salesiq:id/subject_text")
	@CacheLookup
	MobileElement subjectEmail;
	
	@AndroidFindBy(id="com.zoho.salesiq:id/compose_text")
	@CacheLookup
	MobileElement emailContent;
	
	@AndroidFindBy(accessibility="‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎")
	@CacheLookup
	MobileElement closeEmailPage;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_deny_button‎‏‎‎‏‎")
	@CacheLookup
	MobileElement permissionDeny;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/do_not_ask_checkbox‎‏‎‎‏‎")
	@CacheLookup
	MobileElement dontAskPermissionAgain;
	
	@AndroidFindBy(id="com.zoho.salesiq:id/primaryItemText")
	@CacheLookup
	List<MobileElement> individualInformation;
	
	public void checkSendMailPageOpen(String module)
	{
		String caseName ="check Send Mail Page is Opened";
		try
		{
	sendMailPage=actions.isPageOpened(sendMailIcon, module,caseName );
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);

		}
	}
	
	public void checkFromEmailID(String module,String emailid)
	{
		String caseName ="Check From Email id in Send Email page";
		try
		{
	
		
		actions.checkText(emailid, emailFrom, module,caseName );
		
	
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}
	
	public void checkToEmailID(String module,String toEmailid)
	{
		String caseName ="Check From Email id in Send Email page";
		try
		{
		
			actions.textContainsText(emailTo,toEmailid, module, "check To Email id in Send Email page");
			
		
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}
	public void checkCCEmailID(String module,String ccEmailid)
	{
		String caseName ="Check CC Email id in Send Email page";
		try
		{
						
		
			actions.checkText(ccEmailid, emailCC, module, caseName);
			
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, caseName);
	}
	}
	public void checkEmailSubject(String module,String emailSubject)
	{
		String caseName ="Check Email Subject in Send Email page";
		try
		{
	
		
			actions.checkText(emailSubject, subjectEmail, module, caseName);
			}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, caseName);
	}
	}
			
		
	

	public void enterSubjectInMail(String module,String emailSubject)
	{
		String caseName ="Enter email subject in compose mail page";
		try
		{
			
			actions.actionEnter(subjectEmail, emailSubject, module, caseName);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, caseName);
	}
	}
	
	public void enterEmailContent(String module,String emailText)
	{
		String caseName ="Enter email content in Send Email page";
		try
		{
		
			actions.actionEnter(emailContent, emailText, module, "Enter email content");
		
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}
	public void sendEmail(String module)
	{
		String caseName ="Click send mail icon to send mail";
		try
		{
		
			actions.clickAction(sendMailIcon, module, "Send email");
		
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}
	
	public void closeSendEmail(String module)
	{
		String caseName ="Click close icon in send mail";
		try
		{
		actions.clickAction(closeEmailPage, module, "Close Send Email Page");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, caseName);
			actions.hideKeyboard(module);
			actions.backPress(module,caseName);
		}
	}
	
	public void clickPermissionDeny(String module)
	{
		actions.clickAction(permissionDeny, module, "Click on permission deny in phone call permission");
	}
	
	public void clickDontAskPermission(String module)
	{
		actions.clickAction(dontAskPermissionAgain, module, "Click on Dont Ask Permission Again in phone call permission");
	}
	
	public void checkPermissionPopupShown(String module)
	{
		if(individualInformation.isEmpty())
		{
			extentreportclass.mobilepassTest(module, "Popup shown to enable phone call permission");
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, "Popup show to enable phone call permission");
		}
	}
	public void checkSendMail(String module)
	{
		String caseName ="Check mail is successfully send to respective to mail id";
		try
		{
	boolean sendMailPageCheckAfterSend=actions.isPageOpen(sendMailIcon);
	
	if(sendMailPageCheckAfterSend)
	{
		extentreportclass.mobilefailTest(driver,module, caseName);
	}
	else
	{
		extentreportclass.mobilepassTest(module, caseName);
	}
		}
		catch(Exception e)
		{
			extentreportclass.mobilepassTest(module, caseName);
		}
	}
	
	
	
	
	
	

}
