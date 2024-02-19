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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sqcm.Selenium_01.utils.DriverManager;
import com.sqcm.Selenium_01.utils.TakeScreenshot;

public class Scenario3Test {
	@Test(testName = "Download a classroom guide")
	public void scenario3() throws AWTException {	
		//Initialize the driver and also wait
		DriverManager driverManager = new DriverManager();
		WebDriver driver = driverManager.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				
		//declare values of login credentials and screenshots path
		String email = System.getenv("email");
		String userId = System.getenv("userId");
		String password = System.getenv("password");
		String screenshotPath = "ScenarioThree/";

		//Navigate to the website
		driver.get("https://service.northeastern.edu/tech?id=classrooms");
		driver.manage().window().maximize();
		try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		TakeScreenshot.takeScreenShot(driver, screenshotPath + "1");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));

		//click on login
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sp-nav-bar\"]/ul[2]/li/a")));
        login.click();
		
        //enter username and password
        WebElement userIdInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        userIdInput.sendKeys(userId);
        WebElement passWord2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("j_password")));
        passWord2.sendKeys(password);
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "2");
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div[2]/div/form/div[3]/button\n")));
        submit.click();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        

        //Duo authentication
        driver.switchTo().frame("duo_iframe"); // duo iframe
        WebElement pushButton;

        try {
            // get element:
            pushButton = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'auth-button') and contains(@class, 'positive')][@type='submit']"))));
            TakeScreenshot.takeScreenShot(driver, screenshotPath + "3");
            pushButton.click();
        } catch (StaleElementReferenceException e) {
            // if any exception, re-get the element
            pushButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(@class, 'auth-button') and contains(@class, 'positive')][@type='submit']")));
            TakeScreenshot.takeScreenShot(driver, screenshotPath + "3");
            pushButton.click();
        }

        driver.switchTo().defaultContent();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        

		
        
        
        
        //click on a class
		WebElement behrakis = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/tech?id=classroom_details&classroom=9ac92fb397291d905a68bd8c1253afd0']")));
		new Actions(driver)
        .scrollToElement(behrakis)
        .perform();
		TakeScreenshot.takeScreenShot(driver, screenshotPath + "4");
		behrakis.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TakeScreenshot.takeScreenShot(driver, screenshotPath + "5");
		
		//click on nuFlex
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement neuFlex = driver.findElement(By.xpath("//a[@href='https://nuflex.northeastern.edu/wp-content/uploads/2020/11/Hybrid_Nuflex_Classroom.pdf']"));
		neuFlex.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TakeScreenshot.takeScreenShot(driver, screenshotPath + "6");
		
		
		
		
		
		
		//switch tab
        wait.until(numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
		
        //download using robot
        Robot robot = new Robot();
   	    robot.delay(600);
        // Click on the download link
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Press the left mouse button
        robot.delay(600);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(600);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        robot.delay(600);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        driver.quit(); // Close the WebDriver session
		
		
	}
}
