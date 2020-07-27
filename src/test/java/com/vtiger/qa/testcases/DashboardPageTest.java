package com.vtiger.qa.testcases;


import org.testng.annotations.Test;
import com.vtiger.qa.pages.DashboardPage;
import com.vtiger.qa.pages.LoginPage;


public class DashboardPageTest extends LoginPage {

	DashboardPage dbt ;
	LoginPage loginPage;
		

	@Test(priority = 0)
	public void clickDashboardPage()
	{
		dbt= new DashboardPage();
		dbt.clickDashbaordIcon();
		logger.info("Click on Dashbaord");
		
	}
	
	@Test(priority =1 )
	public void getDashbaordHeading()
	{
		dbt.getDashboardHead();
		logger.info("Get Dashbpard Name");
	}
	
}
