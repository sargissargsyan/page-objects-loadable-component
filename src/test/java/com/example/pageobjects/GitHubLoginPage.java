package com.example.pageobjects;

import com.example.setup.PageLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.setup.SeleniumDriver.getDriver;

/**
 * Page object GitHub login page
 *
 * Created by Sargis on 4/3/16.
 */
public class GitHubLoginPage extends BaseObjectPage<GitHubLoginPage> {

    @FindBy(id = "login_field")
    WebElement loginField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "commit")
    WebElement commitButton;

    @FindBy(className = "flash-error")
    WebElement errorBox;

    public GitHubLoginPage() {
        super(getDriver());
    }

    @Override
    public String getPageUrl() {
        return "/login";
    }

    public void login(String login, String password) {
        type(loginField, login);
        type(passwordField, password);
        click(commitButton);
    }

    public boolean isLoginError() {
        return isElementDisplayed(errorBox);
    }

    public String getErrorMessage() {
        return errorBox.getText();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        if (!PageLoad.isElementIsClickable(By.cssSelector("input[id='login_field']"))) {
            throw new Error("Login page was not loaded successfully!");
        }
    }
}
