package com.test.newjob;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderDate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");

		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,900)");

	//	List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
		int count = driver.findElements(By.className("flatpickr-day")).size();

		for (int i = 0; i < count; i++) {

			String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();

			if (text.equalsIgnoreCase("21")) {
				driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
				break;
			}

		}
	}

}
