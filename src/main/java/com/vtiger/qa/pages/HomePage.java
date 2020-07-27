package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vtiger.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(id="menu")
	WebElement menuLink;
	
	@FindBy(xpath="//a[contains(text(),'Dashboard')]")
	WebElement dashboardLabel;
	
	@FindBy(xpath="//span[contains(text(),'Leads funnel')]")
	WebElement vtigerLogo;
	
	@FindBy(xpath="//i[@class='fas fa-rocket text-white']")
	WebElement startOnboardLink;
	
	@FindBy(xpath="//i[@class='fas fa-plus']")
	WebElement quickCreateRecordsLink;
	
	@FindBy(xpath="//i[@class='fas fa-search']")
	WebElement searchLink;
	
	@FindBy(xpath="//i[@class='fas fa-user-circle']")
	WebElement userProfileLink;
	
	@FindBy(xpath="//span[contains(text(),'Leads funnel')]")
	WebElement leadsFunnelPanel;
	
	@FindBy(xpath="//span[contains(text(),'Closed sales')]")
	WebElement closedSalesPanel;
	
	@FindBy(xpath="//span[contains(text(),'Product sales')]")
	WebElement productSalesPanel;
	
	@FindBy(xpath="//span[contains(text(),'Average sale value')]")
	WebElement avgSaleValuePanel;
	
	@FindBy(xpath="//span[contains(text(),'Sales funnel')]")
	WebElement SalesFunnelPanel;
	
	@FindBy(xpath="//span[contains(text(),'Weighted revenue of open deals')]")
	WebElement weightedRevenuePanel;
	
	@FindBy(xpath="//span[contains(text(),'Deals created')]")
	WebElement dealsCreatedPanel;
	
	@FindBy(xpath="//span[contains(text(),'Average sales cycle')]")
	WebElement avgSalesCyclePanel;
	
	@FindBy(xpath="//span[contains(text(),'Lead First follow-up time')]")
	WebElement leadfirstFollowUpPanel;
	
	@FindBy(xpath="//span[contains(text(),'Activity daily count for this month')]")
	WebElement activityDailyCountPanel;
	
	@FindBy(xpath="//span[contains(text(),'Follow-ups per Lead')]")
	WebElement followUpPerLeadPanel;
	
	@FindBy(xpath="//span[contains(text(),'Deal win rate')]")
	WebElement dealWinRatePanel;
	
	@FindBy(xpath="//span[@class='f-600']")
	WebElement monthDates;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement addWidgetsBtn;
	
	@FindBy(xpath="//span[contains(text(),'Filters')]")
	WebElement filtersBtn;
	
	@FindBy(xpath="//i[@class='fa p-1 fa-angle-down']")
	WebElement mySalesDashboardLink;
	
	@FindBy(xpath="//i[@class='fas fa-question h4 mb-0 text-primary']")
	WebElement questionLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyVtigerLogo() {
		return vtigerLogo.isDisplayed();
	}
	
	public boolean verifyMenuLink() {
		return menuLink.isDisplayed();
		
	}
	

}
