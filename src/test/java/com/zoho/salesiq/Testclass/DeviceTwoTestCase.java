//$Id$
package com.zoho.salesiq.Testclass;


import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.zoho.salesiq.pageclass.BaseSetupDevice2;
import com.zoho.salesiq.pageclass.BurgerMenuNavigations;
import com.zoho.salesiq.pageclass.CommonActionMobileDeviceTwo;
import com.zoho.salesiq.pageclass.DeviceTwoPageCommon;
import com.zoho.salesiq.pageclass.Emaillogin;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.VisitorOnlinePage;

public class DeviceTwoTestCase extends BaseSetupDevice2 {

	private CommonActionMobileDeviceTwo actions;
	BurgerMenuNavigations navi ;
	DeviceTwoPageCommon deviceTwoCommon ;
	VisitorOnlinePage visitorOnlinePage;
	BaseSetupDevice2 base;
	Extentreportclass extentreportclass;
	private String module="Ongoing Chat";
	
	public DeviceTwoTestCase()
	{
		extentreportclass = new Extentreportclass();
		actions=new CommonActionMobileDeviceTwo(driver1);
		deviceTwoCommon= new DeviceTwoPageCommon(driver1);
	}

@Test	
public void DeviceTwoLogin(String testcase)
{
	actions.pushFileForFileSharing("push file to device");
	deviceTwoCommon.loginButton(testcase);
	actions.waitTime(2);
	deviceTwoCommon.enterEmail("mr.anbarasu10@gmail.com",testcase);
	deviceTwoCommon.enterPassword("Automation@123",testcase);
	actions.hideKeyboard();
	deviceTwoCommon.loginUser(testcase);
	actions.waitTime(5);
	deviceTwoCommon.clickNotInterested(testcase);
	actions.killApplication(testcase);
	actions.lauchApplicationAfterKill(testcase);
	

	}

public void transferTextPopup(String module)
{
	deviceTwoCommon.checkTransferChatText(module);
}

public void swipeBurger(String module)
{
	actions.swipeOption(10, 1008, 563, 1008);
	}

public void selectOperatorFromOperatorChats(String useCase,String categories,String operatorName)
{
	deviceTwoCommon.selectOperatorFromList(useCase,categories,operatorName);
	}


public void enterTextInOperatorChatsTwo(String useCase,String categories,String chatText)
{
	deviceTwoCommon.enterTextInChatInputField(useCase,categories,"Verify operator2 able to enter chat text",chatText);
	}

	public void enterTextInMessageBoardTwo(String useCase,String categories,String chatText)
{
	deviceTwoCommon.enterTextInChatInputField(useCase,categories,"Verify operator2 able to enter chat text in Message board page",chatText);
	}

public void sendTextInOperatorChatsTwo(String useCase,String categories)
{
	deviceTwoCommon.sendTextFromChatWindow(useCase,categories,"Verify if operator2 clicks send text icon chat text should send to another operator");
	}

	public void sendTextInMessageBoardTwo(String useCase,String categories)
{
	deviceTwoCommon.sendTextFromChatWindow(useCase,categories,"Verify if operator2 clicks send text icon in Message board, chat text should send to message board");
	}
public void checkImageSharedWithOtherOperator(String useCase,String categories)
{
	actions.waitTime(5);
	actions.hideKeyboard();
	deviceTwoCommon.checkImageSharedWithOperatorTwo(useCase,categories);
	}
public void checkImageisDownloaded(String useCase,String categories)
{
	actions.waitTime(3);
	deviceTwoCommon.clickDownloadIcon(useCase,categories);
	deviceTwoCommon.checkImageDownloaded(useCase,categories);
	}

public void rejectTransferChat(String module)
{
	deviceTwoCommon.clickRejectTransferChat(module);
	}

	public void checkActiveOperatorCountIfNewOperatorAdded(String module,String categories,String expectedValue)
{
	deviceTwoCommon.checkActiveOperatorCountInMessageBoard(module,categories,expectedValue);
	}




	public void messageBoardMenuClick(String useCase,String categories)
{
	deviceTwoCommon.messageBoardMenuClickDeviceTwo(useCase,categories);
	}
public void acceptTransferChat(String module)
{
	deviceTwoCommon.clickAcceptTransferChat(module);
}
public void confirmTranslationDeviceTwo(String module)
{
deviceTwoCommon.confirmTranslation(module);
}

public void checkTransferNotitification(String module)
{
	deviceTwoCommon.checkTransferChatText(module);
}
public void checkInviteNotitification(String module)
{
	deviceTwoCommon.checkChatInviteNotification(module);
}
public void clickOngoingMenu(String module)
{
	deviceTwoCommon.openOngoingMenu(module);
}

public void operatorChatsMenuDeviceTwo(String module)
{
	deviceTwoCommon.operatorChatsMenuClickDeviceTwo(module);
}
public void selectChatFromList(String module)
{
	deviceTwoCommon.selectVisitorFromList(module);
}
public void checkInviteActionText(String module)
{
	deviceTwoCommon.checkActionText(module,"operator MPTEST has invited Admin to this chat","check action text in ongoig chat page after chat invite");
}
public void checkChatTransferRejectText(String module)
{
	deviceTwoCommon.checkActionText(module,"Admin has declined the transfer request.","check action text in ongoig chat page after chat transfer declined by operator 2");
}
public void checkChatTransferAcceptedText(String module)
{
	deviceTwoCommon.checkActionText(module,"Admin has accepted the transfer. This chat has now been transferred to Admin.","check action text in ongoig chat page after chat transfer accepted by operator 2");
}
public void killApplication(String module)
{
	actions.killApplication(module);
}
public void openApplication(String module)
{
	actions.lauchApplicationAfterKill(module);
}
public void openNotification(String module)
{
	actions.openPushNotification(module);
}
public void minimizeApplication(String module)
{
	actions.minimizeApplication(module,"Minimize application");
}
public void redirectToHomePage(String module)
{
	actions.navigateToHomePage(module,"Navigate to home page");
	}
public void checkChatTextOfInvitedOperator(String module,String text)
{
	deviceTwoCommon.checkChatTextOfInvitedOperator(module,text);
}

public void enterChatText(String module,String text)
{
	deviceTwoCommon.enterChatText(module,text);
	
	}
public void sendChatText(String module)
{
	deviceTwoCommon.sendTextToVisitor(module);
	
}
public void clickKebabMenu(String module)
{
	deviceTwoCommon.clickKebabMenu(module);
	}
public void openViewInformation(String module)
{
	deviceTwoCommon.selectMenuFroMKebab(module,"View Information");
}
public void endSessionNow(String module)
{
	deviceTwoCommon.selectMenuFroMKebab(module,"End Now");
}
public void openMoreInformation(String module)
{
	deviceTwoCommon.selectMenuFroMKebab(module,"More Information");
}
public void openChatWithOperator(String module)
{
	deviceTwoCommon.selectMenuFroMKebab(module,"Chat with operator MPTEST");
}
public void clickJoinMenu(String module,String useCase)
{
	deviceTwoCommon.joinWithOperatorForChat(module,useCase);
}

public void backPress(String module)
{
	actions.backPress(module,"Navigate to Homes");
}
public void checkKebabMenuListafterInvite(String module)
{
	String caseName = "check operator2 kebab menu list after Invite  Menu Item :";
	deviceTwoCommon.checkKebabMenuFunctionality(module,"Invite operator",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"View Notes",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"View Information",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"Previous Chats",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"End Session in 30 Secs",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"CRM Information",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"Recent Support Requests",caseName);
}
public void checkKebabMenuInMonitoringOperator(String module)
{
	String caseName = "check operator2 kebab menu in chat monitor menu item :";
	deviceTwoCommon.checkKebabMenuFunctionality(module,"Chat with operator MPTEST",caseName);
}
public void checkKebabMenuListafterTransferChat(String module)
{
	String caseName = "check operator2 kebab menu list after Transfer Menu Item :";
	deviceTwoCommon.checkKebabMenuFunctionality(module,"Block IP",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"Invite operator",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"Transfer this chat",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"View Notes",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"View Information",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"Previous Chats",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"End Session in 30 Secs",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"CRM Information",caseName);
	deviceTwoCommon.checkKebabMenuFunctionality(module,"Recent Support Requests",caseName);
}
public boolean checkTextFieldinChatWindow(String module)
{
	boolean result=false;
	result=deviceTwoCommon.checkEnterTextField(module);

return result;
	}
public void openCannedMessage(String module)
{
	deviceTwoCommon.openCannedMessage(module);
	}
public void checkCannedMessageFromList(String module,String text)
{
	deviceTwoCommon.checkDepartmentNameInCanned(module,text);
}
public void checkViewInformationDepartmentName(String module,String text)
{
	deviceTwoCommon.checkViewInformationDepartment(module,text);
}
public void checkMoreInformationDepartmentName(String module,String text)
{
	deviceTwoCommon.checkmoreInformationDepartment(module,text);
}
public void checkChatTransferNotification(String module)
{
	
	String actualValue="";
	String expectedValue="operator MPTEST has transfered chat to you";
	String caseName="check Transfer Chat notitification text";

try
{
	actualValue = actions.getPageSourceValue("android.view.ViewGroup",6,"android.widget.TextView",2);
	if(!actualValue.isEmpty())
	{
	if(actualValue.equalsIgnoreCase(expectedValue))
	{
		extentreportclass.mobilepassTest(module, caseName);
	}
	else
	{
		extentreportclass.mobilefailTest(driver1,module,caseName);
	}
	}
	
	
}
catch(Exception e)
{
	extentreportclass.mobilefailTest(driver1,module, caseName);
}
	
}

public void checkTransferedText(String module)
{
	deviceTwoCommon.checkInviteChatText(module);
	
	}
public void checkOperatorChatOpen(String module)
{
	deviceTwoCommon.checkOperatorChatPageOpen(module);
	
}


}
