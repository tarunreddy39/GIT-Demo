package com.test.newjob;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Streams {

	// TODO Auto-generated method stub

	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Anand");

		names.add("Tarun");
		names.add("Abhishek");
		names.add("Vijay");
		names.add("Ranjith");
		names.add("Anirudh");

		ArrayList<String> namesOne = new ArrayList<String>();

		namesOne.add("first list");
		namesOne.add("continuation");

		namesOne.addAll(names);

		long c = names.stream().filter(s -> s.startsWith("A")).count();

		System.out.println(c);

		System.out.println(names);
	}

	public void streamMap() {

		Stream.of("kohli", "tarun", "dhoni", "sachin", "kumble", "kapildev").filter(s -> s.startsWith("k"))
				.map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));

	}

	public void webtableSorting() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr/th[1]")).click();

		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

		/*
		 * List<String> originalList = elementList.stream().map(s ->
		 * s.getText()).collect(Collectors.toList());
		 * 
		 * List<String> sortedList =
		 * originalList.stream().sorted().collect(Collectors.toList());
		 * 
		 * Assert.assertTrue(sortedList.equals(originalList));
		 */
		List<String> priceList = elementList.stream().filter(s -> s.getText().contains("Banana"))
				.map(s -> getItemPrice(s)).collect(Collectors.toList());

		priceList.forEach(p -> System.out.println(p));
	}

	private String getItemPrice(WebElement s) {
		// TODO Auto-generated method stub

		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

	public static void main(String[] args) {

		Streams s = new Streams();

		s.webtableSorting();
	}

}
