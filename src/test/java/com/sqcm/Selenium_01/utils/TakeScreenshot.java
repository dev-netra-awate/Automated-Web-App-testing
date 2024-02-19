package com.sqcm.Selenium_01.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	public static void takeScreenShot(WebDriver driver, String fileName) {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File(".\\screenshots\\" + fileName + ".png"));
        } catch (IOException e)
        {
            System.out.println(e.getMessage());

        }
	}
}
