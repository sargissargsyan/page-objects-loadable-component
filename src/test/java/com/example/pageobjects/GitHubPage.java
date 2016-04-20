package com.example.pageobjects;

import static com.example.setup.SeleniumDriver.getDriver;

import com.example.setup.CustomLoadableComponent;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Sargis on 4/3/16.
 */

public abstract class GitHubPage<T> extends CustomLoadableComponent {

	private static final String BASE_URL = "https://github.com";


	public T openPage(Class<T> clazz) {
		T page = PageFactory.initElements(getDriver(), clazz);
		getDriver().get(BASE_URL + getPageUrl());
		return page;
	}

	/**
	 * Provides condition when page can be considered as fully loaded.
	 *
	 * @return
	 */
//	protected abstract ExpectedCondition getPageLoadCondition();

	/**
	 * Provides page relative URL/
	 *
	 * @return
	 */
	public abstract String getPageUrl();
}
