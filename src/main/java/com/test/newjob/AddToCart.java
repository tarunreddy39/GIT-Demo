package com.test.newjob;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String[] requiredItems = { "Beans", "Tomato", "Cauliflower" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver, requiredItems);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("button.promoBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] requiredItems) {

		int size = requiredItems.length;

		List<WebElement> itemsList = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < itemsList.size(); i++) {

			String[] productArr = itemsList.get(i).getText().split("-");

			String product = productArr[0].trim();

			List<String> itemsNeededList = Arrays.asList(requiredItems);
			int count = 0;
			if (itemsNeededList.contains(product)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				count++;
			}

			if (count == size)
				break;
		}
	}

}
