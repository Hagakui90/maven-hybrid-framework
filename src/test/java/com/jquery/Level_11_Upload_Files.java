package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {

	private WebDriver driver;
	HomePageObject homePage;
	String anne1FileName = "Anne_1.jpg";
	String anne2FileName = "Anne_2.jpg";
	String anne3FileName = "Anne_3.jpg";
	String[] multipleFiles = { anne1FileName, anne2FileName, anne3FileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, anne1FileName);

		Assert.assertTrue(homePage.isFileLoadedByName(anne1FileName));

		homePage.clickToStartButton();

		homePage.isFileUploadedByName(anne1FileName);

		Assert.assertTrue(homePage.isFileUploadedByName(anne1FileName));
		Assert.assertTrue(homePage.isImageFileUploadedByName(anne1FileName));

	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFiles);

		for (int i = 0; i < multipleFiles.length; i++) {
			Assert.assertTrue(homePage.isFileLoadedByName(multipleFiles[i]));
		}

		homePage.clickToStartButton();

		for (int i = 0; i < multipleFiles.length; i++) {
			Assert.assertTrue(homePage.isFileUploadedByName(multipleFiles[i]));
			Assert.assertTrue(homePage.isImageFileUploadedByName(multipleFiles[i]));

		}

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
