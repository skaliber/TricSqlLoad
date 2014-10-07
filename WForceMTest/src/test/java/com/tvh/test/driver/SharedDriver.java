package com.tvh.test.driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.tvh.test.locators.UsersUrl;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



public class SharedDriver extends EventFiringWebDriver {



	private static WebDriver REAL_DRIVER;
	

	//private static final WebDriver REAL_DRIVER = new FirefoxDriver();

    // public static final WebDriver REAL_DRIVER = new InternetExplorerDriver();

	private static final Thread CLOSE_THREAD = new Thread() {

		@Override

		public void run() {

		REAL_DRIVER.close();

		}

	};

	static {

		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
		 
		  System.setProperty("webdriver.chrome.driver",UsersUrl.chromedriver);
		 REAL_DRIVER = new ChromeDriver();
	}



	public SharedDriver() {

		super(REAL_DRIVER);

	}
	

	@Before

	public void deleteAllCookies() {

		manage().deleteAllCookies();
		REAL_DRIVER.manage().window().maximize();
	}

	@Override

	public void close() {

		if (Thread.currentThread() != CLOSE_THREAD) {

			throw new UnsupportedOperationException(

					"You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");

		}

		super.close();

	}


	@After

	public void embedScreenshot(Scenario scenario) {

		try {

			byte[] screenshot = getScreenshotAs(OutputType.BYTES);

			scenario.embed(screenshot, "image/png");

		} catch (WebDriverException somePlatformsDontSupportScreenshots) {

			System.err

					.println(somePlatformsDontSupportScreenshots.getMessage());

		}

		

		
		REAL_DRIVER.quit();
        
		

	}

	



}

