//$Id$
package com.zoho.salesiq.pageclass;

import org.openqa.selenium.Dimension;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.IOFileFilter;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.aventstack.extentreports.ExtentReports;

import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import com.zoho.salesiq.pageclass.BaseSetupWeb;
import com.zoho.salesiq.pageclass.BaseSetupDevice2;

public class BaseSetup {
	public static AndroidDriver driver;
	private DesiredCapabilities capabilities;
	public static int deviceWidthOne;
	public static int deviceHeightOne;
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

	public void initdriver() throws Exception {
		try {
		
		platform = System.getProperty("Platform");
		setupWeb = new BaseSetupWeb();
		baseSetup2 = new BaseSetupDevice2();
		if (platform.equalsIgnoreCase("ANDROID")) {

			// Access Android device2

			androidDevice1("Intstallation", "App installation");
			baseSetup2.androidDevice2();

			setupWeb.visitorAccessWeb("web start");
			System.out.println("ceghcu");

//			androidDevice2();

			// Access webSite

			// extentreportclass=new Extentreportclass(driver);
		} else {
			File androidApp = new File("");
			final DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM, "iOS");
			capabilities.setCapability("fullReset", true);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.1.2");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Ipad 4");
			capabilities.setCapability(MobileCapabilityType.APP, androidApp.getAbsolutePath());
			// capabilities.setCapability("appActivity", ".AppLinkingActivity");
			capabilities.setCapability("appPackage", "fr.citygoo.citygoo");
			// capabilities.setCapability("automationName","UiAutomator2");
			// driver = new IOSDriver<MobileElement>(new
			// URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			clearscreeShotDirectory();

		}
		}
		catch(Exception e)
		{
			System.out.println("________________________________________Installation issue in Android_______________________________________");
		}

	}

	public void androidDevice1(String module, String description) throws MalformedURLException, InterruptedException {
		// android device push
		
		File appiumPath=null;
		File androidApp = new File("apkFile/Salesiq.apk");

		capabilities = new DesiredCapabilities();
		capabilities.setCapability("avd", "emulator-5556");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("fullReset", true);
//			capabilities.setCapability("noReset",true);
		capabilities.setCapability("newCommandTimeout", 10800);
		capabilities.setCapability("platformVersion",androidOSVersion);
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("app", androidApp.getAbsolutePath());
		capabilities.setCapability("appActivity", ".MainActivity");
		capabilities.setCapability("appPackage", "com.zoho.salesiq");
		capabilities.setCapability("systemPort", "7100");
		//capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("--session-override", "true");

		// capabilities.setCapability("automationName", "UiAutomator1");
		
		
		String osValue = System.getProperty("os.name").toLowerCase();
		
		if(osValue.indexOf("mac") >= 0)
		{
			appiumPath=new File("/usr/local/lib/node_modules/appium/build/lib/main.js");
		}
		else if(osValue.indexOf("nix") >= 0 || osValue.indexOf("nux") >= 0 || osValue.indexOf("aix") > 0 )
		{
			appiumPath=new File("/home/test/.nvm/versions/node/v10.1.0/lib/node_modules/appium/build/lib/main.js");
		}
		else
		{
			appiumPath=new File("/usr/local/lib/node_modules/appium/build/lib/main.js");
		}
		
		AppiumServiceBuilder builder = new AppiumServiceBuilder()
				.withAppiumJS(appiumPath)
				.withLogFile(new File(AppiumLogFilePath() + "appimLog")).withCapabilities(capabilities)
				.withIPAddress("127.0.0.1").usingAnyFreePort().withArgument(GeneralServerFlag.LOG_TIMESTAMP).withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		service = builder.build();
		service.start();
		appiumURL = service.getUrl().toString();
		urlAppium = new URL(appiumURL);

		// driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);
		driver = new AndroidDriver(service, capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		if (driver.getSessionId() != null) {
//			extentreportclass.mobilepassTest(module, description);
//		}
//		else {
//			extentreportclass.mobilefailTest(module, description);
//		}
		Dimension dim = driver.manage().window().getSize();
		deviceWidthOne = dim.getWidth();

		deviceHeightOne = dim.getHeight();
		driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.2);
		driver.setSetting(Setting.FIX_IMAGE_TEMPLATE_SIZE, true);
		

	}

	public void minimizeApplication(String module, String testCaseName) {
		driver.runAppInBackground(Duration.ofSeconds(-1));

	}

	public void androidDevice2(String module, String description) throws MalformedURLException, InterruptedException {
//		String appiumURL1 = "";
//		 File androidApp = new File(apkFilePath()+"Salesiq.apk");
//			capabilities1 = new DesiredCapabilities();
//			capabilities1.setCapability("platformName", "Android");
//			capabilities1.setCapability("fullReset", false);
//			capabilities1.setCapability("noReset",true);
//			capabilities1.setCapability("newCommandTimeout",300);
//			
//			capabilities1.setCapability("platformVersion", "8.1.0");
//			capabilities1.setCapability("deviceName", "emulator-5558");
//			capabilities1.setCapability("app", androidApp.getAbsolutePath());
//			capabilities1.setCapability("appActivity", ".MainActivity");
//			capabilities1.setCapability("appPackage", "com.zoho.salesiq");
//			capabilities1.setCapability("automationName", "UiAutomator2");
////		  AppiumServiceBuilder builder1 = new AppiumServiceBuilder().
////					withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).withLogFile(new File("/Users/anbarasu-7334/eclipse-workspace/Salesiq_Android/LogFile"))
////					.withCapabilities(capabilities).withIPAddress("127.0.0.1").usingAnyFreePort().withArgument(GeneralServerFlag.SESSION_OVERRIDE).withArgument(GeneralServerFlag.LOG_TIMESTAMP);
////	
////		  service1 = builder1.build();
////		  service1.start();
////			appiumURL1=service1.getUrl().toString();
////			
////			urlAppium1=new URL(appiumURL1);
//		driver1 = new AndroidDriver<MobileElement>(new URL("http://localhost:4726/wd/hub"), capabilities1);
//		if (driver1.getSessionId() != null) {
//			extentreportclass.mobilepassTest(module, description);
//		}
//		else {
//			extentreportclass.mobilefailTest(module, description);
//		}

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

	
	public void tearDown() {
		driver.quit();
		service.stop();
//	 service1.stop();
//	 webDriver.close();
		testextent = Extentreportclass.GetExtent();
		testextent.flush();
	}

	public static AndroidDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	public static String apkFilePath() {
		URL location = BaseSetup.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/AppFile/");

		return fileloc;
	}

	public static String AppiumLogFilePath() {
		URL location = BaseSetup.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/logs/");

		return fileloc;
	}
}
