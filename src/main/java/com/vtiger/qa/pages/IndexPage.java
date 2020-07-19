package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.qa.base.TestBase;

public class IndexPage extends TestBase {
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginLink;
	
	@FindBy(className = "navbar-btn btn btn-sm btn-primary ml-2")
	WebElement signUpLink;
	
	@FindBy(xpath = "//a[contains(text(),'Products')]")
	WebElement productsDropDown;
	
	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement pricingDropDown;
	
	@FindBy(xpath = "//a[text()=' COVID']")
	WebElement covidDiscountLink;
	
	@FindBy(xpath="//img[@class='navbar-brand-img']")
	WebElement vtigerLogo;
	
	public void clickLoginLink() {
		loginLink.click();
		System.out.println("click");
	}
	
	public void clickSignupLink() {
		signUpLink.click();
	}
	
	public void clickProductsDropdown() {
		productsDropDown.click();
	}
	
	public void clickPricingDropdown() {
		pricingDropDown.click();
	}
	
	public void clickCovidDiscountLink() {
		covidDiscountLink.click();
	}
	
	public void verifyVtigerLogo() {
		vtigerLogo.isDisplayed();
		
	}

}
