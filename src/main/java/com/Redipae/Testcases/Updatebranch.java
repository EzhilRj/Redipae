package com.Redipae.Testcases;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Updatebranch extends Setup {

	//Update Branch
	@Test(priority=1)
	public void updatebranch() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Branch/UpdateBranch\"]/parent::*"))
		.click();

		driver.findElement(By.className("control-label")).click();
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(800);
		String file4 = "D:\\Redipae Testing\\BranchMasterTEST.xlsx";
		StringSelection filepath4 = new StringSelection(file4);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath4, null);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpdate")).click();
	
		WebElement ob1 = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String sts1 = ob1.getText();
		System.out.println(file4+ "====>"+sts1 );

		driver.findElement(By.id("btnUpdateExport")).click();
	}



	//Negative test for Updatebranch
	@Test(priority=2)
	public void UpdatebranchFailuretest() throws Exception {

		driver.findElement(By.className("control-label")).click();
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_TAB);
		robot3.keyPress(KeyEvent.VK_ENTER);
		robot3.keyRelease(KeyEvent.VK_ENTER);
		robot3.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(800);
		String errorfile5 = "D:\\Redipae Testing\\BranchMaster - Test1.xlsm";
		StringSelection filepath5 = new StringSelection(errorfile5);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath5, null);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_CONTROL);
		robot4.keyPress(KeyEvent.VK_V);
		robot4.keyRelease(KeyEvent.VK_V);
		robot4.keyRelease(KeyEvent.VK_CONTROL);
		robot4.keyPress(KeyEvent.VK_ENTER);
		robot4.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("btUpdate")).click();
		
		WebElement Errormsg = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println(msg );
		
	}


}
