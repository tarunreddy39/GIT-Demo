package com.test.newjob;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));

		System.out.println(driver.findElement(with(By.tagName("label")).above(nameField)).getText());
		
		WebElement dateText=driver.findElement(By.cssSelector("[for='dateofBirth']"));
		
		driver.findElement(with(By.tagName("input")).below(dateText)).click();
		
		WebElement checkBox=driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
		
       WebElement radioButton=driver.findElement(By.cssSelector("[for='exampleFormControlRadio1']"));
		
		driver.findElement(with(By.tagName("input")).toRightOf(radioButton)).click();
		
		
		

	}

}
