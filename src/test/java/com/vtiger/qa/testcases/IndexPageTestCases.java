package com.vtiger.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.IndexPage;

public class IndexPageTestCases extends TestBase {
	
	IndexPage indexpage;
	
	@BeforeClass
	public void setup() {
		indexpage = new IndexPage();
	}
	
	
	@Test
	public void verifyTitle() {

		Assert.assertEquals(driver.getTitle(), "CRM Software | Customer Relationship Management System - Vtiger CRM");
	}
	
	//@Test
	public void verifyLoginLink() {
		indexpage.clickLoginLink();
		//assertEquals(actual, expected);
		//
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();

	}
	
}
