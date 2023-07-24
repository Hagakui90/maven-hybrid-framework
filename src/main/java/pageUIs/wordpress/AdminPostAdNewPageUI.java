package pageUIs.wordpress;

public class AdminPostAdNewPageUI {
	public static final String TITLE_TEXTBOX = "xpath=//div[contains(@class,'post-title')]/h1";
	public static final String BODY_TEXTBOX = "xpath=//div[contains(@class,'editor__content-area')]//div/p";
	public static final String BODY_BUTTON = "xpath=//div//div/p[contains(@class,'block-editor-default')]";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "css=div[aria-label='Editor top bar'] button[class*=editor-post-publish-button]";
	public static final String PRE_PUBLISH_BUTTON = "css=div[aria-label='Editor publish'] button[class*=editor-post-publish-button]";
	public static final String PUBLISH_OR_UPDATE_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
