//$Id$
package com.zoho.salesiq.pageclass;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.Notificatiofucntionality;
import com.zoho.salesiq.pageclass.ViewInformationFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.Testclass.VisitorSiteAccessTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class NotesFunctionality extends BaseSetup {
	CommonActionMobile actions=new CommonActionMobile(driver);
	private String module="NotesFunctionality";
	Extentreportclass extentreportclass = new Extentreportclass();
	VisitorSiteAccessTest visitorSiteAccessTest=new VisitorSiteAccessTest();
	public static String notesView="";
	
	public NotesFunctionality(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id = "fab")
	MobileElement createNewNotesIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	MobileElement viewNotesPageCheck;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
	MobileElement operatorNameInViewNotes;
	
	@AndroidFindBy(id = "visitorchat_name")
	List<MobileElement> viewNotesInfo;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	MobileElement addNotes;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
	MobileElement operatorNameInAddNotes;
	
	@AndroidFindBy(id = "editnotes")
	MobileElement editNotes;
	
	@AndroidFindBy(id = "action_save_note")
	MobileElement saveNotes;
	
	@AndroidFindBy(id = "visitorchat_name")
	List<MobileElement> notesHistory;
	
	@AndroidFindBy(id = "visitorchat_question")
	List<MobileElement> visitorNotes;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	MobileElement notesDetailsVisitorName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
	MobileElement notesDetailsOperatorName;
	
	@AndroidFindBy(id = "viewnotes")
	MobileElement notesDetailsText;
	
	
	
	
	public void clickAddNotesIcon(String module)
	{
		String caseName = "Click on Add notes Icon";
		try
		{
		actions.clickAction(createNewNotesIcon, module,caseName);
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
			
		}
	}
	
	public void checkViewNotesPageOpen(String module)
	{
		String caseName = "Check View Notes page nagigation";
		String NotesPage="";
		try
		{
		 NotesPage=actions.getElementText(viewNotesPageCheck);
		if (NotesPage.equalsIgnoreCase("Notes")) {
			extentreportclass.mobilepassTest(module,caseName );
			
		}
		else {
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}
	
	public void checkAddNotesPageOpen(String module)
	{
		try
		{
		String NotesPage=actions.getElementText(addNotes);
		if (NotesPage.equalsIgnoreCase("Add a Note")) {
			extentreportclass.mobilepassTest(module, "Check View Notes page check and page nagigation check");
			
		}
		else {
			extentreportclass.mobilefailTest(driver,module, "Check View Notes page check and page nagigation check");
		}
	}
	catch(Exception e)
	{


		extentreportclass.mobilefailTest(driver,module, "Check View Notes page check and page nagigation check");
	}
	}
	public void visitorNameInViewNotesPage(String module)
	{
		try{
		String visitorName = visitorSiteAccessTest.visitorName;
		actions.checkText(visitorName,operatorNameInViewNotes,module,"Check Visitor Name in ViewNptes Page");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Check Visitor Name in ViewNptes Page");

	}
	
	}
	
	public void visitorNameInAddNotesPage(String module)
	{
		try
		{
		String visitorName = visitorSiteAccessTest.visitorName;
		actions.checkText(visitorName,operatorNameInAddNotes,module,"Check Visitor Name in AddNotes Page");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Check Visitor Name in AddNotes Page");	
	}
		
	}
	
	public void enterNotes(String module,String enterNotes)
	{
		try
		{
		actions.actionEnter(editNotes, enterNotes, module, "Enter notes in noted field");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Enter notes in noted field");	

	}
	}
	
	public void saveNotes(String module)
	{
		try
		{
		actions.clickAction(saveNotes, module, "Verify Operator should be able to Save Notes");
			
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Enter notes in noted field");	

		}
	}
	
	public void checkNotesHistory(String module,String noteshistory)
	{try
		{
		actions.checkText(noteshistory, notesHistory.get(0), module, "Check Note History in View Notes Page");
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check Note History in View Notes Page");	

		}
	}
	
	public void checkNotesinViewNotes(String module,String visitorNotesinHitory)
	{
		try
		{
		actions.textContainsText(visitorNotes.get(0), visitorNotesinHitory, module, "Check Note in View Notes Page");
		notesView=visitorNotesinHitory;

			
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check Note in View Notes Page");	

		}
	}
	public void doubleClickSaveNotes(String module)
	{
		try
		{
		String newNotesRan=actions.randomStringGeneration("Add Notess Double tap on save notes");
		enterNotes(module,newNotesRan);
//		actions.doubleClickAction(saveNotes, module, "Save Notes double time");
//		actions.checklistedTextTwice(newNotesRan, visitorNotes, module, "check double tap notes listed twice");
		actions.clickAction(saveNotes, module, "save notes");
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Add Notess Double tap on save notes");
	}
	}
	
	public void longtextSaveCheck(String module,String enterNotes)
	{
		try
		{


		enterNotes(module,enterNotes);
		saveNotes(module);
		
		//saving time
		actions.waitTime(3);
		if(actions.isPageOpened(notesHistory.get(0), enterNotes, "Page navigate to View Notes page"))
		{
			extentreportclass.mobilepassTest(module, "Page navigate to View Notes page");
		}
		else
		{
			extentreportclass.mobilefailTest(driver,module, "Page navigate to View Notes page");
			actions.backPress(module, "Navigate to View Notes Page");
		
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module, "Page navigate to View Notes page");
		
	}
	}
	
	public void clickEachNotes(String module)
	{
		try
		{
		if(!notesHistory.isEmpty())
		{
		actions.clickAction(notesHistory.get(0), module, "Open Single Notes History");
		}
		}
		catch(Exception e)
		{
			
			extentreportclass.mobilefailTest(driver,module,"Open Single Notes History");
		}
	}
	
	public void checkNotesDetails(String module,String visitorName, String operatorName,String notesText)
	{
		try{
		actions.checkText(visitorName, notesDetailsVisitorName, module, "Check VisitorName in Notes details Page");
		actions.checkText(operatorName, notesDetailsOperatorName, module, "Check operator Name in Notes details Page");
		if(notesDetailsText.isDisplayed())
		{
		actions.textContainsText(notesDetailsText, notesText, module, "Check Notes Text in Notes details Page");
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,"Check Notes Text in Notes details Page");

	}
	}
	
	public void checkAddNotesIcon(String module)
	{
		try
		{
		if(actions.iselemetFound(createNewNotesIcon))
		{
			extentreportclass.mobilepassTest(module, "Check add new notes icon shown");
		}
		else 
		{
			extentreportclass.mobilefailTest(driver,module, "Check add new notes icon shown");
		}
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module, "Check add new notes icon shown");
			
		}
	}
	public void checkPreviousNotesDisplayed(String module)
	{
		String caseName="Check already added noted";
		try
		{
		
		actions.checkTextinList(viewNotesInfo,"Operator MPTEST has transfered the chat to Admin",module,caseName);
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
		
	}
	
	public void checkNewlyAddedNotesDisplayed(String module,String expectedValue)
	{
		String caseName="Check newly added notes is displayed in the list";
		try
		{
		actions.checkText(expectedValue,visitorNotes.get(0),module,caseName);
		}
		catch(Exception e)
		{
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
