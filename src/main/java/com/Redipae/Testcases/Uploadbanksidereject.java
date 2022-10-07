package com.Redipae.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Uploadbanksidereject  extends Setup {

	String file = "D:\\Redipae Testing\\PayoutTEST.xlsx";
	String Errorfile = "D:\\Redipae Testing\\PayoutTEST - 1.xlsm";


	// Upload Bank Side Reject
	@Test(priority=1)
	public void uploadbanksidereject() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[text()='Report']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Payout/UploadBankRejectDetails\"]")).click();
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		StringSelection filepath = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.id("btUpload")).click();

		WebElement ob1 = driver.findElement(By.xpath("//*[@id=\"UploadRetailer\"]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(file+ "====>"+sts1 );

		driver.findElement(By.id("btnUploadExport")).click();	
	}


	@Test(priority=2)
	public void negativetest() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[text()='Report']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Payout/UploadBankRejectDetails\"]"))
		.click();
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		StringSelection filepath = new StringSelection(Errorfile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.id("btUpload")).click();

		WebElement Errormsg = driver.findElement(By.xpath("//*[@id=\"UploadRetailer\"]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println(msg );




	}

}
