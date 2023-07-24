package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {

	private WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActivated("10"));

	}

	public void Table_02_Enter_to_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
	}

	public void Table_03_Enter_to_Header() {
		homePage.getValueEachRowAtAllPage();

	}

	@Test
	public void Table_04_Actions_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(2);

		// Value de nhap du lieu - tham so 1
		// Row number: tai row nao
		// Ex: Nhap vao textbox tai dong so 3/5/7
		// Colum name: Company/ Contact Person

//		homePage.enterToTextboxAtRowNumberByColumnName("Company", "1", "Suzuki");
//		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person", "1", "Monique Zebedee");
//		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed", "1", "2");
//
//		homePage.selectSpinButtonByColumnNameAtRowNumber("Order Placed", "1", "4");
//
//		homePage.sleepInSecond(2);
//		homePage.enterToTextboxAtRowNumberByColumnName("Member Since", "1", "2010-09-22");

		// homePage.selectDatePicker("Member Since", "1", "2010-09-22");

//		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Japan");
//		homePage.sleepInSecond(2);
//
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
//
//		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "6");
//		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "8");

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.sleepInSecond(2);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
