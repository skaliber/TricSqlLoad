package com.tvh.test.pages;

import org.openqa.selenium.WebDriver;

import com.tvh.test.driver.SharedDriver;
import com.tvh.test.locators.MainPageLinks;
import com.tvh.test.locators.PlantPageElements;
import com.tvh.test.pages.SeleniumWebdriver.Locators;

import static org.junit.Assert.*;

public class PlantsPageMap {

	
	public  WebDriver webDriver;

	public WebDriver getWebDriver() {
		return webDriver;
	}
	public PlantsPageMap openPlantPage() throws Exception{
		
		SeleniumWebdriver.click(Locators.xpath, MainPageLinks.PlantsXpath, webDriver);
		
		return this;
	}
	
	
	
	public PlantsPageMap checkifPlantPageIsOpened()throws Exception{
		
		assertEquals(PlantPageElements.PlantPageTitle,webDriver.getTitle());
		
		return this;
	}
	
	public PlantsPageMap clickonAddPlantButton() throws Exception{
		
		// need to be decided
		
		return this;
	}
	
	public PlantsPageMap clickonsearchbutton() throws Exception{
		
		// need to be decided
		
		return this;
	}
	
	
	public PlantsPageMap clickonresetbutton() throws Exception{
		
		// need to be decided
		
		return this;
	}
	
	public PlantsPageMap clickonSavePlantbutton() throws Exception{
		
		// need to be decided
		
		return this;
	}
	
	
public PlantsPageMap clickonsaveMoveTimeButton() throws Exception{
		
		// need to be decided
		
		return this;
	}
	
public PlantsPageMap clickonSavecompanyButton() throws Exception{
	
	// need to be decided
	
	return this;
}

public PlantsPageMap clickonDeleteCompanyButton() throws Exception{
	
	// need to be decided
	
	return this;
}

	
	
public void setWebDriver(WebDriver webDriver) {
		
		this.webDriver = webDriver;
		
	}

	public PlantsPageMap(SharedDriver webDriver){
		
		this.webDriver = webDriver;
	
	}
	
}
