package com.tvh.test.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ErrorHandler.UnknownServerException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DriverErrors {

	public static Boolean verifyElementPresent(WebDriver webdriver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(webdriver, Setup.EXPLICIT_WAIT);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} 
		 catch (NoSuchElementException | NoSuchFrameException | NoSuchWindowException | UnknownServerException | TimeoutException e) {
				Setup.VERIFICATION_ERRORS.append(
						"Element: " + locator + " is not present on page \n -Caugth exception: "
						+ e.getMessage() + "\n\n");
				return false;
		 }
	}
}