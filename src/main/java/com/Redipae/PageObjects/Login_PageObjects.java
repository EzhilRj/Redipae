package com.Redipae.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PageObjects {

	@FindBy(id = "username")
	public static WebElement username;

	@FindBy(id = "password")
	public static WebElement Password;

	@FindBy(xpath = "//*[text()='Login']")
	public static WebElement LoginButton;

	@FindBy(xpath = "//*[text()='Dashboard']")
	public static WebElement Dashboard;

	@FindBy(className = "error")
	public static WebElement error;

	@FindBy(xpath = "//*[@class=\"username username-hide-on-mobile\"]")
	public static WebElement Userdropdown;

	@FindBy(xpath = "//*[text()='Logout']")
	public static WebElement logout;

	@FindBy(xpath = "//*[text()='Enter User name']")
	public static WebElement ErrorUsername;

	@FindBy(xpath = "//*[text()='Enter Password']")
	public static WebElement ErrorPassword;

}
