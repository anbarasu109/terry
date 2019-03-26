//$Id$
package com.zoho.salesiq.iOS.Testclass;


import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static java.time.Duration.ofSeconds;
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
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import com.zoho.salesiq.iOS.Pageclass.EmailloginiOS;
import com.zoho.salesiq.iOS.Pageclass.BaseSetupiOS;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class EmaillogintestiOS {
	 private static Log log = LogFactory.getLog(EmaillogintestiOS.class);



	
	
	

public void emailLoginFlow() throws Exception

{		

	IOSDriver driver = BaseSetupiOS.getDriverOne();
	EmailloginiOS emailloginiOS=new EmailloginiOS(driver);
	System.out.println("device One capabilities xyz");
	System.out.println(driver.getCapabilities());
	PageFactory.initElements(new AppiumFieldDecorator(driver,ofSeconds(5)),emailloginiOS);
	
	
	IOSDriver driver1 = BaseSetupiOS.getDriverTwo();
	System.out.println("device two capabilities xyz");
	System.out.println(driver1.getCapabilities());
	EmailloginiOS emailloginiOSOne=new EmailloginiOS(driver1);
	PageFactory.initElements(new AppiumFieldDecorator(driver1),emailloginiOSOne);




	String filepath = filePath();

// 		System.out.println(filepath);

		File file = new File(filepath + "EmailLogin.properties");

		// File file = new
		// File("/Users/varun-6182/eclipse-workspace/testing/Testcases/Messaging.conf");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			log.debug("File Not Found Exception in"+Thread.currentThread().getStackTrace());
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			log.debug("IO Exception in"+Thread.currentThread().getStackTrace());
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
// 				System.out.println("Before login");
			Thread.sleep(10000);
				emailloginiOS.signInClick();
		
				break;
			case "Device2 User Login":
 			Thread.sleep(10000);
				emailloginiOSOne.signInClick();
				System.out.println("Value");
			
				break;
			default:

			break;


			}
		}

	}

	public static String filePath() {
		URL location = EmaillogintestiOS.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
// 		System.out.println(fileloc);
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqiOS/");
		return fileloc;

	}
}
