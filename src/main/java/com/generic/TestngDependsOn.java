package com.generic;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngDependsOn {

	@BeforeTest
	public void setup() {
		System.out.println("Before Test");
	}
	//manager = run smoke 1st(if smoke passed)>>then run regression(if regression passed)>>
	//then run functional 
	@Test()
	public void getSmoke() {//test =3, run =no
		
		System.out.println("This is 1st test");
	}
	@Test(dependsOnMethods = {"getSmoke"})// wait for getsmoke run finish
	public void getRegression() {//test =2
		
		System.out.println("This is 2nd test");
	}
	@Test(dependsOnMethods = {"getRegression"})//wait until getregression run finish
	public void getFunctional() {//test =1, run =no
		
		System.out.println("This is 3rd test");
	}
	@AfterTest
	public void teardown() {
		System.out.println("After test");
	}
	
}
