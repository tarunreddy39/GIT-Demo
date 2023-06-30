package com.test.newjob;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		Date currentDate = new Date();
		String timeSTamp = currentDate.toString().replace(" ", "-").replace(":", "-");
		driver.manage().window().maximize();
		driver.get("https://www2.asx.com.au/");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(".//screenshot//" + timeSTamp + ".png"));

	Date nextDate=new Date();
	System.out.println(nextDate);
		System.out.println("Screenshot token sucessfully");
		driver.quit();
	}

}
