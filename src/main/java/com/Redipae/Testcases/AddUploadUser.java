package com.Redipae.Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Redipae.Utilities.DBConfig;
import com.Redipae.Utilities.UploadConfig;

import com.Redipae.Utilities.WriteXLUtils;
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
            throws InterruptedException, AWTException, SQLException, ClassNotFoundException {

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

        //DATABASE
        boolean dbResult = DBConfig.ConnectDB("select * from UserMaster where Username = '" + un + "'", "Username", un);
        boolean UIresult = AddUploadUser_Page.SuccessMessage.isDisplayed();


        if (dbResult == true && UIresult == true) {

            System.out.println("Testcase passed");
            Assert.assertEquals(true, true, "Testcase Passed");

        } else {

            System.out.println("TC_010_Verify_AddUser Testcase Failed");
            Assert.assertEquals(false, true, "Testcase Failed");


        }


    }

    @Test
    @Parameters({"username", "Firstname", "EmailID", "Password", "RePassword", "Rolelist", "Clientlist"})
    public void TC_011_Validate_DuplicateUser(String un, String fn, String email, String pw, String Repw, String Role, String client) throws InterruptedException, AWTException, SQLException, ClassNotFoundException {

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

        boolean dbResult = DBConfig.ConnectDB("Select count(*) as [rowcount] from Usermaster where Username = '" + un + "'", "Username", un);
        boolean msg = AddUploadUser_Page.errorMessage.isDisplayed();

        if (dbResult == false && msg == true) {

            System.out.println("Testcase passed");
            Assert.assertEquals(true, true, "Testcase Passed");

        } else {

            System.out.println("TC_011_Validate_DuplicateUser Testcase Failed");
            Assert.assertEquals(false, true, "Testcase Failed");


        }


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

            Assert.assertEquals(true, true, "Testcase Passed");

        } else {

            System.out.println("TC_012_Verify_TextboxErrormessage Testcase Failed");
            Assert.assertEquals(false, true, "Testcase Failed");


        }

    }

    @Test
    public void TC_013_Verify_Upload_USermaster() throws IOException {


    }

    @Test
    public void TC_014_Verify_Export_USermaster() throws IOException {


        WriteXLUtils.UsermasterTestdatas();


        AddUploadUser_Page.ExportButton.click();


    }

    @Test
    public void TC_015_Verify_Exportwithdata() {


    }
}