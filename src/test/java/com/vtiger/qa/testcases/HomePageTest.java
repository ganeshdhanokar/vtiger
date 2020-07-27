package com.vtiger.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.HomePage;
import com.vtiger.qa.pages.IndexPage;
import com.vtiger.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public  HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization(property.getProperty("browser"));
		indexPage = new IndexPage();
		loginPage = indexPage.clickLoginLink();	
		homePage = loginPage.loginVtiger(property.getProperty("username"), property.getProperty("password"));
	}
	
	@Test(priority=1)
	public void vtigerLogoTest() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		boolean result = homePage.verifyVtigerLogo();
		Assert.assertTrue(result);
	}
	
	@Test(priority=2)
	public void pageTitleTest() throws InterruptedException {
		Thread.sleep(5000);
		String title = homePage.verifyPageTitle();
		Assert.assertEquals(title, "Dashboard");
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
