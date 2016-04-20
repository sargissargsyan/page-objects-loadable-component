package com.example.pageobjects;

import com.example.setup.PageLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page object GitHub login page
 *
 * Created by Sargis on 4/3/16.
 */
public class GitHubLoginPage extends GitHubPage<GitHubLoginPage> {

	@FindBy(id = "login_field")
	WebElement loginField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(name = "commit")
	WebElement commitButton;

	@FindBy(className = "flash-error")
	WebElement errorBox;

	@Override
	public String getPageUrl() {
		return "/login";
	}

	public void login(String login, String password) {
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		commitButton.click();

	}

	public boolean isLoginError() {
		return errorBox.isDisplayed();
	}

	public String getErrorMessage() {
		return errorBox.getText();
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {
		if(!PageLoad.isElementIsClickable(By.className("input[id='login_field']"))) {
			throw new Error("Login page was not successfully loaded");
		}
	}
}
