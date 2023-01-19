package com.generic;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestngFactory {

	public class TestngReviewPractice {
		String a;
		String b;

		@Factory(dataProvider = "myLoginDataprovider")
		public TestngReviewPractice(String x, String y) {// static = no; void = no
			this.a = x;
			this.b = y;
		}

		@BeforeTest
		public void setup() {
			System.out.println("Before Test");
		}

		@Test
		public void getSmoke() {// test =3, run =no

			System.out.println("This is 1st test");
			System.out.println(a);
			System.out.println(b);

		}

		@Test

		public void getRegression() {// test =2

			System.out.println("This is 2nd test");
			System.out.println(a);
			System.out.println(b);
		}

		@AfterTest
		public void teardown() {
			System.out.println("After test");
		}

		@DataProvider(name = "myLoginDataprovider")
		public Object[][] dataProviderMethod() {

			return new Object[][] { { "user", "sahmmed" }, { "password", "dsda1234" } };
		}

	}

}
