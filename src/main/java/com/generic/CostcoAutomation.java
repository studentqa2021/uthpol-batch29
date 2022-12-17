package com.generic;

//import org.openqa.selenium.WebDriver;
//import org.testng.asserts.SoftAssert;
//
//import com.drivermanager.DriverManager;
//import com.selenium.pagefactory.SeleniumPageFactory;
//import com.util.Constants;
//import com.util.HighLighter;
//import com.util.ScreenShot;
//import com.util.SeleniumWait;

public class CostcoAutomation {

//	public static void productHandle() {
//		// go to cs web pg
//		WebDriver driver = DriverManager.getDriver("chrome");
//		driver.manage().window().maximize();
//		driver.navigate().to(Constants.COSTCO_URL);
//
//		// imp wait
//		SeleniumWait.getImplicitWait(driver, 5);
//
//		// get title
//		System.out.println("homePage / titleName = " + driver.getTitle());
//
//		// scrsht1
//		ScreenShot.getScreenShot(driver, "Costco home welcome page");
//
//		// chk current url
//
//		System.out.println("currentURL = " + driver.getCurrentUrl());
//
//		SoftAssert sf = new SoftAssert();
//		sf.assertEquals(driver.getCurrentUrl(), Constants.COSTCO_URL);
//
//		// click sign in
//
//		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
//
//		// highlight
//		HighLighter.getColor(driver, pf.getCostcoSigninButton(), "red");
//
//		pf.getCostcoSigninButton().click();
//
//		// get page name
//		System.out.println("Login page title/name = " + driver.getTitle());
//
//		// scrsht2
//		ScreenShot.getScreenShot(driver, "Costco Sign In page");
//
////		// go back to page
////
////		try {
////			Thread.sleep(3000);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
////
////		driver.navigate().back();
////
////		driver.navigate().back(); //costco web problem	
////		
//////		
//////		for(int i=0;i<10;i++) {
//////			if (pf.getCostcoSigninButton().size()>0)
//////			{
//////				break;
//////			
//////		}else {
//////			driver.navigate().back();
//////			Thread.sleep(3000);
//////		}
////		
////		while(2==2) {//true
////			if (pf.getCostcoSigninButton().size()>0)
////				{
////					break;
////				
////			}else {
////				driver.navigate().back();
////				Thread.sleep(3000);
////		}
////
////		}
//
//		sf.assertAll();
//	}
//
//
//
//
//
//	public static void main(String[] args) {
//		CostcoAutomation.productHandle();
//	}

}
