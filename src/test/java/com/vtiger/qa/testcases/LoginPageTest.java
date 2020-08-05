package com.vtiger.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vtiger.qa.base.TestBase;
import com.vtiger.qa.pages.HomePage;
import com.vtiger.qa.pages.IndexPage;
import com.vtiger.qa.pages.LoginPage;
import com.vtiger.qa.utility.ReadExcel;
import com.vtiger.qa.utility.VerifyPageImages;

public class LoginPageTest extends TestBase {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	
	/*public LoginPageTest() {
		super();
	}*/
	
	@BeforeMethod(groups= {"smoke"})

	public void setup() {
		
		loginPage = new LoginPage();
		indexPage = new IndexPage();
		indexPage.clickLoginLink();

	}
	
	@Test(priority=0)
	public void loginPageTitleTest() {
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Login - Vtiger");
	}
	
	@Test(priority=1)
	public void logoTest() {
		boolean res = loginPage.validateLogo();
		System.out.println("Logo Displayed:"+res);
		Assert.assertTrue(res);
	}
	
	@Test(priority=2, description="Google Link Test at LoginPage")
	public void googleLinkTest() {
		boolean res1 = loginPage.validateGoogleLink();
		System.out.println("Link Displayed:"+res1);
		Assert.assertTrue(res1);
	}
	
	@Test(priority=4)
	public void microsoftLinkTest() {
		boolean res = loginPage.validateMicrosoftLink();
		Assert.assertTrue(res);
	}
	
	@Test(priority=5)
	public void linkedInLinkTest() {
		boolean res2= loginPage.validateLinkedInLink();
		Assert.assertTrue(res2);
	}
	
	@Test(priority=6)
	public void loginTest() {
		homePage = loginPage.loginVtiger(property.getProperty("username"), property.getProperty("password"));
	}
	
	@Test(priority = 7, description = "verifies all images on login Page")
	public void verifyLoginPageImages() {
		Assert.assertTrue(VerifyPageImages.verifyImages());
	}
	

@Test(priority = 8)
public void verifyUsernameRequired() {
	loginPage.clickOnSignInButton();
	Assert.assertEquals(loginPage.userNameRequiredMessage(),"Please fill out this field.");
}

@Test(priority = 9)
public void verifyPasswordRequired() {
	loginPage.enterUsername(property.getProperty("username"));
	loginPage.clickOnSignInButton();
	Assert.assertEquals(loginPage.passwordRequiredMessage(),"Please fill out this field.");
}
	
	@Test( dataProvider="login", description ="Checks login functionality", priority = 10)
	public void verifyLoginFunctionality(String uid, String pass, String expectedTitle)  {
		loginPage.loginVtiger(uid, pass);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
	@Test
	public void testDataPath() {
		System.out.println(property.getProperty("testDataPath"));

	}
	
	@DataProvider(name = "login")
	public static Object[][] getLoginCredentials() throws IOException {
		Object[][] loginCredentials = ReadExcel.getData("Login");
		return loginCredentials;
	}
}

