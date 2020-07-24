package com.vtiger.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.IndexPage;

public class IndexPageTestCases extends TestBase {

	public static IndexPage indexPage;
	
	@BeforeMethod
	
	public void setup() {
		indexPage = new IndexPage();
	}

	@Test(priority = 7, description = "verifies title of index page")
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "CRM Software | Customer Relationship Management System - Vtiger CRM");
	}

	@Test(priority = 8, description = "verify logo")
	public void verifyLogo() {
		Assert.assertEquals(indexPage.verifyVtigerLogo(), true);

	}

	@Test(priority = 9, description = "Check products dropdown")
	public void checkProductsDropdown() {
		indexPage.hoverOnProductsDropdown();
		Assert.assertEquals(indexPage.linksCountInProductsDropdown(), 4);
	}

	@Test(priority = 10, description = "verify pricing link")
	public void verifyPricingLink() {
		indexPage.clickOnPricingLink();
		Assert.assertEquals(driver.getTitle(), "Pricing, Editions and Features - Vtiger CRM");
	}

	@Test(priority = 11, description = "Check products dropdown")
	public void checkResourcesDropdown() {
		indexPage.hoverOnResourcesDropdown();
		Assert.assertEquals(indexPage.linksCountInResourcesDropdown(), 8);
	}

	@Test(priority = 12, description = "verify covid link")
	public void verifyCovidLink() {
		indexPage.clickCovidDiscountLink();
		Assert.assertEquals(driver.getTitle(), "Covid-19: Vtiger's Business Assistance Package | Vtiger CRM");
	}

	@Test(priority = 13, description = "verifies login link")
	public void verifyLoginLink() {
		indexPage.clickLoginLink();
		Assert.assertEquals(driver.getTitle(), "Login - Vtiger");
	}

	@Test(priority = 14, description = "verifies Sign up link")
	private void verifySignUpLink() {
		indexPage.clickSignupLink();
		Assert.assertEquals(driver.getTitle(), "Start Your Free Trial - Vtiger");
	}

	public void verifyClickOnToogleBtn() {
		indexPage.clickOnToggleButton();
	}

	

}
