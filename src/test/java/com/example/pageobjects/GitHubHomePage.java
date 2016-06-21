package com.example.pageobjects;

import com.example.setup.PageLoadHelper;
import org.openqa.selenium.By;

import static com.example.setup.SeleniumDriver.getDriver;

/**
 * Page object GitHub home page.
 *
 * Created by Sargis on 4/3/16.
 */

public class GitHubHomePage extends BaseObjectPage<GitHubHomePage> {


    public GitHubHomePage() {
        super(getDriver());
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public GitHubLoginPage goToLoginPage() {
        return new GitHubLoginPage().openPage(GitHubLoginPage.class);
    }

    public GitHubHomePage open() {
        return new GitHubHomePage().openPage(GitHubHomePage.class);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        PageLoadHelper.isLoaded().
                isElementIsVisible(By.cssSelector("input[name='user[login]']")).
                isElementIsClickable(By.cssSelector("input[name='user[login]']"));
    }
}
