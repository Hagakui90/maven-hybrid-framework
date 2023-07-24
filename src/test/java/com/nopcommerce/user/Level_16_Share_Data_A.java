package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_A extends BaseTest {

	private WebDriver driver;
	private String emailAddress, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = Common_01_Register_End_User.emailAddress;
		password = Common_01_Register_End_User.password;

		log.info("Pre-Condition - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Enter to EmailAddress textbox with value is " + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition - Step 03: Enter to password textbox with value is " + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - Step 04: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();

	}

	@Test
	public void Search_01_Empty_Data() {

		log.info("Login - Step 05: Verify 'My account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06: Navigate to 'My account' page");
		customerInforPage = homePage.openMyAccountPage();

		log.info("Login - Verify 'My account' page is displayed");
		verifyTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void Search_02_Relative_Product_Name() {

	}

	@Test
	public void Search_03_Absolute_Product_Name() {

	}

	@Test
	public void Search_04_Parent_Category() {

	}

	@Test
	public void Search_05_Incorrect_Manufatorer() {

	}

	@Test
	public void Search_06_Correct_Manufatorer() {

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
