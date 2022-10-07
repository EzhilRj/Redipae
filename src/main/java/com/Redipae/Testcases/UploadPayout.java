package com.Redipae.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UploadPayout extends Setup {
	
	
	String File = "D:\\Redipae Testing\\Payout Upload2022.xlsx";
	String Errorfile = "D:\\Redipae Testing\\PayoutPaymentExportWithDataTEST - 1.xlsm";
	String pdfFile = "D:\\Redipae Testing\\Testing.pdf";


	//UploadPayout
	@Test(priority=1)
	public void uploadpayout() throws InterruptedException, AWTException {


		driver.findElement(By.xpath("//*[text()='Payout']")).click();
		WebElement upload=driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Payout/UploadPayout\"]"));
		upload.click();

		WebElement region3 = driver.findElement(By.id("RegionList"));
		Select select14 = new Select(region3);
		select14.selectByIndex(5);
		
		WebElement State = driver.findElement(By.id("StateList"));
		Select select = new Select(State);
		select.selectByIndex(7);
		
		WebElement Town = driver.findElement(By.id("TownList"));
		Select select1 = new Select(Town);
		select1.selectByVisibleText("Chennai");
		
		WebElement tier3 = driver.findElement(By.id("RPTTier"));
		Select select17 = new Select(tier3);
		select17.selectByIndex(1);

		WebElement client3 = driver.findElement(By.id("ClientList"));
		Select select18 = new Select(client3);
		select18.selectByIndex(0);
		
		driver.findElement(By.id("btnExportWithData")).click();

		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath = new StringSelection(File);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		
		WebElement ob1 = driver.findElement(By.xpath("//*[@id=\"UploadRetailer\"]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(File+ "====>"+sts1 );

	}
	
	@Test(priority=2)
	public void negativetest() throws AWTException, InterruptedException {
		
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_TAB);
		robot3.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath1 = new StringSelection(Errorfile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_CONTROL);
		robot4.keyPress(KeyEvent.VK_V);
		robot4.keyRelease(KeyEvent.VK_V);
		robot4.keyRelease(KeyEvent.VK_CONTROL);
		robot4.keyPress(KeyEvent.VK_ENTER);
		robot4.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		
		WebElement Errormsg = driver.findElement(By.xpath("//*[@id=\"UploadRetailer\"]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println(msg );
	
	}
	
	@Test(priority=3)
	public void negativetestPDF() throws Exception {
		
		driver.findElement(By.xpath("//*[text()='File input:']")).click();
		Robot robot5 = new Robot();
		robot5.keyPress(KeyEvent.VK_TAB);
		robot5.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		StringSelection filepath2 = new StringSelection(pdfFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath2, null);
		Robot robot6 = new Robot();
		robot6.keyPress(KeyEvent.VK_CONTROL);
		robot6.keyPress(KeyEvent.VK_V);
		robot6.keyRelease(KeyEvent.VK_V);
		robot6.keyRelease(KeyEvent.VK_CONTROL);
		robot6.keyPress(KeyEvent.VK_ENTER);
		robot6.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpload")).click();
		
		WebElement Errormsg = driver.findElement(By.xpath("//*[@id=\"UploadRetailer\"]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println("PDF UPLOAD====>"+msg );
	
	}
		
		
		
		
		
		
		
	}

