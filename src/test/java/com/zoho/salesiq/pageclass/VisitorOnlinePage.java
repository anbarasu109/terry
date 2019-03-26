//$Id$
package com.zoho.salesiq.pageclass;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.helpers.AbstractUnmarshallerImpl;

//import org.apache.commons.validator.routines.checkdigit.ISBN10CheckDigit;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.pageclass.BaseSetupWeb;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.BurgerMenuNavigations;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class VisitorOnlinePage extends BaseSetup {
	private String module = "Visitor Online Page";
	CommonActionMobile actions = new CommonActionMobile(driver);
	BaseSetupWeb baseSetupWeb = new BaseSetupWeb();
	Extentreportclass extentreportclass = new Extentreportclass();
	BurgerMenuNavigations burgerMenu = new BurgerMenuNavigations(driver);
	int previousCount;
	private Boolean islistPageOpen;
	private boolean footPathPageOpen;

	public VisitorOnlinePage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.zoho.salesiq:id/headingtext")
	@CacheLookup
	MobileElement onlineemptypageHeader;

	@AndroidFindBy(id = "com.zoho.salesiq:id/emptytext")
	@CacheLookup
	MobileElement onlineemptypageContent;

	@AndroidFindBy(id = "com.zoho.salesiq:id/listbutton")
	@CacheLookup
	MobileElement listPageNavigation;

	@AndroidFindBy(id = "com.zoho.salesiq:id/ringbutton")
	@CacheLookup
	MobileElement ringPageNavigation;

	@AndroidFindBy(id = "com.zoho.salesiq:id/search_src_text")
	@CacheLookup
	MobileElement searchTextEnter;
	@AndroidFindBy(id = "com.zoho.salesiq:id/cvg")
	@CacheLookup
	MobileElement visitorOnlineRingContainer;

	@AndroidFindBy(id = "‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‏‎‏‏‎‎‏‏‎‎‏‏‏‎‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‏‎‏‎‎‏‎‎‎‎‏‎‎‎‏‏‎‏‏‏‏‎‎‎‎‎‎‎‎‎‎‏‎‎‏‎Clear query‎‏‎‎‏‎")
	@CacheLookup
	MobileElement clearSearch;

	@AndroidFindBy(id = "path_action_text")
	List<MobileElement> footPathAction;

	@AndroidFindBy(accessibility = "Collapse‎‏‎‎‏‎")
	@CacheLookup
	MobileElement searchBack;

	@AndroidFindBy(id = "title")
	List<MobileElement> kebabMenuList;

	// Filter Name
	@AndroidFindBy(id = "com.zoho.salesiq:id/header_text")
	@CacheLookup
	List<MobileElement> headerText;

	@AndroidFindBy(id = "com.zoho.salesiq:id/visits_chats")
	@CacheLookup
	MobileElement repatedUserStar;

	@AndroidFindBy(id = "com.zoho.salesiq:id/visitname")
	@CacheLookup
	List<MobileElement> visitorName;

	@AndroidFindBy(id = "com.zoho.salesiq:id/pageurl")
	@CacheLookup
	List<MobileElement> visitorAccessURL;

	@AndroidFindBy(id = "com.zoho.salesiq:id/intime")
	@CacheLookup
	List<MobileElement> visitorAccessTime;

	// details will be vary for both new and repeated Visitor
	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemText")
	@CacheLookup
	List<MobileElement> visitorDetails;

	// Available only for repeated user if mail id given
	@AndroidFindBy(id = "com.zoho.salesiq:id/actionicon")
	@CacheLookup
	MobileElement sendMail;

	@AndroidFindBy(accessibility = "More options")
	MobileElement advanceMenu;

	// Advance Menu List
	@AndroidFindBy(id = "com.zoho.salesiq:id/title")
	@CacheLookup
	List<MobileElement> advancemenuItems;

	// Get the List of all the foot Path informations
	@AndroidFindBy(id = "com.zoho.salesiq:id/path_action_text")
	@CacheLookup
	List<MobileElement> footPathInformation;

	@AndroidFindBy(id = "com.zoho.salesiq:id/path_action_time")
	@CacheLookup
	List<MobileElement> footpathTime;

	@AndroidFindBy(id = "com.zoho.salesiq:id/previouschat_attender")
	@CacheLookup
	List<MobileElement> previousUserChats;

	@AndroidFindBy(id = "com.zoho.salesiq:id/previouschat_question")
	@CacheLookup
	List<MobileElement> previousUserQuestions;

	@AndroidFindBy(id = "com.zoho.salesiq:id/previouschat_time")
	@CacheLookup
	List<MobileElement> previousChatTime;

	// Date info text for Previoius chat details page
	@AndroidFindBy(id = "com.zoho.salesiq:id/dateinfotextview")
	@CacheLookup
	List<MobileElement> dateinforText;

	// participant name list
	@AndroidFindBy(id = "com.zoho.salesiq:id/msg_name")
	@CacheLookup
	List<MobileElement> participantName;

	@AndroidFindBy(id = "com.zoho.salesiq:id/showmsg")
	@CacheLookup
	List<MobileElement> chatConversationText;

	@AndroidFindBy(id = "com.zoho.salesiq:id/msg_time")
	@CacheLookup
	List<MobileElement> chatConversationTime;

	@AndroidFindBy(id = "com.zoho.salesiq:id/userpicleft")
	@CacheLookup
	List<MobileElement> visitorProfilePic;

	@AndroidFindBy(id = "com.zoho.salesiq:id/userpicright")
	@CacheLookup
	List<MobileElement> operatorProfilePic;

	@AndroidFindBy(id = "com.zoho.salesiq:id/attach_image")
	@CacheLookup
	MobileElement imageAttachment;

	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemText")
	@CacheLookup
	List<MobileElement> crmInformationList;

	// CRM Application Open Locator
	@AndroidFindBy(id = "com.zoho.salesiq:id/actionicon")
	@CacheLookup
	MobileElement crmApplicationOpen;

	// Location otherthan CRM open application
	@AndroidFindBy(id = "com.zoho.salesiq:id/actioniconLayout")
	@CacheLookup
	MobileElement otherLocationCRMicon;

	// POPUP Cancel for CRM application download if app not Download
	@AndroidFindBy(id = "com.zoho.salesiq:id/cancel_button")
	@CacheLookup
	MobileElement cancelDownload;

	@AndroidFindBy(id = "com.zoho.salesiq:id/ok_button")
	@CacheLookup
	MobileElement crmDownload;

	@AndroidFindBy(id = "com.zoho.salesiq:id/prompt_message")
	@CacheLookup
	MobileElement popupMessageCRM;

	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemText")
	@CacheLookup
	List<MobileElement> moreInformation;

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	@CacheLookup
	MobileElement visitorDetailsName;

	@AndroidFindBy(id = "com.zoho.salesiq:id/item_circle")
	List<MobileElement> visitorCountinMenu;

	@AndroidFindBy(className = "android.widget.TextView")
	List<MobileElement> visitorOnlineDetailsList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/alertTitle")
	MobileElement chooseDepartmentPopupTitle;

	@AndroidFindBy(id = "com.zoho.salesiq:id/simple_text")
	List<MobileElement> chooseDepartment;

	@AndroidFindBy(id = "com.zoho.salesiq:id/msgEditText")
	MobileElement chatText;

	@AndroidFindBy(id = "com.zoho.salesiq:id/ringbutton")
	MobileElement ringButton;

	@AndroidFindBy(id = "com.zoho.salesiq:id/listbutton")
	MobileElement listButton;

	@AndroidFindBy(id = "com.zoho.salesiq:id/search")
	MobileElement searchIcon;

	@AndroidFindBy(id = "com.zoho.salesiq:id/fab")
	MobileElement initiateChatIcon;

	@AndroidFindBy(id = "com.zoho.salesiq:id/header_text")
	List<MobileElement> filterText;

	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> visitorOnlineDetails;

	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> visitorOnlineDetailsRepeatedVisitor;

	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> moreInformationList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/item_view")
	List<MobileElement> itemListOnline;

	public void checkOnlineVisitorCountMenu(String module) throws InterruptedException {

		// get the count of visitor from Ongoing Menu
		try
		{
		int currentVisitcount = burgerMenu.checkOnlineUserCountInMenu();

		int expected = previousCount + 1;

		actions.compareIntegerValue(currentVisitcount, expected, "Visitor Count displayed in Ongoing Menu");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Visitor Count displayed in Ongoing Menu");

	}
	}
	
	
	
	public void checkRingOne()
	{
		Point point=visitorOnlineRingContainer.findElementsByClassName("android.view.View").get(1).getLocation();
	}

	public void checkVisitorCountBeforeAccess(String module) {
		try
		{
			
		previousCount = burgerMenu.checkOnlineUserCountInMenu();
		}
		catch(Exception e)
		{
			previousCount = 0;
		}
	}

	public void checkvisitoDetailsPageOpen(String module) {
		try {
			Boolean check = actions.isPageOpened(visitorOnlineDetailsList.get(0), module,
					"Check visitor Name in List Details Page");
			if (check) {
				actions.navigateToHomePage("Navigate to home page");
			}
		} catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Name is not found in the list");
		}
	}

	public void initiateChatPageOpenCheck(String module) {
		try
		{

		actions.isPageOpened(chooseDepartmentPopupTitle, module, "Check initiate chat page is opened");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check initiate chat page is opened");
		}
	}

	public void checkDepartmentNameinDropdown(String module,String departmentName) {
		try{

		actions.checkTextinList(chooseDepartment, departmentName, module,"Check" + departmentName + "in the dropdownlist");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,"Check" + departmentName + "in the dropdownlist");

		}
				
	}

	public void selectDepartmentFromList(String module,String departmentName) {
		try{

		actions.selectBasedonTextInList(chooseDepartment, departmentName, module,"Select" + departmentName + "from the list");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,"Select" + departmentName + "from the list");

		}
	}

	public void checkChatPageAfterSelectDepartment(String module) {
		try
		{

		actions.isPageOpened(chatText, module, "Check chat page is opened");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,"Check chat page is opened");
		}

	}

	public void openFirstListinOnline(String module) {
		if (islistPageOpen) {
			try {
				actions.clickAction(itemListOnline.get(0), module, "Open single Online Visitor and open Details page");
			} catch (Exception e) {

			}
		}
	}
	public void checkVisitorOnlineAfterLeftSite(String module)
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver,50); 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.zoho.salesiq:id/item_view")));
		
		if(itemListOnline.size()<=0)
		{
			extentreportclass.mobilepassTest(module, "Visitor should be hidden in applcication if visitor left site");

		} else {
			extentreportclass.mobilefailTest(driver,module, "Visitor should be hidden in applcication if visitor left site");
		}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "Visitor should be hidden in applcication if visitor left site");

		}
		
	}
	
	
	
	
	
	
	
	
	
	

	public void checkVisitorCountAfterKillandOpen(String module) {
		try
		{
		int value = burgerMenu.checkOnlineUserCountInMenu();

		if (value == previousCount) {
			extentreportclass.mobilepassTest(module, "Visitor count is same after kill and open application");
		} else {
			extentreportclass.mobilefailTest(driver,module, "Visitor count is changed after kill and open application");
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Visitor count is changed after kill and open application");

	}
	}

	public void checkRingandListIcon(String module) {
		try
		{
		if (ringButton.isDisplayed() && listButton.isDisplayed()) {
			extentreportclass.mobilepassTest(module, "Check ring and list button shown");

		} else {
			extentreportclass.mobilefailTest(driver,module, "Check ring and list button shown");
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Check ring and list button shown");

	}
	}

	public void openOnlineListPage(String module) {
		try
		{
		actions.clickAction(listButton, module, "Click on ListIcon");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Click on ListIcon");
	}
	}

	public void openOnlineRingPage(String module) {
		try
		{
		actions.clickAction(ringButton, module, "Click on Ring Button");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Click on Ring Button");

	}
	}

	public void checkListPageOpen(String module) {
		try
		{
		islistPageOpen = actions.isPageOpened(searchIcon, module, "Check List page is opened");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Check List page is opened");

	}
	}

	public void checkTimeFilterBasedCondition(String module) {
		if (islistPageOpen) {
			String filterTextValue = "";
			try {
				MobileElement elem = filterText.get(0);
				filterTextValue = elem.getText();

				
				long diff = actions.checkTimeDifferenceMinute();
				if (!filterTextValue.isEmpty()) {
					if (diff <= 1) {
						actions.compareText(filterTextValue, "Spent more than 0 Seconds", module,
								"Check the filter value in Visitor Online list");
					} else if (diff > 1 && diff < 3) {
						actions.compareText(filterTextValue, "Spent more than 1 Minute", module,
								"Check the filter value in Visitor Online list");

					} else if (diff > 3 && diff < 10) {
						actions.compareText(filterTextValue, "Spent more than 3 Minutes", module,
								"Check the filter value in Visitor Online list");

					} else if (diff > 10) {
						actions.compareText(filterTextValue, "Spent more than 10 Minutes", module,
								"Check the filter value in Visitor Online list");

					} else {
						actions.compareText(filterTextValue, "Cold Visitors", module,
								"Check the filter value in Visitor Online list");

					}
				} else {
					extentreportclass.mobilefailTest(driver,module, "Visitor Online Filter check");
				}
			} catch (IndexOutOfBoundsException e) {
				extentreportclass.mobilefailTest(driver,module, "Visitor Online Filter check");
			}
		} else {
			extentreportclass.mobilefailTest(driver,module, "Online list page not opened or visitor not shown in list");
		}
	}

	public void checkVisitorNameinDetails(String module,String visitorNameinList) {
		try {
			if (islistPageOpen) {
				extentreportclass.mobilepassTest(module, "Visitor Online list page is not opened");
			}
			else
			{
				extentreportclass.mobilefailTest(driver,module, "Visitor Online list page is not opened");
			}
		} catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Online list page is not opened");
		}

	}

	public void checkVisitorAccessedURL(String module,String pageURL) {
		try {
			if (islistPageOpen) {
				actions.checkText(pageURL, visitorAccessURL.get(0), module, "Check Visitor Accessed site in the list");
			}
		} catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Visitor Online list page is not opened");
		}

	}

	public void checkNewUserTimeOnSite(String module,String timeOnSite) {
		try {
			if (islistPageOpen) {
				actions.checkText(timeOnSite, visitorOnlineDetails.get(0), module, "Check Visitor Time On Site");
			}
		} catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Visitor Time On Site");
		}

	}

	public void checkNewUserNumberOfVisit(String module,String numberOfVisit) {
		try {
			if (islistPageOpen) {
				actions.checkText(numberOfVisit, visitorOnlineDetails.get(1), module,
						"Check New Visitor Number Of Visit");
			}
		} catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Visitor Number Of Visit");
		}

	}

	public void checkNewUserLocation(String module,String location) {
		try {
			if (islistPageOpen) {
				actions.checkText(location, visitorOnlineDetails.get(2), module, "Check New Visitor Location");
			}
		} catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Visitor Location");
		}

	}

	public void checkNewUserCurrentPage(String module,String currentPage) {
		try {
			if (islistPageOpen) {
				actions.checkText(currentPage, visitorOnlineDetails.get(3), module, "Check New Visitor Current Page");
			}
		} catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check New Visitor Current Page");
		}

	}

	public void checkNewUserReferral(String module,String referralType) {
		try {
			if (islistPageOpen) {
				actions.checkText(referralType, visitorOnlineDetails.get(4), module, "Check New Visitor Referral type");
			}
		} catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check New Visitor Referral type");
		}

	}

	public void moreinFormationForNewVisitor(String module,String moreinfo[]) {
		int i;
		if (islistPageOpen) {
			try {
				String Value[] = actions.getListofValue(moreInformationList);

				for (i = 0; i < Value.length; i++) {
					if (Value[i].equalsIgnoreCase(moreinfo[i])) {
						extentreportclass.mobilepassTest(module,
								"MoreInformation list check in Visitor Online" + Value[i]);
					} else {
						extentreportclass.mobilefailTest(driver,module,
								"MoreInformation list check in Visitor Online" + Value[i]);

					}
				}
			} catch (IndexOutOfBoundsException | org.openqa.selenium.NoSuchElementException e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "Check New Visitor Referral type");
			} catch (NullPointerException e) {
				extentreportclass.mobilefailTest(driver,module, "Check New Visitor Referral type");

			}
		}

	}

	public void chatInitiateByClick(String module) {
		try {
			if (islistPageOpen) {
				actions.clickAction(initiateChatIcon, module, "Click on Chat icon");

			}
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check New Visitor Referral type");
		}

	}

	public void checkTextInKebabMenu(String module) {
		try {
			actions.checkTextinList(kebabMenuList, "Foot Path", module, "Check menu text in Kebab Menu List");
			actions.checkTextinList(kebabMenuList, "More Information", module, "Check menu text in Kebab Menu List");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check menu text in Kebab Menu List");
		}

	}

	public void checkFootPathPageOpen(String module) {
		try {
			footPathPageOpen = actions.isPageOpened(footPathAction.get(0), module, "Check footPath action page open");

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check footPath action page open");
		}
	}

	public void footPathAction(String module) {
		try {
			actions.checkTextinList(footPathAction, "salesiqtest", module, "Check footPath action");

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check footPath action");
		}

	}

	public void checkEmailIdRepeatedUserDetailsPage(String module,String emailId) {
		try {
			actions.checkText(emailId, visitorOnlineDetailsRepeatedVisitor.get(0), module,
					"Check Repeated Visitor Mail id");

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Repeated Visitor Mail id");
		}
	}

	public void checkRepeatedNumberOfVisit(String module,String numberOfVisit) {
		try {
			actions.checkText(numberOfVisit, visitorOnlineDetailsRepeatedVisitor.get(2), module,
					"Check Repeated Visitor Number of Visit");

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Repeated Visitor Number of Visit");
		}
	}

	public void checkRepeatedNumberOfChat(String module,String numberOfChat) {
		try {
			actions.checkText(numberOfChat, visitorOnlineDetailsRepeatedVisitor.get(3), module,
					"Check Repeated Visitor Number of Chat");

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Repeated Visitor Number of Chat");
		}
	}

	public void checkRepeatedLocation(String module) {
		try {
			actions.checkText("Chennai , Tamil Nadu , India", visitorOnlineDetailsRepeatedVisitor.get(4), module,
					"Check Repeated Visitor Number of Chat");

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Repeated Visitor Number of Chat");
		}
	}

	public void checkRepeatedCurrentPage(String module) {
		try {
			actions.checkText("salesiqtest", visitorOnlineDetailsRepeatedVisitor.get(5), module,
					"Check Repeated Visitor current access page");
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Repeated Visitor current access page");
		}
	}

	public void checkRepeatedReferralType(String module) {
		try {
			actions.checkText("Direct Traffic", visitorOnlineDetailsRepeatedVisitor.get(7), module,
					"Check Repeated Visitor access page type");

		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Repeated Visitor access page type");
		}
	}

	public void clickRingOne(String module,String expectedAction) {
		try {
			
			
			Point point=visitorOnlineRingContainer.findElementsByClassName("android.view.View").get(3).getCenter()	;
			
			int xValue = point.x;
			int yValue =point.y;
			actions.clickBasedonCoordinate(xValue, yValue);
			boolean RingOne = false;
			RingOne = actions.isPageOpen(searchIcon);
			if (RingOne == true && expectedAction.equalsIgnoreCase("Should Clickable")) {
				extentreportclass.mobilepassTest(module, "RingOne" + expectedAction + "Pass");
				actions.backPress(module,"Navigate to Home");
			} else if (RingOne == false && expectedAction.equalsIgnoreCase("Shouldnot Clickable")) {
				extentreportclass.mobilepassTest(module, "RingOne" + expectedAction + "Pass");
			} else {
				extentreportclass.mobilefailTest(driver,module, "RingOne" + expectedAction + "Fail");

			}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "RingOne" + expectedAction + "Fail");

		}
	}

	public void clickRingTwo(String module,String expectedAction) {
		try {
			Point point=visitorOnlineRingContainer.findElementsByClassName("android.view.View").get(5).getCenter();
			int xValue = point.x;
			int yValue =point.y;
			actions.clickBasedonCoordinate(xValue, yValue);
			boolean RingTwo = false;
			RingTwo = actions.isPageOpen(searchIcon);
			if (RingTwo == true && expectedAction.equalsIgnoreCase("Should Clickable")) {
				extentreportclass.mobilepassTest(module, "RingTwo" + expectedAction + "Pass");
				actions.backPress(module,"Navigate to Home");
			} else if (RingTwo == false && expectedAction.equalsIgnoreCase("Shouldnot Clickable")) {
				extentreportclass.mobilepassTest(module, "RingTwo" + expectedAction + "Pass");
			} else {
				extentreportclass.mobilefailTest(driver,module, "RingTwo" + expectedAction + "Fail");

			}
		} catch (Exception e) {
			
			extentreportclass.mobilefailTest(driver,module, "RingTwo" + expectedAction + "Fail");
		}
	}

	public void clickRingThree(String module,String expectedAction) {
		try {
			
			Point point=visitorOnlineRingContainer.findElementsByClassName("android.view.View").get(4).getCenter();
			int xValue = point.x;
			int yValue =point.y;
			actions.clickBasedonCoordinate(xValue, yValue);
			boolean RingThree = false;
			RingThree = actions.isPageOpen(searchIcon);
			if (RingThree == true && expectedAction.equalsIgnoreCase("Should Clickable")) {
				extentreportclass.mobilepassTest(module, "RingThree" + expectedAction + "Pass");
				actions.backPress(module,"Navigate to Home");
			} else if (RingThree == false && expectedAction.equalsIgnoreCase("Shouldnot Clickable")) {
				extentreportclass.mobilepassTest(module, "RingThree" + expectedAction + "Pass");
			} else {
				extentreportclass.mobilefailTest(driver,module, "RingThree" + expectedAction + "Fail");

			}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "RingThree" + expectedAction + "Fail");

		}
	}

	public void clickRingFour(String module,String expectedAction) {
		try {
			Point point=visitorOnlineRingContainer.findElementsByClassName("android.view.View").get(1).getCenter();
			int xValue = point.x;
			int yValue =point.y;
			actions.clickBasedonCoordinate(xValue, yValue);
			boolean RingFour = false;
			RingFour = actions.isPageOpen(searchIcon);
			if (RingFour == true && expectedAction.equalsIgnoreCase("Should Clickable")) {
				extentreportclass.mobilepassTest(module, "RingFour" + expectedAction + "Pass");
				actions.backPress(module,"Navigate to Home");
			} else if (RingFour == false && expectedAction.equalsIgnoreCase("Shouldnot Clickable")) {
				extentreportclass.mobilepassTest(module, "RingFour" + expectedAction + "Pass");
			} else {
				extentreportclass.mobilefailTest(driver,module, "RingFour" + expectedAction + "Fail");

			}
		} catch (Exception e) {

		}
	}
	
	
	public void checkListAndRingIcon(String module,String UseCase)
	{
		String testCaseName="Verify List and Ring icon is displayed in Online page";
		try
		{
		
		MobileElement lisIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("ListIcon"));
		MobileElement ringIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("RingIcon"));
		if(lisIcon.isDisplayed()&&ringIcon.isDisplayed())
		{
			extentreportclass.mobilepassTest(UseCase,testCaseName);
		}
		else
		{
			extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
		}
		
	}
	
	public void checkVisitorOnlineRing(String module,String UseCase)
	{
		String testCaseName="Verify all Visitor Online displaying correctly";
		try
		{
		
		MobileElement ringOne=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("TenMinRing"));
		MobileElement ringTwo=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("ThreeMinRing"));
		MobileElement ringThree=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("oneminRIng"));
		MobileElement ringFour=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("ZeroSecRing"));
		if(ringOne.isDisplayed()&&ringTwo.isDisplayed()&&ringThree.isDisplayed()&&ringFour.isDisplayed())
		{
			extentreportclass.mobilepassTest(UseCase,testCaseName);
		}
		else
		{
			extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
		}
		
	}
	public void checkSiteAccessTypeIcon(String module,String UseCase)
	{
		String testCaseName="Verify Visitor acccess type is direct based on Icon";
		try
		{
			
			MobileElement lisIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("directIcon"));
			if(lisIcon.isDisplayed())
			{
				extentreportclass.mobilepassTest(UseCase,testCaseName);
			}
			else
			{
				extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
			}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
		}
		
	}
	public void checkOperatorInitiateChatIcon(String module,String UseCase)
	{
		String testCaseName="Verify Operator initiate chat icon present in Visitor online details page";
		try
		{
			
			MobileElement lisIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("OperatorChatinitiateIcon"));
			if(lisIcon.isDisplayed())
			{
				extentreportclass.mobilepassTest(UseCase,testCaseName);
			}
			else
			{
				extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
			}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,UseCase,testCaseName);
		}
		
	}

	public void clickColdVisitor(String module,String expectedAction) {
		boolean coldVisitor = false;
		try {

			Point point=visitorOnlineRingContainer.findElementsByClassName("android.view.View").get(2).getCenter();
		
			int xValue = point.x;
			int yValue =point.y;
			actions.clickBasedonCoordinate(xValue, yValue);
			coldVisitor = actions.isPageOpen(searchIcon);
			
			actions.backPress(module,"Navigate to Home");
			if (coldVisitor == true && expectedAction.equalsIgnoreCase("Should Clickable")) {
				extentreportclass.mobilepassTest(module, "Cold Visitor" + expectedAction + "Pass");
				actions.backPress(module,"Navigate to Home");
			} else if (coldVisitor == false && expectedAction.equalsIgnoreCase("Shouldnot Clickable")) {
				extentreportclass.mobilepassTest(module, "Cold Visitor" + expectedAction + "Pass");
			} else {
				extentreportclass.mobilefailTest(driver,module, "Cold Visitor" + expectedAction + "Fail");

			}
		} catch (Exception e) {
			extentreportclass.mobilefailTest(driver,module, "Cold Visitor" + expectedAction + "Fail");


		}

	}

	public void checkRequiredUIinOnlineList(String module) {
		try
		{
		Boolean name = actions.isPageOpen(visitorName.get(0));
		Boolean site = actions.isPageOpen(visitorAccessURL.get(0));
		if (name == true && site == true) {
			extentreportclass.mobilepassTest(module, "Check UI in Online List page");
		} else {
			extentreportclass.mobilefailTest(driver,module, "Check UI in Online List page");
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Check UI in Online List page");
	}

	}

	public void checkRandomValueForNewVisitor(String module) {
		try {
			String textValue=visitorName.get(0).getText();
			Boolean result = actions.checkIntegerValue(textValue);
			if (result) {
				extentreportclass.mobilepassTest(module, "Check random value for new visitor");

			} else {
				extentreportclass.mobilefailTest(driver,module, "Check Random value of new visitor");
			}
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Check Random value of new visitor");
		}
	}

	public void checkCRMMenuUpdated(String module)
	{
		actions.checkTextinList(kebabMenuList,"CRM Information",module, "check CRM menu shown in Menu list after updated mail id");
	
	}

	public void checkCreatePotentialNotShown(String module) {
		boolean result = actions.isPageOpen(advanceMenu);
		if (result) {
			extentreportclass.mobilefailTest(driver,module, "Check create potetial menu");

		} else {
			extentreportclass.mobilefailTest(driver,module, "Check create potetial menu");

		}
	}
	
	public void checkVisitorRingOneAccess(String module)
	{
		long diff = actions.checkTimeDifference();
		System.out.println("RingOne Difference testing"+diff);
		System.out.println("Ring one difference check"+diff);
		if(diff>600)
		{
			clickRingOne(module,"Should Clickable");
		}
		else
		{
			clickRingOne(module,"ShouldNot Clickable");
		}
	}
	public void checkVisitorRingTwoAccess(String module)
	{
		long diff = actions.checkTimeDifference();

		System.out.println("Ring two difference check"+diff);
		if(diff>180 && diff< 600)
		{
			clickRingTwo(module,"Should Clickable");
		}
		else
		{
			clickRingTwo(module,"ShouldNot Clickable");
		}
	}
	public void checkVisitorRingThreeAccess(String module)
	{
		long diff = actions.checkTimeDifference();
		System.out.println("Ring three difference check"+diff);
		if(diff>60 && diff< 180)
		{
			clickRingThree(module,"Should Clickable");
		}
		else
		{
			clickRingThree(module,"ShouldNot Clickable");
		}
	}
	public void checkVisitorRingFourAccess(String module)
	{
		long diff = actions.checkTimeDifference();
		System.out.println("Ring four difference check"+diff);
		if(diff>0 && diff< 60)
		{
			clickRingFour(module,"Should Clickable");
		}
		else
		{
			clickRingFour(module,"ShouldNot Clickable");
		}
	}
	
	
	
	
	
	

}