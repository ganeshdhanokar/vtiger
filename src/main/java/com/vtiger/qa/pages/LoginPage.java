package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
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
	
	@FindBy(xpath="//img[@class='mb-4']")
	WebElement vtigerLogo;
	
	@FindBy(xpath="//form[@id='com-form-login']//a[1]//img[1]")
	WebElement microsoftSignInLink;
	
	@FindBy(xpath="//a[2]//img[1]")
	WebElement linkedInLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo() {
		return vtigerLogo.isDisplayed();
	}
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean validateGoogleLink() {
		return googleSigninLink.isDisplayed();
	}
	
	public boolean validateMicrosoftLink() {
		return microsoftSignInLink.isDisplayed();
	}
	
	public boolean validateLinkedInLink() {
		return linkedInLink.isDisplayed();
	}
	
	public HomePage loginVtiger(String uid, String pass) {
		username.sendKeys(uid);
		password.sendKeys(pass);
		signInBtn.click();
		return new HomePage();
		
	}


}
