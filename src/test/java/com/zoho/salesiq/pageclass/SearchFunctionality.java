//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.css.ElementCSSInlineStyle;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;

public class SearchFunctionality extends BaseSetup{
	
	private String module = "SearchFunctionality";
	public static ExtentTest etest;
	public static ExtentReports reo;


	CommonActionMobile actions = new CommonActionMobile(driver);
	Extentreportclass extentreportclass=new Extentreportclass();

	public SearchFunctionality(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

	@AndroidFindBy(id = "com.zoho.salesiq:id/search")
	MobileElement searchIcon;

	@AndroidFindBy(id = "com.zoho.salesiq:id/visitname")
	List<MobileElement> visitorNameInVisitorHistoryList;


	@AndroidFindBy(id = "searchid")
	MobileElement visitorHistorySearchIcon;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/search_src_text")
	MobileElement enterSearchText;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/visitorchat_name")
	List<MobileElement> visitorChatName;

	@AndroidFindBy(id = "com.zoho.salesiq:id/visitname")
	List<MobileElement> visitorChatNameVisitorHistory;
	
	@AndroidFindBy(id = "com.zoho.salesiq:id/nosearchtextdescription")
	MobileElement emptyList;
	
	@AndroidFindBy(id = "search_close_btn")
	MobileElement searchCloseButton;
	
	@AndroidFindBy(accessibility = "Collapse‎‏‎‎‏‎")
	MobileElement closeSearchIcon;
	
	
	public void clickSearchIcon(String module)
	{try
		{
		actions.clickAction(searchIcon, module, "Click ON Search Icon");
		}
		catch(Exception e)
		{
			extentreportclass.mobilepassTest(module,"Click ON Search Icon");

		}
		
	}

	public void clickVisitorHistorySearchIcon(String module)
	{try
		{
		actions.clickAction(visitorHistorySearchIcon, module, "Click ON Search Icon");
		}
		catch(Exception e)
		{
			extentreportclass.mobilepassTest(module,"Click ON Search Icon");

		}
		
	}
	public void clickSearchCloseIcon(String module)
	{
		try
		{
		actions.clickAction(searchCloseButton, module, "Click ON Cross icon");
	}
	catch(Exception e)
	{
			extentreportclass.mobilepassTest(module,"Click ON Cross icon");

	}
		
	}
	public void enterSearchText(String module,String searchText)
	{
		try
		{
		actions.actionEnter(enterSearchText, searchText, module, "Enter Search Text to search");
	}
	catch(Exception e)
	{
			extentreportclass.mobilepassTest(module,"Enter Search Text to search");

	}
	}

	public void checkEmptySearchTextField(String useCase,String categories)
	{
		String caseName="Check Search Text should not be persisted in search text field";
		try
		{
	if(enterSearchText.getText().isEmpty())
	{
	extentreportclass.mobilepassTest(useCase,caseName);

	}
	else
	{
		extentreportclass.mobilefailTest(driver,useCase,caseName);
	}

	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,useCase,caseName);

	}
	}
	public void checkSearchResultText(String module,String searchText) {
		boolean searchresult = true;
		
		String searchResult[]=actions.getListofValue(visitorChatName);
		try
		{
		for(String val:searchResult)
		{
			if(val!=null)
			{
			if(val.contains(searchText))
			{
				searchresult=true;
			}
			else {
				searchresult=false;
				extentreportclass.mobilefailTest(driver,module,"Check the search result");
				break;
			}
			}
		}
		if(searchresult)
		{
			extentreportclass.mobilepassTest(module,"Check the search result");
		}
	}

catch(Exception e)
{
	extentreportclass.mobilefailTest(driver,module,"Check the search result");

}
}
	

	public void checkVisitorHistorySearchResult(String module,String searchText) {
		boolean searchresult = true;
		
		String searchResult[]=actions.getListofValue(visitorChatNameVisitorHistory);
		try
		{
		for(String val:searchResult)
		{
			if(val!=null)
			{
			if(val.contains(searchText))
			{
				searchresult=true;
			}
			else {
				searchresult=false;
				extentreportclass.mobilefailTest(driver,module,"Check the search result based on "+ searchText);
				break;
			}
			}
		}
		if(searchresult)
		{
			extentreportclass.mobilepassTest(module,"Check the search result based on "+ searchText);
		}
	}

catch(Exception e)
{
	extentreportclass.mobilefailTest(driver,module,"Check the search result based on "+ searchText);

}
}
	public void checkEmptyList(String module,String expectedText)
	{
		try
		{
		actions.checkText(expectedText, emptyList, module, "Check empty missed chat list after search");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,"Check empty missed chat list after search");

	}
	}
	public void clickSearchCloseButton(String module)
	{
		actions.clickAction(searchCloseButton, module, "Click on Search Close button");
	}
	
	public void afterClickCrossSearchTextShouldHidden(String module)
	{
		try
		{
			if(enterSearchText.getText().isEmpty())
		{
			extentreportclass.mobilepassTest(module,"Check the search result after click on cross");
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module,"Check the search result after click on cross");
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilepassTest(module,"Check the search result after click on cross");
			
		}
		
	}
	
	public void closeSearch(String module)
	{
		try
		{
		actions.clickAction(closeSearchIcon, module, "Close Search icon");
		if(actions.iselemetFound(enterSearchText))
		{
			extentreportclass.mobilefailTest(driver,module,"Check Search text field showing after close search");
			actions.hideKeyboard(module);
			actions.backPress(module, "Back to canned message list");
			
		}
		else {
			extentreportclass.mobilepassTest(module,"Check Search text field showing after close search");
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilepassTest(module,"Check Search text field showing after close search");
			
		}
		
	}
	
	public void closeSearchByClickonCrossIcon(String module)
	{
		try
		{
		clickSearchCloseButton(module);
		actions.hideKeyboard(module);
		String searchText=actions.getElementText(enterSearchText);
		if(actions.elemetListFound(visitorChatName))
		{
			extentreportclass.mobilepassTest(module,"Check after click on cross symbol list should be shown and search text field should be cleared");
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module,"Check after click on cross symbol list should be shown and search text field should be cleared");
			
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,"Check after click on cross symbol list should be shown and search text field should be cleared");

	}
		
		
	}

	public void closeSearchByClickonCrossIconInVisitorHistory(String module)
	{
		try
		{
		clickSearchCloseButton(module);
		String searchText=actions.getElementText(enterSearchText);
		if(searchText.equalsIgnoreCase("Search"))
		{
			extentreportclass.mobilepassTest(module,"Check after click on cross symbol list should be shown and search text field should be cleared actual Text"+searchText);
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module,"Check after click on cross symbol list should be shown and search text field should be cleared actual Text"+searchText);
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,"Check after click on cross symbol list should be shown and search text field should be cleared exception caught");

	}
	
		
		
	}
	
	
	
	
	
	

}
