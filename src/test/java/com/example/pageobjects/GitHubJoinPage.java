package com.example.pageobjects;

import com.example.setup.PageLoad;
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


    @Override
    public String getPageUrl() {
        return "/join";
    }

    @Override
    protected void load() {

    }

//    public GitHubJoinPage openPage() {
//        return new GitHubJoinPage().openPage(GitHubJoinPage.class);
//    }

    public boolean isLoginError() {
        return isElementDisplayed(errorBox);
    }

    @Override
    protected void isLoaded() throws Error {
        if (!PageLoad.isElementIsClickable(By.cssSelector("input[id='user_login']"))) {
            throw new Error("Join page was not loaded successfully!");
        }
    }
}
