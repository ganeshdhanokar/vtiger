package com.vtiger.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	public static Properties property;
	public static WebDriver driver;
	
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

}
