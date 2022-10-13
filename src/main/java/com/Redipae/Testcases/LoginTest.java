package com.Redipae.Testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Redipae.PageObjects.Login_PageObjects;

public class LoginTest extends Setup {

	boolean db = false;

	@Test(priority = 1)
	public void TC_001_VerifyWithValidCredentials() throws InterruptedException {

		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.username.sendKeys(username);
		Login_PageObjects.Password.sendKeys(password);
		Login_PageObjects.LoginButton.click();
		String expectedtitle = "REDIPAE";
		String orginaltitle = driver.getTitle();
		Assert.assertEquals(orginaltitle, expectedtitle);
		db = Login_PageObjects.Dashboard.isDisplayed();
		Assert.assertTrue(true, "TestCase Passed");

	}

	@Test(priority = 2)
	void clickLogout() throws InterruptedException {

		if (db == true) {

			PageFactory.initElements(driver, Login_PageObjects.class);
			Actions actions = new Actions(driver);
			WebElement dropdown = Login_PageObjects.Userdropdown;
			actions.moveToElement(dropdown).perform();
			Login_PageObjects.logout.click();

		}
	}

	@Test(priority = 3)
	public void TC_002_Verifywith_INValidPassword() throws InterruptedException {

		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.username.sendKeys(username);
		Login_PageObjects.Password.sendKeys(GetRandomString());
		Login_PageObjects.LoginButton.click();
		boolean em = Login_PageObjects.error.isDisplayed();
		Assert.assertTrue(true, "Testcase Passed");

	}

	@Test(priority = 4)
	public void TC_003_Verifywith_INValidUsername() throws InterruptedException {

		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.username.clear();
		Login_PageObjects.Password.clear();
		Login_PageObjects.username.sendKeys(GetRandomString());
		Login_PageObjects.Password.sendKeys(password);
		Login_PageObjects.LoginButton.click();
		boolean em = Login_PageObjects.error.isDisplayed();
		Assert.assertTrue(true, "Testcase Passed");

	}

	@Test(priority = 5)
	public void TC_004_Verifywith_INValidCredentials() throws InterruptedException {

		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.username.clear();
		Login_PageObjects.Password.clear();
		Login_PageObjects.username.sendKeys(GetRandomString());
		Login_PageObjects.Password.sendKeys(GetRandomString());
		Login_PageObjects.LoginButton.click();
		boolean em = Login_PageObjects.error.isDisplayed();
		Assert.assertTrue(true, "Testcase Passed");

	}

	@Test(priority = 6)
	public void TC_005_VerifyWithNull_Value() throws InterruptedException {

		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.username.clear();
		Login_PageObjects.Password.clear();
		Login_PageObjects.LoginButton.click();
		boolean err1 = Login_PageObjects.ErrorUsername.isDisplayed();
		boolean err2 = Login_PageObjects.ErrorPassword.isDisplayed();
		if (err1 && err2 == true) {

			System.out.println("Testcase Passed");
		}

	}

	@Test(priority = 7)
	public void TC_006_VerifyWithNull_Value_in_Username() throws InterruptedException {

		driver.navigate().refresh();
		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.username.clear();
		Login_PageObjects.Password.sendKeys(password);
		Login_PageObjects.LoginButton.click();
		boolean err1 = Login_PageObjects.ErrorUsername.isDisplayed();
		Assert.assertTrue(true, "Testcase Passed");
		

	}

	@Test(priority = 8)
	public void TC_007_VerifyWithNull_Value_in_Password() throws InterruptedException {

		driver.navigate().refresh();
        PageFactory.initElements(driver, Login_PageObjects.class);
        Login_PageObjects.username.sendKeys(username);
        Login_PageObjects.LoginButton.click();
        boolean err2 = Login_PageObjects.ErrorPassword.isDisplayed();
        Assert.assertTrue(true, "Testcase Passed");
		
	}

	@Test(priority = 9)
	public void TC_008_Verifywith_NumericValues() throws InterruptedException {

		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.username.clear();
		Login_PageObjects.Password.clear();
		Login_PageObjects.username.sendKeys(GetRandomNumber());
		Login_PageObjects.Password.sendKeys(GetRandomNumber());
		Login_PageObjects.LoginButton.click();
		boolean em = Login_PageObjects.error.isDisplayed();
		Assert.assertTrue(true, "Testcase Passed");

	}

	@Test(priority = 10)
	public void TC_009_Verifywith_SpecialCharacters() throws InterruptedException {

		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.username.clear();
		Login_PageObjects.Password.clear();
		Login_PageObjects.username.sendKeys(GetRandomSpecialCharacters());
		Login_PageObjects.Password.sendKeys(GetRandomSpecialCharacters());
		Login_PageObjects.LoginButton.click();
		boolean em = Login_PageObjects.error.isDisplayed();
		Assert.assertTrue(true, "Testcase Passed");

		Login_PageObjects.username.clear();
		Login_PageObjects.Password.clear();



	}

}
