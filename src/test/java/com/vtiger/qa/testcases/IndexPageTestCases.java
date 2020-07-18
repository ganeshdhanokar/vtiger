package com.vtiger.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;

public class IndexPageTestCases extends TestBase {
	@Test
	public void verifyTitle() {

		Assert.assertEquals(driver.getTitle(), "CRM Software | Customer Relationship Management System - Vtiger CRM");
	}
	
}
