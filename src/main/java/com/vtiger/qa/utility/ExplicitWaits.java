package com.vtiger.qa.utility;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.qa.base.TestBase;

public class ExplicitWaits extends TestBase{
	
	private static WebDriverWait wait;
	
	public static void explicitWaitForTitle(String title, long timeInSeconds) {
		wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.titleIs(title));
	}
}
