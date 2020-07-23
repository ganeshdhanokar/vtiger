package com.vtiger.qa.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.vtiger.qa.base.TestBase;

public class MouseActions extends TestBase{
public static void mouseHover(WebElement webElement) {
	Actions actions = new Actions(driver);
	Action action = actions.moveToElement(webElement).build();
	action.perform();
}
}
