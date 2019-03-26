//$Id$
package com.zoho.salesiq.Testclass;

import javax.swing.plaf.InsetsUIResource;

import org.openqa.selenium.interactions.Actions;

import com.zoho.salesiq.pageclass.*;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;

public class SearchFunctionalityTest extends BaseSetup {
	SearchFunctionality searchFunctionality = new SearchFunctionality(driver);
	CommonActionMobile actions =new CommonActionMobile(driver);
	
	private String module="Search Functionality";
	
	public void searchFunctionalFlow(String module)
	{
		String validSearch="Automation";
		searchFunctionality.clickSearchIcon(module);
		searchFunctionality.enterSearchText(module,"isfsiuygsdudshfsuhf");
		searchFunctionality.checkEmptyList(module,"Looks like there aren't any records that match the search word specified.");
		searchFunctionality.closeSearchByClickonCrossIcon(module);
		
		searchFunctionality.enterSearchText(module,"Automation");
		searchFunctionality.checkSearchResultText(module,"Automation");
		
//		searchFunctionality.closeSearch();
		
		//issue with Element finding need to work as of now user back press as work around
		actions.backPress(module, "Close search functionality");
		
	}

}
