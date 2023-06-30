package com.test.newjob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

		System.out.println(driver.findElement(By.id("output")).getText());

		driver.findElement(By.id("alertBox")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		System.out.println("After Accept " + driver.findElement(By.id("output")).getText());

	}

}
