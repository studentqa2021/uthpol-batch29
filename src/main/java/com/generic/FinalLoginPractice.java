package com.generic;

//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class FinalLoginPractice {

	public static void getFinalLogin() {

		// Login ==>https://magento.softwaretestingboard.com/
		// open browser
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();

		WebDriver driver = DriverManager.getDriver("chrome");

		driver.manage().window().maximize();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SeleniumWait.getImplicitWait(driver, 3);
		
		// got to Application
//		driver.navigate().to("https://magento.softwaretestingboard.com/");
		driver.navigate().to(Constants.URL);
		ScreenShot.getScreenShot(driver, "HomePage");
		
		// click sign in button
//		driver.findElement(By.xpath("(//*[@class='authorization-link']/a)[1]")).click();

		SeleniumPageFactory pf =new SeleniumPageFactory(driver);
		HighLighter.getColor(driver,pf.getSigninButton(), "red");
		
		
		pf.getSigninButton().click();
		ScreenShot.getScreenShot(driver, "LoginPage");
		// put email
//		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sarowerny@gmail.com");
		HighLighter.getColor(driver,pf.getEmail(), "green");
		pf.getEmail().sendKeys(Constants.email);
		// out password
		HighLighter.getColor(driver,pf.getPassword(), "blue");
//		driver.findElement(By.xpath("//*[@title='Password']")).sendKeys("Student123$");
//		driver.findElement(By.xpath(Constants.password)).sendKeys("Student123$");
		
		pf.getPassword().sendKeys(Constants.password);
		HighLighter.getColor(driver,pf.getSubmitButton(), "yellow");
		// click 2nd sign in
//		driver.findElement(By.xpath("//*[@class='action login primary']")).click();
		
	    pf.getSubmitButton().click();
		ScreenShot.getScreenShot(driver, "LoginValidation");

		// validate = welcome sarower =xpath ==> is displayed = true = passed

//		if (driver.findElement(By.xpath("(//*[contains(text(),'Welcome')])[1]")).isDisplayed()) {// true
//
//			System.out.println("Test passed");
//		} else {// not true
//			System.out.println("Test failed");
//		}
		// never tell test passed ==> but always told when test fail

		// explicit wait
//		Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'Welcome')])[1]")).isDisplayed());

	    SoftAssert sf = new SoftAssert();
		sf.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'Welcome')])[1]")).isDisplayed());
		sf.assertAll();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
		
		
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		FinalLoginPractice.getFinalLogin();
	}

}
