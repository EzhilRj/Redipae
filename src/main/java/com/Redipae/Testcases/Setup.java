package com.Redipae.Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Redipae.PageObjects.Baseclass_Page;
import com.Redipae.Utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Setup {

	ReadConfig readconfig = new ReadConfig();
	public String browser = readconfig.GetBrowser();
	public String Baseurl = readconfig.getapplicationURL();
	public String username = readconfig.GetUsername();
	public String password = readconfig.GetPassword();
	public String downloadedfilespath = readconfig.Downloadingpath();
	public String UploadingFilespath  = readconfig.Uploadingpath();

	public static Logger logger;
	protected static WebDriver driver;
	long StartTime;
	long endTime;

	@BeforeSuite
	public void Login() throws InterruptedException {

		Logger logger = Logger.getLogger("Redipae");
		DOMConfigurator.configure("Log4J.xml");

		HashMap preferences = new HashMap();
		preferences.put("download.default_directory", downloadedfilespath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs",preferences);

		if (browser.equalsIgnoreCase("Chrome")) {

			logger.info("Chrome is Opened");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {

			logger.info("Firefox is Opened");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase("Edge")) {

			logger.info("Microsoft Edge is Opened");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Baseurl);
		driver.manage().window().maximize();

	}

	@AfterSuite(enabled = false)
	public void closebrowser() throws InterruptedException {

		driver.quit();
		endTime = System.currentTimeMillis();
		long Totaltime = endTime - StartTime;
		System.out.println("TIMETAKEN:" + Totaltime);

	}

	public void captureScreen(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
			File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + result.getName() + ".png");

			FileUtils.copyFile(source, target);
			System.out.println("Screenshot captured");
		}

	}

	public String getrandomemail() {

		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public String GetRandomString() {

		String Randstr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * Randstr.length());
			salt.append(Randstr.charAt(index));
		}
		String RandomStr = salt.toString();
		return RandomStr;

	}
	
	public String GetRandomNumber() {

		int randomnum1 = ThreadLocalRandom.current().nextInt();
        String randomnum = String.valueOf(randomnum1);
        
		return randomnum;
        
	}
	
	public String GetRandomSpecialCharacters() {

		String Randspecchar= "!@#$%^&*()_+{}";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * Randspecchar.length());
			salt.append(Randspecchar.charAt(index));
		}
		String Randomspecailcharac = salt.toString();
		return Randomspecailcharac;

	}

}
