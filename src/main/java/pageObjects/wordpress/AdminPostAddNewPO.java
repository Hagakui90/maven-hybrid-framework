package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAdNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAdNewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAdNewPageUI.TITLE_TEXTBOX, postTitle);

	}

	public void enterToAddNewPostBody(String postBodyValue) {
		waitForElementClickable(driver, AdminPostAdNewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAdNewPageUI.BODY_BUTTON);

		waitForElementVisible(driver, AdminPostAdNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAdNewPageUI.BODY_TEXTBOX, postBodyValue);

	}

	public void enterToEditPostBody(String postBodyValue) {
		waitForElementClickable(driver, AdminPostAdNewPageUI.BODY_TEXTBOX);
		clickToElement(driver, AdminPostAdNewPageUI.BODY_TEXTBOX);

		waitForElementVisible(driver, AdminPostAdNewPageUI.BODY_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAdNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAdNewPageUI.BODY_TEXTBOX, postBodyValue);

	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAdNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAdNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAdNewPageUI.PUBLISH_OR_UPDATE_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAdNewPageUI.PUBLISH_OR_UPDATE_MESSAGE, postPublishedMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPortUrl) {
		openPageUrl(driver, searchPortUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);

	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAdNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAdNewPageUI.PRE_PUBLISH_BUTTON);

	}
}
