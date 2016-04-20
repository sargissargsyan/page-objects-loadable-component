package com.example.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.example.setup.SeleniumDriver.getDriver;

/**
 * PageLoad
 *
 * Created by Sargis on 4/3/16.
 */
public class PageLoad {
    public static boolean isElementIsClickable (By by) {

        try
        {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(by));
        }
        catch (WebDriverException ex)
        {
            return false;
        }
        return true;
    }
}
