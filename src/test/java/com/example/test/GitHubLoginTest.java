package com.example.test;

import static com.example.setup.SeleniumDriver.getDriver;
import static org.testng.Assert.assertTrue;

import com.example.pageobjects.GitHubHomePage;
import com.example.pageobjects.GitHubLoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class GitHubLoginTest {

	@AfterClass
	public static void tearDown() {
		getDriver().close();
	}

	@Test
	public void shouldNotLoginWithWrongCredentials() {
		//navigate to login page
		GitHubHomePage homePage = new GitHubHomePage().open().get();
		GitHubLoginPage loginPage = homePage.goToLoginPage().get();
		//try to login
		loginPage.login("user", "password");
		//assert there is an error message
		assertTrue(loginPage.isLoginError());
	}
}
