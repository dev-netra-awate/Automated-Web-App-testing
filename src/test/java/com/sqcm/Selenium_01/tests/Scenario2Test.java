package com.sqcm.Selenium_01.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sqcm.Selenium_01.utils.DriverManager;
import com.sqcm.Selenium_01.utils.TakeScreenshot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class Scenario2Test {
    WebDriver driver;

    public static void addEvent(WebDriver driver, String title, String date, String details, String time
    ) {

        WebElement titleInput = driver.findElement(By.id("planner_note_title"));
        WebElement dateInput = driver.findElement(By.id("planner_note_date"));
        WebElement timeInput = driver.findElement(By.id("planner_note_time"));

        WebElement detailsInput = driver.findElement(By.id("details_textarea"));

        titleInput.sendKeys(title);
        dateInput.click();
        dateInput.clear();
        dateInput.sendKeys(date);

        detailsInput.sendKeys(details);
        timeInput.sendKeys(time);


    }

    @Test(testName = "Add two To-Do tasks for yourself")
    public void scenario2() throws IOException, InterruptedException {    	
    	//Initialize the driver and also wait
    	DriverManager driverManager = new DriverManager();
    	WebDriver driver = driverManager.getDriver();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    			
    	//declare values of login credentials and screenshots path
    	String email = System.getenv("email");
		String userId = System.getenv("userId");
		String password = System.getenv("password");
    	String screenshotPath = "ScenarioTwo/";

        //Navigate to the website
    	driver.get("https://northeastern.instructure.com");
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
    	
    	

    	
        
        
        
        
        
        
        
        
        
        // Calender actions
        WebElement calendar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='global_nav_calendar_link']")));
        try {
    		Thread.sleep(500);
    	} catch (InterruptedException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	TakeScreenshot.takeScreenShot(driver, screenshotPath + "6");
        calendar.click();
        try {
    		Thread.sleep(500);
    	} catch (InterruptedException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	TakeScreenshot.takeScreenShot(driver, screenshotPath + "7");

        //read csv
        String eventsCSVPath = "src/test/resources/events.csv";
        String delimiter = ",";
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(eventsCSVPath))) {
            int step = 0;
            while ((line = br.readLine()) != null) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_new_event_link"))).click();
                WebElement todoTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"edit_event_tabs\"]/ul/li[2]")));
                todoTab.click();
                String[] row = line.split(delimiter);
                String title = row[0];
                String time = row[1];
                String date = row[2];
                String details = row[3];
                addEvent(driver, title, date, details, time);
                int a = 7+step+step;
                int b = 8+step+step;
                TakeScreenshot.takeScreenShot(driver, screenshotPath + a);
                step++;

                //submit
                WebElement submit = driver.findElement(By.xpath("//*[@id=\"edit_planner_note_form_holder\"]/form/div[2]/button"));
                try {
        			Thread.sleep(2000);
        		} catch (InterruptedException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                submit.click();
                try {
        			Thread.sleep(2000);
        		} catch (InterruptedException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                TakeScreenshot.takeScreenShot(driver, screenshotPath + b);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();

        }
    }
}
