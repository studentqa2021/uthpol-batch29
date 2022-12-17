package com.cucumber.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FinalStefDef {


		WebDriver driver;
		SeleniumPageFactory pf;
		
	@Given("open browser")
	public void open_browser() {
		driver = DriverManager.getDriver("chrome");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
	}

	@Given("go to url page")
	public void go_to_url_page() {
		driver.navigate().to(Constants.URL);
		ScreenShot.getScreenShot(driver, "HomePage");
	}

	@Given("click signin")
	public void click_signin() {
		pf =new SeleniumPageFactory(driver);
		HighLighter.getColor(driver,pf.getSigninButton(), "red");
		pf.getSigninButton().click();
		ScreenShot.getScreenShot(driver, "LoginPage");
	}

	@When("put valid email")
	public void put_valid_email() {

		HighLighter.getColor(driver,pf.getEmail(), "green");
		
		pf.getEmail().sendKeys(Constants.email);
	}

	@When("put valid pass")
	public void put_valid_pass() {
		HighLighter.getColor(driver,pf.getPassword(), "blue");
		pf.getPassword().sendKeys(Constants.password);
		
	}

	@When("click submit")
	public void click_submit() {
	    
		HighLighter.getColor(driver,pf.getSubmitButton(), "yellow");
		pf.getSubmitButton().click();
	
	}

	@Then("validate login")
	public void validate_login() {
		ScreenShot.getScreenShot(driver, "LoginValidation");
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
}
