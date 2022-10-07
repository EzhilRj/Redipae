package com.Redipae.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Uploadpaymentdetailsforretailer extends Setup {

	String File = "D:\\Redipae Testing\\PPMSClaimInvoiceBankDetailTEST.xlsx";
	String ErrorFile = "D:\\Redipae Testing\\PPMSClaimInvoiceBankDetailTEST - 1.xlsm";

	//Upload Payment Details for Retailer
	@Test(priority=1)
	public void uploadpaymentdetailsforretailer() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[text()='Offline Operation']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Claim/UploadPaymentClaimBankDetail\"]")).click();

		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot1= new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath = new StringSelection(File);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		driver.findElement(By.id("btUpload")).click();
		driver.findElement(By.id("btnUploadExport")).click();
		driver.findElement(By.id("btnExportwithdata")).click();

		WebElement ob1 = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(File+ "====>"+sts1 );
	}

	//Failure Test for Upload Payment Details for Retailer
	@Test(priority=2)
	public void NegativeTest() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[text()='Offline Operation']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Claim/UploadPaymentClaimBankDetail\"]")).click();

		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot1= new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath1 = new StringSelection(ErrorFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_CONTROL);
		robot3.keyPress(KeyEvent.VK_V);
		robot3.keyRelease(KeyEvent.VK_V);
		robot3.keyRelease(KeyEvent.VK_CONTROL);
		robot3.keyPress(KeyEvent.VK_ENTER);
		robot3.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		driver.findElement(By.id("btUpload")).click();
		WebElement Errormsg = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println("Negative Test===>"+msg);





	}
}