
package com.test.newjob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException { // TODO
  WebDriverManager.chromedriver().setup();
  ChromeOptions options = new ChromeOptions();
  options.addArguments("--remote-allow-origins=*"); WebDriver driver = new
  ChromeDriver(options);
  
  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
  
  
	/*
	 * driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(
	 * );
	 * 
	 * driver.findElement(By.xpath("//a[@value='BLR']")).click();
	 * 
	 * Thread.sleep(2000);
	 * 
	 * driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click(); // method
	 * 1-index method for dynamic dropdown driver.findElement(By.
	 * xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']"
	 * )) .click(); // method 2- Parent-Child relationship locator method for
	 * dynamic dropdown
	 */
  
  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
  
  System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
  
  
  driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
  
  System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
  
  
  
  
  
  
  
  
  }

}
