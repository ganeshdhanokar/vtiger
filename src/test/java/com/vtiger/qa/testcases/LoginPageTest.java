package com.vtiger.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.HomePage;
import com.vtiger.qa.pages.IndexPage;
import com.vtiger.qa.pages.LoginPage;
import com.vtiger.qa.utility.VerifyPageImages;

public class LoginPageTest extends TestBase {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	
	/*public LoginPageTest() {
		super();
	}*/
	
	@BeforeMethod

	public void setup() {
		
		loginPage = new LoginPage();
		indexPage = new IndexPage();
		indexPage.clickLoginLink();

	}
	
	@Test(priority=8)
	public void loginPageTitleTest() {
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Login - Vtiger");
	}
	
	@Test(priority=9)
	public void logoTest() {
		boolean res = loginPage.validateLogo();
		System.out.println("Logo Displayed:"+res);
		Assert.assertTrue(res);
	}
	
	@Test(priority=10, description="Google Link Test at LoginPage")
	public void googleLinkTest() {
		boolean res1 = loginPage.validateGoogleLink();
		System.out.println("Link Displayed:"+res1);
		Assert.assertTrue(res1);
	}
	
	@Test(priority=11)
	public void microsoftLinkTest() {
		boolean res = loginPage.validateMicrosoftLink();
		Assert.assertTrue(res);
	}
	
	@Test(priority=12)
	public void linkedInLinkTest() {
		boolean res2= loginPage.validateLinkedInLink();
		Assert.assertTrue(res2);
	}
	
	@Test(priority=13)
	public void loginTest() {
		homePage = loginPage.loginVtiger(property.getProperty("username"), property.getProperty("password"));
	}
	
	@Test(priority = 7, description = "verifies all images on login Page")
	public void verifyLoginPageImages() {
		Assert.assertTrue(VerifyPageImages.verifyImages());
	}
}
