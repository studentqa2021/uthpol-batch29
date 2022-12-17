package com.selenium.pagefactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	
	 WebDriver driver;

	public SeleniumPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "(//*[@class='authorization-link'])[1]") 
	private WebElement signinButton;    

	@FindBy(xpath = "//*[@name='login[username]']")
	private WebElement email;

	@FindBy(xpath = "//*[@name='login[password]']")
	private WebElement password;

	@FindBy(xpath = "//*[@class='action login primary']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@class='logged-in']")  
	private List<WebElement> welcome;  
	public WebElement getSigninButton() {
		return signinButton;
	}
	
	
	@FindBy(xpath = "//*[@id ='header_sign_in']") 
	private WebElement costcoSigninButton;
	
	@FindBy(xpath = "//*[@name='login[username]']")
	private WebElement costcoEmail;
	
	@FindBy(xpath = "//*[@name='login[username]']")
	private WebElement costcoPass;
	
	@FindBy(xpath = "//*[@class='action login primary']")
	private WebElement costcoSubmitBtn;
	
	
	
	
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCostcoSigninButton() {
		return costcoSigninButton;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public List<WebElement> getWelcome() {
		return welcome;
	}
}
