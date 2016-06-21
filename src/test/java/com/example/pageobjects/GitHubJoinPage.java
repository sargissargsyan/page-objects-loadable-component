package com.example.pageobjects;

import com.example.setup.PageLoadHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.setup.SeleniumDriver.getDriver;

/**
 * Created by sargis on 6/19/16.
 */
public class GitHubJoinPage extends BaseObjectPage<GitHubJoinPage> {
    @FindBy(id = "user_login")
    WebElement usernameField;

    @FindBy(id = "user_email")
    WebElement emailField;

    @FindBy(id = "user_password")
    WebElement passwordField;

    @FindBy(className = "flash-error")
    WebElement errorBox;

    @FindBy(id = "signup_button")
    WebElement joinButton;


    public GitHubJoinPage() {
        super(getDriver());
    }

    public void registerNewUser(String username, String email, String password) {
        type(usernameField, username);
        type(emailField, email);
        type(passwordField, password);
        click(joinButton);
    }

    public boolean isLoginError() {
        return isElementDisplayed(errorBox);
    }

    @Override
    public String getPageUrl() {
        return "/join";
    }

    @Override
    protected void load() {

    }


    @Override
    protected void isLoaded() throws Error {
        PageLoadHelper.isLoaded().
                isElementIsVisible(By.cssSelector("input[id='user_login']")).
                isElementIsClickable(By.cssSelector("input[id='user_login']"));
    }
}
