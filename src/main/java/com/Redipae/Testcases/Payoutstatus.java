package com.Redipae.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Payoutstatus extends Setup {

	// Payout Status
	@Test(priority=1)
	public void payoutstatus() throws InterruptedException {

		driver.findElement(By.xpath("//*[text()='Report']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/PayStatusReport/PayStatus\"]"))
		.click();

		WebElement sts = driver.findElement(By.id("RPTType"));
		Select select20 = new Select(sts);
		select20.selectByIndex(4);

		WebElement tir = driver.findElement(By.id("RPTTier"));
		Select select21 = new Select(tir);
		select21.selectByIndex(4);

		WebElement cnt = driver.findElement(By.id("ClientList"));
		Select select22 = new Select(cnt);
		select22.selectByIndex(0);

		WebElement strdate = driver.findElement(By.id("DPfdate"));
		strdate.click();
		WebElement Prev = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span"));
		Prev.click();
		WebElement prevmnth = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[3]/a"));
		prevmnth.click();
		
		driver.findElement(By.id("btnSave")).click();
		

	}

}
