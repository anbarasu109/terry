//$Id$
package com.zoho.salesiq.pageclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class CommonActionWeb extends BaseSetupWeb {
	
	public static ExtentTest etest;
	public static ExtentReports reo;
	
	BaseSetupWeb setupWeb = new BaseSetupWeb();
	//Extentreportclass extentreportclass = new Extentreportclass(driver);
	public CommonActionWeb(WebDriver webDriverw)
	{
		if(webDriverw==null)
		{
			webDriver=setupWeb.getDriver();
			System.out.println("passed null");
		}
		else
		{
		  this.webDriver = webDriverw;
		  System.out.println("return null");
		}
		  PageFactory.initElements(new AppiumFieldDecorator(webDriver), this);
	}
	
	
	
	@AndroidFindBy(accessibility="Zoho SalesIQ")
	@CacheLookup
	WebElement salesiq;
	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public void pressEnter()
	{
	
	}
	public void waitCommand(int secs)
	{
		
		try {
			System.out.println("Waiting for element to be displayed"+secs);
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void backPress(String module,String testCaseName)
	{
		webDriver.navigate().back();

	}
	public void homePress()
	{
		
	}
	public void swipeOption(int sourcex,int sourcey,int destx,int desty)
	{		
		
	}
	public void burgerSwipe()
	{
		
	}
	public void clickAction(WebElement elem,String module,String testCaseName)
	{
		
	
		try
		{
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(elem));		
		elem.click();
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	
		} 
		
	}
	public void actionEnter(WebElement elem,String value,String module,String testCaseName)
	{
		
		try
		{
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		wait.until(ExpectedConditions.visibilityOf(elem));
		elem.sendKeys(value);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	public void clearText(WebElement elem,String module,String testCaseName)
	{
		
		try
		{
		WebDriverWait wait = new WebDriverWait(webDriver, 1000);
		wait.until(ExpectedConditions.visibilityOf(elem));
		elem.clear();
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	public boolean iselemetFound(WebElement elm)
	{
		boolean displayed=false;
		try {
		 displayed = elm.isDisplayed();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			displayed=false;
		}
		return displayed;
	
	}
	
	public String getElementText(WebElement elm)
	{
		String getValue ="";
		try {
			getValue = elm.getText();
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
		return getValue;
	
	}

	public boolean checkIntegerValue(String value)
	{
		try{
			  int num = Integer.parseInt(value);
// 			  System.out.println("pass integer Number");
			  return true;
			 
			} catch (NumberFormatException e) {
// 			  System.out.println("Not a integer Number");
			  return false;
			}
		
	}
	public boolean elemetListFound(List<WebElement> elm)
	{
		if(elm.size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	public String[] getListofValue(List<WebElement> elm)
	{
		boolean status;
		String[] ret = new String[100];
		int i=0;
	if(elemetListFound(elm))
	{
		for(WebElement element : elm)
		{
			ret[i]=element.getText();
			i++;
		}
// 		System.out.println("pass list of value received");
	
	}
	else {
		status =false;
		
// 		System.out.println("fail list of value not received");
	}
	return ret;
	
	}
	
	public void checkTextinList(List<WebElement> elem, String expectedValue,String module,String testCase)
	{
		boolean status;
		try {
			
		boolean check=false;
		String actualValue[]= getListofValue(elem);
		for(String str: actualValue) {
		    if(str.trim().contains(expectedValue))
		    {
		    	check = true;
// 		    	System.out.println(str);
		     
		       break;
		    }
		}
		if(!check)
		{
			status =false;
		}
		}
		catch (NoSuchElementException e) {
			// TODO: handle exception
			
		}
		
				
	
	}
	
	
	
	
	
	
	
	
	public int getCount(List <WebElement> elem, int index)
	{
		int finalCount;
		String count = elem.get(index).getText();
		if(!count.isEmpty())
		{
		 finalCount = Integer.parseInt(count);
		return finalCount;
		}
		else {
			finalCount = 0;
			
		return finalCount;
		}
		
	}
	public void compareIntegerValue(int actual, int expected,String testCaseName)
	{
		boolean status;
		if(actual>=0&&expected>=0)
		{
			if(actual!=expected)
			{
				status=false;
			}
			else
			{
				status=true;
			}
		}
		else {
			status=false;
		}
	}
	public boolean isPageOpened(WebElement elem,String module, String testCaseName)
	{
		boolean isopened;
		
		etest = Extentreportclass.createTest(module, testCaseName);
		if(iselemetFound(elem))
		{
			isopened =true;
		}
		else {
			
			isopened =false;
		}
		return isopened;
	}
	
	public void compareText(String actualText,String expectedText,String module,String testCaseName)
	{
		boolean status;
		etest = Extentreportclass.createTest(module, testCaseName);
		if(!actualText.isEmpty()&&actualText.equalsIgnoreCase(expectedText))
		{
			status=true;
		}
		else {
			status=false;
		}		
		
	}
	
	
	public void checkAttributeValue(WebElement elem,String attributeName,String expectedValue,String module,String testCaseName)
	{
		boolean status;
		try {
		
		etest = Extentreportclass.createTest(module, testCaseName);
		String value = elem.getAttribute(attributeName);
		if(!value.isEmpty()&&value.equalsIgnoreCase(expectedValue))
		{
		
			status =true;
		}
		else {
		status =false;	
		}
	}
	catch (Exception e) {
		// TODO: handle exception
		
	}
	
		
	}
	
	public void departmentCheckinProfile(List<WebElement> elem, String expectedvalue,String module, String testCase)
	{
		boolean status;
		try {
		
		etest = Extentreportclass.createTest(module, testCase);
		
		String actual = elem.get(1).getText();
		if(!actual.isEmpty()&&actual.contains(expectedvalue))
		{
		status =true;
		}
		else {
			status =false;
		}
		}
		catch (NoSuchElementException e) {
			// TODO: handle exception
			
		}
	}
	
	public boolean checkElementClickable(WebElement elem,String module, String testCase)
	{
		return false;
	
	}
	public int getListCount(List<WebElement> element,String module,String testCase)
	{
		int countValue=0;
		
		etest = Extentreportclass.createTest(module, testCase);
		try {
			
			 countValue = element.size();
		return countValue;
		
		}
		catch (NoSuchElementException e) {
			// TODO: handle exception
		return countValue;
		}
		
	}
	
	public void selectBasedonTextInList(List<WebElement> element, String value,String module,String testCaseName)
	{
		String elementValue ="";
		try
		
		{
		if(!value.isEmpty())
		{
		for(WebElement elem:element)
		{
			elementValue=elem.getText();
// 			System.out.println(elementValue);
			if(elementValue.startsWith(value))
					{
				clickAction(elem, module, testCaseName);
				break;
					}
		}
		}
		}
		catch(Exception e)
		{
// 			System.out.println("unable to select");
		}
		
	}
	
	
	
	
	public void performEscKey()
	{

		Actions action = new Actions(webDriver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	
	public String getSystemPublicIPAddress() throws IOException
	{
		
        BufferedReader in = null;
        try {
        	URL whatismyip = new URL("http://checkip.amazonaws.com");
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
//             System.out.println(ip);
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
	public String getCurrentMinute()
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm");  
		LocalDateTime now = LocalDateTime.now(); 
		return dtf.format(now);
		
	}




	
	
	
	
	
	
	

}
