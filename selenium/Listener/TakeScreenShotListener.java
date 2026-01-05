package Listener;

import TestNG.Topic_13_Listener;
import org.dataloader.Try;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TakeScreenShotListener implements ITestListener {
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        Object testClass = result.getInstance();
        WebDriver driver = ((Topic_13_Listener) testClass).getDriver();

        String screenshotPath = captureScreenshot(driver, result.getName());
    }

    public String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

            // Chụp ảnh
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Folder lưu ảnh
            String folderPath = System.getProperty("user.dir") + "\\screenshots\\";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Đường dẫn file cuối cùng
            String screenPath = folderPath + screenshotName + "-" + formatter.format(calendar.getTime()) + ".png";

            // Copy file vào folder
            File dest = new File(screenPath);
            org.openqa.selenium.io.FileHandler.copy(source, dest);

            return screenPath;

        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestStart(ITestResult result) {
    }
}
