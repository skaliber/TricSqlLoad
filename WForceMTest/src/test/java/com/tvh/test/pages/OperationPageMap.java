package com.tvh.test.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tvh.test.driver.SharedDriver;
import com.tvh.test.locators.MainPageLinks;
import com.tvh.test.locators.OperationElements;
import com.tvh.test.pages.SeleniumWebdriver.Locators;

public class OperationPageMap {

	public WebDriver webDriver;

	public WebDriver getWebDriver() {
		return webDriver;
	}

public OperationPageMap OpenoperationPage() throws Exception{
		
	SeleniumWebdriver.click(Locators.xpath, MainPageLinks.OperationPageByXpath, webDriver);
		
		return this;
	}
	
	public OperationPageMap AddOperationButton() throws Exception{
		
		SeleniumWebdriver.click(Locators.name, OperationElements.AddOperationButtonByName, webDriver);
		SeleniumWebdriver.wait(2);
		
		return this;
	}
	
	public OperationPageMap CheckIFAddOperationModalWindowIsOpened() throws Exception{
		
		webDriver.findElement(By.xpath(OperationElements.AddOperationContentByXpath));
		
	return this;	
		
	}
	
	public OperationPageMap ClickOnSaveButton() throws Exception{
		
		SeleniumWebdriver.click(Locators.name, OperationElements.SaveOperationButtonbyName, webDriver);
		SeleniumWebdriver.wait(4);
		
	return this;	
		
	}
	
public OperationPageMap FillOperationDescriptionAndShoprtdescription() throws Exception{
		SeleniumWebdriver.type(Locators.name, OperationElements.OperationShortDescriptionByName, OperationElements.OperationShoprtdescriptionValue+RandomizeNumber.FileReader(), webDriver);
		SeleniumWebdriver.wait(1);
		SeleniumWebdriver.type(Locators.name, OperationElements.OperationDescriptionByName, OperationElements.OperationDescriptionValue+RandomizeNumber.FileReader(), webDriver);
		SeleniumWebdriver.wait(1);
	return this;	
		
	}
	
public OperationPageMap SelectOperationType() throws Exception{

	
	SeleniumWebdriver.click(Locators.xpath, OperationElements.OperationTypeLookUpButtonByXpath, webDriver);
		SeleniumWebdriver.wait(3);
	SeleniumWebdriver.waitForElementDisplayed(Locators.xpath, OperationElements.SelectOperationtypeModalWindowByXpath, webDriver);
	SeleniumWebdriver.type(Locators.name, OperationElements.SelectOperationTypeDescriptionFieldByName, "productie", webDriver);
		SeleniumWebdriver.wait(2);
	SeleniumWebdriver.click(Locators.name, OperationElements.SelectOperationTypeSearchButtonByName, webDriver);
		SeleniumWebdriver.wait(3);
	SeleniumWebdriver.click(Locators.xpath, OperationElements.SelectOperationTypeActionByXpath, webDriver);
	SeleniumWebdriver.wait(3);
	return this;
}	

public OperationPageMap SelectExternalLink()throws Exception{
	
	SeleniumWebdriver.click(Locators.xpath, OperationElements.SelectExternalLinkLookUpButtonbyXpath, webDriver);
		SeleniumWebdriver.wait(2);
	SeleniumWebdriver.click(Locators.xpath, OperationElements.SelectExternalLinkActionByXpath, webDriver);
	SeleniumWebdriver.wait(2);
	
	return this;
}

public OperationPageMap SearchAValidOperationName()throws Exception{
	
	SeleniumWebdriver.type(Locators.name, OperationElements.OperationDescriptionSearchBoxFieldByName, OperationElements.OperationDescriptionValue+RandomizeNumber.FileReader(), webDriver);
	SeleniumWebdriver.wait(2);
	
	return this;
}


public OperationPageMap ClickOnSearchButton()throws Exception{
	
	SeleniumWebdriver.submit(Locators.name, OperationElements.OperationSearchButton, webDriver);
	
	SeleniumWebdriver.wait(4);
	
	return this;
}


public OperationPageMap ClickOnResetButton() throws Exception{
  	
	SeleniumWebdriver.click(Locators.name, OperationElements.OperationResetButtonByName, webDriver);
	SeleniumWebdriver.wait(2);
	
return this;

}

public OperationPageMap CheckIfOperationWasFound() throws Exception{
  	
	assertEquals(OperationElements.OperationShoprtdescriptionValue+RandomizeNumber.FileReader(), webDriver.findElement(By.xpath(OperationElements.OperationResultsFoundByXpath)).getText());
	SeleniumWebdriver.wait(2);
	
return this;

}

public OperationPageMap SearchAnInValidOperationName()throws Exception{
	
	SeleniumWebdriver.type(Locators.name, OperationElements.OperationDescriptionSearchBoxFieldByName, OperationElements.OperationNoResultsfoundvalueToSearch+RandomizeNumber.FileReader(), webDriver);
	
	return this;
}
public OperationPageMap CheckIfNoResultsFoundMessageApear() throws Exception{
  	
	assertEquals(OperationElements.OperationNoResultsfoundvalue, webDriver.findElement(By.xpath(OperationElements.OperationNoresultsFoundByXpath)).getText());
	SeleniumWebdriver.wait(2);
	
return this;

}

public OperationPageMap EditProductiveOperation()throws Exception{
	SeleniumWebdriver.click(Locators.xpath, OperationElements.EditOperationIcon1Xpath, webDriver);
	SeleniumWebdriver.wait(2);
	CheckIFAddOperationModalWindowIsOpened();
	
	SeleniumWebdriver.type(Locators.name, OperationElements.OperationShortDescriptionByName, OperationElements.OperationShortDescriptionrenamed+RandomizeNumber.FileReader(), webDriver);
	SeleniumWebdriver.type(Locators.name, OperationElements.OperationDescriptionByName, OperationElements.OperationDescriptionRenamed+RandomizeNumber.FileReader(), webDriver);
	
	DeleteExternalOperation();
	
	return this;
}

public OperationPageMap DeleteExternalOperation()throws Exception{
	SeleniumWebdriver.click(Locators.xpath, OperationElements.DeteleExternalOperationByXpath, webDriver);
	SeleniumWebdriver.wait(2);
	return this;
}

public OperationPageMap CheckIfOperationWasModified()throws Exception{
	
	assertEquals(OperationElements.OperationShortDescriptionrenamed+RandomizeNumber.FileReader(), webDriver.findElement(By.xpath(OperationElements.OperationResultsFoundByXpath)).getText());
	SeleniumWebdriver.wait(2);
	assertEquals("", webDriver.findElement(By.xpath(OperationElements.CheckExternalOperationField)).getText());
	SeleniumWebdriver.wait(2);
	
	
	return this;
}

public OperationPageMap SearchAfterOperationRenamed()throws Exception{
	
	SeleniumWebdriver.type(Locators.name, OperationElements.OperationDescriptionSearchBoxFieldByName, OperationElements.OperationDescriptionRenamed+RandomizeNumber.FileReader(), webDriver);
	
	return this;
}

	public void setWebDriver(WebDriver webDriver) {
		
		this.webDriver = webDriver;
		
	}

	public OperationPageMap(SharedDriver webDriver){
		
		this.webDriver = webDriver;
	
	}
	
	
	
}
