package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//a[2]//img[1]")
	WebElement linkedInLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
