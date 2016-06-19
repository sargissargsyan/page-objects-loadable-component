package com.example.test;

import com.example.pageobjects.GitHubJoinPage;
import com.example.setup.SeleniumBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by sargis on 6/19/16.
 */
public class GitHubJoinTest extends SeleniumBaseTest {
    @Test
    public void usernameExistTest() {
        //navigate to login page
        GitHubJoinPage joinPage = new GitHubJoinPage().openPage(GitHubJoinPage.class);

        //try to login
        joinPage.registerNewUser("user", "emial@mail.com", "password");
        assertTrue(joinPage.isLoginError(), "Error message should be visible!");
    }
}
