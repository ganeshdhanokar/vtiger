
package com.vtiger.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.qa.base.TestBase;

public class DashboardPage extends TestBase {
	@FindBy(xpath = "//button[@id='__BVID__11__BV_toggle_']")
	WebElement userbtn;

	@FindBy(xpath = "//div[@title='Logout']")
	WebElement logoutBtn;

	@FindBy(xpath = "//button[@data-track-name='add widget']")
	WebElement addWidgetBtn;

	@FindBy(xpath = "//span[@title='Quick Create Records']")
	WebElement createRecordBtn;

	@FindBy(xpath = "//h5[text()='Contact']//ancestor::div[@class='col-4 p-2 d-inline-flex']")
	WebElement contactBtn;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstnameTxt;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastnameTxt;

	@FindBy(xpath = "//span[@title='Primary Email']")
	WebElement emailChoice;

	@FindBy(xpath = "//li[text()='Secondary Email']")
	WebElement secondaryEmail;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//span[@id='select2-tems-container']")
	WebElement mobilePhoneOptions;
	
	@FindBy(xpath = "	@FindBy(xpath = \"//span[@id='select2-tems-container']\")\r\n" + 
			"	WebElement mobilePhoneOptions;")
	WebElement homephone;

	@FindBy(xpath = "//input[@name='mobile']")
	WebElement mobileNo;

	@FindBy(xpath = "//span[@class='select2-selection__placeholder']")
	WebElement organizationName;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement searchbox;

	@FindBy(xpath = "//span[@name='contacttype']//div[@class='text-danger']")
	WebElement competitor;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnUserButton() {
		userbtn.click();
	}

	public void clickOnLogout() {
		logoutBtn.click();
	}

	public void clickOnAddWidget() {
		addWidgetBtn.click();

	}

	public void clickOnCreateRecord() {
		createRecordBtn.click();
	}

	public void clickOnContact() {
		contactBtn.click();
	}

	public void addContactDetails(String firstname, String lastname, String emailid, String phone) {
		firstnameTxt.sendKeys(firstname);
		lastnameTxt.sendKeys(lastname);
		emailChoice.click();
		secondaryEmail.click();
		secondaryEmail.sendKeys(emailid);
		mobilePhoneOptions.click();
		homephone.click();
		mobileNo.sendKeys(phone);
		organizationName.sendKeys("abc");
		searchbox.click();
		competitor.click();
		
	}

}
