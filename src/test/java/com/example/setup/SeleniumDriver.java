package com.example.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Selenium driver wrapper
 *
 * Created by Sargis on 4/3/16.
 */
public class SeleniumDriver {

	static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
		}
		return driver;
	}

}
