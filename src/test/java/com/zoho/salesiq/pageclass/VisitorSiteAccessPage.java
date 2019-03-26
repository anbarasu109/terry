//$Id$
package com.zoho.salesiq.pageclass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zoho.salesiq.pageclass.CommonActionWeb;
import com.zoho.salesiq.pageclass.BaseSetupWeb;

public class VisitorSiteAccessPage extends BaseSetupWeb {

	
	
	private String module="Visitor Page access";
	public static String waitingTime;
	private static boolean createChat;

	BaseSetupWeb setupWeb = new BaseSetupWeb();

	public VisitorSiteAccessPage(WebDriver webDriverw) {
		
		if(webDriverw==null)
		{
			webDriver=setupWeb.getDriver();
			System.out.println("visitor accesspage passed null");
		}
		else
		{
		  this.webDriver = webDriverw;
		  System.out.println("visitor accesspage return null");
		}
		}
		CommonActionWeb actions = new CommonActionWeb(webDriver);
	
	
	// @FindBy(id="siqbtndiv")
	// WebElement widgetButton;
	
	// @FindBy(id="pastchatconv")
	// WebElement pastConversation;
	
	// @FindBy(id="showsiqchatui")
	// WebElement createNewChatIcon;
	
	// @FindBy(id="visname")
	// WebElement enterVisitorName;





	
	// @FindBy(id="visemail")
	// WebElement enterVisitorEmail;
	
	
	// @FindBy(className=".cal_actns")
	// WebElement rejectCall;
	
	// @FindBy(className=".cal_actns")
	// WebElement acceptCall;
	
	// @FindBy(id="audiocall")
	// WebElement initiateAudioCall;
	
	// @FindBy(id="dropheader")
	// WebElement dropDownClick;

		// List<WebElement> selectFromDropDown  = webDriver.findElements(By.xpath("//li"));
		// WebElement createChatByClickHere  = webDriver.findElement(By.linkText("click here."));

	
	// @FindBy(xpath="")
	// List<WebElement> selectFromDropDown;
	
	// @FindBy(id="msgarea")
	// WebElement entervisitorQuestion;
	
	// @FindBy(id="sqico-send")
	// WebElement sendVisitorChat;
	
	// @FindBy(id="wait_div")
	// WebElement countDownTimer;
	
	// @FindBy(id="siqiframe")
	// WebElement frameCheck;
	
	// @FindBy(className=".sqico-end")
	// WebElement endChatByVisitor;
	
	// @FindBy(className=".sqico-close")
	// WebElement closeRating;
	
	// @FindBy(linkText="click here.")
	// WebElement createChatByClickHere;
	
	



	


	public void clickWidget(String module)
	{
		boolean status;
		try
		{
			if(!createChat)
			{
		webDriver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(webDriver,10);
		//WebElement widgetButton  = webDriver.findElement(By.id("siqbtndiv"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zsiq_agtpic")));
		actions.clickAction(webDriver.findElement(By.id("zsiq_agtpic")), module, "click on widget");
		System.out.println("clicked on widget");
		
		actions.waitCommand(1);
		WebElement frameCheck  = webDriver.findElement(By.id("siqiframe"));
		if(frameCheck.isDisplayed())
		{
			createNewChat(module);
		}
		else
		{
			status =false;
			System.out.println("chat window not displayed");
		}
			}
			else
			{
				status =false;
				System.out.println("unable to click widget else "+createChat);
			}
		}
		catch(Exception e)
		{
			System.out.println("unable to click on widget chat");
			
		}
		
	}
	public void createNewChat(String module)
	{
		try
		{
	
		switchtoSalesiqFrame(module);
		WebElement createNewChatIcon  = webDriver.findElement(By.id("showsiqchatui"));
		if(actions.iselemetFound(createNewChatIcon))
		{
			createChat=true;
			actions.clickAction(createNewChatIcon, module, "Click on create new chat icon");
		}
		else
		{
			System.out.println("unable to click on create chat or not shown");
			createChat=false;
		}
		}
		catch(Exception e)
		{
			System.out.println("unable to click on create chat or not shown");
			createChat=false;
		}
	
	}
	
	public void enterVisitorName(String module,String vistorName)

	{
		try
		{
		WebDriverWait wait = new WebDriverWait(webDriver,10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visname")));
		WebElement enterVisitorName  = webDriver.findElement(By.id("visname"));
		actions.actionEnter(enterVisitorName, vistorName, module, "Enter visitor Name");
		}
		catch(Exception e)
		{

		}
	}
	
	public void entervisitorMailid(String module,String visitorMailid)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(webDriver,10);

		WebElement enterVisitorEmail  = webDriver.findElement(By.id("visemail"));
		wait.until(ExpectedConditions.visibilityOf(enterVisitorEmail));
		actions.clickAction(enterVisitorEmail, module, "Clear Email id field");
		actions.clearText(enterVisitorEmail, module, "Clear Email id field");
		actions.actionEnter(enterVisitorEmail, visitorMailid,module, "Enter visitor Mail id");
		}
		catch(Exception e)
		{

		}
		
	}
	public void selectDepartmentName(String module,String departmentName)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(webDriver,10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropheader")));
		WebElement dropDownClick  = webDriver.findElement(By.id("dropheader"));
		actions.clickAction(dropDownClick, module, "click on drobdown");
		
		wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(By.xpath("//li"))));
		List<WebElement> selectFromDropDown  = webDriver.findElements(By.xpath("//li"));
		
		
		actions.selectBasedonTextInList(selectFromDropDown,departmentName,module,"Select department from list");
		}
		catch(Exception e)
		{

		}
		
	}
	public void enterChatText(String module,String textValue){
		try
		{
		WebDriverWait wait = new WebDriverWait(webDriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msgarea")));
		WebElement entervisitorQuestion  = webDriver.findElement(By.id("msgarea"));
		actions.actionEnter(entervisitorQuestion, textValue, module, "Enter visitor chat question");
		}
		catch(Exception e)
		{

		}	
		}
	public void clearChatText(String module){

		try
		{
			WebDriverWait wait = new WebDriverWait(webDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msgarea")));
		WebElement entervisitorQuestion  = webDriver.findElement(By.id("msgarea"));
		
		entervisitorQuestion.clear();
	}
		catch(Exception e)
		{

		}
	}
	
	public void sendchatRequestVisitor(String module){
		try
		{
			WebDriverWait wait = new WebDriverWait(webDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sqico-send")));
		WebElement sendVisitorChat  = webDriver.findElement(By.id("sqico-send"));
		
		actions.clickAction(sendVisitorChat, module, "Send initiate chat request from visitor");
		createChat=false;
		}
		catch(Exception e)
		{

		}
	}
	
	public int getcurrentWaitingTime(String module)
	{
		try
		{
	 Date date = null;
	 WebDriverWait wait = new WebDriverWait(webDriver,10);
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wait_div")));
		WebElement countDownTimer  = webDriver.findElement(By.id("wait_div"));
		 
		String time =actions.getElementText(countDownTimer);
		String a[]=time.split("s");
		try {
		DateFormat dateFormat = new SimpleDateFormat("mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
			
		date = dateFormat.parse(a[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}
		
		 int seconds = (int) (date.getTime() / 1000L);	
		 if(seconds>0)
		 {
			return seconds;
		 }
		 else
		 {
			 return 40;
		 }
		}
		catch(Exception e)
		{
			return 0;
		}

	}
			
	public void clearVisitorNameField(String module)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(webDriver,10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visname")));
		WebElement enterVisitorName  = webDriver.findElement(By.id("visname"));
		actions.clickAction(enterVisitorName, module, "Clear VistiorName field");
		actions.clearText(enterVisitorName, module, "Clear VistiorName field");
		}
		catch(Exception e)
		{

		}
	}
	public void switchtoSalesiqFrame(String module)
	{
		try
		{
		actions.waitCommand(4);
		System.out.println("switch to Frame started");
		webDriver.switchTo().frame("siqiframe");
		System.out.println("switch to Frame completed");
	}
		catch(Exception e)
		{
			System.out.println("unable to switch to frame");
		}
		
		
	}
	
	public void checkNewChatProgress(String module)
	{
		try
		{
		if(getcurrentWaitingTime(module)>0)
		{
			switchtoSalesiqFrame(module);
			actions.waitCommand(getcurrentWaitingTime(module)+3);
		}
		}
		catch(Exception e)
		{

		}
			
	}
	public void checkWidgetChatWindow(String module)
	{
		try
		{
		actions.waitCommand(5);
		WebElement frameCheck  = webDriver.findElement(By.id("siqiframe"));
		if(frameCheck.isDisplayed())
		{
			createNewChat(module);
		}
		else
		{
			clickWidget(module);
		}
		}
		catch(Exception e)
		{

		}
	}
	
	public void initiateCallFromVisitor(String module)
	{
		try
		{
		WebElement initiateAudioCall  = webDriver.findElement(By.cssSelector("span.siqchat-detl.sqico-call"));

		actions.clickAction(initiateAudioCall, module, "Initiate audio call from visitor");
		}
		catch(Exception e)
		{

		}
	}
	
	public void rejectCallFromVisitor(String module)
	{
		try
		{
		WebElement rejectCall  = webDriver.findElement(By.cssSelector(".sqico-call.reject-cal"));

		actions.clickAction(rejectCall, module, "Reject call by visitor");
		}
		catch(Exception e)
		{

		}
	}
	
	public void endChatByVisitor(String module)
	{try
		{
		WebElement endChatByVisitor  = webDriver.findElement(By.cssSelector("span.sqico-end.siq-end-chat-button"));

	if(endChatByVisitor.isDisplayed())
	{
		actions.waitCommand(5);
		actions.clickAction(endChatByVisitor, module, "End Chat by Visitor");
		webDriver.navigate().refresh();
		System.out.println("found end icon");
	}
	else
	{
		WebElement widgetButton  = webDriver.findElement(By.id("siqbtndiv"));
		webDriver.navigate().refresh();
		actions.clickAction(widgetButton, module, "click on widget");
		switchtoSalesiqFrame(module);
		actions.clickAction(endChatByVisitor, module, "End Chat by Visitor");
		System.out.println("unable to found end icon");
	}
}
		catch(Exception e)
		{

		}

	}
	public void closeRating(String module)
	{try
		{
		WebElement closeRating  = webDriver.findElement(By.className(".sqico-close"));

		actions.clickAction(closeRating, module, "Skip rating by visitor");
		}
		catch(Exception e)
		{

		}
	}
	public void createChatClickHere(String module)
	{try
		{
		WebElement createChatByClickHere  = webDriver.findElement(By.linkText("click here."));

		actions.clickAction(createChatByClickHere, module, "Create new chat by clicking on click here");
		}
		catch(Exception e)
		{

		}
	}
	
	
	public void acceptCallFromVisitor(String module)
	{try
		{
		WebElement acceptCall  = webDriver.findElement(By.className(".cal_actns"));

		actions.clickAction(acceptCall, module, "acccept call by visitor");
		}
		catch(Exception e)
		{

		}
	}
	
	public void sendTextToOperator(String module	)
	{try
		{
		WebDriverWait wait = new WebDriverWait(webDriver,10);
		
		WebElement sendVisitorChat  = webDriver.findElement(By.id("sqico-send"));
		wait.until(ExpectedConditions.visibilityOf(sendVisitorChat));
		actions.clickAction(sendVisitorChat, module, "Send text to Operator");
		}
		catch(Exception e)
		{

		}
	}
	
}
