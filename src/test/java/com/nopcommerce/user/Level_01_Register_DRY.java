package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register_DRY {
	WebDriver driver;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		}
		
		driver = new FirefoxDriver();
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
	  }
	
	 @Test
	  public void TC_01_Register_Empty_Data() {
		 driver.findElement(By.cssSelector("a.ico-register")).click();
		 driver.findElement(By.cssSelector("button#register-button")).click();
		 
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText() , "Email is required.");
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText() , "Password is required.");
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText() , "Password is required.");
		 
	  }
	 @Test
	  public void TC_02_Register_Invalid_Email() {
		 driver.findElement(By.cssSelector("a.ico-register")).click();
		 
		 driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Hana");
		 driver.findElement(By.cssSelector("input#LastName")).sendKeys("Hasta");
		 driver.findElement(By.cssSelector("input#Email")).sendKeys("21334@vn");
		 driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		 driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		 
		 driver.findElement(By.cssSelector("button#register-button")).click();
		 
		 Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error")).getText(), "Wrong email");
		 
	  }

	 @Test
	  public void TC_03_Register_Success() {
		 driver.findElement(By.cssSelector("a.ico-register")).click();
		 
		 driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Hana");
		 driver.findElement(By.cssSelector("input#LastName")).sendKeys("Hasta");
		 driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		 driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		 driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		 
		 driver.findElement(By.cssSelector("button#register-button")).click();
		 
		 Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

	  }
	 
	 @Test
	  public void TC_04_Register_Existing_Email() {
		 driver.findElement(By.cssSelector("a.ico-register")).click();

		 driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Hanna");
		 driver.findElement(By.cssSelector("input#LastName")).sendKeys("Manana");
		 driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		 driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		 driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		 
		 driver.findElement(By.cssSelector("button#register-button")).click();
		 
		 Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error")).getText(), "The specified email already exists");

		 
	  }
	 
	 @Test
	  public void TC_05_Register_Pasword_Less_Than_6_Chars() {
		 driver.findElement(By.cssSelector("a.ico-register")).click();

		 driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Hanna");
		 driver.findElement(By.cssSelector("input#LastName")).sendKeys("Manana");
		 driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		 driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
		 driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
		 driver.findElement(By.cssSelector("button#register-button")).click();
		 		 
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
	  }
	 
	 @Test
	  public void TC_06_Register_Invalid_Confirm_Password() {
		 driver.findElement(By.cssSelector("a.ico-register")).click();

		 driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Hanna");
		 driver.findElement(By.cssSelector("input#LastName")).sendKeys("Manana");
		 driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		 driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		 driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123568");
		 driver.findElement(By.cssSelector("button#register-button")).click();
		 
		 
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");

	  }
	 
	 public int generateFakeNumber() {
		 Random rand = new Random();
		 return rand.nextInt(9999);
	 }
	 
  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
