package com.vtiger.qa.testcases;

import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.SignUpPage;

public class SignUpPageTestCase extends TestBase 
{
	SignUpPage signuppage;
	
	@Test(priority = 0)
	public void clickSignUpButton() 
	{
		signuppage= new SignUpPage();
		signuppage.clickSignUpLink();
		logger.info("Click on Sign Up Button");
		
	}
	@Test(priority = 1)
	public void registrationMail()
	{
		signuppage.enterMail();
		logger.info("Enter mail for Registration");
	}
	
	@Test (priority = 2)
	public void clickNextButton()
	
	{
		signuppage= new SignUpPage();
		signuppage.clickNextButton();
		logger.info("Click on Next button of Sign Up page");
	}
	
	/*@Test(priority =3 )
	public void verificationEmailLink()
	{
		signuppage.isPageOpened();
		logger.info("You have reached the limit on signup attempts, please contact support@vtiger.com for further assistance. ");
	}*/
	
	@Test(priority =3 )
	public void sendVerificationMail()
	{
		signuppage.sendVerificationMail();
		logger.info("Mail not send");
	}
	
	@Test(priority = 4)
	public void clickPrivacyPolicy()
	{
		signuppage.clickPrivacyPolicy();
		logger.info("Click on Privacy Policy");
	}
	
	@Test(priority = 5)
	public void getNewTabPrivacyPolicy() 
	{
		signuppage.getNewTabPrivacyPolicy();
		logger.info("Switch to Privacy Policy Tab");
	}
	
	@Test(priority = 6)
	public void getNewTabTermsCondition() 
	{
		signuppage.getNewTabTermsCondition();
		logger.info("Switch to New Tab");
	}
}
