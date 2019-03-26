//$Id$
package com.zoho.salesiq.pageclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.VoiceStatus;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
// org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.http.util.VersionInfo;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Dimension;


import freemarker.core.ReturnInstruction.Return;

import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import com.zoho.salesiq.iOS.Pageclass.EmailloginiOS;
import com.zoho.salesiq.pageclass.BaseSetup;
import com.zoho.salesiq.pageclass.BaseSetupWeb;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import java.net.HttpURLConnection;
import org.json.JSONObject;

public class CommonActionMobile {
	private static Log log = LogFactory.getLog(CommonActionMobile.class);
	private static String currentModule="";
	private static HttpURLConnection con;
	public static ExtentTest etest;
	public static ExtentReports reo;
	public static TouchAction action;
	public static boolean skipNotificationStatus;
	public static boolean batteryOptimisationPopup;
	private static String currentModuleClick="";


	AndroidDriver driver=null;
	public CommonActionMobile(AndroidDriver driver) {
		System.out.println("start common constructor");
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		action = new TouchAction(driver);
		System.out.println("end common constructor");
	}

	Extentreportclass extentreportclass = new Extentreportclass();

	@AndroidFindBy(accessibility = "Zoho SalesIQ")
	MobileElement salesiq;
	
	@AndroidFindBy(id = "android:id/button1")
	MobileElement selectDate;

	@AndroidFindBy(id = "android:id/button3")
	MobileElement disAbleBatteryOptimizationPopup;

	@AndroidFindBy(id ="com.zoho.salesiq:id/dialog_skip_view")
	MobileElement skipNotificationSettingPopup;

	@AndroidFindBy(id ="com.zoho.salesiq:id/dialog_settings_view")
	MobileElement navigateToSettingsPage;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/ringbutton")
	List<MobileElement> ringbutton;




	public void pressEnter(String module) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		extentreportclass.mobilepassTest(module, "click on enter after value entered in field");
	}
	public String convertImageFileToBase64(String fileName)
	{
		  String encodedfile="";
		try
		{
		File screenshotLocationB = new File(ioconFilePath()+fileName+".png");
		
		FileInputStream fileInputStreamReader = new FileInputStream(screenshotLocationB);
        byte[] bytes = new byte[(int)screenshotLocationB.length()];
        fileInputStreamReader.read(bytes);
        waitTime(1);
        encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
		}
		catch(Exception e)
		{
			
		}
		return encodedfile;
		
	}

	public void backPress(String module, String testCaseName) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		if(currentModule.isEmpty()||currentModule!=module)
		{
		extentreportclass.mobilepassTest(module, testCaseName);
		currentModule=module;
	}
		
	}
	
	public void navigateToHomePage(String module)
	{
		int i=0;
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		while(1==1)
		{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			if(ringbutton.size()==0)
			{
			backPress(module, "navigate to home page");
			i++;
			if(i>8)
			{
			lauchApplicationAfterKill(module);	
			extentreportclass.mobilepassTest(module,"launch application due to app killed");
			break;
			}

			}
		else 
			{break;}
		}
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
	public void pushFileForFileSharing(String file)
	{
		try
		{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		File img = new File(ioconFilePath()+"screen.png");

		driver.pushFile("/sdcard/DCIM/Camera",img);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void clickBasedonCoordinate(int xValue,int yValue)
	{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		//action.press(PointOption.point(xValue, yValue)).release().perform();
		action.press(PointOption.point(xValue,yValue)).release().perform();
		
		}
	
	
	public void clickBasedOnPoint(Point point)
	{
		try
		{
			
			action.tap(PointOption.point(point)).perform();
			
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void flashElement(MobileElement el)
	{
		HashMap<String, Object> scriptArgs = new HashMap<String, Object>();
		scriptArgs.put("element", el.getId());
		scriptArgs.put("durationMillis", 50); // how long should each flash take?
		scriptArgs.put("repeatCount", 20); // how many times should we flash?

		driver.executeScript("mobile: flashElement", scriptArgs);
	}

	public void homePress() {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
	}

	public void longPress(MobileElement elem) {
		try
		{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		(new TouchAction(driver)).press(ElementOption.element(elem))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).release().perform();
		}
		catch(Exception e)
		{
			
		}

	}
	
	public void clearTextBox(MobileElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		element.clear();
		}
		catch(Exception e)
		{
			
		}
	}

	public void swipeOption(int sourcex, int sourcey, int destx, int desty) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		action.press(PointOption.point(sourcex, sourcey))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(destx, desty))
				.release().perform();
	}
//	public void swipeOption1(int sourcex, int sourcey, int destx, int desty) {
//		driver1=setup.getDriver1();
//		(new TouchAction(driver1)).press(PointOption.point(sourcex, sourcey))
//		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(destx, desty))
//		.release().perform();
//	}

public int getDeviceXValue()
	{

		int deviceWidthOne=0;

		try{
		Dimension dim = driver.manage().window().getSize();
		deviceWidthOne = dim.getWidth();
	}
	catch(Exception e)
	{


	}

	return deviceWidthOne;
	}


	public void getDeviceVersion()
	{
		try{
		String value = driver.getSessionId().toString();
		//int osVersion = Integer.parseInt("value");
		System.out.println("current device session id"+value);

		System.out.println("Appium URL"+BaseSetup.appiumURL);
		 driver.startRecordingScreen();
		  Thread.sleep(10000);
        String result = driver.stopRecordingScreen();
        System.out.println(result);
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }

	}

public int getDeviceYValue()
	{

		int deviceHeightOne=0;

		try{
		Dimension dim = driver.manage().window().getSize();
		deviceHeightOne = dim.getHeight();
	}
	catch(Exception e)
	{


	}

	return deviceHeightOne;
	}

	public void swipeElementLocation(MobileElement soruceElement,MobileElement destElement) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		(new TouchAction(driver)).press(ElementOption.element(soruceElement))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(ElementOption.element(destElement))
		.release().perform();
	}

	public void burgerSwipe() {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		action.press(PointOption.point(0,900))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(900, 900))
				.release().perform();

	}

	public void clickAction(MobileElement elem, String module, String testCaseName) {
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(elem)).click();
			//elem.click();

			extentreportclass.mobilepassTest(module, testCaseName);
		

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, testCaseName);

		}

		extentreportclass.closeExtendedReport();

	}
	

	public void doubleClickAction(MobileElement elem, String module, String testCaseName) {
		Actions action = new Actions(driver);
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(elem));
			
			action.moveToElement(elem).doubleClick().perform();
			
			extentreportclass.mobilepassTest(module, testCaseName);

		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, testCaseName);

		}

		extentreportclass.closeExtendedReport();

	}

	public void actionEnter(MobileElement elem, String value, String module, String testCaseName) {
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(elem));
			elem.sendKeys(value);
			extentreportclass.mobilepassTest(module, testCaseName);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, testCaseName);
		}

	}

	public void openPushNotification() {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		driver.openNotifications();
	}

	public void killAndOpen() throws InterruptedException {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		driver.closeApp();
		driver.launchApp();

		waitTime(2);
	}
	
	public void killApplication(String module)
	{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		driver.closeApp();
	}
	public void openApplication()
	{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		driver.launchApp();
	}

	public void minAndMax(String module, String testCaseName) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();

		driver.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
		clickAction(salesiq, module, testCaseName);

	}
	
	
	public void minimizeApplication(String module, String testCaseName)
	{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
//		driver.pressKeyCode(AndroidKeyCode.HOME);
		driver.runAppInBackground(Duration.ofSeconds(-1));
		
		
	}
	public void hideKeyboard(String module)
	{
		try{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		driver.hideKeyboard();
	}
	catch(Exception e)
	{

	}
		
	}
	public void openApplication(String module, String testCaseName)
	{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
		clickAction(salesiq, module, testCaseName);
	}
	public void lauchApplicationAfterKill(String module)
	{
		try
		{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		driver.startActivity(new Activity("com.zoho.salesiq",".MainActivity"));
		waitTime(2);
		 if(!batteryOptimisationPopup)
		 {
	if(disAbleBatteryOptimizationPopup.isDisplayed())
		{
		clickAction(disAbleBatteryOptimizationPopup,"Home Page","Check Notification settings popup shown");
		batteryOptimisationPopup=true;
	}

}

	}
	catch(Exception e){

	}
		
	}
	
	
	public boolean checkImagePresent(String imageFileName)
	{
		try
		{
		MobileElement element = (MobileElement) driver.findElementByImage(convertImageFileToBase64(imageFileName));
		if(element.isDisplayed())
		{
			
		return true;
		
		}
		else
		{
		return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	
	public void checkvisitorCount(int headerText, WebElement elm, String testCaseName) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		try {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElements(elm));
		if (elm.getText() != null && elm.isDisplayed()) {
			int userCount = Integer.parseInt(elm.getText());

			if (userCount == headerText) {
				extentreportclass.mobilepassTest("check Visitorcount", testCaseName);
			} else {
				extentreportclass.mobilefailTest(driver,"check Visitorcount", testCaseName);
			}
		} else
		{
			extentreportclass.mobilefailTest(driver,"check Visitorcount", testCaseName);
		}
		}
		catch(Exception e)
		{
			
		}
	}

	public boolean iselemetFound(MobileElement elm) {
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(elm));
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public String getElementText(MobileElement elm) {
		String getValue = "";
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfAllElements(elm));
			getValue = elm.getText();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception

		}
		return getValue;

	}

	public void checkText(String expectedValue, MobileElement elm, String module, String testCaseName)

	{
		String actualValue="";
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfAllElements(elm));
				if (elm.getText() != null) {
					actualValue = elm.getText().trim();
					if (actualValue.equalsIgnoreCase(expectedValue)) {
						
						extentreportclass.mobilepassTest(module, testCaseName+" Actual Text Value"+actualValue+"Expected Value :"+expectedValue);

					} else {
						
						extentreportclass.mobilefailTest(driver,module, testCaseName+" Actual Text Value"+actualValue+"Expected Value :"+expectedValue);
					}
				} else
				{
					extentreportclass.mobilefailTest(driver,module, testCaseName+" Actual Text Value"+actualValue+"Expected Value :"+expectedValue);
				}


		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, testCaseName+" Actual Text Value"+actualValue+"Expected Value :"+expectedValue);
		}

	}

	public boolean checkIntegerValue(String value) {
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			int num = Integer.parseInt(value);
			
			return true;

		} catch (NumberFormatException e) {
		
			return false;
		}

	}

	public boolean elemetListFound(List<MobileElement> elm) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		
		if (elm.size() > 0) {
			
			return true;
		} else
		{
			return false;
		}

	}

	public String[] getListofValue(List<MobileElement> elm) {
		String[] ret = new String[100];
		try
		{
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		int i = 0;
		if (elemetListFound(elm)) {
			for (MobileElement element : elm) {

				ret[i] = element.getText();
				
				i++;
			}
		

		}
	}
	catch(Exception e)
	{

	}
		return ret;
	}

	

	public void checkTextinList(List<MobileElement> elem, String expectedValue, String module, String testCase) {
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			waitTime(1);
			
			boolean check = false;
			String actualValue[] = getListofValue(elem);
			for (String str : actualValue) {
				if (str.trim().contains(expectedValue)) {
					check = true;
					break;
				}
			}
			if (check) {
				extentreportclass.mobilepassTest(module, testCase);
			}
			else
			{
				
				extentreportclass.mobilefailTest(driver,module, testCase);
			}
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, testCase);

		}

	}























	
	public boolean checkTextinListBoolean(List<MobileElement> elem, String expectedValue, String module, String testCase) {
		boolean check = false;
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			
			waitTime(1);
		

			
			String actualValue[] = getListofValue(elem);
			for (String str : actualValue) {
				if (str.trim().contains(expectedValue)) {
					check = true;
					
					extentreportclass.mobilepassTest(module, testCase);
					break;
				}
			}
			if (!check) {
				extentreportclass.mobilefailTest(driver,module, testCase);
				check=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, testCase);
			check=false;

		}
		return check;

	}


	public int getCount(List<MobileElement> elem, int index) {
		int finalCount;
		String count = "";
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			
		
		count = elem.get(index).getText();
		}
		catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		if (!count.isEmpty()) {
			finalCount = Integer.parseInt(count);
			return finalCount;
		} else {
			finalCount = 0;

			return finalCount;
		}

	}

	public void compareIntegerValue(int actual, int expected, String testCaseName) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		if (actual >= 0 && expected >= 0) {
			if (actual != expected) {
				extentreportclass.mobilefailTest(driver,"compare integer", testCaseName);
			} else {
				extentreportclass.mobilepassTest("compare integer", testCaseName);
			}
		} else {
			extentreportclass.mobilefailTest(driver,"compare integer", testCaseName);
		}
	}

	public boolean isPageOpened(MobileElement elem, String module, String testCaseName) {
		boolean isopened=false;
try
{
	Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		if (iselemetFound(elem)) {
			extentreportclass.mobilepassTest(module, testCaseName);
			isopened = true;
		} else {
			extentreportclass.mobilefailTest(driver,module, testCaseName);
			isopened = false;
		}
}
catch(Exception e)
{
	isopened = false;
	}
		return isopened;
	}


	public boolean isPageOpen(MobileElement elem) {
		boolean isopened;
		try
		{
		
		if (iselemetFound(elem)) {
			isopened = true;
		} else {
			isopened = false;
		}
	}
	catch(Exception e)
	{
isopened = false;

	}
		return isopened;
	}
	

	public void compareText(String actualText, String expectedText, String module, String testCaseName) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();

		if (!actualText.isEmpty() && actualText.equalsIgnoreCase(expectedText)) {
			extentreportclass.mobilepassTest(module, testCaseName+"Actual Text:"+actualText+"Expected Text:"+expectedText);
		} else {
			extentreportclass.mobilefailTest(driver,module, testCaseName+"Actual Text:"+actualText+"Expected Text:"+expectedText);
		}

	}
	public void compareTextContainsText(String actualText, String expectedText, String module, String testCaseName) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		
		
		if (!actualText.isEmpty() && actualText.contains(expectedText)) {
			extentreportclass.mobilepassTest(module, testCaseName);
		} else {
			extentreportclass.mobilefailTest(driver,module, testCaseName);
		}
		
	}

	public void checkAttributeValue(MobileElement elem, String attributeName, String expectedValue, String module,
			String testCaseName) {
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();

			String value = elem.getAttribute(attributeName);
			if (!value.isEmpty() && value.equalsIgnoreCase(expectedValue)) {

				extentreportclass.mobilepassTest(module, testCaseName);
			} else {
				extentreportclass.mobilefailTest(driver,module, testCaseName);
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, testCaseName);
		}

	}

	public void departmentCheckinProfile(List<MobileElement> elem, String expectedvalue, String module,
			String testCase) {
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			String actual="";
			
			
			actual = elem.get(1).getText();
			if (!actual.isEmpty() && actual.contains(expectedvalue)) {
				extentreportclass.mobilepassTest(module, testCase);
			} else {
				extentreportclass.mobilefailTest(driver,module, testCase);
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, testCase);
		}
	}
	public void textContainsText(MobileElement elem, String expectedvalue, String module,String testCase) {
		try {
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
			String actual="";
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfAllElements(elem));
			actual = elem.getText().trim();
			if (actual.contains(expectedvalue)||actual.equalsIgnoreCase(expectedvalue)) {
				extentreportclass.mobilepassTest(module, testCase+" actual:"+actual+"Expected:"+expectedvalue);
			} else {
				extentreportclass.mobilefailTest(driver,module, testCase+" actual:"+actual+"Expected:"+expectedvalue);
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, testCase);
		}
	}

	public void checkElementfoundCase(MobileElement elem, String module, String testCase) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();

		if (iselemetFound(elem)) {
			extentreportclass.mobilepassTest(module, testCase);
		} else {
			extentreportclass.mobilefailTest(driver,module, testCase);
		}

	}

	public int getListCount(List<MobileElement> element) {
		int countValue = 0;
		try {
			
			countValue = element.size();
			return countValue;

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return countValue;
		}

	}

	public void waitTime(int sec) {
		try {
			

			System.out.println("Waiting for element to be displayed"+sec);
			Thread.sleep(sec * 1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String randomStringGeneration(String preTextOfRandom) {
		
		String randomString = RandomStringUtils.randomAlphabetic(10);
		return preTextOfRandom + randomString;

	}
	public String randomEmail(String preTextOfRandom) {
		
		String randomString = RandomStringUtils.randomAlphabetic(10);
		return randomString+preTextOfRandom; 
		
	}

	public void checklistedTextTwice(String textvalue, List<MobileElement> element, String module, String testCase) {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();

		int i = 0;
		String textlist[] = getListofValue(element);
		for (String indValue : textlist) {
			if (indValue.equalsIgnoreCase(textvalue)) {
				i++;
				if (i > 1) {

					extentreportclass.mobilefailTest(driver,module, testCase);
					break;

				}
			}
		}

		if (i < 2) {
			extentreportclass.mobilepassTest(module, testCase);
		}

	}

	public void selectBasedonTextInList(List<MobileElement> element, String value, String module, String testCaseName) {
		try {
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();

		boolean status=false;
		String elementValue = "";
		if (!value.isEmpty()) {
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfAllElements(element.get(0)));
			for (MobileElement elem : element) {
				elementValue = elem.getText();
				
				if (elementValue.startsWith(value)) {
					clickAction(elem, module, testCaseName);
					status =true;
					break;
					
				}
			}
		}
		if(!status)
		{
			extentreportclass.mobilefailTest(driver,module, testCaseName);
		}
		else
		{
			extentreportclass.mobilepassTest(module, testCaseName);

		}
		}
		catch(Exception e)
		{
			
			
		}

	}
	public String getSystemPublicIPAddress() throws IOException
	{
		 String ipAddress ="";
       String url = "https://api.ipify.org?format=json";

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            String response= content.toString();
             JSONObject myResponse = new JSONObject(response.toString());
           	ipAddress = (String) myResponse.getString("ip");

            System.out.println("ip address by get request:"+ipAddress);

        }
        catch (Exception e )
        {

        } 
        finally {
            
            con.disconnect();
        }
        return ipAddress;
		
	}
	public String getSystemPublicIPAddressTest() throws IOException
	{
		
        BufferedReader in = null;
        try {
        	URL whatismyip = new URL("http://checkip.amazonaws.com");
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
           
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
	}
	
	public String getCurrentTime()
	{
	
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");  
		 LocalDateTime now = LocalDateTime.now(); 
		return dtf.format(now);
		
	}

	public void checkElementColor(MobileElement elem,String useCase,String testCase,int rValue,int gValue,int bValue)
	{
		try{
		org.openqa.selenium.Point point = elem.getCenter();
		int centerx = point.getX();
		int centerY = point.getY();
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 BufferedImage image = ImageIO.read(scrFile);
		  // Getting pixel color by position x and y 
		  int clr=  image.getRGB(centerx,centerY); 
		  int  red   = (clr & 0x00ff0000) >> 16;
		  int  green = (clr & 0x0000ff00) >> 8;
		  int  blue  =  clr & 0x000000ff;
		  
		  if(red==rValue&&green==gValue&&blue==bValue)
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
			extentreportclass.mobilefailTest(driver,useCase, testCase);
		}

	}


	public void checkImageIcon()
	{










	}




























	
	public void checkTextShouldNotListed(List<MobileElement> elem,String value,String module,String testCase)
	{
		try
		{
			Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		boolean check = true;
		String listValue[]=getListofValue(elem);
		for(String inValue:listValue)
		{
			if(inValue.equalsIgnoreCase(value))
			{
				extentreportclass.mobilefailTest(driver,module, testCase);
				check=false;
				break;
				
			}

		}
		if(check) {
			extentreportclass.mobilepassTest(module, testCase);
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilepassTest(module, testCase);

	}
		
	}
	
	public String selectDatePicker()
	{
		
		SimpleDateFormat dtf = new SimpleDateFormat("dd MMMM yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		return(dtf.format(now).toString()); 
		
		
	}
	

	public String getCurrentMinute()
	{
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm");  
		LocalDateTime now = LocalDateTime.now(); 
		return dtf.format(now);
		
	}
	
	public void selectPotentialEndDate(String module,String testCaseName)
	{
		
		clickAction(selectDate, module, testCaseName);
		
	}
	
	public void checkPotentialDate(MobileElement element,String module,String testCaseName)
	{
		try
		{
			
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		String expectedValue=dtf.format(now).toString();
		checkText(expectedValue,element, module, testCaseName);
	}
	catch(Exception e)
	{

	}
		
	}
	public String splitStringValue(String value, String expression, int index)
	{
		

		String listValue[]=value.split(expression);
		
		return listValue[index];
	}
	public long checkTimeDifference()
	{
		
		Instant end = Instant.now();
		
		System.out.println("Current time"+end.toString());
		System.out.println("Site accessed time"+BaseSetupWeb.start.toString());
		
		Duration timeElapsed = Duration.between(BaseSetupWeb.start, end);
// // 		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
		long secs= timeElapsed.getSeconds();
		return secs;
	}
	public long checkTimeDifferenceMinute()
	{
		
		Instant end = Instant.now();
		
		System.out.println("Current time"+end.toString());
		System.out.println("Site accessed time"+BaseSetupWeb.start.toString());
		
		Duration timeElapsed = Duration.between(BaseSetupWeb.start, end);
// // 		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
		long minutes= timeElapsed.toMinutes();
		return minutes;
	}
	public String getPageSourceValue(String parentClassName,int parentIndex,String childClassName, int childIndex)
	{
		
		waitTime(2);
		String attrValue="";
		try
		{
		String xmlRecords=driver.getPageSource();
		InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(xmlRecords));
	    
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    
	    Document doc = db.parse(is);
	    NodeList nodes = doc.getElementsByTagName(parentClassName);
// 	    System.out.println("----------------------------------------------------------------Node Length");
// 	    System.out.println("Nodelist length"+nodes.getLength());

	     Element element = (Element) nodes.item(parentIndex);
	     if(element.hasChildNodes())
	     {
	     NodeList childNodes= element.getElementsByTagName(childClassName);
	     
	    	 Element element1 = (Element) childNodes.item(childIndex);
	    	 NamedNodeMap attributes=element1.getAttributes();
	    	 for (int i = 0; i < attributes.getLength(); i++) {
	    		             Attr attr = (Attr) attributes.item(i);
	    		             String attrName = attr.getNodeName();
	    		             if(attrName.equalsIgnoreCase("text"))
	    		             {
	    		            	 attrValue = attr.getNodeValue();
	    		            	 log.info("Return string value based on page Source"+attrValue);
	    		            	 break;
	    		            	 
	    		             }
	    		             
	    		                           
	    	 }
// 	    	 System.out.println("----------------------------------------------------------------Attribute value");
// 	    	 System.out.println("Page source Value"+attrValue); 
	     }
	     else
	     {
	    	attrValue="";
	     }
	    
		}
		catch(Exception e)
		{
			attrValue="";
			log.info("Page source method", e);
		}
	     return attrValue;
	}
	public String getPageSourceCoOrdinateValue(String parentClassName,int parentIndex,String childClassName, int childIndex)
	{
		
		int xValue;
		int yValue;
		waitTime(2);
		String CoOrdinates="";
		String finalCoOrdinates="";
		try
		{
		String xmlRecords=driver.getPageSource();
		InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(xmlRecords));
	    
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    
	    Document doc = db.parse(is);
	    NodeList nodes = doc.getElementsByTagName(parentClassName);
// 	    System.out.println("----------------------------------------------------------------Node Length");
// 	    System.out.println("Nodelist length"+nodes.getLength());

	     Element element = (Element) nodes.item(parentIndex);
	     if(element.hasChildNodes())
	     {
	     NodeList childNodes= element.getElementsByTagName(childClassName);
	     
	    	 Element element1 = (Element) childNodes.item(childIndex);
	    	 NamedNodeMap attributes=element1.getAttributes();
	    	 for (int i = 0; i < attributes.getLength(); i++) {
	    		             Attr attr = (Attr) attributes.item(i);
	    		             String attrName = attr.getNodeName();
	    		             if(attrName.equalsIgnoreCase("bounds"))
	    		             {
	    		            	 CoOrdinates = attr.getNodeValue();
	    		            	 break;
	    		             }
	    		             
	    		                           
	    	 }
// 	    	 System.out.println("----------------------------------------------------------------Attribute value");
// 	    	 System.out.println("Page source Value"+CoOrdinates); 
	    	 String CoOrdinates1 = CoOrdinates.replace("][",",").replace("]","").replace("[","");
	    	 String str1[]=CoOrdinates1.split(",");
	    	 
	    	 int x1Value=Integer.parseInt(str1[1]);
	    	 int x2Value=Integer.parseInt(str1[3]);
	    	 int y1Value=Integer.parseInt(str1[2]);
	    	 int y2Value=Integer.parseInt(str1[4]);
	    	 
	    	 xValue = (x1Value+x2Value)/2;
	    	 yValue = (y1Value+y2Value)/2;
	    	 
	    	
	    	 
	     }
	     else
	     {
	    	 CoOrdinates="";
// 	    	System.out.println("Page source Value"+CoOrdinates);
	     }
	    
		}
		catch(Exception e)
		{
			CoOrdinates="";
		}
	     return CoOrdinates;
	}

	public void getCallingClassName()
	{

		try
		{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
	}
		catch(Exception e)

		{
		e.printStackTrace();
		}
		
	}
	
	public static String ioconFilePath() {
		URL location = CommonActionMobile.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/iconImages/");

		return fileloc;
	}
	
	
	

}
