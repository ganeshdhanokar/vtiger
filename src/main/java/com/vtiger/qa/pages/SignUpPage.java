package com.vtiger.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.vtiger.qa.base.TestBase;

public class SignUpPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	@CacheLookup
	WebElement clickSignUpButton;

	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	WebElement textEnterEmail;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement clickNextButton;

	@FindBy(xpath = "//div[@class='text-danger mb-4']")
	WebElement heading;

	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	WebElement clickPrivacyPolicy;

	@FindBy(xpath = "//a[contains(text(),'Products')]")
	WebElement getPrivacyPolictTab;

	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement getTermsConditionTab;

	public SignUpPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public void clickSignUpLink() 
	{
		clickSignUpButton.click();
	}

	public void enterMail() 
	{
		// textEnterEmail.click();
		textEnterEmail.sendKeys("suresh@getnada.com");
	}

	public void clickNextButton() 
	{
		clickNextButton.click();

	}

	/*
	 * public boolean isPageOpened(){
	 * 
	 * return heading.getText().toString().
	 * contains("You have reached the limit on signup attempts, please contact"); }
	 */

	public void sendVerificationMail() 
	{
		String ActualTitle = heading.getText();
		String ExpectedTitle = "You have reached the limit on signup attempts, please contact support@vtiger.com for further assistance.";
		Assert.assertEquals(ExpectedTitle, ActualTitle);

	}

	public void clickPrivacyPolicy() 
	{
		clickPrivacyPolicy.click();
	}

	public void getNewTabPrivacyPolicy() 
	{

		String originalWindow = driver.getWindowHandle();
		String newWindow;
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> stringIterator = windowHandles.iterator();

		while (stringIterator.hasNext()) {
			newWindow = stringIterator.next();
			if (!originalWindow.equalsIgnoreCase(newWindow)) {
				driver.switchTo().window(newWindow);
				System.out.println("Privacy Policy | Vtiger CRM " + getPrivacyPolictTab.getText());
				WebDriverWait wait = new WebDriverWait(driver,100);
			}
		}
		//driver.close(); /// In here I should close the new window

		driver.switchTo().window(originalWindow);
		WebDriverWait wait = new WebDriverWait(driver,10000);
	}

	public void getNewTabTermsCondition() 
	{
		String originalWindow = driver.getWindowHandle();
		String newWindow;
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> stringIterator = windowHandles.iterator();

		while (stringIterator.hasNext()) 
		{
			newWindow = stringIterator.next();
			if (!originalWindow.equalsIgnoreCase(newWindow)) {
				driver.switchTo().window(newWindow);
				System.out.println("Terms of Service | Vtiger CRM" + getPrivacyPolictTab.getText());
				WebDriverWait wait = new WebDriverWait(driver,500);
			}
		}
		//driver.close(); /// In here I should close the new window

		driver.switchTo().window(originalWindow);
	} 
}
