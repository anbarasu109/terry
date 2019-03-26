//$Id$
package com.zoho.salesiq.iOS.Pageclass;

import org.openqa.selenium.Dimension;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import io.appium.java_client.MobileElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import com.zoho.salesiq.pageclass.BaseSetupWeb;
import com.zoho.qa.server.WebdriverQAUtil;
import com.zoho.salesiq.pageclass.BaseSetupDevice2;
import com.zoho.salesiq.pageclass.Extentreportclass;

public class BaseSetupiOS extends BaseSetupWeb {
	
	private static Log log = LogFactory.getLog(BaseSetupiOS.class);
	public static IOSDriver driver;
	public static IOSDriver driver1;
	public static int deviceWidthOne;
	public static int deviceHeightOne;	
	public static int deviceWidthTwo;
	public static int deviceHeightTwo;
	public static String appiumURL = "";

	private AppiumDriverLocalService service;

	public String platform = null;

	public String salesiqURL = "https://salesiqt.blogspot.com/2018/08/blog-post.html";
	public static ExtentReports testextent;
	public String operatorStatus = "Available";
	public static String dynamicOperatorStatus = "";
	private BaseSetupWeb setupWeb;
	private URL urlAppium;
	private URL urlAppium1;
	public static String androidOSVersion="7";
	Extentreportclass extentreportclass;
	BaseSetupDevice2 baseSetup2;

	public void initdriver() {
		try
		{
		platform = WebdriverQAUtil.getOSPlatform();
		setupWeb = new BaseSetupWeb();
		baseSetup2 = new BaseSetupDevice2();
		if (platform.equalsIgnoreCase("iOS")) {

			// Access Android device2
			iOSDevice1("Intstallation", "App installation");
			iOSDeviceTwo("Intstallation", "App installation");
			setupWeb.visitorAccessWeb("web start");
			
		} else {
			
			System.out.println("Else platform condition");
		}
		}
		catch(Exception e)
		{
			System.out.println("Testing ____________________________Installation issue in iOS______________________________"+e.getMessage());
		}
		

	}

	public void iOSDevice1(String module, String description) throws MalformedURLException, InterruptedException {
		// android device push
		
			try
			{
			File iOSApp = new File(apkFilePath()+"ZohoSalesIQ.app");
			final DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("useNewWDA", true);
			capabilities.setCapability("newCommandTimeout", 10800);
			capabilities.setCapability("clearSystemFiles", true);
			capabilities.setCapability("platformVersion", "12.1");
			capabilities.setCapability("bundleId", "com.zoho.salesiq");
			capabilities.setCapability("udid","398AC0A3-5FB1-4206-A9FB-7E792D53BFAC");
			capabilities.setCapability("deviceName", "iPhone 8Plus12");
			capabilities.setCapability("app", iOSApp.getAbsolutePath());
			capabilities.setCapability("automationName", "XCUITest");
			

		AppiumServiceBuilder builder = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withLogFile(new File(AppiumLogFilePath() + "appimLog")).withCapabilities(capabilities)
				.withIPAddress("127.0.0.1").usingAnyFreePort().withArgument(GeneralServerFlag.LOG_TIMESTAMP);

		service = builder.build();
		service.start();
		driver = new IOSDriver(service, capabilities);

		Dimension dim = driver.manage().window().getSize();
		deviceWidthOne = dim.getWidth();
		deviceHeightOne = dim.getHeight();
		System.out.println("devicewidth"+deviceWidthOne);
			}
			catch(Exception e)
			{
				log.info("Exception in iOS device1 iOS driver initialization"+e.getMessage());
			}
	}


	public void iOSDeviceTwo(String module, String description) throws MalformedURLException, InterruptedException {
		try
		{
		File iOSApp = new File(apkFilePath()+"ZohoSalesIQ.app");
		System.out.println("_______________________________File exist_____________________________"+iOSApp.exists());
		final DesiredCapabilities capabilities1 = new DesiredCapabilities();
			capabilities1.setCapability("platformName", "iOS");
			capabilities1.setCapability("wdaLocalPort", "8101");
			capabilities1.setCapability("clearSystemFiles", true);
			capabilities1.setCapability("useNewWDA", true);
			capabilities1.setCapability("newCommandTimeout", 10800);
			capabilities1.setCapability("platformVersion", "11.3");
			capabilities1.setCapability("bundleId", "com.zoho.salesiq");
			capabilities1.setCapability("udid","DEEF8AE2-6E05-4B05-AA28-6EF9CD927886");
			capabilities1.setCapability("deviceName", "iPhone 8 Plus");
			capabilities1.setCapability("app", iOSApp.getAbsolutePath());
			capabilities1.setCapability("automationName", "XCUITest");
			
		AppiumServiceBuilder builder = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withLogFile(new File(AppiumLogFilePath() + "appimLog")).withCapabilities(capabilities1)
				.withIPAddress("127.0.0.1").usingAnyFreePort().withArgument(GeneralServerFlag.LOG_TIMESTAMP);

		service = builder.build();
		service.start();
		driver1 = new IOSDriver(service, capabilities1);

		Dimension dim = driver1.manage().window().getSize();
		deviceWidthTwo = dim.getWidth();
		deviceHeightTwo = dim.getHeight();
		System.out.println("devicewidth"+deviceWidthOne);
	}
	catch(Exception e)
	{
		log.info("Exception in iOS device2 iOS driver initialization"+e.getMessage());
	}

	}

	public static IOSDriver getDriverOne()
	{
		return driver;
	}
	
	public static IOSDriver getDriverTwo()
	{
		return driver1;
	}



	

	public void clearscreeShotDirectory() {
		deleteFiles(new File("/Users/anbarasu-7334/eclipse-workspace/Salesiq_Android/Screenshots"));
	}

	private void deleteFiles(File file) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				deleteFiles(f);
			}
		} else {
			file.delete();
		}
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		service.stop();
		testextent = Extentreportclass.GetExtent();
		testextent.flush();
	}


	public static String apkFilePath() {
		URL location = BaseSetupiOS.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();

		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/AppFile/");
		System.out.println("File Location _____________________"+fileloc);
		return fileloc;
	}

	public static String AppiumLogFilePath() {
		URL location = BaseSetupiOS.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/logs/");

		return fileloc;
	}
}
