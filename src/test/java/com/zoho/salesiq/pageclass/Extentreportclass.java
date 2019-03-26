//$Id$
package com.zoho.salesiq.pageclass;

import java.io.File;
import com.aventstack.extentreports.model.SystemAttribute;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.Hashtable;
import java.util.TreeMap;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.VersionInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import com.zoho.salesiq.pageclass.ZohoSalesiq;
import java.util.List;
import java.util.Arrays;
import java.net.InetAddress;
import java.net.UnknownHostException;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import org.apache.commons.codec.binary.Base64;


public class Extentreportclass  {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static TreeMap<String, Boolean> tm = new TreeMap<String, Boolean>();
	public static Hashtable<Object, Object> ht = new Hashtable<Object, Object>();
	private static String currentTestCase="";
	private static String currentUseCase="";
	public static String categories="";
	public static String directCallCategories="";
	private static String[] exceptionCategoriesList= new String[]{"com.zoho.salesiq.pageclass.CommonActionMobile","com.zoho.salesiq.pageclass.CommonActionMobileDeviceTwo"};
	private static List<String> catgoriesException = Arrays.asList(exceptionCategoriesList);
	private static int useCaseCount=0;
	public static String useCaseName;
	private static int increament=0;

//	public Extentreportclass(AndroidDriver driver) {
//		this.driver = driver;
//	}

	// private static String filePath =
	// "/Users/varun-6182/eclipse-workspace/testing/Reports/Report.html";
	public static String reportime = "Report" + System.currentTimeMillis() + ".html";
	public static String filePath = filePath() + reportime;

	public static ExtentReports GetExtent() {

		if (extent != null) {
			return extent; // avoid creating new instance of html file
		} else {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());
			return extent;
		}

	}

	public static ExtentHtmlReporter getHtmlReporter() {

		htmlReporter = new ExtentHtmlReporter(filePath);
		// make the charts visible on report open
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Salesiq Mobile Automation report");
		htmlReporter.config().setReportName("Testing");
		htmlReporter.loadXMLConfig(configfilePath() + "extent-config.xml");
		//htmlReporter.config().setReportName(WebdriverQAUtil.getModule());
		return htmlReporter;
		
	}

	public void mobilepassTest(String usecase, String testCase) {
		try
		{
		
		if(currentUseCase.isEmpty())
		{
			GetExtent();
			directCallCategories=Thread.currentThread().getStackTrace()[2].getClassName();
			test = Extentreportclass.createTest(usecase,testCase);
			
		}
		else if (currentUseCase == usecase)
		{
			GetExtent();
			directCallCategories=Thread.currentThread().getStackTrace()[2].getClassName();
		}
		else
		{	//stopAndSaveVideo();
			closeExtendedReport();
			GetExtent();
			directCallCategories=Thread.currentThread().getStackTrace()[2].getClassName();
			test = Extentreportclass.createTest(usecase,testCase);
			
			
		}

		
		test.log(Status.PASS, testCase + " Test Passed");
		currentUseCase=usecase;
		tm.put(testCase, true);
		ht.putAll(tm);
		
	
}
	catch(Exception e)
	{

	}

	}

	public void mobilefailTest(AndroidDriver driver,String usecase, String testCase) {
		try
		{
			if(currentUseCase.isEmpty())
		{
			GetExtent();
			directCallCategories=Thread.currentThread().getStackTrace()[2].getClassName();
			test = Extentreportclass.createTest(usecase,testCase);
		}
		else if (currentUseCase == usecase)
		{
			GetExtent();
			directCallCategories=Thread.currentThread().getStackTrace()[2].getClassName();
		}
		else
		{
			closeExtendedReport();
			GetExtent();
			directCallCategories=Thread.currentThread().getStackTrace()[2].getClassName();					
			test = Extentreportclass.createTest(usecase,testCase);

		}
		

		String calledMethodName=Thread.currentThread().getStackTrace()[2].getMethodName();
		

		test.log(Status.FAIL, testCase+" Test Failed and called MethodName :"+calledMethodName);
		//etest.log(Status.FAIL, "Snapshot" + etest.addScreenCaptureFromPath(Screenshotpath));
		mobileScreenshot(driver,"Fail", testCase);
		currentUseCase=usecase;
		tm.put(testCase, false);
		ht.putAll(tm);
		
}
	catch(Exception e)
	{

	}
		

	}

	public static String filePath() {
		URL location = BaseSetup.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/reports/");
		return fileloc;
	}

	public static String configfilePath() {
		URL location = BaseSetup.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/webapps/selenium/WEB-INF/resources/salesiqandroid/");
		return fileloc;
	}

	public static String shellFilePath() {
		URL location = BaseSetup.class.getProtectionDomain().getCodeSource().getLocation();
		String fileloc = location.getFile();
		
		fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar", "/lib/");
		return fileloc;
	}

	public String mobileScreenshot(AndroidDriver driver,String result, String tescaseName) {

		try
		{

		String serverHostName = InetAddress.getLocalHost().getHostName();
					
		String serverPortNumber = "9090";
		
		String resultpath = "http://" + serverHostName + ":" + serverPortNumber + "/";

		GetExtent();
		File srFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshotImage;
		String filePath = null;

		if (result.equalsIgnoreCase("Pass")) {
			String screenshotname = System.currentTimeMillis() + ".png";
			String ScreenshotPath = filePath()+"/Screenshots/Pass/" + screenshotname;
			screenshotImage = new File(ScreenshotPath);
			try {
				FileUtils.copyFile(srFile, screenshotImage);
				filePath = resultpath+"reports/Screenshots/Pass/" + screenshotname;
				test.log(Status.PASS, "Snapshot" + test.addScreenCaptureFromPath(filePath));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			
			String screenshotname = System.currentTimeMillis() + ".png";
			String ScreenshotPath = filePath()+"/Screenshots/Failure/" + screenshotname;
			screenshotImage = new File(ScreenshotPath);
			try {
				FileUtils.copyFile(srFile, screenshotImage);
				filePath = resultpath+"reports/Screenshots/Failure/" + screenshotname;
				test.log(Status.FAIL, "Snapshot" + test.addScreenCaptureFromPath(filePath));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	catch(Exception e)
	{

	}
		return filePath;
	}

	private int intConversion(String value)
	{
		int value1 = Integer.parseInt(value);
		return value1;
	}

	public void startVideoRecord(AndroidDriver driver)
	{
		if(intConversion(BaseSetup.androidOSVersion)>8)
			{
		driver.startRecordingScreen();
		System.out.println("__________________________________________greater than 8 version _______________________________________________________");
	}
	else
	{
	// 	System.out.println("___________________________________________Less than 8 version _______________________________________________________");
	// startRecord.start();
	// useCaseName=useCaseName();

	}
	}
	static Thread startRecord = new Thread() {
	public void run()
	{
		String shellPathValue=shellFilePath()+"screenrecord.sh";
		System.out.println("__________________________________________path of start record"+shellPathValue+"_______________________________________________________");
		System.out.println("dynamic file value start "+useCaseName);
		String[] cmdScript = new String[]{"/bin/bash",shellPathValue,useCaseName}; 
		try {
			Process procScript = Runtime.getRuntime().exec(cmdScript);
			System.out.println("start record");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	};

	static Thread stopRecord = new Thread() {
	public void run()
	{
		String shellPathValue=shellFilePath()+"StopAndSaveScreenRecord.sh";
		System.out.println("__________________________________________path of stop record"+shellPathValue+" _______________________________________________________");
		System.out.println("dynamic file value stop "+useCaseName);
		String[] cmdScript = new String[]{"/bin/bash",shellPathValue,useCaseName}; 
		try {
			Process procScript = Runtime.getRuntime().exec(cmdScript);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	};

	public String useCaseName()
	{
		useCaseName="usecase"+increament;
		increament++;
		System.out.println("use case name dynamic name"+useCaseName);
		return useCaseName;
	}


	public void stopAndSaveVideo(AndroidDriver driver)
	{
		try{
			if(intConversion(BaseSetup.androidOSVersion)>8)
			{
		String serverHostName = InetAddress.getLocalHost().getHostName();
					
		String serverPortNumber = "9090";
		
		String resultpath = "http://" + serverHostName + ":" + serverPortNumber + "/";

		String videoName = "TestCase"+useCaseCount+".mp4";
		 String result = driver.stopRecordingScreen();
		  byte[] decodedBytes = Base64.decodeBase64(result.getBytes());

		String screenRecordPath = filePath()+"/videos/" + videoName;
		File screenRecordFile = new File(screenRecordPath);
		 
		  BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(screenRecordFile));

		  String filePath = resultpath+"reports/Screenshots/Failure/"+videoName;
		  writer.write(decodedBytes);
		  writer.flush();
		  writer.close();
		  useCaseCount++;
		}
		else{
		// 	stopRecord.start();
		// 	try {
		// 	Thread.sleep(3000);
		// 	startRecord.join();
		// 	stopRecord.join();
		// 	startRecord.stop();
		// 	stopRecord.stop();
		// } catch (InterruptedException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }


		}
		}
		catch(Exception e)
		{
e.printStackTrace();
		}
	}

	

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is " + result.getName());
			test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
		}
	}

	public static ExtentTest createTest(String usecase, String testcase) {
		String finalDirectcatagories[]=null;
		String finacatogaries[]=null;
		try
		{
		test = extent.createTest(usecase,testcase);
		test.assignAuthor("Salesiq Mobile Automation");

		System.out.println("common categroies "+ categories);
		System.out.println("direct categroies "+ directCallCategories);

		if(!categories.isEmpty())
		{
		finacatogaries=categories.split("[\\s@&.?$+-]+");
		System.out.println("Final direct categroies "+ finacatogaries[4]);
	}

		if(!directCallCategories.isEmpty())
		{
		finalDirectcatagories=directCallCategories.split("[\\s@&.?$+-]+");
		System.out.println("Final direct categroies "+ finalDirectcatagories[4]);
	}



		if(catgoriesException.contains(categories))
		{
			test.assignCategory(finalDirectcatagories[4]);
		}
		else
		{
			test.assignCategory(finacatogaries[4]);

		}
	}
	catch(Exception e )
	{
		return test;
	}
	
		return test;

	}

	public void closeExtendedReport() {
		extent.flush();
	}

}
