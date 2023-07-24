package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_15_Allure extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Hana";
		lastName = "Hasta";
		emailAddress = "hana_automation" + generateFakeNumber() + "@gmail.com";
		password = "123456";

	}

	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_01_Register(Method method) {

		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstnameTextbox(firstName);

		registerPage.inputToLastnameTextbox(lastName);

		registerPage.inputToEmailTextbox(emailAddress);

		registerPage.inputToPasswordTextbox(password);

		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Description("Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_02_Login(Method method) {
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		assertFalse(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.openMyAccountPage();

		assertFalse(customerInforPage.isCustomerInforPageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
