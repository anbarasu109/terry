//$Id$
package com.zoho.salesiq.pageclass;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.DataOutputStream;

import javax.activation.*;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.InputStream;

import com.google.gson.JsonElement;


import org.json.JSONException;

import org.apache.commons.io.IOUtils;
//import com.zoho.salesiq.pageclass.WebdriverQAUtil;



public class ChatUtil
{
    
    public static String buildversion="";
    public static String postStatus="True";
    public static String getSeviceName="";

    public static int overallusecasecount = ZohoSalesiq.total;


        public static void automationstart(boolean finResult) {

            try{

                 buildversion = System.getProperty("BuildVersion");
                 postStatus =  System.getProperty("PostToChannel");
                 
                 System.out.println("post status________________________________________"+postStatus);
                 if(System.getProperty("Platform").equalsIgnoreCase("iOS"))
                 {
                	 getSeviceName="iOS"; 
                 }
                 else
                 {
                	 getSeviceName="Android";	 
                 }
                
            }
            catch(Exception e)
            {
                buildversion=""; 
                getSeviceName="Android";
            }
        
        try {
            
            String imgurl = "https://wpmayor.com/wp-content/uploads/2016/08/zoho-salesiq-630x391.gif";
                System.out.println("Build version from portal"+buildversion);                
          //  String content = "{\"message\":\" Automation Initiated - Android - Build Version : " +buildversion+ "\",\"custom_sender_name\":\"Automation\",\"custom_sender_imageurl\":\""+imgurl+"\",\"custom_message\":\"true\"}";
            String content = "{\"message\":\" Automation Initiated - "+getSeviceName+" - Build Version :"+buildversion+"\",\"custom_sender_name\":\"Automation\",\"custom_sender_imageurl\":\""+imgurl+"\",\"custom_message\":\"true\"}";
            
            
            if(finResult)
            {
                sendResultAsChatMessage(content);
            }
            
            
            
        }
        catch(Exception e){

            buildversion="";
            e.printStackTrace();
        }
        
    }


    public static void sendChatResult(Hashtable report,String filePath,String mname,boolean finResult)
    {
         
          try{

                 buildversion = System.getProperty("BuildVersion");
            }
            catch(Exception e)
            {
                buildversion=""; 
            }
        try
        {
            ///       ENDS HERE  ///////////////////////////////////////////////////////

//                      String report_template = WebdriverQAUtil.getAttachmentPath("ldreport_mail.html");
//            			report_template = report_template.replace("null", "Cliq");
//            			String content = getMailString(report_template);
//            
//            			content=content.replace("$TOTALUSECASE", ""+report.get("TotalUseCases"));
//            			content=content.replace("$TIMETAKEN", (""+report.get("TimeTaken")));
//            			content=content.replace("$SUCCESS", ""+report.get("Success"));
//            			content=content.replace("$FAILURE", ""+report.get("Failure"));
//            			content=content.replace("$SUCESSPER", (""+report.get("Success_per")+"%"));
//            			content=content.replace("$FAILPER", (""+report.get("Failure_per")+"%"));
//            
//
//            			String data = "<table cellspacing='0'><tbody><tr><td style='width: 321px; vertical-align: top; font-family: 'Liberation Serif';font-size: 12pt;'> No failed use case</td></tbody></table>";
//            			if(result.size() > 0)
//            			{
//            				data = "<table cellspacing='0'><tbody><tr><td style='width: 321px; border-width: 1px 1px 1px 1px; border-style: solid; border-color: rgb(0, 0, 0); vertical-align: middle; height:26px;'><div style='position: relative; padding: 4px; width: 313px; height:26px; font-weight: bold;font-family: 'Liberation Serif';font-size: 12pt;'>&nbsp;Use Cases</div></td>";
//            				data += "<td style='width: 321px; border-width: 1px 1px 1px 0px; border-style: solid; border-color: rgb(0, 0, 0); vertical-align: middle; height:26px;'><div style='position: relative; padding: 4px; width: 313px; height:22px; font-weight: bold;font-family: 'Liberation Serif';font-size: 12pt;'>&nbsp;Status</div></td></tr>";
//            				Set<String> keys = result.keySet();
//                            for(String key: keys){
//                                data += "<tr style='height: 40px;'><td style='width: 321px; border-width: 0px 1px 1px 1px; border-style: solid; border-color: rgb(0, 0, 0); vertical-align: top;'><div style='position: relative; padding: 4px; width: 313px; height:26px;'>  "+key+"</div></td><td style='width: 321px; border-width: 0px 1px 1px 0px; border-style: solid; border-color: rgb(0, 0, 0); vertical-align: top;'><div style='position: relative; padding: 4px; width: 313px; height:26px;'>  "+result.get(key)+"</div></td></tr>";
//                            }
//            				data += "</tbody></table>";
//            			}
//                        content = content.replace("$REPORT", data);




            String subject = getSubject(report);
           
            String imgurl = "https://assets.pcmag.com/media/images/468082-zoho-cliq.png?width=333&height=245";//"https://www.zoho.com/salesiq/img/favicon.ico";

            String modules_result ="";


            String totalUsecases = "";



            String content = "{\"message\":\"Build : Version " +buildversion+ "\",\"formattedmsg\":[{\"type\":\"table\",\"title\":\"Summary :\",\"data\":{\"headers\":[\"Total Use Cases\",\"Executed Use Cases\",\"Time Taken\",\"Success\",\"Failure\",\"Success(%)\",\"Failure(%)\"],\"rows\":[{\"Total Use Cases\":\""+report.get("TotalUseCases")+"\",\"Executed Use Cases\":\""+report.get("TotalUseCases")+"\",\"Time Taken\":\""+report.get("TimeTaken")+"\",\"Success\":\""+report.get("Success")+"\",\"Failure\":\""+report.get("Failure")+"\",\"Success(%)\":\""+report.get("Success_per")+"%\",\"Failure(%)\":\""+report.get("Failure_per")+"%\"}]}}],\"buttons\" : [{ \"label\" : \"View Results\", \"hint\" : \"Click here to view the automation results\", \"type\" : \"\", \"action\" : { \"type\" : \"open.url\", \"data\" : { \"web\" : \""+filePath+"\", } } }],\"custom_sender_name\":\"Automation\",\"custom_sender_imageurl\":\""+imgurl+"\",\"custom_message\":\"true\",\"msg_title\": \""+subject+"\",\"thumbnail_url\": \""+imgurl+"\"}";

          System.out.println("outside if if:::::::::"+content);



            if(finResult)
            {
               System.out.println("inside if:::::::::"+content);
                sendResultAsChatMessage(content);
            }
            else
            {
                subject = "Salesiq Automation - "+mname+" : Total Test Cases : "+report.get("TotalUseCases")+", Failure : "+report.get("Failure")+" ("+report.get("Failure_per")+"%) [Details]("+filePath+")";
                content = "{\"message\":\""+subject+"\",\"custom_sender_name\":\"Automation\",\"custom_sender_imageurl\":\""+imgurl+"\",\"custom_message\":\"false\"}";

                sendChatMessage(content);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    private static String getSubject(Hashtable report)
    {
    	   if(System.getProperty("Platform").equalsIgnoreCase("iOS"))
           {
          	 getSeviceName="iOS"; 
           }
           else
           {
          	 getSeviceName="Android";	 
           }
        String subject = "Salesiq Mobile Automation - "+getSeviceName+" - Success Rate - "+report.get("Success_per")+"% | Failure Rate - "+report.get("Failure_per")+"%";

        return subject;
    }

    private static String getMailString(String path) throws Exception
    {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
            String line = null;
            StringBuffer st = new StringBuffer();
            while((line = reader.readLine())!=null)
            {
                st.append(line);
                st.append("\r\n");//No i18N
            }
            return st.toString();
        }
        finally
        {
            try{if(reader!=null){reader.close();}}catch(Exception e){
            	
            }
        }
    }

    public static void sendModuleExecutionStatus(String chmsg)
    {
    	

        DataOutputStream os=null;
         HttpURLConnection httpcon=null;
         

        try
        {
        	postStatus =  System.getProperty("PostToChannel");
            if(postStatus.equalsIgnoreCase("True"))
             {
            String channelName = System.getProperty("ChannelList");
           
            String aToken = System.getProperty("cliqSession");

           
         System.out.println("Channel name"+channelName);
         System.out.println("Channel Tokens"+aToken);

         
          System.out.println("Message content"+chmsg);

            URL url = new URL("https://cliq.zoho.com/api/v2/channelsbyname/"+channelName+"/message?authtoken="+aToken+"&scope=InternalAPI");
            System.out.println("URL value"+url);
            httpcon = (HttpURLConnection) (url.openConnection());
            httpcon.setRequestMethod("POST");
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type","application/json");

            String inputValue="{\"text\":\""+chmsg+"\"}";
                

            //String outputBytes = "{\"message\":\""+chmsg+"\"}";//URLEncoder.encode(chmsg, "UTF-8")
            //String outputBytes = "{\"message\":{\"table\":\\"+chmsg+"\"}}";
            String outputBytes = inputValue;
             os = new DataOutputStream(httpcon.getOutputStream());
           // os = httpcon.getOutputStream();
            os.write(outputBytes.getBytes());
            //os.write(.URLEncoder.encode(data, "UTF-8"));
            os.flush();
             }
           

        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        finally
        {
            try
            {
                os.close();
                 System.out.println("After"+httpcon.getResponseCode());
            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }
        }
    

    }






    public static void sendResultAsChatMessage(String chmsg)
    {
    	
      //  OutputStream os = null;
        DataOutputStream os=null;
         HttpURLConnection httpcon=null;
         String channelName;

        try
        {
        	if(System.getProperty("ChannelList").isEmpty())
        	{
            channelName = System.getProperty("ChannelList");
        	}
        	else
        	{
        		channelName=System.getProperty("ChannelList");
        	}
           
            String aToken = System.getProperty("cliqSession");
            

           
         System.out.println("Channel name"+channelName);
         System.out.println("Channel Tokens"+aToken);

         
          System.out.println("Message content"+chmsg);

            URL url = new URL("https://cliq.zoho.com/api/v1/channelsbyname/"+channelName+"/message?authtoken="+aToken+"&scope=InternalAPI");
            System.out.println("URL value"+url);
            httpcon = (HttpURLConnection) (url.openConnection());
            httpcon.setRequestMethod("POST");
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type","application/json");
                

            //String outputBytes = "{\"message\":\""+chmsg+"\"}";//URLEncoder.encode(chmsg, "UTF-8")
            //String outputBytes = "{\"message\":{\"table\":\\"+chmsg+"\"}}";
            String outputBytes = chmsg;
             os = new DataOutputStream(httpcon.getOutputStream());
           // os = httpcon.getOutputStream();
            os.write(outputBytes.getBytes("UTF-8"));
            //os.write(.URLEncoder.encode(data, "UTF-8"));
            os.flush();
           
           

        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        finally
        {
            try
            {
                os.close();
                 System.out.println("After"+httpcon.getResponseCode());
            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }
        }
    }

    public static void sendResultAsChatMessageForException(String chmsg)
    {
        OutputStream os = null;

        try
        {
            String channelName = System.getProperty("ChannelList");

            if(channelName.equals("updatesv"))
            {
                channelName = "automation";
            }
            else
            {
                channelName = "salesiqtest";
            }

            String aToken = System.getProperty("cliqSession");

            URL url = new URL("https://cliq.zoho.com/api/v1/channelsbyname/"+channelName+"/message?authtoken="+aToken+"&scope=InternalAPI");

            HttpURLConnection httpcon = (HttpURLConnection) (url.openConnection());
            httpcon.setRequestMethod("POST");
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type", "application/json");

            String outputBytes = chmsg;
            os = httpcon.getOutputStream();
            os.write(outputBytes.getBytes("UTF-8"));
            os.flush();
           
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        finally
        {
            try
            {
                os.close();
            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }
        }
    }

    public static void sendChatMessage(String chmsg)
    {
        
        {
        OutputStream os = null;

        try
        {
            String channelName = System.getProperty("ChannelList");
            String aToken = System.getProperty("cliqSession");

            URL url = new URL("https://cliq.zoho.com/api/v1/channelsbyname/"+channelName+"/message?authtoken="+aToken+"&scope=InternalAPI");
          

            HttpURLConnection httpcon = (HttpURLConnection) (url.openConnection());
            httpcon.setRequestMethod("POST");
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type", "application/json");


            //String outputBytes = "{\"message\":\""+chmsg+"\"}";//URLEncoder.encode(chmsg, "UTF-8")
            //String outputBytes = "{\"message\":{\"table\":\\"+chmsg+"\"}}";
            String outputBytes = chmsg;
            os = httpcon.getOutputStream();
            os.write(outputBytes.getBytes("UTF-8"));
            //os.write(.URLEncoder.encode(data, "UTF-8"));
            os.flush();
            
           
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        finally
        {
            try
            {
                os.close();
            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }
        }
    }
    }

    public static void sendChatMessage(String chmsg,String channelName)
    {
        OutputStream os = null;

        try
        {
            String aToken = System.getProperty("cliqSession");

            URL url = new URL("https://cliq.zoho.com/api/v1/channelsbyname/"+channelName+"/message?authtoken="+aToken+"&scope=InternalAPI");

            HttpURLConnection httpcon = (HttpURLConnection) (url.openConnection());
            httpcon.setRequestMethod("POST");
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type", "application/json");

            //String outputBytes = "{\"message\":\""+chmsg+"\"}";//URLEncoder.encode(chmsg, "UTF-8")
            //String outputBytes = "{\"message\":{\"table\":\\"+chmsg+"\"}}";
            String outputBytes = chmsg;
            os = httpcon.getOutputStream();
            os.write(outputBytes.getBytes("UTF-8"));
            //os.write(.URLEncoder.encode(data, "UTF-8"));
            os.flush();
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        finally
        {
            try
            {
                os.close();
            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }
        }
        
    }

     public static String filePath()
    {
        URL location = ZohoSalesiq.class.getProtectionDomain().getCodeSource().getLocation();
        String fileloc = location.getFile();

        fileloc = fileloc.replaceAll("/lib/salesiqandroid-webdriver.jar","/webapps/selenium/WEB-INF/resources/salesiqandroid/");
        return fileloc;
    }

    public static String Keymanager(String key) throws IOException {

        String filepath = filePath();
        
        String value = null;
        //File file = new File("/Users/varun-6182/eclipse-workspace/testing/Testcases/TeamChannel.conf");
        File file = new File(filepath + "SalesiqMobileConf.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
            value = prop.getProperty(key);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
		    if (fileInput!=null) {
		    	fileInput.close();
		    }
		}
        return value;
        
    }

    public static void automationend(boolean finResult) {
        
        try {
            
            
            String imgurl = "https://assets.pcmag.com/media/images/468082-zoho-cliq.png?width=333&height=245";
           
          
            
            String content = "{\"message\":\" Automation Completed - "+getSeviceName+" - Build Version :" +buildversion+ "\",\"custom_sender_name\":\"Automation\",\"custom_sender_imageurl\":\""+imgurl+"\",\"custom_message\":\"true\"}";   
           
            if(finResult)
            {
                sendResultAsChatMessage(content);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

}
