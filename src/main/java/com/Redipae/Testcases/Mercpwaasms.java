package com.Redipae.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Mercpwaasms extends Setup {


	String Invalidid = "123456789";

	// MercPWASMS
	@Test(priority=1)
	public void Mercpwasms() throws InterruptedException {

		driver.findElement(By.xpath("//*[text()='Payout']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Payout/mercpushsmslink\"]")).click();
		WebElement getstats = driver.findElement(By.xpath("//*[@id=\"checkableGrid\"]/tbody/tr[1]"));
		String details = getstats.getText();
		System.out.println(details);

		driver.findElement(By.xpath("//*[@id=\"Approved_1815\"]/svg")).click();
		driver.switchTo().alert().accept();
		//Search the Retailer id
		WebElement getid = driver.findElement(By.xpath("//*[@id=\"checkableGrid\"]/tbody/tr[1]/td[1]"));
		String id = getid.getText();
		WebElement send = driver.findElement(By.id("ClientRetailerID"));
		send.sendKeys(id);
		driver.findElement(By.id("btnSave")).click();

	}

	@Test(priority=2)
	public void Negativetest() throws Exception {

		WebElement send = driver.findElement(By.id("ClientRetailerID"));
		send.sendKeys(Invalidid);
		driver.findElement(By.id("btnSave")).click();

		WebElement getsts = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String msg = getsts.getText();
		System.out.println("Negativetest=="+msg);


	}


}
