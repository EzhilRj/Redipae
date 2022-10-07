package com.Redipae.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Baseclass_Page {

    @FindBy(id = "username")
    public static WebElement username;
    @FindBy(id="password")
    public static WebElement password;
    @FindBy(xpath = "//*[text()=\"Login\"]")
    public static WebElement clicklogin;
}
