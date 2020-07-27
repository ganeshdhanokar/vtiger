package com.vtiger.qa.utility;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vtiger.qa.base.TestBase;



public class VerifyPageImages extends TestBase{
	public static boolean verifyImages() {
		boolean flag = true;
		List<WebElement> elements = driver.findElements(By.tagName("img"));
		int size = elements.size();
		for (int i = 0; i < size; i++) {
			WebElement element = elements.get(i);
			String src = element.getAttribute("src");
			try {
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(src);
				HttpResponse response = client.execute(request);
				// verifying response code here HttpStatus should be 200 if not,
				// increment as invalid images count
				if (response.getStatusLine().getStatusCode() == 200)
					System.out.println(src + " - " + response.getStatusLine().getReasonPhrase());
				else
				{
					System.out.println(src + " - image not available");
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
