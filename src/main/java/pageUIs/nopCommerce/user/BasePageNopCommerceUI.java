package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {

	public static final String ADDRESS_LINK = "xpath=//a[text()='Addresses']";
	public static final String REWARD_POINTS_LINK = "xpath=//a[text()='Reward points']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//a[text()='My product reviews']";
	public static final String LOGOUT_LINK_AT_USER = "xpath=//a[text()='Log out']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String MY_ACCOUNT_LINK = "xpath=//div[@class='header']//a[text()='My account']";

	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String LOAD_BUTTON = "css=button#load";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input";

	// Pattern Object
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";

}
