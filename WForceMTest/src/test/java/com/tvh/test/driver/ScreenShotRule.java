package com.tvh.test.driver;

import org.apache.commons.io.FileUtils;

import org.junit.rules.TestWatcher;

import org.junit.runner.Description;

import org.openqa.selenium.Capabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import java.io.File;

import java.io.IOException;

public class ScreenShotRule extends TestWatcher {

	private WebDriver browser;
	public ScreenShotRule(WebDriver browser) {

		this.browser = browser;
	}

	@Override

	public void failed(final Throwable e, final Description description) {

		// when a test will fail this method is invoked and ovverided

		System.out

				.println("HERE WE need to take a screenshot before clossing the browser for a FAILINGL test");

		takeTheScreenshot("FAILED", description.getMethodName());
	}

	@Override

	public void succeeded(final Description description) {



		System.out

				.println("HERE WE need to take a screenshot before clossing the browser for a SUCCESSFULL test");

		takeTheScreenshot("PASSED", description.getMethodName());

	}

	private void takeTheScreenshot(String testStatus, String testName) {

		TakesScreenshot takesScreenshot = (TakesScreenshot) browser;

		File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		File destFile = getDestinationFile(testStatus, testName);

		try {

			FileUtils.copyFile(scrFile, destFile);

		} catch (IOException ioe) {

			throw new RuntimeException(ioe);

		}

	}



	private File getDestinationFile(String testStatus, String testName) {

		String baseFilePath = null;

		if (testStatus == "FAILED") {

			baseFilePath = "C:/screenshots/AUTOMATION_SCREENSHOTS/Failed";

		} else if (testStatus == "PASSED") {

			baseFilePath = "C:/screenshots/AUTOMATION_SCREENSHOTS/Passed";

		}

		String fileName = RemoveSpecialChars(testName);

		// obtaibn browser name and version

		Capabilities caps = ((RemoteWebDriver) browser).getCapabilities();

		String browserName = caps.getBrowserName();

		String browserVersion = caps.getVersion();

		String absoluteFileName = baseFilePath + "/" + fileName + "_Browser_"

				+ browserName + browserVersion + ".png";



		return new File(absoluteFileName);

	}



	private String RemoveSpecialChars(String testName) {



		String alphaOnly = testName.replaceAll("[^a-zA-Z]+", "");

		return alphaOnly;

	}

}