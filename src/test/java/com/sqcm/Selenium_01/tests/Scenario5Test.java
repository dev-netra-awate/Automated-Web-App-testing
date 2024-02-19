package com.sqcm.Selenium_01.tests;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sqcm.Selenium_01.utils.DriverManager;
import com.sqcm.Selenium_01.utils.TakeScreenshot;

public class Scenario5Test {
	@Test(testName = "Update the Academic calendar")
	public void scenario5() {	
		//Initialize the driver and also wait
		DriverManager driverManager = new DriverManager();
		WebDriver driver = driverManager.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				
		//declare values of login credentials and screenshots path
		String email = System.getenv("email");
		String userId = System.getenv("userId");
		String password = System.getenv("password");
		String screenshotPath = "ScenarioFive/";

		//Navigate to the website
	    driver.get("https://northeastern.sharepoint.com/sites/studenthub/SitePages/Student-Resources.aspx#/resources");
		driver.manage().window().maximize();
	    TakeScreenshot.takeScreenShot(driver, screenshotPath + "1");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
		
		//enter email
        WebElement emailInput = driver.findElement(By.id("i0116"));
        emailInput.sendKeys(email);
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "2");
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        next.click();

        //enter password
        WebElement userPassword = driver.findElement(By.id("i0118"));
        userPassword.sendKeys(password);
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "3");
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        WebElement SignIn = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        SignIn.click();

        //click on yes this is my device
        WebElement duoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trust-browser-button")));
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "4");
        duoElement.click();

        //click on no
        WebElement noButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("idBtn_Back")));
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "5");
        noButton.click();
		        
		
        
        
        
        //click on academics
        Assert.assertEquals(driver.getTitle(), "Student Hub - Resources");
        WebElement academics = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vpc_WebPart.ResourcesWebPartWebPart.external.7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div[1]/div[2]/div/div[1]/div/div/img\n")));
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "6");
        academics.click();

        //click on academic calendar
        WebElement acad_cal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vpc_WebPart.ResourcesWebPartWebPart.external.7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div[2]/div/div/div[1]/div/div[1]/div/div/a")));
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "7");
        acad_cal.click();

        //switch tab
        wait.until(numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
        //click on academic calendar
        WebElement acad_cal2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tax-academic-calendars\"]/div/a[1]")));
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "8");
        acad_cal2.click();
        
        
        

        
        
        
        
      //Change Iframe:
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
        WebElement iframe = driver.findElement(By.id("trumba.spud.6.iframe"));
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "9");
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

        TakeScreenshot.takeScreenShot(driver, screenshotPath + "10");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("trumba.spud.6.iframe")));
        WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"mixItem0\"]"));
        if (checkBox.isSelected()) {
            checkBox.click();
        }
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "11");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

        driver.switchTo().defaultContent();
        WebElement iframe2 = driver.findElement(By.id("trumba.spud.2.iframe"));
        WebElement bottom = driver.findElement(By.xpath("//*[@id=\"nu-global-footer\"]/footer/div[1]/div[2]/a[3]"));

        TakeScreenshot.takeScreenShot(driver, screenshotPath + "12");
        new Actions(driver)
                .scrollToElement(bottom)
                .perform();
        driver.switchTo().frame(iframe2);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        WebElement table = driver.findElement(By.xpath("//*[@id=\"ctl04_ctl90_ctl00_actionsWrap\"]/table"));
        WebElement addToMy = table.findElement(By.id("ctl04_ctl90_ctl00_buttonAtmc"));
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "13");
        boolean checkpoint = addToMy.isDisplayed();
        Assert.assertTrue(checkpoint);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.quit();

		
	}
}
