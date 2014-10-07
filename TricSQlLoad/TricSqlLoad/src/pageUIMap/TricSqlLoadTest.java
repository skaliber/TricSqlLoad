package pageUIMap;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.General;

public class TricSqlLoadTest {
	private DriverClass driver;
	
	public TricSqlLoadTest(DriverClass driver){
		this.driver = driver;
	}
	
	
	public TricSqlLoadTest SearchforMakeAndModel() throws Exception{
		
		driver.getDriver().navigate().to("http://cosminlazar:8080/TricSQL/?key=INTERNAL&userid=user1");
		
		 final  WebElement machineEquipment = driver.getDriver().findElement(By.xpath("//a[@wicketpath='defineModelSearchPanel_selectEquipmentTypeBox_equipTypeGroup_0_equipTypeGroupLink']/img"));
		   machineEquipment.click();
		   
		   Thread.sleep(3000);
		   
		   WebElement makeAutoComplete = driver.getDriver().findElement(By.name("makeAutoComplete"));
		   
		   //defineModelSearchPanel_tabs_panel_searchBox_searchPartForm_makeAutoComplete
		//   WebElement makeAutoComplete = (new WebDriverWait(driver, 3, 500l))
//		       .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='defineModelSearchPanel_tabs_panel_searchBox_searchPartForm_makeAutoComplete']")));
		   makeAutoComplete.clear();
		   makeAutoComplete.sendKeys("TOYOTA");//
		   
		   WebElement selectmake = (new WebDriverWait(driver.getDriver(), 3, 500l))
		             .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='wicket-aa']/ul/li[1]")));
		   selectmake.click();
		     
		   WebElement inputMoldel = (new WebDriverWait(driver.getDriver(), 3, 500l))//
		               .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='defineModelSearchPanel_tabs_panel_searchBox_searchPartForm_modelContainer_modelAutoComplete']")));
		     
		   inputMoldel.clear();
		   inputMoldel.sendKeys("02-7FD10");
		     
		     
		   WebElement selectbutton = (new WebDriverWait(driver.getDriver(), 3, 500l))
		             .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='defineModelSearchPanel_tabs_panel_searchBox_searchPartForm_selectBtn']")));
		     
		   selectbutton.click();
		    
		   WebElement searchbutton = (new WebDriverWait(driver.getDriver(), 3, 500l))
		           .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='defineModelSearchPanel_tabs_panel_searchSpecPanel_refineSearchBox_searchBtn']")));
		     
		   searchbutton.click();
		
		
		
		return this;
		
	}	
	
	public TricSqlLoadTest stayOnPage(int time){
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return this;
	}
}
