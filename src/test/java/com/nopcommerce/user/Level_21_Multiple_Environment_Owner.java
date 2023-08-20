package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import utilities.Environments;

public class Level_21_Multiple_Environment_Owner extends BaseTest {
	Environments environment;

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	String url, emailAddress;
	UserDataMapper userData;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environments.class);
		System.out.println(environment.appUrl());
		log.info("Pre-Condition - Step 01: Open site");
		driver = getBrowserDriver(browserName, environment.appUrl());
		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakemail.com";

	}

	@Test
	public void Login_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");

		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioButtonByLabel(driver, "Male");

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + userData.getFirstName() + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + userData.getLastName() + "'");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Register - Step 04: Enter to EmailAddress textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 05: Enter to password textbox with value is '" + userData.getPassword() + "'");
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Register - Step 06: Enter to confirm password textbox with value is '" + userData.getPassword() + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register - Step 08: Verify register success messsage is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

		log.info("Register - Step 09: CLick to Logout link");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Login_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to EmailAddress textbox with value is " + emailAddress);
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03: Enter to password textbox with value is " + userData.getPassword() + "'");
		loginPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Login - Step 04: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void Login_03_My_Account() {
		log.info("Login - Step 01: Navigate to 'My account' page");
		customerInforPage = homePage.openMyAccountPage();

		log.info("Login - Step 02: Verify 'My account' page is displayed");
		verifyTrue(customerInforPage.isCustomerInforPageDisplayed());

		log.info("Login - Step 03: Verify 'First Name' value is correctly");
		verifyEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), userData.getFirstName());

		log.info("Login - Step 04: Verify 'Last Name' value is correctly");
		verifyEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), userData.getLastName());

		log.info("Login - Step 05: Verify 'Email' value is correctly");
		verifyEquals(customerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
