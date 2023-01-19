package com.generic;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeParameterTestng {

	public class PracticeParameterAnnotationTestNG {
		
		@Test
		@Parameters({"URL","user","password"})
		public void test(String URL,String user,String password) {
			System.out.println(URL);
			System.out.println(user);
			System.out.println(password);
		}

	}
	
	
}
