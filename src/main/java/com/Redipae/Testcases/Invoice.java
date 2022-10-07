package com.Redipae.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Invoice extends Setup {

	String invoiceno = "5213 ";


	// invoice
	@Test(priority=1)
	public void invoice() throws InterruptedException {

		driver.findElement(By.xpath("//*[text()='Report']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/InvoiceReport/Invoice\"]")).click();
		driver.findElement(By.id("TranId")).sendKeys(invoiceno);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(1000);
		driver.navigate().back();
	}


	@Test(priority=2)
	public void negativetest() {
		
		driver.findElement(By.xpath("//*[text()='Report']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/InvoiceReport/Invoice\"]")).click();
		driver.findElement(By.id("btnSave")).click();
		WebElement Errormsg = driver.findElement(By.xpath("//*[@id=\"UpdateTown\"]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println("Negativetest====>"+msg);



	}
}
