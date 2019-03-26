//$Id$
package com.zoho.salesiq.pageclass;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import org.apache.http.util.VersionInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.BufferedWriter;		
import java.io.File;		
import java.io.FileWriter;
import org.openqa.selenium.Cookie;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BaseSetupWeb {
public static WebDriver webDriver;
public static DesiredCapabilities capabilities;
public static ChromeOptions options;


public String siteAccessedTime=""; 
public static Instant start;
public Set<Cookie> allCookies;
	
public void webPageAccess(String module,String webpage)
{
	try
	{
	if(webDriver!=null)
	{
		webDriver.get(webpage);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");  
		getCookieValue(module);
		 LocalDateTime now = LocalDateTime.now(); 
		siteAccessedTime=dtf.format(now);
		start = Instant.now();
		
	}
	else
	{
		Logger.getGlobal().info("WebDriver not initiated");
	}
	}

catch(Exception e)
{
	Logger.getGlobal().info("WebDriver not initiated");

}
}


public void closeBrowser(String module)
{
	if(webDriver!=null)
	{
	webDriver.quit();
	}
	else
	{
		Logger.getGlobal().info("WebDriver not initiated to close");
	}
	
	}

public void getBrowserCookie(String module)
{
	allCookies = webDriver.manage().getCookies();
	
	}
public void clearCookies(String module)
{
	try{
	webDriver.manage().deleteAllCookies();
	Thread.sleep(5000);
}
catch(InterruptedException e)
{
	
}

	
	}

public void setBrowserCookie(String module)
{
	 for(Cookie cookie : allCookies) {
		 webDriver.manage().addCookie(cookie);
     }
	}


public void getCookieValue(String module)
{
	File file = new File(testfilePath()+"Cookies.data");							
    try		
    {	  
        // Delete old file if exists
		file.delete();		
        file.createNewFile();			
        FileWriter fileWrite = new FileWriter(file);							
        BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
        // loop for getting the cookie information 		
        	
        // loop for getting the cookie information 		
        for(Cookie ck : webDriver.manage().getCookies())							
        {			
            Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()+";"+ck.getValue()));																									
            Bwrite.newLine();             
        }			
        Bwrite.close();			
        fileWrite.close();	
        
    }
    catch(Exception ex)					
    {		
        ex.printStackTrace();			
    }		
	}
public WebDriver visitorAccessWeb(String module) {

	try{
	
	System.out.println("Entered into visitor web browser create function_______________________________");
	
	
	String osValue = System.getProperty("os.name").toLowerCase();
	
	if(osValue.indexOf("mac") >= 0)
	{
		System.setProperty("webdriver.chrome.driver",testfilePath()+"chromedriver");
	}
	else if(osValue.indexOf("nix") >= 0 || osValue.indexOf("nux") >= 0 || osValue.indexOf("aix") > 0 )
	{
		System.setProperty("webdriver.chrome.driver",linuxPath()+"chromedriver");
	}
	else
	{
		System.setProperty("webdriver.chrome.driver",testfilePath()+"chromedriver");
	}

	
	System.setProperty("webdriver.chrome.logfile", chromdriverLog()+"chromedriver.log");
	System.setProperty("webdriver.chrome.verboseLogging", "true");
	options = new ChromeOptions();
	capabilities = DesiredCapabilities.chrome();
    options.addArguments("use-fake-ui-for-media-stream");
    options.addArguments("--disable-user-media-security=true");
    
    
    if(osValue.indexOf("mac") >= 0)
	{
    	capabilities.setCapability("chrome.binary",testfilePath()+"chromedriver");
	}
	else if(osValue.indexOf("nix") >= 0 || osValue.indexOf("nux") >= 0 || osValue.indexOf("aix") > 0 )
	{
		capabilities.setCapability("chrome.binary",linuxPath()+"chromedriver");
	}
	else
	{
		capabilities.setCapability("chrome.binary",testfilePath()+"chromedriver");
	}
	
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	webDriver = new ChromeDriver(capabilities);

}
catch(Exception e)
{
e.printStackTrace();
}

	
return webDriver;	
}

public static String testfilePath()
{
    URL location = BaseSetupWeb.class.getProtectionDomain().getCodeSource().getLocation();
    String fileloc = location.getFile();
    
    fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar","/lib/mac/");
    System.out.println("Chrome driver location"+ fileloc);
    
    return fileloc;
}



public static String linuxPath()
{
    URL location = BaseSetupWeb.class.getProtectionDomain().getCodeSource().getLocation();
    String fileloc = location.getFile();
    
    fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar","/lib/linux/64bit/");
    System.out.println("Chrome driver location"+ fileloc);
    return fileloc;
}
public static String chromdriverLog()
{
	URL location = BaseSetupWeb.class.getProtectionDomain().getCodeSource().getLocation();
	String fileloc = location.getFile();
	
	fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar","/logs/");
	System.out.println("Chrome driver location"+ fileloc);
	
	
	
	
	
	return fileloc;
}

public WebDriver getDriver()
{
	return webDriver;
}



}
