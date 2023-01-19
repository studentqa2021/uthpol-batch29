package com.testng.interview.practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeTetWithTestNG {

	@BeforeTest
	public void Setup() {
		System.out.println("before test ; all setup code");
	}

	// method name follows alphabetic order , limitation of testNG
	// testNG bring --> priority- to ignore alphabetic order
	// priority follows index theory
	// testNG bring --> enabled = false --> to comment out like java,test will not run

	@Test(priority = 0)
	public void test1() {
		System.out.println("1st test = login");
	}

	@Test(priority = 2)
	public void test2() {
		System.out.println("2nd test = product");
	}

	@Test(priority = 1, enabled = false)
	public void test3() {
		System.out.println("3rd test = cart");
	}

	@AfterTest
	public void teardown() {
		System.out.println("after test ; close connection");
	}

}
