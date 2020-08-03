package com.vtiger.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.DashboardPage;
import com.vtiger.qa.pages.IndexPage;
import com.vtiger.qa.pages.LoginPage;
import com.vtiger.qa.utility.ExplicitWaits;

public class DashboardPageTestCases extends TestBase {
	IndexPage indexPage;
	LoginPage loginPage;
	DashboardPage dashboardPage;

	@BeforeMethod
	public void setup() {
		indexPage = new IndexPage();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		indexPage.clickLoginLink();
		loginPage.enterUsername(property.getProperty("username"));
		loginPage.enterPassword(property.getProperty("password"));
		loginPage.clickOnSignInButton();
		ExplicitWaits.explicitWaitForTitle(property.getProperty("dashboardPageTitle"), 20);
		Assert.assertEquals(driver.getTitle(), property.getProperty("dashboardPageTitle"));
	}

	@Test
	public void verifyDashboardTitle() {
		Assert.assertEquals(driver.getTitle(), property.getProperty("dashboardPageTitle"));
	}

	@Test
	public void verifyLogout() {
		dashboardPage.clickOnUserButton();
		dashboardPage.clickOnLogout();
		ExplicitWaits.explicitWaitForTitle(property.getProperty("loginPageTitle"), 20);
		Assert.assertEquals(driver.getTitle(), property.getProperty("loginPageTitle"));
	}

	@Test
	public void createContact() throws InterruptedException {
		Thread.sleep(10000);
		dashboardPage.clickOnCreateRecord();
		dashboardPage.clickOnContact();
		dashboardPage.addContactDetails("abc","pqr","abc@getnada.com","2345672948");

	}

}
