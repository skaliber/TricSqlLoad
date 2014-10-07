package com.tvh.tricsql.test.load;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tvh.tricsql.test.load.util.SeleniumDriver;
import com.tvh.tricsql.test.load.util.TestDataConstants;
import com.tvh.tricsql.test.load.util.TestDataLoader;

@RunWith(ParameterizedMultiThreadedRunner.class)
public class WebAppLoadTest extends AutomatedTestBase {

	protected static Logger logger = LoggerFactory.getLogger(WebAppLoadTest.class);
	
	private String make;
	
	private String model;
	
	public WebAppLoadTest(String username, String password, String make, String model) {
		super(username, password);
		this.model =model;
		this.make = make;
	}
	
	@Before
	public void beforeMethod() {
		
		boolean webServiceAvailable = false;
		
		  try {
			URL url = new URL("http://cosminlazar:8080/TricSQL");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestProperty("Connection", "close");
			connection.setConnectTimeout(10000); // Timeout 10 seconds
			connection.connect();
			// If the web service is available
			if (connection.getResponseCode() == 200) {
				webServiceAvailable = true;
			}
		} catch (Exception e) {
			//failed to connect to service
		}
		org.junit.Assume.assumeTrue(webServiceAvailable);
	   
	 }
	
	@Parameters
	public static Collection<Object[]> data() {
		
		List<Object[]> params = new ArrayList<Object[]>();
		
		//TestDataLoader loader = TestDataLoader.getInstance();
		
		List<AutomatedTestBase.UserInfo> users = loadTestUsers(TestDataConstants.Test.LOAD_TEST);
		
		for  ( AutomatedTestBase.UserInfo userInfo : users ) {
			
			int testDataIndex = userInfo.getTestDataIndex();
			
			String make = TestDataLoader.getInstance().getTestData(TestDataConstants.Test.LOAD_TEST, 
					testDataIndex, WebAppLoadTestConstants.MAKE);
			
			String model = TestDataLoader.getInstance().getTestData(TestDataConstants.Test.LOAD_TEST, 
					testDataIndex,  WebAppLoadTestConstants.MODEL);
			
			params.add(new Object [] {userInfo.getUserName(), userInfo.getPassword(), make, model});
		}

		return params;
	}
	
	@Test
	public void testLoadCatalogForModel() {
		
		try {
			WebDriver driver = SeleniumDriver.getDriver(SeleniumDriver.HtmlUnit);
			
			driver.navigate().to(this.webServerAppUrl + userName);
			
			final  WebElement machineEquipment = driver.findElement(By.xpath("//a[@wicketpath='defineModelSearchPanel_selectEquipmentTypeBox_equipTypeGroup_0_equipTypeGroupLink']/img"));
			machineEquipment.click();
			
			Thread.sleep(1500);
			
			WebElement makeAutoComplete = (new WebDriverWait(driver, 20, 200l))
					  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='defineModelSearchPanel_tabs_panel_searchBox_searchPartForm_makeAutoComplete']")));
			makeAutoComplete.clear();
			makeAutoComplete.sendKeys("TOYOTA");//
			//makeAutoComplete.sendKeys("OTA");//
			
			WebElement makelbl = (new WebDriverWait(driver, 20, 200l))
					  .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@wicketpath='defineModelSearchPanel_tabs_panel_searchBox_searchPartForm_label6']")));
			makelbl.click();
			
			Thread.sleep(400);
			
//			logger.info(userName +  " Before Select Make ");
			
//			WebElement selectmake = (new WebDriverWait(driver, 20, 200l))
//			          .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='wicket-aa']/ul/li[1]")));
//			selectmake.click();
			
			Thread.sleep(1000);
			
//			logger.info(userName +  " After Select Make ");
			
			WebElement inputMoldel = (new WebDriverWait(driver, 20, 1000l))//
			            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='defineModelSearchPanel_tabs_panel_searchBox_searchPartForm_modelContainer_modelAutoComplete']")));
			  
			inputMoldel.clear();
			inputMoldel.sendKeys(model);
			  
			WebElement selectbutton = (new WebDriverWait(driver, 20, 1000l))
			          .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='defineModelSearchPanel_tabs_panel_searchBox_searchPartForm_selectBtn']")));
			  
			selectbutton.click();
			
			logger.info(userName +  " after Select Button ");
			
			Thread.sleep(2000);
			 
			WebElement searchbutton = (new WebDriverWait(driver, 20, 1000l))
			        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='defineModelSearchPanel_tabs_panel_searchSpecPanel_refineSearchBox_searchBtn']")));
			
			searchbutton.click();
			
			driver.close();
			
			Assert.assertTrue("Test sucess for user:" + userName, true);
			logger.info("Test sucess for user:" + userName);
			
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(" Test failed for user " + userName + ", error message:"+ e.getMessage());
			Assert.fail("Error " + e.getMessage());
		}
	}
}
