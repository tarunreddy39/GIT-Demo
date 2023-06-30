package com.test.newjob;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGsampleTest {

	@Parameters({ "URL" })
	@Test(priority=2)
	public void Parameter1(String URL) {
		System.out.println(URL);
	}

	@Parameters({ "Tarun", "Goal" })
	@Test
	public void Parameter2(String Tarun, String Goal) {
		System.out.println(Tarun + " " + Goal);
	}

	@Test(dataProvider="RecurringData",priority=1)
	public void DataProvider1Example(String Username, String Password) {
		System.out.println(Username +" "+ Password);
	}
	
	@DataProvider
	public Object[][] RecurringData() {
		
		Object[][] details=new Object[3][2];
		
		details[0][0]="username1";
		details[0][1]="password1";
		details[1][0]="username2";
		details[1][1]="password2";
		details[2][0]="username3";
		details[2][1]="password3";
		
		return details;
	}

	@Test(priority=3)
	public void HelperAttributes1() {
		System.out.println("this is priority 3 ");
	}

	@Test(priority=4)
	public void HelperAttributes2() {
		System.out.println("this is priority 4");
	}

}
