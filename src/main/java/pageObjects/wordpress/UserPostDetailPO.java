package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage {
	WebDriver driver;

	public UserPostDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementClickable(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementClickable(driver, UserPostDetailPageUI.POST_BODY_TEXT, postTitle, postBody);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_BODY_TEXT, postTitle, postBody);
	}

	public boolean isPostInforDisplayedWithAuthor(String postTitle, String authorName) {
		waitForElementClickable(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT, postTitle, authorName);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT, postTitle, authorName);
	}

	public boolean isPostInforDisplayedWithCurrentDay(String postTitle, String currentDay) {
		waitForElementClickable(driver, UserPostDetailPageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

}
