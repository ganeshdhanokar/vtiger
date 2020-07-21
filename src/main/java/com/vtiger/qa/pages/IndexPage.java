package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void clickProductsDropdown() {
		productsDropDown.click();
	}
	
	public void clickPricingDropdown() {
		pricingDropDown.click();
	}
	
	public void clickCovidDiscountLink() {
		covidDiscountLink.click();
	}
	
	public boolean verifyVtigerLogo() {
		return vtigerLogo.isDisplayed();
		
	}
	
	

}
