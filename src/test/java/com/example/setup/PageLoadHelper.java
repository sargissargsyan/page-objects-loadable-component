package com.example.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.example.setup.SeleniumDriver.getDriver;

/**
 * PageLoadHelper
 *
 * Created by Sargis on 4/3/16.
 */
public class PageLoadHelper {
    public static PageLoadHelper isLoaded() {
        PageLoadHelper loadHelper = new PageLoadHelper();
        return loadHelper;
    }


    public PageLoadHelper isElementIsClickable(By by) {
        try {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(by));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not clickable");
        }
    }

    public PageLoadHelper isElementIsVisible(By by) {
        try {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(by));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not visible");
        }
    }
}
