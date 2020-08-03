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
import com.vtiger.qa.utility.VerifyPageImages;
import com.vtiger.qa.utility.VerifyPageLinks;

public class IndexPageTestCases extends TestBase {

	public static IndexPage indexPage;
	
	@BeforeMethod
	
	public void setup() {
		//initialization(property.getProperty("browser"));
		indexPage = new IndexPage();
	}

	@Test(priority = 0, description = "verifies title of index page")
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), property.getProperty("indexPageTitle"));
	}

	@Test(priority = 1, description = "verify logo")
	public void verifyLogo() {
		Assert.assertEquals(indexPage.verifyVtigerLogo(), true);

	}

	@Test(priority = 2, description = "Check products dropdown")
	public void checkProductsDropdown() {
		indexPage.hoverOnProductsDropdown();
		Assert.assertEquals(indexPage.linksCountInProductsDropdown(), 4);
	}

	@Test(priority = 3, description = "verify pricing link")
	public void verifyPricingLink() {
		indexPage.clickOnPricingLink();
		Assert.assertEquals(driver.getTitle(), property.getProperty("pricingTitle"));
	}

	@Test(priority = 4, description = "Check products dropdown")
	public void checkResourcesDropdown() {
		indexPage.hoverOnResourcesDropdown();
		Assert.assertEquals(indexPage.linksCountInResourcesDropdown(), 8);
	}

	@Test(priority = 5, description = "verify covid link")
	public void verifyCovidLink() {
		indexPage.clickCovidDiscountLink();
		Assert.assertEquals(driver.getTitle(), property.getProperty("covidPageTitle"));
	}

	@Test(priority = 6, description = "verifies login link")
	public void verifyLoginLink() {
		indexPage.clickLoginLink();
		Assert.assertEquals(driver.getTitle(), property.getProperty("loginPageTitle"));
	}

	@Test(priority = 7, description = "verifies Sign up link")
	private void verifySignUpLink() {
		indexPage.clickSignupLink();
		Assert.assertEquals(driver.getTitle(), property.getProperty("signupPageTitle"));
	}

	@Test(priority = 8, description = "verifies all links on Index Page")
	public void verifyIndexPageLinks() {
		Assert.assertTrue(VerifyPageLinks.verifyLinks());
	}

	@Test(priority = 9, description = "verifies all images on Index Page")
	public void verifyIndexPageImages() {
		Assert.assertTrue(VerifyPageImages.verifyImages());
	}

}
