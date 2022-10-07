package com.Redipae.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Uploadbranchretailermapping extends Setup {
	
	
	String file = "D:\\Redipae Testing\\PPMSRetailerMappingTEST.xlsx";
	String Errorfile = "D:\\Redipae Testing\\PPMSRetailerMappingTEST - 1.xlsm";
	
	//Upload Branch Retailer Mapping

		@Test(priority=1)
		public void UploadBranchRetailerMapping() throws AWTException, InterruptedException {

			driver.findElement(By.xpath("//*[text()='Branch Retailer Mapping']")).click();
			driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/PPMSRetailerMap/UploadPPMSRetailerMap\"]")).click();
			driver.findElement(By.className("control-label")).click();
			Robot robot24 = new Robot();
			robot24.keyPress(KeyEvent.VK_TAB);
			robot24.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(800);
			StringSelection filepath10 = new StringSelection(file);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath10, null);
			Robot robot25 = new Robot();
			robot25.keyPress(KeyEvent.VK_CONTROL);
			robot25.keyPress(KeyEvent.VK_V);
			robot25.keyRelease(KeyEvent.VK_V);
			robot25.keyRelease(KeyEvent.VK_CONTROL);
			robot25.keyPress(KeyEvent.VK_ENTER);
			robot25.keyRelease(KeyEvent.VK_ENTER);
			driver.findElement(By.id("btUpload")).click();
			
			WebElement ob1 = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
			String sts1 = ob1.getText();
			System.out.println(file+ "====>"+sts1 );
			
			driver.findElement(By.id("btnUploadExport")).click();
			driver.findElement(By.id("btnExportWithData")).click();

		}
		
		@Test(priority=2)
		public void Failuretest() throws AWTException, InterruptedException {

			driver.findElement(By.xpath("//*[text()='Branch Retailer Mapping']")).click();
			driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/PPMSRetailerMap/UploadPPMSRetailerMap\"]")).click();
			driver.findElement(By.className("control-label")).click();
			Robot robot24 = new Robot();
			robot24.keyPress(KeyEvent.VK_TAB);
			robot24.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(800);
			StringSelection filepath10 = new StringSelection(Errorfile);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath10, null);
			Robot robot25 = new Robot();
			robot25.keyPress(KeyEvent.VK_CONTROL);
			robot25.keyPress(KeyEvent.VK_V);
			robot25.keyRelease(KeyEvent.VK_V);
			robot25.keyRelease(KeyEvent.VK_CONTROL);
			robot25.keyPress(KeyEvent.VK_ENTER);
			robot25.keyRelease(KeyEvent.VK_ENTER);
			driver.findElement(By.id("btUpload")).click();
			
			WebElement Errormsg = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
			String msg = Errormsg.getText();
			System.out.println(msg);
		}



}
