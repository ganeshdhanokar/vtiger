package com.vtiger.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
	public static WebDriver driver;

	public static Logger logger;
	
	@BeforeSuite
	public void setupSuite() {
		 
		logger= Logger.getLogger("vtiger");
		PropertyConfigurator.configure("log4j.properties");
		
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
	
	public static void initialization(@Optional("CHROME") String browserName) {
	
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
		//driver.manage().timeouts().pageLoadTimeout(Long.parseLong(property.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Long.parseLong(property.getProperty("implicitTimeout")), TimeUnit.SECONDS);
		
	}
}
