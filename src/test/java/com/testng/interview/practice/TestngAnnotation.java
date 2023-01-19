package com.testng.interview.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotation {

	@BeforeSuite
	public void setupSuite() {
		System.out.println("This is BeforeSuite");
	}

	@BeforeTest
	public void setup() {
		System.out.println("This is BeforeTest");
	}

	@BeforeClass
	public void setupClass() {
		System.out.println("This is BeforeClass");
	}

	@BeforeMethod
	public void setupMethod() {
		System.out.println("This is BeforeMethod");
	}

	@AfterMethod
	public void closeMethod() {
		System.out.println("This is AfterMethod");
	}

	@AfterClass
	public void closeClass() {
		System.out.println("This is AfterClass");
	}

	@AfterTest
	public void close() {
		System.out.println("This is AfterTest");
	}

	@AfterSuite
	public void closeSuite() {
		System.out.println("This is AfterSuite");
	}

	@Test
	public void getsalary() {
		System.out.println("This is Test one");

	}

}
