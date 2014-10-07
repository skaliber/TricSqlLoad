package com.tvh.tricsql.test.load;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tvh.tricsql.test.load.util.GlobalSettings;
import com.tvh.tricsql.test.load.util.SeleniumDriver;
import com.tvh.tricsql.test.load.util.TestDataConstants;
import com.tvh.tricsql.test.load.util.TestDataLoader;

public abstract class AutomatedTestBase {
	
	protected String userName;
	
	protected String password;
	
	protected SeleniumDriver seleniumDriver;
	
	protected String webServerAppUrl;
	
	protected AutomatedTestBase(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
		
		this.seleniumDriver = SeleniumDriver.getDriver(
				TestDataLoader.getInstance().getSetting(GlobalSettings.SELENIUM_DRIVER));
		this.webServerAppUrl = TestDataLoader.getInstance().getSetting(GlobalSettings.WEB_SERVER_URL);
	}
	
	public static List<UserInfo> loadTestUsers(TestDataConstants.Test test) {
		
		List<UserInfo> usersList = new ArrayList<UserInfo>();
		int userCount = 1;
		TestDataLoader loader = TestDataLoader.getInstance();
		
		while ( loader.getUserLogin(test, userCount) != null) {
			
			String username = loader.getUserLogin(test, userCount);
			String password = loader.getUserPassword(test, userCount);
			int testDataIndex = Integer.parseInt(loader.getUserTestData(test, userCount));
			
			usersList.add( new UserInfo(username, password, testDataIndex));
			
			userCount++;
		}
		return usersList;
	}
	
	/**
	 * 
	 * Initializes web driver.
	 * 
	 * Override for additional settings
	 * 
	 * @return
	 */
	protected WebDriver initWebDriver() {
		WebDriver driver = SeleniumDriver.getDriver(seleniumDriver);
		return driver;
	}
	
	protected WebDriver loginMyTotalSource() {
		
		WebDriver driver = initWebDriver();
		
		driver.navigate().to(this.webServerAppUrl);

		// Login page 
		final  WebElement form =  driver.findElements(By.xpath("//form[@wicketpath='signInForm']")).get(0);
		
		//username
		final WebElement textField =  form.findElements(By.xpath("//input[@type='text']")).get(0);
		textField.sendKeys(this.userName);
		
		//password
		final WebElement  passwordtextField2 =  form.findElements(By.xpath("//input[@type='password']")).get(0);
		passwordtextField2.sendKeys(this.password);
		
		// submit buttopn
		WebElement login = form.findElements(By.xpath("//input[@type='submit']")).get(0);
		
		//MTS home page
		login.click();
		
		return driver;
	}
	
	public static class UserInfo {
		
		private String userName; 

		private String password; 
		
		private int testDataIndex;
		
		private Object[] testData;

		public UserInfo(String userName, 
					String password, int testDataIndex) {
			super();
			this.userName = userName;
			this.password = password;
			this.testDataIndex = testDataIndex;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getTestDataIndex() {
			return testDataIndex;
		}

		public void setTestDataIndex(int testDataIndex) {
			this.testDataIndex = testDataIndex;
		}
	}
}
