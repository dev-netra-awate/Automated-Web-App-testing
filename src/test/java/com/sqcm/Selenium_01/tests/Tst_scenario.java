package com.sqcm.Selenium_01.tests;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sqcm.Selenium_01.utils.DriverManager;
import com.sqcm.Selenium_01.utils.TakeScreenshot;

public class Tst_scenario {
	@Test
	public void scenario1() {

		DriverManager driverManager = new DriverManager();
		WebDriver driver = driverManager.getDriver();
		
		driver.manage().window().maximize();
        //driver.get("https://www.schedulesource.net/Enterprise/TeamWork5/Emp/Sch/#SwapBoard");
		driver.get("https://www.google.com");
		TakeScreenshot.takeScreenShot(driver, "scenario1_afterGoogle");
		Assert.assertEquals(driver.getTitle(), "Google");
		//driver.quit();
		driverManager.quitDriver();
		
	}
}
