package com.tvh.test.locators;

import java.util.HashMap;
import java.util.Map;

public class MainPageLinks {
	public static void main(String args[]) {
		linksMap.put(OperationTypePage, OperationTypePageByXpath);
		linksMap.put("Operation", OperationPageByXpath);
		linksMap.put("Traject Type", TrajectTypePageByXpath);
		linksMap.put("Traject", trajectByXpath);
		linksMap.put("Zone", ZonePageXpath);
		linksMap.put("Zone operation", ZoneOperationXpath);
		linksMap.put("Orders Management", OrdersXpath);
		linksMap.put("Plants  ", OrdersXpath);
		linksMap.put("Workers Management", WorkersManagementxpath);
		linksMap.put("Teams Management", TeamManagementXpath);
		linksMap.put("Employee Management", EmployeeManagementXpath);
		linksMap.put("Employee access to companies", EmployeeAccesXpath);
		linksMap.put("Assign Teams and Workers", AssignTeamsXpath);
		linksMap.put("Assign Team Leader", AssignTeamLeaderXpath);
		linksMap.put("Schedule jobs", SchedulerXpath);
		linksMap.put("Jobs Inbox", InboxXpath);
		
		
	}
	
	public final static String OperationTypePage = "Operation type";
	public final static String OperationTypePageByXpath="//a[contains(text(),'" + OperationTypePage + "')]";
	public final static String OperationPageByXpath ="(//a[contains(text(),'Operation')])[2]";
	public final static String TrajectTypePageByXpath="//a[contains(text(),'Traject type')]";
	public final static String trajectByXpath="xpath=(//a[contains(text(),'Traject')])[2]";
	public final static String ZonePageXpath="//a[contains(text(),'Zone')]";
	public final static  String ZoneOperationXpath ="//a[contains(text(),'Zone operation')]";
	public final static String OrdersXpath ="//a[contains(text(),'Orders Management')]";
	public final static String PlantsXpath="//a[contains(text(),'Plants Management')]";
	public final static String WorkersManagementxpath="//a[contains(text(),'Workers Management')]";
	public final static String TeamManagementXpath="//a[contains(text(),'Teams Management')]";
	public final static String EmployeeManagementXpath="//a[contains(text(),'Employee Management')]";
	public final static String EmployeeAccesXpath="//a[contains(text(),'Employee access to companies')]";
	public final static String AssignTeamsXpath ="//a[contains(text(),'Assign Teams and Workers')]";
	public final static String AssignTeamLeaderXpath="//a[contains(text(),'Assign Team Leader')]";
	public final static String InboxXpath="//a[contains(text(),'Jobs Inbox')]";
	public final static String SchedulerXpath="//a[contains(text(),'Schedule jobs')]";
	public final static String WorKShopManagementxpath="//a[contains(text(),'Workshop')]";
	public final static Map<String, String> linksMap = new HashMap<String, String>();
	
	
}
