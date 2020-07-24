package com.vtiger.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.IndexPage;

public class IndexPageTestCases extends TestBase {
	
	IndexPage indexPage;
	
	@BeforeClass
	public void setup() {
		initialization(property.getProperty("browser"));
		indexPage = new IndexPage();
	}
	
	@Test(priority=0, description="verifies title of index page")
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "CRM Software | Customer Relationship Management System - Vtiger CRM");
	}
	
	
	@Test(priority=1, description="verify logo")
	public void verifyLogo() {
		Assert.assertEquals(indexPage.verifyVtigerLogo(),true);

	}
	
	@Test(priority=2, description="Check products dropdown")
	public void checkProductsDropdown() {
		indexPage.hoverOnProductsDropdown();
		Assert.assertEquals(indexPage.linksCountInProductsDropdown(), 4);
	}
	
	@Test(priority=3, description="verify pricing link")
	public void verifyPricingLink() {
		indexPage.clickOnPricingLink();
		Assert.assertEquals(driver.getTitle(),"Pricing, Editions and Features - Vtiger CRM");
	}
	
	@Test(priority=4, description="Check products dropdown")
	public void checkResourcesDropdown() {
		driver.navigate().back();
		indexPage.hoverOnResourcesDropdown();;
		Assert.assertEquals(indexPage.linksCountInResourcesDropdown(), 8);
	}
	
	@Test(priority=5, description="verify covid link")
	public void verifyCovidLink() {
		indexPage.clickCovidDiscountLink();;
		Assert.assertEquals(driver.getTitle(), "Covid-19: Vtiger's Business Assistance Package | Vtiger CRM");	
	}
	
	@Test(priority=6, description="verifies login link")
		public void verifyLoginLink() {
			driver.navigate().back();
			indexPage.clickLoginLink();
			Assert.assertEquals(driver.getTitle(), "Login - Vtiger");	
		}
		
	@Test(priority=7, description="verifies Sign up link")
		private void verifySignUpLink() {
			driver.navigate().back();
			indexPage.clickSignupLink();
			Assert.assertEquals(driver.getTitle(), "Start Your Free Trial - Vtiger");
		}
	
	@AfterClass
	public void tearDown() {
		driver.quit();

	}
	
}
