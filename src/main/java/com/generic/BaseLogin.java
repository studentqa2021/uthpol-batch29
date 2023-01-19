package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class BaseLogin {

	WebDriver driver;
	SeleniumPageFactory pf;

	public void getBaselogin() {

		driver = DriverManager.getDriver("chrome");
		driver.manage().window().maximize();

		SeleniumWait.getImplicitWait(driver, 3);

		driver.navigate().to(Constants.URL);

		ScreenShot.getScreenShot(driver, "Home Page");

		
		
		pf = new SeleniumPageFactory(driver);

		SeleniumWait.getExplicitWait(driver, pf.getSigninButton(), 3);

		HighLighter.getColor(driver, pf.getSigninButton(), "red");
		pf.getSigninButton().click();

		ScreenShot.getScreenShot(driver, "Login Page");

		
		
		SeleniumWait.getExplicitWait(driver, pf.getEmail(), 3);
		HighLighter.getColor(driver, pf.getEmail(), "red");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.email);

		SeleniumWait.getExplicitWait(driver, pf.getPassword(), 3);
		HighLighter.getColor(driver, pf.getPassword(), "red");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.password);

		HighLighter.getColor(driver, pf.getSubmitButton(), "red");
		pf.getSubmitButton().click();

		HighLighter.getColor(driver, pf.getWelcome().get(0), "red");

		ScreenShot.getScreenShot(driver, "Login Validation");
		
		
		
		boolean status = pf.getWelcome().get(0).isDisplayed();

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);

		sa.assertAll();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}
		driver.quit();

	}

}
