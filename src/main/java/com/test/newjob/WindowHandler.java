package com.test.newjob;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");

		driver.findElement(By.className("blinkingText")).click();

		Set<String> windowsAddr = driver.getWindowHandles();

		Iterator<String> itr = windowsAddr.iterator();

		String parentWindow = itr.next();
		String childWindow = itr.next();

		driver.switchTo().window(childWindow);

		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());

	}

}
