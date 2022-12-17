package com.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import com.drivermanager.DriverManager;
//import com.github.dockerjava.api.model.Driver;

public class SeleniumWait {

	// conditional wait
	public static void getImplicitWait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	public static void getImplicitWait(WebDriver driver, int time) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public static void getExplicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void getExplicitWait(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// unconditional sleep, not used in this project
	public static void getUnconditonalSleep(WebDriver driver) {
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void getUnconditonalSleep2(WebDriver driver) {

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
