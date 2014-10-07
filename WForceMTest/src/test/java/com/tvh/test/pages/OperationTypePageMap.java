package com.tvh.test.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.tvh.test.driver.SharedDriver;
import com.tvh.test.locators.MainPageLinks;
import com.tvh.test.locators.OperationPageElements;
import com.tvh.test.pages.SeleniumWebdriver.Locators;

public class OperationTypePageMap {

	protected WebDriver webDriver;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public OperationTypePageMap addOperationTypeButton(){
	
		webDriver.findElement(By.xpath(OperationPageElements.AddOperationTypeButtonXpath)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return this;
	}
	
	public OperationTypePageMap checkIfAddModalWindowIsOpened() throws Exception{
		 SeleniumWebdriver.wait(5);
		webDriver.findElement(By.xpath(OperationPageElements.AddOperationTypeModalWindowByXpath));
		return this;
	}
	
	public OperationTypePageMap clickOnSaveButton() throws Exception{
			
		SeleniumWebdriver.click(Locators.name, OperationPageElements.SaveOperationTypeButtonByName,webDriver);
	    SeleniumWebdriver.wait(5);
		
		return this;
	}
	
	public OperationTypePageMap OpenOperationPage() throws Exception{
      
		SeleniumWebdriver.click(Locators.xpath, MainPageLinks.OperationTypePageByXpath, webDriver);

      return this;
	    }
	    
	public OperationTypePageMap CheckIfOperationPageIsOpened(){
	      
		webDriver.findElement(By.xpath(OperationPageElements.operationTypeContent));
	    
	    for (String OperationTypeElements : OperationPageElements.OperationTypeEelements.keySet()){
	    	assertEquals(OperationTypeElements, webDriver.findElement(By.xpath(OperationPageElements.OperationTypeEelements.get(OperationTypeElements))));
	    }

      return this;
	    }
	
        public  OperationTypePageMap FillOperationTypeFieldsAsProductiveOperation() throws Exception{
        	
		SeleniumWebdriver.type(Locators.name, OperationPageElements.OperationTypedescriptionByName, OperationPageElements.OperationTypedescriptionValue +RandomizeNumber.FileReader(), webDriver);
		
			SeleniumWebdriver.wait(1);
			
				new Select(webDriver.findElement(By.name(OperationPageElements.OperationTypeSelectFactorByName))).selectByVisibleText("# = Serial Quantity");
				
				SeleniumWebdriver.click(Locators.name, OperationPageElements.OperationTypeProductiveCheckBoxbyName, webDriver);
	   
		return this;
	}
        
        public  OperationTypePageMap FillOperationTypeFieldsAsNonproductiveOperation() throws Exception{
        	
    		SeleniumWebdriver.type(Locators.name, OperationPageElements.OperationTypedescriptionByName, OperationPageElements.OperationTypedescriptionNPValue+RandomizeNumber.FileReader(), webDriver);
    		
    			SeleniumWebdriver.wait(1);
    			
    				new Select(webDriver.findElement(By.name(OperationPageElements.OperationTypeSelectFactorByName))).selectByVisibleText("# = Serial Quantity");
    				
    		return this;
    	}
	
    public  OperationTypePageMap SearchProductiveOperationType() throws Exception{
    	
        	SeleniumWebdriver.type(Locators.name, OperationPageElements.OpeartionTypeSearchBoxByName, OperationPageElements.OperationTypedescriptionValue+RandomizeNumber.FileReader(), webDriver);
        		SeleniumWebdriver.wait(2);
        			
        		    ClickOnSearchBytton();
        		    
        		    	CheckIfProductiveOperationWasFound();
        		    	SeleniumWebdriver.wait(2);
    			
    		return this;
    	}
	
	
    public OperationTypePageMap SearchNPOperationType() throws Exception{
    	
    	SeleniumWebdriver.type(Locators.name, OperationPageElements.OpeartionTypeSearchBoxByName, OperationPageElements.OperationTypedescriptionNPValue+RandomizeNumber.FileReader(), webDriver);
			SeleniumWebdriver.wait(2);
		ClickOnSearchBytton();
			CheckIfNonProductiveOperationWasFound();
    	
    	return this;
    }
    
    
    public OperationTypePageMap SearchUnknownOperationType() throws Exception{
    	

		SeleniumWebdriver.type(Locators.name, OperationPageElements.OpeartionTypeSearchBoxByName, OperationPageElements.OperationNoResultsfoundvalueToSearch, webDriver);
		 	 
			ClickOnSearchBytton();
		 
				CheckIfNoresultsFoundMessageApear();
    	
    	return this;
    }
    
    
    
    
    public OperationTypePageMap ClickOnSearchBytton() throws Exception{
    	
    	SeleniumWebdriver.click(Locators.xpath, OperationPageElements.SearchOperationTypeButtonXpath, webDriver);
			SeleniumWebdriver.wait(2);
    	
    	return this;
    	
    }
    
    public OperationTypePageMap ClickOnResetBytton() throws Exception{
    	
    	SeleniumWebdriver.click(Locators.xpath, OperationPageElements.ResetOperationTypeButtonXpath, webDriver);
			SeleniumWebdriver.wait(2);
    	
    	return this;
    	
    }
  public OperationTypePageMap CheckIfProductiveOperationWasFound() throws Exception{
    	
			assertEquals(OperationPageElements.OperationTypedescriptionValue+RandomizeNumber.FileReader(), webDriver.findElement(By.xpath(OperationPageElements.OperationTypeResultsFoundByXpath)).getText());
			SeleniumWebdriver.wait(2);
			
    	return this;
    	
    }
  public OperationTypePageMap CheckIfNonProductiveOperationWasFound() throws Exception{
  	
		assertEquals(OperationPageElements.OperationTypedescriptionNPValue+RandomizeNumber.FileReader(), webDriver.findElement(By.xpath(OperationPageElements.OperationTypeResultsFoundByXpath)).getText());
		SeleniumWebdriver.wait(2);
		
	return this;
	
}
  
  public OperationTypePageMap CheckIfNoresultsFoundMessageApear() throws Exception{
	  	
		assertEquals(OperationPageElements.OperationNoResultsfoundvalue, webDriver.findElement(By.xpath(OperationPageElements.OperationTypeNoresultsFoundByXpath)).getText());
		SeleniumWebdriver.wait(2);
		
	return this;
	
}

  public OperationTypePageMap EditProductiveOperationType() throws Exception{
	  SeleniumWebdriver.click(Locators.xpath, OperationPageElements.EditOperationtypeIcon1Xpath, webDriver);
	  			checkIfAddModalWindowIsOpened();
	  			//webDriver.findElement(By.name(OperationPageElements.OperationTypedescriptionByName)).clear();
	  SeleniumWebdriver.type(Locators.name, OperationPageElements.OperationTypedescriptionByName, OperationPageElements.OperationTypeRenamedValue+ RandomizeNumber.FileReader(), webDriver);
	  
				SeleniumWebdriver.wait(1);
		
				new Select(webDriver.findElement(By.name(OperationPageElements.OperationTypeSelectFactorByName))).selectByVisibleText("0 = Single Use");
			
	
	  clickOnSaveButton();
	  return this;
  }
  

  public  OperationTypePageMap CheckIfOperationTypeWasModifyed() throws Exception{
  	
      	SeleniumWebdriver.type(Locators.name, OperationPageElements.OpeartionTypeSearchBoxByName, OperationPageElements.OperationTypeRenamedValue+RandomizeNumber.FileReader(), webDriver);
      		SeleniumWebdriver.wait(2);
      			
      		    ClickOnSearchBytton();
      		    
      		  CheckIfProductiveOperationWasFoundAfterEdit();
      		    	SeleniumWebdriver.wait(2);
  			
  		return this;
  	}
  
  
  public OperationTypePageMap CheckIfProductiveOperationWasFoundAfterEdit() throws Exception{
  	
		assertEquals(OperationPageElements.OperationTypeRenamedValue+RandomizeNumber.FileReader(), webDriver.findElement(By.xpath(OperationPageElements.OperationTypeResultsFoundByXpath)).getText());
		SeleniumWebdriver.wait(2);
		
	return this;
	
}
  
  public OperationTypePageMap EditNonProductiveOperationType() throws Exception{
	  SeleniumWebdriver.click(Locators.xpath, OperationPageElements.EditOperationtypeIcon1Xpath, webDriver);
	  			checkIfAddModalWindowIsOpened();
	  			//webDriver.findElement(By.name(OperationPageElements.OperationTypedescriptionByName)).clear();
	  SeleniumWebdriver.type(Locators.name, OperationPageElements.OperationTypedescriptionByName, OperationPageElements.OperationTypeRenamedValueNP+ RandomizeNumber.FileReader(), webDriver);
	  
				SeleniumWebdriver.wait(1);
		
				new Select(webDriver.findElement(By.name(OperationPageElements.OperationTypeSelectFactorByName))).selectByVisibleText("0 = Single Use");
			
	  clickOnSaveButton();
	  return this;
  }
  
  public  OperationTypePageMap CheckIfNonOperationTypeWasModifyed() throws Exception{
	  	
    	SeleniumWebdriver.type(Locators.name, OperationPageElements.OpeartionTypeSearchBoxByName, OperationPageElements.OperationTypeRenamedValueNP+RandomizeNumber.FileReader(), webDriver);
    		SeleniumWebdriver.wait(2);
    			
    		    ClickOnSearchBytton();
    		    
    		    CheckIfNonProductiveOperationWasFoundAfterEdit();
    		    	SeleniumWebdriver.wait(2);
			
		return this;
	}
  
  
  public OperationTypePageMap CheckIfNonProductiveOperationWasFoundAfterEdit() throws Exception{
	  	
		assertEquals(OperationPageElements.OperationTypeRenamedValueNP+RandomizeNumber.FileReader(), webDriver.findElement(By.xpath(OperationPageElements.OperationTypeResultsFoundByXpath)).getText());
		SeleniumWebdriver.wait(2);
		
	return this;
	
}
  
  public  OperationTypePageMap CheckIfNonProductiveOperationTypeWasModifyed() throws Exception{
	  	
    	SeleniumWebdriver.type(Locators.name, OperationPageElements.OpeartionTypeSearchBoxByName, OperationPageElements.OperationTypeRenamedValueNP+RandomizeNumber.FileReader(), webDriver);
    		SeleniumWebdriver.wait(2);
    			
    		    ClickOnSearchBytton();
    		    
    		    CheckIfNonProductiveOperationWasFoundAfterEdit();
    		    	SeleniumWebdriver.wait(2);
			
		return this;
	}
  
	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public OperationTypePageMap(SharedDriver webDriver){
	
		this.webDriver = webDriver;
	
	}
	
}
