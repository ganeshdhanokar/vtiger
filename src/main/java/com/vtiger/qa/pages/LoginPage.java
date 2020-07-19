package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.qa.base.TestBase;

public class LoginPage extends TestBase{
	HomePage homepage = new HomePage();
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-block']")
	WebElement signInBtn;
	
	@FindBy(xpath="//span[text()='Sign in with Google']")
	WebElement googleSigninLink;
	
	@FindBy(xpath="//a[text()='Forgot Password ?']")
	WebElement forgotPassLink;
	
	@FindBy(xpath="//a[text()='Start Free Trial']")
	WebElement freeTrialLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public HomePage loginVtiger(String uid, String pass) {
		username.sendKeys(uid);
		password.sendKeys(pass);
		signInBtn.click();
		return new HomePage();
		
	}

}
