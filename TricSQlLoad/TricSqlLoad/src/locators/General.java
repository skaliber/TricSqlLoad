package locators;

import org.openqa.selenium.By;

public class General {
	public static final String TricSQLURL = "http://cosminlazar:8080/TricSQL/?key=INTERNAL&userid=user1";
	public static final By MachineTab = By.xpath("//a[@id='equipTypeGroupLink1']/img");
	public static final By Make = By.name("makeAutoComplete");
	public static final By Model = By.name("modelContainer:modelAutoComplete");
	public static final By SelectButton = By.name("selectBtn");
	public static final By Searchbutton = By.xpath("//div[2]/div[5]/input");
	
	
	public static final String MakeValue = "TOYOTA";
	public static final String ModelValue ="02-7FD10";
	
	
}
