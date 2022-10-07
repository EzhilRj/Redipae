package com.Redipae.Testcases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadForm16 extends Setup {

	String PDFFILE = "D:\\Redipae Testing\\COR0093.pdf";
	String ErrorFile = "D:\\Redipae Testing\\UsersExportWithData (4).xls";
	String errorfile = "D:\\Redipae Testing\\Usermasterdemo.xlsm";


	//UploadForm16
	@Test(priority=1)
	public void uploadform16() throws InterruptedException, Exception {

		driver.findElement(By.xpath("//*[text()='Retailer Form 16']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Report/TdsUpload\"]")).click();
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath = new StringSelection(PDFFILE);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		driver.findElement(By.id("btUpload")).click();

		WebElement ob1 = driver.findElement(By.xpath("/html/body/span/h1"));
		String sts1 = ob1.getText();
		System.out.println(PDFFILE+ "====>"+sts1 );

		if(sts1.equals("Server Error in '/Redipae' Application.")) {

			driver.navigate().back();
		}else {

			WebElement ob2 = driver.findElement(By.xpath("//*[@id=\"UpdateRetailer\"]/div/div/form/span"));
			String sts2 = ob2.getText();
			System.out.println(PDFFILE+ "====>"+sts2 );	
		}

	}

	//UploadForm16
	@Test(priority=2)
	public void NegativeTest() throws InterruptedException, Exception {

		driver.findElement(By.xpath("//*[text()='Retailer Form 16']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Report/TdsUpload\"]")).click();
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath = new StringSelection(ErrorFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		driver.findElement(By.id("btUpload")).click();
		/*
		 * WebElement Errormsg = driver.findElement(By.xpath(
		 * "/html/body/div[5]/div[2]/div/div[3]/div/div/form/span")); String msg =
		 * Errormsg.getText(); System.out.println("Negative Test===>"+msg);
		 */


		//Uploading XLSM
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_TAB);
		robot3.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath4 = new StringSelection(errorfile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath4, null);
		Robot robot5 = new Robot();
		robot5.keyPress(KeyEvent.VK_CONTROL);
		robot5.keyPress(KeyEvent.VK_V);
		robot5.keyRelease(KeyEvent.VK_V);
		robot5.keyRelease(KeyEvent.VK_CONTROL);
		robot5.keyPress(KeyEvent.VK_ENTER);
		robot5.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		driver.findElement(By.id("btUpload")).click();

		/*
		 * WebElement Errormsg1 = driver.findElement(By.xpath(
		 * "/html/body/div[5]/div[2]/div/div[3]/div/div/form/span")); String msg1 =
		 * Errormsg1.getText(); System.out.println("Negative Test===>"+msg1);
		 */

	}
}