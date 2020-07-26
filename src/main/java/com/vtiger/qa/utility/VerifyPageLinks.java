package com.vtiger.qa.utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vtiger.qa.base.TestBase;

public class VerifyPageLinks extends TestBase {
	public static boolean verifyLinks() {
		boolean flag = true;
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		int size = elements.size();
		for (int i = 0; i < size; i++) {
			WebElement element = elements.get(i);
			String link = element.getAttribute("href");
			try {
				URL url = new URL(link);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(3000);
				connection.connect();
				if (connection.getResponseCode() == 200) {
					System.out.println(link + " - " + connection.getResponseMessage());
				}
				if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					System.out.println(
							link + " - " + connection.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
					flag = false;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
}
