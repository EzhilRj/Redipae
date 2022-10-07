
package com.Redipae.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Pushfinalsms extends Setup {

	String Approvests = "Approved Retailer Details====>  ";
	String Rejectsts = "Rejected Retailer Details====>  ";

	// Push Final SMS

	@Test(priority = 1)
	public void pushfinalsms() throws InterruptedException {

		// Approve the selected Payout

		WebElement payout = driver.findElement(By.xpath("//*[text()='Payout']"));
		payout.click();
		WebElement mas = driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Payout/ApprovePayout\"]"));
		mas.click();
		WebElement stats = driver.findElement(By.xpath("//*[@id=\"checkableGrid\"]/tbody/tr[1]"));
		String dip = stats.getText();
		System.out.println(Approvests + dip);

		WebElement check = driver.findElement(By.xpath("//*[@id=\"checkableGrid\"]/tbody/tr[1]/td[1]/div/span/input"));
		check.click();

		driver.findElement(By.id("btnApprove")).click();
		driver.switchTo().alert().accept();

		WebElement getsts = driver.findElement(By.xpath("//*[@id=\"DeleteClient\"]/div/div/form/span"));
		String msg = getsts.getText();
		System.out.println(msg);

		// Reject the Payout 
		WebElement stats1 =driver.findElement(By.xpath("//*[@id=\"checkableGrid\"]/tbody/tr[1]"));
		String dip1 = stats1.getText();
		System.out.println(Rejectsts + dip1);

		WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkableGrid\"]/tbody/tr[1]/td[1]/div/span/input"));
		check1.click();

		driver.findElement(By.id("btnReject")).click();
		driver.switchTo().alert().accept();

		WebElement getsts1 = driver.findElement(By.xpath("//*[@id=\"DeleteClient\"]/div/div/form/span"));
		String Rejectmsg = getsts1.getText();
		System.out.println(Rejectmsg);

	}

	@Test(priority = 2)
	public void NegativeTest() {

		driver.findElement(By.id("btnApprove")).click();
		driver.switchTo().alert().accept();

		WebElement getsts = driver.findElement(By.xpath("//*[@id=\"DeleteClient\"]/div/div/form/span"));
		String msg = getsts.getText();
		System.out.println("NegativeTest==" + msg);

		driver.findElement(By.id("btnReject")).click();
		driver.switchTo().alert().accept();

		WebElement getsts1 = driver.findElement(By.xpath("//*[@id=\"DeleteClient\"]/div/div/form/span"));
		String Rejectmsg = getsts1.getText();
		System.out.println("NegativeTest==" + Rejectmsg);

	}

}
