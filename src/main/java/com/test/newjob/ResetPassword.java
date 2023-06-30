package com.test.newjob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResetPassword {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
		 * ChromeOptions(); options.addArguments("--remote-allow-origins=*");
		 */
		 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String userName = "Rahul";
		String password = resetPassword(driver);
		driver.findElement(By.cssSelector("div[class='forgot-pwd-btn-conainer'] button.go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("form input[placeholder='Username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(password);
		driver.findElement(By.cssSelector("div button[class='submit signInBtn']")).click();

		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h1")).getText());
	}

	public static String resetPassword(WebDriver driver) throws InterruptedException {

		driver.findElement(By.cssSelector("div[class='forgot-pwd-container'] a ")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		String message = driver.findElement(By.cssSelector(".infoMsg")).getText();

		String[] split = message.split("'");

		String password = split[1].split("'")[0];

		return password;

	}
}
