package pageUIMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class DriverClass {
	
	private WebDriver driver;
	
	public void setFirefoxDriver(){
		driver = new FirefoxDriver();
	}
	public void setIEDriver(){
		driver = new InternetExplorerDriver();
	}
	
	public void SetHTMLUnitDriver(){
		
		driver = new HtmlUnitDriver();
		((HtmlUnitDriver) driver).setJavascriptEnabled(true);
		
	}
	
	public void SetChromeDriver(){
		
		System.setProperty("webdriver.chrome.driver","E:\\G\\workspacejava\\WForceMTest\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void quitDriver(){
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}
