package com.test.newjob;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www2.asx.com.au/");

		List<WebElement> rowElements = driver
				.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[2]/table/tr"));
		System.out.println(rowElements.size());

		List<WebElement> colElements = driver
				.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[2]/table/tr[1]/th"));
		System.out.println(colElements.size());

		int rowSize = rowElements.size();
		int colSize = colElements.size();

		for (int i = 2; i <= rowSize; i++) {
			for (int j = 1; j <= colSize; j++) {

				System.out.print(driver
						.findElement(By.xpath(
								"//*[@id=\"home_top_five\"]/div/div[1]/div/div[2]/table/tr["+i+"]/td["+j+"]/div/div/a"))
						.getText() + " ");
			}
			System.out.println();
		}
		driver.quit();

	}

}
