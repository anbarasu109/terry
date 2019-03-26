//$Id$
package com.zoho.salesiq.pageclass;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import io.appium.java_client.AppiumDriver;

public class VisitorHistoryPage extends BaseSetup {
	private boolean chatHistotryPage;
	private String visitorChatQuestion;
	private String singleChat;
	private String categories ="Visitor History Page";

	private static int LeadScoreVisitorOne;
	private static int LeadScoreVisitorTwo;
	private static  List<String> visitiorInfoDetails = new ArrayList<String>(); 
	CommonActionMobile actions = new CommonActionMobile(driver);

	public VisitorHistoryPage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	SearchFunctionality seachFunctionality = new SearchFunctionality(driver);
	Extentreportclass extentreportclass = new Extentreportclass();
	private KebabMenuFunctionality kebabMenuFunctionality = new KebabMenuFunctionality(driver);
	private BurgerMenuNavigations burgerMenu = new BurgerMenuNavigations(driver);


	@AndroidFindBy(id = "com.zoho.salesiq:id/visitname")
	List<MobileElement> visitorNameInVisitorHistoryList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/timein")
	List<MobileElement> visitorStartedAccessTime;

	@AndroidFindBy(id = "com.zoho.salesiq:id/timespent")
	List<MobileElement> visitorSpentTime;

	@AndroidFindBy(id = "com.zoho.salesiq:id/intime")
	List<MobileElement> accessedTime;

	@AndroidFindBy(id = "com.zoho.salesiq:id/user_name")
	MobileElement visitorNameInHistoryDetails;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact']")
	MobileElement checkCRMTabOpenCheck;


	@AndroidFindBy(id ="com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> visitorInfoTabList;

	@AndroidFindBy(id ="com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> activitiesInfoTabList;

	@AndroidFindBy(id ="com.zoho.salesiq:id/primaryItemText")
	List<MobileElement> crmInfoPageList;


	@AndroidFindBy(id ="com.zoho.salesiq:id/toolbar_spinner")
	MobileElement visitorHistoryDropDown;

	@AndroidFindBy(id = "com.zoho.salesiq:id/text1")
	MobileElement defaultFilterName;

	@AndroidFindBy(id = "com.zoho.salesiq:id/oppotunity_percentage")
	MobileElement leadScorePercentage;

	@AndroidFindBy(id = "com.zoho.salesiq:id/mail")
	MobileElement mailIcon;

	@AndroidFindBy(id = "com.zoho.salesiq:id/phone")
	MobileElement mobileCallIcon;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/toppageshead")
	MobileElement topPagessAccessedHead;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='https://salesiqt.blogspot.com/2018/08/blog-post.html']")
	MobileElement accessedSite;
	
	@AndroidFindBy(id = "android:id/text1")
	List<MobileElement> visitorHistoryFilterList;

	@AndroidFindBy(id = "com.zoho.salesiq:id/primaryItemHeadingText")
	List<MobileElement> activitiesInfoHeadText;

	@AndroidFindBy(className = "android.support.v7.app.ActionBar$Tab")
	List<MobileElement> vsiitorHistoryTab;














	public void checkVisitorHistoryUI(String useCase,String categories)
	{
		String testCase="Check Visitor history UI";
		try{

		actions.isPageOpened(visitorNameInVisitorHistoryList.get(0),useCase,"Check Visitor Namer in visitor history List");
		actions.isPageOpened(visitorStartedAccessTime.get(0),useCase,"Check starting time of visitor accessed site");
		actions.isPageOpened(visitorSpentTime.get(0),useCase,"Check Visitor time spent in visitor history List");
		actions.isPageOpened(accessedTime.get(0),useCase,"Check Visitor accessed time in visitor history List");

		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}
public void checkVisitorHistoryDetailspageOpen(String useCase,String categories)
	{
		String testCase="Verify if operator clicks on Visitor history list, respected visitor history detail page should be shown";
		try{

		actions.isPageOpened(mailIcon,useCase,testCase);
		

		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}

	public void checkMailIconInVisitorHistoryDetailspage(String useCase,String categories)
	{
		String testCase="Verify Mail icon is displaying in Visitor history details page";
		try{

		actions.isPageOpened(mailIcon,useCase,testCase);
		

		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}

	public void checkPhoneIconInVisitorHistoryDetailspage(String useCase,String categories)
	{
		String testCase="Verify phone icon is displaying in Visitor history details page";
		try{

		actions.isPageOpened(mobileCallIcon,useCase,testCase);
		

		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}
	public void checkSendMailIcon(String module,String useCase)
	{
		String testCaseName="Verify Mail Icon is displayed in Visitor history page";
		try
		{		
		MobileElement sendMailIcon=(MobileElement) driver.findElementByImage(actions.convertImageFileToBase64("mailIcon"));
		if(sendMailIcon.isDisplayed())
		{
			extentreportclass.mobilepassTest(useCase, testCaseName);
		}
		else
		{
			extentreportclass.mobilefailTest(driver,useCase, testCaseName);
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,useCase, testCaseName);
		}
	}
	

	public void clickMailIconInVisitorHistoryDetailspage(String useCase,String categories)
	{
		String testCase="Verify if operator clicks on Mail icon in visitor history details page, mail compose page should be shown";
		try{

		actions.clickAction(mailIcon,useCase,testCase);
		

		}catch(Exception e){


			extentreportclass.mobilefailTest(driver,useCase,testCase);

		}
	}



	public void checkVisitorNameInVisitorHistoryList(String useCase,String visitorName)
	{
	String testCase="Verify visitor name should be displayed in Visitor history List page";
	try
	{
	actions.checkText(visitorName,visitorNameInVisitorHistoryList.get(0), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

	public void checkVisitorReferal(String useCase,String categories,String referalValue)
	{
	String testCase="Verify in visitor history list visitor referal type should be "+referalValue;
	try
	{
	actions.checkText(referalValue,visitorSpentTime.get(0),useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

	public void checkVisitorNameInVisitorHistoryDetails(String useCase,String categories)
	{
	String testCase="Verify visitor name should be displayed in Visitor history Details page";
	try
	{	
	actions.checkIntegerValue(visitorNameInHistoryDetails.getText());
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

	public void checkVisitorSiteAccessedTime(String useCase,String categories)
	{
	String testCase="Verify Viistor accessed time in Visitor history visit info tab";
	try
	{
		
	actions.compareText(visitiorInfoDetails.get(2),"1", useCase, testCase);
	}
	catch(Exception e)
	{	
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}
	
	
	public void getVisitorInfoDetailsList()
	{try
	{
		for(MobileElement elem:visitorInfoTabList)
		{
			visitiorInfoDetails.add(elem.getText());
		}
		
		System.out.println("list of values in visitor info tab"+visitiorInfoDetails);
	}
	catch(Exception e)
	{
		System.out.println("Isse in getting visitor details");
	}
	}
	
	public void checkVisitorReferalType(String useCase,String categories,String referalType)
	{
	String testCase="Verify Viistor referal Type in Visitor history visit info tab";
	try
	{
	actions.compareText(visitiorInfoDetails.get(3),referalType,useCase,testCase);
	}
	catch(Exception e)
	{	
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

	public void checkVisitorHistoryListOpenCheck(String useCase,String categories)
	{
	String testCase="Verify visitor History List page should be opened after operator clicks on Visitor History burger menu";
	try
	{
	actions.isPageOpened(visitorHistoryDropDown,useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}


	public void checkVisitorHistoryFilterDefault(String useCase,String defaultFilter)
	{
	String testCase="Verify in Visitor history list page by default "+defaultFilter+" filter should be selelcted" ;
	try
	{
	actions.checkText(defaultFilter,defaultFilterName, useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}


	public void checkVisitorHistoryValueFromList(List<MobileElement> elem,String expectedValue,String useCase,String testCase)
	{

		try{


		actions.checkTextinList(elem,expectedValue, useCase,testCase);
		
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);

	}
	}



	public void checkVisitorHistoryFilterName(String useCase)
	{
	    checkVisitorHistoryValueFromList(visitorHistoryFilterList,"Returning Visitors",useCase,"Verify Returning visitor filter shown in Visitor history filter list");
	    checkVisitorHistoryValueFromList(visitorHistoryFilterList,"All Visitors",useCase,"Verify All Visitors filter shown in Visitor history filter list");
	}


	public void selectSingleVisitorHistory(String useCase,String categories) {
		String testCase="Verify if operator clicks on single Visitor history list Visitor history details page should be shown";
		try {
		MobileElement element = visitorNameInVisitorHistoryList.get(0);
		actions.clickAction(element, useCase,testCase);
		}
		catch (Exception e) {
			// TODO: handle exception
		extentreportclass.mobilepassTest(useCase, testCase);

		}
	}

	public void selectSecondVisitorHistory(String useCase,String categories) {
		String testCase="Verify if operator clicks on Second Visitor history list, Visitor history details page should be shown";
		try {
		MobileElement element = visitorNameInVisitorHistoryList.get(1);
		actions.clickAction(element, useCase,testCase);
		}
		catch (Exception e) {
			// TODO: handle exception
		extentreportclass.mobilepassTest(useCase, testCase);

		}
	}



	public String getVisitorLeadScore() {
		String value=null;
		
		try {
		value=leadScorePercentage.getText();
		}
		catch (Exception e) {
			// TODO: handle exception
		 e.printStackTrace();
		}
		return value;
	}


	public void getVisitorOneLeadScore(String useCase,String categories)
	{
		String testCase="Get the Visitor one Lead score";
		try{

	LeadScoreVisitorOne = Integer.parseInt(getVisitorLeadScore().replaceAll("[^A-Za-z0-9]",""));
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase, testCase);

	}

	}

	public void checkVisitoryListedBasedOnLeadScore(String useCase,String categories)
	{
		String testCase="Verify in Visitor history all visitor will be sorted based on lead score value";
		try
		{
		LeadScoreVisitorTwo=Integer.parseInt(getVisitorLeadScore().replaceAll("[^A-Za-z0-9]",""));

		if(LeadScoreVisitorTwo<LeadScoreVisitorOne)
		{
			extentreportclass.mobilepassTest(useCase, testCase);
		}
		else
		{
			extentreportclass.mobilefailTest(driver,useCase, testCase);
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase, testCase);
		e.printStackTrace();
	}
	}

	public void checkReturningVisitorName(String useCase,String categories,String visitorName)
	{
	String testCase="Check returning visitor filter condition and its value in visitor history";
	try
	{
	actions.checkText(visitorName,visitorNameInVisitorHistoryList.get(0), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}
	

	public void checkAllVisitorName(String useCase,String categories)
	{
	String testCase="Check All visitor Filter condition and its value in visitor history";
	try
	{

	boolean result=actions.checkIntegerValue(visitorNameInVisitorHistoryList.get(0).getText().replaceAll("[^A-Za-z0-9]",""));

if(result)
{
	extentreportclass.mobilepassTest(useCase,testCase);

}
else
{
	extentreportclass.mobilefailTest(driver,useCase,testCase);

}
}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}


	public void checkVisitorHistoryIPAddress(String useCase,String categories)
	{
	String testCase="Check if visitor not updated neither updated name nor initiate chat in visitor hisitor, visitor name should be updated as IP address";
	try
	{

	boolean result=actions.checkIntegerValue(visitorNameInVisitorHistoryList.get(0).getText().replaceAll("[^A-Za-z0-9]",""));

if(result)
{
	extentreportclass.mobilepassTest(useCase,testCase);

}
else
{
	extentreportclass.mobilefailTest(driver,useCase,testCase);

}
}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}


	public void selectFilterFromList(String useCase,String categories,String filterName)
	{
	String testCase="Select "+filterName+" From visitor history filter";
	try
	{

	actions.selectBasedonTextInList(visitorHistoryFilterList,filterName,useCase,testCase);
	
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}


	public void clickVisitorHistroyFilter(String useCase,String categories )
	{
		String testCase="Click on Visitor history dropdown";
		try{

		actions.clickAction(visitorHistoryDropDown,useCase,testCase);

		}catch(Exception e){}
	}

	public void swipeVisitoInfoTab(String useCase,String categories)
	{
		String testCase="Swipe visitor info tab to view information";
	try{
		actions.swipeElementLocation(visitorInfoTabList.get(2),visitorNameInHistoryDetails);
	
		}catch(Exception e){
			extentreportclass.mobilefailTest(driver,useCase,testCase);
		}
	}

	public void checkLeadScoreValue(String useCase,String categories,String expected)
	{
		String testCase="Verify Visitor Lead score in visitor info tab is same as expected";
	try
	{
	actions.compareText(visitiorInfoDetails.get(4),expected,categories, testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}

	}


public void checkVisitorfirstAccessTime(String useCase,String categories)
	{
		String testCase="Verify Visitor First site accessed time/date in visitor info tab is same as expected";
	try
	{
	actions.textContainsText(visitorNameInVisitorHistoryList.get(5),"ago",useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}

	}

public void checkVisitorLastContactType(String useCase,String categories,String contactType)
	{
		String testCase="Verify Visitor Contact type/contact operator should be "+contactType+" in visitor info tab is same as expected";
	try
	{
	actions.compareTextContainsText(visitiorInfoDetails.get(6),contactType,useCase,testCase+visitiorInfoDetails.get(6));
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase+visitiorInfoDetails.get(6));
	}

	}


public void selectVisitorInfoTab(String useCase,String categories)
	{
		String testCase="Select Visitor info tab in Visitor history page";
	try
	{
	actions.clickAction(vsiitorHistoryTab.get(0),useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}

	}

public void selectCRMInfoTab(String useCase,String categories)
	{
		String testCase="Select CRM info tab in Visitor history page";
	try
	{
	actions.clickAction(vsiitorHistoryTab.get(2),useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}

	}

public void selectActivitiesInfoTab(String useCase,String categories)
	{
		String testCase="Select CRM info tab in Visitor history page";
	try
	{
	actions.clickAction(vsiitorHistoryTab.get(1),useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}

	}

public void checkActivitiesInfoList(String useCase,String categories)
	{
	String testCase="Verify Activities info contains expected information shown";
	try
	{
	actions.checkText("Frequency of Visits",activitiesInfoHeadText.get(0), useCase,"Verify frequency of Visits header shown in activities info");
	actions.checkText("Number of Visits this Week",activitiesInfoHeadText.get(1), useCase,"Verify Number of Visits this Week header shown in activities info");
	actions.checkText("Referred by",activitiesInfoHeadText.get(2), useCase,"Verify Referred by header shown in activities info");
	//Top pages visisted element not found so swipe option include in this case
	//actions.swipeElementLocation(activitiesInfoTabList.get(3),activitiesInfoTabList.get(2));
	actions.checkText("Top Pages Visited",topPagessAccessedHead, useCase,"Verify Top Pages Visited header shown in activities info");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}


public void checkFrequencyOfVisitsInActivitiesInfo(String useCase,String categories,String frequencyOfVisits)
	{
	String testCase="Verify frequnecy of Visits in Activities info tab";
	try
	{
	actions.checkText(frequencyOfVisits,activitiesInfoTabList.get(0), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

public void checknumberOfvisitsInActivitiesInfo(String useCase,String categories,String numberOfVisits)
	{
	String testCase="Verify Number of visits in Activities info tab";
	try
	{
	actions.checkText(numberOfVisits,activitiesInfoTabList.get(1), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

public void checkReferedByInActivitiesInfo(String useCase,String categories,String referredBy)
	{
	String testCase="Verify Referred by in Activities info tab";
	try
	{
	actions.checkText(referredBy,activitiesInfoTabList.get(2), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

public void checkAccessedSiteInActivitiesInfo(String useCase,String categories,String topAccessedSite)
	{
	String testCase="Verify top accessed sites in Activities info tab";
	try
	{
	actions.swipeElementLocation(activitiesInfoTabList.get(3),activitiesInfoTabList.get(2));
	actions.checkText(topAccessedSite,accessedSite, useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

	public void checkCRMVsitorName(String useCase,String categories,String visitorName)
	{
	String testCase="Verify visitor CRM First name should be as expected";
	try
	{
	actions.checkText(visitorName,crmInfoPageList.get(0), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

	public void checkCRMVsitorEmail(String useCase,String categories,String emailID)
	{
	String testCase="Verify visitor CRM Visitor emailID should be as expected";
	try
	{
	actions.checkText(emailID,crmInfoPageList.get(1), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}
public void checkCRMVsitorContactOwner(String useCase,String categories,String contactOwner)
	{
	String testCase="Verify visitor CRM Visitor Contact owner should be as expected";
	try
	{
	actions.checkText(contactOwner,crmInfoPageList.get(2), useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}

public void checkCRMTypeTabOpen(String useCase,String categories)
	{
	String testCase="Verify if operator clicks on CRM Type tab CRM information should open";
	try
	{
	actions.isPageOpened(checkCRMTabOpenCheck,useCase,testCase);
	}
	catch(Exception e)
	{
		
		extentreportclass.mobilefailTest(driver,useCase,testCase);
	}
	}




	














































}
