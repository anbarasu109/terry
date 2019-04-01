//$Id$
package com.zoho.salesiq.pageclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseSetupDevice2 {
	public AppiumDriverLocalService service1;
	public DesiredCapabilities capabilities1;
	public static AndroidDriver driver1;
	
	public void androidDevice2() throws MalformedURLException, InterruptedException
	{try
	{
		File appiumPath=null;
		String appiumURL1 = "";
		File androidApp = new File("apkFile/Salesiq.apk");
			capabilities1 = new DesiredCapabilities();
			capabilities1.setCapability("avd", "emulator-5554");
			capabilities1.setCapability("platformName", "Android");
			capabilities1.setCapability("fullReset", true);
			//capabilities1.setCapability("noReset",true);
			capabilities1.setCapability("newCommandTimeout",10800);
			
			capabilities1.setCapability("platformVersion", "8.1.0");
			capabilities1.setCapability("deviceName", "emulator-5556");
			capabilities1.setCapability("app", androidApp.getAbsolutePath());
			capabilities1.setCapability("appActivity", ".MainActivity");
			capabilities1.setCapability("appPackage", "com.zoho.salesiq");
			capabilities1.setCapability("--session-override", "false");
//			capabilities1.setCapability("automationName", "UiAutomator2");
			
		
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
			
		  AppiumServiceBuilder builder1 = new AppiumServiceBuilder().
					withAppiumJS(appiumPath).withLogFile(new File(AppiumLogFilePath()+"appimLog"))
					.withCapabilities(capabilities1).withIPAddress("127.0.0.1").usingAnyFreePort().withArgument(GeneralServerFlag.LOG_TIMESTAMP);
	
		  service1 = builder1.build();
		  service1.start();

		driver1 = new AndroidDriver(service1,capabilities1);
		driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver1.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.2);
		driver1.setSetting(Setting.FIX_IMAGE_TEMPLATE_SIZE, true);
		
//		if (driver1.getSessionId() != null) {
//			extentreportclass.mobilepassTest(module, description);
//		}
//		else {
//			extentreportclass.mobilefailTest(module, description);
//		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("issue in device two installation");
	}
	
	}
	public static String apkFilePath()
    {
        URL location = BaseSetup.class.getProtectionDomain().getCodeSource().getLocation();
        String fileloc = location.getFile();
        fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar","/webapps/selenium/AppFile/");
       
        return fileloc;
    }
	public static AndroidDriver getDriver() {
		// TODO Auto-generated method stub
		return driver1;
	}
	public static String AppiumLogFilePath()
	{
		URL location = BaseSetup.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar","/logs/");
		
		
		return fileloc;
	}

}
