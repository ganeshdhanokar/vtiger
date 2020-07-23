package com.vtiger.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.HomePage;
import com.vtiger.qa.pages.IndexPage;
import com.vtiger.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		
		openBrowser(property.getProperty("browser"));
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Login - Vtiger");
	}
	
	@Test(priority=2)
	public void logoTest() {
		boolean res = loginPage.validateLogo();
		System.out.println("Logo Displayed:"+res);
		Assert.assertTrue(res);
	}
	
	@Test(priority=3)
	public void googleLinkTest() {
		boolean res1 = loginPage.validateGoogleLink();
		System.out.println("Link Displayed:"+res1);
		Assert.assertTrue(res1);
	}
	
	@Test(priority=4)
	public void microsoftLinkTest() {
		boolean res = loginPage.validateMicrosoftLink();
		Assert.assertTrue(res);
	}
	
	@Test(priority=5)
	public void linkedInLinkTest() {
		boolean res2= loginPage.validateLinkedInLink();
		Assert.assertTrue(res2);
	}
	
	@Test(priority=6)
	public void loginTest() {
		loginPage.loginVtiger(property.getProperty("username"), property.getProperty("password"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}

}
