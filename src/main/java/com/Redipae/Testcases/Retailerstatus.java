package com.Redipae.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Retailerstatus extends Setup {

	// Retailer Status
	@Test
	public void retailerstatus() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Report']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/RetailerStatusReport/RetailerStatus\"]")).click();

		WebElement Stsrt = driver.findElement(By.id("RPTType"));
		Select select = new Select(Stsrt);
		select.selectByIndex(3);

		WebElement tierrt = driver.findElement(By.id("RPTTier"));
		Select select1 = new Select(tierrt);
		select1.selectByIndex(1);

		WebElement cltrt = driver.findElement(By.id("ClientList"));
		Select select2 = new Select(cltrt);
		select2.selectByIndex(0);

		driver.findElement(By.id("btnSave")).click();

		WebElement Errormsg = driver.findElement(By.xpath("/html/body/span/h1"));
		String msg = Errormsg.getText();
		System.out.println(msg );

		if(msg.equals("Server Error in '/Redipae' Application.") ){

			System.out.println("Retailer status Report is Not Downloaded");
		}

		driver.navigate().back();
	}



}


