package com.Redipae.Testcases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UploadRetailer extends Setup {

	//Upload Retailer
	@Test(priority=1)
	public void Uploadretailer() throws Exception {

		driver.findElement(By.xpath("//*[text()='Retailer Master']")).click();	
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Retailer/UploadRetailer\"]"))
		.click();
		Thread.sleep(500);	

		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
        String file = "D:\\Redipae Testing\\TEST2022.xlsx";
		StringSelection filepath = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);

		driver.findElement(By.id("btUpload")).click();
		
		Thread.sleep(500);

		WebElement ob1 = driver.findElement(By.xpath("//*[@id=\"UploadRetailer\"]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(file+ "====>"+sts1 );
		
		WebElement region1 = driver.findElement(By.id("RegionList"));
		Select select6 = new Select(region1);
		select6.selectByIndex(1);
		Thread.sleep(500);

		WebElement state1 = driver.findElement(By.id("StateList"));
		Select select7 = new Select(state1);
		select7.selectByIndex(3);
		driver.findElement(By.id("btnUploadExport")).click();
		Thread.sleep(500);
	

	}
	
	/* Negative Test for Upload Retailer */
	@Test(priority=2)
	public void Failuretest() throws Exception {
		
		driver.findElement(By.xpath("//*[text()='Retailer Master']")).click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Retailer/UploadRetailer\"]"))
		.click();
		Thread.sleep(500);	
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Thread.sleep(500);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
        String Errorfile = "D:\\Redipae Testing\\TEST2022 - 1.xlsm";
		StringSelection filepath = new StringSelection(Errorfile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);

		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);

		driver.findElement(By.id("btUpload")).click();

		WebElement Errormsg = driver.findElement(By.xpath("//*[@id=\"UploadRetailer\"]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println("When You Give Wrong File Format===> "+msg );

		
		
	}


	

}
