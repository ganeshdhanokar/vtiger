package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.qa.base.TestBase;

public class SignUpPage extends TestBase{
	

	@FindBy(xpath="//ul[@class='rd-navbar-nav']/li[1]/a")
	WebElement clickSignUpLink;
	
	
	public void clickSignUpLink()
	{
		clickSignUpLink.click();
	}
}
