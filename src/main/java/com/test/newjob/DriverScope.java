package com.test.newjob;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println("Total No. of Links in page : "+driver.findElements(By.tagName("a")).size()); // size of all links in the page
		
		WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
		
		System.out.println("No. of Links in footer : "+footerDriver.findElements(By.tagName("a")).size()); // size of all links in the footer
		
		WebElement coloumnDriver=driver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		
		System.out.println("No. of Links in First Coloumn : "+coloumnDriver.findElements(By.tagName("a")).size()); // size of all links in the first coloumn
		
		int size=coloumnDriver.findElements(By.tagName("a")).size();
		
		for (int i=1 ; i<size;i++) {
			
			String pressKey=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			coloumnDriver.findElements(By.tagName("a")).get(i).sendKeys(pressKey);
			
			Thread.sleep(5000);
		}

		Set<String> tabs=driver.getWindowHandles();
		
		Iterator<String> induvidualTab=tabs.iterator();
		
		while(induvidualTab.hasNext()) {
			
			driver.switchTo().window(induvidualTab.next());
			System.out.println("Page Title : "+driver.getTitle());
			
		}
	}

}
