package com.vtiger.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.utility.MouseActions;

public class IndexPage extends TestBase {

	LoginPage loginpage;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginLink;
	
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	WebElement signUpLink;
	
	@FindBy(xpath = "//a[contains(text(),'Products')]")
	WebElement productsDropDown;
	
	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement pricingLink;
	
	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement resourcesDropDown;
	
	@FindBy(xpath = "//a[text()=' COVID']")
	WebElement covidDiscountLink;
	
	@FindBy(xpath="//img[@class='navbar-brand-img']")
	WebElement vtigerLogo;
	

	public LoginPage clickLoginLink() {
		loginLink.click();
		
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickLoginLink() {
		loginLink.click();
		return new LoginPage();
	}
	
	public SignUpPage clickSignupLink() {
		signUpLink.click();
		return new SignUpPage();
	}
	
	
	public boolean verifyVtigerLogo() {
		return vtigerLogo.isDisplayed();	
	}
	
	public void hoverOnProductsDropdown() {
		MouseActions.mouseHover(productsDropDown);
	}
	
	public int linksCountInProductsDropdown() {
		List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='dropdown-menu dropdown-menu-md-2']/a"));
		return productsList.size();
	}
	
	public  PricingPage clickOnPricingLink() {
		pricingLink.click();
		return new PricingPage();
	
	}
	
	public void hoverOnResourcesDropdown() {
		MouseActions.mouseHover(resourcesDropDown);
	}
	
	public int linksCountInResourcesDropdown() {
		List<WebElement> resourcesList = driver.findElements(By.xpath("//div[@class='dropdown-menu']/a"));
		return resourcesList.size();
	}
	
	public CovidPage clickCovidDiscountLink() {
		covidDiscountLink.click();
		return new CovidPage();
	}

}
