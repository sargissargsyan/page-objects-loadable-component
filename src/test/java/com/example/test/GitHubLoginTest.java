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
	public void should_not_login_with_wrong_credentials() {
		//given
		GitHubLoginPage loginPage = new GitHubHomePage().open().goToLoginPage();
		//when
		loginPage.login("user", "password");
		//then
		assertTrue(loginPage.isLoginError());
	}
}
