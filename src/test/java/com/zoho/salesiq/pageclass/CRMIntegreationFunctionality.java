//$Id$
package com.zoho.salesiq.pageclass;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.css.ElementCSSInlineStyle;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.zoho.salesiq.pageclass.CommonActionMobile;
import com.zoho.salesiq.pageclass.SearchFunctionality;
import com.zoho.salesiq.pageclass.Extentreportclass;
import com.zoho.salesiq.pageclass.KebabMenuFunctionality;
import io.appium.java_client.AppiumDriver;

public class CRMIntegreationFunctionality extends BaseSetup{
private String module = "CRM Integration";
	
	private boolean missedDetailsPage;
	CommonActionMobile actions = new CommonActionMobile(driver);
	private boolean missedChatPage;
	SearchFunctionality seachFunctionality=new SearchFunctionality(driver);
	String assigneeName="";
	Extentreportclass extentreportclass=new Extentreportclass();
	KebabMenuFunctionality kebabMenuFunctionality=new KebabMenuFunctionality(driver);
	public static boolean crmMenuShow;
	public static boolean cRMLinkIcon;
	
	public int crmContactFieldCount=3;
	
	public boolean crminfoUpdated;
	private ArrayList<String> cars = new ArrayList<String>();
	public CRMIntegreationFunctionality(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(id="vchat_button")
	MobileElement leadSelection;
	
	@AndroidFindBy(id="achat_button")
	MobileElement contactSelection;
	
	@AndroidFindBy(id="action_save_note")
	MobileElement saveCRM;
	
	@AndroidFindBy(id="editText1")
	MobileElement enterLeadCompanyName;
	
	@AndroidFindBy(id="android:id/text1")
	List<MobileElement> leadclickDropdown;
	
	@AndroidFindBy(className="android.widget.CheckedTextView")
	List<MobileElement> leaddropdownList;
	
	@AndroidFindBy(className="android.widget.CheckedTextView")
	List<MobileElement> leadDropDownStatus;
	
	@AndroidFindBy(id="editText2")
	MobileElement leadphoneNumber;
	
	@AndroidFindBy(id="checkbox")
	MobileElement leadAddTaskCheckBox;

	@AndroidFindBy(id="editText1")
	List<MobileElement> contactAccountName;
	
	@AndroidFindBy(className="android.widget.TextView")
	List<MobileElement> checkPotentialPageOpen;
	
	@AndroidFindBy(id="editText2")
	List<MobileElement> contactPhoneNumber;
	
	@AndroidFindBy(id="android:id/text1")
	List<MobileElement> contactclickDropdown;
	
	@AndroidFindBy(className="android.widget.CheckedTextView")
	List<MobileElement> contactManagerList;
	
	@AndroidFindBy(className="android.widget.CheckedTextView")
	List<MobileElement> potentialStageList;
	
	@AndroidFindBy(id = "title")
	List<MobileElement> kebabMenuList;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CRM Information']")
	MobileElement crmInformationPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lead']")
	MobileElement checkCRMConvertedAsLead;
	
	
	
	@AndroidFindBy(id="checkbox")
	List<MobileElement> contactAddTaskAndPotential;
	
	@AndroidFindBy(id="primaryItemText")
	List<MobileElement> cRMInformationList;
	
	@AndroidFindBy(id="actionicon")
	MobileElement cRMappLink;
	
	@AndroidFindBy(id="prompt_message")
	MobileElement cRMAppLinkPopupMessage;
	
	@AndroidFindBy(id="cancel_button")
	MobileElement popupCancel;
	
	@AndroidFindBy(id="ok_button")
	MobileElement downLoadLink;
	
	@AndroidFindBy(id="primaryItemText")
	List<MobileElement> crmIndividualInformationList;
	
	@AndroidFindBy(id="imageDate")
	MobileElement potentialDatePicker;
	
	@AndroidFindBy(id="visitorchat_info")
	MobileElement visitorPipeLineRevenue;
	
	@AndroidFindBy(id="visitorchat_question")
	MobileElement visitorPipeLineStage;
	
	@AndroidFindBy(id="visitorchat_time")
	MobileElement visitorPipeLineEndDate;
	
	@AndroidFindBy(id="header_text")
	MobileElement checkCRMType;
	
	
	public void selectLeadCRM(String module)
	{
		actions.clickAction(leadSelection, module, "Select Lead CRM");
	}
	
	public void selectContacCRM(String module)
	{
		actions.clickAction(contactSelection, module, "Select Contact CRM");
	}
	public void enterLeadCompanyName(String module,String companyName)
	{
	actions.actionEnter(enterLeadCompanyName, companyName, module, "Enter lead Company Name");
	}
	public void checkLeadStatusDropDownList(String module)
	{
		actions.clickAction(leadclickDropdown.get(0), module, "Click on Lead Status DropDown");
		actions.checkTextinList(leadDropDownStatus, "Attempted to Contact", module,"Check dropdown list text in Lead Status");
		actions.checkTextinList(leadDropDownStatus, "Contact in Future", module,"Check dropdown list text in Lead Status");
		actions.checkTextinList(leadDropDownStatus, "Contacted", module,"Check dropdown list text in Lead Status");
		actions.checkTextinList(leadDropDownStatus, "Junk Lead", module,"Check dropdown list text in Lead Status");
		actions.checkTextinList(leadDropDownStatus, "Lost Lead", module,"Check dropdown list text in Lead Status");
		actions.checkTextinList(leadDropDownStatus, "Not Contacted", module,"Check dropdown list text in Lead Status");
		actions.checkTextinList(leadDropDownStatus, "Pre-Qualified", module,"Check dropdown list text in Lead Status");
		actions.checkTextinList(leadDropDownStatus, "Not Qualified", module,"Check dropdown list text in Lead Status");
		actions.checkTextinList(leadDropDownStatus, "None", module,"Check dropdown list text in Lead Status");
	}
	public void checkCRMMangerDropDownList(String module)
	{
		actions.clickAction(leadclickDropdown.get(1), module, "Click on Lead Status DropDown");
		actions.checkTextinList(leaddropdownList, "Manager1 CRM", module,"Check dropdown list text in mananger");
		actions.checkTextinList(leaddropdownList, "mr.anbarasu10", module,"Check dropdown list text in Lead manager");
		actions.checkTextinList(leaddropdownList, "Supervisor Salesiq", module,"Check dropdown list text in Lead manager");
		
	}
	public void selectLeadStatus(String module,String value)
	{
		try {
		actions.waitTime(2);
		actions.selectBasedonTextInList(leaddropdownList,value, module, "Select"+value+"from status Dropdown");
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Lead Status dropdown not Found");
		}
	}
	
	public void enterLeadPhoneNumber(String module,String phoneNumber)
	{
		actions.actionEnter(leadphoneNumber, phoneNumber, module, "Enter Lead Phone Number");
	}
	
	public void selectLeadMangerForCRM(String module,String value)
	{
		try {
		actions.waitTime(2);
		actions.selectBasedonTextInList(leaddropdownList, value, module, "Select"+value+"from status Dropdown");
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Manger dropdown not Found");
		}
		
	}
	
	public void leadAddTask(String module)
	{
		// need to check in CRM portal about CRM task
		actions.clickAction(leadAddTaskCheckBox, module, "Add Task for Lead");
	}
	
	public void enterCRMAccountName(String module,String name)
	{
		try {
		actions.actionEnter(contactAccountName.get(0), name, module, "Enter account name for Contact");
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Enter CRM account Name not found");
		}
	}
	
	public void contactPhoneNumber(String module,String phoneNumber)
	{
		try {
			
		actions.actionEnter(contactPhoneNumber.get(0), phoneNumber, module, "Enter Contact phone number");
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Enter CRM contact Phone Number not found");
		}
	}
	
	public void selectMangerForContactCRM(String module,String value)
	{
		try {
		actions.clickAction(contactclickDropdown.get(0), module, "Click on Lead Status DropDown");
		actions.selectBasedonTextInList(contactManagerList, value, module, "Select"+value+"from status Dropdown");
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Manger dropdown not Found");
		}
		
	}
	
	public void addTaskContact(String module)
	{
		try {
			actions.clickAction(contactAddTaskAndPotential.get(0), module, "Add task for Contact CRM");
			
			}
			catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "Add Task not found");
			}
	}
	public void clickCreatePotentialContact(String module)
	{
		try {
			actions.clickAction(contactAddTaskAndPotential.get(1), module, "Add Potential for Contact CRM");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Create potential not found");
		}
	}
	
	public void enterPotentialName(String module,String potentialName)
	{
		try {
			
			actions.actionEnter(contactAccountName.get(0), potentialName, module, "Enter pontential Name");
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Enter pontential Name not found");
		}
	}
	public void selectPotentialStage(String module,String potentialStage)
	{
		try {
			actions.clickAction(contactclickDropdown.get(0), module, "Click on Lead Status DropDown");
			actions.selectBasedonTextInList(potentialStageList, potentialStage, module, "Select"+potentialStage+"from potential Stage Dropdown");
			}
			catch (Exception e) {
				// TODO: handle exception
				extentreportclass.mobilefailTest(driver,module, "Manger dropdown not Found");
			}
		
	}
	
	
	public void enterPotentialAmount(String module,String potentialAmount)
	{
		try {
			
			actions.actionEnter(contactPhoneNumber.get(0), potentialAmount, module, "Enter pontential amount");
		}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Enter pontential amount not found");
		}
	}
	
	
	public void clickPotentialDatePicker(String module)
	{
		String caseName="Click on potential Date Picker";
		try {
			actions.clickAction(potentialDatePicker, module,caseName);
			actions.selectPotentialEndDate(module,"select current Date");
		}
		
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}
	
	
	
	
	
	
	
	
	
	
	public void checkPopupShouldNotOpen(String module)
	{
		try {
	int xValue=cRMappLink.getLocation().getX();
	int yValue=cRMappLink.getLocation().getY();
	
	actions.clickBasedonCoordinate(xValue+150, yValue);
	if(cRMAppLinkPopupMessage.isDisplayed())
	{
		extentreportclass.mobilefailTest(driver,module, "Popup should not show while click other position than CRM Link Icon");
		actions.backPress(module, "CRM Popup");
	}
	else {
		extentreportclass.mobilepassTest(module, "Popup should not show while click other position than CRM Link Icon");
	}
		}
		catch (NoSuchElementException e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "CRM Link ICon no showing");
			cRMLinkIcon=false;
		}
	
	}
	public void clickCRMICon(String module)
	{
		if(crmMenuShow	)
		{
		actions.clickAction(cRMappLink, module, "Click on CRM App link Icon");
		if(!cRMAppLinkPopupMessage.isDisplayed())
		{
			extentreportclass.mobilefailTest(driver,module, "Popup should show while click on CRM Link Icon");
		}
		else {
			extentreportclass.mobilepassTest(module, "Popup should show while click on CRM Link Icon");
		}
		}
	}
	
	public void checkCRMAppLinkPopup(String module,String text)
	{
		if(crmMenuShow)
		{
		actions.checkText(text, cRMAppLinkPopupMessage, module, "Check CRM App download Popup Message");
		}
		
	}
	public void clickCancelCRMPopup(String module)
	{
		actions.clickAction(popupCancel, module, "Cancel CRM popup");
	}
	
	public void downloadCRMApplication(String module)
	{
		actions.clickAction(downLoadLink, module, "Click on CRM Link");
	}
	
	
	
	public void saveCRM(String module)
	{
		actions.clickAction(saveCRM, module, "Save CRM after entered CRM information");
		crminfoUpdated=true;
	}
	public void checkCRMinformationMenuinKebabMenu(String module)
	{
		String caseName="Check CRM information displayed in Kebab Menu";
	try
	{
		actions.waitTime(2);
		for(MobileElement menu:kebabMenuList)
		{
			if(menu.getText().equalsIgnoreCase("CRM Information"))
			{
				crmMenuShow=true;
				extentreportclass.mobilepassTest(module, caseName);
				break;
			}
			else {
				crmMenuShow=false;
				extentreportclass.mobilefailTest(driver,module,caseName);
			}
		}
	}
	catch(Exception e)
	{
		extentreportclass.mobilefailTest(driver,module,caseName);
		
	}
	}
	
	

	
	public void checkLeadOwner(String module,String leadOwner)
	{
		try {
			actions.checkText(leadOwner, crmIndividualInformationList.get(0), module,"Check Lead owner Name in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "CRM Lead information Not Found");
		}
	}
	public void checkLeadSource(String module,String leadSource)
	{
		try {
			actions.checkText(leadSource, crmIndividualInformationList.get(1), module,"Check Lead Source in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "CRM Lead information Not Found");
		}
	}
	public void checkLeadCity(String module,String city)
	{
		try {
			actions.checkText(city, crmIndividualInformationList.get(2), module,"Check Lead Source in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "CRM Lead information Not Found");
		}
	}
	
	public void checkCRMFieldOne(String module,String contactName)
	{
		try {
			actions.checkText(contactName, crmIndividualInformationList.get(0), module,"Check visitor Mail id "+contactName+" in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "CRM Contact info Not Found");
		}
	}
	public void checkCRMFieldTwo(String module,String contactEmailID)
	{
		try {
			actions.checkText(contactEmailID, crmIndividualInformationList.get(1), module,"Check contact Email "+contactEmailID+" in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "CRM Contact info Not Found");
		}
	}
	public void checkCRMFieldThree(String module,String contactOwner)
	{
		try {
			actions.checkText(contactOwner, crmIndividualInformationList.get(2), module,"Check contact owner "+contactOwner+" in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "CRM Contact info Not Found");
		}
	}
	public void checkPotentialName(String module,String potentialName)
	{
		try {
			actions.compareText(cars.get(4), potentialName, module, "Check Potential Name "+potentialName+" in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Potential field not found");
		}
	}
	
	public void getAllCRMInformationList()
	{
		for(MobileElement elem:crmIndividualInformationList)
		
			cars.add(elem.getText());
	}
	
	
	
	
	
	
	
	public void checkPotentialStage(String module,String potentialStage)
	{
		try {
			//actions.checkText(potentialStage, crmIndividualInformationList.get(5), module,"Check Potential Name "+potentialStage+" in the list");
			actions.compareText(cars.get(5), potentialStage, module, "Check Potential Stage "+potentialStage+" in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Potential field not found");
		}
	}
	public void checkPotentialExpectedRevenue(String module,String potentialAmount)
	{
		try {
			//actions.checkText(potentialAmount, crmIndividualInformationList.get(6), module,"Check Potential Name "+potentialAmount+" in the list");
			
			actions.compareText(cars.get(6), potentialAmount, module, "Check Potential Amount "+potentialAmount+" in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Potential field not found");
		}
	}
	
	
	public void checkPotentialClosingDate(String module)
	{
		try 
		{
		actions.checkPotentialDate(crmIndividualInformationList.get(7), module, "Check potential Date");
	}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Potential field not found");
		}
	}
	public void checkPotentialOwner(String module,String potentialOwner)
	{
		try {
			int value = crmIndividualInformationList.size();
			actions.swipeElementLocation(crmIndividualInformationList.get(6), crmIndividualInformationList.get(6));
			actions.checkText(potentialOwner, crmIndividualInformationList.get(value-1), module,"Check Potential Name "+potentialOwner+" in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Potential field not found");
		}
	}
	public void checkPotentialPipeLineStage(String module,String potentialPipeLineStage)
	{
		try {
		
			actions.checkText(potentialPipeLineStage, visitorPipeLineStage, module,"Check Potential Name "+potentialPipeLineStage+" in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Potential field not found");
		}
	}
	public void checkPotentialPipeLineRevenue(String module,String potentialPipeLineRevenue)
	{
		try {
			
			actions.textContainsText(visitorPipeLineRevenue,potentialPipeLineRevenue,module,"Check Potential Revenue "+potentialPipeLineRevenue+" in the list");
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "Potential field not found");
		}
	}
	public void checkPotentialPageOpen(String module)
	{
		String caseName="Check Potential is opened after click on Create potential";
		try {
			
			actions.checkText("Create Potential", checkPotentialPageOpen.get(0), module,caseName);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}
	public void checkConvertAsContact(String module)
	{
		actions.waitTime(3);
		String caseName="Check CRM type after convert as Contact";
		try {
			
			actions.checkText("Contact", checkCRMType, module,caseName);
			
		} catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}
	public void checkPotentialPipeLineEndDate(String module)
	{
		try 
		{
		actions.checkPotentialDate(visitorPipeLineEndDate, module, "Check potentialPipeLine End Date");
	}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, "PotentialPipeLine field not found");
		}
	}

	public void checkCRMInformationPageOpen(String useCase,String categories)
	{
		String caseName="Check CRM information page is opened";
		try 
		{
		actions.isPageOpened(crmInformationPage,useCase,caseName);
	}
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module, caseName);
		}
	}

	public void verifyCRMConvertedAsLead(String useCase,String categories)
	{
		String caseName="Check if CRM is configured as Lead visitor should converted as Lead";
		try 
		{
		actions.isPageOpened(checkCRMConvertedAsLead,useCase,caseName);
	}	
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}

	public void checkPotentialCreatePageOpen(String useCase,String categories)
	{
		String caseName="Verify Create potential page is opened if operator clicks on create potential menu";
		try 
		{
		actions.isPageOpened(saveCRM,useCase,caseName);
	}	
		catch (Exception e) {
			// TODO: handle exception
			extentreportclass.mobilefailTest(driver,module,caseName);
		}
	}
	
	
	
	
	
	
	
	
	

}
