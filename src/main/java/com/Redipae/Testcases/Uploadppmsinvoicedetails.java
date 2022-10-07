package com.Redipae.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Uploadppmsinvoicedetails extends Setup {


	String File = "D:\\Redipae Testing\\PPMSClaimInvoiceTEST.xlsx";
	String ErrorFile = "D:\\Redipae Testing\\PPMSClaimInvoiceTEST - 1.xlsm";


	//Upload PPMS invoice details
	@Test(priority=1)
	public void uploadppmsinvoicedetails() throws InterruptedException, AWTException  {

		driver.findElement(By.xpath("//*[text()='Offline Operation']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Claim/UploadPaymentClaim\"]")).click();
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath1 = new StringSelection(File);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//*[@value='Upload']")).click();
		driver.findElement(By.id("btnUploadExport")).click();
		driver.findElement(By.id("btnExportwithdata")).click();

		WebElement ob1 = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(File+ "====>"+sts1 );

	}
	//Failure Test For uploadppmsinvoicedetails
	@Test(priority=2)
	public void negativetest () throws InterruptedException, AWTException  {

		driver.findElement(By.xpath("//*[text()='Offline Operation']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Claim/UploadPaymentClaim\"]")).click();
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath1 = new StringSelection(ErrorFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//*[@value='Upload']")).click();
		driver.findElement(By.id("btnUploadExport")).click();
		driver.findElement(By.id("btnExportwithdata")).click();

		WebElement Errormsg = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println("Negative Test===>"+msg );




	}
}