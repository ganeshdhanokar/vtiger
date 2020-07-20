package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	
	
	@FindBy(xpath="//a[contains(text(),'Sign up')]")
	@CacheLookup
	WebElement clickSignUpButton;
	
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickSignUpLink()
	{
		clickSignUpButton.click();
	}
}
