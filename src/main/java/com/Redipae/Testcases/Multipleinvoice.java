package com.Redipae.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Multipleinvoice extends Setup {

	// MULTIPLE INVOICE
	@Test(priority=1)
	public void multipleinvoice() throws InterruptedException {

		driver.findElement(By.xpath("//*[text()='Report']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/InvoiceReport/MultipleInvoice\"]"))
		.click();
		//Client
		WebElement clnt = driver.findElement(By.id("ClientList"));
		Select select = new Select(clnt);
		select.selectByIndex(0);
		//Tier 
		WebElement Tier = driver.findElement(By.id("RPTTier"));
		Select select1 = new Select(Tier);
		select1.selectByIndex(4);
		driver.findElement(By.id("btnSave")).click();

		WebElement Errormsg = driver.findElement(By.xpath("/html/body/span/h1"));
		String msg = Errormsg.getText();
		System.out.println(msg );

		if(msg.equals("Server Error in '/Redipae' Application.") ){

			System.out.println("Invoice Is Not Downloaded");
		}
		

		driver.navigate().back();
	}





}
