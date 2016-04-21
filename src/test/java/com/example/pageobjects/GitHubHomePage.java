package com.example.pageobjects;

import com.example.setup.PageLoad;
import org.openqa.selenium.By;

/**
 * Page object GitHub home page.
 *
 * Created by Sargis on 4/3/16.
 */

public class GitHubHomePage extends GitHubPage<GitHubHomePage> {


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
		if(!PageLoad.isElementIsClickable(By.cssSelector("input[name='user[login]']"))) {
			throw new Error("Home page was not successfully loaded");
		}

	}
}
