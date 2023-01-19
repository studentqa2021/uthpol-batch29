package com.cucumber.test;

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

public class StepDef {
	WebDriver driver;
	SeleniumPageFactory pf;

	@Given("open any browser")
	public void open_any_browser() {

		driver = DriverManager.getDriver("chrome");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);

	}

	@Given("go to app url")
	public void go_to_app_url() {
		driver.navigate().to(Constants.URL);
		ScreenShot.getScreenShot(driver, "Home Page");
	}

	@Given("click signin button")
	public void click_signin_button() {
		pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSigninButton(), 3);
		HighLighter.getColor(driver, pf.getSigninButton(), "red");
		pf.getSigninButton().click();
		ScreenShot.getScreenShot(driver, "Login Page");
	}

	@When("enter valid email")
	public void enter_valid_email() {
		SeleniumWait.getExplicitWait(driver, pf.getEmail(), 3);
		HighLighter.getColor(driver, pf.getEmail(), "red");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.email);
	}

	@When("enter valid passward")
	public void enter_valid_passward() {
		SeleniumWait.getExplicitWait(driver, pf.getPassword(), 3);
		HighLighter.getColor(driver, pf.getPassword(), "red");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.password);
	}

	@When("click submit buttion")
	public void click_submit_buttion() {
		HighLighter.getColor(driver, pf.getSubmitButton(), "red");
		pf.getSubmitButton().click();
	}

	@Then("Validate login was successful")
	public void validate_login_was_successful() {
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
