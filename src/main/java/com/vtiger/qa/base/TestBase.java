package com.vtiger.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties property;
	public static WebDriver driver= null;
	
	@BeforeSuite
	public void setupSuite() {
		 
		try {
			property = new Properties();
			FileInputStream file = new FileInputStream(".\\src\\main\\java\\com\\vtiger\\qa\\config\\config.properties");
			property.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@BeforeTest
	@Parameters("browser")
	public static void openBrowser(@Optional("CHROME") String browserName) {
	
		switch (browserName) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "OPERA":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		default:
			System.err
					.println("Invalid Browser name " + browserName + ". Expected Expected CHROME, IE, FIREFOX, OPERA");
			break;
		}
		
		driver.get(property.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

}
