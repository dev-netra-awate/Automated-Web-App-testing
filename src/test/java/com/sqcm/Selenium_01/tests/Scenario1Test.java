package com.sqcm.Selenium_01.tests;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sqcm.Selenium_01.utils.DriverManager;
import com.sqcm.Selenium_01.utils.TakeScreenshot;

public class Scenario1Test {
	@Test(testName = "Verify download transcript")
	public void scenario1() throws AWTException {
		//Initialize the driver and also wait
		DriverManager driverManager = new DriverManager();
		WebDriver driver = driverManager.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//declare values of login credentials and screenshots path
		String email = System.getenv("email");
		String userId = System.getenv("userId");
		String password = System.getenv("password");
        String screenshotPath = "ScenarioOne/";

        //Navigate to the website
        driver.get("https://me.northeastern.edu/");
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

        
        
        
        
        
        
        //close popup
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/button[2]")));
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "6");
        continueBtn.click();

        Assert.assertEquals(driver.getTitle(), "Student Hub - Home");
        //click on resources
        WebElement resource = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div[1]/div[3]/div/div/div/div/span[4]/a/span")));
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "7");
        resource.click();

        //click on academics
        WebElement academics = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vpc_WebPart.ResourcesWebPartWebPart.external.7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div[1]/div[2]/div/div[1]/div/div/img\n")));
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "8");
        academics.click();

        //click on transcript
        WebElement transcript = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vpc_WebPart.ResourcesWebPartWebPart.external.7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div[2]/div/div/div[1]/div/div[21]/div/div/a\n")));
        try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "9");
        transcript.click();

        //switch tab
        wait.until(numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //enter username and password
        WebElement userIdInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        userIdInput.sendKeys(userId);
        WebElement passWord2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("j_password")));
        passWord2.sendKeys(password);
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "10");
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div[2]/div/form/div[3]/button\n")));
        submit.click();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "11");

        //Duo authentication
        driver.switchTo().frame("duo_iframe"); // duo iframe
        WebElement pushButton;

        try {
            // get element:
            pushButton = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'auth-button') and contains(@class, 'positive')][@type='submit']"))));
            pushButton.click();
        } catch (StaleElementReferenceException e) {
            // if any exception, re-get the element
            pushButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(@class, 'auth-button') and contains(@class, 'positive')][@type='submit']")));
            pushButton.click();
        }

        driver.switchTo().defaultContent();
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "12");

        //select level and find transcript
        Select drpLevel = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("levl_id"))));
        drpLevel.selectByVisibleText("Graduate");
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "13");
        WebElement findTranscript = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/form/input")));
        findTranscript.click();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "14");
      
        // download pdf   
        Robot robot = new Robot();
        // Click on the download link
 
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Press the left mouse button
 
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Release the left mouse button
        // Wait for the download dialog or action to start (you might need to adjust this delay)
 
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Simulate Ctrl + S (Save As)
 
        robot.keyPress(KeyEvent.VK_CONTROL); // Press the Ctrl key
 
        robot.keyPress(KeyEvent.VK_S); // Press the 'S' key
 
        robot.keyRelease(KeyEvent.VK_S); // Release the 'S' key
 
        robot.keyRelease(KeyEvent.VK_CONTROL); // Release the Ctrl key
        // Wait for the Save As dialog to appear (you might need to adjust this delay)
 
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Press Enter to confirm the Save As action
 
        robot.keyPress(KeyEvent.VK_ENTER); // Press the Enter key
 
        robot.keyRelease(KeyEvent.VK_ENTER); // Release the Enter key
        // Wait for the download to complete (you might need to adjust this delay)
 
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Wait for 10 seconds or adjust as needed
        
        // Take a screenshot
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "15");
        
        // Quit the WebDriver
        driver.quit(); // Close the WebDriver session
        
		
		
	}
}
