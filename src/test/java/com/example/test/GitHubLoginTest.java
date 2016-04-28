package com.example.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.example.pageobjects.GitHubHomePage;
import com.example.pageobjects.GitHubLoginPage;
import com.example.setup.SeleniumBaseTest;
import org.testng.annotations.Test;


public class GitHubLoginTest extends SeleniumBaseTest {

    @Test
    public void shouldNotLoginWithWrongCredentials() {
        //navigate to login page
        GitHubHomePage homePage = new GitHubHomePage().open();
        GitHubLoginPage loginPage = homePage.goToLoginPage();
        //try to login
        loginPage.login("user", "password");
        //assert there is an error message
        assertTrue(loginPage.isLoginError(), "Error message was not displayed!");
        assertEquals(loginPage.getErrorMessage(), "Incorrect username or password.", "Error message was incorrect!");
    }

}
