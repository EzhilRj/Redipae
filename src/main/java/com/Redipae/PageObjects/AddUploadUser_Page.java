package com.Redipae.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUploadUser_Page {

	@FindBy(xpath = "//*[text()='User Master']")
	public static WebElement usermaster;

	@FindBy(xpath = "//a[normalize-space()='Add / Upload User']")
	public static WebElement Adduploaduser;

	@FindBy(name = "txtUserName")
	public static WebElement Username;

	@FindBy(name = "txtFirstName")
	public static WebElement firstname;

	@FindBy(name = "txtEmailID")
	public static WebElement emailid;

	@FindBy(name = "txtPassword")
	public static WebElement password;

	@FindBy(name = "txtREPassword")
	public static WebElement Repassword;

	@FindBy(name = "RoleList")
	public static WebElement Rolelist;

	@FindBy(name = "ClientList")
	public static WebElement Clientlist;

	@FindBy(id = "btSubmit")
	public static WebElement submit;

	@FindBy(id = "uploadpostedFile")
	public static WebElement ChooseFileButton;

	@FindBy(id = "btUpload")
	public static WebElement UploadButton;

	@FindBy(id = "btnUploadExport")
	public static WebElement ExportButton;

	@FindBy(id = "btnExportWithData")
	public static WebElement ExportwithDataButton;

	@FindBy(id = "txtrole")
	public static WebElement Roleid;

	@FindBy(className = "succes")
	public static WebElement SuccessMessage;

	@FindBy(className = "error")
	public static WebElement errorMessage;
	
	//Error Message
	
	@FindBy(xpath = "//*[text()='Enter user name here']")
	public static WebElement UnErrmsg;
	
	@FindBy(xpath = "//*[text()='Enter your name here']")
	public static WebElement FnErrmsg;
	
	@FindBy(xpath = "//*[text()='Enter your email-id here']")
	public static WebElement EmailErrmsg;
	
	
	
	

		
}
