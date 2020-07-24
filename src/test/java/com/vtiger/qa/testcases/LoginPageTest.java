package com.vtiger.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

	
	@BeforeClass
	public void setUp() {
		initialization(property.getProperty("browser"));
		indexPage = new IndexPage();
		loginPage = indexPage.clickLoginLink();
				
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
	
	@Test(priority=10)
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
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}

}
