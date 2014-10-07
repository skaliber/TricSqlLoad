package com.tvh.tricsql.test.load.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

public enum SeleniumDriver {
	
	HtmlUnit,
	Firefox, 
	InternetExplorer,
	Chrome;
	
	public static WebDriver getDriver(SeleniumDriver seleniumDriver) {
		
		WebDriver driver;
		
		switch (seleniumDriver) {
			case Firefox : 
				driver = new FirefoxDriver();
				break;
			case InternetExplorer  : 
				System.setProperty("webdriver.ie.driver", "D:\\TVH\\Tools\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case Chrome  :
				//System.setProperty("webdriver.chrome.driver", "C:\\work\\Projects\\Java\\Java_tools\\SeleniumDriver\\chrome\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", "D:\\TVH\\Tools\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			default:
				driver = new HtmlUnitDriver (BrowserVersion.FIREFOX_24){
					
					@Override
					protected WebClient modifyWebClient(WebClient client) {
						client.setAjaxController(new NicelyResynchronizingAjaxController());
						client.getOptions().setThrowExceptionOnScriptError(false);
						client.getOptions().setJavaScriptEnabled(true);
						return super.modifyWebClient(client);
					}
				};	
				break;
		}
		
		return driver;
	}
	
	public static SeleniumDriver getDriver(String driverName) {
		
		SeleniumDriver result;
		
		switch (driverName) {
			case "Firefox" : 
				result = Firefox;
				break;
			case "InternetExplorer"  : 
				result = InternetExplorer;
				break;
			case "Chrome"  : 
				result = Chrome;
				break;
			default:
				result = HtmlUnit;
				break;
		}
		
		return result;
	}
}
