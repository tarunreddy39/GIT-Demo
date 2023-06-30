package com.test.newjob;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");

		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");

		driver.findElement(By.xpath("//label[2]/span[@class='checkmark']")).click();
		
		driver.switchTo().alert().accept();

		Select dropDown = new Select(driver.findElement(By.cssSelector("select.form-control")));

		dropDown.selectByVisibleText("Consultant");

		driver.findElement(By.cssSelector("input#terms")).click();

		driver.findElement(By.id("signInBtn")).click();

	}

}
