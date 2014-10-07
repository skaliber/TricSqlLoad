package com.tvh.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import com.tvh.test.driver.SharedDriver;
import com.tvh.test.locators.General;
import com.tvh.test.locators.MainPageLinks;
import com.tvh.test.locators.OperationPageElements;
import com.tvh.test.locators.TrajectTypePageElements;
import com.tvh.test.locators.WorkshopElements;
import com.tvh.test.pages.SeleniumWebdriver.Locators;

public class TrajectTypePageMap {

	public  WebDriver webDriver;

	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	public TrajectTypePageMap ClickonTrajectTypePageLInk(){
		
		try {
			SeleniumWebdriver.click(Locators.xpath, MainPageLinks.TrajectTypePageByXpath, webDriver);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return this;
		
	}
	
	
	
	 public TrajectTypePageMap getTrajectTypePageTitile(){
		 
		 assertEquals(TrajectTypePageElements.TrajectPageTitle, webDriver.getTitle());
		 
		 return this;
	 }
	 
	 
	
	public TrajectTypePageMap CheckifcompanyfieldIsEmpty(){
		assertEquals(TrajectTypePageElements.CompanyTextEmpty, webDriver.findElement(
				By.name(TrajectTypePageElements.CompanySearchFieldByName)).getText());
		
		return this;
	}
	
	public TrajectTypePageMap ClickonAddTrajectTypeButton(){
		
		try {
			SeleniumWebdriver.click(Locators.name, TrajectTypePageElements.AddTrajectTypeButton, webDriver);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return this;
	}
	
	public TrajectTypePageMap CheckIfAdDTrajectTypeModalWindowIsOpened() throws Exception{
		
			SeleniumWebdriver.wait(2);
		
			webDriver.findElement(By.xpath(TrajectTypePageElements.AddTrajectTypeModalwindowbyXpath));
			
			
		
		
		return this;
	}
	
	public TrajectTypePageMap ClickOnCompanyLookUpButton() throws Exception{
		
		SeleniumWebdriver.click(Locators.xpath, TrajectTypePageElements.CompanyLookUpButtonXpath, webDriver);
		SeleniumWebdriver.wait(2);
		return this;
	}
	
	
	public TrajectTypePageMap SelectComapnyFromList() throws Exception{
		
		SeleniumWebdriver.click(Locators.xpath, TrajectTypePageElements.SelectACompanyFromListByXpath, webDriver);
		SeleniumWebdriver.wait(2);
		return this;
	}
	
	public TrajectTypePageMap CheckIfCompanyIsSelected() throws Exception{
		
		assertEquals("TVH", webDriver.findElement(
				By.xpath(TrajectTypePageElements.CompanyLabelXpath)).getText());
		
		SeleniumWebdriver.wait(2);
		
		return this;
	}
	
	
	
	public TrajectTypePageMap InputADecsription() throws Exception{
		
		SeleniumWebdriver.type(Locators.name, TrajectTypePageElements.TrajectTypeDescriptionByName, TrajectTypePageElements.TrajectTypeDescriptionValue + RandomizeNumber.FileReader(), webDriver);
		
		return this;
	}
	
	
	 public  TrajectTypePageMap SelectATypeFromList() throws Exception{
			
				SeleniumWebdriver.wait(1);
				
					new Select(webDriver.findElement(By.name(TrajectTypePageElements.SelectaTypeFromListByName))).selectByVisibleText("WorkOrderBased");
					
					
					SeleniumWebdriver.wait(1);
					
		   
			return this;
		}
	
	public TrajectTypePageMap ClickOnSaveButton() throws Exception{
		
		
		SeleniumWebdriver.click(Locators.name, TrajectTypePageElements.SaveButton, webDriver);
		SeleniumWebdriver.wait(3);
		
		return this;
	}
	
	public TrajectTypePageMap SearchForTrajectTypeAndCheckIfWasCreated () throws Exception{
		
		SeleniumWebdriver.type(Locators.name, TrajectTypePageElements.DescriptionFromSearchBoxByName, 
				TrajectTypePageElements.TrajectTypeDescriptionValue + RandomizeNumber.FileReader(), webDriver);
		
		SeleniumWebdriver.wait(1);
		
		SeleniumWebdriver.click(Locators.name, TrajectTypePageElements.SearchButtonByName, webDriver);
		
		
		SeleniumWebdriver.wait(2);
		
		assertEquals(TrajectTypePageElements.TrajectTypeDescriptionValue + RandomizeNumber.FileReader(), webDriver.findElement(
				By.xpath(TrajectTypePageElements.TrajectTypeFoundByXpath)).getText());
		
		SeleniumWebdriver.wait(1);
		
		
		return this;
	}
	
	public TrajectTypePageMap ClickonEditIcon() throws Exception{
		
		SeleniumWebdriver.click(Locators.xpath, TrajectTypePageElements.EditIconFirstTrajectOnTheLIstByXpath, webDriver);
		SeleniumWebdriver.wait(1);
		
		
		return this;
	}
	
public TrajectTypePageMap RenameTrajectType() throws Exception{
		
		
	SeleniumWebdriver.clear(Locators.name, TrajectTypePageElements.TrajectTypeDescriptionByName, webDriver);
	
	SeleniumWebdriver.type(Locators.name, TrajectTypePageElements.TrajectTypeDescriptionByName, TrajectTypePageElements.TrajectTypeRenamed + RandomizeNumber.FileReader(), webDriver);
		SeleniumWebdriver.wait(1);
		return this;
	}


public TrajectTypePageMap CheckIfTrajectTypeWasRenamed () throws Exception{
	
	SeleniumWebdriver.clear(Locators.name, TrajectTypePageElements.DescriptionFromSearchBoxByName, webDriver);
		SeleniumWebdriver.wait(1);
	
	SeleniumWebdriver.type(Locators.name, TrajectTypePageElements.DescriptionFromSearchBoxByName, 
			TrajectTypePageElements.TrajectTypeRenamed + RandomizeNumber.FileReader(), webDriver);
	
	SeleniumWebdriver.wait(1);
	
	SeleniumWebdriver.click(Locators.name, TrajectTypePageElements.SearchButtonByName, webDriver);
	
	
	SeleniumWebdriver.wait(2);
	
	assertEquals(TrajectTypePageElements.TrajectTypeRenamed + RandomizeNumber.FileReader(), webDriver.findElement(
			By.xpath(TrajectTypePageElements.TrajectTypeFoundByXpath)).getText());
	
	SeleniumWebdriver.wait(1);
	
	
	return this;
}
public TrajectTypePageMap ClickOnMagnifierIcon () throws Exception{
	
	SeleniumWebdriver.click(Locators.xpath, TrajectTypePageElements.MagnifierIconForFirstTrajectType, webDriver);
		SeleniumWebdriver.wait(1);
	
	return this;
}




public TrajectTypePageMap CheckIfDefaultWOCisSelected () throws Exception{
	
	WebElement isChecked = webDriver.findElement(By.xpath(TrajectTypePageElements.DefaultWOCByXparh));

	   if (isChecked != null){
	      System.out.println("Default Value is checked"); 
	   }else{
		   System.out.println("default value is not checked");
		   
	   }
	
	
	return this;
}

public TrajectTypePageMap SelectTheSecondWOC () throws Exception{
	
SeleniumWebdriver.click(Locators.xpath, TrajectTypePageElements.SecondWOCByXparh, webDriver);
	SeleniumWebdriver.wait(1);
	
	return this;
}
public TrajectTypePageMap CheckifWOCWasAssign () throws Exception{
	
	WebElement isChecked = webDriver.findElement(By.xpath(TrajectTypePageElements.DefaultWOCByXparh));

	   if (isChecked != null){
	      System.out.println("Default Value is checked"); 
	   }else{
		   System.out.println("default value is not checked");
		   
		   
		   assertEquals(TrajectTypePageElements.SuccesWOCAssignValue, webDriver.findElement(
					By.xpath(TrajectTypePageElements.SuccesWOCAssignXpath)).getText());
	
	return this;
	
	   }
	return null;
}


public TrajectTypePageMap UnselectTheSecondWOC () throws Exception{
	
SeleniumWebdriver.click(Locators.xpath, TrajectTypePageElements.SecondWOCByXparh, webDriver);
	SeleniumWebdriver.wait(1);
	
	return this;
}

public TrajectTypePageMap CheckifWOCWasUnAssign () throws Exception{
	
	WebElement isChecked = webDriver.findElement(By.xpath(TrajectTypePageElements.DefaultWOCByXparh));

	   if (isChecked == null){
	      System.out.println("Default Value is unchecked"); 
	   }else{
		   System.out.println("default value is  checked");
		   
		   
		   assertEquals(TrajectTypePageElements.SuccesWOCUnAssignValue, webDriver.findElement(
					By.xpath(TrajectTypePageElements.SuccesWOCUnAssignXpath)).getText());
	
	return this;
	
	   }
	return null;
}

	
public TrajectTypePageMap ClikonBacktoTrajectButton() throws Exception{
	
	
	SeleniumWebdriver.click(Locators.xpath, TrajectTypePageElements.BackToTrajectButtonXpath, webDriver);
	SeleniumWebdriver.wait(1);
	return this;
}

public TrajectTypePageMap CheckIfWasReturnedtotheMainTrajectTypePage() throws Exception{
	
	
	 assertEquals(TrajectTypePageElements.TrajectTypeRenamed + RandomizeNumber.FileReader(), webDriver.findElement(
				By.name(TrajectTypePageElements.DescriptionFromSearchBoxByName)).getText());
	 
	 
	 
	return this;
}

public TrajectTypePageMap CheckErrorMessage() throws Exception{
	
	
	 assertEquals(TrajectTypePageElements.DescriptionError, webDriver.findElement(
				By.xpath(General.ErrorClearBox1ByXpath)).getText());
	 
	 SeleniumWebdriver.wait(1);
	 
	 assertEquals(TrajectTypePageElements.TypeError, webDriver.findElement(
				By.xpath(General.ErrorClearBox2ByXpath)).getText());
	 
	 SeleniumWebdriver.wait(1);
	 
	 assertEquals(TrajectTypePageElements.CompanyError, webDriver.findElement(
				By.xpath(General.ErrorClearBox3ByXpath)).getText());
	 
	 SeleniumWebdriver.wait(1);
	 
	 
	 
	return this;
}


public TrajectTypePageMap CloseAddTrajectTypeModalwindow() throws Exception{
	
	
SeleniumWebdriver.click(Locators.xpath, TrajectTypePageElements.CloseAddTrajectTypeModalWindowButtonXpaht, webDriver);
	 
	 SeleniumWebdriver.wait(1);
	 
	 
	 
	return this;
}

public TrajectTypePageMap clickontheresetbutton() throws Exception{
	
	
SeleniumWebdriver.click(Locators.name, TrajectTypePageElements.ResetButtonByName, webDriver);
	 
	 SeleniumWebdriver.wait(3);
	 
	return this;
}


public TrajectTypePageMap CheckIfFilterWasReseted() throws Exception{
	
	
	 assertEquals("", webDriver.findElement(
				By.name(TrajectTypePageElements.DescriptionFromSearchBoxByName)).getText());
	 
	return this;
}



public void setWebDriver(WebDriver webDriver) {
		
		this.webDriver = webDriver;
		
	}

	public TrajectTypePageMap(SharedDriver webDriver){
		
		this.webDriver = webDriver;
	
	}
	
	
}
