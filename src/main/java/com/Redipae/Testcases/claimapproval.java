package com.Redipae.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class claimapproval extends Setup {


	//Claim Approval
	@Test(priority=1)
	public void Claimapproval() throws InterruptedException {

		driver.findElement(By.xpath("//*[text()='Claim Approval']")).click();
		driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/ClaimProcess/ClaimForm\"]")).click();
		driver.findElement(By.xpath("//*[text()='PENDING']")).click();

		WebElement ob1 = driver.findElement(By.xpath("//*[@id=\"pendingtab\"]/div[2]/div/div/form/div[2]/label"));
		String sts1 = ob1.getText();
		System.out.println(sts1 );
		driver.findElement(By.id("btUpload")).click();
		driver.findElement(By.xpath("//*[text()='PAID']")).click();
		driver.findElement(By.xpath("//*[text()='REJECT']")).click();



	}

}
