package com.Redipae.Testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RetailerHistory extends Setup {

	String ClientRetailerid = "COR0093";

	//Retailer History
	@Test
	public void retailerhistory() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[text()='Report']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/RetailerHistory/RetailerHistoryView\"]")).click();
		//Region
		WebElement rng = driver.findElement(By.id("RegionList"));
		Select select1 = new Select(rng);
		select1.selectByIndex(5);
		//State
		WebElement st = driver.findElement(By.id("StateList"));
		Select select2 = new Select(st);
		select2.selectByIndex(7);
		//Town
		WebElement town = driver.findElement(By.id("TownList"));
		Select select3 = new Select(town);
		select3.selectByVisibleText("Chennai");
		//Tier
		WebElement tier = driver.findElement(By.id("RPTTier"));
		Select select4 = new Select(tier);
		select4.selectByIndex(4);
		//Client
		WebElement clnt = driver.findElement(By.id("ClientList"));
		Select select5 = new Select(clnt);
		select5.selectByIndex(0);

		driver.findElement(By.id("ClientRetailerID")).sendKeys(ClientRetailerid);
		Thread.sleep(500);
		driver.findElement(By.id("btnSave")).click();

		WebElement Errormsg = driver.findElement(By.xpath("//*[@id=\"UpdateTown\"]/div/div/form/div[3]/table/tbody/tr[1]/td[25]"));
		String msg = Errormsg.getText();
		System.out.println(msg );

		if(msg.equals(ClientRetailerid)) {

			System.out.println("Showing Retailer id is Same");
			driver.navigate().refresh();	
		}


	}

}
