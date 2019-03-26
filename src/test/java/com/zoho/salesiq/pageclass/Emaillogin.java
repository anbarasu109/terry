//$Id$
package com.zoho.salesiq.pageclass;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.KebabMenuFunctionality;

public class Emaillogin extends BaseSetup {
	
	
	String module="EmailLoginPage";
	CommonActionMobile actions= new CommonActionMobile(driver);
	public  Emaillogin(AndroidDriver driver) {
		
		Emaillogin.driver=driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	

	@AndroidFindBy(id = "loginButton")
	// @iOSFindBy(id = "recoverPassword")
	MobileElement loginButton;
//
//	@AndroidFindBy(id = "lid")
//	MobileElement emailEnter;
//
//	@AndroidFindBy(id = "pwd")
//	MobileElement passwordEnter;
	@AndroidFindBy(className = "android.widget.EditText")
	List<MobileElement> emailEnter;
	
	@AndroidFindBy(className = "android.widget.EditText")
	List<MobileElement> passwordEnter;

	@AndroidFindBy(className = "android.widget.Button")
	MobileElement loginUser;
	
	@AndroidFindBy(id = "dialog_notification_skip")
	MobileElement notificationDialogSkip;


	@AndroidFindBy(id = "button1")
	MobileElement notIntersted;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Online']")
	MobileElement onlineMenu;

	@AndroidFindBy(id = "setpinedit")
	MobileElement passCode;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='History']")
	@CacheLookup
	MobileElement someElements;
	
	


	public void loginButton(String testcase) {
		actions.clickAction(loginButton,testcase,"Verify User able to login");
	}

	public void enterEmail(String email,String testcase) {
		try {
			System.out.println(driver.getContextHandles());
		actions.actionEnter(emailEnter.get(0), email,testcase,"Verify Email enter field should be shown");
	}
	catch (IndexOutOfBoundsException e) {
		// TODO: handle exception
	}
	}

	public void enterPassword(String password,String testcase) {
		try {
		actions.actionEnter(passwordEnter.get(1),password,testcase,"Verify password enter field should be shown");
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}

	public void loginUser(String testcase)  {
		actions.clickAction(loginUser,testcase,"Verify after clicks on Login app should navigate user to App Home page");
	}
	
	public void clickNotInterested(String testcase)
	{
		if(actions.iselemetFound(notIntersted))
		{
		actions.clickAction(notIntersted,testcase,"Verify Report Popup Showing in every Login");
		}
		
	}

	public void acceptCrashReport()  {
		try {
			actions.clickAction(notIntersted,"Login","Verify after clicks on I am With email address option, popup should be dismissed");
			driver.getPerformanceData("com.zoho.salesiq","cpuinfo", 5000);
		} catch (Exception e) {
		}
		

	}
	public void skipNotificationDialog()  {
		try {
			if(notificationDialogSkip.isDisplayed())
			{
			actions.clickAction(notificationDialogSkip,"Login","Click on Skip in Notification dialog");
			}
		} catch (Exception e) {
		}
		
		
	}

	public void enterPasscode(String code) {
		passCode.sendKeys(code);
	}

	public void clickOngoing() throws InterruptedException, IOException {
		
		
//		driver.openNotifications();
		
//		MobileElement textOngoing = (MobileElement)driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Ongoing\")");
//		textOngoing.click();
//		
//		
//		
//		driver.pushFile("/path/to/device/foo.bar", new File("/Users/johndoe/files/foo.bar"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/header_status_change_track")));
//		statusChange.click();
//		
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='History']")));
		someElements.click();
//
//	
//
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("visitname")));

		List<MobileElement> elements = driver.findElementsById("visitname");
		
		
		elements.get(0).click();
	
//
//		WebDriverWait wait3 = new WebDriverWait(driver, 20);
//		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/showmsg")));
//
////		AndroidElement element1= (AndroidElement)driver.findElement(By.id("com.zoho.salesiq:id/showmsg"));
////		TouchAction action = new TouchAction(driver);
////		action.longPress(element1).waitAction(100).release().perform();
//
////		burger.click();
////		WebDriverWait wait1 = new WebDriverWait(driver,20);
////		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Online']")));
////		onlineMenu.click();
//		WebDriverWait wait1 = new WebDriverWait(driver, 20);
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/item_name")));
//		List<WebElement> elementName = driver.findElementsById("com.zoho.salesiq:id/item_name");
//		System.out.println(elementName.size());

	}
	public void dpClick()
	{
//		WebDriverWait wait2 = new WebDriverWait(driver, 20);
//		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/header_dp")));
//		MobileElement eleme = driver.findElement(By.id("com.zoho.salesiq:id/header_dp"));
//		eleme.click();

	}

	public void getListProfile()
	{
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zoho.salesiq:id/textview")));
		List <MobileElement> eleme = driver.findElements(By.id("com.zoho.salesiq:id/textview"));
		String val = eleme.get(2).getText();
		
	}
}
