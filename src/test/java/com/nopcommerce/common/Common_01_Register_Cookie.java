package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookie extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName;
	private String emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static Set<Cookie> loggedCookies;

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Hana";
		lastName = "Hasta";
		emailAddress = "hana_automation" + generateFakeNumber() + "@gmail.com";
		password = "123456";

		log.info("Pre-Condition - Step 01: Navigate to 'Register' page");

		registerPage = homePage.openRegisterPage();

		log.info("Pre-Condition - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-Condition - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Pre-Condition - Step 04: Enter to EmailAddress textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition - Step 05: Enter to password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - Step 06: Enter to confirm password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-Condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition - Step 08: Verify register success messsage is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-Condition - Step 09: CLick to Logout link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Pre-Condition - Step 10: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 11: Enter to EmailAddress textbox with value is " + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition - Step 12: Enter to password textbox with value is " + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - Step 13: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();

		loggedCookies = homePage.getAllCookies(driver);
		System.out.println("Cookie at Common class ");
		for (Cookie cookie : loggedCookies) {
			System.out.println(cookie);
		}
		// homePage = homePage.clickToLogoutLinkAtUserPage(driver);

	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

}
