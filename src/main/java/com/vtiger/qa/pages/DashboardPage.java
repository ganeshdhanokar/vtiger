
package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class DashboardPage extends LoginPage{
	
	@FindBy(xpath = "//div/i[@id='openmenu']")
	@CacheLookup
	WebElement clickDashboardIcon;
	
	@FindBy(className = "h4")
	@CacheLookup
	WebElement getDashboardHeading;
	
	
	public DashboardPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickDashbaordIcon() 
	{
		clickDashboardIcon.click();
	}
	public void getDashboardHead()
	{
		String ActualTitle = getDashboardHeading.getText();
		String ExpectedTitle = "Dashboard";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}


	/*
	Sales Insights
	Help Desk Insights */
	
}
