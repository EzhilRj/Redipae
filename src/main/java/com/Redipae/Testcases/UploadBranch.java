package com.Redipae.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

	public class UploadBranch extends Setup {

	@Test(priority=1)
	public void uploadBranch() throws AWTException, InterruptedException {

		// Upload Branch
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Upload Branch']")).click();
		driver.findElement(By.className("control-label")).click();
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(800);
		String file1 = "D:\\Redipae Testing\\BranchDemoTEST.xlsx";
		StringSelection filepath3 = new StringSelection(file1);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath3, null);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		
		WebElement ob1 = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(file1+ "====>"+sts1 );

		driver.findElement(By.id("btnUploadExport")).click();
		driver.findElement(By.id("btnExportWithData")).click();

	}

	@Test(priority=2)
	public void FailureTest() throws InterruptedException, AWTException {


		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Upload Branch']")).click();

		driver.findElement(By.className("control-label")).click();
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_TAB);
		robot4.keyPress(KeyEvent.VK_ENTER);
		robot4.keyRelease(KeyEvent.VK_ENTER);
		robot4.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		String errorfile = "D:\\Redipae Testing\\BranchDemoTEST - 1.xlsm";
		StringSelection filepath3 = new StringSelection(errorfile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath3, null);
		Robot robot5 = new Robot();
		robot5.keyPress(KeyEvent.VK_CONTROL);
		robot5.keyPress(KeyEvent.VK_V);
		robot5.keyRelease(KeyEvent.VK_V);
		robot5.keyRelease(KeyEvent.VK_CONTROL);
		robot5.keyPress(KeyEvent.VK_ENTER);
		robot5.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		
		WebElement Errormsg = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println(msg );









	}




}
