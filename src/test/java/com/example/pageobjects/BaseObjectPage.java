package com.example.pageobjects;

import static com.example.setup.SeleniumDriver.getDriver;

import com.example.setup.CustomLoadableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Sargis on 4/3/16.
 */

public abstract class BaseObjectPage<T extends CustomLoadableComponent<T>> extends CustomLoadableComponent<T> {
    private WebDriver driver;
    private static final String BASE_URL = "https://github.com";

    public BaseObjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public T openPage(Class<T> clazz) {
        T page = PageFactory.initElements(getDriver(), clazz);
        getDriver().get(BASE_URL + getPageUrl());
        return page.get();
    }

    public abstract String getPageUrl();

    public void open(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void type(By inputLocator, String text) {
        find(inputLocator).sendKeys(text);
    }

    public void type(WebElement input, String text) {
        input.sendKeys(text);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
           return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}