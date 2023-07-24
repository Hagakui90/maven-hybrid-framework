package pageObjects.saurceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saurceLab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefautlDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);

	}

	public boolean isProductNameSortByAscending() {
		// Khai bao ra 1 ArrayList de chua cac product name tren UI
		List<String> productUIList = new ArrayList<String>();

		// Lay ra het tat ca cac text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// Dung vong lap de getText va add vao ArrayList tren
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.println("Product Name o tren UI: " + productName.getText());
		}

		// Tao 1 ArrayList moi de sort du lieu trong ArrayList cu xem dung hay ko
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort productSortList
		Collections.sort(productSortList);
		for (String productName : productSortList) {
			System.out.println("Product Name sau khi sort: " + productName);
		}

		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		// Khai bao ra 1 ArrayList de chua cac product name tren UI
		List<String> productUIList = new ArrayList<String>();

		// Lay ra het tat ca cac text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// Dung vong lap de getText va add vao ArrayList tren
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.println("Product Name o tren UI: " + productName.getText());
		}

		// Tao 1 ArrayList moi de sort du lieu trong ArrayList cu xem dung hay ko
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort productSortList
		Collections.sort(productSortList);

		// Reverse productSortList
		Collections.reverse(productSortList);
		for (String productName : productSortList) {
			System.out.println("Product Name sau khi sort descending: " + productName);
		}

		return productSortList.equals(productUIList);

	}

	public boolean isProductPriceSortByDescending() {
		// Khai bao ra 1 ArrayList de chua cac product price tren UI
		List<Float> productUIList = new ArrayList<Float>();

		// Lay ra het tat ca cac text product price
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// Dung vong lap de getText va add vao ArrayList tren
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
			System.out.println("Product Price o tren UI: " + productPrice.getText());
		}

		// Tao 1 ArrayList moi de sort du lieu trong ArrayList cu xem dung hay ko
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		// Sort productSortList
		Collections.sort(productSortList);

		// Reverse productSortList
		Collections.reverse(productSortList);
		for (Float productPrice : productSortList) {
			System.out.println("Product Price sau khi sort descending: $" + productPrice);
		}

		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		// Khai bao ra 1 ArrayList de chua cac product price tren UI
		List<Float> productUIList = new ArrayList<Float>();

		// Lay ra het tat ca cac text product price
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// Dung vong lap de getText va add vao ArrayList tren
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
			System.out.println("Product Price o tren UI: " + productPrice.getText());
		}

		// Tao 1 ArrayList moi de sort du lieu trong ArrayList cu xem dung hay ko
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		// Sort productSortList
		Collections.sort(productSortList);
		for (Float productPrice : productSortList) {
			System.out.println("Product Price sau khi sort: $" + productPrice);
		}

		return productSortList.equals(productUIList);
	}
}
