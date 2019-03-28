//$Id$
package com.zoho.salesiq.pageclass;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class CommonActionMobileDeviceTwo {
	private static Log log = LogFactory.getLog(CommonActionMobileDeviceTwo.class);
	public static ExtentTest etest;
	public static ExtentReports reo;
	public static TouchAction action;
	public static boolean skipNotificationStatus;
	public static boolean batteryOptimisationPopup;
	AppiumFieldDecorator appiumFieldDecoratorDeviceTwo;
	AndroidDriver driver1=null;
	
	public CommonActionMobileDeviceTwo(AndroidDriver driver1) {
		this.driver1 = driver1;
		appiumFieldDecoratorDeviceTwo=new AppiumFieldDecorator(driver1);
		PageFactory.initElements(appiumFieldDecoratorDeviceTwo, this);
		action = new TouchAction(driver1);
	}


	@AndroidFindBy(accessibility = "Zoho SalesIQ")
	@CacheLookup
	MobileElement salesiq;
	
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	MobileElement selectDate;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/ringbutton")
	List<MobileElement> ringbutton;

	@AndroidFindBy(id ="com.zoho.salesiq:id/dialog_skip_view")
	MobileElement skipNotificationSettingPopup;

	@AndroidFindBy(id ="com.zoho.salesiq:id/dialog_settings_view")
	MobileElement navigateToSettingsPage;

	@AndroidFindBy(id = "android:id/button3")
	MobileElement disAbleBatteryOptimizationPopup;
	

	@SuppressWarnings("deprecation")
	public void pressEnter() {
		driver1.pressKeyCode(AndroidKeyCode.ENTER);
	}

	public void backPress(String module, String testCaseName) {
		((AndroidDriver) driver1).pressKeyCode(AndroidKeyCode.BACK);
		
	}
	
	public void navigateToHomePage(String module,String testcase)
	{
		int i=0;
		try {
		while(1==1)
		{
			driver1.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			if(ringbutton.size()==0)
			{
			backPress(testcase, "navigate to home page");
			i++;
			if(i>8)
			{
			lauchApplicationAfterKill(module);
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
	
	public void clickBasedonCoordinate(int xValue,int yValue)
	{
		//action.press(PointOption.point(xValue, yValue)).release().perform();
		action.tap(PointOption.point(xValue,yValue)).release().perform();
		}
	public void hideKeyboard()
	{
		try{

		driver1.hideKeyboard();	
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void clickBasedOnPoint(Point point)
	{
		try
		{
			action.press(PointOption.point(point)).release().perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void homePress() {
		((AndroidDriver) driver1).pressKeyCode(AndroidKeyCode.HOME);
	}

	public void longPress(MobileElement elem) {
		WebDriverWait wait = new WebDriverWait(driver1, 20);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		(new TouchAction(driver1)).press(ElementOption.element(elem))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).release().perform();

	}

	public void swipeOption(int sourcex, int sourcey, int destx, int desty) {
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
	public void swipeElementLocation(MobileElement soruceElement,MobileElement destElement) {
		(new TouchAction(driver1)).press(ElementOption.element(soruceElement))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(ElementOption.element(destElement))
		.release().perform();
	}

	public void burgerSwipe() {
		action.press(PointOption.point(0, 900))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(900, 900))
				.release().perform();

	}

	public void clickAction(MobileElement elem, String module, String testCaseName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver1, 20);
			wait.until(ExpectedConditions.elementToBeClickable(elem));

			elem.click();
			

		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			// TODO: handle exception
			
		}

		

	}
	

	public void doubleClickAction(MobileElement elem, String module, String testCaseName) {
		Actions action = new Actions(driver1);
		try {
			WebDriverWait wait = new WebDriverWait(driver1, 20);
			wait.until(ExpectedConditions.elementToBeClickable(elem));
			//(new TouchAction(driver)).press(ElementOption.element(elem)).release().press(ElementOption.element(elem)).release().perform();
		
			(new Actions(driver1)).moveToElement(elem).doubleClick().perform();
		
		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			// TODO: handle exception
			
		}

		

	}

	public void actionEnter(MobileElement elem, String value, String module, String testCaseName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver1, 20);
			wait.until(ExpectedConditions.visibilityOf(elem));
			elem.sendKeys(value);
			
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		
		}

	}

	public void openPushNotification(String module) {
		driver1.openNotifications();
	}

	public void killAndOpen() throws InterruptedException {
		driver1.closeApp();
		driver1.launchApp();

		waitTime(2);
	}
	
	public void killApplication(String module)
	{
		driver1.closeApp();
	}
	public void openApplication()
	{
		driver1.launchApp();
	}

	public void minAndMax(String module, String testCaseName) {

		driver1.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
		clickAction(salesiq, module, testCaseName);

	}
	
	
	public void minimizeApplication(String module, String testCaseName)
	{
		driver1.pressKeyCode(AndroidKeyCode.HOME);
		
	}
	public void openApplication(String module, String testCaseName)
	{
		driver1.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
		clickAction(salesiq, module, testCaseName);
	}
	public void lauchApplicationAfterKill(String module)
	{
		try
		{

		driver1.startActivity(new Activity("com.zoho.salesiq",".MainActivity"));
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
	catch(Exception e)
	{

	}
	}

	
	
	public void checkvisitorCount(int headerText, WebElement elm, String testCaseName) {
		boolean status;
		if (elm.getText() != null && elm.isDisplayed()) {
			int userCount = Integer.parseInt(elm.getText());

			if (userCount == headerText) {
				status=true;
				
			} else {
				status=false;
			}
		} else
		{
			status=false;
			}
	}

	public boolean iselemetFound(MobileElement elm) {
		try {
			driver1.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			boolean displayed = elm.isDisplayed();
			return displayed;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public String getElementText(MobileElement elm) {
		String getValue = "";
		try {
			getValue = elm.getText();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception

		}
		return getValue;

	}
	public void pushFileForFileSharing(String file)
	{
		try
		{
		Extentreportclass.categories=Thread.currentThread().getStackTrace()[2].getClassName();
		File img = new File(ioconFilePath()+"screen.png");

		driver1.pushFile("/sdcard/DCIM/Camera",img);
		}
		catch(Exception e)
		{
			
		}
	}
	public static String ioconFilePath() {
		URL location = CommonActionMobileDeviceTwo.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/iconImages/");

		return fileloc;
	}
	

	public boolean checkText(String expectedValue, MobileElement elm, String module, String testCaseName)

	{
		boolean status=false;
		
		try {
			if (elm.isDisplayed()) {
				if (elm.getText() != null) {
					String actualValue = elm.getText();
					if (actualValue.equalsIgnoreCase(expectedValue)) {
						
						status =true;
					

					} else {
						
						status =false;
					}
				} else
				{
					status =false;
				}
			}

		} catch (Exception e) {
			status =false;
		}
return status;
	}

	public boolean checkIntegerValue(String value) {
		try {
			int num = Integer.parseInt(value);
			
			return true;

		} catch (NumberFormatException e) {
		
			return false;
		}

	}

	public boolean elemetListFound(List<MobileElement> elm) {
		if (elm.size() > 0) {
			return true;
		} else
		{
			return false;
		}

	}

	public String[] getListofValue(List<MobileElement> elm) {
		String[] ret = new String[100];
		int i = 0;
		if (elemetListFound(elm)) {
			for (MobileElement element : elm) {

				ret[i] = element.getText();
				
				i++;
			}
		

		}
		return ret;

	}

	public boolean checkTextinList(List<MobileElement> elem, String expectedValue, String module, String testCase) {
		boolean check = false;	
		try {
			waitTime(1);

			
			String actualValue[] = getListofValue(elem);
			for (String str : actualValue) {
				if (str.trim().equalsIgnoreCase(expectedValue)) {
					check = true;
//					extentreportclass.mobilepassTest(module, testCase);
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
//			extentreportclass.mobilefailTest(module, testCase);
			check = false;
		}
		return check;

	}


	public int getCount(List<MobileElement> elem, int index) {
		int finalCount;
		String count = "";
		try {
		
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
	boolean status;
		if (actual >= 0 && expected >= 0) {
			if (actual != expected) {
//				extentreportclass.mobilefailTest("compare integer", testCaseName);
				status =false;
				
			} else {
//				extentreportclass.mobilepassTest("compare integer", testCaseName);
				status =true;
			}
		} else {
//			extentreportclass.mobilefailTest("compare integer", testCaseName);
			status =false;
		}
	}

	public boolean isPageOpened(MobileElement elem, String module, String testCaseName) {
		boolean isopened=false;
try
{
		if (iselemetFound(elem)) {
//			extentreportclass.mobilepassTest(module, testCaseName);
			isopened = true;
		} else {
//			extentreportclass.mobilefailTest(module, testCaseName);
			isopened = false;
		}
}
catch(Exception e)
{
	}
		return isopened;
	}
	public boolean isPageOpen(MobileElement elem) {
		boolean isopened;
		
		if (iselemetFound(elem)) {
			isopened = true;
		} else {
			isopened = false;
		}
		return isopened;
	}

	public void compareText(String actualText, String expectedText, String module, String testCaseName) {
boolean status;
		if (!actualText.isEmpty() && actualText.equalsIgnoreCase(expectedText)) {
//			extentreportclass.mobilepassTest(module, testCaseName);status =false;
			
			status =true;
		} else {
//			extentreportclass.mobilefailTest(module, testCaseName);
			status =false;
		}

	}

	public void checkAttributeValue(MobileElement elem, String attributeName, String expectedValue, String module,
			String testCaseName) 
	{
	boolean status;
		try {

			String value = elem.getAttribute(attributeName);
			if (!value.isEmpty() && value.equalsIgnoreCase(expectedValue)) {

//				extentreportclass.mobilepassTest(module, testCaseName);
				status =true;
			} else {
//				extentreportclass.mobilefailTest(module, testCaseName);
				status =false;
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
//			extentreportclass.mobilefailTest(module, testCaseName);
			status =false;
		}

	}

	public void departmentCheckinProfile(List<MobileElement> elem, String expectedvalue, String module,
			String testCase) {
		boolean status;
		try {
			String actual="";
			actual = elem.get(1).getText();
			if (!actual.isEmpty() && actual.contains(expectedvalue)) {
//				extentreportclass.mobilepassTest(module, testCase);
				status =true;
				
			} else {
//				extentreportclass.mobilefailTest(module, testCase);
				
				status =false;
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
//			extentreportclass.mobilefailTest(module, testCase);

			status =false;
		}
	}
	public void textContainsText(MobileElement elem, String expectedvalue, String module,String testCase) {
		boolean status;
		try {
			String actual="";
			actual = elem.getText();
			if (!actual.isEmpty() && actual.contains(expectedvalue)) {
//				extentreportclass.mobilepassTest(module, testCase);
				status=true;
			} else {
//				extentreportclass.mobilefailTest(module, testCase);
				status=false;
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
//			extentreportclass.mobilefailTest(module, testCase);
		}
	}

	public void checkElementfoundCase(MobileElement elem, String module, String testCase) {
boolean status;
		if (iselemetFound(elem)) {
//			extentreportclass.mobilepassTest(module, testCase);
			status =true;
			
		} else {
//			extentreportclass.mobilefailTest(module, testCase);
			
			status =false;
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
boolean status;
		int i = 0;
		String textlist[] = getListofValue(element);
		for (String indValue : textlist) {
			if (indValue.equalsIgnoreCase(textvalue)) {
				i++;
				if (i > 1) {
					
status =false;
//					extentreportclass.mobilefailTest(module, testCase);
					break;

				}
			}
		}

		if (i < 2) {
//			extentreportclass.mobilepassTest(module, testCase);
			status = true;
		}

	}

	public void selectBasedonTextInList(List<MobileElement> element, String value, String module, String testCaseName) {
		String elementValue = "";
		if (!value.isEmpty()) {
			for (MobileElement elem : element) {
				elementValue = elem.getText();
				
				if (elementValue.startsWith(value)) {
					clickAction(elem, module, testCaseName);
					break;
				}
			}
		}

	}
	public String getSystemPublicIPAddress() throws IOException
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
	
	public void checkTextShouldNotListed(List<MobileElement> elem,String value,String module,String testCase)
	{
		boolean check = true;
		String listValue[]=getListofValue(elem);
		for(String inValue:listValue)
		{
			if(value.equalsIgnoreCase(value))
			{
//				extentreportclass.mobilefailTest(module, testCase);
				check=false;
				break;
				
			}

		}
//		if(!check) {
////			extentreportclass.mobilepassTest(module, testCase);
//			
//			
//		}
		
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
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		String expectedValue=dtf.format(now).toString();
		checkText(expectedValue,element, module, testCaseName);
		
	}
	
	public String splitStringValue(String value, String expression, int index)
	{
		String listValue[]=value.split(expression);
		
		return listValue[index];
	}
	public long checkTimeDifference()
	{
		Instant end = Instant.now();
//		System.out.print("Access time in commonmobile class"+BaseSetupWeb.start.toString());
		Duration timeElapsed = Duration.between(BaseSetupWeb.start, end);
// 		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
		long secs= timeElapsed.toMillis()/ 1000 % 60;
		return secs;
	}
	public String getPageSourceValue(String parentClassName,int parentIndex,String childClassName, int childIndex)
	{
		waitTime(2);
		String attrValue="";
		try
		{
		String xmlRecords=driver1.getPageSource();
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
		String xmlRecords=driver1.getPageSource();
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
	
 
}
