package com.vtiger.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.IndexPage;
import com.vtiger.qa.pages.LoginPage;

public class IndexPageTestCases extends TestBase {
	
	IndexPage indexPage;
	
	
	@BeforeClass
	public void setup() {
		indexPage = new IndexPage();
	}
	
	@Test(priority=0)
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "CRM Software | Customer Relationship Management System - Vtiger CRM");
	}
	
	@Test(priority=1)
	public void verifyLoginLink() {
		LoginPage loginPage = indexPage.clickLoginLink();
		Assert.assertEquals(driver.getTitle(), "Login - Vtiger");	
	}
	
	private void verifySignUpLink() {
		// TODO Auto-generated method stub

	}
	@AfterClass
	public void tearDown() {
		driver.quit();

	}
	
}
