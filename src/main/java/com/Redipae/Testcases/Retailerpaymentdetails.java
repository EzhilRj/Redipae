package com.Redipae.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Retailerpaymentdetails extends Setup {

	// RetailPaymentDetails
	@Test(priority=1)
	public void RetailPaymentDetails() throws InterruptedException {

		driver.findElement(By.xpath("//*[text()='Report']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Report/RetailPaymentDetails\"]")).click();
		
		//Claim Status
		WebElement clmsts = driver.findElement(By.id("ClaimList"));
		Select select1 = new Select(clmsts);
		select1.selectByIndex(0);
		
        //Fromdate
		WebElement prev = driver.findElement(By.id("DPfdate"));
		prev.click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
		WebElement prevmth = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[3]/a"));
		prevmth.click();
		//Client
		WebElement clt = driver.findElement(By.id("ClientList"));
		Select select2 = new Select(clt);
		select2.selectByIndex(0);
		//Region
		WebElement rng = driver.findElement(By.id("RegionList"));
		Select select3 = new Select(rng);
		select3.selectByIndex(5);
		//State
		WebElement st = driver.findElement(By.id("StateList"));
		Select select4 = new Select(st);
		select4.selectByIndex(7);
		//Town
		WebElement twn = driver.findElement(By.id("TownList"));
		Select select5 = new Select(twn);
		select5.selectByVisibleText("Chennai");
		//Tier
		WebElement tier = driver.findElement(By.id("RPTTier"));
		Select select6 = new Select(tier);
		select6.selectByIndex(1);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void negativetest() throws Exception {
		
		driver.findElement(By.xpath("//*[text()='Report']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Report/RetailPaymentDetails\"]")).click();
		
		//Claim Status
		WebElement clmsts = driver.findElement(By.id("ClaimList"));
		Select select1 = new Select(clmsts);
		select1.selectByIndex(0);
		
		//Client
		WebElement clt = driver.findElement(By.id("ClientList"));
		Select select2 = new Select(clt);
		select2.selectByIndex(0);
		//Region
		WebElement rng = driver.findElement(By.id("RegionList"));
		Select select3 = new Select(rng);
		select3.selectByIndex(5);
		//State
		WebElement st = driver.findElement(By.id("StateList"));
		Select select4 = new Select(st);
		select4.selectByIndex(7);
		//Town
		WebElement twn = driver.findElement(By.id("TownList"));
		Select select5 = new Select(twn);
		select5.selectByVisibleText("Chennai");
		//Tier
		WebElement tier = driver.findElement(By.id("RPTTier"));
		Select select6 = new Select(tier);
		select6.selectByIndex(1);
		driver.findElement(By.id("btnSave")).click();
		
		WebElement Errormsg = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div/div/form/span"));
		String msg = Errormsg.getText();
		System.out.println("Negative test===>"+msg );

		
		
		
		
		
	}

}
