package com.zoho.salesiq.iOS.Pageclass;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.binary.Base64;

import io.appium.java_client.android.AndroidDriver;

public class CommonMethodsiOS {
	
	AndroidDriver driver;
	AndroidDriver driver1;
	
	
	public CommonMethodsiOS( AndroidDriver driver, AndroidDriver driver1)
	{
	this.driver=driver;
	this.driver1=driver1;
	//PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
	
	public String converImageFileToBase64(String filePath)
	{
		  String encodedfile="";
		try
		{
		File screenshotLocationB = new File(filePath);
		
		 FileInputStream fileInputStreamReader = new FileInputStream(screenshotLocationB);
        byte[] bytes = new byte[(int)screenshotLocationB.length()];
        fileInputStreamReader.read(bytes);
        encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
		}
		catch(Exception e)
		{
			
		}
		return encodedfile;
		
	}

}
