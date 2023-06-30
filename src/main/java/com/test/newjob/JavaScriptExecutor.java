package com.test.newjob;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

		int sum = 0;
		List<WebElement> data = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		for (int i = 0; i < data.size(); i++) {

			int num = Integer
					.parseInt(driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")).get(i).getText());

			sum = sum + num;
		}
		System.out.println("Sum : " + sum);

		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

		System.out.println("Total : " + total);

		Assert.assertEquals(sum, total);
	}

}
