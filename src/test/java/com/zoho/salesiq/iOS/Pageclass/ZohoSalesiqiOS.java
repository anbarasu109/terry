//$Id$
package com.zoho.salesiq.iOS.Pageclass;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.zoho.salesiq.iOS.Testclass.EmaillogintestiOS;
import com.zoho.salesiq.Testclass.SettingsTest;
import com.zoho.salesiq.Testclass.OnlineChatTest;
import com.zoho.salesiq.Testclass.MissedChatTest;
import com.zoho.salesiq.Testclass.VisitorOnlineTest;
import com.zoho.salesiq.Testclass.ChatHistory;
import com.zoho.salesiq.Testclass.VisitorHistoryTest;
import com.zoho.salesiq.Testclass.OperatorChats;
import com.zoho.salesiq.Testclass.MessageBoardTest;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.ChatUtil;
import com.zoho.salesiq.iOS.Pageclass.BaseSetupiOS;
import com.zoho.salesiq.pageclass.Hashtablecalculate;

import org.testng.TestNG;
import org.testng.annotations.Test;

public class ZohoSalesiqiOS {

	public static int a;
	public static int b;
	public static int c;
	public static int d;
	public static int e;
	public static int f;
	public static int g;
	public static int h;
	public static int total;
	public static String modulename;
	public static String moduleList;
	public static String reportpath;
	static String postStatus="True";

	@Test
	public static void testSalesiqiOS() throws UnknownHostException,IOException,InterruptedException {

		System.out.print("before extended report start");

		// TODO Auto-generated method stub
		try {
			postStatus = System.getProperty("PostToChannel");
		}
		catch(Exception e)
		{
			postStatus="Yes";
			
		}

//		 System.out.print("before automation start");
		if(postStatus.equalsIgnoreCase("True"))
		{
		ChatUtil.automationstart(true);
		}
//		 System.out.print("After automation start");
		String serverHostName = InetAddress.getLocalHost().getHostName();
		
        String serverPortNumber = "9090";
       		 try
       		 {

		String url = System.getProperty("APKURL");

		System.out.println("before assign module"+System.getProperty("ModuleSelection"));
		
		moduleList= System.getProperty("ModuleSelection");
		System.out.println("print assigned variable"+moduleList);
		System.out.print("before"+url);
		if(url!=null)
		{
		if(url.contains("http"))
		{
		 File file = new File(apkfilePath()+"Salesiq.apk");
		 saveFileFromUrlWithJavaIO(file, url);
		}
	}
}
catch(Exception e)
{
	
}
		InetAddress ipAddr = InetAddress.getLocalHost();
        String localIP=  ipAddr.getHostAddress();
		System.out.print("before extended report");
		reportpath = "http://" + serverHostName + ":" + serverPortNumber + "/reports/" + Extentreportclass.reportime;
		
		String filePath = "http://" + serverHostName + ":" + serverPortNumber + "/reports/" + Extentreportclass.reportime;
		Hashtable<Object, Object> ht = new Hashtable<Object, Object>();
		long starttime = System.currentTimeMillis();
try{

	File file1 = new File( testfilePath() + "SalesiqMobileConf.properties");
	FileInputStream in = new FileInputStream(file1);
	Properties props = new Properties();
	props.load(in);
	in.close();

	FileOutputStream out = new FileOutputStream(file1);
	props.setProperty("ReportPath", Extentreportclass.reportime);
	props.store(out, null);
	out.close();
}
catch(Exception e)
{
	System.out.print("Exception at report path updation in properties file");
}
		System.out.print("before condition");

		try
		{
		if(!moduleList.isEmpty())
		{
			if(moduleList.contains(","))
			{
			System.out.println("enter IF condition");
		modulename=moduleList;
			}
		}
		else
		{
			System.out.println("enter else condition");
		modulename = f("Modules");
		}
	}
	catch(Exception e)
	{
		
		modulename = f("Modules");
	}
		
		

		ArrayList<String> result = new ArrayList<String>(Arrays.asList(modulename.split(",")));

		 for (String value : result) { 	

		 System.out.println(value);	      
          
		 	switch(value)
		 	{
		case "BaseSetupiOS":
			try{
				ChatUtil.sendModuleExecutionStatus("Installation Started");
				 System.out.print("Base Setup Call1");
			 	 BaseSetupiOS run = new BaseSetupiOS();
			 	System.out.print("Base Setup Call2");
			 	run.initdriver();
			 	 System.out.print("Base Setup Call3");
			 	 ChatUtil.sendModuleExecutionStatus("Installation Completed");
			}
			catch(Exception e)
			{
				
			}
		break;
		
		case "Settings":
		try{
				System.out.println("setting started");
				ChatUtil.sendModuleExecutionStatus("Settings Started");
			
				a = count(testfilePath() + "Settings.properties");
				SettingsTest run = new SettingsTest();
				run.settingsPageTest();
				
				ChatUtil.sendModuleExecutionStatus("Settings Completed");
			
		}
		catch(Exception e)
		{
			
		}

		break;

		case "VisitorOnline":
		try{
				ChatUtil.sendModuleExecutionStatus("VsiitorOnline Started");
			
				b = count(testfilePath() + "VisitorOnline.properties");
				VisitorOnlineTest run = new VisitorOnlineTest();

				run.visitorOnline();
				ChatUtil.sendModuleExecutionStatus("VsiitorOnline completed");
			}
		
		catch(Exception e)
		{
			
		}
		break;

		case "MissedChat":
		try{
			
				ChatUtil.sendModuleExecutionStatus("MissedChat Started");

				System.out.println("Missed Chat");
				c = count(testfilePath() + "MissedChat.properties");
				MissedChatTest run = new MissedChatTest();
				System.out.println("inside Missed chat ");
			
				run.missedChatExecution();

				ChatUtil.sendModuleExecutionStatus("MissedChat Completed");
	
			
		}
		catch(Exception e)
		{
			
		}
		break;

		case "VisitorOngoing":
		try{
				ChatUtil.sendModuleExecutionStatus("VisitorOngoing started");

				System.out.println("Visitor ongoing");
				d = count(testfilePath() + "VisitorOngoing.properties");
				OnlineChatTest run = new OnlineChatTest();
				System.out.println("inside visitor ongoing");
				System.out.println("new class created");
				run.ongoingChatExecution();

				ChatUtil.sendModuleExecutionStatus("VisitorOngoing completed");
		}
		catch(Exception e)
		{
			
		}
		break;

		case "ChatHistory":
		try{
				ChatUtil.sendModuleExecutionStatus("Chat History started");

			
				e = count(testfilePath() + "ChatHistory.properties");
				ChatHistory run = new ChatHistory();
				run.chatHistoryExecution();

				ChatUtil.sendModuleExecutionStatus("Chat History completed");
		}
		catch(Exception e)
		{
			
		}
		break;

		
		case "LoginTwoDevices":
		try{
				ChatUtil.sendModuleExecutionStatus("Login Started");
				f = count(testfilePath() + "EmailLogin.properties");
				EmaillogintestiOS run = new EmaillogintestiOS();
				run.emailLoginFlow();
				ChatUtil.sendModuleExecutionStatus("Login completed");
		}
		catch(Exception e)
		{
			
		}
		break;

		case "VisitorHistory":
		try{
				ChatUtil.sendModuleExecutionStatus("Visitor History Started");
				g = count(testfilePath() + "VisitorHistoryTest.properties");
				VisitorHistoryTest run = new VisitorHistoryTest();
				run.visitorHistoryTestExecution();
				ChatUtil.sendModuleExecutionStatus("Visitor History completed");
		}
		catch(Exception e)
		{
			
		}
		break;

		case "OperatorsChat":
		try{
				ChatUtil.sendModuleExecutionStatus("OperatorsChat Started");
				h = count(testfilePath() + "OperatorChats.properties");
				OperatorChats run = new OperatorChats();
				run.operatorChatsTestExecution();
				ChatUtil.sendModuleExecutionStatus("OperatorsChat completed");
		}
		catch(Exception e)
		{
			
		}
		break;

		case "MessageBoard":
		try{
				ChatUtil.sendModuleExecutionStatus("OperatorsChat Started");
				h = count(testfilePath() + "OperatorChats.properties");
				MessageBoardTest run = new MessageBoardTest();
				run.messageBoardTestExecution();
				ChatUtil.sendModuleExecutionStatus("OperatorsChat completed");
		}
		catch(Exception e)
		{
			
		}
		break;
	}

	}

		total = a + b + c + d + e+f+g+h;
		

		// TestNG runner=new TestNG();
		// List<String> suitefiles=new ArrayList<String>();
		// suitefiles.add(testfilePath() + "testng.xml");
		// runner.setTestSuites(suitefiles);
		// runner.run();

		long endtime = System.currentTimeMillis();
		

//		ht.putAll(Testcase.tm);
//		ht.putAll(OrgChannel.tm);
//		ht.putAll(Privatechannel.tm);
//		ht.putAll(ExternalChannel.tm);
//		ht.putAll(Messaging.tm);
//		ht.putAll(GroupChat.tm);
//		ht.putAll(Peopleintegration.tm);

		System.out.println("Actual use case"+total);

		System.out.println("Use case count from extended report class"+Extentreportclass.ht);	


		Hashtablecalculate.calculateReport(Extentreportclass.ht, endtime-starttime);
		
		
		if(postStatus.equalsIgnoreCase("Yes"))
		{
		ChatUtil.sendChatResult(Hashtablecalculate.report, reportpath, "All modules", true);
		}


	}

		public static void saveFileFromUrlWithJavaIO(File file, String url)
			 throws MalformedURLException, IOException {
			 BufferedInputStream in = null;
			 FileOutputStream fout = null;
			 try {
			 in = new BufferedInputStream(new URL(url).openStream());
			 fout = new FileOutputStream(file);

			byte data[] = new byte[1024];
			 int count;
			 while ((count = in.read(data, 0, 1024)) != -1) {
			 fout.write(data, 0, count);
			 }
			 } finally {
			 if (in != null)
			 {
			 in.close();
			 }
			 if (fout != null)
			 {
			 fout.close();
			 }
			 }
			 }

public static String apkfilePath()
    {
        URL location = ZohoSalesiqiOS.class.getProtectionDomain().getCodeSource().getLocation();
        String fileloc = location.getFile();
//         System.out.println(fileloc);
       
        fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar","/webapps/selenium/apk/");
        return fileloc;
    }

    public static String testfilePath()
    {
        URL location = ZohoSalesiqiOS.class.getProtectionDomain().getCodeSource().getLocation();
        String fileloc = location.getFile();
        
        fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar","/webapps/selenium/WEB-INF/resources/salesiqiOS/");
        System.out.print("test"+fileloc);
        return fileloc;
       
    }

    public static String f(String key)throws IOException {

		String value = null;
		//File file = new File("/Users/varun-6182/eclipse-workspace/testing/Testcases/TeamChannel.conf");
		File file = new File( testfilePath() + "SalesiqMobileConf.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
			value = prop.getProperty(key);

		} catch (IOException e) {
			
		}
		finally {
		    if (fileInput!=null) {
		    	fileInput.close();
		    }
		}
		System.out.println(value);
		return value;

	}

	public static int count(String filename)throws IOException {


		File file = new File(filename);

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
		int a = keys.size();
		
		return a;

	}

}
