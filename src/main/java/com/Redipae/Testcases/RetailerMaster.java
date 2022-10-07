package com.Redipae.Testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RetailerMaster extends Setup {

	boolean isdisplayed = true;
	String Enabledmsg = "Rejected box is Enabled";
	String NotEnabledmsg = "Rejected box is Not Enabled";
	String Testnumber = "8248606917";  

	//Approve Retailer

	@Test(priority=1)
	public void ApproveRetailer() throws Exception {


		WebElement master = driver.findElement(By.xpath("//*[text()='Retailer Master']"));
		master.click();
	

		WebElement approverretailer = driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Retailer/RetailerApprove\"]"));
		approverretailer.click();

		//Region 
		WebElement region = driver.findElement(By.id("RegionList"));   
		Select select8 = new Select(region);
		select8.selectByIndex(5);	

		//State
		WebElement state = driver.findElement(By.id("StateList"));
		Select select9 = new Select(state);
		select9.selectByIndex(7);

		//Status
		WebElement status = driver.findElement(By.id("RetailerStatusList"));
		Select select1 = new Select(status);
		select1.selectByIndex(6);

		//Tier
		WebElement tier= driver.findElement(By.id("RPTTier"));
		Select select2 = new Select(tier);
		select2.selectByIndex(4);

		//client
		WebElement client = driver.findElement(By.id("ClientList"));
		Select select3 = new Select(client);
		select3.selectByIndex(0);

		driver.findElement(By.id("btnSave")).click();

		//Annexure
		WebElement annexure = driver.findElement(By.xpath("//*[@class=\"glyphicon glyphicon-file\"]"));
		annexure.click();
		WebElement an = driver.findElement(By.xpath("/html"));
		String readpage =	an.getText();
		System.out.println("Annexure Page =====> ["+ readpage+ "]");

		//Thread.sleep(500);
		driver.navigate().back();

	}


	@Test(dependsOnMethods = "ApproveRetailer")
	public void Auditorscreen() throws Exception {


		//Auditor screen
		WebElement approveretailer =driver.findElement(By.xpath("//*[@class=\"glyphicon glyphicon-edit\"]"));
		approveretailer.click();
		String Retailerid =driver.getCurrentUrl();
		System.out.println("RETAILER ID["+Retailerid+"]");
		//Thread.sleep(500);

		//Getting Retailer status
		WebElement sts = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/span"));
		String txt = sts.getText();
		System.out.println("RETAILER STATUS=====>["+ txt +"]");

		if(txt.equals("Data is successfully Submitted by the retailer.")||(txt.equals("Bank Change Request from Retailer."))) {

			//Thread.sleep(500);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

			//Shop front photo
			WebElement shopfront = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/div[3]/div[2]/img")); 

			if(shopfront.getAttribute("naturalWidth").equals("0")) {

				System.out.println("SHOPFRONTPHOTO: UNAVAILABLE");

			}else {

				shopfront.click();
				robot.delay(3000);
				Robot robot1= new Robot();
				robot1.keyPress(KeyEvent.VK_TAB); 
				robot1.keyPress(KeyEvent.VK_ENTER);
				robot1.keyRelease(KeyEvent.VK_ENTER);
				robot1.keyRelease(KeyEvent.VK_TAB);
				robot.delay(1000);
				Robot robot2= new Robot();
				robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot2.keyRelease(KeyEvent.VK_PAGE_DOWN);
				robot2.keyRelease(KeyEvent.VK_PAGE_DOWN);
				robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot.delay(1000);

			}
			//GST PROOF
			WebElement gst = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/div[14]/div[2]/img")); 

			if(gst.getAttribute("naturalWidth").equals("0")) {

				System.out.println("GST : UNAVAILABLE");

			}else  {

				//Close GST

				gst.click();
				robot.delay(3000);
				Robot robot3 = new Robot();
				robot3.keyPress(KeyEvent.VK_TAB);
				robot3.keyPress(KeyEvent.VK_ENTER);
				robot3.keyRelease(KeyEvent.VK_ENTER); 
				robot3.keyRelease(KeyEvent.VK_TAB);
				robot.delay(1000);

			}

			//GST Page Scroll
			Robot robot4 = new Robot();
			robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot4.keyRelease(KeyEvent.VK_PAGE_DOWN);
			robot4.keyRelease(KeyEvent.VK_PAGE_DOWN);
			robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.delay(1000);


			//PAN Proof
			WebElement pan = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/div[16]/div[2]/img"));

			if(pan.getAttribute("naturalWidth").equals("0")) {

				System.out.println("PANIMAGE: UNAVAILABLE");

			}else {

				pan.click();
				robot.delay(3000);
				Robot robot1= new Robot();
				robot1.keyPress(KeyEvent.VK_TAB); 
				robot1.keyPress(KeyEvent.VK_ENTER);
				robot1.keyRelease(KeyEvent.VK_ENTER);
				robot1.keyRelease(KeyEvent.VK_TAB);
				robot.delay(1000);
				Robot robot2= new Robot();
				robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot2.keyRelease(KeyEvent.VK_PAGE_DOWN);
				robot.delay(1000);
			}

			//Bank PRoof
			WebElement bankproof  = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/div[21]/div[2]/img"));

			if(bankproof.getAttribute("naturalWidth").equals("0")) {

				System.out.println("BANKPROOF: UNAVAILABLE");

			}else {

				bankproof.click();
				robot.delay(3000);
				Robot robot1= new Robot();
				robot1.keyPress(KeyEvent.VK_TAB); 
				robot1.keyPress(KeyEvent.VK_ENTER);
				robot1.keyRelease(KeyEvent.VK_ENTER);
				robot1.keyRelease(KeyEvent.VK_TAB);
				robot.delay(1000);
				Robot robot2= new Robot();
				robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot2.keyRelease(KeyEvent.VK_PAGE_DOWN);
				robot2.keyRelease(KeyEvent.VK_PAGE_DOWN);
				robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot.delay(1000);
			}

			Robot robot2= new Robot();
			robot2.keyPress(KeyEvent.VK_PAGE_UP);
			robot2.keyRelease(KeyEvent.VK_PAGE_UP);
			robot2.keyRelease(KeyEvent.VK_PAGE_UP);
			robot2.keyPress(KeyEvent.VK_PAGE_UP);
			robot2.keyPress(KeyEvent.VK_PAGE_UP);
			robot2.keyRelease(KeyEvent.VK_PAGE_UP);
			robot2.keyRelease(KeyEvent.VK_PAGE_UP);
			robot2.keyPress(KeyEvent.VK_PAGE_UP);
			robot2.keyPress(KeyEvent.VK_PAGE_UP);
			robot2.keyRelease(KeyEvent.VK_PAGE_UP);
			robot2.keyPress(KeyEvent.VK_PAGE_UP);
			robot2.keyRelease(KeyEvent.VK_PAGE_UP);
			robot.delay(1000);    

			WebElement actionstatus = driver.findElement(By.id("Approvalselect"));
			Select select = new Select(actionstatus);
			select.selectByIndex(0);

			WebElement submit = driver.findElement(By.xpath("//*[@value=\"Submit\"]"));
			submit.click();


		}else if(txt.equals("Mobile Change Request from Retailer.")||txt.equals("Owner's ship Change Request from Retailer.")) {


			WebElement actionstatus = driver.findElement(By.id("Approvalselect"));
			Select select = new Select(actionstatus);
			select.selectByIndex(1);

			WebElement submit = driver.findElement(By.xpath("//*[@value=\"Submit\"]"));
			submit.click();
		}
	}

	//Approve the Retailer

	@Test(dependsOnMethods = "Auditorscreen")
	public void ESCLATION() throws Exception {


		//Getting Modified status
		WebElement Currentstatus = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/span"));
		String crttxt = Currentstatus.getText();
		System.out.println("Updatedstatus=====>["+ crttxt +"]");

		if(crttxt.equals("Mismatch in RetailerName or Mobile,So this retailer need to 'Approve' or 'Reject' by Client.")) {

			WebElement actionstatus = driver.findElement(By.id("Approvalselect"));
			Select select = new Select(actionstatus);
			select.selectByIndex(1);

			WebElement submit = driver.findElement(By.xpath("//*[@value=\"Submit\"]"));
			submit.click();			
		}
	}


	//Positive Test  for Rejecting Retailer
	@Test(dependsOnMethods = "Auditorscreen")
	public void Rejecttheretailerretailer() throws InterruptedException {


		WebElement master = driver.findElement(By.xpath("//*[text()='Retailer Master']"));
		master.click();
		//Thread.sleep(500);

		WebElement approverretailer = driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Retailer/RetailerApprove\"]"));
		approverretailer.click();

		//Status
		WebElement status = driver.findElement(By.id("RetailerStatusList"));
		Select select1 = new Select(status);
		select1.selectByIndex(6);

		driver.findElement(By.id("btnSave")).click();

		WebElement approveretailer =driver.findElement(By.xpath("//*[@class=\"glyphicon glyphicon-edit\"]"));
		approveretailer.click();

		//Getting Retailer status
		WebElement sts = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/span"));
		String txt = sts.getText();
		System.out.println("REJECTED RETAILER CURRENT STATUS=====>["+ txt +"]");

		//Rejected
		WebElement Rejected = driver.findElement(By.id("Approvalselect"));
		Select select10 = new Select(Rejected);
		select10.selectByIndex(2);

		WebElement Retailernameremarks	 =driver.findElement(By.id("checkBoxretailername"));
		boolean rm = Retailernameremarks.isEnabled();
		if (rm==true) {
			System.out.println("Retailer name"+Enabledmsg);
		}

		WebElement Shopfrontphoto	 =driver.findElement(By.id("checkBoxshopfront"));
		boolean sfp = Shopfrontphoto.isEnabled();
		if (sfp==true) {

			System.out.println("Shopfrontphoto"+Enabledmsg);
		}

		WebElement Mobileno	 =driver.findElement(By.id("checkBoxMobilenoChk"));
		boolean mn = Mobileno.isEnabled();
		if (mn==true) {

			System.out.println("Mobileno"+Enabledmsg);
		}

		WebElement Email	 =driver.findElement(By.id("checkBoxEmailidChk"));
		boolean el = Email.isEnabled();
		if (el==true) {

			System.out.println("Email"+Enabledmsg);
		}

		WebElement GSTProof	 =driver.findElement(By.id("checkBoxGSTIMGChk"));
		boolean Gpf = GSTProof.isEnabled();
		if (Gpf==true) {

			System.out.println("GSTProof"+Enabledmsg);
		}


		WebElement Pannumber =driver.findElement(By.id("checkBoxPannoChk"));
		boolean pnm = Pannumber.isEnabled();
		if (pnm==true) {

			System.out.println("Pannumber"+Enabledmsg);
		}


		WebElement PanProof	=driver.findElement(By.id("checkBoxretailername"));
		boolean ppf = PanProof.isEnabled();
		if (ppf==true) {

			System.out.println("Pan proof"+Enabledmsg);
		}


		WebElement accholdername =driver.findElement(By.id("checkBoxContactPersonChk"));
		boolean acn = accholdername.isEnabled();
		if (acn==true) {

			System.out.println("Account Holder name"+Enabledmsg);
		}


		WebElement Accountno	 =driver.findElement(By.id("checkBoxretailername"));
		boolean an = Accountno.isEnabled();
		if (an==true) {

			System.out.println("Account Number"+Enabledmsg);
		}


		WebElement BankProof	 =driver.findElement(By.id("checkBoxBANKIMGChk"));
		boolean bf = BankProof.isEnabled();
		if (bf==true) {

			System.out.println("Bank Image"+Enabledmsg);


			driver.findElement(By.id("checkBoxshopfront")).click();
			driver.findElement(By.id("txtRetailernameRemark")).sendKeys("Image is Blur");
			driver.findElement(By.id("checkBoxMobilenoChk")).click();
			driver.findElement(By.id("txtMobileno")).sendKeys("Mobile num is Wrong");

			WebElement approvalsts = driver.findElement(By.id("Approvalselect"));
			Select select111 = new Select(approvalsts);
			select111.selectByIndex(2);

			WebElement submit = driver.findElement(By.xpath("//*[@value=\"Submit\"]"));
			submit.click();


			//Getting Modified status
			WebElement Currentstatus = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/span"));
			String crttxt = Currentstatus.getText();
			System.out.println("Updatedstatus=====>["+ crttxt +"]");

		}


	}


	//When Status dropdown is approve.Checking when the Remarks box is enabled 


	@Test(dependsOnMethods = "Auditorscreen")
	public void NegativetestforRejection() throws InterruptedException {



		WebElement master = driver.findElement(By.xpath("//*[text()='Retailer Master']"));
		master.click();
		//Thread.sleep(500);

		WebElement approverretailer = driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Retailer/RetailerApprove\"]"));
		approverretailer.click();

		//Status
		WebElement status = driver.findElement(By.id("RetailerStatusList"));
		Select select1 = new Select(status);
		select1.selectByIndex(6);

		driver.findElement(By.id("btnSave")).click();


		WebElement approveretailer =driver.findElement(By.xpath("//*[@class=\"glyphicon glyphicon-edit\"]"));
		approveretailer.click();
		String Retailerid =driver.getCurrentUrl();
		System.out.println("REJECTED RETAILER ID["+Retailerid+"]");

		//Getting Retailer status
		WebElement sts = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/span"));
		String txt = sts.getText();
		System.out.println("RETAILER CURRENT STATUS=====>["+ txt +"]");

		//Getting Modified status
		WebElement updatestatus = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[3]/div[1]/form/div[3]/div/span"));
		String crttxt = updatestatus.getText();
		System.out.println("Updatedstatus=====>["+ crttxt +"]");


		//Rejected
		WebElement Rejected = driver.findElement(By.id("Approvalselect"));
		Select select10 = new Select(Rejected);
		select10.selectByIndex(2);

		WebElement Retailernameremarks	 =driver.findElement(By.id("checkBoxretailername"));
		boolean rm = Retailernameremarks.isEnabled();
		if (rm==false) {
			System.out.println("Retailer name"+NotEnabledmsg);
		}

		WebElement Shopfrontphoto	 =driver.findElement(By.id("checkBoxshopfront"));
		boolean sfp = Shopfrontphoto.isEnabled();
		if (sfp==false) {

			System.out.println("Shopfrontphoto"+NotEnabledmsg);
		}

		WebElement Mobileno	 =driver.findElement(By.id("checkBoxMobilenoChk"));
		boolean mn = Mobileno.isEnabled();
		if (mn==false) {

			System.out.println("Mobileno"+NotEnabledmsg);
		}

		WebElement Email	 =driver.findElement(By.id("checkBoxEmailidChk"));
		boolean el = Email.isEnabled();
		if (el==false) {

			System.out.println("Email"+NotEnabledmsg);
		}

		WebElement GSTProof	 =driver.findElement(By.id("checkBoxGSTIMGChk"));
		boolean Gpf = GSTProof.isEnabled();
		if (Gpf==false) {

			System.out.println("GSTProof"+NotEnabledmsg);
		}

		WebElement Pannumber =driver.findElement(By.id("checkBoxPannoChk"));
		boolean pnm = Pannumber.isEnabled();
		if (pnm==false) {

			System.out.println("Pannumber"+NotEnabledmsg);
		}

		WebElement PanProof	=driver.findElement(By.id("checkBoxretailername"));
		boolean ppf = PanProof.isEnabled();
		if (ppf==false) {

			System.out.println("Pan proof"+NotEnabledmsg);
		}

		WebElement accholdername =driver.findElement(By.id("checkBoxContactPersonChk"));
		boolean acn = accholdername.isEnabled();
		if (acn==false) {

			System.out.println("Account Holder name"+NotEnabledmsg);
		}

		WebElement Accountno	 =driver.findElement(By.id("checkBoxretailername"));
		boolean an = Accountno.isEnabled();
		if (an==false) {

			System.out.println("Account Number"+NotEnabledmsg);
		}

		WebElement BankProof	 =driver.findElement(By.id("checkBoxBANKIMGChk"));
		boolean bf = BankProof.isEnabled();
		if (bf==false) {

			System.out.println("Bank Image"+NotEnabledmsg);
		}
	}
	
	@Test
	public void RegressionTest() {
		
		WebElement master = driver.findElement(By.xpath("//*[text()='Retailer Master']"));
		master.click();

		WebElement approverretailer = driver.findElement(By.xpath("//*[@href=\"http://testing.ppms.co.in/redipae/Retailer/RetailerApprove\"]"));
		approverretailer.click();
		
		driver.findElement(By.id("MobileNumber")).sendKeys(Testnumber);
		
		driver.findElement(By.id("btnSave")).click();
		
			
	}


}



