package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
//import reportConfig.ExtentTestManager;

public class Level_15_ExtentV5 extends BaseTest {

//	private WebDriver driver;
//	private String firstName, lastName, emailAddress, password;
//	private UserHomePageObject homePage;
//	private UserRegisterPageObject registerPage;
//	private UserLoginPageObject loginPage;
//	private UserCustomerInforPageObject customerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//
//		firstName = "Hana";
//		lastName = "Hasta";
//		emailAddress = "hana_automation" + generateFakeNumber() + "@gmail.com";
//		password = "123456";

	}

	@Test
	public void Login_01_Register(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
//
//		registerPage = homePage.openRegisterPage();
//
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is " + firstName);
//		registerPage.inputToFirstnameTextbox(firstName);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is " + lastName);
//		registerPage.inputToLastnameTextbox(lastName);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is " + emailAddress);
//		registerPage.inputToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is " + password);
//		registerPage.inputToPasswordTextbox(password);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirmed password textbox with value is " + password);
//		registerPage.inputToConfirmPasswordTextbox(password);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to Register button ");
//		registerPage.clickToRegisterButton();
//
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed ");
//		assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Login_02_Login(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Login to system with email and password");
//		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
//		homePage = registerPage.clickToLogoutLink();
//		loginPage = homePage.openLoginPage();
//
//		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
//		loginPage.inputToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox with value is '" + password + "'");
//		loginPage.inputToPasswordTextbox(password);
//
//		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
//		homePage = loginPage.clickToLoginButton();
//
//		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
//		assertFalse(homePage.isMyAccountLinkDisplayed());
//
//		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Navigate to 'My Account' page");
//		customerInforPage = homePage.openMyAccountPage();
//
//		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 07: Verify 'Customer Infor' page is displayed");
//		assertFalse(customerInforPage.isCustomerInforPageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
