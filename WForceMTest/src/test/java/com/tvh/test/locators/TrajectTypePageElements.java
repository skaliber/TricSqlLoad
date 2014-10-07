package com.tvh.test.locators;

import com.tvh.test.pages.RandomizeNumber;

public class TrajectTypePageElements {

	public final static String TrajectPageTitle ="TVH - WFM - TrajectType Page";
	public final static String CompanySearchFieldByName="searchBox:hldCompany:company";
	public final static String CompanyTextEmpty="";
	public final static String AddTrajectTypeButton="searchBox:btnAddTrajectType";
	public final static String AddTrajectTypeModalwindowbyXpath="//div[@class='w_content_1']";
	public final static String CompanyLookUpButtonXpath="//div[2]/div/ul/li/div/a";
	public final static String CompanyLabelXpath="//div[2]/div/ul/li/div/label";
	public final static String TrajectTypeDescriptionByName="editTrajectTypeMW:content:editTrajectTypeForm:editBox:hldDescription:description";
	public final static String TrajectTypeDescriptionValue="TrajectTypeTest";
	public final static String TrajectTypeRenamed="TTRTest";
	public final static String SelectACompanyFromListByXpath="//div[2]/div/table/tbody/tr[2]/td[2]";
	public final static String SelectaTypeFromListByName="editTrajectTypeMW:content:editTrajectTypeForm:editBox:hldType:type";
	public final static String SaveButton="editTrajectTypeMW:content:editTrajectTypeForm:editBox:btnSave";
	public static final String DescriptionFromSearchBoxByName="searchBox:hldTrajectType:ttDescription";
	public static final String SearchButtonByName="searchBox:btnSearch";
	public static final String ResetButtonByName="searchBox:btnReset";
	public static final String TrajectTypeFoundByXpath="//td[2]/span";
	public static final String EditIconFirstTrajectOnTheLIstByXpath="//a[2]";
	public static final String MagnifierIconForFirstTrajectType="//span/a";
	public static final String SecondWOCByXparh="//tr[3]/td/span/input";
	public static final String DefaultWOCByXparh="//tr[2]/td/span/input";
	public static final String WOCOverviewXpath="//h2/span";
	public static final String WOCOverviewText="Work Order Codes overview for Traject Type:" + " " + TrajectTypePageElements.TrajectTypeRenamed + RandomizeNumber.FileReader() + " " + "- Results from 1 to 6";
	public static final String SuccesWOCAssignXpath="//span/ul/li/span";
	public static final String SuccesWOCAssignValue="Work order code assigned successfully to traject type";
	
	public static final String SuccesWOCUnAssignXpath="//span/ul/li/span";
	public static final String SuccesWOCUnAssignValue="Work order code removed successfully from traject type";
	public static final String BackToTrajectButtonXpath="//input";
	public static final String DescriptionError="Field 'Description' is required.";
	public static final String TypeError="Field 'Type' is required.";
	public static final String CompanyError="Field 'Company' is required.";
	public final static String CloseAddTrajectTypeModalWindowButtonXpaht="//a[contains(@href, '#')]";
	
}
