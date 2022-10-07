package com.Redipae.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UpdateRetailerClientMapping extends Setup {


	@Test(priority=1)
	public void updateRetailerClientMapping() throws InterruptedException, AWTException {


		driver.findElement(By.xpath("//*[text()=\"Retailer Clients Mapping\"]")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/RCMap/UpdateRCMap\"]")).click();
		driver.findElement(By.className("control-label")).click();
		Robot robot22 = new Robot();
		robot22.keyPress(KeyEvent.VK_TAB);
		robot22.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		String file = "D:\\Redipae Testing\\RetailerClientsMappingTEST1.xlsx";
		StringSelection filepath9 = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath9, null);
		Robot robot23 = new Robot();
		robot23.keyPress(KeyEvent.VK_CONTROL);
		robot23.keyPress(KeyEvent.VK_V);
		robot23.keyRelease(KeyEvent.VK_V);
		robot23.keyRelease(KeyEvent.VK_CONTROL);
		robot23.keyPress(KeyEvent.VK_ENTER);
		robot23.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpdate")).click();
		
		WebElement ob1 = driver.findElement(By.xpath("//*[@id=\"UpdateRetailer\"]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(file+ "====>"+sts1 );

	}

	@Test(priority=2)
	public void NegativeTest() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[text()=\"Retailer Clients Mapping\"]")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/RCMap/UpdateRCMap\"]")).click();
		driver.findElement(By.className("control-label")).click();
		Robot robot22 = new Robot();
		robot22.keyPress(KeyEvent.VK_TAB);
		robot22.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		String Errorfile = "D:\\Redipae Testing\\RetailerClientsMappingTEST - 1.xlsm";
		StringSelection filepath9 = new StringSelection(Errorfile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath9, null);
		Robot robot23 = new Robot();
		robot23.keyPress(KeyEvent.VK_CONTROL);
		robot23.keyPress(KeyEvent.VK_V);
		robot23.keyRelease(KeyEvent.VK_V);
		robot23.keyRelease(KeyEvent.VK_CONTROL);
		robot23.keyPress(KeyEvent.VK_ENTER);
		robot23.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpdate")).click();
		
		
		WebElement ob = driver.findElement(By.xpath("//*[@id=\"UpdateRetailer\"]/div/div/form/span"));
		String sts = ob.getText();
		System.out.println(sts);
		
	
		driver.findElement(By.id("btnUpdateExport")).click();

	}



}


