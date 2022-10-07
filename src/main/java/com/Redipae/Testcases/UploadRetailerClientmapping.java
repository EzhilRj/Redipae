package com.Redipae.Testcases;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadRetailerClientmapping extends Setup {

	String File= "D:\\Redipae Testing\\RetailerClientsMappingTEST.xlsx";
	String ErrorFile= "D:\\Redipae Testing\\RetailerClientsMappingTEST - 1.xlsm";

	//Positive Test for Upload Retailer Clients 
	@Test(priority=1)
	public void UploadRetailerClients() throws AWTException, InterruptedException {

		driver.findElement(By.xpath("//*[text()=\"Retailer Clients Mapping\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/RCMap/UploadRCMap\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("control-label")).click();
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB); 
		robot1.keyPress(KeyEvent.VK_ENTER);
		Robot robo2 = new Robot();
		robo2.delay(1000);
		StringSelection filepath1 = new StringSelection(File);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_CONTROL);
		robot3.keyPress(KeyEvent.VK_V);
		robot3.keyRelease(KeyEvent.VK_V);
		robot3.keyRelease(KeyEvent.VK_CONTROL);
		robot3.keyPress(KeyEvent.VK_ENTER);
		robot3.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		

		WebElement ob1 = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(File+ "====>"+sts1 );


		driver.findElement(By.id("btnUploadExport")).click();
		Thread.sleep(500);
		driver.findElement(By.id("btnExportWithData")).click();

	}

	@Test(priority=2)
	public void NegativeTest() throws InterruptedException, Exception {

		driver.findElement(By.xpath("//*[text()=\"Retailer Clients Mapping\"]")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/RCMap/UploadRCMap\"]")).click();
		driver.findElement(By.className("control-label")).click();
		Thread.sleep(1000);
		Robot robot5 = new Robot();
		robot5.keyPress(KeyEvent.VK_TAB); 
		robot5.keyPress(KeyEvent.VK_ENTER);
		Robot robot4 = new Robot();
		robot4.delay(1000);
		StringSelection filepath1 = new StringSelection(ErrorFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
		Robot robot6 = new Robot();
		robot6.keyPress(KeyEvent.VK_CONTROL);
		robot6.keyPress(KeyEvent.VK_V);
		robot6.keyRelease(KeyEvent.VK_V);
		robot6.keyRelease(KeyEvent.VK_CONTROL);
		robot6.keyPress(KeyEvent.VK_ENTER);
		robot6.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		
		WebElement Errormsg = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println(msg );



	}
}
