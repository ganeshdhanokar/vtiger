package com.vtiger.qa.testcases;

import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.SignUpPage;

public class SignUpPageTestCase extends TestBase {

	SignUpPage signuppage;

	@Test
	public void clickSignUpButton() {
		signuppage= new SignUpPage();
		signuppage.clickSignUpLink();
		
	}
}
