package com.sqcm.Selenium_01.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sqcm.Selenium_01.utils.DriverManager;
import com.sqcm.Selenium_01.utils.TakeScreenshot;

public class Scenario4Test {
	@Test(testName = "Download a DATASET")
	public void scenario4() {
		//Initialize the driver and also wait
		DriverManager driverManager = new DriverManager();
		WebDriver driver = driverManager.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//declare values of login credentials and screenshots path
		String email = System.getenv("email");
		String userId = System.getenv("userId");
		String password = System.getenv("password");
		String screenshotPath = "ScenarioFour/";
		
		//Navigate to the website
		driver.get("https://onesearch.library.northeastern.edu/discovery/search?vid=01NEU_INST:NU&lang=en");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		//Click on signin
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("signInBtn")));
        login.click();
		
		//enter username and password
        WebElement userIdInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        userIdInput.sendKeys(userId);
        WebElement passWord2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("j_password")));
        passWord2.sendKeys(password);
        TakeScreenshot.takeScreenShot(driver, screenshotPath + "1");
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
            TakeScreenshot.takeScreenShot(driver, screenshotPath + "2");
            pushButton.click();
        } catch (StaleElementReferenceException e) {
            // if any exception, re-get the element
            pushButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(@class, 'auth-button') and contains(@class, 'positive')][@type='submit']")));
            TakeScreenshot.takeScreenShot(driver, screenshotPath + "2");
            pushButton.click();
        }

        driver.switchTo().defaultContent();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		// Click on "Digital Repository Service"
		/*
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/primo-explore/div/prm-explore-main/div/prm-topbar/div/prm-main-menu/div/div/div[5]/a/span")));
		WebElement datasetRepo = driver.findElement(By.xpath(
				"/html/body/primo-explore/div/prm-explore-main/div/prm-topbar/div/prm-main-menu/div/div/div[5]/a/span"));
		*/
        WebElement datasetRepo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/primo-explore/div/prm-explore-main/div/prm-topbar/div/prm-main-menu/div/div/div[5]/a/span")));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
		TakeScreenshot.takeScreenShot(driver, screenshotPath + "3");
		datasetRepo.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		//tab switch
		Set<String> windowHandles = driver.getWindowHandles();
		// Assuming the new tab is the second tab in the set (index 1)
		// Note: Index may vary based on the order in which tabs were opened
		List<String> handlesList = new ArrayList<>(windowHandles);
		String newTab = handlesList.get(1);
		driver.switchTo().window(newTab);
 
		// Click on Datasets under the Featured Content
		/*
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[1]/main/div[1]/section/div[1]/a[5]/span")));
		WebElement dataset = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/section/div[1]/a[5]/span"));
		*/
		WebElement dataset = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[1]/main/div[1]/section/div[1]/a[5]/span")));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
		try {
			Thread.sleep(600);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TakeScreenshot.takeScreenShot(driver, screenshotPath + "4");
		dataset.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		// Open any dataset (Assuming it's the first dataset in this example)
		/*
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[1]/main/div[2]/main/section/ul/article[1]/div/div/div/div/div[1]/a[1]")));
		WebElement datasetDownloadZip = driver.findElement(
				By.xpath("/html/body/div[1]/main/div[2]/main/section/ul/article[1]/div/div/div/div/div[1]/a[1]"));
		*/
		WebElement datasetDownloadZip = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[1]/main/div[2]/main/section/ul/article[1]/div/div/div/div/div[1]/a[1]")));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
		datasetDownloadZip.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.quit();//close the browser

	}
}
