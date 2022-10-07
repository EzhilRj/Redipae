package com.Redipae.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadBranchclientmapping extends Setup {
	
	String file = "D:\\Redipae Testing\\BranchClinetMappingTEST.xlsx";
	String Errorfile =  "D:\\Redipae Testing\\BranchClinetMappingTEST - 1.xlsm";

	@Test(priority=1)
	public void Uploadbranchclientmapping() throws AWTException, InterruptedException {


		driver.findElement(By.xpath("//*[text()='Branch Client Mapping']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/BranchClientMap/UploadBranchClientMap\"]")).click();
		driver.findElement(By.className("control-label")).click();
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		StringSelection filepath1= new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
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
		System.out.println(file+ "====>"+sts1 );

		driver.findElement(By.id("btnUploadExport")).click();
		driver.findElement(By.id("btnExportWithData")).click();																				
	}

	
	@Test(priority=2)
	public void Failuretest() throws Exception {
		
		driver.findElement(By.xpath("//*[text()='Branch Client Mapping']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/BranchClientMap/UploadBranchClientMap\"]")).click();
		driver.findElement(By.className("control-label")).click();
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		StringSelection filepath1= new StringSelection(Errorfile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		WebElement Errormsg = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println(msg );
		
		
		
		
	}

}
