package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.vtiger.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	
	
	@FindBy(xpath="//div[@id=navbarCollapse']/a[2]")
	@CacheLookup
	WebElement clickSignUpButton;


	public void clickSignUpLink()
	{
		clickSignUpButton.click();
	}
}
