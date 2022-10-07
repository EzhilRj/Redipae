package com.Redipae.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Uploadclient extends Setup {


	@Test(priority=1)
	public void uploadclient() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[text()='Client Master']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Client/UploadClient\"]/parent::li"))
		.click();
		Thread.sleep(500);

		driver.findElement(By.className("control-label")).click();
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_TAB);
		String file5 = "D:\\Redipae Testing\\ClientDemoTEST.xlsx";
		StringSelection filepath5 = new StringSelection(file5);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath5, null);
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		Thread.sleep(1000);
		
		WebElement ob1 = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(file5+ "====>"+sts1 );
		
		driver.navigate().back();

		driver.findElement(By.xpath("//*[@id=\"btnUploadExport\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("btnExportWithData")).click();
	}



	//Negative Test for Upload client
	@Test(priority=2)
	public void Negativetest() throws Exception {
		
		driver.findElement(By.xpath("//*[text()='Client Master']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Client/UploadClient\"]/parent::li"))
		.click();
		Thread.sleep(500);

		driver.findElement(By.className("control-label")).click();
		Thread.sleep(1000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_TAB);
		robot3.keyPress(KeyEvent.VK_ENTER);
		robot3.keyRelease(KeyEvent.VK_ENTER);
		robot3.keyRelease(KeyEvent.VK_TAB);
		String errorfile6= "D:\\Redipae Testing\\ClientDemoTEST - 1.xlsm";
		StringSelection filepath6 = new StringSelection(errorfile6);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath6, null);
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_CONTROL);
		robot4.keyPress(KeyEvent.VK_V);
		robot4.keyRelease(KeyEvent.VK_V);
		robot4.keyRelease(KeyEvent.VK_CONTROL);
		robot4.keyPress(KeyEvent.VK_ENTER);
		robot4.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		Thread.sleep(1000);
		
		WebElement Errormsg = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println(msg );
		


	}}