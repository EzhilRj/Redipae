package com.Redipae.Testcases;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AuditInvoice extends Setup {

	//Audit Invoice
	@Test(priority=1)
	public void Auditinvoice() throws InterruptedException, AWTException { 

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement pt = driver.findElement(By.xpath("//*[text()='Payout']"));
		pt.click();
		WebElement audit = driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/InvoiceReport/AuditInvoice\"]"));
		audit.click();
		//Status
		WebElement audit1 = driver.findElement(By.id("Exporttype"));
		Select select = new Select(audit1);
		select.selectByIndex(1);
		driver.findElement(By.id("DPfdate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[3]/a")).click();
		Thread.sleep(800);
		
		driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(2) > div:nth-child(1) > div:nth-child(9) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(6) > button:nth-child(1)")).click();
		WebElement inv = driver.findElement(By.xpath("//*[@id=\"UpdateTown\"]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr[2]/td[2]/a"));
		inv.click();
		Thread.sleep(800);

		driver.findElement(By.id("btnApprove")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(800);

		//Reject invoice 
		driver.findElement(By.id("btnReject")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(800);

		//Advance Search

		WebElement adv = driver.findElement(By.xpath("//*[@id=\"UpdateTown\"]/div/div/div/a/h6"));
		adv.click();
		WebElement no = driver.findElement(By.className("btnEdit"));
		String sts1 = no.getText();
		sts1 = sts1.substring(12, sts1.indexOf('-'));
		sts1 = sts1.trim();
		driver.findElement(By.id("txtTranID")).sendKeys(sts1);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(800);
		driver.findElement(By.id("btnclear")).click();
		Thread.sleep(800);
		driver.navigate().refresh();
	}

	@Test(priority=2)
	public void Negativetest() throws Throwable {
		
		System.out.println("===NEGATIVE TEST STARTED===");

		WebElement pt = driver.findElement(By.xpath("//*[text()='Payout']"));
		pt.click();
		WebElement audit = driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/InvoiceReport/AuditInvoice\"]"));
		audit.click();

		WebElement adv = driver.findElement(By.xpath("//*[@id=\"UpdateTown\"]/div/div/div/a/h6"));
		adv.click();
		Thread.sleep(800);
		driver.findElement(By.xpath("//*[@onclick=\"GetPDFfile()\"]")).click();
		Thread.sleep(800);
		driver.switchTo().frame(0);
		WebElement Errormsg = driver.findElement(By.xpath("/html/body/span/h1"));
		String msg = Errormsg.getText();
		WebElement Errormsg1 = driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr/td"));
		String msg1 = Errormsg1.getText();
		System.out.println("When you try to Search without enter Retailer id===>"+msg+msg1);
		
		System.out.println("===NEGATIVE TEST FINISHED===");
		



	}

}
