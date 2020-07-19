package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class SignUpPage {
	
	@FindBy(xpath="//a[@class='navbar-btn btn btn-sm btn-primary ml-2']")
	@CacheLookup
	WebElement clickSignUpButton;

	public void clickSignUpButton()
	{
		clickSignUpButton.click();
	}
}
