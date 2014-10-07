//package com.tvh.test.driver;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.Assume.assumeTrue;
//
//import org.apache.commons.io.FileUtils;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.opera.core.systems.OperaDriver;
//
//import org.openqa.selenium.Platform;
//
//import com.thoughtworks.selenium.Selenium;
//import com.tvh.test.locators.UsersUrl;
//
//
//public class AbstractSeleniumTest {
//
//
//
//	private static final String USER_DIR = System.getProperty("user.dir");
//
//	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
//
//	private static final String CHROME_DRIVER_URL = USER_DIR
//
//			+ "/src/test/java/browserDrivers/chromedriver.exe";
//
//	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
//
//	// private static final String IE_DRIVER_X32_URL = USER_DIR +
//
//	// "/src/test/java/resources/IEDriverServerWin32.exe";
//
//	private static final String IE_DRIVER_X64_URL = USER_DIR
//
//			+ "/src/test/java/browserDrivers/IEDriverServerX64.exe";
//
//	public static String URL = UsersUrl.GOOGLE_URL;
//
//
//
//	// HERE YOU CAN EASILY CHANGE THE BROWSER
//
//	protected static Browser browser = Browser.FIREFOX;
//
//
//
//	protected static Selenium server;
//
//	protected static WebDriver webDriver;
//
//
//
//	protected enum Browser {
//
//		CHROME, IE, FIREFOX, OPERA, SAFARI, ANDROID;
//
//
//
//	};
//
//
//	protected static void buildFirefox() {
//
//		webDriver = new FirefoxDriver();
//
//		webDriver.get("");
//
//		// webDriver.manage().window().maximize();
//
//	}
//
//
//
//	public static void buildChromeDriver() {
//
//		System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_URL);
//
//		webDriver = new ChromeDriver();
//
//	}
//
//
//
//	public static void buildIEDriver() {
//
//		System.setProperty(IE_DRIVER_PROPERTY, IE_DRIVER_X64_URL);
//
//		webDriver = new InternetExplorerDriver();
//
//	}
//
//
//
//	public static void buildOpera() {
//
//		webDriver = new OperaDriver();
//
//		webDriver.get("");
//
//	}
//
//
//
////	public static void buildAndroid() {
////
////		webDriver = new AndroidDriver();
////
////		webDriver.get("");
////
////	}
//
//
//
//	public static void buildSafari() {
//
//		assumeTrue(isSupportedPlatform());
//
//		webDriver = new SafariDriver();
//
//
//
//	}
//
//
//
//	protected static boolean isSupportedPlatform() {
//
//		Platform current = Platform.getCurrent();
//
//		return Platform.MAC.is(current) || Platform.WINDOWS.is(current);
//
//	}
//
//
//
//	/*
//
//	 * ~ THIS IS FOR JENKINS INTEGRATION ~ public static String URL =
//
//	 * System.getProperty("automated.tests.url"); private static Browser browser
//
//	 * = Browser.getEnum(System.getProperty("automated.tests.browser"));
//
//	 * 
//
//	 * public static Browser getEnum(String enumAsString) { if
//
//	 * (enumAsString.equals("ie")) { return IE; } else if
//
//	 * (enumAsString.equals("firefox")) { return FIREFOX; } else if
//
//	 * (enumAsString.equals("chrome")) { return CHROME; }
//
//	 * 
//
//	 * return CHROME; }
//
//	 */
//
//
//
//	protected static void CreateFolderIfMissing(String path) {
//
//
//
//		File dir = new File(path);
//
//		if (!dir.exists()) {
//
//			dir.mkdirs();
//
//		}
//
//	}
//
//
//
//	protected static void waitSeconds(int seconds) {
//
//		StopWatch stopWatch = new StopWatch();
//
//		stopWatch.start();
//
//		while (stopWatch.getElapsedTimeSecs() < seconds) {
//
//		}
//
//		stopWatch.stop();
//
//	}
//
//
//
//	public static WebElement VerifyElementExists(By find) {
//
//		// returns the object element that we searched for if it exists ,
//
//		// or the test fails with an error message if it doesn't exists;
//
//		WebDriverWait wait = new WebDriverWait(webDriver, 15);
//
//		WebElement objectToSearchFor = null;
//
//		try {
//
//			objectToSearchFor = wait.until(ExpectedConditions
//
//					.elementToBeClickable(find));
//
//		} catch (Exception ex) {
//
//			Assert.assertNotNull("FAILED: The Element with following locator: "
//
//					+ find + " could not be found ! " + "_Exception :" + ex,
//
//					objectToSearchFor);
//
//		}
//
//
//
//		return objectToSearchFor;
//
//	}
//
//
//
//	public static WebElement DoesElementExists(By find) {
//
//		// returns the object element that we searched for if it exists ,
//
//		// or the test fails with an error message if it doesn't exists;
//
//		WebDriverWait wait = new WebDriverWait(webDriver, 3);
//
//		WebElement objectToSearchFor = null;
//
//		try {
//
//			objectToSearchFor = wait.until(ExpectedConditions
//
//					.elementToBeClickable(find));
//
//		} catch (Exception ex) {
//
//		}
//
//
//
//		return objectToSearchFor;
//
//	}
//
//
//
//	public static List<WebElement> VerifyListOfElementsExists(By find) {
//
//		// returns the list with elements that have the same locator ,
//
//		// or the test fails with an error message if it doesn't exists;
//
//		// WebDriverWait wait = new WebDriverWait(webDriver, 15);
//
//		List<WebElement> listToSearchFor = null;
//
//		try {
//
//			listToSearchFor = webDriver.findElements(find);
//
//		} catch (Exception ex) {
//
//			Assert.assertNotNull(
//
//					"FAILED: The List of elements with following locator: "
//
//							+ find + " could not be found ! " + "_Exception :"
//
//							+ ex, listToSearchFor);
//
//		}
//
//
//
//		return listToSearchFor;
//
//	}
//
//
//
//	protected void takeTheScreenshotOnDisk(String testStatus, String testName) {
//
//
//
//		TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
//
//		File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//
//		File destFile = getDestinationFile(testStatus, testName);
//
//		try {
//
//			FileUtils.copyFile(scrFile, destFile);
//
//		} catch (IOException ioe) {
//
//			throw new RuntimeException(ioe);
//
//		}
//
//
//
//	}
//
//
//
//	/*
//
//	 * protected InputStream captureTheScreenshot() {
//
//	 * 
//
//	 * TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver; byte[]
//
//	 * InputStreem = takesScreenshot.getScreenshotAs(OutputType.BYTES); return
//
//	 * InputStreem;
//
//	 * 
//
//	 * }
//
//	 */
//
//
//
//	protected File getDestinationFile(String testStatus, String testName) {
//
//
//
//		String baseFilePath = null;
//
//		if (testStatus == "FAILED") {
//
//			baseFilePath = "C:/screenshots/AUTOMATION_SCREENSHOTS/Failed";
//
//		} else if (testStatus == "PASSED") {
//
//			baseFilePath = "C:/screenshots/AUTOMATION_SCREENSHOTS/Passed";
//
//		}
//
//		String fileName = RemoveSpecialChars(testName);
//
//		// obtaibn browser name and version
//
//		Capabilities caps = ((RemoteWebDriver) webDriver).getCapabilities();
//
//		String browserName = caps.getBrowserName();
//
//		String browserVersion = caps.getVersion();
//
//		String absoluteFileName = baseFilePath + "/" + fileName + "_Browser_"
//
//				+ browserName + browserVersion + ".png";
//
//
//
//		return new File(absoluteFileName);
//
//	}
//
//
//
//	protected String RemoveSpecialChars(String testName) {
//
//
//
//		String alphaOnly = testName.replaceAll("[^a-zA-Z]+", "");
//
//		return alphaOnly;
//
//	}
//
//}
//
