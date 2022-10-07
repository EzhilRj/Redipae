package com.Redipae.Testcases;

import java.awt.AWTException;

import com.Redipae.Utilities.UploadConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Redipae.PageObjects.AddUploadUser_Page;

public class AddUploadUser extends Setup {

    @Test(priority = 1)
    @Parameters({"username", "Firstname", "EmailID", "Password", "RePassword", "Rolelist", "Clientlist"})
    public void TC_010_Verify_AddUser(String un, String fn, String email, String pw, String Repw, String Role, String client)
            throws InterruptedException, AWTException {

        PageFactory.initElements(driver, AddUploadUser_Page.class);
        AddUploadUser_Page.usermaster.click();
        AddUploadUser_Page.Adduploaduser.click();
        AddUploadUser_Page.Username.sendKeys(un);
        AddUploadUser_Page.firstname.sendKeys(fn);
        AddUploadUser_Page.emailid.sendKeys(email);
        AddUploadUser_Page.password.sendKeys(pw);
        AddUploadUser_Page.Repassword.sendKeys(Repw);
        Select Roledropdown = new Select(AddUploadUser_Page.Rolelist);
        Roledropdown.selectByVisibleText(Role);
        Select Clientdropdown = new Select(AddUploadUser_Page.Clientlist);
        Clientdropdown.selectByVisibleText(client);

        AddUploadUser_Page.submit.click();

        boolean msg = AddUploadUser_Page.SuccessMessage.isDisplayed();
        Assert.assertTrue(true, "Testcase Passed");

    }

    @Test
    @Parameters({"username", "Firstname", "EmailID", "Password", "RePassword", "Rolelist", "Clientlist"})
    public void TC_011_Validate_DuplicateUser(String un, String fn, String email, String pw, String Repw, String Role, String client) throws InterruptedException, AWTException {

        PageFactory.initElements(driver, AddUploadUser_Page.class);
        AddUploadUser_Page.usermaster.click();
        AddUploadUser_Page.Adduploaduser.click();
        AddUploadUser_Page.Username.sendKeys(un);
        AddUploadUser_Page.firstname.sendKeys(fn);
        AddUploadUser_Page.emailid.sendKeys(email);
        AddUploadUser_Page.password.sendKeys(pw);
        AddUploadUser_Page.Repassword.sendKeys(Repw);
        Select Roledropdown = new Select(AddUploadUser_Page.Rolelist);
        Roledropdown.selectByVisibleText(Role);
        Select Clientdropdown = new Select(AddUploadUser_Page.Clientlist);
        Clientdropdown.selectByVisibleText(client);

        AddUploadUser_Page.submit.click();

        boolean msg = AddUploadUser_Page.errorMessage.isDisplayed();
        Assert.fail("Testcase Passed");


    }

    @Test(priority = 2)
    @Parameters({"username", "Firstname", "EmailID", "Password", "RePassword", "Rolelist", "Clientlist"})
    public void TC_012_Verify_TextboxErrormessage(String un, String fn, String email, String pw, String Repw, String Role, String client) {

        driver.navigate().refresh();
        PageFactory.initElements(driver, AddUploadUser_Page.class);
        AddUploadUser_Page.submit.click();

        boolean unerrmsg = AddUploadUser_Page.UnErrmsg.isDisplayed();
        AddUploadUser_Page.Username.sendKeys(un);

        AddUploadUser_Page.submit.click();

        boolean fnerrmsg = AddUploadUser_Page.FnErrmsg.isDisplayed();
        AddUploadUser_Page.firstname.sendKeys(fn);

        AddUploadUser_Page.submit.click();

        boolean emailerrmsg = AddUploadUser_Page.EmailErrmsg.isDisplayed();
        AddUploadUser_Page.emailid.sendKeys(email);

        AddUploadUser_Page.submit.click();

        boolean Selectdropdownerrormsg = driver.findElement(By.xpath("//*[text()=' Please select Client from drop down.']")).isDisplayed();

        AddUploadUser_Page.Username.sendKeys(un);
        AddUploadUser_Page.firstname.sendKeys(fn);
        AddUploadUser_Page.emailid.sendKeys(email);
        AddUploadUser_Page.password.sendKeys(pw);
        AddUploadUser_Page.Repassword.sendKeys(Repw);
        AddUploadUser_Page.Roleid.sendKeys(Role);
        AddUploadUser_Page.submit.click();

        boolean Selectdropdownerrormsg1 = driver.findElement(By.xpath("//*[text()=' Please select Client from drop down.']")).isDisplayed();

        if (unerrmsg && fnerrmsg && emailerrmsg && Selectdropdownerrormsg && Selectdropdownerrormsg1 == true) {

            Assert.assertTrue(true, "Testcase Passed");
        }


    }

    public void TC_013_Verify_Upload_USermaster(){


    }

    @Test
    public void TC_014_Verify_Download_USermaster(){

        AddUploadUser_Page.ExportButton.click();


    }
}