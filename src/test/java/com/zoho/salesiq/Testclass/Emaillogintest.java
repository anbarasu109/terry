//$Id$
package com.zoho.salesiq.Testclass;


import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.zoho.salesiq.pageclass.BaseSetup;
import com.zoho.salesiq.pageclass.BaseSetupDevice2;
import com.zoho.salesiq.pageclass.BurgerMenuNavigations;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.CommonActionMobileDeviceTwo;
import com.zoho.salesiq.pageclass.Emaillogin;
import com.zoho.salesiq.pageclass.VisitorOnlinePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Emaillogintest {

	private CommonActionMobile actions;
	BurgerMenuNavigations navi ;
	Emaillogin emaillogin ;
	Emaillogin emailloginDeviceTwo ;
	VisitorOnlinePage visitorOnlinePage;
	BaseSetup base;
	DeviceTwoTestCase devicetwoTestCase;
	Properties testDataProp;
	AndroidDriver driver;
	AndroidDriver driver1;
	private CommonActionMobileDeviceTwo actions1;
	int deviceNumber;
	String useCase;

public void emaillogintes(int val,String useCaseVal)
{
	deviceNumber=val;
	useCase=useCaseVal;
	}
	
	

public void emailLoginFlow() throws Exception

{
	String filepath = filePath();
		File file = new File(filepath + "EmailLogin.properties");
	
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			
		}
		finally {
		    if (fileInput!=null) {
		    	fileInput.close();
		    }
		}
		
		
		

		Set<String> keys = prop.stringPropertyNames();
		TreeSet<String> sortedSet = new TreeSet<String>(keys);
		// Collections.sort(List<keys>);
		for (String property : sortedSet) {

			String value = prop.getProperty(property);

			
			String testcase = value;
			System.out.println("Automation Case"+property+"="+testcase);
			// String testcase = property;

			System.out.println(testcase);
			switch (testcase) {
			case "Device1 User Login":
				
				loginUser(testcase);
				
// 				System.out.println("Before login");
				
				//loginUser(testcase);
		
				break;
			case "Device2 User Login":
				loginUserTwo(testcase);
			
				break;
			default:

			break;


			}
		}

	}


public String getPropertiesValue(String value)
{
	File testData=null;
	
	FileInputStream testDataFile = null;
	try {
		testData = new File(testDataPath() + "SalesiqTestData.properties");
		testDataFile = new FileInputStream(testData);
	} catch (FileNotFoundException e) {
		
	}
	testDataProp = new Properties();
	try {
		testDataProp.load(testDataFile);
	} catch (IOException e) {
		
	}
	finally {
	    if (testDataFile!=null) {
	    	try {
				testDataFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	return testDataProp.getProperty(value);

	}


public void loginUser(String testcase)
{
	if(emaillogin==null)
	{
		System.out.println("email login object is null");
	}
	driver=BaseSetup.getDriver();
	driver1=BaseSetupDevice2.getDriver();
	actions=new CommonActionMobile(driver);
	emaillogin=new Emaillogin(driver);
	PageFactory.initElements(new AppiumFieldDecorator(driver),emaillogin);
	
	
	
	
	emaillogin.loginButton(testcase);
	actions.waitTime(2);
	emaillogin.enterEmail(getPropertiesValue("User1Email"),testcase);
	emaillogin.enterPassword(getPropertiesValue("User1Password"),testcase);
	actions.hideKeyboard(testcase);
	emaillogin.loginUser(testcase);
	actions.waitTime(5);
	emaillogin.clickNotInterested(testcase);
	actions.killApplication(testcase);
	actions.lauchApplicationAfterKill(testcase);

	}public void loginUserThree(String testcase)
{
	emaillogin.loginButton(testcase);
	actions.waitTime(2);
	emaillogin.enterEmail(getPropertiesValue("User2Email"),testcase);
	emaillogin.enterPassword(getPropertiesValue("User2Password"),testcase);
	actions.hideKeyboard(testcase);
	emaillogin.loginUser(testcase);
	actions.waitTime(5);
	emaillogin.clickNotInterested(testcase);

	}
	
	
	
	public void loginUserTwo(String testcase)
	{
		driver=BaseSetup.getDriver();
		driver1=BaseSetupDevice2.getDriver();
		emailloginDeviceTwo=new Emaillogin(driver1);
		PageFactory.initElements(new AppiumFieldDecorator(driver1),emailloginDeviceTwo);
		actions1=new CommonActionMobileDeviceTwo(driver1);
		
		emailloginDeviceTwo.loginButton(testcase);
		actions1.waitTime(2);
		emailloginDeviceTwo.enterEmail(getPropertiesValue("User2Email"),testcase);
		emailloginDeviceTwo.enterPassword(getPropertiesValue("User2Password"),testcase);
		actions1.hideKeyboard();
		emailloginDeviceTwo.loginUser(testcase);
		actions1.waitTime(5);
		emailloginDeviceTwo.clickNotInterested(testcase);
		actions1.killApplication(testcase);
		actions1.lauchApplicationAfterKill(testcase);
		
	}
	
	
	public static String filePath() {
		URL location = Emaillogintest.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		return fileloc;

	}
	public static String testDataPath() {
		URL location = Emaillogintest.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/AutomationTestData/");
		return fileloc;

	}
}
